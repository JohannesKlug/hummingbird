/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * Significance provides some cautionary information about the
 * potential consequence of each MetaCommand.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SignificanceType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * If none is supplied, then the current SpaceSystem is assumed
     * to be the one at risk by the issuance of this command
     */
    private java.lang.String _spaceSystemAtRisk;

    /**
     * Field _reasonForWarning.
     */
    private java.lang.String _reasonForWarning;

    /**
     * No specific meanings have been assigned to these different
     * levels, but they mirror the Alarm levels of Telemetry.
     */
    private org.hbird.xtce.castor.types.SignificanceTypeConsequenceLevelType _consequenceLevel;


      //----------------/
     //- Constructors -/
    //----------------/

    public SignificanceType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'consequenceLevel'. The field
     * 'consequenceLevel' has the following description: No
     * specific meanings have been assigned to these different
     * levels, but they mirror the Alarm levels of Telemetry.
     * 
     * @return the value of field 'ConsequenceLevel'.
     */
    public org.hbird.xtce.castor.types.SignificanceTypeConsequenceLevelType getConsequenceLevel(
    ) {
        return this._consequenceLevel;
    }

    /**
     * Returns the value of field 'reasonForWarning'.
     * 
     * @return the value of field 'ReasonForWarning'.
     */
    public java.lang.String getReasonForWarning(
    ) {
        return this._reasonForWarning;
    }

    /**
     * Returns the value of field 'spaceSystemAtRisk'. The field
     * 'spaceSystemAtRisk' has the following description: If none
     * is supplied, then the current SpaceSystem is assumed to be
     * the one at risk by the issuance of this command
     * 
     * @return the value of field 'SpaceSystemAtRisk'.
     */
    public java.lang.String getSpaceSystemAtRisk(
    ) {
        return this._spaceSystemAtRisk;
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
     * Sets the value of field 'consequenceLevel'. The field
     * 'consequenceLevel' has the following description: No
     * specific meanings have been assigned to these different
     * levels, but they mirror the Alarm levels of Telemetry.
     * 
     * @param consequenceLevel the value of field 'consequenceLevel'
     */
    public void setConsequenceLevel(
            final org.hbird.xtce.castor.types.SignificanceTypeConsequenceLevelType consequenceLevel) {
        this._consequenceLevel = consequenceLevel;
    }

    /**
     * Sets the value of field 'reasonForWarning'.
     * 
     * @param reasonForWarning the value of field 'reasonForWarning'
     */
    public void setReasonForWarning(
            final java.lang.String reasonForWarning) {
        this._reasonForWarning = reasonForWarning;
    }

    /**
     * Sets the value of field 'spaceSystemAtRisk'. The field
     * 'spaceSystemAtRisk' has the following description: If none
     * is supplied, then the current SpaceSystem is assumed to be
     * the one at risk by the issuance of this command
     * 
     * @param spaceSystemAtRisk the value of field
     * 'spaceSystemAtRisk'.
     */
    public void setSpaceSystemAtRisk(
            final java.lang.String spaceSystemAtRisk) {
        this._spaceSystemAtRisk = spaceSystemAtRisk;
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
     * org.hbird.xtce.castor.SignificanceType
     */
    public static org.hbird.xtce.castor.SignificanceType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.SignificanceType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.SignificanceType.class, reader);
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
