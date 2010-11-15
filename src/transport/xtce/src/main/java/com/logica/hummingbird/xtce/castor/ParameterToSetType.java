/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Used by Meta Command to indicate ground Parameters that should
 * be set after completion of a command. 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ParameterToSetType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _parameterRef.
     */
    private com.logica.hummingbird.xtce.castor.ParameterRef _parameterRef;

    /**
     * Field _derivation.
     */
    private com.logica.hummingbird.xtce.castor.Derivation _derivation;


      //----------------/
     //- Constructors -/
    //----------------/

    public ParameterToSetType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'derivation'.
     * 
     * @return the value of field 'Derivation'.
     */
    public com.logica.hummingbird.xtce.castor.Derivation getDerivation(
    ) {
        return this._derivation;
    }

    /**
     * Returns the value of field 'parameterRef'.
     * 
     * @return the value of field 'ParameterRef'.
     */
    public com.logica.hummingbird.xtce.castor.ParameterRef getParameterRef(
    ) {
        return this._parameterRef;
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
     * Sets the value of field 'derivation'.
     * 
     * @param derivation the value of field 'derivation'.
     */
    public void setDerivation(
            final com.logica.hummingbird.xtce.castor.Derivation derivation) {
        this._derivation = derivation;
    }

    /**
     * Sets the value of field 'parameterRef'.
     * 
     * @param parameterRef the value of field 'parameterRef'.
     */
    public void setParameterRef(
            final com.logica.hummingbird.xtce.castor.ParameterRef parameterRef) {
        this._parameterRef = parameterRef;
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
     * com.logica.hummingbird.xtce.castor.ParameterToSetType
     */
    public static com.logica.hummingbird.xtce.castor.ParameterToSetType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.ParameterToSetType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.ParameterToSetType.class, reader);
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
