/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * The pattern of bits used to look for frame synchronization.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class FixedFrameSyncStrategyTypeSyncPattern implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _pattern.
     */
    private byte[] _pattern;

    /**
     * Field _bitLocation.
     */
    private long _bitLocation = 0;

    /**
     * keeps track of state for field: _bitLocation
     */
    private boolean _has_bitLocation;

    /**
     * Field _mask.
     */
    private byte[] _mask;

    /**
     * Field _maskLengthInBits.
     */
    private long _maskLengthInBits;

    /**
     * keeps track of state for field: _maskLengthInBits
     */
    private boolean _has_maskLengthInBits;

    /**
     * Field _patternLengthInBits.
     */
    private long _patternLengthInBits;

    /**
     * keeps track of state for field: _patternLengthInBits
     */
    private boolean _has_patternLengthInBits;


      //----------------/
     //- Constructors -/
    //----------------/

    public FixedFrameSyncStrategyTypeSyncPattern() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteBitLocation(
    ) {
        this._has_bitLocation= false;
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
     * Returns the value of field 'bitLocation'.
     * 
     * @return the value of field 'BitLocation'.
     */
    public long getBitLocation(
    ) {
        return this._bitLocation;
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
     * Returns the value of field 'maskLengthInBits'.
     * 
     * @return the value of field 'MaskLengthInBits'.
     */
    public long getMaskLengthInBits(
    ) {
        return this._maskLengthInBits;
    }

    /**
     * Returns the value of field 'pattern'.
     * 
     * @return the value of field 'Pattern'.
     */
    public byte[] getPattern(
    ) {
        return this._pattern;
    }

    /**
     * Returns the value of field 'patternLengthInBits'.
     * 
     * @return the value of field 'PatternLengthInBits'.
     */
    public long getPatternLengthInBits(
    ) {
        return this._patternLengthInBits;
    }

    /**
     * Method hasBitLocation.
     * 
     * @return true if at least one BitLocation has been added
     */
    public boolean hasBitLocation(
    ) {
        return this._has_bitLocation;
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
     * Sets the value of field 'bitLocation'.
     * 
     * @param bitLocation the value of field 'bitLocation'.
     */
    public void setBitLocation(
            final long bitLocation) {
        this._bitLocation = bitLocation;
        this._has_bitLocation = true;
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
     * Sets the value of field 'maskLengthInBits'.
     * 
     * @param maskLengthInBits the value of field 'maskLengthInBits'
     */
    public void setMaskLengthInBits(
            final long maskLengthInBits) {
        this._maskLengthInBits = maskLengthInBits;
        this._has_maskLengthInBits = true;
    }

    /**
     * Sets the value of field 'pattern'.
     * 
     * @param pattern the value of field 'pattern'.
     */
    public void setPattern(
            final byte[] pattern) {
        this._pattern = pattern;
    }

    /**
     * Sets the value of field 'patternLengthInBits'.
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
     * org.hbird.xtce.castor.FixedFrameSyncStrategyTypeSyncPattern
     */
    public static org.hbird.xtce.castor.FixedFrameSyncStrategyTypeSyncPattern unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.FixedFrameSyncStrategyTypeSyncPattern) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.FixedFrameSyncStrategyTypeSyncPattern.class, reader);
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
