/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Contains five ranges: Watch, Warning, Distress, Critical, and
 * Severe each in increasing severity. Normally, only the Warning
 * and Critical ranges are used and the color yellow is associated
 * with Warning and the color red is associated with Critical. The
 * ranges given are valid for numbers lower than the min and higher
 * than the max values. These ranges should not overlap, but if
 * they do, assume the most severe range is to be applied. All
 * ranges are optional and it is quite allowed for there to be only
 * one end of the range. 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class AlarmRangesType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _appliesToCalibratedValues.
     */
    private boolean _appliesToCalibratedValues = true;

    /**
     * keeps track of state for field: _appliesToCalibratedValues
     */
    private boolean _has_appliesToCalibratedValues;

    /**
     * Field _watchRange.
     */
    private com.logica.hummingbird.xtce.castor.WatchRange _watchRange;

    /**
     * Field _warningRange.
     */
    private com.logica.hummingbird.xtce.castor.WarningRange _warningRange;

    /**
     * Field _distressRange.
     */
    private com.logica.hummingbird.xtce.castor.DistressRange _distressRange;

    /**
     * Field _criticalRange.
     */
    private com.logica.hummingbird.xtce.castor.CriticalRange _criticalRange;

    /**
     * Field _severeRange.
     */
    private com.logica.hummingbird.xtce.castor.SevereRange _severeRange;


      //----------------/
     //- Constructors -/
    //----------------/

    public AlarmRangesType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteAppliesToCalibratedValues(
    ) {
        this._has_appliesToCalibratedValues= false;
    }

    /**
     * Returns the value of field 'appliesToCalibratedValues'.
     * 
     * @return the value of field 'AppliesToCalibratedValues'.
     */
    public boolean getAppliesToCalibratedValues(
    ) {
        return this._appliesToCalibratedValues;
    }

    /**
     * Returns the value of field 'criticalRange'.
     * 
     * @return the value of field 'CriticalRange'.
     */
    public com.logica.hummingbird.xtce.castor.CriticalRange getCriticalRange(
    ) {
        return this._criticalRange;
    }

    /**
     * Returns the value of field 'distressRange'.
     * 
     * @return the value of field 'DistressRange'.
     */
    public com.logica.hummingbird.xtce.castor.DistressRange getDistressRange(
    ) {
        return this._distressRange;
    }

    /**
     * Returns the value of field 'severeRange'.
     * 
     * @return the value of field 'SevereRange'.
     */
    public com.logica.hummingbird.xtce.castor.SevereRange getSevereRange(
    ) {
        return this._severeRange;
    }

    /**
     * Returns the value of field 'warningRange'.
     * 
     * @return the value of field 'WarningRange'.
     */
    public com.logica.hummingbird.xtce.castor.WarningRange getWarningRange(
    ) {
        return this._warningRange;
    }

    /**
     * Returns the value of field 'watchRange'.
     * 
     * @return the value of field 'WatchRange'.
     */
    public com.logica.hummingbird.xtce.castor.WatchRange getWatchRange(
    ) {
        return this._watchRange;
    }

    /**
     * Method hasAppliesToCalibratedValues.
     * 
     * @return true if at least one AppliesToCalibratedValues has
     * been added
     */
    public boolean hasAppliesToCalibratedValues(
    ) {
        return this._has_appliesToCalibratedValues;
    }

    /**
     * Returns the value of field 'appliesToCalibratedValues'.
     * 
     * @return the value of field 'AppliesToCalibratedValues'.
     */
    public boolean isAppliesToCalibratedValues(
    ) {
        return this._appliesToCalibratedValues;
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
     * Sets the value of field 'appliesToCalibratedValues'.
     * 
     * @param appliesToCalibratedValues the value of field
     * 'appliesToCalibratedValues'.
     */
    public void setAppliesToCalibratedValues(
            final boolean appliesToCalibratedValues) {
        this._appliesToCalibratedValues = appliesToCalibratedValues;
        this._has_appliesToCalibratedValues = true;
    }

    /**
     * Sets the value of field 'criticalRange'.
     * 
     * @param criticalRange the value of field 'criticalRange'.
     */
    public void setCriticalRange(
            final com.logica.hummingbird.xtce.castor.CriticalRange criticalRange) {
        this._criticalRange = criticalRange;
    }

    /**
     * Sets the value of field 'distressRange'.
     * 
     * @param distressRange the value of field 'distressRange'.
     */
    public void setDistressRange(
            final com.logica.hummingbird.xtce.castor.DistressRange distressRange) {
        this._distressRange = distressRange;
    }

    /**
     * Sets the value of field 'severeRange'.
     * 
     * @param severeRange the value of field 'severeRange'.
     */
    public void setSevereRange(
            final com.logica.hummingbird.xtce.castor.SevereRange severeRange) {
        this._severeRange = severeRange;
    }

    /**
     * Sets the value of field 'warningRange'.
     * 
     * @param warningRange the value of field 'warningRange'.
     */
    public void setWarningRange(
            final com.logica.hummingbird.xtce.castor.WarningRange warningRange) {
        this._warningRange = warningRange;
    }

    /**
     * Sets the value of field 'watchRange'.
     * 
     * @param watchRange the value of field 'watchRange'.
     */
    public void setWatchRange(
            final com.logica.hummingbird.xtce.castor.WatchRange watchRange) {
        this._watchRange = watchRange;
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
     * com.logica.hummingbird.xtce.castor.AlarmRangesType
     */
    public static com.logica.hummingbird.xtce.castor.AlarmRangesType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.AlarmRangesType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.AlarmRangesType.class, reader);
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
