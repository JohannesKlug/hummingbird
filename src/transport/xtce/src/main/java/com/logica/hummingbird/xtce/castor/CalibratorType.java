/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * Calibrators are normally used to convert to and from bit
 * compacted numerical data
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CalibratorType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name.
     */
    private java.lang.String _name;

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * A calibration type where a segmented line in a raw vs
     * calibrated plane is described using a set of points. Raw
     * values are converted to calibrated values by finding a
     * position on the line coorosponding to the raw value. The
     * algorithm triggers on the input parameter.
     */
    private org.hbird.xtce.castor.SplineCalibrator _splineCalibrator;

    /**
     * A calibration type where a curve in a raw vs calibrated
     * plane is described using a set of polynomial coefficients.
     * Raw values are converted to calibrated values by finding a
     * position on the curve corresponding to the raw value. The
     * first coefficient belongs with the X^0 term, the next
     * coefficient belongs to the X^1 term and so on. 
     */
    private org.hbird.xtce.castor.PolynomialCalibrator _polynomialCalibrator;


      //----------------/
     //- Constructors -/
    //----------------/

    public CalibratorType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'choiceValue'. The field
     * 'choiceValue' has the following description: Internal choice
     * value storage
     * 
     * @return the value of field 'ChoiceValue'.
     */
    public java.lang.Object getChoiceValue(
    ) {
        return this._choiceValue;
    }

    /**
     * Returns the value of field 'name'.
     * 
     * @return the value of field 'Name'.
     */
    public java.lang.String getName(
    ) {
        return this._name;
    }

    /**
     * Returns the value of field 'polynomialCalibrator'. The field
     * 'polynomialCalibrator' has the following description: A
     * calibration type where a curve in a raw vs calibrated plane
     * is described using a set of polynomial coefficients. Raw
     * values are converted to calibrated values by finding a
     * position on the curve corresponding to the raw value. The
     * first coefficient belongs with the X^0 term, the next
     * coefficient belongs to the X^1 term and so on. 
     * 
     * @return the value of field 'PolynomialCalibrator'.
     */
    public org.hbird.xtce.castor.PolynomialCalibrator getPolynomialCalibrator(
    ) {
        return this._polynomialCalibrator;
    }

    /**
     * Returns the value of field 'splineCalibrator'. The field
     * 'splineCalibrator' has the following description: A
     * calibration type where a segmented line in a raw vs
     * calibrated plane is described using a set of points. Raw
     * values are converted to calibrated values by finding a
     * position on the line coorosponding to the raw value. The
     * algorithm triggers on the input parameter.
     * 
     * @return the value of field 'SplineCalibrator'.
     */
    public org.hbird.xtce.castor.SplineCalibrator getSplineCalibrator(
    ) {
        return this._splineCalibrator;
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
     * Sets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(
            final java.lang.String name) {
        this._name = name;
    }

    /**
     * Sets the value of field 'polynomialCalibrator'. The field
     * 'polynomialCalibrator' has the following description: A
     * calibration type where a curve in a raw vs calibrated plane
     * is described using a set of polynomial coefficients. Raw
     * values are converted to calibrated values by finding a
     * position on the curve corresponding to the raw value. The
     * first coefficient belongs with the X^0 term, the next
     * coefficient belongs to the X^1 term and so on. 
     * 
     * @param polynomialCalibrator the value of field
     * 'polynomialCalibrator'.
     */
    public void setPolynomialCalibrator(
            final org.hbird.xtce.castor.PolynomialCalibrator polynomialCalibrator) {
        this._polynomialCalibrator = polynomialCalibrator;
        this._choiceValue = polynomialCalibrator;
    }

    /**
     * Sets the value of field 'splineCalibrator'. The field
     * 'splineCalibrator' has the following description: A
     * calibration type where a segmented line in a raw vs
     * calibrated plane is described using a set of points. Raw
     * values are converted to calibrated values by finding a
     * position on the line coorosponding to the raw value. The
     * algorithm triggers on the input parameter.
     * 
     * @param splineCalibrator the value of field 'splineCalibrator'
     */
    public void setSplineCalibrator(
            final org.hbird.xtce.castor.SplineCalibrator splineCalibrator) {
        this._splineCalibrator = splineCalibrator;
        this._choiceValue = splineCalibrator;
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
     * org.hbird.xtce.castor.CalibratorType
     */
    public static org.hbird.xtce.castor.CalibratorType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.CalibratorType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.CalibratorType.class, reader);
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
