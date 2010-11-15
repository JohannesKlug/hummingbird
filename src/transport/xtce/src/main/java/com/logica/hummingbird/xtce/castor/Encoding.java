/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Scale and offset are used in a y =mx +b type relationship (m is
 * the scale and b is the offset) to make adjustmets to the encoded
 * value to that it matches the time units. Binary Encoded time is
 * typically used with a user supplied transform algorithm to
 * convert time data formats that are too difficult to describe in
 * XTCE.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Encoding implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _units.
     */
    private com.logica.hummingbird.xtce.castor.types.EncodingUnitsType _units = com.logica.hummingbird.xtce.castor.types.EncodingUnitsType.fromValue("seconds");

    /**
     * Field _scale.
     */
    private double _scale = 1;

    /**
     * keeps track of state for field: _scale
     */
    private boolean _has_scale;

    /**
     * Field _offset.
     */
    private double _offset = 0;

    /**
     * keeps track of state for field: _offset
     */
    private boolean _has_offset;

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _binaryDataEncoding.
     */
    private com.logica.hummingbird.xtce.castor.BinaryDataEncoding _binaryDataEncoding;

    /**
     * Field _floatDataEncoding.
     */
    private com.logica.hummingbird.xtce.castor.FloatDataEncoding _floatDataEncoding;

    /**
     * Field _integerDataEncoding.
     */
    private com.logica.hummingbird.xtce.castor.IntegerDataEncoding _integerDataEncoding;

    /**
     * Field _stringDataEncoding.
     */
    private com.logica.hummingbird.xtce.castor.StringDataEncoding _stringDataEncoding;


      //----------------/
     //- Constructors -/
    //----------------/

    public Encoding() {
        super();
        setUnits(com.logica.hummingbird.xtce.castor.types.EncodingUnitsType.fromValue("seconds"));
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteOffset(
    ) {
        this._has_offset= false;
    }

    /**
     */
    public void deleteScale(
    ) {
        this._has_scale= false;
    }

    /**
     * Returns the value of field 'binaryDataEncoding'.
     * 
     * @return the value of field 'BinaryDataEncoding'.
     */
    public com.logica.hummingbird.xtce.castor.BinaryDataEncoding getBinaryDataEncoding(
    ) {
        return this._binaryDataEncoding;
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
     * Returns the value of field 'floatDataEncoding'.
     * 
     * @return the value of field 'FloatDataEncoding'.
     */
    public com.logica.hummingbird.xtce.castor.FloatDataEncoding getFloatDataEncoding(
    ) {
        return this._floatDataEncoding;
    }

    /**
     * Returns the value of field 'integerDataEncoding'.
     * 
     * @return the value of field 'IntegerDataEncoding'.
     */
    public com.logica.hummingbird.xtce.castor.IntegerDataEncoding getIntegerDataEncoding(
    ) {
        return this._integerDataEncoding;
    }

    /**
     * Returns the value of field 'offset'.
     * 
     * @return the value of field 'Offset'.
     */
    public double getOffset(
    ) {
        return this._offset;
    }

    /**
     * Returns the value of field 'scale'.
     * 
     * @return the value of field 'Scale'.
     */
    public double getScale(
    ) {
        return this._scale;
    }

    /**
     * Returns the value of field 'stringDataEncoding'.
     * 
     * @return the value of field 'StringDataEncoding'.
     */
    public com.logica.hummingbird.xtce.castor.StringDataEncoding getStringDataEncoding(
    ) {
        return this._stringDataEncoding;
    }

    /**
     * Returns the value of field 'units'.
     * 
     * @return the value of field 'Units'.
     */
    public com.logica.hummingbird.xtce.castor.types.EncodingUnitsType getUnits(
    ) {
        return this._units;
    }

    /**
     * Method hasOffset.
     * 
     * @return true if at least one Offset has been added
     */
    public boolean hasOffset(
    ) {
        return this._has_offset;
    }

    /**
     * Method hasScale.
     * 
     * @return true if at least one Scale has been added
     */
    public boolean hasScale(
    ) {
        return this._has_scale;
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
     * Sets the value of field 'binaryDataEncoding'.
     * 
     * @param binaryDataEncoding the value of field
     * 'binaryDataEncoding'.
     */
    public void setBinaryDataEncoding(
            final com.logica.hummingbird.xtce.castor.BinaryDataEncoding binaryDataEncoding) {
        this._binaryDataEncoding = binaryDataEncoding;
        this._choiceValue = binaryDataEncoding;
    }

    /**
     * Sets the value of field 'floatDataEncoding'.
     * 
     * @param floatDataEncoding the value of field
     * 'floatDataEncoding'.
     */
    public void setFloatDataEncoding(
            final com.logica.hummingbird.xtce.castor.FloatDataEncoding floatDataEncoding) {
        this._floatDataEncoding = floatDataEncoding;
        this._choiceValue = floatDataEncoding;
    }

    /**
     * Sets the value of field 'integerDataEncoding'.
     * 
     * @param integerDataEncoding the value of field
     * 'integerDataEncoding'.
     */
    public void setIntegerDataEncoding(
            final com.logica.hummingbird.xtce.castor.IntegerDataEncoding integerDataEncoding) {
        this._integerDataEncoding = integerDataEncoding;
        this._choiceValue = integerDataEncoding;
    }

    /**
     * Sets the value of field 'offset'.
     * 
     * @param offset the value of field 'offset'.
     */
    public void setOffset(
            final double offset) {
        this._offset = offset;
        this._has_offset = true;
    }

    /**
     * Sets the value of field 'scale'.
     * 
     * @param scale the value of field 'scale'.
     */
    public void setScale(
            final double scale) {
        this._scale = scale;
        this._has_scale = true;
    }

    /**
     * Sets the value of field 'stringDataEncoding'.
     * 
     * @param stringDataEncoding the value of field
     * 'stringDataEncoding'.
     */
    public void setStringDataEncoding(
            final com.logica.hummingbird.xtce.castor.StringDataEncoding stringDataEncoding) {
        this._stringDataEncoding = stringDataEncoding;
        this._choiceValue = stringDataEncoding;
    }

    /**
     * Sets the value of field 'units'.
     * 
     * @param units the value of field 'units'.
     */
    public void setUnits(
            final com.logica.hummingbird.xtce.castor.types.EncodingUnitsType units) {
        this._units = units;
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
     * com.logica.hummingbird.xtce.castor.Encoding
     */
    public static com.logica.hummingbird.xtce.castor.Encoding unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.Encoding) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.Encoding.class, reader);
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
