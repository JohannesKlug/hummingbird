/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * Class FloatArgumentType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class FloatArgumentType extends org.hbird.transport.xtce.castor.FloatDataType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _defaultAlarm.
     */
    private org.hbird.transport.xtce.castor.DefaultAlarm _defaultAlarm;

    /**
     * Field _contextAlarmList.
     */
    private org.hbird.transport.xtce.castor.CommandMetaDataTypeArgumentTypeSetFloatArgumentTypeContextAlarmList _contextAlarmList;


      //----------------/
     //- Constructors -/
    //----------------/

    public FloatArgumentType() {
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
    public org.hbird.transport.xtce.castor.CommandMetaDataTypeArgumentTypeSetFloatArgumentTypeContextAlarmList getContextAlarmList(
    ) {
        return this._contextAlarmList;
    }

    /**
     * Returns the value of field 'defaultAlarm'.
     * 
     * @return the value of field 'DefaultAlarm'.
     */
    public org.hbird.transport.xtce.castor.DefaultAlarm getDefaultAlarm(
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
            final org.hbird.transport.xtce.castor.CommandMetaDataTypeArgumentTypeSetFloatArgumentTypeContextAlarmList contextAlarmList) {
        this._contextAlarmList = contextAlarmList;
    }

    /**
     * Sets the value of field 'defaultAlarm'.
     * 
     * @param defaultAlarm the value of field 'defaultAlarm'.
     */
    public void setDefaultAlarm(
            final org.hbird.transport.xtce.castor.DefaultAlarm defaultAlarm) {
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
     * org.hbird.xtce.castor.FloatArgumentType
     */
    public static org.hbird.transport.xtce.castor.FloatArgumentType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.FloatArgumentType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.FloatArgumentType.class, reader);
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
