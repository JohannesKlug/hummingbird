/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Class BaseDataTypeChoice.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class BaseDataTypeChoice implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

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

    public BaseDataTypeChoice() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'stringDataEncoding'.
     * 
     * @return the value of field 'StringDataEncoding'.
     */
    public com.logica.hummingbird.xtce.castor.StringDataEncoding getStringDataEncoding(
    ) {
        return this._stringDataEncoding;
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
     * com.logica.hummingbird.xtce.castor.BaseDataTypeChoice
     */
    public static com.logica.hummingbird.xtce.castor.BaseDataTypeChoice unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.BaseDataTypeChoice) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.BaseDataTypeChoice.class, reader);
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
