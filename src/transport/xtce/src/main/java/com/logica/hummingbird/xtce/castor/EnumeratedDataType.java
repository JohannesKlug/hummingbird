/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Contains an enumerated value - a value that has both an integral
 * and a string representation.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class EnumeratedDataType extends com.logica.hummingbird.xtce.castor.BaseDataType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _initialValue.
     */
    private java.lang.String _initialValue;

    /**
     * Field _enumerationList.
     */
    private com.logica.hummingbird.xtce.castor.EnumerationList _enumerationList;


      //----------------/
     //- Constructors -/
    //----------------/

    public EnumeratedDataType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'enumerationList'.
     * 
     * @return the value of field 'EnumerationList'.
     */
    public com.logica.hummingbird.xtce.castor.EnumerationList getEnumerationList(
    ) {
        return this._enumerationList;
    }

    /**
     * Returns the value of field 'initialValue'.
     * 
     * @return the value of field 'InitialValue'.
     */
    public java.lang.String getInitialValue(
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
     * Sets the value of field 'enumerationList'.
     * 
     * @param enumerationList the value of field 'enumerationList'.
     */
    public void setEnumerationList(
            final com.logica.hummingbird.xtce.castor.EnumerationList enumerationList) {
        this._enumerationList = enumerationList;
    }

    /**
     * Sets the value of field 'initialValue'.
     * 
     * @param initialValue the value of field 'initialValue'.
     */
    public void setInitialValue(
            final java.lang.String initialValue) {
        this._initialValue = initialValue;
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
     * com.logica.hummingbird.xtce.castor.EnumeratedDataType
     */
    public static com.logica.hummingbird.xtce.castor.EnumeratedDataType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.EnumeratedDataType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.EnumeratedDataType.class, reader);
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
