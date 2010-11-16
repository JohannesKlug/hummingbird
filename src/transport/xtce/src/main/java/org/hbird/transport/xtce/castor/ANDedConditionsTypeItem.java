/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * Class ANDedConditionsTypeItem.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ANDedConditionsTypeItem implements java.io.Serializable {


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
     * Field _ORedConditions.
     */
    private org.hbird.transport.xtce.castor.ORedConditions _ORedConditions;


      //----------------/
     //- Constructors -/
    //----------------/

    public ANDedConditionsTypeItem() {
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
     * Returns the value of field 'condition'.
     * 
     * @return the value of field 'Condition'.
     */
    public org.hbird.transport.xtce.castor.Condition getCondition(
    ) {
        return this._condition;
    }

    /**
     * Returns the value of field 'ORedConditions'.
     * 
     * @return the value of field 'ORedConditions'.
     */
    public org.hbird.transport.xtce.castor.ORedConditions getORedConditions(
    ) {
        return this._ORedConditions;
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

    /**
     * Sets the value of field 'ORedConditions'.
     * 
     * @param ORedConditions the value of field 'ORedConditions'.
     */
    public void setORedConditions(
            final org.hbird.transport.xtce.castor.ORedConditions ORedConditions) {
        this._ORedConditions = ORedConditions;
        this._choiceValue = ORedConditions;
    }

}
