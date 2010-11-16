/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * Class BaseTimeDataTypeSequence.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class BaseTimeDataTypeSequence implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Scale and offset are used in a y =mx +b type relationship (m
     * is the scale and b is the offset) to make adjustmets to the
     * encoded value to that it matches the time units. Binary
     * Encoded time is typically used with a user supplied
     * transform algorithm to convert time data formats that are
     * too difficult to describe in XTCE.
     */
    private org.hbird.transport.xtce.castor.Encoding _encoding;


      //----------------/
     //- Constructors -/
    //----------------/

    public BaseTimeDataTypeSequence() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'encoding'. The field 'encoding'
     * has the following description: Scale and offset are used in
     * a y =mx +b type relationship (m is the scale and b is the
     * offset) to make adjustmets to the encoded value to that it
     * matches the time units. Binary Encoded time is typically
     * used with a user supplied transform algorithm to convert
     * time data formats that are too difficult to describe in
     * XTCE.
     * 
     * @return the value of field 'Encoding'.
     */
    public org.hbird.transport.xtce.castor.Encoding getEncoding(
    ) {
        return this._encoding;
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
     * Sets the value of field 'encoding'. The field 'encoding' has
     * the following description: Scale and offset are used in a y
     * =mx +b type relationship (m is the scale and b is the
     * offset) to make adjustmets to the encoded value to that it
     * matches the time units. Binary Encoded time is typically
     * used with a user supplied transform algorithm to convert
     * time data formats that are too difficult to describe in
     * XTCE.
     * 
     * @param encoding the value of field 'encoding'.
     */
    public void setEncoding(
            final org.hbird.transport.xtce.castor.Encoding encoding) {
        this._encoding = encoding;
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
     * org.hbird.xtce.castor.BaseTimeDataTypeSequence
     */
    public static org.hbird.transport.xtce.castor.BaseTimeDataTypeSequence unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.BaseTimeDataTypeSequence) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.BaseTimeDataTypeSequence.class, reader);
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
