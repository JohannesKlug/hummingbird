/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * For streams that contain a series of frames with a fixed frame
 * length where the frames are found by looking for a marker in the
 * data. This marker is sometimes called the frame sync pattern and
 * sometimes the Asynchronous Sync Marker (ASM).
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class FixedFrameStreamType extends org.hbird.transport.xtce.castor.FrameStreamType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Allowed slip (in bits) in either direction for the sync
     * pattern
     */
    private long _syncApertureInBits = 0;

    /**
     * keeps track of state for field: _syncApertureInBits
     */
    private boolean _has_syncApertureInBits;

    /**
     * Field _frameLengthInBits.
     */
    private long _frameLengthInBits;

    /**
     * keeps track of state for field: _frameLengthInBits
     */
    private boolean _has_frameLengthInBits;

    /**
     * Field _syncStrategy.
     */
    private org.hbird.transport.xtce.castor.SyncStrategy _syncStrategy;


      //----------------/
     //- Constructors -/
    //----------------/

    public FixedFrameStreamType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteFrameLengthInBits(
    ) {
        this._has_frameLengthInBits= false;
    }

    /**
     */
    public void deleteSyncApertureInBits(
    ) {
        this._has_syncApertureInBits= false;
    }

    /**
     * Returns the value of field 'frameLengthInBits'.
     * 
     * @return the value of field 'FrameLengthInBits'.
     */
    public long getFrameLengthInBits(
    ) {
        return this._frameLengthInBits;
    }

    /**
     * Returns the value of field 'syncApertureInBits'. The field
     * 'syncApertureInBits' has the following description: Allowed
     * slip (in bits) in either direction for the sync pattern
     * 
     * @return the value of field 'SyncApertureInBits'.
     */
    public long getSyncApertureInBits(
    ) {
        return this._syncApertureInBits;
    }

    /**
     * Returns the value of field 'syncStrategy'.
     * 
     * @return the value of field 'SyncStrategy'.
     */
    public org.hbird.transport.xtce.castor.SyncStrategy getSyncStrategy(
    ) {
        return this._syncStrategy;
    }

    /**
     * Method hasFrameLengthInBits.
     * 
     * @return true if at least one FrameLengthInBits has been added
     */
    public boolean hasFrameLengthInBits(
    ) {
        return this._has_frameLengthInBits;
    }

    /**
     * Method hasSyncApertureInBits.
     * 
     * @return true if at least one SyncApertureInBits has been adde
     */
    public boolean hasSyncApertureInBits(
    ) {
        return this._has_syncApertureInBits;
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
     * Sets the value of field 'frameLengthInBits'.
     * 
     * @param frameLengthInBits the value of field
     * 'frameLengthInBits'.
     */
    public void setFrameLengthInBits(
            final long frameLengthInBits) {
        this._frameLengthInBits = frameLengthInBits;
        this._has_frameLengthInBits = true;
    }

    /**
     * Sets the value of field 'syncApertureInBits'. The field
     * 'syncApertureInBits' has the following description: Allowed
     * slip (in bits) in either direction for the sync pattern
     * 
     * @param syncApertureInBits the value of field
     * 'syncApertureInBits'.
     */
    public void setSyncApertureInBits(
            final long syncApertureInBits) {
        this._syncApertureInBits = syncApertureInBits;
        this._has_syncApertureInBits = true;
    }

    /**
     * Sets the value of field 'syncStrategy'.
     * 
     * @param syncStrategy the value of field 'syncStrategy'.
     */
    public void setSyncStrategy(
            final org.hbird.transport.xtce.castor.SyncStrategy syncStrategy) {
        this._syncStrategy = syncStrategy;
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
     * org.hbird.xtce.castor.FixedFrameStreamType
     */
    public static org.hbird.transport.xtce.castor.FixedFrameStreamType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.FixedFrameStreamType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.FixedFrameStreamType.class, reader);
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
