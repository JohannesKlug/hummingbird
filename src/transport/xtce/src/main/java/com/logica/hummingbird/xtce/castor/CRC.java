/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * Cyclic Redundancy Check definition. Legal values for
 * coefficient's are 0 or 1. Exponents must be integer values.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CRC implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

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
    private org.hbird.xtce.castor.types.CRCReferenceType _reference = org.hbird.xtce.castor.types.CRCReferenceType.fromValue("start");

    /**
     * Field _polynomial.
     */
    private org.hbird.xtce.castor.Polynomial _polynomial;


      //----------------/
     //- Constructors -/
    //----------------/

    public CRC() {
        super();
        setReference(org.hbird.xtce.castor.types.CRCReferenceType.fromValue("start"));
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
     * Returns the value of field 'polynomial'.
     * 
     * @return the value of field 'Polynomial'.
     */
    public org.hbird.xtce.castor.Polynomial getPolynomial(
    ) {
        return this._polynomial;
    }

    /**
     * Returns the value of field 'reference'.
     * 
     * @return the value of field 'Reference'.
     */
    public org.hbird.xtce.castor.types.CRCReferenceType getReference(
    ) {
        return this._reference;
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
     * Sets the value of field 'polynomial'.
     * 
     * @param polynomial the value of field 'polynomial'.
     */
    public void setPolynomial(
            final org.hbird.xtce.castor.Polynomial polynomial) {
        this._polynomial = polynomial;
    }

    /**
     * Sets the value of field 'reference'.
     * 
     * @param reference the value of field 'reference'.
     */
    public void setReference(
            final org.hbird.xtce.castor.types.CRCReferenceType reference) {
        this._reference = reference;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled org.hbird.xtce.castor.CR
     */
    public static org.hbird.xtce.castor.CRC unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.CRC) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.CRC.class, reader);
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
