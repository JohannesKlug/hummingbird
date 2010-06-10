package com.logica.hummingbird.xtce;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.exolab.castor.xml.XMLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.generatedcode.xtce.Comparison;
import com.logica.hummingbird.generatedcode.xtce.ParameterSetTypeItem;
import com.logica.hummingbird.generatedcode.xtce.ParameterTypeSetTypeItem;
import com.logica.hummingbird.generatedcode.xtce.SequenceContainer;
import com.logica.hummingbird.generatedcode.xtce.SpaceSystem;
import com.logica.hummingbird.spacesystemmodel.ContainerFactory;
import com.logica.hummingbird.spacesystemmodel.ContainerImpl;
import com.logica.hummingbird.spacesystemmodel.Unit;
import com.logica.hummingbird.spacesystemmodel.exceptions.InvalidParameterTypeException;
import com.logica.hummingbird.spacesystemmodel.exceptions.UnknownContainerNameException;
import com.logica.hummingbird.spacesystemmodel.parameters.FloatParameter;
import com.logica.hummingbird.spacesystemmodel.parameters.IntegerParameter;
import com.logica.hummingbird.spacesystemmodel.parameters.ParameterImpl;
import com.logica.hummingbird.spacesystemmodel.parameters.ParameterType;
import com.logica.hummingbird.xtce.exceptions.InvalidXtceFileException;

/**
 * 
 * @author Gert Villemos
 *
 */
public class XtceModelFactory implements ContainerFactory {
	
	private static final Logger LOG = LoggerFactory.getLogger(XtceModelFactory.class);

	protected Map<String, Unit> units = new HashMap<String, Unit>();
	protected Map<String, ParameterType> types = new HashMap<String, ParameterType>();
	protected Map<String, ContainerImpl> containers = new HashMap<String, ContainerImpl>();
	protected Map<String, ParameterImpl> parameters = new HashMap<String, ParameterImpl>();

	protected SpaceSystem spaceSystem = null;

	protected String packetBaseReference = "TMPacket";
	protected String frameBaseReference = "TMFrame";

	protected String spacesystemmodelFilename = "src/main/resources/humsat.xml";

	public XtceModelFactory(String spacesystemmodelFilename) throws InvalidXtceFileException {
		this.spacesystemmodelFilename = spacesystemmodelFilename;
		try {
			initialise();
		}
		catch (InvalidParameterTypeException e) {
			String message = "Error in SpaceSystemModel file: " + spacesystemmodelFilename + "." ;
			LOG.error(message + " " + e.getMessage());
			throw new InvalidXtceFileException(message, e);
		}
	}

	public ParameterImpl getParameter(String name) {
		return parameters.get(name);
	}

	public ContainerImpl getContainer(String name) throws UnknownContainerNameException {
		ContainerImpl container = containers.get(name);
		
		if (container == null) {
			throw new UnknownContainerNameException(containers, "Your container lookup for '" + name + "' did not return any containers. Check your SpaceSystem configuration.");
		}
		
		return container;
	}

	private void initialise() throws InvalidParameterTypeException {

		spaceSystem = getSpaceSystem();

		/** Create all parameter types. */
		for (int parameterTypeIndex = 0; parameterTypeIndex < spaceSystem.getTelemetryMetaData().getParameterTypeSet().getParameterTypeSetTypeItemCount(); ++parameterTypeIndex) {
			ParameterTypeSetTypeItem item = spaceSystem.getTelemetryMetaData().getParameterTypeSet().getParameterTypeSetTypeItem(parameterTypeIndex);


			/** INTEGER */
			if (item.getIntegerParameterType() != null) {
				Unit unit = null;				

				/** Read in the unit of the parameter type. */
				if (item.getIntegerParameterType().getUnitSet() != null) {
					for (int unitTypeIndex = 0; unitTypeIndex < item.getIntegerParameterType().getUnitSet().getUnitCount(); ++unitTypeIndex) {
						unit = units.get(item.getIntegerParameterType().getUnitSet().getUnit(unitTypeIndex).getContent());
						if (unit == null) {
							unit = new Unit(
									item.getIntegerParameterType().getUnitSet().getUnit(unitTypeIndex).getContent(),
									item.getIntegerParameterType().getUnitSet().getUnit(unitTypeIndex).getDescription(),
									item.getIntegerParameterType().getUnitSet().getUnit(unitTypeIndex).getDescription(),
									item.getIntegerParameterType().getUnitSet().getUnit(unitTypeIndex).getPower(),
									item.getIntegerParameterType().getUnitSet().getUnit(unitTypeIndex).getFactor());

							units.put(item.getIntegerParameterType().getUnitSet().getUnit(unitTypeIndex).getContent(), unit);
						}
					}
				}

				/** TITLE XTCE Empty (null) Initial Value
				 * If the XTCE definition doesn't contain a default value, then the parameter gets the initial value of '0'. 
				 * CATEGORY XTCE FAQ */
				
				String initialValueAsString = item.getIntegerParameterType().getInitialValue();
				
				long initialValue = 0;
				
				if (initialValueAsString != null) {
					initialValue = Long.decode(initialValueAsString);
					// FIXME decode() will ONLY work with base10 and hex, NOT with octal (wrong representation) and not with binary.
				}
				
				
				ParameterType type = new ParameterType(					
						item.getIntegerParameterType().getName(),
						item.getIntegerParameterType().getShortDescription(),
						item.getIntegerParameterType().getLongDescription(),
						ParameterType.eParameterType.INTEGER,
						item.getIntegerParameterType().getSigned(),
						initialValue,				
						item.getIntegerParameterType().getSizeInBits());
				

				types.put(type.getName(), type);
			}

			/** FLOAT */
			else if (item.getFloatParameterType() != null) {
				Unit unit = null;

				/** Read in the unit of the parameter type. */
				if (item.getFloatParameterType().getUnitSet() != null) {
					for (int unitTypeIndex = 0; unitTypeIndex < item.getFloatParameterType().getUnitSet().getUnitCount(); ++unitTypeIndex) {
						unit = units.get(item.getFloatParameterType().getUnitSet().getUnit(unitTypeIndex).getContent());
						if (unit == null) {
							unit = new Unit(
									item.getFloatParameterType().getUnitSet().getUnit(unitTypeIndex).getContent(),
									item.getFloatParameterType().getUnitSet().getUnit(unitTypeIndex).getDescription(),
									item.getFloatParameterType().getUnitSet().getUnit(unitTypeIndex).getDescription(),
									item.getFloatParameterType().getUnitSet().getUnit(unitTypeIndex).getPower(),
									item.getFloatParameterType().getUnitSet().getUnit(unitTypeIndex).getFactor());

							units.put(item.getFloatParameterType().getUnitSet().getUnit(unitTypeIndex).getContent(), unit);
						}
					}
				}

				ParameterType type = new ParameterType(					
						item.getFloatParameterType().getName(),
						item.getFloatParameterType().getShortDescription(),
						item.getFloatParameterType().getLongDescription(),
						ParameterType.eParameterType.FLOAT,
						false,
						(long) item.getFloatParameterType().getInitialValue(),				
						Long.parseLong(item.getFloatParameterType().getSizeInBits().value()));

				types.put(type.getName(), type);
			}
		}

		/** Create all parameters. */
		for (int parameterIndex = 0; parameterIndex < spaceSystem.getTelemetryMetaData().getParameterSet().getParameterSetTypeItemCount(); ++parameterIndex) {
			ParameterSetTypeItem item = spaceSystem.getTelemetryMetaData().getParameterSet().getParameterSetTypeItem(parameterIndex);

			ParameterImpl model = null;
			ParameterType type = types.get(item.getParameter().getParameterTypeRef());
			if (type != null) {

				if (type.getType() == ParameterType.eParameterType.INTEGER) {
					model = new IntegerParameter(					
							item.getParameter().getName(),
							item.getParameter().getShortDescription(),
							item.getParameter().getLongDescription(),
							type,
							(int) type.getInitialValue());
				}
				else if (type.getType() == ParameterType.eParameterType.FLOAT) {
					model = new FloatParameter(					
							item.getParameter().getName(),
							item.getParameter().getShortDescription(),
							item.getParameter().getLongDescription(),
							type,
							(int) type.getInitialValue());	
				}
			}

			parameters.put(model.getName(), model);
			containers.put(model.getName(), model);
		}

		/** Create all containers. 
		 * In this iteration we create the container models, but do not create the references between 
		 * them as the referenced objects do not yet exit. The creation of the references is done in
		 * the second iteration below. */
		for (int containerIndex = 0; containerIndex < spaceSystem.getTelemetryMetaData().getContainerSet().getContainerSetTypeItemCount(); ++containerIndex) {
			SequenceContainer xtceContainer = spaceSystem.getTelemetryMetaData().getContainerSet().getContainerSetTypeItem(containerIndex).getSequenceContainer();

			ContainerImpl container = new ContainerImpl(xtceContainer.getName(), xtceContainer.getShortDescription(), xtceContainer.getLongDescription());			
			containers.put(container.getName(), container);			
		}

		/** Reiterate through the containers and set the references between the objects. 
		 * Three types of references exist;
		 * 1. Base. A container may have a base container. 
		 * 2. Sub containers.
		 * 3. Restrictions. */
		for (int containerIndex = 0; containerIndex < spaceSystem.getTelemetryMetaData().getContainerSet().getContainerSetTypeItemCount(); ++containerIndex) {
			SequenceContainer xtceContainer = spaceSystem.getTelemetryMetaData().getContainerSet().getContainerSetTypeItem(containerIndex).getSequenceContainer();

			ContainerImpl thisContainer = containers.get(xtceContainer.getName());

			/** Register this container with the base container to make sure it gets processed. */
			if (xtceContainer.getBaseContainer() != null) {				
				for (Comparison comparison : xtceContainer.getBaseContainer().getRestrictionCriteria().getComparisonList().getComparison()) {
					thisContainer.addRestriction((ParameterImpl) containers.get(comparison.getParameterRef()), comparison.getValue());
				}

				containers.get(xtceContainer.getBaseContainer().getContainerRef()).addContainer(thisContainer);
			}

			/** Register all sub containers. */
			for (int subContainerIndex = 0; subContainerIndex < xtceContainer.getEntryList().getEntryListTypeItemCount(); ++subContainerIndex) {
				String name = "";
				if (xtceContainer.getEntryList().getEntryListTypeItem(subContainerIndex).getParameterRefEntry() != null) {
					name = xtceContainer.getEntryList().getEntryListTypeItem(subContainerIndex).getParameterRefEntry().getParameterRef();
				}
				else if (xtceContainer.getEntryList().getEntryListTypeItem(subContainerIndex).getContainerRefEntry() != null) {
					name = xtceContainer.getEntryList().getEntryListTypeItem(subContainerIndex).getContainerRefEntry().getContainerRef();
				}
				
				thisContainer.addContainer(containers.get(name));
			}
		}
	}
	
	public SpaceSystem getSpaceSystem() {
		if (spaceSystem == null) {

			try {
				// Load Mapping
				// Mapping mapping = new Mapping();

				// mapping.loadMapping(mappingFilename);
				// initialize and configure XMLContext

				XMLContext context = new XMLContext();
				// context.addMapping(mapping);

				// Create a new Unmarshaller
				Unmarshaller unmarshaller = context.createUnmarshaller();
				unmarshaller.setClass(SpaceSystem.class);

				// Unmarshal the space system object
				spaceSystem = (SpaceSystem) unmarshaller.unmarshal(new FileReader(spacesystemmodelFilename));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MarshalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ValidationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return spaceSystem;
	}

	public String getPacketBaseReference() {
		return packetBaseReference;
	}

	public void setPacketBaseReference(String packetBaseReference) {
		this.packetBaseReference = packetBaseReference;
	}

	public String getFrameBaseReference() {
		return frameBaseReference;
	}

	public void setFrameBaseReference(String frameBaseReference) {
		this.frameBaseReference = frameBaseReference;
	}

	public String getSpacesystemmodelFilename() {
		return spacesystemmodelFilename;
	}

	public void setSpacesystemmodelFilename(String spacesystemmodelFilename) {
		this.spacesystemmodelFilename = spacesystemmodelFilename;
	}

	@Override
	public Map<String, ParameterImpl> getAllParameters() {
		return parameters;
	}	
}