/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Holds an arbitrarily complex boolean expression
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class BooleanExpressionType implements java.io.Serializable {


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
    private com.logica.hummingbird.xtce.castor.Condition _condition;

    /**
     * Field _ANDedConditions.
     */
    private com.logica.hummingbird.xtce.castor.ANDedConditions _ANDedConditions;

    /**
     * Field _ORedConditions.
     */
    private com.logica.hummingbird.xtce.castor.ORedConditions _ORedConditions;


      //----------------/
     //- Constructors -/
    //----------------/

    public BooleanExpressionType() {
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
    public com.logica.hummingbird.xtce.castor.ANDedConditions getANDedConditions(
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
    public com.logica.hummingbird.xtce.castor.Condition getCondition(
    ) {
        return this._condition;
    }

    /**
     * Returns the value of field 'ORedConditions'.
     * 
     * @return the value of field 'ORedConditions'.
     */
    public com.logica.hummingbird.xtce.castor.ORedConditions getORedConditions(
    ) {
        return this._ORedConditions;
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
     * Sets the value of field 'ANDedConditions'.
     * 
     * @param ANDedConditions the value of field 'ANDedConditions'.
     */
    public void setANDedConditions(
            final com.logica.hummingbird.xtce.castor.ANDedConditions ANDedConditions) {
        this._ANDedConditions = ANDedConditions;
        this._choiceValue = ANDedConditions;
    }

    /**
     * Sets the value of field 'condition'.
     * 
     * @param condition the value of field 'condition'.
     */
    public void setCondition(
            final com.logica.hummingbird.xtce.castor.Condition condition) {
        this._condition = condition;
        this._choiceValue = condition;
    }

    /**
     * Sets the value of field 'ORedConditions'.
     * 
     * @param ORedConditions the value of field 'ORedConditions'.
     */
    public void setORedConditions(
            final com.logica.hummingbird.xtce.castor.ORedConditions ORedConditions) {
        this._ORedConditions = ORedConditions;
        this._choiceValue = ORedConditions;
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
     * com.logica.hummingbird.xtce.castor.BooleanExpressionType
     */
    public static com.logica.hummingbird.xtce.castor.BooleanExpressionType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.BooleanExpressionType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.BooleanExpressionType.class, reader);
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
