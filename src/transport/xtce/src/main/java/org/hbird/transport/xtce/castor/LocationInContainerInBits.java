/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * If no LocationInContainer value is given, the entry is assumed
 * to begin immediately after the previous entry.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class LocationInContainerInBits extends org.hbird.transport.xtce.castor.IntegerValueType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The location may be relative to the start of the container
     * (containerStart), relatitive to the end of the previous
     * entry (previousEntry), relative to the end of the container
     * (containerEnd), or relative to the entry that follows this
     * one (nextEntry). If going forward (containerStart and
     * previousEntry) then, then the location refers to the start
     * of the Entry. If going backwards (containerEnd and
     * nextEntry) then, the location refers to the end of the entry.
     */
    private org.hbird.transport.xtce.castor.types.LocationInContainerInBitsReferenceLocationType _referenceLocation = org.hbird.transport.xtce.castor.types.LocationInContainerInBitsReferenceLocationType.fromValue("previousEntry");


      //----------------/
     //- Constructors -/
    //----------------/

    public LocationInContainerInBits() {
        super();
        setReferenceLocation(org.hbird.transport.xtce.castor.types.LocationInContainerInBitsReferenceLocationType.fromValue("previousEntry"));
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'referenceLocation'. The field
     * 'referenceLocation' has the following description: The
     * location may be relative to the start of the container
     * (containerStart), relatitive to the end of the previous
     * entry (previousEntry), relative to the end of the container
     * (containerEnd), or relative to the entry that follows this
     * one (nextEntry). If going forward (containerStart and
     * previousEntry) then, then the location refers to the start
     * of the Entry. If going backwards (containerEnd and
     * nextEntry) then, the location refers to the end of the
     * entry.
     * 
     * @return the value of field 'ReferenceLocation'.
     */
    public org.hbird.transport.xtce.castor.types.LocationInContainerInBitsReferenceLocationType getReferenceLocation(
    ) {
        return this._referenceLocation;
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
     * Sets the value of field 'referenceLocation'. The field
     * 'referenceLocation' has the following description: The
     * location may be relative to the start of the container
     * (containerStart), relatitive to the end of the previous
     * entry (previousEntry), relative to the end of the container
     * (containerEnd), or relative to the entry that follows this
     * one (nextEntry). If going forward (containerStart and
     * previousEntry) then, then the location refers to the start
     * of the Entry. If going backwards (containerEnd and
     * nextEntry) then, the location refers to the end of the
     * entry.
     * 
     * @param referenceLocation the value of field
     * 'referenceLocation'.
     */
    public void setReferenceLocation(
            final org.hbird.transport.xtce.castor.types.LocationInContainerInBitsReferenceLocationType referenceLocation) {
        this._referenceLocation = referenceLocation;
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
     * org.hbird.xtce.castor.LocationInContainerInBits
     */
    public static org.hbird.transport.xtce.castor.LocationInContainerInBits unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.LocationInContainerInBits) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.LocationInContainerInBits.class, reader);
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
