/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * A MatchCriteria may be specifiec for each of the 5 alarm levels.
 * Each level is optional and the alarm should be the highest level
 * to test true.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ConditionalAlarm implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _staticAlarmConditions.
     */
    private com.logica.hummingbird.xtce.castor.StaticAlarmConditions _staticAlarmConditions;

    /**
     * Field _changePerSecondAlarmConditions.
     */
    private com.logica.hummingbird.xtce.castor.ChangePerSecondAlarmConditions _changePerSecondAlarmConditions;


      //----------------/
     //- Constructors -/
    //----------------/

    public ConditionalAlarm() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'changePerSecondAlarmConditions'.
     * 
     * @return the value of field 'ChangePerSecondAlarmConditions'.
     */
    public com.logica.hummingbird.xtce.castor.ChangePerSecondAlarmConditions getChangePerSecondAlarmConditions(
    ) {
        return this._changePerSecondAlarmConditions;
    }

    /**
     * Returns the value of field 'staticAlarmConditions'.
     * 
     * @return the value of field 'StaticAlarmConditions'.
     */
    public com.logica.hummingbird.xtce.castor.StaticAlarmConditions getStaticAlarmConditions(
    ) {
        return this._staticAlarmConditions;
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
     * Sets the value of field 'changePerSecondAlarmConditions'.
     * 
     * @param changePerSecondAlarmConditions the value of field
     * 'changePerSecondAlarmConditions'.
     */
    public void setChangePerSecondAlarmConditions(
            final com.logica.hummingbird.xtce.castor.ChangePerSecondAlarmConditions changePerSecondAlarmConditions) {
        this._changePerSecondAlarmConditions = changePerSecondAlarmConditions;
    }

    /**
     * Sets the value of field 'staticAlarmConditions'.
     * 
     * @param staticAlarmConditions the value of field
     * 'staticAlarmConditions'.
     */
    public void setStaticAlarmConditions(
            final com.logica.hummingbird.xtce.castor.StaticAlarmConditions staticAlarmConditions) {
        this._staticAlarmConditions = staticAlarmConditions;
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
     * com.logica.hummingbird.xtce.castor.ConditionalAlarm
     */
    public static com.logica.hummingbird.xtce.castor.ConditionalAlarm unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.ConditionalAlarm) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.ConditionalAlarm.class, reader);
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
