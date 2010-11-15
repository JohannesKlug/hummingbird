/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * For binary data or for integer, float, string, or time data that
 * is not in any of the known encoding formats. For any data that
 * is not encoded in any of the known integer, float, string, or
 * time data formats use a To/From transform algorithm.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class BinaryDataEncodingType extends com.logica.hummingbird.xtce.castor.DataEncodingType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _sizeInBits.
     */
    private com.logica.hummingbird.xtce.castor.SizeInBits _sizeInBits;

    /**
     * Used to convert binary data to an application data type
     */
    private com.logica.hummingbird.xtce.castor.FromBinaryTransformAlgorithm _fromBinaryTransformAlgorithm;

    /**
     * Used to convert binary data from an application data type to
     * binary data
     */
    private com.logica.hummingbird.xtce.castor.ToBinaryTransformAlgorithm _toBinaryTransformAlgorithm;


      //----------------/
     //- Constructors -/
    //----------------/

    public BinaryDataEncodingType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'fromBinaryTransformAlgorithm'.
     * The field 'fromBinaryTransformAlgorithm' has the following
     * description: Used to convert binary data to an application
     * data type
     * 
     * @return the value of field 'FromBinaryTransformAlgorithm'.
     */
    public com.logica.hummingbird.xtce.castor.FromBinaryTransformAlgorithm getFromBinaryTransformAlgorithm(
    ) {
        return this._fromBinaryTransformAlgorithm;
    }

    /**
     * Returns the value of field 'sizeInBits'.
     * 
     * @return the value of field 'SizeInBits'.
     */
    public com.logica.hummingbird.xtce.castor.SizeInBits getSizeInBits(
    ) {
        return this._sizeInBits;
    }

    /**
     * Returns the value of field 'toBinaryTransformAlgorithm'. The
     * field 'toBinaryTransformAlgorithm' has the following
     * description: Used to convert binary data from an application
     * data type to binary data
     * 
     * @return the value of field 'ToBinaryTransformAlgorithm'.
     */
    public com.logica.hummingbird.xtce.castor.ToBinaryTransformAlgorithm getToBinaryTransformAlgorithm(
    ) {
        return this._toBinaryTransformAlgorithm;
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
     * Sets the value of field 'fromBinaryTransformAlgorithm'. The
     * field 'fromBinaryTransformAlgorithm' has the following
     * description: Used to convert binary data to an application
     * data type
     * 
     * @param fromBinaryTransformAlgorithm the value of field
     * 'fromBinaryTransformAlgorithm'.
     */
    public void setFromBinaryTransformAlgorithm(
            final com.logica.hummingbird.xtce.castor.FromBinaryTransformAlgorithm fromBinaryTransformAlgorithm) {
        this._fromBinaryTransformAlgorithm = fromBinaryTransformAlgorithm;
    }

    /**
     * Sets the value of field 'sizeInBits'.
     * 
     * @param sizeInBits the value of field 'sizeInBits'.
     */
    public void setSizeInBits(
            final com.logica.hummingbird.xtce.castor.SizeInBits sizeInBits) {
        this._sizeInBits = sizeInBits;
    }

    /**
     * Sets the value of field 'toBinaryTransformAlgorithm'. The
     * field 'toBinaryTransformAlgorithm' has the following
     * description: Used to convert binary data from an application
     * data type to binary data
     * 
     * @param toBinaryTransformAlgorithm the value of field
     * 'toBinaryTransformAlgorithm'.
     */
    public void setToBinaryTransformAlgorithm(
            final com.logica.hummingbird.xtce.castor.ToBinaryTransformAlgorithm toBinaryTransformAlgorithm) {
        this._toBinaryTransformAlgorithm = toBinaryTransformAlgorithm;
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
     * com.logica.hummingbird.xtce.castor.BinaryDataEncodingType
     */
    public static com.logica.hummingbird.xtce.castor.BinaryDataEncodingType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.BinaryDataEncodingType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.BinaryDataEncodingType.class, reader);
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
