/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * A Sync Strategy specifies the strategy on how to find frames
 * within a stream of PCM data. The sync strategy is based upon a
 * state machine that begins in the 'Search' state until the first
 * sync marker is found. Then it goes into the 'Verify' state until
 * a specified number of successive good sync markers are found.
 * Then, the state machine goes into the 'Lock' state, in the
 * 'Lock' state frames are considered good. Should a sync marker be
 * missed in the 'Lock' state, the state machine will transition
 * into the 'Check' state, if the next sync marker is where it's
 * expected within a specified number of frames, then the state
 * machine will transition back to the 'Lock' state, it not it will
 * transition back to 'Search'. 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SyncStrategyType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _verifyToLockGoodFrames.
     */
    private long _verifyToLockGoodFrames = 4;

    /**
     * keeps track of state for field: _verifyToLockGoodFrames
     */
    private boolean _has_verifyToLockGoodFrames;

    /**
     * Field _checkToLockGoodFrames.
     */
    private long _checkToLockGoodFrames = 1;

    /**
     * keeps track of state for field: _checkToLockGoodFrames
     */
    private boolean _has_checkToLockGoodFrames;

    /**
     * Maximum number of bit errors in the sync pattern (marker).
     */
    private long _maxBitErrorsInSyncPattern = 0;

    /**
     * keeps track of state for field: _maxBitErrorsInSyncPattern
     */
    private boolean _has_maxBitErrorsInSyncPattern;

    /**
     * After serching for the frame sync marker for some number of
     * bitss, it may be desirable to invert the incoming data, and
     * then look for frame sync. In some cases this will require an
     * external algorithm
     */
    private org.hbird.transport.xtce.castor.AutoInvert _autoInvert;


      //----------------/
     //- Constructors -/
    //----------------/

    public SyncStrategyType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteCheckToLockGoodFrames(
    ) {
        this._has_checkToLockGoodFrames= false;
    }

    /**
     */
    public void deleteMaxBitErrorsInSyncPattern(
    ) {
        this._has_maxBitErrorsInSyncPattern= false;
    }

    /**
     */
    public void deleteVerifyToLockGoodFrames(
    ) {
        this._has_verifyToLockGoodFrames= false;
    }

    /**
     * Returns the value of field 'autoInvert'. The field
     * 'autoInvert' has the following description: After serching
     * for the frame sync marker for some number of bitss, it may
     * be desirable to invert the incoming data, and then look for
     * frame sync. In some cases this will require an external
     * algorithm
     * 
     * @return the value of field 'AutoInvert'.
     */
    public org.hbird.transport.xtce.castor.AutoInvert getAutoInvert(
    ) {
        return this._autoInvert;
    }

    /**
     * Returns the value of field 'checkToLockGoodFrames'.
     * 
     * @return the value of field 'CheckToLockGoodFrames'.
     */
    public long getCheckToLockGoodFrames(
    ) {
        return this._checkToLockGoodFrames;
    }

    /**
     * Returns the value of field 'maxBitErrorsInSyncPattern'. The
     * field 'maxBitErrorsInSyncPattern' has the following
     * description: Maximum number of bit errors in the sync
     * pattern (marker).
     * 
     * @return the value of field 'MaxBitErrorsInSyncPattern'.
     */
    public long getMaxBitErrorsInSyncPattern(
    ) {
        return this._maxBitErrorsInSyncPattern;
    }

    /**
     * Returns the value of field 'verifyToLockGoodFrames'.
     * 
     * @return the value of field 'VerifyToLockGoodFrames'.
     */
    public long getVerifyToLockGoodFrames(
    ) {
        return this._verifyToLockGoodFrames;
    }

    /**
     * Method hasCheckToLockGoodFrames.
     * 
     * @return true if at least one CheckToLockGoodFrames has been
     * added
     */
    public boolean hasCheckToLockGoodFrames(
    ) {
        return this._has_checkToLockGoodFrames;
    }

    /**
     * Method hasMaxBitErrorsInSyncPattern.
     * 
     * @return true if at least one MaxBitErrorsInSyncPattern has
     * been added
     */
    public boolean hasMaxBitErrorsInSyncPattern(
    ) {
        return this._has_maxBitErrorsInSyncPattern;
    }

    /**
     * Method hasVerifyToLockGoodFrames.
     * 
     * @return true if at least one VerifyToLockGoodFrames has been
     * added
     */
    public boolean hasVerifyToLockGoodFrames(
    ) {
        return this._has_verifyToLockGoodFrames;
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
     * Sets the value of field 'autoInvert'. The field 'autoInvert'
     * has the following description: After serching for the frame
     * sync marker for some number of bitss, it may be desirable to
     * invert the incoming data, and then look for frame sync. In
     * some cases this will require an external algorithm
     * 
     * @param autoInvert the value of field 'autoInvert'.
     */
    public void setAutoInvert(
            final org.hbird.transport.xtce.castor.AutoInvert autoInvert) {
        this._autoInvert = autoInvert;
    }

    /**
     * Sets the value of field 'checkToLockGoodFrames'.
     * 
     * @param checkToLockGoodFrames the value of field
     * 'checkToLockGoodFrames'.
     */
    public void setCheckToLockGoodFrames(
            final long checkToLockGoodFrames) {
        this._checkToLockGoodFrames = checkToLockGoodFrames;
        this._has_checkToLockGoodFrames = true;
    }

    /**
     * Sets the value of field 'maxBitErrorsInSyncPattern'. The
     * field 'maxBitErrorsInSyncPattern' has the following
     * description: Maximum number of bit errors in the sync
     * pattern (marker).
     * 
     * @param maxBitErrorsInSyncPattern the value of field
     * 'maxBitErrorsInSyncPattern'.
     */
    public void setMaxBitErrorsInSyncPattern(
            final long maxBitErrorsInSyncPattern) {
        this._maxBitErrorsInSyncPattern = maxBitErrorsInSyncPattern;
        this._has_maxBitErrorsInSyncPattern = true;
    }

    /**
     * Sets the value of field 'verifyToLockGoodFrames'.
     * 
     * @param verifyToLockGoodFrames the value of field
     * 'verifyToLockGoodFrames'.
     */
    public void setVerifyToLockGoodFrames(
            final long verifyToLockGoodFrames) {
        this._verifyToLockGoodFrames = verifyToLockGoodFrames;
        this._has_verifyToLockGoodFrames = true;
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
     * org.hbird.xtce.castor.SyncStrategyType
     */
    public static org.hbird.transport.xtce.castor.SyncStrategyType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.SyncStrategyType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.SyncStrategyType.class, reader);
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
