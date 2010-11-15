/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Contains a String Value
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class StringDataType extends com.logica.hummingbird.xtce.castor.BaseDataType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _initialValue.
     */
    private java.lang.String _initialValue;

    /**
     * Field _restrictionPattern.
     */
    private java.lang.String _restrictionPattern;

    /**
     * Field _characterWidth.
     */
    private com.logica.hummingbird.xtce.castor.types.BaseDataTypeCharacterWidthType _characterWidth;

    /**
     * Field _sizeRangeInCharacters.
     */
    private com.logica.hummingbird.xtce.castor.SizeRangeInCharacters _sizeRangeInCharacters;

    /**
     * Field _defaultCalibrator.
     */
    private com.logica.hummingbird.xtce.castor.DefaultCalibrator _defaultCalibrator;

    /**
     * Field _contextCalibratorList.
     */
    private com.logica.hummingbird.xtce.castor.ContextCalibratorList _contextCalibratorList;


      //----------------/
     //- Constructors -/
    //----------------/

    public StringDataType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'characterWidth'.
     * 
     * @return the value of field 'CharacterWidth'.
     */
    public com.logica.hummingbird.xtce.castor.types.BaseDataTypeCharacterWidthType getCharacterWidth(
    ) {
        return this._characterWidth;
    }

    /**
     * Returns the value of field 'contextCalibratorList'.
     * 
     * @return the value of field 'ContextCalibratorList'.
     */
    public com.logica.hummingbird.xtce.castor.ContextCalibratorList getContextCalibratorList(
    ) {
        return this._contextCalibratorList;
    }

    /**
     * Returns the value of field 'defaultCalibrator'.
     * 
     * @return the value of field 'DefaultCalibrator'.
     */
    public com.logica.hummingbird.xtce.castor.DefaultCalibrator getDefaultCalibrator(
    ) {
        return this._defaultCalibrator;
    }

    /**
     * Returns the value of field 'initialValue'.
     * 
     * @return the value of field 'InitialValue'.
     */
    public java.lang.String getInitialValue(
    ) {
        return this._initialValue;
    }

    /**
     * Returns the value of field 'restrictionPattern'.
     * 
     * @return the value of field 'RestrictionPattern'.
     */
    public java.lang.String getRestrictionPattern(
    ) {
        return this._restrictionPattern;
    }

    /**
     * Returns the value of field 'sizeRangeInCharacters'.
     * 
     * @return the value of field 'SizeRangeInCharacters'.
     */
    public com.logica.hummingbird.xtce.castor.SizeRangeInCharacters getSizeRangeInCharacters(
    ) {
        return this._sizeRangeInCharacters;
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
     * Sets the value of field 'characterWidth'.
     * 
     * @param characterWidth the value of field 'characterWidth'.
     */
    public void setCharacterWidth(
            final com.logica.hummingbird.xtce.castor.types.BaseDataTypeCharacterWidthType characterWidth) {
        this._characterWidth = characterWidth;
    }

    /**
     * Sets the value of field 'contextCalibratorList'.
     * 
     * @param contextCalibratorList the value of field
     * 'contextCalibratorList'.
     */
    public void setContextCalibratorList(
            final com.logica.hummingbird.xtce.castor.ContextCalibratorList contextCalibratorList) {
        this._contextCalibratorList = contextCalibratorList;
    }

    /**
     * Sets the value of field 'defaultCalibrator'.
     * 
     * @param defaultCalibrator the value of field
     * 'defaultCalibrator'.
     */
    public void setDefaultCalibrator(
            final com.logica.hummingbird.xtce.castor.DefaultCalibrator defaultCalibrator) {
        this._defaultCalibrator = defaultCalibrator;
    }

    /**
     * Sets the value of field 'initialValue'.
     * 
     * @param initialValue the value of field 'initialValue'.
     */
    public void setInitialValue(
            final java.lang.String initialValue) {
        this._initialValue = initialValue;
    }

    /**
     * Sets the value of field 'restrictionPattern'.
     * 
     * @param restrictionPattern the value of field
     * 'restrictionPattern'.
     */
    public void setRestrictionPattern(
            final java.lang.String restrictionPattern) {
        this._restrictionPattern = restrictionPattern;
    }

    /**
     * Sets the value of field 'sizeRangeInCharacters'.
     * 
     * @param sizeRangeInCharacters the value of field
     * 'sizeRangeInCharacters'.
     */
    public void setSizeRangeInCharacters(
            final com.logica.hummingbird.xtce.castor.SizeRangeInCharacters sizeRangeInCharacters) {
        this._sizeRangeInCharacters = sizeRangeInCharacters;
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
     * com.logica.hummingbird.xtce.castor.StringDataType
     */
    public static com.logica.hummingbird.xtce.castor.StringDataType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.StringDataType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.StringDataType.class, reader);
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
