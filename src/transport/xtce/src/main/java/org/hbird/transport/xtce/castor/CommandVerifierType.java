/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * A command verifier is used to check that the command has be
 * successfully executed. Command Verifiers may be either a Custom
 * Algorithm or a Boolean Check or the presence of a Container for
 * a relative change in the value of a Parameter. The timeToWait is
 * a time period where the verification must test true.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CommandVerifierType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Specifies how much time to provide for the verification. 
     */
    private org.exolab.castor.types.Duration _timeToWait;

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _comparison.
     */
    private org.hbird.transport.xtce.castor.Comparison _comparison;

    /**
     * All comparisons must be true
     */
    private org.hbird.transport.xtce.castor.CommandVerifierTypeComparisonList _comparisonList;

    /**
     * Field _booleanExpression.
     */
    private org.hbird.transport.xtce.castor.BooleanExpression _booleanExpression;

    /**
     * When verification is the existance of a Container
     */
    private org.hbird.transport.xtce.castor.ContainerRef _containerRef;

    /**
     * Used to look for relative change in a Parameter value. Only
     * usefull for numeric Parameters
     */
    private org.hbird.transport.xtce.castor.ParameterValueChange _parameterValueChange;

    /**
     * Field _customAlgorithm.
     */
    private org.hbird.transport.xtce.castor.CustomAlgorithm _customAlgorithm;


      //----------------/
     //- Constructors -/
    //----------------/

    public CommandVerifierType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'booleanExpression'.
     * 
     * @return the value of field 'BooleanExpression'.
     */
    public org.hbird.transport.xtce.castor.BooleanExpression getBooleanExpression(
    ) {
        return this._booleanExpression;
    }

    /**
     * Returns the value of field 'choiceValue'. The field
     * 'choiceValue' has the following description: Internal choice
     * value storage
     * 
     * @return the value of field 'ChoiceValue'.
     */
    public java.lang.Object getChoiceValue(
    ) {
        return this._choiceValue;
    }

    /**
     * Returns the value of field 'comparison'.
     * 
     * @return the value of field 'Comparison'.
     */
    public org.hbird.transport.xtce.castor.Comparison getComparison(
    ) {
        return this._comparison;
    }

    /**
     * Returns the value of field 'comparisonList'. The field
     * 'comparisonList' has the following description: All
     * comparisons must be true
     * 
     * @return the value of field 'ComparisonList'.
     */
    public org.hbird.transport.xtce.castor.CommandVerifierTypeComparisonList getComparisonList(
    ) {
        return this._comparisonList;
    }

    /**
     * Returns the value of field 'containerRef'. The field
     * 'containerRef' has the following description: When
     * verification is the existance of a Container
     * 
     * @return the value of field 'ContainerRef'.
     */
    public org.hbird.transport.xtce.castor.ContainerRef getContainerRef(
    ) {
        return this._containerRef;
    }

    /**
     * Returns the value of field 'customAlgorithm'.
     * 
     * @return the value of field 'CustomAlgorithm'.
     */
    public org.hbird.transport.xtce.castor.CustomAlgorithm getCustomAlgorithm(
    ) {
        return this._customAlgorithm;
    }

    /**
     * Returns the value of field 'parameterValueChange'. The field
     * 'parameterValueChange' has the following description: Used
     * to look for relative change in a Parameter value. Only
     * usefull for numeric Parameters
     * 
     * @return the value of field 'ParameterValueChange'.
     */
    public org.hbird.transport.xtce.castor.ParameterValueChange getParameterValueChange(
    ) {
        return this._parameterValueChange;
    }

    /**
     * Returns the value of field 'timeToWait'. The field
     * 'timeToWait' has the following description: Specifies how
     * much time to provide for the verification. 
     * 
     * @return the value of field 'TimeToWait'.
     */
    public org.exolab.castor.types.Duration getTimeToWait(
    ) {
        return this._timeToWait;
    }

    /**
     * Method isValid.
     * 
     * @return true if this object is valid according to the schema
     */
    public boolean isValid(
    ) {
        try {
            validate();
        } catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    }

    /**
     * 
     * 
     * @param out
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void marshal(
            final java.io.Writer out)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, out);
    }

    /**
     * 
     * 
     * @param handler
     * @throws java.io.IOException if an IOException occurs during
     * marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     */
    public void marshal(
            final org.xml.sax.ContentHandler handler)
    throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, handler);
    }

    /**
     * Sets the value of field 'booleanExpression'.
     * 
     * @param booleanExpression the value of field
     * 'booleanExpression'.
     */
    public void setBooleanExpression(
            final org.hbird.transport.xtce.castor.BooleanExpression booleanExpression) {
        this._booleanExpression = booleanExpression;
        this._choiceValue = booleanExpression;
    }

    /**
     * Sets the value of field 'comparison'.
     * 
     * @param comparison the value of field 'comparison'.
     */
    public void setComparison(
            final org.hbird.transport.xtce.castor.Comparison comparison) {
        this._comparison = comparison;
        this._choiceValue = comparison;
    }

    /**
     * Sets the value of field 'comparisonList'. The field
     * 'comparisonList' has the following description: All
     * comparisons must be true
     * 
     * @param comparisonList the value of field 'comparisonList'.
     */
    public void setComparisonList(
            final org.hbird.transport.xtce.castor.CommandVerifierTypeComparisonList comparisonList) {
        this._comparisonList = comparisonList;
        this._choiceValue = comparisonList;
    }

    /**
     * Sets the value of field 'containerRef'. The field
     * 'containerRef' has the following description: When
     * verification is the existance of a Container
     * 
     * @param containerRef the value of field 'containerRef'.
     */
    public void setContainerRef(
            final org.hbird.transport.xtce.castor.ContainerRef containerRef) {
        this._containerRef = containerRef;
        this._choiceValue = containerRef;
    }

    /**
     * Sets the value of field 'customAlgorithm'.
     * 
     * @param customAlgorithm the value of field 'customAlgorithm'.
     */
    public void setCustomAlgorithm(
            final org.hbird.transport.xtce.castor.CustomAlgorithm customAlgorithm) {
        this._customAlgorithm = customAlgorithm;
        this._choiceValue = customAlgorithm;
    }

    /**
     * Sets the value of field 'parameterValueChange'. The field
     * 'parameterValueChange' has the following description: Used
     * to look for relative change in a Parameter value. Only
     * usefull for numeric Parameters
     * 
     * @param parameterValueChange the value of field
     * 'parameterValueChange'.
     */
    public void setParameterValueChange(
            final org.hbird.transport.xtce.castor.ParameterValueChange parameterValueChange) {
        this._parameterValueChange = parameterValueChange;
        this._choiceValue = parameterValueChange;
    }

    /**
     * Sets the value of field 'timeToWait'. The field 'timeToWait'
     * has the following description: Specifies how much time to
     * provide for the verification. 
     * 
     * @param timeToWait the value of field 'timeToWait'.
     */
    public void setTimeToWait(
            final org.exolab.castor.types.Duration timeToWait) {
        this._timeToWait = timeToWait;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * org.hbird.xtce.castor.CommandVerifierType
     */
    public static org.hbird.transport.xtce.castor.CommandVerifierType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.CommandVerifierType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.CommandVerifierType.class, reader);
    }

    /**
     * 
     * 
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void validate(
    )
    throws org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    }

}
