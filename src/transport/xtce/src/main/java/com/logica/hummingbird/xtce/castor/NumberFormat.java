/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * Class NumberFormat.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class NumberFormat implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _numberBase.
     */
    private org.hbird.xtce.castor.types.RadixType _numberBase;

    /**
     * Field _minimumFractionDigits.
     */
    private long _minimumFractionDigits;

    /**
     * keeps track of state for field: _minimumFractionDigits
     */
    private boolean _has_minimumFractionDigits;

    /**
     * Field _maximumFractionDigits.
     */
    private long _maximumFractionDigits;

    /**
     * keeps track of state for field: _maximumFractionDigits
     */
    private boolean _has_maximumFractionDigits;

    /**
     * Field _minimumIntegerDigits.
     */
    private long _minimumIntegerDigits;

    /**
     * keeps track of state for field: _minimumIntegerDigits
     */
    private boolean _has_minimumIntegerDigits;

    /**
     * Field _maximumIntegerDigits.
     */
    private long _maximumIntegerDigits;

    /**
     * keeps track of state for field: _maximumIntegerDigits
     */
    private boolean _has_maximumIntegerDigits;

    /**
     * Field _negativeSuffix.
     */
    private java.lang.String _negativeSuffix;

    /**
     * Field _positiveSuffix.
     */
    private java.lang.String _positiveSuffix;

    /**
     * Field _negativePrefix.
     */
    private java.lang.String _negativePrefix = "-";

    /**
     * Field _positivePrefix.
     */
    private java.lang.String _positivePrefix;

    /**
     * Field _showThousandsGrouping.
     */
    private boolean _showThousandsGrouping = true;

    /**
     * keeps track of state for field: _showThousandsGrouping
     */
    private boolean _has_showThousandsGrouping;

    /**
     * Field _notation.
     */
    private org.hbird.xtce.castor.types.NumberFormatNotationType _notation = org.hbird.xtce.castor.types.NumberFormatNotationType.fromValue("normal");


      //----------------/
     //- Constructors -/
    //----------------/

    public NumberFormat() {
        super();
        setNegativePrefix("-");
        setNotation(org.hbird.xtce.castor.types.NumberFormatNotationType.fromValue("normal"));
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteMaximumFractionDigits(
    ) {
        this._has_maximumFractionDigits= false;
    }

    /**
     */
    public void deleteMaximumIntegerDigits(
    ) {
        this._has_maximumIntegerDigits= false;
    }

    /**
     */
    public void deleteMinimumFractionDigits(
    ) {
        this._has_minimumFractionDigits= false;
    }

    /**
     */
    public void deleteMinimumIntegerDigits(
    ) {
        this._has_minimumIntegerDigits= false;
    }

    /**
     */
    public void deleteShowThousandsGrouping(
    ) {
        this._has_showThousandsGrouping= false;
    }

    /**
     * Returns the value of field 'maximumFractionDigits'.
     * 
     * @return the value of field 'MaximumFractionDigits'.
     */
    public long getMaximumFractionDigits(
    ) {
        return this._maximumFractionDigits;
    }

    /**
     * Returns the value of field 'maximumIntegerDigits'.
     * 
     * @return the value of field 'MaximumIntegerDigits'.
     */
    public long getMaximumIntegerDigits(
    ) {
        return this._maximumIntegerDigits;
    }

    /**
     * Returns the value of field 'minimumFractionDigits'.
     * 
     * @return the value of field 'MinimumFractionDigits'.
     */
    public long getMinimumFractionDigits(
    ) {
        return this._minimumFractionDigits;
    }

    /**
     * Returns the value of field 'minimumIntegerDigits'.
     * 
     * @return the value of field 'MinimumIntegerDigits'.
     */
    public long getMinimumIntegerDigits(
    ) {
        return this._minimumIntegerDigits;
    }

    /**
     * Returns the value of field 'negativePrefix'.
     * 
     * @return the value of field 'NegativePrefix'.
     */
    public java.lang.String getNegativePrefix(
    ) {
        return this._negativePrefix;
    }

    /**
     * Returns the value of field 'negativeSuffix'.
     * 
     * @return the value of field 'NegativeSuffix'.
     */
    public java.lang.String getNegativeSuffix(
    ) {
        return this._negativeSuffix;
    }

    /**
     * Returns the value of field 'notation'.
     * 
     * @return the value of field 'Notation'.
     */
    public org.hbird.xtce.castor.types.NumberFormatNotationType getNotation(
    ) {
        return this._notation;
    }

    /**
     * Returns the value of field 'numberBase'.
     * 
     * @return the value of field 'NumberBase'.
     */
    public org.hbird.xtce.castor.types.RadixType getNumberBase(
    ) {
        return this._numberBase;
    }

    /**
     * Returns the value of field 'positivePrefix'.
     * 
     * @return the value of field 'PositivePrefix'.
     */
    public java.lang.String getPositivePrefix(
    ) {
        return this._positivePrefix;
    }

    /**
     * Returns the value of field 'positiveSuffix'.
     * 
     * @return the value of field 'PositiveSuffix'.
     */
    public java.lang.String getPositiveSuffix(
    ) {
        return this._positiveSuffix;
    }

    /**
     * Returns the value of field 'showThousandsGrouping'.
     * 
     * @return the value of field 'ShowThousandsGrouping'.
     */
    public boolean getShowThousandsGrouping(
    ) {
        return this._showThousandsGrouping;
    }

    /**
     * Method hasMaximumFractionDigits.
     * 
     * @return true if at least one MaximumFractionDigits has been
     * added
     */
    public boolean hasMaximumFractionDigits(
    ) {
        return this._has_maximumFractionDigits;
    }

    /**
     * Method hasMaximumIntegerDigits.
     * 
     * @return true if at least one MaximumIntegerDigits has been
     * added
     */
    public boolean hasMaximumIntegerDigits(
    ) {
        return this._has_maximumIntegerDigits;
    }

    /**
     * Method hasMinimumFractionDigits.
     * 
     * @return true if at least one MinimumFractionDigits has been
     * added
     */
    public boolean hasMinimumFractionDigits(
    ) {
        return this._has_minimumFractionDigits;
    }

    /**
     * Method hasMinimumIntegerDigits.
     * 
     * @return true if at least one MinimumIntegerDigits has been
     * added
     */
    public boolean hasMinimumIntegerDigits(
    ) {
        return this._has_minimumIntegerDigits;
    }

    /**
     * Method hasShowThousandsGrouping.
     * 
     * @return true if at least one ShowThousandsGrouping has been
     * added
     */
    public boolean hasShowThousandsGrouping(
    ) {
        return this._has_showThousandsGrouping;
    }

    /**
     * Returns the value of field 'showThousandsGrouping'.
     * 
     * @return the value of field 'ShowThousandsGrouping'.
     */
    public boolean isShowThousandsGrouping(
    ) {
        return this._showThousandsGrouping;
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
     * Sets the value of field 'maximumFractionDigits'.
     * 
     * @param maximumFractionDigits the value of field
     * 'maximumFractionDigits'.
     */
    public void setMaximumFractionDigits(
            final long maximumFractionDigits) {
        this._maximumFractionDigits = maximumFractionDigits;
        this._has_maximumFractionDigits = true;
    }

    /**
     * Sets the value of field 'maximumIntegerDigits'.
     * 
     * @param maximumIntegerDigits the value of field
     * 'maximumIntegerDigits'.
     */
    public void setMaximumIntegerDigits(
            final long maximumIntegerDigits) {
        this._maximumIntegerDigits = maximumIntegerDigits;
        this._has_maximumIntegerDigits = true;
    }

    /**
     * Sets the value of field 'minimumFractionDigits'.
     * 
     * @param minimumFractionDigits the value of field
     * 'minimumFractionDigits'.
     */
    public void setMinimumFractionDigits(
            final long minimumFractionDigits) {
        this._minimumFractionDigits = minimumFractionDigits;
        this._has_minimumFractionDigits = true;
    }

    /**
     * Sets the value of field 'minimumIntegerDigits'.
     * 
     * @param minimumIntegerDigits the value of field
     * 'minimumIntegerDigits'.
     */
    public void setMinimumIntegerDigits(
            final long minimumIntegerDigits) {
        this._minimumIntegerDigits = minimumIntegerDigits;
        this._has_minimumIntegerDigits = true;
    }

    /**
     * Sets the value of field 'negativePrefix'.
     * 
     * @param negativePrefix the value of field 'negativePrefix'.
     */
    public void setNegativePrefix(
            final java.lang.String negativePrefix) {
        this._negativePrefix = negativePrefix;
    }

    /**
     * Sets the value of field 'negativeSuffix'.
     * 
     * @param negativeSuffix the value of field 'negativeSuffix'.
     */
    public void setNegativeSuffix(
            final java.lang.String negativeSuffix) {
        this._negativeSuffix = negativeSuffix;
    }

    /**
     * Sets the value of field 'notation'.
     * 
     * @param notation the value of field 'notation'.
     */
    public void setNotation(
            final org.hbird.xtce.castor.types.NumberFormatNotationType notation) {
        this._notation = notation;
    }

    /**
     * Sets the value of field 'numberBase'.
     * 
     * @param numberBase the value of field 'numberBase'.
     */
    public void setNumberBase(
            final org.hbird.xtce.castor.types.RadixType numberBase) {
        this._numberBase = numberBase;
    }

    /**
     * Sets the value of field 'positivePrefix'.
     * 
     * @param positivePrefix the value of field 'positivePrefix'.
     */
    public void setPositivePrefix(
            final java.lang.String positivePrefix) {
        this._positivePrefix = positivePrefix;
    }

    /**
     * Sets the value of field 'positiveSuffix'.
     * 
     * @param positiveSuffix the value of field 'positiveSuffix'.
     */
    public void setPositiveSuffix(
            final java.lang.String positiveSuffix) {
        this._positiveSuffix = positiveSuffix;
    }

    /**
     * Sets the value of field 'showThousandsGrouping'.
     * 
     * @param showThousandsGrouping the value of field
     * 'showThousandsGrouping'.
     */
    public void setShowThousandsGrouping(
            final boolean showThousandsGrouping) {
        this._showThousandsGrouping = showThousandsGrouping;
        this._has_showThousandsGrouping = true;
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
     * org.hbird.xtce.castor.NumberFormat
     */
    public static org.hbird.xtce.castor.NumberFormat unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.NumberFormat) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.NumberFormat.class, reader);
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
