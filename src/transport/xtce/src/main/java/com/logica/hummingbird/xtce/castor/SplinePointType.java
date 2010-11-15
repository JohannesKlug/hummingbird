/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * a spline is a set on points from which a curve may be drawn to
 * interpolate raw to calibrated values
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SplinePointType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _order.
     */
    private long _order = 1;

    /**
     * keeps track of state for field: _order
     */
    private boolean _has_order;

    /**
     * Field _raw.
     */
    private double _raw;

    /**
     * keeps track of state for field: _raw
     */
    private boolean _has_raw;

    /**
     * Field _calibrated.
     */
    private double _calibrated;

    /**
     * keeps track of state for field: _calibrated
     */
    private boolean _has_calibrated;


      //----------------/
     //- Constructors -/
    //----------------/

    public SplinePointType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteCalibrated(
    ) {
        this._has_calibrated= false;
    }

    /**
     */
    public void deleteOrder(
    ) {
        this._has_order= false;
    }

    /**
     */
    public void deleteRaw(
    ) {
        this._has_raw= false;
    }

    /**
     * Returns the value of field 'calibrated'.
     * 
     * @return the value of field 'Calibrated'.
     */
    public double getCalibrated(
    ) {
        return this._calibrated;
    }

    /**
     * Returns the value of field 'order'.
     * 
     * @return the value of field 'Order'.
     */
    public long getOrder(
    ) {
        return this._order;
    }

    /**
     * Returns the value of field 'raw'.
     * 
     * @return the value of field 'Raw'.
     */
    public double getRaw(
    ) {
        return this._raw;
    }

    /**
     * Method hasCalibrated.
     * 
     * @return true if at least one Calibrated has been added
     */
    public boolean hasCalibrated(
    ) {
        return this._has_calibrated;
    }

    /**
     * Method hasOrder.
     * 
     * @return true if at least one Order has been added
     */
    public boolean hasOrder(
    ) {
        return this._has_order;
    }

    /**
     * Method hasRaw.
     * 
     * @return true if at least one Raw has been added
     */
    public boolean hasRaw(
    ) {
        return this._has_raw;
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
     * Sets the value of field 'calibrated'.
     * 
     * @param calibrated the value of field 'calibrated'.
     */
    public void setCalibrated(
            final double calibrated) {
        this._calibrated = calibrated;
        this._has_calibrated = true;
    }

    /**
     * Sets the value of field 'order'.
     * 
     * @param order the value of field 'order'.
     */
    public void setOrder(
            final long order) {
        this._order = order;
        this._has_order = true;
    }

    /**
     * Sets the value of field 'raw'.
     * 
     * @param raw the value of field 'raw'.
     */
    public void setRaw(
            final double raw) {
        this._raw = raw;
        this._has_raw = true;
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
     * org.hbird.xtce.castor.SplinePointType
     */
    public static org.hbird.xtce.castor.SplinePointType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.SplinePointType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.SplinePointType.class, reader);
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
