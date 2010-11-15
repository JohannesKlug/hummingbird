/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Contains a boolean value
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class BooleanDataType extends com.logica.hummingbird.xtce.castor.BaseDataType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _initialValue.
     */
    private boolean _initialValue;

    /**
     * keeps track of state for field: _initialValue
     */
    private boolean _has_initialValue;

    /**
     * Field _oneStringValue.
     */
    private java.lang.String _oneStringValue = "True";

    /**
     * Field _zeroStringValue.
     */
    private java.lang.String _zeroStringValue = "False";


      //----------------/
     //- Constructors -/
    //----------------/

    public BooleanDataType() {
        super();
        setOneStringValue("True");
        setZeroStringValue("False");
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteInitialValue(
    ) {
        this._has_initialValue= false;
    }

    /**
     * Returns the value of field 'initialValue'.
     * 
     * @return the value of field 'InitialValue'.
     */
    public boolean getInitialValue(
    ) {
        return this._initialValue;
    }

    /**
     * Returns the value of field 'oneStringValue'.
     * 
     * @return the value of field 'OneStringValue'.
     */
    public java.lang.String getOneStringValue(
    ) {
        return this._oneStringValue;
    }

    /**
     * Returns the value of field 'zeroStringValue'.
     * 
     * @return the value of field 'ZeroStringValue'.
     */
    public java.lang.String getZeroStringValue(
    ) {
        return this._zeroStringValue;
    }

    /**
     * Method hasInitialValue.
     * 
     * @return true if at least one InitialValue has been added
     */
    public boolean hasInitialValue(
    ) {
        return this._has_initialValue;
    }

    /**
     * Returns the value of field 'initialValue'.
     * 
     * @return the value of field 'InitialValue'.
     */
    public boolean isInitialValue(
    ) {
        return this._initialValue;
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
     * Sets the value of field 'initialValue'.
     * 
     * @param initialValue the value of field 'initialValue'.
     */
    public void setInitialValue(
            final boolean initialValue) {
        this._initialValue = initialValue;
        this._has_initialValue = true;
    }

    /**
     * Sets the value of field 'oneStringValue'.
     * 
     * @param oneStringValue the value of field 'oneStringValue'.
     */
    public void setOneStringValue(
            final java.lang.String oneStringValue) {
        this._oneStringValue = oneStringValue;
    }

    /**
     * Sets the value of field 'zeroStringValue'.
     * 
     * @param zeroStringValue the value of field 'zeroStringValue'.
     */
    public void setZeroStringValue(
            final java.lang.String zeroStringValue) {
        this._zeroStringValue = zeroStringValue;
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
     * com.logica.hummingbird.xtce.castor.BooleanDataType
     */
    public static com.logica.hummingbird.xtce.castor.BooleanDataType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.BooleanDataType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.BooleanDataType.class, reader);
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
