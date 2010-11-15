/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * An abstract type used by sequence containers. An entry contains
 * a location in the container. The location may be either fixed or
 * dynamic, absolute (to the start or end of the enclosing
 * container, or relative (to either the previous or subsequent
 * entry). Entries may also repeat.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SequenceEntryType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * If no LocationInContainer value is given, the entry is
     * assumed to begin immediately after the previous entry.
     */
    private com.logica.hummingbird.xtce.castor.LocationInContainerInBits _locationInContainerInBits;

    /**
     * May be used when this entry repeats itself in the sequence
     * container. If not supplied, the entry does not repeat.
     */
    private com.logica.hummingbird.xtce.castor.RepeatEntry _repeatEntry;

    /**
     * This entry will only be included in the sequence when this
     * condition is true. If no IncludeCondition is given, then it
     * is will be included. A parameter that is not included will
     * be treated as if it did not exist in the sequence at all.
     */
    private com.logica.hummingbird.xtce.castor.IncludeCondition _includeCondition;


      //----------------/
     //- Constructors -/
    //----------------/

    public SequenceEntryType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'includeCondition'. The field
     * 'includeCondition' has the following description: This entry
     * will only be included in the sequence when this condition is
     * true. If no IncludeCondition is given, then it is will be
     * included. A parameter that is not included will be treated
     * as if it did not exist in the sequence at all.
     * 
     * @return the value of field 'IncludeCondition'.
     */
    public com.logica.hummingbird.xtce.castor.IncludeCondition getIncludeCondition(
    ) {
        return this._includeCondition;
    }

    /**
     * Returns the value of field 'locationInContainerInBits'. The
     * field 'locationInContainerInBits' has the following
     * description: If no LocationInContainer value is given, the
     * entry is assumed to begin immediately after the previous
     * entry.
     * 
     * @return the value of field 'LocationInContainerInBits'.
     */
    public com.logica.hummingbird.xtce.castor.LocationInContainerInBits getLocationInContainerInBits(
    ) {
        return this._locationInContainerInBits;
    }

    /**
     * Returns the value of field 'repeatEntry'. The field
     * 'repeatEntry' has the following description: May be used
     * when this entry repeats itself in the sequence container. If
     * not supplied, the entry does not repeat.
     * 
     * @return the value of field 'RepeatEntry'.
     */
    public com.logica.hummingbird.xtce.castor.RepeatEntry getRepeatEntry(
    ) {
        return this._repeatEntry;
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
     * Sets the value of field 'includeCondition'. The field
     * 'includeCondition' has the following description: This entry
     * will only be included in the sequence when this condition is
     * true. If no IncludeCondition is given, then it is will be
     * included. A parameter that is not included will be treated
     * as if it did not exist in the sequence at all.
     * 
     * @param includeCondition the value of field 'includeCondition'
     */
    public void setIncludeCondition(
            final com.logica.hummingbird.xtce.castor.IncludeCondition includeCondition) {
        this._includeCondition = includeCondition;
    }

    /**
     * Sets the value of field 'locationInContainerInBits'. The
     * field 'locationInContainerInBits' has the following
     * description: If no LocationInContainer value is given, the
     * entry is assumed to begin immediately after the previous
     * entry.
     * 
     * @param locationInContainerInBits the value of field
     * 'locationInContainerInBits'.
     */
    public void setLocationInContainerInBits(
            final com.logica.hummingbird.xtce.castor.LocationInContainerInBits locationInContainerInBits) {
        this._locationInContainerInBits = locationInContainerInBits;
    }

    /**
     * Sets the value of field 'repeatEntry'. The field
     * 'repeatEntry' has the following description: May be used
     * when this entry repeats itself in the sequence container. If
     * not supplied, the entry does not repeat.
     * 
     * @param repeatEntry the value of field 'repeatEntry'.
     */
    public void setRepeatEntry(
            final com.logica.hummingbird.xtce.castor.RepeatEntry repeatEntry) {
        this._repeatEntry = repeatEntry;
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
     * com.logica.hummingbird.xtce.castor.SequenceEntryType
     */
    public static com.logica.hummingbird.xtce.castor.SequenceEntryType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.SequenceEntryType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.SequenceEntryType.class, reader);
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
