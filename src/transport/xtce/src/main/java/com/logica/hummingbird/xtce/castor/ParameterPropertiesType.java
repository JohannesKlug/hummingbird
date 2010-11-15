/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * A wrapper for those properties that are unique to telemetry
 * parameters.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ParameterPropertiesType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * A telemetered Parameter is one that will have values in
     * telemetry. A derived Parameter is one that is calculated,
     * usually be an Algorithm. A constant Parameter is one that is
     * used as a constant in the system (e.g. a vehicle id). A
     * local Parameter is one that is used purely on the ground
     * (e.g. a ground command counter).
     */
    private org.hbird.xtce.castor.types.ParameterPropertiesTypeDataSourceType _dataSource;

    /**
     * A Parameter marked as 'readOnly' true is constant and
     * non-settable
     */
    private boolean _readOnly = false;

    /**
     * keeps track of state for field: _readOnly
     */
    private boolean _has_readOnly;

    /**
     * Optional. Normally used when the database is built in a
     * flat, non-hierarchical format
     */
    private java.lang.String _systemName;

    /**
     * Optional condition that must be true for this Parameter to
     * be valid
     */
    private org.hbird.xtce.castor.ValidityCondition _validityCondition;

    /**
     * One or more physical addresses may be associated with each
     * Parameter. Examples of phyical addresses include a location
     * on the spacecraft or a location on a data collection bus. 
     */
    private org.hbird.xtce.castor.PhysicalAddressSet _physicalAddressSet;

    /**
     * This time will overide any Default value for TimeAssociation.
     */
    private org.hbird.xtce.castor.TimeAssociation _timeAssociation;


      //----------------/
     //- Constructors -/
    //----------------/

    public ParameterPropertiesType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteReadOnly(
    ) {
        this._has_readOnly= false;
    }

    /**
     * Returns the value of field 'dataSource'. The field
     * 'dataSource' has the following description: A telemetered
     * Parameter is one that will have values in telemetry. A
     * derived Parameter is one that is calculated, usually be an
     * Algorithm. A constant Parameter is one that is used as a
     * constant in the system (e.g. a vehicle id). A local
     * Parameter is one that is used purely on the ground (e.g. a
     * ground command counter).
     * 
     * @return the value of field 'DataSource'.
     */
    public org.hbird.xtce.castor.types.ParameterPropertiesTypeDataSourceType getDataSource(
    ) {
        return this._dataSource;
    }

    /**
     * Returns the value of field 'physicalAddressSet'. The field
     * 'physicalAddressSet' has the following description: One or
     * more physical addresses may be associated with each
     * Parameter. Examples of phyical addresses include a location
     * on the spacecraft or a location on a data collection bus. 
     * 
     * @return the value of field 'PhysicalAddressSet'.
     */
    public org.hbird.xtce.castor.PhysicalAddressSet getPhysicalAddressSet(
    ) {
        return this._physicalAddressSet;
    }

    /**
     * Returns the value of field 'readOnly'. The field 'readOnly'
     * has the following description: A Parameter marked as
     * 'readOnly' true is constant and non-settable
     * 
     * @return the value of field 'ReadOnly'.
     */
    public boolean getReadOnly(
    ) {
        return this._readOnly;
    }

    /**
     * Returns the value of field 'systemName'. The field
     * 'systemName' has the following description: Optional.
     * Normally used when the database is built in a flat,
     * non-hierarchical format
     * 
     * @return the value of field 'SystemName'.
     */
    public java.lang.String getSystemName(
    ) {
        return this._systemName;
    }

    /**
     * Returns the value of field 'timeAssociation'. The field
     * 'timeAssociation' has the following description: This time
     * will overide any Default value for TimeAssociation. 
     * 
     * @return the value of field 'TimeAssociation'.
     */
    public org.hbird.xtce.castor.TimeAssociation getTimeAssociation(
    ) {
        return this._timeAssociation;
    }

    /**
     * Returns the value of field 'validityCondition'. The field
     * 'validityCondition' has the following description: Optional
     * condition that must be true for this Parameter to be valid
     * 
     * @return the value of field 'ValidityCondition'.
     */
    public org.hbird.xtce.castor.ValidityCondition getValidityCondition(
    ) {
        return this._validityCondition;
    }

    /**
     * Method hasReadOnly.
     * 
     * @return true if at least one ReadOnly has been added
     */
    public boolean hasReadOnly(
    ) {
        return this._has_readOnly;
    }

    /**
     * Returns the value of field 'readOnly'. The field 'readOnly'
     * has the following description: A Parameter marked as
     * 'readOnly' true is constant and non-settable
     * 
     * @return the value of field 'ReadOnly'.
     */
    public boolean isReadOnly(
    ) {
        return this._readOnly;
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
     * Sets the value of field 'dataSource'. The field 'dataSource'
     * has the following description: A telemetered Parameter is
     * one that will have values in telemetry. A derived Parameter
     * is one that is calculated, usually be an Algorithm. A
     * constant Parameter is one that is used as a constant in the
     * system (e.g. a vehicle id). A local Parameter is one that is
     * used purely on the ground (e.g. a ground command counter).
     * 
     * @param dataSource the value of field 'dataSource'.
     */
    public void setDataSource(
            final org.hbird.xtce.castor.types.ParameterPropertiesTypeDataSourceType dataSource) {
        this._dataSource = dataSource;
    }

    /**
     * Sets the value of field 'physicalAddressSet'. The field
     * 'physicalAddressSet' has the following description: One or
     * more physical addresses may be associated with each
     * Parameter. Examples of phyical addresses include a location
     * on the spacecraft or a location on a data collection bus. 
     * 
     * @param physicalAddressSet the value of field
     * 'physicalAddressSet'.
     */
    public void setPhysicalAddressSet(
            final org.hbird.xtce.castor.PhysicalAddressSet physicalAddressSet) {
        this._physicalAddressSet = physicalAddressSet;
    }

    /**
     * Sets the value of field 'readOnly'. The field 'readOnly' has
     * the following description: A Parameter marked as 'readOnly'
     * true is constant and non-settable
     * 
     * @param readOnly the value of field 'readOnly'.
     */
    public void setReadOnly(
            final boolean readOnly) {
        this._readOnly = readOnly;
        this._has_readOnly = true;
    }

    /**
     * Sets the value of field 'systemName'. The field 'systemName'
     * has the following description: Optional. Normally used when
     * the database is built in a flat, non-hierarchical format
     * 
     * @param systemName the value of field 'systemName'.
     */
    public void setSystemName(
            final java.lang.String systemName) {
        this._systemName = systemName;
    }

    /**
     * Sets the value of field 'timeAssociation'. The field
     * 'timeAssociation' has the following description: This time
     * will overide any Default value for TimeAssociation. 
     * 
     * @param timeAssociation the value of field 'timeAssociation'.
     */
    public void setTimeAssociation(
            final org.hbird.xtce.castor.TimeAssociation timeAssociation) {
        this._timeAssociation = timeAssociation;
    }

    /**
     * Sets the value of field 'validityCondition'. The field
     * 'validityCondition' has the following description: Optional
     * condition that must be true for this Parameter to be valid
     * 
     * @param validityCondition the value of field
     * 'validityCondition'.
     */
    public void setValidityCondition(
            final org.hbird.xtce.castor.ValidityCondition validityCondition) {
        this._validityCondition = validityCondition;
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
     * org.hbird.xtce.castor.ParameterPropertiesType
     */
    public static org.hbird.xtce.castor.ParameterPropertiesType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.ParameterPropertiesType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.ParameterPropertiesType.class, reader);
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
