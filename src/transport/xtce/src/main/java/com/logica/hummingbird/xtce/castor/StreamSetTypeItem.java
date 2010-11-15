/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Class StreamSetTypeItem.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class StreamSetTypeItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _fixedFrameStream.
     */
    private com.logica.hummingbird.xtce.castor.FixedFrameStream _fixedFrameStream;

    /**
     * Field _variableFrameStream.
     */
    private com.logica.hummingbird.xtce.castor.VariableFrameStream _variableFrameStream;

    /**
     * Field _customStream.
     */
    private com.logica.hummingbird.xtce.castor.CustomStream _customStream;


      //----------------/
     //- Constructors -/
    //----------------/

    public StreamSetTypeItem() {
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
     * Returns the value of field 'customStream'.
     * 
     * @return the value of field 'CustomStream'.
     */
    public com.logica.hummingbird.xtce.castor.CustomStream getCustomStream(
    ) {
        return this._customStream;
    }

    /**
     * Returns the value of field 'fixedFrameStream'.
     * 
     * @return the value of field 'FixedFrameStream'.
     */
    public com.logica.hummingbird.xtce.castor.FixedFrameStream getFixedFrameStream(
    ) {
        return this._fixedFrameStream;
    }

    /**
     * Returns the value of field 'variableFrameStream'.
     * 
     * @return the value of field 'VariableFrameStream'.
     */
    public com.logica.hummingbird.xtce.castor.VariableFrameStream getVariableFrameStream(
    ) {
        return this._variableFrameStream;
    }

    /**
     * Sets the value of field 'customStream'.
     * 
     * @param customStream the value of field 'customStream'.
     */
    public void setCustomStream(
            final com.logica.hummingbird.xtce.castor.CustomStream customStream) {
        this._customStream = customStream;
        this._choiceValue = customStream;
    }

    /**
     * Sets the value of field 'fixedFrameStream'.
     * 
     * @param fixedFrameStream the value of field 'fixedFrameStream'
     */
    public void setFixedFrameStream(
            final com.logica.hummingbird.xtce.castor.FixedFrameStream fixedFrameStream) {
        this._fixedFrameStream = fixedFrameStream;
        this._choiceValue = fixedFrameStream;
    }

    /**
     * Sets the value of field 'variableFrameStream'.
     * 
     * @param variableFrameStream the value of field
     * 'variableFrameStream'.
     */
    public void setVariableFrameStream(
            final com.logica.hummingbird.xtce.castor.VariableFrameStream variableFrameStream) {
        this._variableFrameStream = variableFrameStream;
        this._choiceValue = variableFrameStream;
    }

}
