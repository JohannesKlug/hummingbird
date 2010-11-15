/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Contains an Numeric value; value may be provided directly or via
 * the value in a parameter.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class DecimalValueType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _fixedValue.
     */
    private java.math.BigDecimal _fixedValue;

    /**
     * Uses a parameter to for the value. The parameter value may
     * be optionally adjusted by a Linear function or use a series
     * of boolean expressions to lookup the value. Anything more
     * complex and a DynamicValue with a CustomAlgorithm may be used
     */
    private com.logica.hummingbird.xtce.castor.DecimalValueTypeDynamicValue _dynamicValue;


      //----------------/
     //- Constructors -/
    //----------------/

    public DecimalValueType() {
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
     * Returns the value of field 'dynamicValue'. The field
     * 'dynamicValue' has the following description: Uses a
     * parameter to for the value. The parameter value may be
     * optionally adjusted by a Linear function or use a series of
     * boolean expressions to lookup the value. Anything more
     * complex and a DynamicValue with a CustomAlgorithm may be
     * used 
     * 
     * @return the value of field 'DynamicValue'.
     */
    public com.logica.hummingbird.xtce.castor.DecimalValueTypeDynamicValue getDynamicValue(
    ) {
        return this._dynamicValue;
    }

    /**
     * Returns the value of field 'fixedValue'.
     * 
     * @return the value of field 'FixedValue'.
     */
    public java.math.BigDecimal getFixedValue(
    ) {
        return this._fixedValue;
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
     * Sets the value of field 'dynamicValue'. The field
     * 'dynamicValue' has the following description: Uses a
     * parameter to for the value. The parameter value may be
     * optionally adjusted by a Linear function or use a series of
     * boolean expressions to lookup the value. Anything more
     * complex and a DynamicValue with a CustomAlgorithm may be
     * used 
     * 
     * @param dynamicValue the value of field 'dynamicValue'.
     */
    public void setDynamicValue(
            final com.logica.hummingbird.xtce.castor.DecimalValueTypeDynamicValue dynamicValue) {
        this._dynamicValue = dynamicValue;
        this._choiceValue = dynamicValue;
    }

    /**
     * Sets the value of field 'fixedValue'.
     * 
     * @param fixedValue the value of field 'fixedValue'.
     */
    public void setFixedValue(
            final java.math.BigDecimal fixedValue) {
        this._fixedValue = fixedValue;
        this._choiceValue = fixedValue;
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
     * com.logica.hummingbird.xtce.castor.DecimalValueType
     */
    public static com.logica.hummingbird.xtce.castor.DecimalValueType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.DecimalValueType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.DecimalValueType.class, reader);
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
