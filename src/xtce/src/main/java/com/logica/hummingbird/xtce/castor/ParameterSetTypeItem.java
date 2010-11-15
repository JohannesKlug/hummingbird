/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Class ParameterSetTypeItem.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ParameterSetTypeItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _parameter.
     */
    private com.logica.hummingbird.xtce.castor.Parameter _parameter;

    /**
     * Used to include a Parameter defined in another sub-system in
     * this sub-system.
     */
    private com.logica.hummingbird.xtce.castor.ParameterRef _parameterRef;


      //----------------/
     //- Constructors -/
    //----------------/

    public ParameterSetTypeItem() {
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
     * Returns the value of field 'parameter'.
     * 
     * @return the value of field 'Parameter'.
     */
    public com.logica.hummingbird.xtce.castor.Parameter getParameter(
    ) {
        return this._parameter;
    }

    /**
     * Returns the value of field 'parameterRef'. The field
     * 'parameterRef' has the following description: Used to
     * include a Parameter defined in another sub-system in this
     * sub-system.
     * 
     * @return the value of field 'ParameterRef'.
     */
    public com.logica.hummingbird.xtce.castor.ParameterRef getParameterRef(
    ) {
        return this._parameterRef;
    }

    /**
     * Sets the value of field 'parameter'.
     * 
     * @param parameter the value of field 'parameter'.
     */
    public void setParameter(
            final com.logica.hummingbird.xtce.castor.Parameter parameter) {
        this._parameter = parameter;
        this._choiceValue = parameter;
    }

    /**
     * Sets the value of field 'parameterRef'. The field
     * 'parameterRef' has the following description: Used to
     * include a Parameter defined in another sub-system in this
     * sub-system.
     * 
     * @param parameterRef the value of field 'parameterRef'.
     */
    public void setParameterRef(
            final com.logica.hummingbird.xtce.castor.ParameterRef parameterRef) {
        this._parameterRef = parameterRef;
        this._choiceValue = parameterRef;
    }

}
