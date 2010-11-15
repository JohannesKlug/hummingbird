/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * There are two ways numeric data can be changed to string data:
 * using a Java style NumberFormat, or using an enumerated list.
 * Enumerated lists can be assigned to a single value or a value
 * range.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class NumberToStringType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _numberToStringTypeChoice.
     */
    private com.logica.hummingbird.xtce.castor.NumberToStringTypeChoice _numberToStringTypeChoice;

    /**
     * Field _numberFormat.
     */
    private com.logica.hummingbird.xtce.castor.NumberFormat _numberFormat;


      //----------------/
     //- Constructors -/
    //----------------/

    public NumberToStringType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'numberFormat'.
     * 
     * @return the value of field 'NumberFormat'.
     */
    public com.logica.hummingbird.xtce.castor.NumberFormat getNumberFormat(
    ) {
        return this._numberFormat;
    }

    /**
     * Returns the value of field 'numberToStringTypeChoice'.
     * 
     * @return the value of field 'NumberToStringTypeChoice'.
     */
    public com.logica.hummingbird.xtce.castor.NumberToStringTypeChoice getNumberToStringTypeChoice(
    ) {
        return this._numberToStringTypeChoice;
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
     * Sets the value of field 'numberFormat'.
     * 
     * @param numberFormat the value of field 'numberFormat'.
     */
    public void setNumberFormat(
            final com.logica.hummingbird.xtce.castor.NumberFormat numberFormat) {
        this._numberFormat = numberFormat;
        this._choiceValue = numberFormat;
    }

    /**
     * Sets the value of field 'numberToStringTypeChoice'.
     * 
     * @param numberToStringTypeChoice the value of field
     * 'numberToStringTypeChoice'.
     */
    public void setNumberToStringTypeChoice(
            final com.logica.hummingbird.xtce.castor.NumberToStringTypeChoice numberToStringTypeChoice) {
        this._numberToStringTypeChoice = numberToStringTypeChoice;
        this._choiceValue = numberToStringTypeChoice;
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
     * com.logica.hummingbird.xtce.castor.NumberToStringType
     */
    public static com.logica.hummingbird.xtce.castor.NumberToStringType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.NumberToStringType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.NumberToStringType.class, reader);
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
