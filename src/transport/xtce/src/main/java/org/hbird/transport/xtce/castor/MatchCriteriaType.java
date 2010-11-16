/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * Contains either a simple Comparison, a ComparisonList, an
 * arbitrarily complex BooleanExpression or an escape to an
 * externally defined algorithm
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class MatchCriteriaType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * A simple comparison check
     */
    private org.hbird.transport.xtce.castor.Comparison _comparison;

    /**
     * All comparisons must be true
     */
    private org.hbird.transport.xtce.castor.ComparisonList _comparisonList;

    /**
     * An arbitrarily complex boolean expression
     */
    private org.hbird.transport.xtce.castor.BooleanExpression _booleanExpression;

    /**
     * An escape to an externally defined algorithm
     */
    private org.hbird.transport.xtce.castor.CustomAlgorithm _customAlgorithm;


      //----------------/
     //- Constructors -/
    //----------------/

    public MatchCriteriaType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'booleanExpression'. The field
     * 'booleanExpression' has the following description: An
     * arbitrarily complex boolean expression
     * 
     * @return the value of field 'BooleanExpression'.
     */
    public org.hbird.transport.xtce.castor.BooleanExpression getBooleanExpression(
    ) {
        return this._booleanExpression;
    }

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
     * Returns the value of field 'comparison'. The field
     * 'comparison' has the following description: A simple
     * comparison check
     * 
     * @return the value of field 'Comparison'.
     */
    public org.hbird.transport.xtce.castor.Comparison getComparison(
    ) {
        return this._comparison;
    }

    /**
     * Returns the value of field 'comparisonList'. The field
     * 'comparisonList' has the following description: All
     * comparisons must be true
     * 
     * @return the value of field 'ComparisonList'.
     */
    public org.hbird.transport.xtce.castor.ComparisonList getComparisonList(
    ) {
        return this._comparisonList;
    }

    /**
     * Returns the value of field 'customAlgorithm'. The field
     * 'customAlgorithm' has the following description: An escape
     * to an externally defined algorithm
     * 
     * @return the value of field 'CustomAlgorithm'.
     */
    public org.hbird.transport.xtce.castor.CustomAlgorithm getCustomAlgorithm(
    ) {
        return this._customAlgorithm;
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
     * Sets the value of field 'booleanExpression'. The field
     * 'booleanExpression' has the following description: An
     * arbitrarily complex boolean expression
     * 
     * @param booleanExpression the value of field
     * 'booleanExpression'.
     */
    public void setBooleanExpression(
            final org.hbird.transport.xtce.castor.BooleanExpression booleanExpression) {
        this._booleanExpression = booleanExpression;
        this._choiceValue = booleanExpression;
    }

    /**
     * Sets the value of field 'comparison'. The field 'comparison'
     * has the following description: A simple comparison check
     * 
     * @param comparison the value of field 'comparison'.
     */
    public void setComparison(
            final org.hbird.transport.xtce.castor.Comparison comparison) {
        this._comparison = comparison;
        this._choiceValue = comparison;
    }

    /**
     * Sets the value of field 'comparisonList'. The field
     * 'comparisonList' has the following description: All
     * comparisons must be true
     * 
     * @param comparisonList the value of field 'comparisonList'.
     */
    public void setComparisonList(
            final org.hbird.transport.xtce.castor.ComparisonList comparisonList) {
        this._comparisonList = comparisonList;
        this._choiceValue = comparisonList;
    }

    /**
     * Sets the value of field 'customAlgorithm'. The field
     * 'customAlgorithm' has the following description: An escape
     * to an externally defined algorithm
     * 
     * @param customAlgorithm the value of field 'customAlgorithm'.
     */
    public void setCustomAlgorithm(
            final org.hbird.transport.xtce.castor.CustomAlgorithm customAlgorithm) {
        this._customAlgorithm = customAlgorithm;
        this._choiceValue = customAlgorithm;
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
     * org.hbird.xtce.castor.MatchCriteriaType
     */
    public static org.hbird.transport.xtce.castor.MatchCriteriaType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.MatchCriteriaType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.MatchCriteriaType.class, reader);
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
