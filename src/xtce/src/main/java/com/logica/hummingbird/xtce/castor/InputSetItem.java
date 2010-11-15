/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Class InputSetItem.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class InputSetItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Names an input parameter to the algorithm. There are two
     * attributes to InputParm, inputName and parameterName.
     * parameterName is a parameter reference name for a parameter
     * that will be used in this algorithm. inputName is an
     * optional "friendly" name for the input parameter. 
     */
    private com.logica.hummingbird.xtce.castor.InputAlgorithmTypeInputSetParameterInstanceRef _parameterInstanceRef;

    /**
     * Names and provides a value for a constant input to the
     * algorithm. There are two attributes to Constant,
     * constantName and value. constantName is a variable name in
     * the algorithm to be executed. value is the value of the
     * constant to be used.
     */
    private com.logica.hummingbird.xtce.castor.Constant _constant;


      //----------------/
     //- Constructors -/
    //----------------/

    public InputSetItem() {
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
     * Returns the value of field 'constant'. The field 'constant'
     * has the following description: Names and provides a value
     * for a constant input to the algorithm. There are two
     * attributes to Constant, constantName and value. constantName
     * is a variable name in the algorithm to be executed. value is
     * the value of the constant to be used.
     * 
     * @return the value of field 'Constant'.
     */
    public com.logica.hummingbird.xtce.castor.Constant getConstant(
    ) {
        return this._constant;
    }

    /**
     * Returns the value of field 'parameterInstanceRef'. The field
     * 'parameterInstanceRef' has the following description: Names
     * an input parameter to the algorithm. There are two
     * attributes to InputParm, inputName and parameterName.
     * parameterName is a parameter reference name for a parameter
     * that will be used in this algorithm. inputName is an
     * optional "friendly" name for the input parameter. 
     * 
     * @return the value of field 'ParameterInstanceRef'.
     */
    public com.logica.hummingbird.xtce.castor.InputAlgorithmTypeInputSetParameterInstanceRef getParameterInstanceRef(
    ) {
        return this._parameterInstanceRef;
    }

    /**
     * Sets the value of field 'constant'. The field 'constant' has
     * the following description: Names and provides a value for a
     * constant input to the algorithm. There are two attributes to
     * Constant, constantName and value. constantName is a variable
     * name in the algorithm to be executed. value is the value of
     * the constant to be used.
     * 
     * @param constant the value of field 'constant'.
     */
    public void setConstant(
            final com.logica.hummingbird.xtce.castor.Constant constant) {
        this._constant = constant;
        this._choiceValue = constant;
    }

    /**
     * Sets the value of field 'parameterInstanceRef'. The field
     * 'parameterInstanceRef' has the following description: Names
     * an input parameter to the algorithm. There are two
     * attributes to InputParm, inputName and parameterName.
     * parameterName is a parameter reference name for a parameter
     * that will be used in this algorithm. inputName is an
     * optional "friendly" name for the input parameter. 
     * 
     * @param parameterInstanceRef the value of field
     * 'parameterInstanceRef'.
     */
    public void setParameterInstanceRef(
            final com.logica.hummingbird.xtce.castor.InputAlgorithmTypeInputSetParameterInstanceRef parameterInstanceRef) {
        this._parameterInstanceRef = parameterInstanceRef;
        this._choiceValue = parameterInstanceRef;
    }

}
