/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * Class SizeInBits.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class StringDataEncodingTypeSizeInBits implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _fixed.
     */
    private org.hbird.transport.xtce.castor.Fixed _fixed;

    /**
     * Like C strings, they are terminated with a special string,
     * usually a null character.
     */
    private byte[] _terminationChar;

    /**
     * Like PASCAL strings, the size of the string is given as an
     * integer at the start of the string. SizeTag must be an
     * unsigned Integer
     */
    private org.hbird.transport.xtce.castor.LeadingSize _leadingSize;


      //----------------/
     //- Constructors -/
    //----------------/

    public StringDataEncodingTypeSizeInBits() {
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
     * Returns the value of field 'fixed'.
     * 
     * @return the value of field 'Fixed'.
     */
    public org.hbird.transport.xtce.castor.Fixed getFixed(
    ) {
        return this._fixed;
    }

    /**
     * Returns the value of field 'leadingSize'. The field
     * 'leadingSize' has the following description: Like PASCAL
     * strings, the size of the string is given as an integer at
     * the start of the string. SizeTag must be an unsigned Integer
     * 
     * @return the value of field 'LeadingSize'.
     */
    public org.hbird.transport.xtce.castor.LeadingSize getLeadingSize(
    ) {
        return this._leadingSize;
    }

    /**
     * Returns the value of field 'terminationChar'. The field
     * 'terminationChar' has the following description: Like C
     * strings, they are terminated with a special string, usually
     * a null character.
     * 
     * @return the value of field 'TerminationChar'.
     */
    public byte[] getTerminationChar(
    ) {
        return this._terminationChar;
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
     * Sets the value of field 'fixed'.
     * 
     * @param fixed the value of field 'fixed'.
     */
    public void setFixed(
            final org.hbird.transport.xtce.castor.Fixed fixed) {
        this._fixed = fixed;
        this._choiceValue = fixed;
    }

    /**
     * Sets the value of field 'leadingSize'. The field
     * 'leadingSize' has the following description: Like PASCAL
     * strings, the size of the string is given as an integer at
     * the start of the string. SizeTag must be an unsigned Integer
     * 
     * @param leadingSize the value of field 'leadingSize'.
     */
    public void setLeadingSize(
            final org.hbird.transport.xtce.castor.LeadingSize leadingSize) {
        this._leadingSize = leadingSize;
        this._choiceValue = leadingSize;
    }

    /**
     * Sets the value of field 'terminationChar'. The field
     * 'terminationChar' has the following description: Like C
     * strings, they are terminated with a special string, usually
     * a null character.
     * 
     * @param terminationChar the value of field 'terminationChar'.
     */
    public void setTerminationChar(
            final byte[] terminationChar) {
        this._terminationChar = terminationChar;
        this._choiceValue = terminationChar;
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
     * org.hbird.xtce.castor.StringDataEncodingTypeSizeInBits
     */
    public static org.hbird.transport.xtce.castor.StringDataEncodingTypeSizeInBits unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.StringDataEncodingTypeSizeInBits) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.StringDataEncodingTypeSizeInBits.class, reader);
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
