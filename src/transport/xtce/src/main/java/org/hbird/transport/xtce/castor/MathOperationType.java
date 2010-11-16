/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * A simple math operation
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class MathOperationType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _mathOperationTypeChoice.
     */
    private org.hbird.transport.xtce.castor.MathOperationTypeChoice _mathOperationTypeChoice;

    /**
     * Field _mathOperationTypeSequence.
     */
    private org.hbird.transport.xtce.castor.MathOperationTypeSequence _mathOperationTypeSequence;


      //----------------/
     //- Constructors -/
    //----------------/

    public MathOperationType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'mathOperationTypeChoice'.
     * 
     * @return the value of field 'MathOperationTypeChoice'.
     */
    public org.hbird.transport.xtce.castor.MathOperationTypeChoice getMathOperationTypeChoice(
    ) {
        return this._mathOperationTypeChoice;
    }

    /**
     * Returns the value of field 'mathOperationTypeSequence'.
     * 
     * @return the value of field 'MathOperationTypeSequence'.
     */
    public org.hbird.transport.xtce.castor.MathOperationTypeSequence getMathOperationTypeSequence(
    ) {
        return this._mathOperationTypeSequence;
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
     * Sets the value of field 'mathOperationTypeChoice'.
     * 
     * @param mathOperationTypeChoice the value of field
     * 'mathOperationTypeChoice'.
     */
    public void setMathOperationTypeChoice(
            final org.hbird.transport.xtce.castor.MathOperationTypeChoice mathOperationTypeChoice) {
        this._mathOperationTypeChoice = mathOperationTypeChoice;
    }

    /**
     * Sets the value of field 'mathOperationTypeSequence'.
     * 
     * @param mathOperationTypeSequence the value of field
     * 'mathOperationTypeSequence'.
     */
    public void setMathOperationTypeSequence(
            final org.hbird.transport.xtce.castor.MathOperationTypeSequence mathOperationTypeSequence) {
        this._mathOperationTypeSequence = mathOperationTypeSequence;
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
     * org.hbird.xtce.castor.MathOperationType
     */
    public static org.hbird.transport.xtce.castor.MathOperationType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.MathOperationType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.MathOperationType.class, reader);
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
