/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * For common encodings of floating point data
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class FloatDataEncodingType extends org.hbird.transport.xtce.castor.DataEncodingType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _encoding.
     */
    private org.hbird.transport.xtce.castor.types.FloatDataEncodingTypeEncodingType _encoding = org.hbird.transport.xtce.castor.types.FloatDataEncodingTypeEncodingType.fromValue("IEEE754_1985");

    /**
     * Field _sizeInBits.
     */
    private org.hbird.transport.xtce.castor.types.FloatDataEncodingTypeSizeInBitsType _sizeInBits = org.hbird.transport.xtce.castor.types.FloatDataEncodingTypeSizeInBitsType.fromValue("32");

    /**
     * Field _defaultCalibrator.
     */
    private org.hbird.transport.xtce.castor.DefaultCalibrator _defaultCalibrator;

    /**
     * Use when different calibrations must be used on the
     * Parameter in different contexts. Use the first one that
     * tests true
     */
    private org.hbird.transport.xtce.castor.FloatDataEncodingTypeContextCalibratorList _contextCalibratorList;


      //----------------/
     //- Constructors -/
    //----------------/

    public FloatDataEncodingType() {
        super();
        setEncoding(org.hbird.transport.xtce.castor.types.FloatDataEncodingTypeEncodingType.fromValue("IEEE754_1985"));
        setSizeInBits(org.hbird.transport.xtce.castor.types.FloatDataEncodingTypeSizeInBitsType.fromValue("32"));
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'contextCalibratorList'. The
     * field 'contextCalibratorList' has the following description:
     * Use when different calibrations must be used on the
     * Parameter in different contexts. Use the first one that
     * tests true
     * 
     * @return the value of field 'ContextCalibratorList'.
     */
    public org.hbird.transport.xtce.castor.FloatDataEncodingTypeContextCalibratorList getContextCalibratorList(
    ) {
        return this._contextCalibratorList;
    }

    /**
     * Returns the value of field 'defaultCalibrator'.
     * 
     * @return the value of field 'DefaultCalibrator'.
     */
    public org.hbird.transport.xtce.castor.DefaultCalibrator getDefaultCalibrator(
    ) {
        return this._defaultCalibrator;
    }

    /**
     * Returns the value of field 'encoding'.
     * 
     * @return the value of field 'Encoding'.
     */
    public org.hbird.transport.xtce.castor.types.FloatDataEncodingTypeEncodingType getEncoding(
    ) {
        return this._encoding;
    }

    /**
     * Returns the value of field 'sizeInBits'.
     * 
     * @return the value of field 'SizeInBits'.
     */
    public org.hbird.transport.xtce.castor.types.FloatDataEncodingTypeSizeInBitsType getSizeInBits(
    ) {
        return this._sizeInBits;
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
     * Sets the value of field 'contextCalibratorList'. The field
     * 'contextCalibratorList' has the following description: Use
     * when different calibrations must be used on the Parameter in
     * different contexts. Use the first one that tests true
     * 
     * @param contextCalibratorList the value of field
     * 'contextCalibratorList'.
     */
    public void setContextCalibratorList(
            final org.hbird.transport.xtce.castor.FloatDataEncodingTypeContextCalibratorList contextCalibratorList) {
        this._contextCalibratorList = contextCalibratorList;
    }

    /**
     * Sets the value of field 'defaultCalibrator'.
     * 
     * @param defaultCalibrator the value of field
     * 'defaultCalibrator'.
     */
    public void setDefaultCalibrator(
            final org.hbird.transport.xtce.castor.DefaultCalibrator defaultCalibrator) {
        this._defaultCalibrator = defaultCalibrator;
    }

    /**
     * Sets the value of field 'encoding'.
     * 
     * @param encoding the value of field 'encoding'.
     */
    public void setEncoding(
            final org.hbird.transport.xtce.castor.types.FloatDataEncodingTypeEncodingType encoding) {
        this._encoding = encoding;
    }

    /**
     * Sets the value of field 'sizeInBits'.
     * 
     * @param sizeInBits the value of field 'sizeInBits'.
     */
    public void setSizeInBits(
            final org.hbird.transport.xtce.castor.types.FloatDataEncodingTypeSizeInBitsType sizeInBits) {
        this._sizeInBits = sizeInBits;
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
     * org.hbird.xtce.castor.FloatDataEncodingType
     */
    public static org.hbird.transport.xtce.castor.FloatDataEncodingType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.FloatDataEncodingType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.FloatDataEncodingType.class, reader);
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
