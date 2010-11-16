/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * A set of labled triggers is added to the
 * SimpleInputOutputAlgorithmType
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class InputOutputTriggerAlgorithmType extends org.hbird.transport.xtce.castor.InputOutputAlgorithmType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * First telemetry container from which the output parameter
     * should be calculated.
     */
    private java.lang.String _triggerContainer;

    /**
     * Algorithm processing priority.
     */
    private long _priority;

    /**
     * keeps track of state for field: _priority
     */
    private boolean _has_priority;

    /**
     * Field _triggerSet.
     */
    private org.hbird.transport.xtce.castor.TriggerSet _triggerSet;


      //----------------/
     //- Constructors -/
    //----------------/

    public InputOutputTriggerAlgorithmType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deletePriority(
    ) {
        this._has_priority= false;
    }

    /**
     * Returns the value of field 'priority'. The field 'priority'
     * has the following description: Algorithm processing
     * priority.
     * 
     * @return the value of field 'Priority'.
     */
    public long getPriority(
    ) {
        return this._priority;
    }

    /**
     * Returns the value of field 'triggerContainer'. The field
     * 'triggerContainer' has the following description: First
     * telemetry container from which the output parameter should
     * be calculated.
     * 
     * @return the value of field 'TriggerContainer'.
     */
    public java.lang.String getTriggerContainer(
    ) {
        return this._triggerContainer;
    }

    /**
     * Returns the value of field 'triggerSet'.
     * 
     * @return the value of field 'TriggerSet'.
     */
    public org.hbird.transport.xtce.castor.TriggerSet getTriggerSet(
    ) {
        return this._triggerSet;
    }

    /**
     * Method hasPriority.
     * 
     * @return true if at least one Priority has been added
     */
    public boolean hasPriority(
    ) {
        return this._has_priority;
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
     * Sets the value of field 'priority'. The field 'priority' has
     * the following description: Algorithm processing priority.
     * 
     * @param priority the value of field 'priority'.
     */
    public void setPriority(
            final long priority) {
        this._priority = priority;
        this._has_priority = true;
    }

    /**
     * Sets the value of field 'triggerContainer'. The field
     * 'triggerContainer' has the following description: First
     * telemetry container from which the output parameter should
     * be calculated.
     * 
     * @param triggerContainer the value of field 'triggerContainer'
     */
    public void setTriggerContainer(
            final java.lang.String triggerContainer) {
        this._triggerContainer = triggerContainer;
    }

    /**
     * Sets the value of field 'triggerSet'.
     * 
     * @param triggerSet the value of field 'triggerSet'.
     */
    public void setTriggerSet(
            final org.hbird.transport.xtce.castor.TriggerSet triggerSet) {
        this._triggerSet = triggerSet;
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
     * org.hbird.xtce.castor.InputOutputTriggerAlgorithmType
     */
    public static org.hbird.transport.xtce.castor.InputOutputTriggerAlgorithmType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.InputOutputTriggerAlgorithmType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.InputOutputTriggerAlgorithmType.class, reader);
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
