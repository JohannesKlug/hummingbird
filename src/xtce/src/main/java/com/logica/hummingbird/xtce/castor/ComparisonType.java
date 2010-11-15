/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * A simple ParameterInstanceRef to value comparison. The string
 * supplied in the value attribute needs to be converted to a type
 * matching the Parameter being compared to. Numerical values are
 * assumed to be base 10 unless proceeded by 0x (hexadecimal), 0o
 * (octal), or 0b (binary). The value is truncated to use the least
 * significant bits that match the bit size of the Parameter being
 * compared to.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ComparisonType extends com.logica.hummingbird.xtce.castor.ParameterInstanceRefType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * internal content storage
     */
    private java.lang.String _content = "";

    /**
     * Field _comparisonOperator.
     */
    private com.logica.hummingbird.xtce.castor.types.ComparisonOperatorsType _comparisonOperator = com.logica.hummingbird.xtce.castor.types.ComparisonOperatorsType.fromValue("==");

    /**
     * Field _value.
     */
    private java.lang.String _value;


      //----------------/
     //- Constructors -/
    //----------------/

    public ComparisonType() {
        super();
        setContent("");
        setComparisonOperator(com.logica.hummingbird.xtce.castor.types.ComparisonOperatorsType.fromValue("=="));
    }

    public ComparisonType(final java.lang.String defaultValue) {
        try {
            setContent( new java.lang.String(defaultValue));
         } catch(Exception e) {
            throw new RuntimeException("Unable to cast default value for simple content!");
         } 
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'comparisonOperator'.
     * 
     * @return the value of field 'ComparisonOperator'.
     */
    public com.logica.hummingbird.xtce.castor.types.ComparisonOperatorsType getComparisonOperator(
    ) {
        return this._comparisonOperator;
    }

    /**
     * Returns the value of field 'content'. The field 'content'
     * has the following description: internal content storage
     * 
     * @return the value of field 'Content'.
     */
    public java.lang.String getContent(
    ) {
        return this._content;
    }

    /**
     * Returns the value of field 'value'.
     * 
     * @return the value of field 'Value'.
     */
    public java.lang.String getValue(
    ) {
        return this._value;
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
     * Sets the value of field 'comparisonOperator'.
     * 
     * @param comparisonOperator the value of field
     * 'comparisonOperator'.
     */
    public void setComparisonOperator(
            final com.logica.hummingbird.xtce.castor.types.ComparisonOperatorsType comparisonOperator) {
        this._comparisonOperator = comparisonOperator;
    }

    /**
     * Sets the value of field 'content'. The field 'content' has
     * the following description: internal content storage
     * 
     * @param content the value of field 'content'.
     */
    public void setContent(
            final java.lang.String content) {
        this._content = content;
    }

    /**
     * Sets the value of field 'value'.
     * 
     * @param value the value of field 'value'.
     */
    public void setValue(
            final java.lang.String value) {
        this._value = value;
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
     * com.logica.hummingbird.xtce.castor.ComparisonType
     */
    public static com.logica.hummingbird.xtce.castor.ComparisonType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.ComparisonType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.ComparisonType.class, reader);
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
