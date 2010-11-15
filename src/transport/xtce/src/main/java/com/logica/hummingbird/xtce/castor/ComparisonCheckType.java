/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * A ParameterInstanceRef to a value or another parameter instance
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ComparisonCheckType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _parameterInstanceRef.
     */
    private org.hbird.xtce.castor.ParameterInstanceRef _parameterInstanceRef;

    /**
     * Field _comparisonOperator.
     */
    private org.hbird.xtce.castor.types.ComparisonOperatorsType _comparisonOperator;

    /**
     * Field _comparisonCheckTypeChoice.
     */
    private org.hbird.xtce.castor.ComparisonCheckTypeChoice _comparisonCheckTypeChoice;


      //----------------/
     //- Constructors -/
    //----------------/

    public ComparisonCheckType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'comparisonCheckTypeChoice'.
     * 
     * @return the value of field 'ComparisonCheckTypeChoice'.
     */
    public org.hbird.xtce.castor.ComparisonCheckTypeChoice getComparisonCheckTypeChoice(
    ) {
        return this._comparisonCheckTypeChoice;
    }

    /**
     * Returns the value of field 'comparisonOperator'.
     * 
     * @return the value of field 'ComparisonOperator'.
     */
    public org.hbird.xtce.castor.types.ComparisonOperatorsType getComparisonOperator(
    ) {
        return this._comparisonOperator;
    }

    /**
     * Returns the value of field 'parameterInstanceRef'.
     * 
     * @return the value of field 'ParameterInstanceRef'.
     */
    public org.hbird.xtce.castor.ParameterInstanceRef getParameterInstanceRef(
    ) {
        return this._parameterInstanceRef;
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
     * Sets the value of field 'comparisonCheckTypeChoice'.
     * 
     * @param comparisonCheckTypeChoice the value of field
     * 'comparisonCheckTypeChoice'.
     */
    public void setComparisonCheckTypeChoice(
            final org.hbird.xtce.castor.ComparisonCheckTypeChoice comparisonCheckTypeChoice) {
        this._comparisonCheckTypeChoice = comparisonCheckTypeChoice;
    }

    /**
     * Sets the value of field 'comparisonOperator'.
     * 
     * @param comparisonOperator the value of field
     * 'comparisonOperator'.
     */
    public void setComparisonOperator(
            final org.hbird.xtce.castor.types.ComparisonOperatorsType comparisonOperator) {
        this._comparisonOperator = comparisonOperator;
    }

    /**
     * Sets the value of field 'parameterInstanceRef'.
     * 
     * @param parameterInstanceRef the value of field
     * 'parameterInstanceRef'.
     */
    public void setParameterInstanceRef(
            final org.hbird.xtce.castor.ParameterInstanceRef parameterInstanceRef) {
        this._parameterInstanceRef = parameterInstanceRef;
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
     * org.hbird.xtce.castor.ComparisonCheckType
     */
    public static org.hbird.xtce.castor.ComparisonCheckType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.ComparisonCheckType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.ComparisonCheckType.class, reader);
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
