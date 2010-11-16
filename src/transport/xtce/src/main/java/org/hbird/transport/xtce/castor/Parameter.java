/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Parameter extends org.hbird.transport.xtce.castor.NameDescriptionType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _parameterTypeRef.
     */
    private java.lang.String _parameterTypeRef;

    /**
     * Field _parameterProperties.
     */
    private org.hbird.transport.xtce.castor.ParameterProperties _parameterProperties;


      //----------------/
     //- Constructors -/
    //----------------/

    public Parameter() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'parameterProperties'.
     * 
     * @return the value of field 'ParameterProperties'.
     */
    public org.hbird.transport.xtce.castor.ParameterProperties getParameterProperties(
    ) {
        return this._parameterProperties;
    }

    /**
     * Returns the value of field 'parameterTypeRef'.
     * 
     * @return the value of field 'ParameterTypeRef'.
     */
    public java.lang.String getParameterTypeRef(
    ) {
        return this._parameterTypeRef;
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
     * Sets the value of field 'parameterProperties'.
     * 
     * @param parameterProperties the value of field
     * 'parameterProperties'.
     */
    public void setParameterProperties(
            final org.hbird.transport.xtce.castor.ParameterProperties parameterProperties) {
        this._parameterProperties = parameterProperties;
    }

    /**
     * Sets the value of field 'parameterTypeRef'.
     * 
     * @param parameterTypeRef the value of field 'parameterTypeRef'
     */
    public void setParameterTypeRef(
            final java.lang.String parameterTypeRef) {
        this._parameterTypeRef = parameterTypeRef;
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
     * org.hbird.xtce.castor.Parameter
     */
    public static org.hbird.transport.xtce.castor.Parameter unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.Parameter) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.Parameter.class, reader);
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
