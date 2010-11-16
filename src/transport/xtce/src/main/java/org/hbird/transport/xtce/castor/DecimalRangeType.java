/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * A range of numbers. "minInclusive", "minExclusive",
 * "maxInclusive" and "maxExclusive" attributes are borrowed from
 * the W3C schema language.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class DecimalRangeType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _minInclusive.
     */
    private java.math.BigDecimal _minInclusive;

    /**
     * Field _minExclusive.
     */
    private java.math.BigDecimal _minExclusive;

    /**
     * Field _maxInclusive.
     */
    private java.math.BigDecimal _maxInclusive;

    /**
     * Field _maxExclusive.
     */
    private java.math.BigDecimal _maxExclusive;


      //----------------/
     //- Constructors -/
    //----------------/

    public DecimalRangeType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'maxExclusive'.
     * 
     * @return the value of field 'MaxExclusive'.
     */
    public java.math.BigDecimal getMaxExclusive(
    ) {
        return this._maxExclusive;
    }

    /**
     * Returns the value of field 'maxInclusive'.
     * 
     * @return the value of field 'MaxInclusive'.
     */
    public java.math.BigDecimal getMaxInclusive(
    ) {
        return this._maxInclusive;
    }

    /**
     * Returns the value of field 'minExclusive'.
     * 
     * @return the value of field 'MinExclusive'.
     */
    public java.math.BigDecimal getMinExclusive(
    ) {
        return this._minExclusive;
    }

    /**
     * Returns the value of field 'minInclusive'.
     * 
     * @return the value of field 'MinInclusive'.
     */
    public java.math.BigDecimal getMinInclusive(
    ) {
        return this._minInclusive;
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
     * Sets the value of field 'maxExclusive'.
     * 
     * @param maxExclusive the value of field 'maxExclusive'.
     */
    public void setMaxExclusive(
            final java.math.BigDecimal maxExclusive) {
        this._maxExclusive = maxExclusive;
    }

    /**
     * Sets the value of field 'maxInclusive'.
     * 
     * @param maxInclusive the value of field 'maxInclusive'.
     */
    public void setMaxInclusive(
            final java.math.BigDecimal maxInclusive) {
        this._maxInclusive = maxInclusive;
    }

    /**
     * Sets the value of field 'minExclusive'.
     * 
     * @param minExclusive the value of field 'minExclusive'.
     */
    public void setMinExclusive(
            final java.math.BigDecimal minExclusive) {
        this._minExclusive = minExclusive;
    }

    /**
     * Sets the value of field 'minInclusive'.
     * 
     * @param minInclusive the value of field 'minInclusive'.
     */
    public void setMinInclusive(
            final java.math.BigDecimal minInclusive) {
        this._minInclusive = minInclusive;
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
     * org.hbird.xtce.castor.DecimalRangeType
     */
    public static org.hbird.transport.xtce.castor.DecimalRangeType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.DecimalRangeType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.DecimalRangeType.class, reader);
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
