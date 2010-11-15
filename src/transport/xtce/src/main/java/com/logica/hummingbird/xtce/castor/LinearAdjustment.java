/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * A slope and intercept may be applied to scale or shift the value
 * of the parameter in the dynamic value
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class LinearAdjustment implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _slope.
     */
    private long _slope = 0;

    /**
     * keeps track of state for field: _slope
     */
    private boolean _has_slope;

    /**
     * Field _intercept.
     */
    private long _intercept = 0;

    /**
     * keeps track of state for field: _intercept
     */
    private boolean _has_intercept;


      //----------------/
     //- Constructors -/
    //----------------/

    public LinearAdjustment() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteIntercept(
    ) {
        this._has_intercept= false;
    }

    /**
     */
    public void deleteSlope(
    ) {
        this._has_slope= false;
    }

    /**
     * Returns the value of field 'intercept'.
     * 
     * @return the value of field 'Intercept'.
     */
    public long getIntercept(
    ) {
        return this._intercept;
    }

    /**
     * Returns the value of field 'slope'.
     * 
     * @return the value of field 'Slope'.
     */
    public long getSlope(
    ) {
        return this._slope;
    }

    /**
     * Method hasIntercept.
     * 
     * @return true if at least one Intercept has been added
     */
    public boolean hasIntercept(
    ) {
        return this._has_intercept;
    }

    /**
     * Method hasSlope.
     * 
     * @return true if at least one Slope has been added
     */
    public boolean hasSlope(
    ) {
        return this._has_slope;
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
     * Sets the value of field 'intercept'.
     * 
     * @param intercept the value of field 'intercept'.
     */
    public void setIntercept(
            final long intercept) {
        this._intercept = intercept;
        this._has_intercept = true;
    }

    /**
     * Sets the value of field 'slope'.
     * 
     * @param slope the value of field 'slope'.
     */
    public void setSlope(
            final long slope) {
        this._slope = slope;
        this._has_slope = true;
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
     * com.logica.hummingbird.xtce.castor.LinearAdjustment
     */
    public static com.logica.hummingbird.xtce.castor.LinearAdjustment unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.LinearAdjustment) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.LinearAdjustment.class, reader);
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
