/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * A simple element that provides for simple, but common error
 * checking and detection.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ErrorDetectCorrectType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Bit position starts with 'zero'.
     */
    private org.hbird.transport.xtce.castor.Parity _parity;

    /**
     * Cyclic Redundancy Check definition. Legal values for
     * coefficient's are 0 or 1. Exponents must be integer values.
     */
    private org.hbird.transport.xtce.castor.CRC _CRC;


      //----------------/
     //- Constructors -/
    //----------------/

    public ErrorDetectCorrectType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'CRC'. The field 'CRC' has the
     * following description: Cyclic Redundancy Check definition.
     * Legal values for coefficient's are 0 or 1. Exponents must be
     * integer values.
     * 
     * @return the value of field 'CRC'.
     */
    public org.hbird.transport.xtce.castor.CRC getCRC(
    ) {
        return this._CRC;
    }

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
     * Returns the value of field 'parity'. The field 'parity' has
     * the following description: Bit position starts with 'zero'.
     * 
     * @return the value of field 'Parity'.
     */
    public org.hbird.transport.xtce.castor.Parity getParity(
    ) {
        return this._parity;
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
     * Sets the value of field 'CRC'. The field 'CRC' has the
     * following description: Cyclic Redundancy Check definition.
     * Legal values for coefficient's are 0 or 1. Exponents must be
     * integer values.
     * 
     * @param CRC the value of field 'CRC'.
     */
    public void setCRC(
            final org.hbird.transport.xtce.castor.CRC CRC) {
        this._CRC = CRC;
        this._choiceValue = CRC;
    }

    /**
     * Sets the value of field 'parity'. The field 'parity' has the
     * following description: Bit position starts with 'zero'.
     * 
     * @param parity the value of field 'parity'.
     */
    public void setParity(
            final org.hbird.transport.xtce.castor.Parity parity) {
        this._parity = parity;
        this._choiceValue = parity;
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
     * org.hbird.xtce.castor.ErrorDetectCorrectType
     */
    public static org.hbird.transport.xtce.castor.ErrorDetectCorrectType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.ErrorDetectCorrectType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.ErrorDetectCorrectType.class, reader);
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
