package org.hbird.transport.xtce;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.exolab.castor.xml.XMLContext;
import org.hbird.transport.generatedcode.xtce.BaseDataTypeChoice;
import org.hbird.transport.generatedcode.xtce.Comparison;
import org.hbird.transport.generatedcode.xtce.IntegerParameterType;
import org.hbird.transport.generatedcode.xtce.ParameterSetTypeItem;
import org.hbird.transport.generatedcode.xtce.ParameterTypeSetTypeItem;
import org.hbird.transport.generatedcode.xtce.SequenceContainer;
import org.hbird.transport.generatedcode.xtce.SpaceSystem;
import org.hbird.transport.generatedcode.xtce.types.DataEncodingTypeBitOrderType;
import org.hbird.transport.spacesystemmodel.Container;
import org.hbird.transport.spacesystemmodel.ContainerFactory;
import org.hbird.transport.spacesystemmodel.ContainerImpl;
import org.hbird.transport.spacesystemmodel.Unit;
import org.hbird.transport.spacesystemmodel.exceptions.InvalidParameterTypeException;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownContainerNameException;
import org.hbird.transport.spacesystemmodel.parameters.FloatParameter;
import org.hbird.transport.spacesystemmodel.parameters.IntegerParameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.hbird.transport.spacesystemmodel.parameters.ParameterContainer;
import org.hbird.transport.spacesystemmodel.parameters.behaviours.AbstractFloatBehaviour;
import org.hbird.transport.spacesystemmodel.parameters.behaviours.AbstractIntegerBehaviour;
import org.hbird.transport.spacesystemmodel.parameters.behaviours.Float32Behaviour;
import org.hbird.transport.spacesystemmodel.parameters.behaviours.Float64Behaviour;
import org.hbird.transport.spacesystemmodel.parameters.behaviours.IntegerSignedBehaviour;
import org.hbird.transport.spacesystemmodel.parameters.behaviours.IntegerUnsignedBehaviour;
import org.hbird.transport.spacesystemmodel.parameters.behaviours.LongSignedBehaviour;
import org.hbird.transport.spacesystemmodel.parameters.behaviours.NumberParameterTypeBehaviour;
import org.hbird.transport.spacesystemmodel.parameters.types.NumberParameterType;
import org.hbird.transport.xtce.exceptions.InvalidXtceFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Gert Villemos
 * 
 */
public class XtceModelFactory implements ContainerFactory {

	private static final Logger LOG = LoggerFactory.getLogger(XtceModelFactory.class);

	protected Map<String, Unit> units = new HashMap<String, Unit>();
	protected Map<String, NumberParameterType> types = new HashMap<String, NumberParameterType>();
	protected Map<String, Container> containers = new HashMap<String, Container>();
	protected Map<String, ParameterContainer> parameters = new HashMap<String, ParameterContainer>();
	protected Map<Parameter, List<String>> restrictions = new HashMap<Parameter, List<String>>();

	protected SpaceSystem spaceSystem = null;

	protected String packetBaseReference = "TMPacket";
	protected String frameBaseReference = "TMFrame";

	protected String spacesystemmodelFilename;

	public XtceModelFactory(final String spacesystemmodelFilename) throws InvalidXtceFileException {
		this.spacesystemmodelFilename = spacesystemmodelFilename;
		try {
			initialise();
		}
		catch (final InvalidParameterTypeException e) {
			final String message = "Error in SpaceSystemModel file: " + spacesystemmodelFilename + ".";
			LOG.error(message + " " + e.getMessage());
			throw new InvalidXtceFileException(message, e);
		}
	}

	@Override
	public ParameterContainer getParameter(final String name) {
		return parameters.get(name);
	}

	@Override
	public Container getContainer(final String name) throws UnknownContainerNameException {
		final Container container = containers.get(name);

		if (container == null) {
			throw new UnknownContainerNameException(containers, "Your container lookup for '" + name
					+ "' did not return any containers. Check your SpaceSystem configuration.");
		}

		return container;
	}

	private final void initialise() throws InvalidParameterTypeException, InvalidXtceFileException {
		// Create the space system
		spaceSystem = getSpaceSystem();

		// Create all parameter types and store them in the types field.
		createAllParameterTypes();

		// Create all parameters.
		createAllParameters();

		/**
		 * Create all containers. In this iteration we create the container models, but do not create the references
		 * between them as the referenced objects do not yet exit. The creation of the references is done in the second
		 * iteration below.
		 */
		final int containerSetTypeItemCount = spaceSystem.getTelemetryMetaData().getContainerSet().getContainerSetTypeItemCount();

		for (int containerIndex = 0; containerIndex < containerSetTypeItemCount; ++containerIndex) {
			final SequenceContainer xtceContainer = spaceSystem.getTelemetryMetaData().getContainerSet().getContainerSetTypeItem(containerIndex)
			.getSequenceContainer();

			LOG.debug("Creating container " + xtceContainer.getName());
			final ContainerImpl container = new ContainerImpl(xtceContainer.getName(), xtceContainer.getShortDescription(), xtceContainer.getLongDescription());
			containers.put(container.getName(), container);
		}

		/**
		 * Reiterate through the containers and set the references between the objects. Three types of references exist;
		 * 1. Base. A container may have a base container. 2. Sub containers. 3. Restrictions.
		 */
		for (int containerIndex = 0; containerIndex < containerSetTypeItemCount; ++containerIndex) {
			final SequenceContainer xtceContainer = spaceSystem.getTelemetryMetaData().getContainerSet().getContainerSetTypeItem(containerIndex)
			.getSequenceContainer();

			// Get the container
			final Container thisContainer = containers.get(xtceContainer.getName());

			// Register this container with the base container to make sure it gets processed.
			if (xtceContainer.getBaseContainer() != null) {
				for (final Comparison comparison : xtceContainer.getBaseContainer().getRestrictionCriteria().getComparisonList().getComparison()) {
					final ParameterContainer paramContainer = (ParameterContainer) containers.get(comparison.getParameterRef());
					final String comparisonValue = comparison.getValue();
					addRestrictionToGlobalMap(paramContainer, comparisonValue);
					thisContainer.addRestriction(paramContainer, comparisonValue);
				}

				final String containerParentRef = xtceContainer.getBaseContainer().getContainerRef();
				final Container parentContainer = containers.get(containerParentRef);
				parentContainer.addContainer(thisContainer);
				thisContainer.addParent(parentContainer);

				LOG.debug("Added container " + thisContainer.getName() + " to parent (base) container " + containerParentRef);
			}

			/** Register all sub containers. */
			for (int subContainerIndex = 0; subContainerIndex < xtceContainer.getEntryList().getEntryListTypeItemCount(); ++subContainerIndex) {
				String name = null;
				if (xtceContainer.getEntryList().getEntryListTypeItem(subContainerIndex).getParameterRefEntry() != null) {
					name = xtceContainer.getEntryList().getEntryListTypeItem(subContainerIndex).getParameterRefEntry().getParameterRef();
				}
				else if (xtceContainer.getEntryList().getEntryListTypeItem(subContainerIndex).getContainerRefEntry() != null) {
					name = xtceContainer.getEntryList().getEntryListTypeItem(subContainerIndex).getContainerRefEntry().getContainerRef();
				}

				final Container subcontainer = containers.get(name);
				if (subcontainer != null) {
					thisContainer.addContainer(subcontainer);
					subcontainer.addParent(thisContainer);
					LOG.debug("Added subcontainer " + subcontainer + " to container " + thisContainer.getName());
				}
			}
		}
	}

	/**
	 * 
	 * @throws InvalidParameterTypeException
	 */
	private void createAllParameters() throws InvalidParameterTypeException {
		for (int parameterIndex = 0; parameterIndex < spaceSystem.getTelemetryMetaData().getParameterSet().getParameterSetTypeItemCount(); ++parameterIndex) {
			final ParameterSetTypeItem item = spaceSystem.getTelemetryMetaData().getParameterSet().getParameterSetTypeItem(parameterIndex);

			LOG.debug(item.getParameter().getName());

			ParameterContainer parameterContainer = null;
			final NumberParameterType type = types.get(item.getParameter().getParameterTypeRef());

			// @formatter:off
			if (type != null) {
				if (type.getNumberBehaviour() instanceof AbstractIntegerBehaviour) {
					parameterContainer = new IntegerParameter(
							item.getParameter().getName(),
							item.getParameter().getShortDescription(),
							item.getParameter().getLongDescription(),
							type,
							(int) type.getInitialValue());
				}
				else if (type.getNumberBehaviour() instanceof AbstractFloatBehaviour) {
					parameterContainer = new FloatParameter(
							item.getParameter().getName(),
							item.getParameter().getShortDescription(),
							item.getParameter().getLongDescription(),
							type,
							(int) type.getInitialValue());
				}
			}
			// @formatter:on

			parameters.put(parameterContainer.getName(), parameterContainer);
			containers.put(parameterContainer.getName(), parameterContainer);
		}
	}

	/**
	 * @throws InvalidParameterTypeException
	 * @throws InvalidXtceFileException
	 */
	private void createAllParameterTypes() throws InvalidParameterTypeException, InvalidXtceFileException {
		for (int parameterTypeIndex = 0; parameterTypeIndex < spaceSystem.getTelemetryMetaData().getParameterTypeSet().getParameterTypeSetTypeItemCount(); ++parameterTypeIndex) {
			final ParameterTypeSetTypeItem item = spaceSystem.getTelemetryMetaData().getParameterTypeSet().getParameterTypeSetTypeItem(parameterTypeIndex);

			// If it's an integer parameter..
			final IntegerParameterType integerParameterType = item.getIntegerParameterType();
			if (integerParameterType != null) {
				Unit unit = null;

				// Read in the unit of the parameter type.
				//@formatter:off
				if (integerParameterType.getUnitSet() != null) {
					for (int unitTypeIndex = 0; unitTypeIndex < integerParameterType.getUnitSet().getUnitCount(); ++unitTypeIndex) {
						final org.hbird.transport.generatedcode.xtce.Unit parameterTypeUnit = integerParameterType.getUnitSet().getUnit(unitTypeIndex);
						unit = units.get(parameterTypeUnit.getContent());
						if (unit == null) {
							unit = new Unit(
									parameterTypeUnit.getContent(),
									parameterTypeUnit.getDescription(),
									parameterTypeUnit.getDescription(),
									parameterTypeUnit.getPower(),
									parameterTypeUnit.getFactor());

							units.put(parameterTypeUnit.getContent(), unit);
						}
					}
				}


				boolean bigEndian;
				final BaseDataTypeChoice baseDataTypeChoice = integerParameterType.getBaseDataTypeChoice();
				if(baseDataTypeChoice == null) {
					bigEndian = true;
				}
				else {
					final DataEncodingTypeBitOrderType bitOrder = baseDataTypeChoice.getBinaryDataEncoding().getBitOrder();
					if (bitOrder == DataEncodingTypeBitOrderType.MOSTSIGNIFICANTBITFIRST) {
						bigEndian = true;
					}
					else if (bitOrder == DataEncodingTypeBitOrderType.LEASTSIGNIFICANTBITFIRST) {
						bigEndian = false;
					}
					else {
						throw new InvalidXtceFileException(integerParameterType.getName() +
								" is has an undefined bit order. ParameterType's BinaryDataEncoding " +
								"bitOrder must be either " +
								DataEncodingTypeBitOrderType.MOSTSIGNIFICANTBITFIRST +
								" or " + DataEncodingTypeBitOrderType.LEASTSIGNIFICANTBITFIRST);
					}
				}
				//@formatter:on

				/*
				 * TITLE XTCE Empty (null) Initial Value If the XTCE definition doesn't contain a default value, then
				 * the parameter gets the initial value of '0'. CATEGORY XTCE FAQ
				 */
				final String initialValueAsString = integerParameterType.getInitialValue();

				long initialValue = 0;

				if (initialValueAsString != null) {
					initialValue = Long.decode(initialValueAsString);
					// FIXME decode() will ONLY work with base10 and hex, NOT with octal (wrong representation) and not
					// with binary.
				}

				// FIXME Add more logic to cater for multiple integer behaviours.
				NumberParameterTypeBehaviour numberTypeBehaviour = null;

				// If parameter is less than 64 (i.e. an integers type...
				if (integerParameterType.getSizeInBits() < 64) {
					if (!integerParameterType.getSigned()) {
						numberTypeBehaviour = new IntegerUnsignedBehaviour((int) integerParameterType.getSizeInBits(), bigEndian);
					}
					else {
						numberTypeBehaviour = new IntegerSignedBehaviour((int) integerParameterType.getSizeInBits(), bigEndian);
					}
				}
				// else we are dealing with a long
				else {
					numberTypeBehaviour = new LongSignedBehaviour((int) integerParameterType.getSizeInBits(), bigEndian);
				}

				// else {
				// LOG.error("Not enough information to construct the behaviour type");
				// }
				final NumberParameterType type = new NumberParameterType(integerParameterType.getName(), integerParameterType.getShortDescription(),
						integerParameterType.getLongDescription(), numberTypeBehaviour, initialValue);

				types.put(type.getName(), type);
			}

			// If it is a float parameter...
			else if (item.getFloatParameterType() != null) {
				Unit unit = null;

				// Read in the unit of the parameter type
				if (item.getFloatParameterType().getUnitSet() != null) {
					for (int unitTypeIndex = 0; unitTypeIndex < item.getFloatParameterType().getUnitSet().getUnitCount(); ++unitTypeIndex) {
						unit = units.get(item.getFloatParameterType().getUnitSet().getUnit(unitTypeIndex).getContent());
						if (unit == null) {
							unit = new Unit(item.getFloatParameterType().getUnitSet().getUnit(unitTypeIndex).getContent(), item.getFloatParameterType()
									.getUnitSet().getUnit(unitTypeIndex).getDescription(), item.getFloatParameterType().getUnitSet().getUnit(unitTypeIndex)
									.getDescription(), item.getFloatParameterType().getUnitSet().getUnit(unitTypeIndex).getPower(), item
									.getFloatParameterType().getUnitSet().getUnit(unitTypeIndex).getFactor());

							units.put(item.getFloatParameterType().getUnitSet().getUnit(unitTypeIndex).getContent(), unit);
						}
					}
				}

				NumberParameterType type = null;
				final long size = Long.parseLong(item.getFloatParameterType().getSizeInBits().value());
				if (size == 32) {
					type = new NumberParameterType(item.getFloatParameterType().getName(), item.getFloatParameterType().getShortDescription(), item
							.getFloatParameterType().getLongDescription(), new Float32Behaviour(), (long) item.getFloatParameterType().getInitialValue());
				}
				else if (size == 64) {
					type = new NumberParameterType(item.getFloatParameterType().getName(), item.getFloatParameterType().getShortDescription(), item
							.getFloatParameterType().getLongDescription(), new Float64Behaviour(), (long) item.getFloatParameterType().getInitialValue());
				}
				else {
					throw new InvalidXtceFileException(
					"Invalid float type Parameter definition.  Hummingbird only supports size 32 or 64 bit big endian floats");
				}

				types.put(type.getName(), type);
			}
		}
	}

	private void addRestrictionToGlobalMap(final ParameterContainer paramContainer, final String comparisonValue) {
		List<String> pList;
		if (restrictions.containsKey(paramContainer)) {
			pList = restrictions.get(paramContainer);
			pList.add(comparisonValue);
		}
		else {
			pList = new ArrayList<String>();
			pList.add(comparisonValue);
			restrictions.put(paramContainer, pList);
		}
	}

	/**
	 * If the space system is not already created this method unmarshalls the XTCE definition and creates the space
	 * system model.
	 * 
	 * @return
	 */
	public final SpaceSystem getSpaceSystem() {
		if (spaceSystem == null) {

			try {
				// Load Mapping
				// Mapping mapping = new Mapping();

				// mapping.loadMapping(mappingFilename);
				// initialize and configure XMLContext

				final XMLContext context = new XMLContext();
				// context.addMapping(mapping);

				// Create a new Unmarshaller
				final Unmarshaller unmarshaller = context.createUnmarshaller();
				unmarshaller.setClass(SpaceSystem.class);

				// Unmarshal the space system object
				spaceSystem = (SpaceSystem) unmarshaller.unmarshal(new FileReader(spacesystemmodelFilename));
			}
			catch (final IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (final MarshalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (final ValidationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return spaceSystem;
	}

	public String getPacketBaseReference() {
		return packetBaseReference;
	}

	public void setPacketBaseReference(final String packetBaseReference) {
		this.packetBaseReference = packetBaseReference;
	}

	public String getFrameBaseReference() {
		return frameBaseReference;
	}

	public void setFrameBaseReference(final String frameBaseReference) {
		this.frameBaseReference = frameBaseReference;
	}

	public String getSpacesystemmodelFilename() {
		return spacesystemmodelFilename;
	}

	public void setSpacesystemmodelFilename(final String spacesystemmodelFilename) {
		this.spacesystemmodelFilename = spacesystemmodelFilename;
	}

	@Override
	public Map<String, ParameterContainer> getAllParameters() {
		return parameters;
	}

	@Override
	public String getSpaceSystemModelFilePath() {
		return this.spacesystemmodelFilename;
	}

	@Override
	public Map<Parameter, List<String>> getAllParameterRestrictions() {
		return restrictions;
	}

	@Override
	public Collection<Container> getAllContainers() {
		return containers.values();
	}
}