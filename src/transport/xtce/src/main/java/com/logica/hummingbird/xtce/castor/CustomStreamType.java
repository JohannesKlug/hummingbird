/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * A stream type where some level of custom processing (e.g.
 * convolutional, encryption, compression) is performed. Has a
 * reference to external algorithms for encoding and decoding
 * algorithms.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CustomStreamType extends org.hbird.xtce.castor.PCMStreamType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _encodedStreamRef.
     */
    private java.lang.String _encodedStreamRef;

    /**
     * Field _decodedStreamRef.
     */
    private java.lang.String _decodedStreamRef;

    /**
     * Field _encodingAlgorithm.
     */
    private org.hbird.xtce.castor.EncodingAlgorithm _encodingAlgorithm;

    /**
     * Algorithm outputs may be used to set decoding quality
     * parameters.
     */
    private org.hbird.xtce.castor.DecodingAlgorithm _decodingAlgorithm;


      //----------------/
     //- Constructors -/
    //----------------/

    public CustomStreamType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'decodedStreamRef'.
     * 
     * @return the value of field 'DecodedStreamRef'.
     */
    public java.lang.String getDecodedStreamRef(
    ) {
        return this._decodedStreamRef;
    }

    /**
     * Returns the value of field 'decodingAlgorithm'. The field
     * 'decodingAlgorithm' has the following description: Algorithm
     * outputs may be used to set decoding quality parameters.
     * 
     * @return the value of field 'DecodingAlgorithm'.
     */
    public org.hbird.xtce.castor.DecodingAlgorithm getDecodingAlgorithm(
    ) {
        return this._decodingAlgorithm;
    }

    /**
     * Returns the value of field 'encodedStreamRef'.
     * 
     * @return the value of field 'EncodedStreamRef'.
     */
    public java.lang.String getEncodedStreamRef(
    ) {
        return this._encodedStreamRef;
    }

    /**
     * Returns the value of field 'encodingAlgorithm'.
     * 
     * @return the value of field 'EncodingAlgorithm'.
     */
    public org.hbird.xtce.castor.EncodingAlgorithm getEncodingAlgorithm(
    ) {
        return this._encodingAlgorithm;
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
     * Sets the value of field 'decodedStreamRef'.
     * 
     * @param decodedStreamRef the value of field 'decodedStreamRef'
     */
    public void setDecodedStreamRef(
            final java.lang.String decodedStreamRef) {
        this._decodedStreamRef = decodedStreamRef;
    }

    /**
     * Sets the value of field 'decodingAlgorithm'. The field
     * 'decodingAlgorithm' has the following description: Algorithm
     * outputs may be used to set decoding quality parameters.
     * 
     * @param decodingAlgorithm the value of field
     * 'decodingAlgorithm'.
     */
    public void setDecodingAlgorithm(
            final org.hbird.xtce.castor.DecodingAlgorithm decodingAlgorithm) {
        this._decodingAlgorithm = decodingAlgorithm;
    }

    /**
     * Sets the value of field 'encodedStreamRef'.
     * 
     * @param encodedStreamRef the value of field 'encodedStreamRef'
     */
    public void setEncodedStreamRef(
            final java.lang.String encodedStreamRef) {
        this._encodedStreamRef = encodedStreamRef;
    }

    /**
     * Sets the value of field 'encodingAlgorithm'.
     * 
     * @param encodingAlgorithm the value of field
     * 'encodingAlgorithm'.
     */
    public void setEncodingAlgorithm(
            final org.hbird.xtce.castor.EncodingAlgorithm encodingAlgorithm) {
        this._encodingAlgorithm = encodingAlgorithm;
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
     * org.hbird.xtce.castor.CustomStreamType
     */
    public static org.hbird.xtce.castor.CustomStreamType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.CustomStreamType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.CustomStreamType.class, reader);
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
