/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * A reference to an instance of a Parameter. Used when the value
 * of a parameter is required for a calculation or as an index
 * value. A positive value for instance is forward in time, a
 * negative value for count is backward in time, a 0 value for
 * count means use the current value of the parameter or the first
 * value in a container.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ParameterInstanceRefType extends org.hbird.xtce.castor.ParameterRefType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * internal content storage
     */
    private java.lang.String _content = "";

    /**
     * Field _instance.
     */
    private long _instance = 0;

    /**
     * keeps track of state for field: _instance
     */
    private boolean _has_instance;

    /**
     * Field _useCalibratedValue.
     */
    private boolean _useCalibratedValue = true;

    /**
     * keeps track of state for field: _useCalibratedValue
     */
    private boolean _has_useCalibratedValue;


      //----------------/
     //- Constructors -/
    //----------------/

    public ParameterInstanceRefType() {
        super();
        setContent("");
    }

    public ParameterInstanceRefType(final java.lang.String defaultValue) {
        try {
            setContent( new java.lang.String(defaultValue));
         } catch(Exception e) {
            throw new RuntimeException("Unable to cast default value for simple content!");
         } 
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteInstance(
    ) {
        this._has_instance= false;
    }

    /**
     */
    public void deleteUseCalibratedValue(
    ) {
        this._has_useCalibratedValue= false;
    }

    /**
     * Returns the value of field 'content'. The field 'content'
     * has the following description: internal content storage
     * 
     * @return the value of field 'Content'.
     */
    public java.lang.String getContent(
    ) {
        return this._content;
    }

    /**
     * Returns the value of field 'instance'.
     * 
     * @return the value of field 'Instance'.
     */
    public long getInstance(
    ) {
        return this._instance;
    }

    /**
     * Returns the value of field 'useCalibratedValue'.
     * 
     * @return the value of field 'UseCalibratedValue'.
     */
    public boolean getUseCalibratedValue(
    ) {
        return this._useCalibratedValue;
    }

    /**
     * Method hasInstance.
     * 
     * @return true if at least one Instance has been added
     */
    public boolean hasInstance(
    ) {
        return this._has_instance;
    }

    /**
     * Method hasUseCalibratedValue.
     * 
     * @return true if at least one UseCalibratedValue has been adde
     */
    public boolean hasUseCalibratedValue(
    ) {
        return this._has_useCalibratedValue;
    }

    /**
     * Returns the value of field 'useCalibratedValue'.
     * 
     * @return the value of field 'UseCalibratedValue'.
     */
    public boolean isUseCalibratedValue(
    ) {
        return this._useCalibratedValue;
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
     * Sets the value of field 'content'. The field 'content' has
     * the following description: internal content storage
     * 
     * @param content the value of field 'content'.
     */
    public void setContent(
            final java.lang.String content) {
        this._content = content;
    }

    /**
     * Sets the value of field 'instance'.
     * 
     * @param instance the value of field 'instance'.
     */
    public void setInstance(
            final long instance) {
        this._instance = instance;
        this._has_instance = true;
    }

    /**
     * Sets the value of field 'useCalibratedValue'.
     * 
     * @param useCalibratedValue the value of field
     * 'useCalibratedValue'.
     */
    public void setUseCalibratedValue(
            final boolean useCalibratedValue) {
        this._useCalibratedValue = useCalibratedValue;
        this._has_useCalibratedValue = true;
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
     * org.hbird.xtce.castor.ParameterInstanceRefType
     */
    public static org.hbird.xtce.castor.ParameterInstanceRefType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.ParameterInstanceRefType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.ParameterInstanceRefType.class, reader);
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
