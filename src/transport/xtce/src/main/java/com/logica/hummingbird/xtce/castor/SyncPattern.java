/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * The pattern of bits used to look for frame synchronization.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SyncPattern implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * CCSDS ASM for non-turbocoded frames = 1acffc1d
     */
    private byte[] _pattern;

    /**
     * Field _bitLocationFromStartOfContainer.
     */
    private long _bitLocationFromStartOfContainer = 0;

    /**
     * keeps track of state for field:
     * _bitLocationFromStartOfContainer
     */
    private boolean _has_bitLocationFromStartOfContainer;

    /**
     * Field _mask.
     */
    private byte[] _mask;

    /**
     * truncate the mask from the left
     */
    private long _maskLengthInBits;

    /**
     * keeps track of state for field: _maskLengthInBits
     */
    private boolean _has_maskLengthInBits;

    /**
     * truncate the pattern from the left
     */
    private long _patternLengthInBits;

    /**
     * keeps track of state for field: _patternLengthInBits
     */
    private boolean _has_patternLengthInBits;


      //----------------/
     //- Constructors -/
    //----------------/

    public SyncPattern() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteBitLocationFromStartOfContainer(
    ) {
        this._has_bitLocationFromStartOfContainer= false;
    }

    /**
     */
    public void deleteMaskLengthInBits(
    ) {
        this._has_maskLengthInBits= false;
    }

    /**
     */
    public void deletePatternLengthInBits(
    ) {
        this._has_patternLengthInBits= false;
    }

    /**
     * Returns the value of field
     * 'bitLocationFromStartOfContainer'.
     * 
     * @return the value of field 'BitLocationFromStartOfContainer'.
     */
    public long getBitLocationFromStartOfContainer(
    ) {
        return this._bitLocationFromStartOfContainer;
    }

    /**
     * Returns the value of field 'mask'.
     * 
     * @return the value of field 'Mask'.
     */
    public byte[] getMask(
    ) {
        return this._mask;
    }

    /**
     * Returns the value of field 'maskLengthInBits'. The field
     * 'maskLengthInBits' has the following description: truncate
     * the mask from the left
     * 
     * @return the value of field 'MaskLengthInBits'.
     */
    public long getMaskLengthInBits(
    ) {
        return this._maskLengthInBits;
    }

    /**
     * Returns the value of field 'pattern'. The field 'pattern'
     * has the following description: CCSDS ASM for non-turbocoded
     * frames = 1acffc1d
     * 
     * @return the value of field 'Pattern'.
     */
    public byte[] getPattern(
    ) {
        return this._pattern;
    }

    /**
     * Returns the value of field 'patternLengthInBits'. The field
     * 'patternLengthInBits' has the following description:
     * truncate the pattern from the left
     * 
     * @return the value of field 'PatternLengthInBits'.
     */
    public long getPatternLengthInBits(
    ) {
        return this._patternLengthInBits;
    }

    /**
     * Method hasBitLocationFromStartOfContainer.
     * 
     * @return true if at least one BitLocationFromStartOfContainer
     * has been added
     */
    public boolean hasBitLocationFromStartOfContainer(
    ) {
        return this._has_bitLocationFromStartOfContainer;
    }

    /**
     * Method hasMaskLengthInBits.
     * 
     * @return true if at least one MaskLengthInBits has been added
     */
    public boolean hasMaskLengthInBits(
    ) {
        return this._has_maskLengthInBits;
    }

    /**
     * Method hasPatternLengthInBits.
     * 
     * @return true if at least one PatternLengthInBits has been
     * added
     */
    public boolean hasPatternLengthInBits(
    ) {
        return this._has_patternLengthInBits;
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
     * Sets the value of field 'bitLocationFromStartOfContainer'.
     * 
     * @param bitLocationFromStartOfContainer the value of field
     * 'bitLocationFromStartOfContainer'.
     */
    public void setBitLocationFromStartOfContainer(
            final long bitLocationFromStartOfContainer) {
        this._bitLocationFromStartOfContainer = bitLocationFromStartOfContainer;
        this._has_bitLocationFromStartOfContainer = true;
    }

    /**
     * Sets the value of field 'mask'.
     * 
     * @param mask the value of field 'mask'.
     */
    public void setMask(
            final byte[] mask) {
        this._mask = mask;
    }

    /**
     * Sets the value of field 'maskLengthInBits'. The field
     * 'maskLengthInBits' has the following description: truncate
     * the mask from the left
     * 
     * @param maskLengthInBits the value of field 'maskLengthInBits'
     */
    public void setMaskLengthInBits(
            final long maskLengthInBits) {
        this._maskLengthInBits = maskLengthInBits;
        this._has_maskLengthInBits = true;
    }

    /**
     * Sets the value of field 'pattern'. The field 'pattern' has
     * the following description: CCSDS ASM for non-turbocoded
     * frames = 1acffc1d
     * 
     * @param pattern the value of field 'pattern'.
     */
    public void setPattern(
            final byte[] pattern) {
        this._pattern = pattern;
    }

    /**
     * Sets the value of field 'patternLengthInBits'. The field
     * 'patternLengthInBits' has the following description:
     * truncate the pattern from the left
     * 
     * @param patternLengthInBits the value of field
     * 'patternLengthInBits'.
     */
    public void setPatternLengthInBits(
            final long patternLengthInBits) {
        this._patternLengthInBits = patternLengthInBits;
        this._has_patternLengthInBits = true;
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
     * com.logica.hummingbird.xtce.castor.SyncPattern
     */
    public static com.logica.hummingbird.xtce.castor.SyncPattern unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.SyncPattern) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.SyncPattern.class, reader);
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
