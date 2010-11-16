/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * Most time values are relative to another time e.g. seconds are
 * relative to minutes, minutes are relative to hours. This type is
 * used to describe this relationship starting with the least
 * significant time Parameter to and progressing to the most
 * significant time parameter. 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ReferenceTimeType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _offsetFrom.
     */
    private org.hbird.transport.xtce.castor.OffsetFrom _offsetFrom;

    /**
     * Field _epoch.
     */
    private java.lang.String _epoch;


      //----------------/
     //- Constructors -/
    //----------------/

    public ReferenceTimeType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'choiceValue'. The field
     * 'choiceValue' has the following description: Internal choice
     * value storage
     * 
     * @return the value of field 'ChoiceValue'.
     */
    public java.lang.Object getChoiceValue(
    ) {
        return this._choiceValue;
    }

    /**
     * Returns the value of field 'epoch'.
     * 
     * @return the value of field 'Epoch'.
     */
    public java.lang.String getEpoch(
    ) {
        return this._epoch;
    }

    /**
     * Returns the value of field 'offsetFrom'.
     * 
     * @return the value of field 'OffsetFrom'.
     */
    public org.hbird.transport.xtce.castor.OffsetFrom getOffsetFrom(
    ) {
        return this._offsetFrom;
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
     * Sets the value of field 'epoch'.
     * 
     * @param epoch the value of field 'epoch'.
     */
    public void setEpoch(
            final java.lang.String epoch) {
        this._epoch = epoch;
        this._choiceValue = epoch;
    }

    /**
     * Sets the value of field 'offsetFrom'.
     * 
     * @param offsetFrom the value of field 'offsetFrom'.
     */
    public void setOffsetFrom(
            final org.hbird.transport.xtce.castor.OffsetFrom offsetFrom) {
        this._offsetFrom = offsetFrom;
        this._choiceValue = offsetFrom;
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
     * org.hbird.xtce.castor.ReferenceTimeType
     */
    public static org.hbird.transport.xtce.castor.ReferenceTimeType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.ReferenceTimeType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.ReferenceTimeType.class, reader);
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
