/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * Contains an integral value
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class IntegerDataType extends org.hbird.xtce.castor.NumericDataType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * base 10 integer value
     */
    private long _initialValue;

    /**
     * keeps track of state for field: _initialValue
     */
    private boolean _has_initialValue;

    /**
     * Field _sizeInBits.
     */
    private long _sizeInBits = 32;

    /**
     * keeps track of state for field: _sizeInBits
     */
    private boolean _has_sizeInBits;

    /**
     * Field _signed.
     */
    private boolean _signed = true;

    /**
     * keeps track of state for field: _signed
     */
    private boolean _has_signed;


      //----------------/
     //- Constructors -/
    //----------------/

    public IntegerDataType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteInitialValue(
    ) {
        this._has_initialValue= false;
    }

    /**
     */
    public void deleteSigned(
    ) {
        this._has_signed= false;
    }

    /**
     */
    public void deleteSizeInBits(
    ) {
        this._has_sizeInBits= false;
    }

    /**
     * Returns the value of field 'initialValue'. The field
     * 'initialValue' has the following description: base 10
     * integer value
     * 
     * @return the value of field 'InitialValue'.
     */
    public long getInitialValue(
    ) {
        return this._initialValue;
    }

    /**
     * Returns the value of field 'signed'.
     * 
     * @return the value of field 'Signed'.
     */
    public boolean getSigned(
    ) {
        return this._signed;
    }

    /**
     * Returns the value of field 'sizeInBits'.
     * 
     * @return the value of field 'SizeInBits'.
     */
    public long getSizeInBits(
    ) {
        return this._sizeInBits;
    }

    /**
     * Method hasInitialValue.
     * 
     * @return true if at least one InitialValue has been added
     */
    public boolean hasInitialValue(
    ) {
        return this._has_initialValue;
    }

    /**
     * Method hasSigned.
     * 
     * @return true if at least one Signed has been added
     */
    public boolean hasSigned(
    ) {
        return this._has_signed;
    }

    /**
     * Method hasSizeInBits.
     * 
     * @return true if at least one SizeInBits has been added
     */
    public boolean hasSizeInBits(
    ) {
        return this._has_sizeInBits;
    }

    /**
     * Returns the value of field 'signed'.
     * 
     * @return the value of field 'Signed'.
     */
    public boolean isSigned(
    ) {
        return this._signed;
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
     * Sets the value of field 'initialValue'. The field
     * 'initialValue' has the following description: base 10
     * integer value
     * 
     * @param initialValue the value of field 'initialValue'.
     */
    public void setInitialValue(
            final long initialValue) {
        this._initialValue = initialValue;
        this._has_initialValue = true;
    }

    /**
     * Sets the value of field 'signed'.
     * 
     * @param signed the value of field 'signed'.
     */
    public void setSigned(
            final boolean signed) {
        this._signed = signed;
        this._has_signed = true;
    }

    /**
     * Sets the value of field 'sizeInBits'.
     * 
     * @param sizeInBits the value of field 'sizeInBits'.
     */
    public void setSizeInBits(
            final long sizeInBits) {
        this._sizeInBits = sizeInBits;
        this._has_sizeInBits = true;
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
     * org.hbird.xtce.castor.IntegerDataType
     */
    public static org.hbird.xtce.castor.IntegerDataType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.IntegerDataType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.IntegerDataType.class, reader);
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
