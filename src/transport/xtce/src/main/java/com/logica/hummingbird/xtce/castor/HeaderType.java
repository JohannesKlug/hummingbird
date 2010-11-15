/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * Schema for a Header record. A header contains general
 * information about the system or subsystem.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class HeaderType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _version.
     */
    private java.lang.String _version;

    /**
     * Field _date.
     */
    private java.lang.String _date;

    /**
     * Field _classification.
     */
    private java.lang.String _classification = "NotClassified";

    /**
     * Field _classificationInstructions.
     */
    private java.lang.String _classificationInstructions;

    /**
     * Field _validationStatus.
     */
    private org.hbird.xtce.castor.types.HeaderTypeValidationStatusType _validationStatus;

    /**
     * Field _authorSet.
     */
    private org.hbird.xtce.castor.AuthorSet _authorSet;

    /**
     * Field _noteSet.
     */
    private org.hbird.xtce.castor.NoteSet _noteSet;

    /**
     * Field _historySet.
     */
    private org.hbird.xtce.castor.HistorySet _historySet;


      //----------------/
     //- Constructors -/
    //----------------/

    public HeaderType() {
        super();
        setClassification("NotClassified");
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'authorSet'.
     * 
     * @return the value of field 'AuthorSet'.
     */
    public org.hbird.xtce.castor.AuthorSet getAuthorSet(
    ) {
        return this._authorSet;
    }

    /**
     * Returns the value of field 'classification'.
     * 
     * @return the value of field 'Classification'.
     */
    public java.lang.String getClassification(
    ) {
        return this._classification;
    }

    /**
     * Returns the value of field 'classificationInstructions'.
     * 
     * @return the value of field 'ClassificationInstructions'.
     */
    public java.lang.String getClassificationInstructions(
    ) {
        return this._classificationInstructions;
    }

    /**
     * Returns the value of field 'date'.
     * 
     * @return the value of field 'Date'.
     */
    public java.lang.String getDate(
    ) {
        return this._date;
    }

    /**
     * Returns the value of field 'historySet'.
     * 
     * @return the value of field 'HistorySet'.
     */
    public org.hbird.xtce.castor.HistorySet getHistorySet(
    ) {
        return this._historySet;
    }

    /**
     * Returns the value of field 'noteSet'.
     * 
     * @return the value of field 'NoteSet'.
     */
    public org.hbird.xtce.castor.NoteSet getNoteSet(
    ) {
        return this._noteSet;
    }

    /**
     * Returns the value of field 'validationStatus'.
     * 
     * @return the value of field 'ValidationStatus'.
     */
    public org.hbird.xtce.castor.types.HeaderTypeValidationStatusType getValidationStatus(
    ) {
        return this._validationStatus;
    }

    /**
     * Returns the value of field 'version'.
     * 
     * @return the value of field 'Version'.
     */
    public java.lang.String getVersion(
    ) {
        return this._version;
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
     * Sets the value of field 'authorSet'.
     * 
     * @param authorSet the value of field 'authorSet'.
     */
    public void setAuthorSet(
            final org.hbird.xtce.castor.AuthorSet authorSet) {
        this._authorSet = authorSet;
    }

    /**
     * Sets the value of field 'classification'.
     * 
     * @param classification the value of field 'classification'.
     */
    public void setClassification(
            final java.lang.String classification) {
        this._classification = classification;
    }

    /**
     * Sets the value of field 'classificationInstructions'.
     * 
     * @param classificationInstructions the value of field
     * 'classificationInstructions'.
     */
    public void setClassificationInstructions(
            final java.lang.String classificationInstructions) {
        this._classificationInstructions = classificationInstructions;
    }

    /**
     * Sets the value of field 'date'.
     * 
     * @param date the value of field 'date'.
     */
    public void setDate(
            final java.lang.String date) {
        this._date = date;
    }

    /**
     * Sets the value of field 'historySet'.
     * 
     * @param historySet the value of field 'historySet'.
     */
    public void setHistorySet(
            final org.hbird.xtce.castor.HistorySet historySet) {
        this._historySet = historySet;
    }

    /**
     * Sets the value of field 'noteSet'.
     * 
     * @param noteSet the value of field 'noteSet'.
     */
    public void setNoteSet(
            final org.hbird.xtce.castor.NoteSet noteSet) {
        this._noteSet = noteSet;
    }

    /**
     * Sets the value of field 'validationStatus'.
     * 
     * @param validationStatus the value of field 'validationStatus'
     */
    public void setValidationStatus(
            final org.hbird.xtce.castor.types.HeaderTypeValidationStatusType validationStatus) {
        this._validationStatus = validationStatus;
    }

    /**
     * Sets the value of field 'version'.
     * 
     * @param version the value of field 'version'.
     */
    public void setVersion(
            final java.lang.String version) {
        this._version = version;
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
     * org.hbird.xtce.castor.HeaderType
     */
    public static org.hbird.xtce.castor.HeaderType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.HeaderType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.HeaderType.class, reader);
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
