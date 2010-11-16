/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * Class MathOperationTypeSequence.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class MathOperationTypeSequence implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _operator.
     */
    private org.hbird.transport.xtce.castor.types.MathOperatorsType _operator;

    /**
     * Field _mathOperationTypeSequenceChoice.
     */
    private org.hbird.transport.xtce.castor.MathOperationTypeSequenceChoice _mathOperationTypeSequenceChoice;


      //----------------/
     //- Constructors -/
    //----------------/

    public MathOperationTypeSequence() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field
     * 'mathOperationTypeSequenceChoice'.
     * 
     * @return the value of field 'MathOperationTypeSequenceChoice'.
     */
    public org.hbird.transport.xtce.castor.MathOperationTypeSequenceChoice getMathOperationTypeSequenceChoice(
    ) {
        return this._mathOperationTypeSequenceChoice;
    }

    /**
     * Returns the value of field 'operator'.
     * 
     * @return the value of field 'Operator'.
     */
    public org.hbird.transport.xtce.castor.types.MathOperatorsType getOperator(
    ) {
        return this._operator;
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
     * Sets the value of field 'mathOperationTypeSequenceChoice'.
     * 
     * @param mathOperationTypeSequenceChoice the value of field
     * 'mathOperationTypeSequenceChoice'.
     */
    public void setMathOperationTypeSequenceChoice(
            final org.hbird.transport.xtce.castor.MathOperationTypeSequenceChoice mathOperationTypeSequenceChoice) {
        this._mathOperationTypeSequenceChoice = mathOperationTypeSequenceChoice;
    }

    /**
     * Sets the value of field 'operator'.
     * 
     * @param operator the value of field 'operator'.
     */
    public void setOperator(
            final org.hbird.transport.xtce.castor.types.MathOperatorsType operator) {
        this._operator = operator;
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
     * org.hbird.xtce.castor.MathOperationTypeSequence
     */
    public static org.hbird.transport.xtce.castor.MathOperationTypeSequence unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.MathOperationTypeSequence) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.MathOperationTypeSequence.class, reader);
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
