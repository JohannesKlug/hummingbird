/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * Alarms associated with numeric data types
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class NumericAlarmConditionType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Number of successive values of the Parameter for the Alarm
     * to trigger.
     */
    private long _minViolations = 1;

    /**
     * keeps track of state for field: _minViolations
     */
    private boolean _has_minViolations;

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _numericAlarmConditionTypeSequence.
     */
    private org.hbird.xtce.castor.NumericAlarmConditionTypeSequence _numericAlarmConditionTypeSequence;

    /**
     * A MatchCriteria may be specifiec for each of the 5 alarm
     * levels. Each level is optional and the alarm should be the
     * highest level to test true.
     */
    private org.hbird.xtce.castor.ConditionalAlarm _conditionalAlarm;

    /**
     * An escape for ridiculously complex alarm conditions. Will
     * trigger on changes to the containing Parameter. 
     */
    private org.hbird.xtce.castor.CustomAlarm _customAlarm;


      //----------------/
     //- Constructors -/
    //----------------/

    public NumericAlarmConditionType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteMinViolations(
    ) {
        this._has_minViolations= false;
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
     * Returns the value of field 'conditionalAlarm'. The field
     * 'conditionalAlarm' has the following description: A
     * MatchCriteria may be specifiec for each of the 5 alarm
     * levels. Each level is optional and the alarm should be the
     * highest level to test true.
     * 
     * @return the value of field 'ConditionalAlarm'.
     */
    public org.hbird.xtce.castor.ConditionalAlarm getConditionalAlarm(
    ) {
        return this._conditionalAlarm;
    }

    /**
     * Returns the value of field 'customAlarm'. The field
     * 'customAlarm' has the following description: An escape for
     * ridiculously complex alarm conditions. Will trigger on
     * changes to the containing Parameter. 
     * 
     * @return the value of field 'CustomAlarm'.
     */
    public org.hbird.xtce.castor.CustomAlarm getCustomAlarm(
    ) {
        return this._customAlarm;
    }

    /**
     * Returns the value of field 'minViolations'. The field
     * 'minViolations' has the following description: Number of
     * successive values of the Parameter for the Alarm to trigger.
     * 
     * @return the value of field 'MinViolations'.
     */
    public long getMinViolations(
    ) {
        return this._minViolations;
    }

    /**
     * Returns the value of field
     * 'numericAlarmConditionTypeSequence'.
     * 
     * @return the value of field
     * 'NumericAlarmConditionTypeSequence'.
     */
    public org.hbird.xtce.castor.NumericAlarmConditionTypeSequence getNumericAlarmConditionTypeSequence(
    ) {
        return this._numericAlarmConditionTypeSequence;
    }

    /**
     * Method hasMinViolations.
     * 
     * @return true if at least one MinViolations has been added
     */
    public boolean hasMinViolations(
    ) {
        return this._has_minViolations;
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
     * Sets the value of field 'conditionalAlarm'. The field
     * 'conditionalAlarm' has the following description: A
     * MatchCriteria may be specifiec for each of the 5 alarm
     * levels. Each level is optional and the alarm should be the
     * highest level to test true.
     * 
     * @param conditionalAlarm the value of field 'conditionalAlarm'
     */
    public void setConditionalAlarm(
            final org.hbird.xtce.castor.ConditionalAlarm conditionalAlarm) {
        this._conditionalAlarm = conditionalAlarm;
        this._choiceValue = conditionalAlarm;
    }

    /**
     * Sets the value of field 'customAlarm'. The field
     * 'customAlarm' has the following description: An escape for
     * ridiculously complex alarm conditions. Will trigger on
     * changes to the containing Parameter. 
     * 
     * @param customAlarm the value of field 'customAlarm'.
     */
    public void setCustomAlarm(
            final org.hbird.xtce.castor.CustomAlarm customAlarm) {
        this._customAlarm = customAlarm;
        this._choiceValue = customAlarm;
    }

    /**
     * Sets the value of field 'minViolations'. The field
     * 'minViolations' has the following description: Number of
     * successive values of the Parameter for the Alarm to trigger.
     * 
     * @param minViolations the value of field 'minViolations'.
     */
    public void setMinViolations(
            final long minViolations) {
        this._minViolations = minViolations;
        this._has_minViolations = true;
    }

    /**
     * Sets the value of field 'numericAlarmConditionTypeSequence'.
     * 
     * @param numericAlarmConditionTypeSequence the value of field
     * 'numericAlarmConditionTypeSequence'.
     */
    public void setNumericAlarmConditionTypeSequence(
            final org.hbird.xtce.castor.NumericAlarmConditionTypeSequence numericAlarmConditionTypeSequence) {
        this._numericAlarmConditionTypeSequence = numericAlarmConditionTypeSequence;
        this._choiceValue = numericAlarmConditionTypeSequence;
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
     * org.hbird.xtce.castor.NumericAlarmConditionType
     */
    public static org.hbird.xtce.castor.NumericAlarmConditionType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.NumericAlarmConditionType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.NumericAlarmConditionType.class, reader);
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
