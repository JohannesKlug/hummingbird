/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * An abstract type that is a super type of either an Integer or
 * Float Data type.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class NumericDataType extends com.logica.hummingbird.xtce.castor.BaseDataType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _validRangeAppliesToCalibrated.
     */
    private boolean _validRangeAppliesToCalibrated = true;

    /**
     * keeps track of state for field: _validRangeAppliesToCalibrate
     */
    private boolean _has_validRangeAppliesToCalibrated;

    /**
     * Field _toString.
     */
    private com.logica.hummingbird.xtce.castor.ToString _toString;

    /**
     * Field _validRange.
     */
    private com.logica.hummingbird.xtce.castor.ValidRange _validRange;

    /**
     * Field _defaultCalibrator.
     */
    private com.logica.hummingbird.xtce.castor.DefaultCalibrator _defaultCalibrator;

    /**
     * Field _contextCalibratorList.
     */
    private com.logica.hummingbird.xtce.castor.NumericDataTypeContextCalibratorList _contextCalibratorList;


      //----------------/
     //- Constructors -/
    //----------------/

    public NumericDataType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteValidRangeAppliesToCalibrated(
    ) {
        this._has_validRangeAppliesToCalibrated= false;
    }

    /**
     * Returns the value of field 'contextCalibratorList'.
     * 
     * @return the value of field 'ContextCalibratorList'.
     */
    public com.logica.hummingbird.xtce.castor.NumericDataTypeContextCalibratorList getContextCalibratorList(
    ) {
        return this._contextCalibratorList;
    }

    /**
     * Returns the value of field 'defaultCalibrator'.
     * 
     * @return the value of field 'DefaultCalibrator'.
     */
    public com.logica.hummingbird.xtce.castor.DefaultCalibrator getDefaultCalibrator(
    ) {
        return this._defaultCalibrator;
    }

    /**
     * Returns the value of field 'toString'.
     * 
     * @return the value of field 'ToString'.
     */
    public com.logica.hummingbird.xtce.castor.ToString getToString(
    ) {
        return this._toString;
    }

    /**
     * Returns the value of field 'validRange'.
     * 
     * @return the value of field 'ValidRange'.
     */
    public com.logica.hummingbird.xtce.castor.ValidRange getValidRange(
    ) {
        return this._validRange;
    }

    /**
     * Returns the value of field 'validRangeAppliesToCalibrated'.
     * 
     * @return the value of field 'ValidRangeAppliesToCalibrated'.
     */
    public boolean getValidRangeAppliesToCalibrated(
    ) {
        return this._validRangeAppliesToCalibrated;
    }

    /**
     * Method hasValidRangeAppliesToCalibrated.
     * 
     * @return true if at least one ValidRangeAppliesToCalibrated
     * has been added
     */
    public boolean hasValidRangeAppliesToCalibrated(
    ) {
        return this._has_validRangeAppliesToCalibrated;
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
     * Returns the value of field 'validRangeAppliesToCalibrated'.
     * 
     * @return the value of field 'ValidRangeAppliesToCalibrated'.
     */
    public boolean isValidRangeAppliesToCalibrated(
    ) {
        return this._validRangeAppliesToCalibrated;
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
     * Sets the value of field 'contextCalibratorList'.
     * 
     * @param contextCalibratorList the value of field
     * 'contextCalibratorList'.
     */
    public void setContextCalibratorList(
            final com.logica.hummingbird.xtce.castor.NumericDataTypeContextCalibratorList contextCalibratorList) {
        this._contextCalibratorList = contextCalibratorList;
    }

    /**
     * Sets the value of field 'defaultCalibrator'.
     * 
     * @param defaultCalibrator the value of field
     * 'defaultCalibrator'.
     */
    public void setDefaultCalibrator(
            final com.logica.hummingbird.xtce.castor.DefaultCalibrator defaultCalibrator) {
        this._defaultCalibrator = defaultCalibrator;
    }

    /**
     * Sets the value of field 'toString'.
     * 
     * @param toString the value of field 'toString'.
     */
    public void setToString(
            final com.logica.hummingbird.xtce.castor.ToString toString) {
        this._toString = toString;
    }

    /**
     * Sets the value of field 'validRange'.
     * 
     * @param validRange the value of field 'validRange'.
     */
    public void setValidRange(
            final com.logica.hummingbird.xtce.castor.ValidRange validRange) {
        this._validRange = validRange;
    }

    /**
     * Sets the value of field 'validRangeAppliesToCalibrated'.
     * 
     * @param validRangeAppliesToCalibrated the value of field
     * 'validRangeAppliesToCalibrated'.
     */
    public void setValidRangeAppliesToCalibrated(
            final boolean validRangeAppliesToCalibrated) {
        this._validRangeAppliesToCalibrated = validRangeAppliesToCalibrated;
        this._has_validRangeAppliesToCalibrated = true;
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
     * com.logica.hummingbird.xtce.castor.NumericDataType
     */
    public static com.logica.hummingbird.xtce.castor.NumericDataType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.NumericDataType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.NumericDataType.class, reader);
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
