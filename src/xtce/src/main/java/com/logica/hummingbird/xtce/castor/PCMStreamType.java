/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * A PCM Stream Type is the high level definition for all Pulse
 * Code Modulated (PCM) (i.e., binary) streams.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public abstract class PCMStreamType extends com.logica.hummingbird.xtce.castor.NameDescriptionType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _bitRateInBPS.
     */
    private double _bitRateInBPS;

    /**
     * keeps track of state for field: _bitRateInBPS
     */
    private boolean _has_bitRateInBPS;

    /**
     * Field _pcmType.
     */
    private com.logica.hummingbird.xtce.castor.types.PCMStreamTypePcmTypeType _pcmType = com.logica.hummingbird.xtce.castor.types.PCMStreamTypePcmTypeType.fromValue("NRZL");

    /**
     * Field _inverted.
     */
    private boolean _inverted = false;

    /**
     * keeps track of state for field: _inverted
     */
    private boolean _has_inverted;


      //----------------/
     //- Constructors -/
    //----------------/

    public PCMStreamType() {
        super();
        setPcmType(com.logica.hummingbird.xtce.castor.types.PCMStreamTypePcmTypeType.fromValue("NRZL"));
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteBitRateInBPS(
    ) {
        this._has_bitRateInBPS= false;
    }

    /**
     */
    public void deleteInverted(
    ) {
        this._has_inverted= false;
    }

    /**
     * Returns the value of field 'bitRateInBPS'.
     * 
     * @return the value of field 'BitRateInBPS'.
     */
    public double getBitRateInBPS(
    ) {
        return this._bitRateInBPS;
    }

    /**
     * Returns the value of field 'inverted'.
     * 
     * @return the value of field 'Inverted'.
     */
    public boolean getInverted(
    ) {
        return this._inverted;
    }

    /**
     * Returns the value of field 'pcmType'.
     * 
     * @return the value of field 'PcmType'.
     */
    public com.logica.hummingbird.xtce.castor.types.PCMStreamTypePcmTypeType getPcmType(
    ) {
        return this._pcmType;
    }

    /**
     * Method hasBitRateInBPS.
     * 
     * @return true if at least one BitRateInBPS has been added
     */
    public boolean hasBitRateInBPS(
    ) {
        return this._has_bitRateInBPS;
    }

    /**
     * Method hasInverted.
     * 
     * @return true if at least one Inverted has been added
     */
    public boolean hasInverted(
    ) {
        return this._has_inverted;
    }

    /**
     * Returns the value of field 'inverted'.
     * 
     * @return the value of field 'Inverted'.
     */
    public boolean isInverted(
    ) {
        return this._inverted;
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
     * Sets the value of field 'bitRateInBPS'.
     * 
     * @param bitRateInBPS the value of field 'bitRateInBPS'.
     */
    public void setBitRateInBPS(
            final double bitRateInBPS) {
        this._bitRateInBPS = bitRateInBPS;
        this._has_bitRateInBPS = true;
    }

    /**
     * Sets the value of field 'inverted'.
     * 
     * @param inverted the value of field 'inverted'.
     */
    public void setInverted(
            final boolean inverted) {
        this._inverted = inverted;
        this._has_inverted = true;
    }

    /**
     * Sets the value of field 'pcmType'.
     * 
     * @param pcmType the value of field 'pcmType'.
     */
    public void setPcmType(
            final com.logica.hummingbird.xtce.castor.types.PCMStreamTypePcmTypeType pcmType) {
        this._pcmType = pcmType;
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
