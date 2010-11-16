/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * The pattern of bits used to look for frame synchronization.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Flag implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _flagSizeInBits.
     */
    private long _flagSizeInBits = 6;

    /**
     * keeps track of state for field: _flagSizeInBits
     */
    private boolean _has_flagSizeInBits;

    /**
     * Field _flagBitType.
     */
    private org.hbird.transport.xtce.castor.types.FlagFlagBitTypeType _flagBitType = org.hbird.transport.xtce.castor.types.FlagFlagBitTypeType.fromValue("ones");


      //----------------/
     //- Constructors -/
    //----------------/

    public Flag() {
        super();
        setFlagBitType(org.hbird.transport.xtce.castor.types.FlagFlagBitTypeType.fromValue("ones"));
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteFlagSizeInBits(
    ) {
        this._has_flagSizeInBits= false;
    }

    /**
     * Returns the value of field 'flagBitType'.
     * 
     * @return the value of field 'FlagBitType'.
     */
    public org.hbird.transport.xtce.castor.types.FlagFlagBitTypeType getFlagBitType(
    ) {
        return this._flagBitType;
    }

    /**
     * Returns the value of field 'flagSizeInBits'.
     * 
     * @return the value of field 'FlagSizeInBits'.
     */
    public long getFlagSizeInBits(
    ) {
        return this._flagSizeInBits;
    }

    /**
     * Method hasFlagSizeInBits.
     * 
     * @return true if at least one FlagSizeInBits has been added
     */
    public boolean hasFlagSizeInBits(
    ) {
        return this._has_flagSizeInBits;
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
     * Sets the value of field 'flagBitType'.
     * 
     * @param flagBitType the value of field 'flagBitType'.
     */
    public void setFlagBitType(
            final org.hbird.transport.xtce.castor.types.FlagFlagBitTypeType flagBitType) {
        this._flagBitType = flagBitType;
    }

    /**
     * Sets the value of field 'flagSizeInBits'.
     * 
     * @param flagSizeInBits the value of field 'flagSizeInBits'.
     */
    public void setFlagSizeInBits(
            final long flagSizeInBits) {
        this._flagSizeInBits = flagSizeInBits;
        this._has_flagSizeInBits = true;
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
     * org.hbird.xtce.castor.Flag
     */
    public static org.hbird.transport.xtce.castor.Flag unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.Flag) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.Flag.class, reader);
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
