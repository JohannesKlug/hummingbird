/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Defaults has default data encoding for ParameterTypes and
 * ArgumentTypes and default parameter time association that will
 * be applied to all Parameters within this SpaceSystem. These
 * defaults may be overidden by sub-SpaceSystems or by the Types or
 * Parameters themselves. Defaults simply provides a means to avoid
 * repeating attributes such as ‘bit order’ for every Type
 * definition.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Defaults implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Since the data encoding (bit order and byte order) is
     * normally the same throughout a spacesystem, using this
     * element allows that data encoding to be specified as a
     * default.
     */
    private com.logica.hummingbird.xtce.castor.DefaultDataEncoding _defaultDataEncoding;

    /**
     * Default time to associate each ParameterInstance with.
     */
    private com.logica.hummingbird.xtce.castor.ParameterTimeAssociation _parameterTimeAssociation;


      //----------------/
     //- Constructors -/
    //----------------/

    public Defaults() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'defaultDataEncoding'. The field
     * 'defaultDataEncoding' has the following description: Since
     * the data encoding (bit order and byte order) is normally the
     * same throughout a spacesystem, using this element allows
     * that data encoding to be specified as a default.
     * 
     * @return the value of field 'DefaultDataEncoding'.
     */
    public com.logica.hummingbird.xtce.castor.DefaultDataEncoding getDefaultDataEncoding(
    ) {
        return this._defaultDataEncoding;
    }

    /**
     * Returns the value of field 'parameterTimeAssociation'. The
     * field 'parameterTimeAssociation' has the following
     * description: Default time to associate each
     * ParameterInstance with.
     * 
     * @return the value of field 'ParameterTimeAssociation'.
     */
    public com.logica.hummingbird.xtce.castor.ParameterTimeAssociation getParameterTimeAssociation(
    ) {
        return this._parameterTimeAssociation;
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
     * Sets the value of field 'defaultDataEncoding'. The field
     * 'defaultDataEncoding' has the following description: Since
     * the data encoding (bit order and byte order) is normally the
     * same throughout a spacesystem, using this element allows
     * that data encoding to be specified as a default.
     * 
     * @param defaultDataEncoding the value of field
     * 'defaultDataEncoding'.
     */
    public void setDefaultDataEncoding(
            final com.logica.hummingbird.xtce.castor.DefaultDataEncoding defaultDataEncoding) {
        this._defaultDataEncoding = defaultDataEncoding;
    }

    /**
     * Sets the value of field 'parameterTimeAssociation'. The
     * field 'parameterTimeAssociation' has the following
     * description: Default time to associate each
     * ParameterInstance with.
     * 
     * @param parameterTimeAssociation the value of field
     * 'parameterTimeAssociation'.
     */
    public void setParameterTimeAssociation(
            final com.logica.hummingbird.xtce.castor.ParameterTimeAssociation parameterTimeAssociation) {
        this._parameterTimeAssociation = parameterTimeAssociation;
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
     * com.logica.hummingbird.xtce.castor.Defaults
     */
    public static com.logica.hummingbird.xtce.castor.Defaults unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.Defaults) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.Defaults.class, reader);
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
