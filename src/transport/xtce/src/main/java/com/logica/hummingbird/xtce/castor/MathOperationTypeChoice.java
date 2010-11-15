/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * Class MathOperationTypeChoice.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class MathOperationTypeChoice implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _parameterInstanceRef.
     */
    private org.hbird.xtce.castor.ParameterInstanceRef _parameterInstanceRef;

    /**
     * Value is assumed to be of the same type as the Parameter
     */
    private java.lang.String _value;


      //----------------/
     //- Constructors -/
    //----------------/

    public MathOperationTypeChoice() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'parameterInstanceRef'.
     * 
     * @return the value of field 'ParameterInstanceRef'.
     */
    public org.hbird.xtce.castor.ParameterInstanceRef getParameterInstanceRef(
    ) {
        return this._parameterInstanceRef;
    }

    /**
     * Returns the value of field 'value'. The field 'value' has
     * the following description: Value is assumed to be of the
     * same type as the Parameter
     * 
     * @return the value of field 'Value'.
     */
    public java.lang.String getValue(
    ) {
        return this._value;
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
     * Sets the value of field 'parameterInstanceRef'.
     * 
     * @param parameterInstanceRef the value of field
     * 'parameterInstanceRef'.
     */
    public void setParameterInstanceRef(
            final org.hbird.xtce.castor.ParameterInstanceRef parameterInstanceRef) {
        this._parameterInstanceRef = parameterInstanceRef;
    }

    /**
     * Sets the value of field 'value'. The field 'value' has the
     * following description: Value is assumed to be of the same
     * type as the Parameter
     * 
     * @param value the value of field 'value'.
     */
    public void setValue(
            final java.lang.String value) {
        this._value = value;
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
     * org.hbird.xtce.castor.MathOperationTypeChoice
     */
    public static org.hbird.xtce.castor.MathOperationTypeChoice unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.MathOperationTypeChoice) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.MathOperationTypeChoice.class, reader);
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
