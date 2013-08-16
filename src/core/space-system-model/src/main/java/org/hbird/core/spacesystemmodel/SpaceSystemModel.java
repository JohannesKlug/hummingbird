package org.hbird.core.spacesystemmodel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import org.hbird.core.commons.tmtc.exceptions.UnknownParameterException;
import org.hbird.core.spacesystemmodel.calibration.Calibrator;
import org.hbird.core.spacesystemmodel.encoding.Encoding;
import org.hbird.core.spacesystemmodel.exceptions.ParameterNotInModelException;
import org.hbird.core.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.core.spacesystemmodel.tmtc.CommandGroup;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.core.spacesystemmodel.tmtc.ParameterGroup;

/**
 * Interface to create Space System Model factories.
 * 
 * The models are created based on an underlying space system model, defining the structure of the space system,
 * including the telemetry and command structures. The space system can be constructed from any format given the correct
 * factory, for example, the OMG/CCSDS XTCE, ESA MIB/PUS model, Spring, or any other DSL. The model factory
 * implementation will depend on a data structure in a specific format, but hides this implementation to the monitoring
 * component.
 */
@XmlRootElement
public interface SpaceSystemModel extends Serializable {

	// FIXME XTCE specific hack. Should move to the xtce project. Investigate. - Mark
	String HUMMINGBIRD_PROCESSED_HEADER = "HEADER";

	String getName();

	// Parameter Group related
	ParameterGroup getParameterGroup(String qualifiedName) throws UnknownParameterGroupException;

	Map<String, ParameterGroup> getParameterGroups();

	Map<String, CommandGroup> getCommands();

	Collection<ParameterGroup> getParameterGroupsCollection();

	// Parameter related
	Parameter<?> getParameter(String qualifiedName) throws UnknownParameterException;

	Parameter<Integer> getIntParameter(String qualifiedName) throws UnknownParameterException;

	Parameter<Long> getLongParameter(String qualifiedName) throws UnknownParameterException;

	Parameter<BigDecimal> getBigDecimalParameter(String qualifiedName) throws UnknownParameterException;

	Parameter<String> getStringParameter(String qualifiedName) throws UnknownParameterException;

	Parameter<Float> getFloatParameter(String qualifiedName) throws UnknownParameterException;

	Parameter<Double> getDoubleParameter(String qualifiedName) throws UnknownParameterException;

	Parameter<Byte[]> getRawParameter(String qualifiedName) throws UnknownParameterException;

	/** Returns all parameters (unbound) from all payload groups in the model */
	Map<String, Parameter<?>> getAllPayloadParameters();

	/** Returns all Integer parameters from all payload groups in the model */
	Map<String, Parameter<Integer>> getAllUniqueIntegerParameters();

	/** Returns all Long parameters from all payload groups in the model */
	Map<String, Parameter<Long>> getAllUniqueLongParameters();

	/** Returns all BigDecimal parameters from all payload groups in the model */
	Map<String, Parameter<BigDecimal>> getAllUniqueBigDecimalParameters();

	/** Returns all Float parameters from all payload groups in the model */
	Map<String, Parameter<Float>> getAllUniqueFloatParameters();

	/** Returns all Double parameters from all payload groups in the model */
	Map<String, Parameter<Double>> getAllUniqueDoubleParameters();

	/** Returns all String parameters from all payload groups in the model */
	Map<String, Parameter<String>> getAllUniqueStringParameters();

	/** Returns all Raw parameters from all payload groups in the model */
	Map<String, Parameter<Byte[]>> getAllUniqueRawParameters();

	/**
	 * Finds and replaces a parameter keyed by qualified name in the the model
	 * 
	 * @throws ParameterNotInModelException
	 */
	void replaceParameterInModel(String qualifiedName, final Parameter<?> newParameter) throws ParameterNotInModelException;

	Map<String, List<String>> getAllPayloadRestrictions();

	Map<String, Encoding> getEncodings();

	Map<String, String> getCommandVerifiers(String qualifiedName);

	Map<String, Calibrator> getAllCalibrators();

	/**
	 * Gets the calibration definition associated with a specified parameter.
	 * 
	 * @param qualifiedName
	 *            the parameter whose calibration definition you which to retrieve.
	 */
	Calibrator getCalibrator(String qualifiedName);
}