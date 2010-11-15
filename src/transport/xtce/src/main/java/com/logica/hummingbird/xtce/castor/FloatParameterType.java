/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Class FloatParameterType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class FloatParameterType extends com.logica.hummingbird.xtce.castor.FloatDataType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _defaultAlarm.
     */
    private com.logica.hummingbird.xtce.castor.DefaultAlarm _defaultAlarm;

    /**
     * Field _contextAlarmList.
     */
    private com.logica.hummingbird.xtce.castor.ParameterTypeSetTypeFloatParameterTypeContextAlarmList _contextAlarmList;


      //----------------/
     //- Constructors -/
    //----------------/

    public FloatParameterType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'contextAlarmList'.
     * 
     * @return the value of field 'ContextAlarmList'.
     */
    public com.logica.hummingbird.xtce.castor.ParameterTypeSetTypeFloatParameterTypeContextAlarmList getContextAlarmList(
    ) {
        return this._contextAlarmList;
    }

    /**
     * Returns the value of field 'defaultAlarm'.
     * 
     * @return the value of field 'DefaultAlarm'.
     */
    public com.logica.hummingbird.xtce.castor.DefaultAlarm getDefaultAlarm(
    ) {
        return this._defaultAlarm;
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
     * Sets the value of field 'contextAlarmList'.
     * 
     * @param contextAlarmList the value of field 'contextAlarmList'
     */
    public void setContextAlarmList(
            final com.logica.hummingbird.xtce.castor.ParameterTypeSetTypeFloatParameterTypeContextAlarmList contextAlarmList) {
        this._contextAlarmList = contextAlarmList;
    }

    /**
     * Sets the value of field 'defaultAlarm'.
     * 
     * @param defaultAlarm the value of field 'defaultAlarm'.
     */
    public void setDefaultAlarm(
            final com.logica.hummingbird.xtce.castor.DefaultAlarm defaultAlarm) {
        this._defaultAlarm = defaultAlarm;
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
     * com.logica.hummingbird.xtce.castor.FloatParameterType
     */
    public static com.logica.hummingbird.xtce.castor.FloatParameterType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.FloatParameterType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.FloatParameterType.class, reader);
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
