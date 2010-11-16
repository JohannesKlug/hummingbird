/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * Class ORedConditionsTypeItem.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ORedConditionsTypeItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _condition.
     */
    private org.hbird.transport.xtce.castor.Condition _condition;

    /**
     * Field _ANDedConditions.
     */
    private org.hbird.transport.xtce.castor.ANDedConditions _ANDedConditions;


      //----------------/
     //- Constructors -/
    //----------------/

    public ORedConditionsTypeItem() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'ANDedConditions'.
     * 
     * @return the value of field 'ANDedConditions'.
     */
    public org.hbird.transport.xtce.castor.ANDedConditions getANDedConditions(
    ) {
        return this._ANDedConditions;
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
     * Returns the value of field 'condition'.
     * 
     * @return the value of field 'Condition'.
     */
    public org.hbird.transport.xtce.castor.Condition getCondition(
    ) {
        return this._condition;
    }

    /**
     * Sets the value of field 'ANDedConditions'.
     * 
     * @param ANDedConditions the value of field 'ANDedConditions'.
     */
    public void setANDedConditions(
            final org.hbird.transport.xtce.castor.ANDedConditions ANDedConditions) {
        this._ANDedConditions = ANDedConditions;
        this._choiceValue = ANDedConditions;
    }

    /**
     * Sets the value of field 'condition'.
     * 
     * @param condition the value of field 'condition'.
     */
    public void setCondition(
            final org.hbird.transport.xtce.castor.Condition condition) {
        this._condition = condition;
        this._choiceValue = condition;
    }

}
