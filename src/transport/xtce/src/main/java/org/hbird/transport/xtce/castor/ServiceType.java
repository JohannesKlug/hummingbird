/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * Holds a set of services, logical groups of containers OR
 * messages (not both).
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ServiceType extends org.hbird.transport.xtce.castor.NameDescriptionType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _messageRefSet.
     */
    private org.hbird.transport.xtce.castor.MessageRefSet _messageRefSet;

    /**
     * Field _containerRefSet.
     */
    private org.hbird.transport.xtce.castor.ContainerRefSet _containerRefSet;


      //----------------/
     //- Constructors -/
    //----------------/

    public ServiceType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'containerRefSet'.
     * 
     * @return the value of field 'ContainerRefSet'.
     */
    public org.hbird.transport.xtce.castor.ContainerRefSet getContainerRefSet(
    ) {
        return this._containerRefSet;
    }

    /**
     * Returns the value of field 'messageRefSet'.
     * 
     * @return the value of field 'MessageRefSet'.
     */
    public org.hbird.transport.xtce.castor.MessageRefSet getMessageRefSet(
    ) {
        return this._messageRefSet;
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
     * Sets the value of field 'containerRefSet'.
     * 
     * @param containerRefSet the value of field 'containerRefSet'.
     */
    public void setContainerRefSet(
            final org.hbird.transport.xtce.castor.ContainerRefSet containerRefSet) {
        this._containerRefSet = containerRefSet;
    }

    /**
     * Sets the value of field 'messageRefSet'.
     * 
     * @param messageRefSet the value of field 'messageRefSet'.
     */
    public void setMessageRefSet(
            final org.hbird.transport.xtce.castor.MessageRefSet messageRefSet) {
        this._messageRefSet = messageRefSet;
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
     * org.hbird.xtce.castor.ServiceType
     */
    public static org.hbird.transport.xtce.castor.ServiceType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.ServiceType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.ServiceType.class, reader);
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
