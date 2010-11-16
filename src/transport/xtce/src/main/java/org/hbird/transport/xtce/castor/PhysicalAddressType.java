/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * When it's important to know the physical address(s) on the
 * spacecraft that this parameter may be collected from, use this. 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PhysicalAddressType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _sourceName.
     */
    private java.lang.String _sourceName;

    /**
     * Field _sourceAddress.
     */
    private java.lang.String _sourceAddress;

    /**
     * Field _subAddress.
     */
    private org.hbird.transport.xtce.castor.SubAddress _subAddress;


      //----------------/
     //- Constructors -/
    //----------------/

    public PhysicalAddressType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'sourceAddress'.
     * 
     * @return the value of field 'SourceAddress'.
     */
    public java.lang.String getSourceAddress(
    ) {
        return this._sourceAddress;
    }

    /**
     * Returns the value of field 'sourceName'.
     * 
     * @return the value of field 'SourceName'.
     */
    public java.lang.String getSourceName(
    ) {
        return this._sourceName;
    }

    /**
     * Returns the value of field 'subAddress'.
     * 
     * @return the value of field 'SubAddress'.
     */
    public org.hbird.transport.xtce.castor.SubAddress getSubAddress(
    ) {
        return this._subAddress;
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
     * Sets the value of field 'sourceAddress'.
     * 
     * @param sourceAddress the value of field 'sourceAddress'.
     */
    public void setSourceAddress(
            final java.lang.String sourceAddress) {
        this._sourceAddress = sourceAddress;
    }

    /**
     * Sets the value of field 'sourceName'.
     * 
     * @param sourceName the value of field 'sourceName'.
     */
    public void setSourceName(
            final java.lang.String sourceName) {
        this._sourceName = sourceName;
    }

    /**
     * Sets the value of field 'subAddress'.
     * 
     * @param subAddress the value of field 'subAddress'.
     */
    public void setSubAddress(
            final org.hbird.transport.xtce.castor.SubAddress subAddress) {
        this._subAddress = subAddress;
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
     * org.hbird.xtce.castor.PhysicalAddressType
     */
    public static org.hbird.transport.xtce.castor.PhysicalAddressType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.PhysicalAddressType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.PhysicalAddressType.class, reader);
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
