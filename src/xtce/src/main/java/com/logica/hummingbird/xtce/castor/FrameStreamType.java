/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * The top level type definition for all data streams that are
 * frame based.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class FrameStreamType extends com.logica.hummingbird.xtce.castor.PCMStreamType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _frameStreamTypeChoice.
     */
    private com.logica.hummingbird.xtce.castor.FrameStreamTypeChoice _frameStreamTypeChoice;

    /**
     * This is a reference to a connecting stream - say a custom
     * stream.
     */
    private com.logica.hummingbird.xtce.castor.StreamRef _streamRef;


      //----------------/
     //- Constructors -/
    //----------------/

    public FrameStreamType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'frameStreamTypeChoice'.
     * 
     * @return the value of field 'FrameStreamTypeChoice'.
     */
    public com.logica.hummingbird.xtce.castor.FrameStreamTypeChoice getFrameStreamTypeChoice(
    ) {
        return this._frameStreamTypeChoice;
    }

    /**
     * Returns the value of field 'streamRef'. The field
     * 'streamRef' has the following description: This is a
     * reference to a connecting stream - say a custom stream.
     * 
     * @return the value of field 'StreamRef'.
     */
    public com.logica.hummingbird.xtce.castor.StreamRef getStreamRef(
    ) {
        return this._streamRef;
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
     * Sets the value of field 'frameStreamTypeChoice'.
     * 
     * @param frameStreamTypeChoice the value of field
     * 'frameStreamTypeChoice'.
     */
    public void setFrameStreamTypeChoice(
            final com.logica.hummingbird.xtce.castor.FrameStreamTypeChoice frameStreamTypeChoice) {
        this._frameStreamTypeChoice = frameStreamTypeChoice;
    }

    /**
     * Sets the value of field 'streamRef'. The field 'streamRef'
     * has the following description: This is a reference to a
     * connecting stream - say a custom stream.
     * 
     * @param streamRef the value of field 'streamRef'.
     */
    public void setStreamRef(
            final com.logica.hummingbird.xtce.castor.StreamRef streamRef) {
        this._streamRef = streamRef;
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
     * com.logica.hummingbird.xtce.castor.FrameStreamType
     */
    public static com.logica.hummingbird.xtce.castor.FrameStreamType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.FrameStreamType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.FrameStreamType.class, reader);
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
