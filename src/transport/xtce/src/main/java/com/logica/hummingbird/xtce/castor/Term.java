/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * A term in a polynomial expresssion. 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Term implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _coefficient.
     */
    private double _coefficient;

    /**
     * keeps track of state for field: _coefficient
     */
    private boolean _has_coefficient;

    /**
     * Field _exponent.
     */
    private double _exponent;

    /**
     * keeps track of state for field: _exponent
     */
    private boolean _has_exponent;


      //----------------/
     //- Constructors -/
    //----------------/

    public Term() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteCoefficient(
    ) {
        this._has_coefficient= false;
    }

    /**
     */
    public void deleteExponent(
    ) {
        this._has_exponent= false;
    }

    /**
     * Returns the value of field 'coefficient'.
     * 
     * @return the value of field 'Coefficient'.
     */
    public double getCoefficient(
    ) {
        return this._coefficient;
    }

    /**
     * Returns the value of field 'exponent'.
     * 
     * @return the value of field 'Exponent'.
     */
    public double getExponent(
    ) {
        return this._exponent;
    }

    /**
     * Method hasCoefficient.
     * 
     * @return true if at least one Coefficient has been added
     */
    public boolean hasCoefficient(
    ) {
        return this._has_coefficient;
    }

    /**
     * Method hasExponent.
     * 
     * @return true if at least one Exponent has been added
     */
    public boolean hasExponent(
    ) {
        return this._has_exponent;
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
     * Sets the value of field 'coefficient'.
     * 
     * @param coefficient the value of field 'coefficient'.
     */
    public void setCoefficient(
            final double coefficient) {
        this._coefficient = coefficient;
        this._has_coefficient = true;
    }

    /**
     * Sets the value of field 'exponent'.
     * 
     * @param exponent the value of field 'exponent'.
     */
    public void setExponent(
            final double exponent) {
        this._exponent = exponent;
        this._has_exponent = true;
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
     * org.hbird.xtce.castor.Term
     */
    public static org.hbird.xtce.castor.Term unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.Term) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.Term.class, reader);
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
