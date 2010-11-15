/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Class FixedValueEntry.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class FixedValueEntry extends com.logica.hummingbird.xtce.castor.SequenceEntryType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _binaryValue.
     */
    private byte[] _binaryValue;

    /**
     * Field _sizeInBits.
     */
    private long _sizeInBits;

    /**
     * keeps track of state for field: _sizeInBits
     */
    private boolean _has_sizeInBits;


      //----------------/
     //- Constructors -/
    //----------------/

    public FixedValueEntry() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteSizeInBits(
    ) {
        this._has_sizeInBits= false;
    }

    /**
     * Returns the value of field 'binaryValue'.
     * 
     * @return the value of field 'BinaryValue'.
     */
    public byte[] getBinaryValue(
    ) {
        return this._binaryValue;
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
     * Method hasSizeInBits.
     * 
     * @return true if at least one SizeInBits has been added
     */
    public boolean hasSizeInBits(
    ) {
        return this._has_sizeInBits;
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
     * Sets the value of field 'binaryValue'.
     * 
     * @param binaryValue the value of field 'binaryValue'.
     */
    public void setBinaryValue(
            final byte[] binaryValue) {
        this._binaryValue = binaryValue;
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
     * com.logica.hummingbird.xtce.castor.FixedValueEntry
     */
    public static com.logica.hummingbird.xtce.castor.FixedValueEntry unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.FixedValueEntry) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.FixedValueEntry.class, reader);
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
