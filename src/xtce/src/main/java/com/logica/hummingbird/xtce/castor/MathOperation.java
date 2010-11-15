/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Class MathOperation.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class MathOperation extends com.logica.hummingbird.xtce.castor.MathOperationType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _outputParameterRef.
     */
    private java.lang.String _outputParameterRef;

    /**
     * Field _triggerSet.
     */
    private com.logica.hummingbird.xtce.castor.TriggerSet _triggerSet;


      //----------------/
     //- Constructors -/
    //----------------/

    public MathOperation() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'outputParameterRef'.
     * 
     * @return the value of field 'OutputParameterRef'.
     */
    public java.lang.String getOutputParameterRef(
    ) {
        return this._outputParameterRef;
    }

    /**
     * Returns the value of field 'triggerSet'.
     * 
     * @return the value of field 'TriggerSet'.
     */
    public com.logica.hummingbird.xtce.castor.TriggerSet getTriggerSet(
    ) {
        return this._triggerSet;
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
     * Sets the value of field 'outputParameterRef'.
     * 
     * @param outputParameterRef the value of field
     * 'outputParameterRef'.
     */
    public void setOutputParameterRef(
            final java.lang.String outputParameterRef) {
        this._outputParameterRef = outputParameterRef;
    }

    /**
     * Sets the value of field 'triggerSet'.
     * 
     * @param triggerSet the value of field 'triggerSet'.
     */
    public void setTriggerSet(
            final com.logica.hummingbird.xtce.castor.TriggerSet triggerSet) {
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
     * com.logica.hummingbird.xtce.castor.MathOperation
     */
    public static com.logica.hummingbird.xtce.castor.MathOperation unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.MathOperation) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.MathOperation.class, reader);
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
