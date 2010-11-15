/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Telemetry parameter instances are oftentimes "time-tagged" with
 * a timing signal either provided on the ground or on the space
 * system. This data element allows one to specify which of
 * possibly many AbsoluteTimeParameters to use to "time-tag"
 * parameter instances with. 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class TimeAssociationType extends com.logica.hummingbird.xtce.castor.ParameterInstanceRefType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * internal content storage
     */
    private java.lang.String _content = "";

    /**
     * If true, then the current value of the AbsoluteTime will be
     * projected to current time. I.E., if the value of the
     * AbsoluteTime parameter was set 10 seconds ago, then 10
     * seconds will be added to it's value before associating this
     * time with the parameter.
     */
    private boolean _interpolateTime = true;

    /**
     * keeps track of state for field: _interpolateTime
     */
    private boolean _has_interpolateTime;

    /**
     * The offset is used to supply a relative time offset from the
     * time association and to this parameter
     */
    private org.exolab.castor.types.Date _offset;


      //----------------/
     //- Constructors -/
    //----------------/

    public TimeAssociationType() {
        super();
        setContent("");
    }

    public TimeAssociationType(final java.lang.String defaultValue) {
        try {
            setContent( new java.lang.String(defaultValue));
         } catch(Exception e) {
            throw new RuntimeException("Unable to cast default value for simple content!");
         } 
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteInterpolateTime(
    ) {
        this._has_interpolateTime= false;
    }

    /**
     * Returns the value of field 'content'. The field 'content'
     * has the following description: internal content storage
     * 
     * @return the value of field 'Content'.
     */
    public java.lang.String getContent(
    ) {
        return this._content;
    }

    /**
     * Returns the value of field 'interpolateTime'. The field
     * 'interpolateTime' has the following description: If true,
     * then the current value of the AbsoluteTime will be projected
     * to current time. I.E., if the value of the AbsoluteTime
     * parameter was set 10 seconds ago, then 10 seconds will be
     * added to it's value before associating this time with the
     * parameter.
     * 
     * @return the value of field 'InterpolateTime'.
     */
    public boolean getInterpolateTime(
    ) {
        return this._interpolateTime;
    }

    /**
     * Returns the value of field 'offset'. The field 'offset' has
     * the following description: The offset is used to supply a
     * relative time offset from the time association and to this
     * parameter
     * 
     * @return the value of field 'Offset'.
     */
    public org.exolab.castor.types.Date getOffset(
    ) {
        return this._offset;
    }

    /**
     * Method hasInterpolateTime.
     * 
     * @return true if at least one InterpolateTime has been added
     */
    public boolean hasInterpolateTime(
    ) {
        return this._has_interpolateTime;
    }

    /**
     * Returns the value of field 'interpolateTime'. The field
     * 'interpolateTime' has the following description: If true,
     * then the current value of the AbsoluteTime will be projected
     * to current time. I.E., if the value of the AbsoluteTime
     * parameter was set 10 seconds ago, then 10 seconds will be
     * added to it's value before associating this time with the
     * parameter.
     * 
     * @return the value of field 'InterpolateTime'.
     */
    public boolean isInterpolateTime(
    ) {
        return this._interpolateTime;
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
     * Sets the value of field 'content'. The field 'content' has
     * the following description: internal content storage
     * 
     * @param content the value of field 'content'.
     */
    public void setContent(
            final java.lang.String content) {
        this._content = content;
    }

    /**
     * Sets the value of field 'interpolateTime'. The field
     * 'interpolateTime' has the following description: If true,
     * then the current value of the AbsoluteTime will be projected
     * to current time. I.E., if the value of the AbsoluteTime
     * parameter was set 10 seconds ago, then 10 seconds will be
     * added to it's value before associating this time with the
     * parameter.
     * 
     * @param interpolateTime the value of field 'interpolateTime'.
     */
    public void setInterpolateTime(
            final boolean interpolateTime) {
        this._interpolateTime = interpolateTime;
        this._has_interpolateTime = true;
    }

    /**
     * Sets the value of field 'offset'. The field 'offset' has the
     * following description: The offset is used to supply a
     * relative time offset from the time association and to this
     * parameter
     * 
     * @param offset the value of field 'offset'.
     */
    public void setOffset(
            final org.exolab.castor.types.Date offset) {
        this._offset = offset;
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
     * com.logica.hummingbird.xtce.castor.TimeAssociationType
     */
    public static com.logica.hummingbird.xtce.castor.TimeAssociationType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.TimeAssociationType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.TimeAssociationType.class, reader);
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
