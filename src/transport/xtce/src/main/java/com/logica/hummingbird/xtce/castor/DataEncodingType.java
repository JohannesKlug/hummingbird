/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * Describes how a particular piece of data is sent or received
 * from some non-native, off-platform device. (e.g. a spacecraft)
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class DataEncodingType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _bitOrder.
     */
    private org.hbird.xtce.castor.types.DataEncodingTypeBitOrderType _bitOrder = org.hbird.xtce.castor.types.DataEncodingTypeBitOrderType.fromValue("mostSignificantBitFirst");

    /**
     * Field _errorDetectCorrect.
     */
    private org.hbird.xtce.castor.ErrorDetectCorrect _errorDetectCorrect;

    /**
     * Used to describe an arbitrary byte order in multibyte
     * parameters. First byte in list is the first in the stream.
     * Byte significance is the is highest for most significant
     * bytes. If not included, it is assumed that the most
     * significant byte is first, least significant byte last.
     */
    private org.hbird.xtce.castor.ByteOrderList _byteOrderList;


      //----------------/
     //- Constructors -/
    //----------------/

    public DataEncodingType() {
        super();
        setBitOrder(org.hbird.xtce.castor.types.DataEncodingTypeBitOrderType.fromValue("mostSignificantBitFirst"));
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'bitOrder'.
     * 
     * @return the value of field 'BitOrder'.
     */
    public org.hbird.xtce.castor.types.DataEncodingTypeBitOrderType getBitOrder(
    ) {
        return this._bitOrder;
    }

    /**
     * Returns the value of field 'byteOrderList'. The field
     * 'byteOrderList' has the following description: Used to
     * describe an arbitrary byte order in multibyte parameters.
     * First byte in list is the first in the stream. Byte
     * significance is the is highest for most significant bytes.
     * If not included, it is assumed that the most significant
     * byte is first, least significant byte last.
     * 
     * @return the value of field 'ByteOrderList'.
     */
    public org.hbird.xtce.castor.ByteOrderList getByteOrderList(
    ) {
        return this._byteOrderList;
    }

    /**
     * Returns the value of field 'errorDetectCorrect'.
     * 
     * @return the value of field 'ErrorDetectCorrect'.
     */
    public org.hbird.xtce.castor.ErrorDetectCorrect getErrorDetectCorrect(
    ) {
        return this._errorDetectCorrect;
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
     * Sets the value of field 'bitOrder'.
     * 
     * @param bitOrder the value of field 'bitOrder'.
     */
    public void setBitOrder(
            final org.hbird.xtce.castor.types.DataEncodingTypeBitOrderType bitOrder) {
        this._bitOrder = bitOrder;
    }

    /**
     * Sets the value of field 'byteOrderList'. The field
     * 'byteOrderList' has the following description: Used to
     * describe an arbitrary byte order in multibyte parameters.
     * First byte in list is the first in the stream. Byte
     * significance is the is highest for most significant bytes.
     * If not included, it is assumed that the most significant
     * byte is first, least significant byte last.
     * 
     * @param byteOrderList the value of field 'byteOrderList'.
     */
    public void setByteOrderList(
            final org.hbird.xtce.castor.ByteOrderList byteOrderList) {
        this._byteOrderList = byteOrderList;
    }

    /**
     * Sets the value of field 'errorDetectCorrect'.
     * 
     * @param errorDetectCorrect the value of field
     * 'errorDetectCorrect'.
     */
    public void setErrorDetectCorrect(
            final org.hbird.xtce.castor.ErrorDetectCorrect errorDetectCorrect) {
        this._errorDetectCorrect = errorDetectCorrect;
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
     * org.hbird.xtce.castor.DataEncodingType
     */
    public static org.hbird.xtce.castor.DataEncodingType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.DataEncodingType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.DataEncodingType.class, reader);
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
