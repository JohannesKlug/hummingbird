package org.hbird.transport.xtce; // Hi Mark.

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.exolab.castor.xml.XMLContext;
import org.hbird.transport.generatedcode.xtce.BaseContainer;
import org.hbird.transport.generatedcode.xtce.BaseDataTypeChoice;
import org.hbird.transport.generatedcode.xtce.Comparison;
import org.hbird.transport.generatedcode.xtce.ComparisonList;
import org.hbird.transport.generatedcode.xtce.ContainerSet;
import org.hbird.transport.generatedcode.xtce.EntryList;
import org.hbird.transport.generatedcode.xtce.FloatParameterType;
import org.hbird.transport.generatedcode.xtce.IntegerParameterType;
import org.hbird.transport.generatedcode.xtce.ParameterSetTypeItem;
import org.hbird.transport.generatedcode.xtce.ParameterTypeSetTypeItem;
import org.hbird.transport.generatedcode.xtce.SequenceContainer;
import org.hbird.transport.generatedcode.xtce.SpaceSystem;
import org.hbird.transport.generatedcode.xtce.TelemetryMetaData;
import org.hbird.transport.generatedcode.xtce.types.FloatDataEncodingTypeEncodingType;
import org.hbird.transport.generatedcode.xtce.types.IntegerDataEncodingTypeEncodingType;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.encoding.Encoding;
import org.hbird.transport.spacesystemmodel.encoding.Encoding.BinaryRepresentation;
import org.hbird.transport.spacesystemmodel.exceptions.InvalidParameterTypeException;
import org.hbird.transport.spacesystemmodel.parameters.HummingbirdParameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.hbird.transport.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup;
import org.hbird.transport.spacesystemmodel.tmtcgroups.ParameterGroup;
import org.hbird.transport.xtce.exceptions.InvalidXtceFileException;
import org.hbird.transport.xtce.exceptions.UnsupportedXtceConstructException;
import org.hbird.transport.xtce.utils.XtceToJavaMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class XtceSpaceSystemModelFactory {
	private static final Logger LOG = LoggerFactory.getLogger(XtceSpaceSystemModelFactory.class);

	private SpaceSystem spaceSystem;

	private SpaceSystemModel model;

	private int numParameterGroups;

	private final Map<String, ParameterTypeSetTypeItem> xtceParameterTypes = new LinkedHashMap<String, ParameterTypeSetTypeItem>();

	private final Map<String, Parameter<Integer>> integerParameters = new LinkedHashMap<>();

	private final Map<String, Parameter<Long>> longParameters = new LinkedHashMap<>();

	private final Map<String, Parameter<Float>> floatParameters = new LinkedHashMap<>();

	private final Map<String, Parameter<Double>> doubleParameters = new LinkedHashMap<>();

	private final Map<String, Parameter<BigDecimal>> bigDecimalParameters = new LinkedHashMap<>();

	private final Map<String, Parameter<String>> stringParameters = new LinkedHashMap<>();

	private final Map<String, Parameter<Byte[]>> rawParameters = new LinkedHashMap<>();

	private final Map<String, ParameterGroup> parameterGroups = new HashMap<>();

	Map<String, List<Object>> restrictions = new HashMap<>();

	Map<String, Encoding> encodings = new HashMap<>();

	public XtceSpaceSystemModelFactory() {
	}

	public final SpaceSystemModel createSpaceSystemModel(final String spaceSystemmodelFilename) throws InvalidXtceFileException, NumberFormatException,
			InvalidParameterTypeException, UnsupportedXtceConstructException {
		model = new XtceSpaceSystemModel();

		spaceSystem = unmarshallXtceXmlSpaceSystem(spaceSystemmodelFilename);

		numParameterGroups = spaceSystem.getTelemetryMetaData().getContainerSet().getContainerSetTypeItemCount();

		createTelemetryModel();

		// createCommandModel();

		try {
			injectConstructsIntoModel();
		}
		catch (IllegalArgumentException | IllegalAccessException e) {
			LOG.error("Critical Error creating XTCE based Space System Model");
			e.printStackTrace();
			System.exit(-1);
		}

		return model;
	}

	private void injectConstructsIntoModel() throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = model.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			String name = field.getName();
			switch (name) {
				case "parameterGroups":
					field.set(model, parameterGroups);
					break;
				case "restrictions":
					field.set(model, restrictions);
					break;
				default:
					LOG.debug("Not interested in field : " + name);
			}
		}
	}

	private void createCommandModel() {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException();
	}

	private void createTelemetryModel() throws InvalidXtceFileException, NumberFormatException, InvalidParameterTypeException,
			UnsupportedXtceConstructException {
		createAllParameterTypes();
		createAllTelemetryParameters();
		createAllTelemetryParameterGroups();
		populateParameterGroups();
	}

	private final void createAllTelemetryParameters() throws InvalidParameterTypeException, NumberFormatException, InvalidXtceFileException {
		TelemetryMetaData categoryMetaData = spaceSystem.getTelemetryMetaData();
		int numberOfParameters = categoryMetaData.getParameterSet().getParameterSetTypeItemCount();

		// @formatter:off
		for (int i = 0; i < numberOfParameters; ++i) {

			final ParameterSetTypeItem xtceParameter = categoryMetaData.getParameterSet().getParameterSetTypeItem(i);

			String parameterTypeRef = xtceParameter.getParameter().getParameterTypeRef();
			ParameterTypeSetTypeItem xtceType = xtceParameterTypes.get(parameterTypeRef);

			// If it's an integer type...
			if(xtceType == null) {
				throw new InvalidXtceFileException("Unknown parameter type: " + parameterTypeRef + ". A parameter references an undeclared parameter type in the XTCE space system definition file.");
			}

			String qualifiedNamePrefix = spaceSystem.getName() + ".tm.";
			if (xtceType.getIntegerParameterType() != null) {
				IntegerParameterType type = xtceType.getIntegerParameterType();
				if (!XtceToJavaMapping.doesIntRequireJavaLong(type)) {
					Parameter<Integer> intParameter = new HummingbirdParameter<Integer>(
								qualifiedNamePrefix + xtceParameter.getParameter().getName(),
								xtceParameter.getParameter().getName(),
								xtceParameter.getParameter().getShortDescription(),
								xtceParameter.getParameter().getLongDescription());
					if(LOG.isDebugEnabled()) {
						LOG.debug("Adding Integer parameter " + intParameter.getName());
					}
					integerParameters.put(intParameter.getQualifiedName(), intParameter);
					encodings.put(intParameter.getQualifiedName(), createXtceIntegerEncoding(type));
				}
				else {
					Parameter<Long> longParameter = new HummingbirdParameter<Long>(
								qualifiedNamePrefix + xtceParameter.getParameter().getName(),
								xtceParameter.getParameter().getName(),
								xtceParameter.getParameter().getShortDescription(),
								xtceParameter.getParameter().getLongDescription());
					if(LOG.isDebugEnabled()) {
						LOG.debug("Adding Long parameter " + longParameter.getName());
					}
					longParameters.put(longParameter.getQualifiedName(), longParameter);
					encodings.put(longParameter.getQualifiedName(), createXtceIntegerEncoding(type));
				}
			}

			// If it's an float type...
			else if (xtceType.getFloatParameterType() != null) {
				FloatParameterType type = xtceType.getFloatParameterType();
				switch(type.getSizeInBits()) {
					case VALUE_32:
						Parameter<Float> floatParameter = new HummingbirdParameter<Float>(
								qualifiedNamePrefix + xtceParameter.getParameter().getName(),
								xtceParameter.getParameter().getName(),
								xtceParameter.getParameter().getShortDescription(),
								xtceParameter.getParameter().getLongDescription());
						floatParameters.put(floatParameter.getQualifiedName(), floatParameter);
						break;
					case VALUE_64:
						Parameter<Double> doubleParameter = new HummingbirdParameter<Double>(
								qualifiedNamePrefix + xtceParameter.getParameter().getName(),
								xtceParameter.getParameter().getName(),
								xtceParameter.getParameter().getShortDescription(),
								xtceParameter.getParameter().getLongDescription());
						doubleParameters.put(doubleParameter.getQualifiedName(), doubleParameter);
						break;
					case VALUE_128:
						Parameter<BigDecimal> bigDecimalParameter = new HummingbirdParameter<BigDecimal>(
								qualifiedNamePrefix + xtceParameter.getParameter().getName(),
								xtceParameter.getParameter().getName(),
								xtceParameter.getParameter().getShortDescription(),
								xtceParameter.getParameter().getLongDescription());
						bigDecimalParameters.put(bigDecimalParameter.getQualifiedName(), bigDecimalParameter);
						break;
					default:
						throw new InvalidXtceFileException("Invalid bit size for float type " + type.getName());
				}
			}
			else {
				throw new InvalidXtceFileException("Unknown parameter type: " + parameterTypeRef + ". A parameter references an undeclared parameter type in the XTCE space system definition file.");
			}
			// @formatter:on
		}
	}



	/**
	 * @return
	 * @throws InvalidParameterTypeException
	 * @throws InvalidXtceFileException
	 */
	private final void createAllParameterTypes() throws InvalidXtceFileException {
		int numberOfParameterTypes = spaceSystem.getTelemetryMetaData().getParameterTypeSet().getParameterTypeSetTypeItemCount();

		for (int parameterTypeIndex = 0; parameterTypeIndex < numberOfParameterTypes; ++parameterTypeIndex) {
			final ParameterTypeSetTypeItem item = spaceSystem.getTelemetryMetaData().getParameterTypeSet().getParameterTypeSetTypeItem(parameterTypeIndex);

			// If it's an integer parameter..
			final IntegerParameterType integerParameterType = item.getIntegerParameterType();
			if (integerParameterType != null) {
				String name = integerParameterType.getName();
				if (name != null) {
					xtceParameterTypes.put(name, item);
				}
				else {
					throw new InvalidXtceFileException("IntegerParameter has a null name; cannot add to parameterTypes");
				}
			}
			// If it is a float parameter...
			else if (item.getFloatParameterType() != null) {
				String name = item.getFloatParameterType().getName();
				if (name != null) {
					xtceParameterTypes.put(name, item);
				}
				else {
					throw new InvalidXtceFileException("FloatParameter has a null name; cannot add to parameterTypes");
				}
			}
			// If it is a string parameter...
			else if (item.getStringParameterType() != null) {
				String name = item.getStringParameterType().getName();
				if (name != null) {
					xtceParameterTypes.put(name, item);
				}
				else {
					throw new InvalidXtceFileException("StringParameter has a null name; cannot add to parameterTypes");
				}
			}
			// If it is a boolean parameter...
			else if (item.getBooleanParameterType() != null) {
				String name = item.getBooleanParameterType().getName();
				if (name != null) {
					xtceParameterTypes.put(name, item);
				}
				else {
					throw new InvalidXtceFileException("BooleanParameter has a null name; cannot add to parameterTypes");
				}
			}
			else {
				throw new InvalidXtceFileException("Unknown/unsupported parameter type: " + item);
			}
		}
	}

	private final static SpaceSystem unmarshallXtceXmlSpaceSystem(final String spacesystemmodelFilename) {
		SpaceSystem spaceSystem = null;
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

		return spaceSystem;
	}

	/**
	 * Create all ParameterGroups. In this iteration we create the parameter groups, but do not create the references
	 * between them as the referenced objects do not yet exit.
	 *
	 * @throws UnsupportedXtceConstructException
	 */
	private final void createAllTelemetryParameterGroups() throws UnsupportedXtceConstructException {
		String qualifiedNamePrefix = spaceSystem.getName() + ".tm.";
		for (int containerIndex = 0; containerIndex < numParameterGroups; ++containerIndex) {
			final SequenceContainer xtceContainer = spaceSystem.getTelemetryMetaData().getContainerSet().getContainerSetTypeItem(containerIndex)
					.getSequenceContainer();

			// @formatter:off
			final ParameterGroup parameterGroup = new HummingbirdParameterGroup(qualifiedNamePrefix + xtceContainer.getName(),
																				xtceContainer.getName(),
																				xtceContainer.getShortDescription(),
																				xtceContainer.getLongDescription());
			// @formatter:on
			parameterGroups.put(parameterGroup.getQualifiedName(), parameterGroup);
			populateParameterGroupRestrictions(parameterGroup.getQualifiedName(), xtceContainer);
			if (LOG.isDebugEnabled()) {
				LOG.debug("Created ParameterGroup " + xtceContainer.getName());
			}
		}
	}

	/**
	 * @throws UnsupportedXtceConstructException
	 *
	 */
	private final void populateParameterGroupRestrictions(final String qualifiedName, final SequenceContainer parameterGroupContainer)
			throws UnsupportedXtceConstructException {
		// If the group extends another, e.g. a payload that is linked to a header via a restriction
		// we need to create the restrictions.
		BaseContainer baseContainer = parameterGroupContainer.getBaseContainer();
		if (baseContainer != null) {
			List<Object> comparisons = new ArrayList<>();
			// In Hummingbird we do not model from the packet level, only the payload. In light of this we stipulate
			// that base containers representing parameter groups that are linked to another base container via a
			// restriction
			// (e.g. header) extend a base container whose name is defined as the
			// SpaceSystemModel.HUMMINGBIRD_PROCESSED_HEADER
			// constant
			if (StringUtils.equalsIgnoreCase(baseContainer.getContainerRef(), SpaceSystemModel.HUMMINGBIRD_PROCESSED_HEADER)) {
				// Check for lists of comparisons
				ComparisonList comparisonList = baseContainer.getRestrictionCriteria().getComparisonList();
				if (comparisonList != null) {
					Comparison[] restrictionCriteria = comparisonList.getComparison();
					for (final Comparison comparison : restrictionCriteria) {
						final String comparisonValue = comparison.getValue();
						comparisons.add(comparisonValue);
						if (LOG.isDebugEnabled()) {
							LOG.debug("Added restriction " + comparisonValue + " to parameter group " + parameterGroupContainer.getName());
						}
					}
					restrictions.put(qualifiedName, comparisons);
				}
				// Check for a single comparison
				Comparison singleComparison = baseContainer.getRestrictionCriteria().getComparison();
				if (singleComparison != null) {
					String comparisonValue = singleComparison.getValue();
					comparisons.add(comparisonValue);
					restrictions.put(qualifiedName, comparisons);
					if (LOG.isDebugEnabled()) {
						LOG.debug("Added restriction " + comparisonValue + " to parameter group " + parameterGroupContainer.getName());
					}
				}

				if (baseContainer.getRestrictionCriteria().getBooleanExpression() != null) {
					throw new UnsupportedXtceConstructException(
							"Hummingbird does not currently support Boolean Expression restrictions. Offending Container = "
									+ parameterGroupContainer.getName());
				}
				else if (baseContainer.getRestrictionCriteria().getChoiceValue() != null) {
					throw new UnsupportedXtceConstructException("Hummingbird does not currently support Choice Value restrictions. Offending Container = "
							+ parameterGroupContainer.getName());
				}
				else if (baseContainer.getRestrictionCriteria().getCustomAlgorithm() != null) {
					throw new UnsupportedXtceConstructException("Hummingbird does not currently support Custom Algorithm restrictions. Offending Container = "
							+ parameterGroupContainer.getName());
				}
				else if (baseContainer.getRestrictionCriteria().getNextContainer() != null) {
					throw new UnsupportedXtceConstructException("Hummingbird does not currently support Next Container restrictions. Offending Container = "
							+ parameterGroupContainer.getName());
				}
			}
			else {
				LOG.error("Hummingbird does not process hierarchical container models due to their incompatiablity with multi-packet spanning payloads and/or multi-frame spanning packets.");
				LOG.error("Specific error: ");
				LOG.error("ParameterGroup: " + parameterGroupContainer.getName() + " extends base container " + baseContainer.getContainerRef());
			}
		}
	}

	private final void populateEncodings(final String qualifiedName, final SequenceContainer parameterGroupContainer) {

	}

	private void populateParameterGroups() throws InvalidXtceFileException {
		String qualifiedNamePrefix = spaceSystem.getName() + ".tm.";
		ContainerSet containers = spaceSystem.getTelemetryMetaData().getContainerSet();

		// For every defined container
		for (int i = 0; i < containers.getContainerSetTypeItemCount(); i++) {
			SequenceContainer sequenceContainer = containers.getContainerSetTypeItem(i).getSequenceContainer();

			// Get the ParameterGroup we have created that corresponds to this SequenceContainer
			ParameterGroup group = this.parameterGroups.get(qualifiedNamePrefix + sequenceContainer.getName());

			// grab it's entry list
			EntryList parameterEntrys = sequenceContainer.getEntryList();

			for (int x = 0; x < parameterEntrys.getEntryListTypeItemCount(); x++) {
				String parameterRef = parameterEntrys.getEntryListTypeItem(x).getParameterRefEntry().getParameterRef();

				addParameterToGroup(group, qualifiedNamePrefix + parameterRef);

				if (LOG.isDebugEnabled()) {
					LOG.debug("Added parameter " + qualifiedNamePrefix + parameterRef + " to group " + group.getName());
				}
			}
		}
	}

//	private Class findParameter(final String qualifiedName) {
//		if(integerParameters.containsKey(qualifiedName)) {
//			return Integer.class;
////			return integerParameters.get(qualifiedName);
//		}
//		if(longParameters.containsKey(qualifiedName)) {
//			return Long.class;
////			return longParameters.get(qualifiedName);
//		}
//		if(floatParameters.containsKey(qualifiedName)) {
//			return Float.class;
////			return floatParameters.get(qualifiedName);
//		}
//		if(doubleParameters.containsKey(qualifiedName)) {
//			return Double.class;
////			return doubleParameters.get(qualifiedName);
//		}
//		if(bigDecimalParameters.containsKey(qualifiedName)) {
//			return BigDecimal.class;
////			return bigDecimalParameters.get(qualifiedName);
//		}
//		if(stringParameters.containsKey(qualifiedName)) {
//			return String.class;
////			return stringParameters.get(qualifiedName);
//		}
//		if(rawParameters.containsKey(qualifiedName)) {
//			return Byte.class;
////			return rawParameters.get(qualifiedName);
//		}
//		return null;
//	}



	private void addParameterToGroup(final ParameterGroup group, final String qualifiedName) throws InvalidXtceFileException {
		if (integerParameters.containsValue(qualifiedName)) {
			group.addIntegerParameter(qualifiedName, integerParameters.get(qualifiedName));
		}
		else if (longParameters.containsValue(qualifiedName)) {
			group.addLongParameter(qualifiedName, longParameters.get(qualifiedName));
		}
		else {
			// TODO Finish unsupported parameter types
			throw new InvalidXtceFileException("Hummingbird currently only supports integer and long sized parameters");
		}
	}


	/**
	 * Covers Java Integers and Longs
	 * @param intParamType
	 * @return
	 * @throws InvalidXtceFileException
	 */
	private final static Encoding createXtceIntegerEncoding(final IntegerParameterType intParamType) throws InvalidXtceFileException {
		Encoding encoding = new Encoding();
		encoding.setSizeInBits(intParamType.getSizeInBits());

		BaseDataTypeChoice baseDataTypeChoice = intParamType.getBaseDataTypeChoice();
		if (baseDataTypeChoice == null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("Base data type does not have a base data type choice, assuming default of unsigned integer encoding");
			}
			encoding.setBinaryRepresentation(BinaryRepresentation.unsigned);
		}
		IntegerDataEncodingTypeEncodingType xtceEncoding = baseDataTypeChoice.getIntegerDataEncoding().getEncoding();
		switch (xtceEncoding) {
			case UNSIGNED:
				encoding.setBinaryRepresentation(BinaryRepresentation.unsigned);
				break;
			case TWOSCOMPLIMENT:
				encoding.setBinaryRepresentation(BinaryRepresentation.twosComplement);
				break;
			case BCD:
				encoding.setBinaryRepresentation(BinaryRepresentation.binaryCodedDecimal);
				break;
			case ONESCOMPLIMENT:
				encoding.setBinaryRepresentation(BinaryRepresentation.onesComplement);
				break;
			case SIGNMAGNITUDE:
				encoding.setBinaryRepresentation(BinaryRepresentation.signMagnitude);
				break;
			case PACKEDBCD:
				encoding.setBinaryRepresentation(BinaryRepresentation.packedBinaryCodedDecimal);
				break;
			default:
				throw new InvalidXtceFileException("Invalid integer encoding in type " + intParamType);
		}

		return encoding;
	}

	/**
	 * Covers Java Floats and Doubles.
	 * @param type
	 * @return
	 * @throws InvalidXtceFileException
	 */
	private final static Encoding getFloatEncoding(final FloatParameterType type) throws InvalidXtceFileException {
		BaseDataTypeChoice baseDataTypeChoice = type.getBaseDataTypeChoice();

		Encoding encoding = new Encoding();
		encoding.setSizeInBits(Long.parseLong(type.getSizeInBits().value()));

		if (baseDataTypeChoice == null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("Base data type does not have a base data type choice, assuming default of IEEE754_1985 float encoding");
			}
			encoding.setBinaryRepresentation(BinaryRepresentation.IEEE754_1985);
		}
		FloatDataEncodingTypeEncodingType xtceEncoding = baseDataTypeChoice.getFloatDataEncoding().getEncoding();

		switch (xtceEncoding) {
			case IEEE754_1985:
				encoding.setBinaryRepresentation(BinaryRepresentation.IEEE754_1985);
				break;
			case MILSTD_1750A:
				encoding.setBinaryRepresentation(BinaryRepresentation.MILSTD_1750A);
				break;
			default:
				throw new InvalidXtceFileException("Invalid float encoding in type " + type);
		}
		return encoding;
	}

}
