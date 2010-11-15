/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Class AlgorithmSetTypeItem.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class AlgorithmSetTypeItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _customAlgorithm.
     */
    private com.logica.hummingbird.xtce.castor.AlgorithmSetTypeCustomAlgorithm _customAlgorithm;

    /**
     * Field _mathAlgorithm.
     */
    private com.logica.hummingbird.xtce.castor.MathAlgorithm _mathAlgorithm;


      //----------------/
     //- Constructors -/
    //----------------/

    public AlgorithmSetTypeItem() {
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
     * Returns the value of field 'customAlgorithm'.
     * 
     * @return the value of field 'CustomAlgorithm'.
     */
    public com.logica.hummingbird.xtce.castor.AlgorithmSetTypeCustomAlgorithm getCustomAlgorithm(
    ) {
        return this._customAlgorithm;
    }

    /**
     * Returns the value of field 'mathAlgorithm'.
     * 
     * @return the value of field 'MathAlgorithm'.
     */
    public com.logica.hummingbird.xtce.castor.MathAlgorithm getMathAlgorithm(
    ) {
        return this._mathAlgorithm;
    }

    /**
     * Sets the value of field 'customAlgorithm'.
     * 
     * @param customAlgorithm the value of field 'customAlgorithm'.
     */
    public void setCustomAlgorithm(
            final com.logica.hummingbird.xtce.castor.AlgorithmSetTypeCustomAlgorithm customAlgorithm) {
        this._customAlgorithm = customAlgorithm;
        this._choiceValue = customAlgorithm;
    }

    /**
     * Sets the value of field 'mathAlgorithm'.
     * 
     * @param mathAlgorithm the value of field 'mathAlgorithm'.
     */
    public void setMathAlgorithm(
            final com.logica.hummingbird.xtce.castor.MathAlgorithm mathAlgorithm) {
        this._mathAlgorithm = mathAlgorithm;
        this._choiceValue = mathAlgorithm;
    }

}
