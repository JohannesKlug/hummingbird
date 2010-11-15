/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * An entry whose name is given by the value of a
 * ParamameterInstance. This entry may be used to implement dwell
 * telemetry streams. The value of the parameter in
 * ParameterInstance must use either the name of the Parameter or
 * its alias. If it's an alias name, the alias namespace is
 * supplied as an attribute.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class IndirectParameterRefEntryType extends com.logica.hummingbird.xtce.castor.SequenceEntryType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _aliasNameSpace.
     */
    private java.lang.String _aliasNameSpace;

    /**
     * Field _parameterInstance.
     */
    private com.logica.hummingbird.xtce.castor.ParameterInstance _parameterInstance;


      //----------------/
     //- Constructors -/
    //----------------/

    public IndirectParameterRefEntryType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'aliasNameSpace'.
     * 
     * @return the value of field 'AliasNameSpace'.
     */
    public java.lang.String getAliasNameSpace(
    ) {
        return this._aliasNameSpace;
    }

    /**
     * Returns the value of field 'parameterInstance'.
     * 
     * @return the value of field 'ParameterInstance'.
     */
    public com.logica.hummingbird.xtce.castor.ParameterInstance getParameterInstance(
    ) {
        return this._parameterInstance;
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
     * Sets the value of field 'aliasNameSpace'.
     * 
     * @param aliasNameSpace the value of field 'aliasNameSpace'.
     */
    public void setAliasNameSpace(
            final java.lang.String aliasNameSpace) {
        this._aliasNameSpace = aliasNameSpace;
    }

    /**
     * Sets the value of field 'parameterInstance'.
     * 
     * @param parameterInstance the value of field
     * 'parameterInstance'.
     */
    public void setParameterInstance(
            final com.logica.hummingbird.xtce.castor.ParameterInstance parameterInstance) {
        this._parameterInstance = parameterInstance;
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
     * com.logica.hummingbird.xtce.castor.IndirectParameterRefEntryType
     */
    public static com.logica.hummingbird.xtce.castor.IndirectParameterRefEntryType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.IndirectParameterRefEntryType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.IndirectParameterRefEntryType.class, reader);
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
