package org.hbird.transport.xtce;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.exolab.castor.xml.XMLContext;
import org.hbird.transport.generatedcode.xtce.BaseDataType;
import org.hbird.transport.generatedcode.xtce.BaseDataTypeChoice;
import org.hbird.transport.generatedcode.xtce.Comparison;
import org.hbird.transport.generatedcode.xtce.FloatParameterType;
import org.hbird.transport.generatedcode.xtce.IntegerParameterType;
import org.hbird.transport.generatedcode.xtce.ParameterSetTypeItem;
import org.hbird.transport.generatedcode.xtce.ParameterTypeSetTypeItem;
import org.hbird.transport.generatedcode.xtce.SequenceContainer;
import org.hbird.transport.generatedcode.xtce.SpaceSystem;
import org.hbird.transport.generatedcode.xtce.types.DataEncodingTypeBitOrderType;
import org.hbird.transport.generatedcode.xtce.types.FloatDataEncodingTypeEncodingType;
import org.hbird.transport.generatedcode.xtce.types.IntegerDataEncodingTypeEncodingType;
import org.hbird.transport.spacesystemmodel.DefaultParameterGroup;
import org.hbird.transport.spacesystemmodel.ParameterGroup;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.exceptions.InvalidParameterTypeException;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.transport.spacesystemmodel.parameters.HummingbirdParameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter.Encoding;
import org.hbird.transport.spacesystemmodel.parameters.Parameter.Endianness;
import org.hbird.transport.xtce.exceptions.InvalidXtceFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Gert Villemos
 * @author Mark Doyle
 * @author Johannes Klug
 * 
 */
public class XtceSpaceSystemModel implements SpaceSystemModel {
	private static final Logger LOG = LoggerFactory.getLogger(XtceSpaceSystemModel.class);

	private final Map<String, ParameterGroup> parameterGroups = new HashMap<String, ParameterGroup>();
	private final Map<String, Parameter<?>> parameters = new HashMap<String, Parameter<?>>();
	private final Map<Parameter<?>, List<Object>> restrictions = new HashMap<Parameter<?>, List<Object>>();

	private final Map<String, ParameterTypeSetTypeItem> xtceParameterTypes = new HashMap<String, ParameterTypeSetTypeItem>();

	private SpaceSystem spaceSystem = null;

	private String packetBaseReference = "TMPacket";
	private String frameBaseReference = "TMFrame";

	private String spacesystemmodelFilename;

	private int numParameterGroups;

	public XtceSpaceSystemModel(final String spacesystemmodelFilename) throws InvalidXtceFileException {
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
	public Parameter<?> getParameter(final String name) {
		return parameters.get(name);
	}

	@Override
	public ParameterGroup getParameterGroup(final String name) throws UnknownParameterGroupException {
		final ParameterGroup container = parameterGroups.get(name);

		if (container == null) {
			throw new UnknownParameterGroupException(parameterGroups, "Your container lookup for '" + name
					+ "' did not return any containers. Check your SpaceSystem configuration.");
		}

		return container;
	}

	private final void initialise() throws InvalidParameterTypeException, InvalidXtceFileException {
		// Create the space system
		spaceSystem = getSpaceSystem();

		numParameterGroups = spaceSystem.getTelemetryMetaData().getContainerSet().getContainerSetTypeItemCount();

		// Create all parameter types and store them in the types field.
		createAllParameterTypes();

		// Create all parameters.
		createAllParameters();

		createAllParameterGroups();

		createModelConnections();
	}

	/**
	 * @throws InvalidParameterTypeException
	 * @throws InvalidXtceFileException
	 */
	private final void createAllParameterTypes() throws InvalidXtceFileException {
		int numberOfParameterTypes = spaceSystem.getTelemetryMetaData().getParameterTypeSet()
				.getParameterTypeSetTypeItemCount();

		for (int parameterTypeIndex = 0; parameterTypeIndex < numberOfParameterTypes; ++parameterTypeIndex) {
			final ParameterTypeSetTypeItem item = spaceSystem.getTelemetryMetaData().getParameterTypeSet()
					.getParameterTypeSetTypeItem(parameterTypeIndex);

			// If it's an integer parameter..
			final IntegerParameterType integerParameterType = item.getIntegerParameterType();
			if (integerParameterType != null) {
				xtceParameterTypes.put(integerParameterType.getName(), item);
			}
			// If it is a float parameter...
			else if (item.getFloatParameterType() != null) {
				xtceParameterTypes.put(item.getFloatParameterType().getName(), item);
			}
			// If it is a string parameter...
			else if (item.getStringParameterType() != null) {
				xtceParameterTypes.put(item.getStringParameterType().getName(), item);
			}
			// If it is a boolean parameter...
			else if (item.getBooleanParameterType() != null) {
				xtceParameterTypes.put(item.getBooleanParameterType().getName(), item);
			}
			else {
				throw new InvalidXtceFileException("Unknown parameter type: " + item);
			}
		}
	}

	/**
	 * 
	 * @throws InvalidParameterTypeException
	 * @throws InvalidXtceFileException
	 * @throws NumberFormatException
	 */
	private final void createAllParameters() throws InvalidParameterTypeException, NumberFormatException,
			InvalidXtceFileException {
		int numberOfParameters = spaceSystem.getTelemetryMetaData().getParameterSet().getParameterSetTypeItemCount();

		// @formatter:off
		for (int i = 0; i < numberOfParameters; ++i) {

			final ParameterSetTypeItem xtceParameter = spaceSystem.getTelemetryMetaData().getParameterSet()
					.getParameterSetTypeItem(i);

			String parameterTypeRef = xtceParameter.getParameter().getParameterTypeRef();
			ParameterTypeSetTypeItem xtceType = xtceParameterTypes.get(parameterTypeRef);

			Parameter<?> parameter = null;
			// If it's an integer type...
			if (xtceType.getIntegerParameterType() != null) {
				IntegerParameterType type = xtceType.getIntegerParameterType();
				if (!doesIntRequireJavaLong(type)) {
						parameter = new HummingbirdParameter<Integer>(
								xtceParameter.getParameter().getName(),
								xtceParameter.getParameter().getShortDescription(), 
								xtceParameter.getParameter().getLongDescription(),
								type.getSizeInBits(), 
								getEndianness(type), 
								getIntegerEncoding(type));
				}
				else {
						parameter = new HummingbirdParameter<Long>(
								xtceParameter.getParameter().getName(), 
								xtceParameter.getParameter().getShortDescription(), 
								xtceParameter.getParameter().getLongDescription(),
								type.getSizeInBits(), 
								getEndianness(type), 
								getIntegerEncoding(type));
				}
			}

			// If it's an float type...
			else if (xtceType.getFloatParameterType() != null) {
				FloatParameterType type = xtceType.getFloatParameterType();
				switch(type.getSizeInBits()) {
					case VALUE_32:
						parameter = new HummingbirdParameter<Float>(
								xtceParameter.getParameter().getName(), 
								xtceParameter.getParameter().getShortDescription(), 
								xtceParameter.getParameter().getLongDescription(),
								Long.parseLong(type.getSizeInBits().value()), 
								getEndianness(type),
								getFloatEncoding(type));
						break;
					case VALUE_64:
						parameter = new HummingbirdParameter<Double>(
								xtceParameter.getParameter().getName(), 
								xtceParameter.getParameter().getShortDescription(), 
								xtceParameter.getParameter().getLongDescription(),
								Long.parseLong(type.getSizeInBits().value()), 
								getEndianness(type),
								getFloatEncoding(type));
						break;
					case VALUE_128:
						parameter = new HummingbirdParameter<BigDecimal>(
								xtceParameter.getParameter().getName(), 
								xtceParameter.getParameter().getShortDescription(), 
								xtceParameter.getParameter().getLongDescription(),
								Long.parseLong(type.getSizeInBits().value()),
								getEndianness(type),
								getFloatEncoding(type));
						break;
					default:
						throw new InvalidXtceFileException("Invalid bit size for float type " + type.getName());
				}
			}
			// @formatter:on

			// FIXME Add support for other parameters and split off creation into a series of private methods.
			parameters.put(parameter.getName(), parameter);
		}
	}


	/**
	 * Create all ParameterGroups. In this iteration we create the parameter groups, but do not create the references
	 * between them as the referenced objects do not yet exit.
	 */
	private final void createAllParameterGroups() {
		for (int containerIndex = 0; containerIndex < numParameterGroups; ++containerIndex) {
			final SequenceContainer xtceContainer = spaceSystem.getTelemetryMetaData().getContainerSet()
					.getContainerSetTypeItem(containerIndex).getSequenceContainer();


			final ParameterGroup parameterGroup = new DefaultParameterGroup(xtceContainer.getName(),
					xtceContainer.getShortDescription(), xtceContainer.getLongDescription());

			parameterGroups.put(parameterGroup.getName(), parameterGroup);
			if (LOG.isDebugEnabled()) {
				LOG.debug("Created container " + xtceContainer.getName());
			}
		}
	}

	/**
	 * Reiterate through the parameterGroups and Parameters and set the connections between the objects. </br> Three
	 * types of references exist:
	 * <ol>
	 * <li></li>
	 * <li>Parent Child relationship - ParameterGroups can contain other ParameterGroups and/or Parameters.</li>
	 * <li>Restrictions</li>
	 * </ol>
	 */
	private final void createModelConnections() {
		for (int containerIndex = 0; containerIndex < numParameterGroups; ++containerIndex) {

			final SequenceContainer xtceSequenceContainer = spaceSystem.getTelemetryMetaData().getContainerSet()
					.getContainerSetTypeItem(containerIndex).getSequenceContainer();

			// Get the parameter group, in the space system model sequence containers are parameter groups
			final ParameterGroup parameterGroup = parameterGroups.get(xtceSequenceContainer.getName());

			// Register this container with the base container to make sure it gets processed.
			if (xtceSequenceContainer.getBaseContainer() != null) {
				Comparison[] restrictionCriteria = xtceSequenceContainer.getBaseContainer().getRestrictionCriteria()
						.getComparisonList().getComparison();
				for (final Comparison comparison : restrictionCriteria) {
					final Parameter<?> paramContainer = (Parameter<?>) parameterGroups.get(comparison.getParameterRef());
					final String comparisonValue = comparison.getValue();
					addRestrictionToGlobalMap(paramContainer, comparisonValue);
					parameterGroup.addRestriction(paramContainer, comparisonValue);
				}

				final String containerParentRef = xtceSequenceContainer.getBaseContainer().getContainerRef();
				final ParameterGroup parentContainer = parameterGroups.get(containerParentRef);
				parentContainer.addParameterGroup(parameterGroup);
				parameterGroup.addParentParameterGroup(parentContainer);

				if (LOG.isDebugEnabled()) {
					LOG.debug("Added container " + parameterGroup.getName() + " to parent (base) container "
							+ containerParentRef);
				}
			}

			// Register all sub containers.
			for (int subContainerIndex = 0; subContainerIndex < xtceSequenceContainer.getEntryList()
					.getEntryListTypeItemCount(); ++subContainerIndex) {
				String name = null;
				if (xtceSequenceContainer.getEntryList().getEntryListTypeItem(subContainerIndex).getParameterRefEntry() != null) {
					name = xtceSequenceContainer.getEntryList().getEntryListTypeItem(subContainerIndex)
							.getParameterRefEntry().getParameterRef();
				}
				else if (xtceSequenceContainer.getEntryList().getEntryListTypeItem(subContainerIndex).getContainerRefEntry() != null) {
					name = xtceSequenceContainer.getEntryList().getEntryListTypeItem(subContainerIndex)
							.getContainerRefEntry().getContainerRef();
				}

				final ParameterGroup subcontainer = parameterGroups.get(name);
				if (subcontainer != null) {
					parameterGroup.addParameterGroup(subcontainer);
					subcontainer.addParentParameterGroup(parameterGroup);

					if (LOG.isDebugEnabled()) {
						LOG.debug("Added subcontainer " + subcontainer + " to container " + parameterGroup.getName());
					}
				}
			}
		}
	}

	private final boolean doesIntRequireJavaLong(final IntegerParameterType type) {
		boolean longRequired = false;
		// If signed
		if (type.getSigned()) {
			if (type.getSizeInBits() > 32) {
				longRequired = true;
			}
		}
		// else if unsigned
		else {
			if (type.getSizeInBits() > 31) {
				longRequired = true;
			}
		}

		return longRequired;
	}

	private void addRestrictionToGlobalMap(final Parameter<?> restrictionParameter, final String comparisonValue) {
		List<Object> pList;
		if (restrictions.containsKey(restrictionParameter)) {
			pList = restrictions.get(restrictionParameter);
			pList.add(comparisonValue);
		}
		else {
			pList = new ArrayList<Object>();
			pList.add(comparisonValue);
			restrictions.put(restrictionParameter, pList);
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
				final XMLContext context = new XMLContext();

				// Create a new Unmarshaller
				final Unmarshaller unmarshaller = context.createUnmarshaller();
				unmarshaller.setClass(SpaceSystem.class);

				// Unmarshal the space system object
				spaceSystem = (SpaceSystem) unmarshaller.unmarshal(new FileReader(spacesystemmodelFilename));
			}
			catch (final IOException e) {
				LOG.error(e.toString());
			}
			catch (final MarshalException e) {
				LOG.error(e.toString());
			}
			catch (final ValidationException e) {
				LOG.error(e.toString());
			}
		}

		return spaceSystem;
	}

	private final Encoding getIntegerEncoding(final IntegerParameterType intParamType) throws InvalidXtceFileException {
		BaseDataTypeChoice baseDataTypeChoice = intParamType.getBaseDataTypeChoice();
		if (baseDataTypeChoice == null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("Base data type does not have a base data type choice, assuming default of unsigned integer encoding");
			}
			return Encoding.unsigned;
		}
		IntegerDataEncodingTypeEncodingType xtceEncoding = baseDataTypeChoice.getIntegerDataEncoding().getEncoding();
		switch (xtceEncoding) {
			case UNSIGNED:
				return Encoding.unsigned;
			case TWOSCOMPLIMENT:
				return Encoding.twosComplement;
			case BCD:
				return Encoding.binaryCodedDecimal;
			case ONESCOMPLIMENT:
				return Encoding.onesComplement;
			case SIGNMAGNITUDE:
				return Encoding.signMagnitude;
			case PACKEDBCD:
				return Encoding.packedBinaryCodedDecimal;
			default:
				throw new InvalidXtceFileException("Invalid integer encoding in type " + intParamType);
		}
	}

	private final Encoding getFloatEncoding(final FloatParameterType type) throws InvalidXtceFileException {
		BaseDataTypeChoice baseDataTypeChoice = type.getBaseDataTypeChoice();
		if (baseDataTypeChoice == null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("Base data type does not have a base data type choice, assuming default of IEEE754_1985 float encoding");
			}
			return Encoding.IEEE754_1985;
		}
		FloatDataEncodingTypeEncodingType xtceEncoding = baseDataTypeChoice.getFloatDataEncoding().getEncoding();

		switch (xtceEncoding) {
			case IEEE754_1985:
				return Encoding.IEEE754_1985;
			case MILSTD_1750A:
				return Encoding.MILSTD_1750A;
			default:
				throw new InvalidXtceFileException("Invalid float encoding in type " + type);
		}
	}

	private final Endianness getEndianness(final BaseDataType type) throws InvalidXtceFileException {
		BaseDataTypeChoice baseDataTypeChoice = type.getBaseDataTypeChoice();
		if (baseDataTypeChoice == null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("Base data type does not have a base data type choice, assuming default of BIG endian");
			}
			return Endianness.BIG;
		}
		DataEncodingTypeBitOrderType byteOrder = baseDataTypeChoice.getIntegerDataEncoding().getBitOrder();
		switch (byteOrder) {
			case MOSTSIGNIFICANTBITFIRST:
				return Endianness.BIG;
			case LEASTSIGNIFICANTBITFIRST:
				return Endianness.LITTLE;
			default:
				throw new InvalidXtceFileException("Invalid bit order in " + type);
		}
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
	public Map<String, Parameter<?>> getAllParameters() {
		return parameters;
	}

	public String getSpaceSystemModelFilePath() {
		return this.spacesystemmodelFilename;
	}

	@Override
	public Map<Parameter<?>, List<Object>> getAllParameterRestrictions() {
		return restrictions;
	}

	@Override
	public Collection<ParameterGroup> getAllParameterGroups() {
		return parameterGroups.values();
	}

}