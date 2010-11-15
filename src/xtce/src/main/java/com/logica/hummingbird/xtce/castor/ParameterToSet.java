/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Sets a Parameter to a new value after the command has been
 * verified (all verifications have passed)
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ParameterToSet extends com.logica.hummingbird.xtce.castor.ParameterToSetType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _verifierToTriggerOn.
     */
    private com.logica.hummingbird.xtce.castor.types.ParameterToSetTypeVerifierToTriggerOnType _verifierToTriggerOn = com.logica.hummingbird.xtce.castor.types.ParameterToSetTypeVerifierToTriggerOnType.fromValue("release");


      //----------------/
     //- Constructors -/
    //----------------/

    public ParameterToSet() {
        super();
        setVerifierToTriggerOn(com.logica.hummingbird.xtce.castor.types.ParameterToSetTypeVerifierToTriggerOnType.fromValue("release"));
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'verifierToTriggerOn'.
     * 
     * @return the value of field 'VerifierToTriggerOn'.
     */
    public com.logica.hummingbird.xtce.castor.types.ParameterToSetTypeVerifierToTriggerOnType getVerifierToTriggerOn(
    ) {
        return this._verifierToTriggerOn;
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
     * Sets the value of field 'verifierToTriggerOn'.
     * 
     * @param verifierToTriggerOn the value of field
     * 'verifierToTriggerOn'.
     */
    public void setVerifierToTriggerOn(
            final com.logica.hummingbird.xtce.castor.types.ParameterToSetTypeVerifierToTriggerOnType verifierToTriggerOn) {
        this._verifierToTriggerOn = verifierToTriggerOn;
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
     * com.logica.hummingbird.xtce.castor.ParameterToSet
     */
    public static com.logica.hummingbird.xtce.castor.ParameterToSet unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.ParameterToSet) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.ParameterToSet.class, reader);
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
