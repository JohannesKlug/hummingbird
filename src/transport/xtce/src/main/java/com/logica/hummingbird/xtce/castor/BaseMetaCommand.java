/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * The MetaCommand is derived from this Base. Arguments of the base
 * MetaCommand are further specified.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class BaseMetaCommand implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _metaCommandRef.
     */
    private java.lang.String _metaCommandRef;

    /**
     * Field _argumentAssignmentList.
     */
    private com.logica.hummingbird.xtce.castor.ArgumentAssignmentList _argumentAssignmentList;


      //----------------/
     //- Constructors -/
    //----------------/

    public BaseMetaCommand() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'argumentAssignmentList'.
     * 
     * @return the value of field 'ArgumentAssignmentList'.
     */
    public com.logica.hummingbird.xtce.castor.ArgumentAssignmentList getArgumentAssignmentList(
    ) {
        return this._argumentAssignmentList;
    }

    /**
     * Returns the value of field 'metaCommandRef'.
     * 
     * @return the value of field 'MetaCommandRef'.
     */
    public java.lang.String getMetaCommandRef(
    ) {
        return this._metaCommandRef;
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
     * Sets the value of field 'argumentAssignmentList'.
     * 
     * @param argumentAssignmentList the value of field
     * 'argumentAssignmentList'.
     */
    public void setArgumentAssignmentList(
            final com.logica.hummingbird.xtce.castor.ArgumentAssignmentList argumentAssignmentList) {
        this._argumentAssignmentList = argumentAssignmentList;
    }

    /**
     * Sets the value of field 'metaCommandRef'.
     * 
     * @param metaCommandRef the value of field 'metaCommandRef'.
     */
    public void setMetaCommandRef(
            final java.lang.String metaCommandRef) {
        this._metaCommandRef = metaCommandRef;
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
     * com.logica.hummingbird.xtce.castor.BaseMetaCommand
     */
    public static com.logica.hummingbird.xtce.castor.BaseMetaCommand unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.BaseMetaCommand) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.BaseMetaCommand.class, reader);
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
