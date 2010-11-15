/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * Class BaseContainer.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CommandContainerTypeBaseContainer implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _containerRef.
     */
    private java.lang.String _containerRef;

    /**
     * Given that this Container is the Base container type,
     * RestrictionCriteria lists conditions that must be true for
     * this Container to be 'this' subContainer type. May be a
     * simple Comparison List, a Boolean Expression, and/or in a
     * Graph of containers established by the NextContainer
     */
    private org.hbird.xtce.castor.CommandContainerTypeBaseContainerRestrictionCriteria _restrictionCriteria;


      //----------------/
     //- Constructors -/
    //----------------/

    public CommandContainerTypeBaseContainer() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'containerRef'.
     * 
     * @return the value of field 'ContainerRef'.
     */
    public java.lang.String getContainerRef(
    ) {
        return this._containerRef;
    }

    /**
     * Returns the value of field 'restrictionCriteria'. The field
     * 'restrictionCriteria' has the following description: Given
     * that this Container is the Base container type,
     * RestrictionCriteria lists conditions that must be true for
     * this Container to be 'this' subContainer type. May be a
     * simple Comparison List, a Boolean Expression, and/or in a
     * Graph of containers established by the NextContainer
     * 
     * @return the value of field 'RestrictionCriteria'.
     */
    public org.hbird.xtce.castor.CommandContainerTypeBaseContainerRestrictionCriteria getRestrictionCriteria(
    ) {
        return this._restrictionCriteria;
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
     * Sets the value of field 'containerRef'.
     * 
     * @param containerRef the value of field 'containerRef'.
     */
    public void setContainerRef(
            final java.lang.String containerRef) {
        this._containerRef = containerRef;
    }

    /**
     * Sets the value of field 'restrictionCriteria'. The field
     * 'restrictionCriteria' has the following description: Given
     * that this Container is the Base container type,
     * RestrictionCriteria lists conditions that must be true for
     * this Container to be 'this' subContainer type. May be a
     * simple Comparison List, a Boolean Expression, and/or in a
     * Graph of containers established by the NextContainer
     * 
     * @param restrictionCriteria the value of field
     * 'restrictionCriteria'.
     */
    public void setRestrictionCriteria(
            final org.hbird.xtce.castor.CommandContainerTypeBaseContainerRestrictionCriteria restrictionCriteria) {
        this._restrictionCriteria = restrictionCriteria;
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
     * org.hbird.xtce.castor.CommandContainerTypeBaseContainer
     */
    public static org.hbird.xtce.castor.CommandContainerTypeBaseContainer unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.CommandContainerTypeBaseContainer) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.CommandContainerTypeBaseContainer.class, reader);
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
