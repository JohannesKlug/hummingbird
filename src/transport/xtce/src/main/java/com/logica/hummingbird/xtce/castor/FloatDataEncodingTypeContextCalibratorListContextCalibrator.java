/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * Class ContextCalibrator.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class FloatDataEncodingTypeContextCalibratorListContextCalibrator implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _useWhenCondition.
     */
    private org.hbird.xtce.castor.UseWhenCondition _useWhenCondition;

    /**
     * Field _calibrator.
     */
    private org.hbird.xtce.castor.Calibrator _calibrator;


      //----------------/
     //- Constructors -/
    //----------------/

    public FloatDataEncodingTypeContextCalibratorListContextCalibrator() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'calibrator'.
     * 
     * @return the value of field 'Calibrator'.
     */
    public org.hbird.xtce.castor.Calibrator getCalibrator(
    ) {
        return this._calibrator;
    }

    /**
     * Returns the value of field 'useWhenCondition'.
     * 
     * @return the value of field 'UseWhenCondition'.
     */
    public org.hbird.xtce.castor.UseWhenCondition getUseWhenCondition(
    ) {
        return this._useWhenCondition;
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
     * Sets the value of field 'calibrator'.
     * 
     * @param calibrator the value of field 'calibrator'.
     */
    public void setCalibrator(
            final org.hbird.xtce.castor.Calibrator calibrator) {
        this._calibrator = calibrator;
    }

    /**
     * Sets the value of field 'useWhenCondition'.
     * 
     * @param useWhenCondition the value of field 'useWhenCondition'
     */
    public void setUseWhenCondition(
            final org.hbird.xtce.castor.UseWhenCondition useWhenCondition) {
        this._useWhenCondition = useWhenCondition;
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
     * org.hbird.xtce.castor.FloatDataEncodingTypeContextCalibratorListContextCalibrator
     */
    public static org.hbird.xtce.castor.FloatDataEncodingTypeContextCalibratorListContextCalibrator unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.FloatDataEncodingTypeContextCalibratorListContextCalibrator) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.FloatDataEncodingTypeContextCalibratorListContextCalibrator.class, reader);
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
