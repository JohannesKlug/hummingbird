/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * Class FrameStreamTypeChoice.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class FrameStreamTypeChoice implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * This Container (usually abstract) is the container that is
     * in the fixed frame stream. Normally, this is an
     * generalcontainer type from which many specific containers
     * are inherited.
     */
    private org.hbird.xtce.castor.ContainerRef _containerRef;

    /**
     * Field _serviceRef.
     */
    private org.hbird.xtce.castor.ServiceRef _serviceRef;


      //----------------/
     //- Constructors -/
    //----------------/

    public FrameStreamTypeChoice() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'containerRef'. The field
     * 'containerRef' has the following description: This Container
     * (usually abstract) is the container that is in the fixed
     * frame stream. Normally, this is an generalcontainer type
     * from which many specific containers are inherited.
     * 
     * @return the value of field 'ContainerRef'.
     */
    public org.hbird.xtce.castor.ContainerRef getContainerRef(
    ) {
        return this._containerRef;
    }

    /**
     * Returns the value of field 'serviceRef'.
     * 
     * @return the value of field 'ServiceRef'.
     */
    public org.hbird.xtce.castor.ServiceRef getServiceRef(
    ) {
        return this._serviceRef;
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
     * Sets the value of field 'containerRef'. The field
     * 'containerRef' has the following description: This Container
     * (usually abstract) is the container that is in the fixed
     * frame stream. Normally, this is an generalcontainer type
     * from which many specific containers are inherited.
     * 
     * @param containerRef the value of field 'containerRef'.
     */
    public void setContainerRef(
            final org.hbird.xtce.castor.ContainerRef containerRef) {
        this._containerRef = containerRef;
    }

    /**
     * Sets the value of field 'serviceRef'.
     * 
     * @param serviceRef the value of field 'serviceRef'.
     */
    public void setServiceRef(
            final org.hbird.xtce.castor.ServiceRef serviceRef) {
        this._serviceRef = serviceRef;
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
     * org.hbird.xtce.castor.FrameStreamTypeChoice
     */
    public static org.hbird.xtce.castor.FrameStreamTypeChoice unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.FrameStreamTypeChoice) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.FrameStreamTypeChoice.class, reader);
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
