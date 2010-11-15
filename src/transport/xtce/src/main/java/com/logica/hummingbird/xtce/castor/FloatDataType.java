/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * Contains a floating point value
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class FloatDataType extends org.hbird.xtce.castor.NumericDataType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _initialValue.
     */
    private java.math.BigDecimal _initialValue;

    /**
     * Field _sizeInBits.
     */
    private org.hbird.xtce.castor.types.FloatDataTypeSizeInBitsType _sizeInBits = org.hbird.xtce.castor.types.FloatDataTypeSizeInBitsType.fromValue("32");


      //----------------/
     //- Constructors -/
    //----------------/

    public FloatDataType() {
        super();
        setSizeInBits(org.hbird.xtce.castor.types.FloatDataTypeSizeInBitsType.fromValue("32"));
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'initialValue'.
     * 
     * @return the value of field 'InitialValue'.
     */
    public java.math.BigDecimal getInitialValue(
    ) {
        return this._initialValue;
    }

    /**
     * Returns the value of field 'sizeInBits'.
     * 
     * @return the value of field 'SizeInBits'.
     */
    public org.hbird.xtce.castor.types.FloatDataTypeSizeInBitsType getSizeInBits(
    ) {
        return this._sizeInBits;
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
     * Sets the value of field 'initialValue'.
     * 
     * @param initialValue the value of field 'initialValue'.
     */
    public void setInitialValue(
            final java.math.BigDecimal initialValue) {
        this._initialValue = initialValue;
    }

    /**
     * Sets the value of field 'sizeInBits'.
     * 
     * @param sizeInBits the value of field 'sizeInBits'.
     */
    public void setSizeInBits(
            final org.hbird.xtce.castor.types.FloatDataTypeSizeInBitsType sizeInBits) {
        this._sizeInBits = sizeInBits;
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
     * org.hbird.xtce.castor.FloatDataType
     */
    public static org.hbird.xtce.castor.FloatDataType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.FloatDataType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.FloatDataType.class, reader);
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
