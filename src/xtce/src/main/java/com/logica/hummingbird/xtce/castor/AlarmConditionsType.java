/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * When the alarm is determined by boolean logic
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class AlarmConditionsType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _watchAlarm.
     */
    private com.logica.hummingbird.xtce.castor.WatchAlarm _watchAlarm;

    /**
     * Field _warningAlarm.
     */
    private com.logica.hummingbird.xtce.castor.WarningAlarm _warningAlarm;

    /**
     * Field _distressAlarm.
     */
    private com.logica.hummingbird.xtce.castor.DistressAlarm _distressAlarm;

    /**
     * Field _critialAlarm.
     */
    private com.logica.hummingbird.xtce.castor.CritialAlarm _critialAlarm;

    /**
     * Field _severeAlarm.
     */
    private com.logica.hummingbird.xtce.castor.SevereAlarm _severeAlarm;


      //----------------/
     //- Constructors -/
    //----------------/

    public AlarmConditionsType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'critialAlarm'.
     * 
     * @return the value of field 'CritialAlarm'.
     */
    public com.logica.hummingbird.xtce.castor.CritialAlarm getCritialAlarm(
    ) {
        return this._critialAlarm;
    }

    /**
     * Returns the value of field 'distressAlarm'.
     * 
     * @return the value of field 'DistressAlarm'.
     */
    public com.logica.hummingbird.xtce.castor.DistressAlarm getDistressAlarm(
    ) {
        return this._distressAlarm;
    }

    /**
     * Returns the value of field 'severeAlarm'.
     * 
     * @return the value of field 'SevereAlarm'.
     */
    public com.logica.hummingbird.xtce.castor.SevereAlarm getSevereAlarm(
    ) {
        return this._severeAlarm;
    }

    /**
     * Returns the value of field 'warningAlarm'.
     * 
     * @return the value of field 'WarningAlarm'.
     */
    public com.logica.hummingbird.xtce.castor.WarningAlarm getWarningAlarm(
    ) {
        return this._warningAlarm;
    }

    /**
     * Returns the value of field 'watchAlarm'.
     * 
     * @return the value of field 'WatchAlarm'.
     */
    public com.logica.hummingbird.xtce.castor.WatchAlarm getWatchAlarm(
    ) {
        return this._watchAlarm;
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
     * Sets the value of field 'critialAlarm'.
     * 
     * @param critialAlarm the value of field 'critialAlarm'.
     */
    public void setCritialAlarm(
            final com.logica.hummingbird.xtce.castor.CritialAlarm critialAlarm) {
        this._critialAlarm = critialAlarm;
    }

    /**
     * Sets the value of field 'distressAlarm'.
     * 
     * @param distressAlarm the value of field 'distressAlarm'.
     */
    public void setDistressAlarm(
            final com.logica.hummingbird.xtce.castor.DistressAlarm distressAlarm) {
        this._distressAlarm = distressAlarm;
    }

    /**
     * Sets the value of field 'severeAlarm'.
     * 
     * @param severeAlarm the value of field 'severeAlarm'.
     */
    public void setSevereAlarm(
            final com.logica.hummingbird.xtce.castor.SevereAlarm severeAlarm) {
        this._severeAlarm = severeAlarm;
    }

    /**
     * Sets the value of field 'warningAlarm'.
     * 
     * @param warningAlarm the value of field 'warningAlarm'.
     */
    public void setWarningAlarm(
            final com.logica.hummingbird.xtce.castor.WarningAlarm warningAlarm) {
        this._warningAlarm = warningAlarm;
    }

    /**
     * Sets the value of field 'watchAlarm'.
     * 
     * @param watchAlarm the value of field 'watchAlarm'.
     */
    public void setWatchAlarm(
            final com.logica.hummingbird.xtce.castor.WatchAlarm watchAlarm) {
        this._watchAlarm = watchAlarm;
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
     * com.logica.hummingbird.xtce.castor.AlarmConditionsType
     */
    public static com.logica.hummingbird.xtce.castor.AlarmConditionsType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.AlarmConditionsType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.AlarmConditionsType.class, reader);
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
