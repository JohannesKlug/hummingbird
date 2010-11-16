/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * Bit position starts with 'zero'.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Parity implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _type.
     */
    private org.hbird.transport.xtce.castor.types.ParityTypeType _type;

    /**
     * Field _bitsFromReference.
     */
    private long _bitsFromReference;

    /**
     * keeps track of state for field: _bitsFromReference
     */
    private boolean _has_bitsFromReference;

    /**
     * Field _reference.
     */
    private org.hbird.transport.xtce.castor.types.ParityReferenceType _reference = org.hbird.transport.xtce.castor.types.ParityReferenceType.fromValue("start");


      //----------------/
     //- Constructors -/
    //----------------/

    public Parity() {
        super();
        setReference(org.hbird.transport.xtce.castor.types.ParityReferenceType.fromValue("start"));
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteBitsFromReference(
    ) {
        this._has_bitsFromReference= false;
    }

    /**
     * Returns the value of field 'bitsFromReference'.
     * 
     * @return the value of field 'BitsFromReference'.
     */
    public long getBitsFromReference(
    ) {
        return this._bitsFromReference;
    }

    /**
     * Returns the value of field 'reference'.
     * 
     * @return the value of field 'Reference'.
     */
    public org.hbird.transport.xtce.castor.types.ParityReferenceType getReference(
    ) {
        return this._reference;
    }

    /**
     * Returns the value of field 'type'.
     * 
     * @return the value of field 'Type'.
     */
    public org.hbird.transport.xtce.castor.types.ParityTypeType getType(
    ) {
        return this._type;
    }

    /**
     * Method hasBitsFromReference.
     * 
     * @return true if at least one BitsFromReference has been added
     */
    public boolean hasBitsFromReference(
    ) {
        return this._has_bitsFromReference;
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
     * Sets the value of field 'bitsFromReference'.
     * 
     * @param bitsFromReference the value of field
     * 'bitsFromReference'.
     */
    public void setBitsFromReference(
            final long bitsFromReference) {
        this._bitsFromReference = bitsFromReference;
        this._has_bitsFromReference = true;
    }

    /**
     * Sets the value of field 'reference'.
     * 
     * @param reference the value of field 'reference'.
     */
    public void setReference(
            final org.hbird.transport.xtce.castor.types.ParityReferenceType reference) {
        this._reference = reference;
    }

    /**
     * Sets the value of field 'type'.
     * 
     * @param type the value of field 'type'.
     */
    public void setType(
            final org.hbird.transport.xtce.castor.types.ParityTypeType type) {
        this._type = type;
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
     * org.hbird.xtce.castor.Parity
     */
    public static org.hbird.transport.xtce.castor.Parity unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.Parity) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.Parity.class, reader);
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
