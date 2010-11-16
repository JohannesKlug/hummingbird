/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * Class TriggerTypeItem.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class TriggerTypeItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Names a parameter that upon change will start the execution
     * of the algorithm. Holds a parameter reference name for a
     * parameter that when it changes, will cause this algorithm to
     * be executed.
     */
    private org.hbird.transport.xtce.castor.TriggerTypeParameterRef _parameterRef;

    /**
     * Field _triggerFrequency.
     */
    private org.exolab.castor.types.Duration _triggerFrequency;


      //----------------/
     //- Constructors -/
    //----------------/

    public TriggerTypeItem() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'parameterRef'. The field
     * 'parameterRef' has the following description: Names a
     * parameter that upon change will start the execution of the
     * algorithm. Holds a parameter reference name for a parameter
     * that when it changes, will cause this algorithm to be
     * executed.
     * 
     * @return the value of field 'ParameterRef'.
     */
    public org.hbird.transport.xtce.castor.TriggerTypeParameterRef getParameterRef(
    ) {
        return this._parameterRef;
    }

    /**
     * Returns the value of field 'triggerFrequency'.
     * 
     * @return the value of field 'TriggerFrequency'.
     */
    public org.exolab.castor.types.Duration getTriggerFrequency(
    ) {
        return this._triggerFrequency;
    }

    /**
     * Sets the value of field 'parameterRef'. The field
     * 'parameterRef' has the following description: Names a
     * parameter that upon change will start the execution of the
     * algorithm. Holds a parameter reference name for a parameter
     * that when it changes, will cause this algorithm to be
     * executed.
     * 
     * @param parameterRef the value of field 'parameterRef'.
     */
    public void setParameterRef(
            final org.hbird.transport.xtce.castor.TriggerTypeParameterRef parameterRef) {
        this._parameterRef = parameterRef;
        this._choiceValue = parameterRef;
    }

    /**
     * Sets the value of field 'triggerFrequency'.
     * 
     * @param triggerFrequency the value of field 'triggerFrequency'
     */
    public void setTriggerFrequency(
            final org.exolab.castor.types.Duration triggerFrequency) {
        this._triggerFrequency = triggerFrequency;
        this._choiceValue = triggerFrequency;
    }

}
