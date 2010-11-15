/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Used in packaging to define the expected rate that any
 * individual container will be in a Stream
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class RateInStreamType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _basis.
     */
    private com.logica.hummingbird.xtce.castor.types.RateInStreamTypeBasisType _basis = com.logica.hummingbird.xtce.castor.types.RateInStreamTypeBasisType.fromValue("perSecond");

    /**
     * Field _minimumValue.
     */
    private double _minimumValue;

    /**
     * keeps track of state for field: _minimumValue
     */
    private boolean _has_minimumValue;

    /**
     * Field _maximumValue.
     */
    private double _maximumValue;

    /**
     * keeps track of state for field: _maximumValue
     */
    private boolean _has_maximumValue;


      //----------------/
     //- Constructors -/
    //----------------/

    public RateInStreamType() {
        super();
        setBasis(com.logica.hummingbird.xtce.castor.types.RateInStreamTypeBasisType.fromValue("perSecond"));
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteMaximumValue(
    ) {
        this._has_maximumValue= false;
    }

    /**
     */
    public void deleteMinimumValue(
    ) {
        this._has_minimumValue= false;
    }

    /**
     * Returns the value of field 'basis'.
     * 
     * @return the value of field 'Basis'.
     */
    public com.logica.hummingbird.xtce.castor.types.RateInStreamTypeBasisType getBasis(
    ) {
        return this._basis;
    }

    /**
     * Returns the value of field 'maximumValue'.
     * 
     * @return the value of field 'MaximumValue'.
     */
    public double getMaximumValue(
    ) {
        return this._maximumValue;
    }

    /**
     * Returns the value of field 'minimumValue'.
     * 
     * @return the value of field 'MinimumValue'.
     */
    public double getMinimumValue(
    ) {
        return this._minimumValue;
    }

    /**
     * Method hasMaximumValue.
     * 
     * @return true if at least one MaximumValue has been added
     */
    public boolean hasMaximumValue(
    ) {
        return this._has_maximumValue;
    }

    /**
     * Method hasMinimumValue.
     * 
     * @return true if at least one MinimumValue has been added
     */
    public boolean hasMinimumValue(
    ) {
        return this._has_minimumValue;
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
     * Sets the value of field 'basis'.
     * 
     * @param basis the value of field 'basis'.
     */
    public void setBasis(
            final com.logica.hummingbird.xtce.castor.types.RateInStreamTypeBasisType basis) {
        this._basis = basis;
    }

    /**
     * Sets the value of field 'maximumValue'.
     * 
     * @param maximumValue the value of field 'maximumValue'.
     */
    public void setMaximumValue(
            final double maximumValue) {
        this._maximumValue = maximumValue;
        this._has_maximumValue = true;
    }

    /**
     * Sets the value of field 'minimumValue'.
     * 
     * @param minimumValue the value of field 'minimumValue'.
     */
    public void setMinimumValue(
            final double minimumValue) {
        this._minimumValue = minimumValue;
        this._has_minimumValue = true;
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
     * com.logica.hummingbird.xtce.castor.RateInStreamType
     */
    public static com.logica.hummingbird.xtce.castor.RateInStreamType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.RateInStreamType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.RateInStreamType.class, reader);
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
