/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * Class ParameterTypeSetTypeItem.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ParameterTypeSetTypeItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _stringParameterType.
     */
    private org.hbird.transport.xtce.castor.StringParameterType _stringParameterType;

    /**
     * Field _enumeratedParameterType.
     */
    private org.hbird.transport.xtce.castor.EnumeratedParameterType _enumeratedParameterType;

    /**
     * Field _integerParameterType.
     */
    private org.hbird.transport.xtce.castor.IntegerParameterType _integerParameterType;

    /**
     * Field _binaryParameterType.
     */
    private org.hbird.transport.xtce.castor.BinaryParameterType _binaryParameterType;

    /**
     * Field _floatParameterType.
     */
    private org.hbird.transport.xtce.castor.FloatParameterType _floatParameterType;

    /**
     * Field _booleanParameterType.
     */
    private org.hbird.transport.xtce.castor.BooleanParameterType _booleanParameterType;

    /**
     * Field _relativeTimeParameterType.
     */
    private org.hbird.transport.xtce.castor.RelativeTimeParameterType _relativeTimeParameterType;

    /**
     * Field _absoluteTimeParameterType.
     */
    private org.hbird.transport.xtce.castor.AbsoluteTimeParameterType _absoluteTimeParameterType;

    /**
     * An array type. Will be an array of parameters of the type
     * referenced in 'arrayTypeRef' and have the number of array
     * dimensions as specified in 'numberOfDimensions' 
     */
    private org.hbird.transport.xtce.castor.ArrayParameterType _arrayParameterType;


      //----------------/
     //- Constructors -/
    //----------------/

    public ParameterTypeSetTypeItem() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'absoluteTimeParameterType'.
     * 
     * @return the value of field 'AbsoluteTimeParameterType'.
     */
    public org.hbird.transport.xtce.castor.AbsoluteTimeParameterType getAbsoluteTimeParameterType(
    ) {
        return this._absoluteTimeParameterType;
    }

    /**
     * Returns the value of field 'arrayParameterType'. The field
     * 'arrayParameterType' has the following description: An array
     * type. Will be an array of parameters of the type referenced
     * in 'arrayTypeRef' and have the number of array dimensions as
     * specified in 'numberOfDimensions' 
     * 
     * @return the value of field 'ArrayParameterType'.
     */
    public org.hbird.transport.xtce.castor.ArrayParameterType getArrayParameterType(
    ) {
        return this._arrayParameterType;
    }

    /**
     * Returns the value of field 'binaryParameterType'.
     * 
     * @return the value of field 'BinaryParameterType'.
     */
    public org.hbird.transport.xtce.castor.BinaryParameterType getBinaryParameterType(
    ) {
        return this._binaryParameterType;
    }

    /**
     * Returns the value of field 'booleanParameterType'.
     * 
     * @return the value of field 'BooleanParameterType'.
     */
    public org.hbird.transport.xtce.castor.BooleanParameterType getBooleanParameterType(
    ) {
        return this._booleanParameterType;
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
     * Returns the value of field 'enumeratedParameterType'.
     * 
     * @return the value of field 'EnumeratedParameterType'.
     */
    public org.hbird.transport.xtce.castor.EnumeratedParameterType getEnumeratedParameterType(
    ) {
        return this._enumeratedParameterType;
    }

    /**
     * Returns the value of field 'floatParameterType'.
     * 
     * @return the value of field 'FloatParameterType'.
     */
    public org.hbird.transport.xtce.castor.FloatParameterType getFloatParameterType(
    ) {
        return this._floatParameterType;
    }

    /**
     * Returns the value of field 'integerParameterType'.
     * 
     * @return the value of field 'IntegerParameterType'.
     */
    public org.hbird.transport.xtce.castor.IntegerParameterType getIntegerParameterType(
    ) {
        return this._integerParameterType;
    }

    /**
     * Returns the value of field 'relativeTimeParameterType'.
     * 
     * @return the value of field 'RelativeTimeParameterType'.
     */
    public org.hbird.transport.xtce.castor.RelativeTimeParameterType getRelativeTimeParameterType(
    ) {
        return this._relativeTimeParameterType;
    }

    /**
     * Returns the value of field 'stringParameterType'.
     * 
     * @return the value of field 'StringParameterType'.
     */
    public org.hbird.transport.xtce.castor.StringParameterType getStringParameterType(
    ) {
        return this._stringParameterType;
    }

    /**
     * Sets the value of field 'absoluteTimeParameterType'.
     * 
     * @param absoluteTimeParameterType the value of field
     * 'absoluteTimeParameterType'.
     */
    public void setAbsoluteTimeParameterType(
            final org.hbird.transport.xtce.castor.AbsoluteTimeParameterType absoluteTimeParameterType) {
        this._absoluteTimeParameterType = absoluteTimeParameterType;
        this._choiceValue = absoluteTimeParameterType;
    }

    /**
     * Sets the value of field 'arrayParameterType'. The field
     * 'arrayParameterType' has the following description: An array
     * type. Will be an array of parameters of the type referenced
     * in 'arrayTypeRef' and have the number of array dimensions as
     * specified in 'numberOfDimensions' 
     * 
     * @param arrayParameterType the value of field
     * 'arrayParameterType'.
     */
    public void setArrayParameterType(
            final org.hbird.transport.xtce.castor.ArrayParameterType arrayParameterType) {
        this._arrayParameterType = arrayParameterType;
        this._choiceValue = arrayParameterType;
    }

    /**
     * Sets the value of field 'binaryParameterType'.
     * 
     * @param binaryParameterType the value of field
     * 'binaryParameterType'.
     */
    public void setBinaryParameterType(
            final org.hbird.transport.xtce.castor.BinaryParameterType binaryParameterType) {
        this._binaryParameterType = binaryParameterType;
        this._choiceValue = binaryParameterType;
    }

    /**
     * Sets the value of field 'booleanParameterType'.
     * 
     * @param booleanParameterType the value of field
     * 'booleanParameterType'.
     */
    public void setBooleanParameterType(
            final org.hbird.transport.xtce.castor.BooleanParameterType booleanParameterType) {
        this._booleanParameterType = booleanParameterType;
        this._choiceValue = booleanParameterType;
    }

    /**
     * Sets the value of field 'enumeratedParameterType'.
     * 
     * @param enumeratedParameterType the value of field
     * 'enumeratedParameterType'.
     */
    public void setEnumeratedParameterType(
            final org.hbird.transport.xtce.castor.EnumeratedParameterType enumeratedParameterType) {
        this._enumeratedParameterType = enumeratedParameterType;
        this._choiceValue = enumeratedParameterType;
    }

    /**
     * Sets the value of field 'floatParameterType'.
     * 
     * @param floatParameterType the value of field
     * 'floatParameterType'.
     */
    public void setFloatParameterType(
            final org.hbird.transport.xtce.castor.FloatParameterType floatParameterType) {
        this._floatParameterType = floatParameterType;
        this._choiceValue = floatParameterType;
    }

    /**
     * Sets the value of field 'integerParameterType'.
     * 
     * @param integerParameterType the value of field
     * 'integerParameterType'.
     */
    public void setIntegerParameterType(
            final org.hbird.transport.xtce.castor.IntegerParameterType integerParameterType) {
        this._integerParameterType = integerParameterType;
        this._choiceValue = integerParameterType;
    }

    /**
     * Sets the value of field 'relativeTimeParameterType'.
     * 
     * @param relativeTimeParameterType the value of field
     * 'relativeTimeParameterType'.
     */
    public void setRelativeTimeParameterType(
            final org.hbird.transport.xtce.castor.RelativeTimeParameterType relativeTimeParameterType) {
        this._relativeTimeParameterType = relativeTimeParameterType;
        this._choiceValue = relativeTimeParameterType;
    }

    /**
     * Sets the value of field 'stringParameterType'.
     * 
     * @param stringParameterType the value of field
     * 'stringParameterType'.
     */
    public void setStringParameterType(
            final org.hbird.transport.xtce.castor.StringParameterType stringParameterType) {
        this._stringParameterType = stringParameterType;
        this._choiceValue = stringParameterType;
    }

}
