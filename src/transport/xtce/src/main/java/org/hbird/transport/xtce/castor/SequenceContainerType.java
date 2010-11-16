/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * A list of raw parameters, parameter segments, stream segments,
 * containers, or container segments. Sequence containers may
 * inherit from other sequence containers; when they do, the
 * sequence in the parent SequenceContainer is 'inherited' and if
 * the location of entries in the child sequence is not specified,
 * it is assumed to start where the parent sequence ended. Parent
 * sequence containers may be marked as "abstract". The idle
 * pattern is part of any unallocated space in the Container.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SequenceContainerType extends org.hbird.transport.xtce.castor.ContainerType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _abstract.
     */
    private boolean _abstract;

    /**
     * keeps track of state for field: _abstract
     */
    private boolean _has_abstract;

    /**
     * Field _idlePattern.
     */
    private java.lang.String _idlePattern = "0x0";

    /**
     * Field _entryList.
     */
    private org.hbird.transport.xtce.castor.EntryList _entryList;

    /**
     * Field _baseContainer.
     */
    private org.hbird.transport.xtce.castor.BaseContainer _baseContainer;


      //----------------/
     //- Constructors -/
    //----------------/

    public SequenceContainerType() {
        super();
        setIdlePattern("0x0");
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteAbstract(
    ) {
        this._has_abstract= false;
    }

    /**
     * Returns the value of field 'abstract'.
     * 
     * @return the value of field 'Abstract'.
     */
    public boolean getAbstract(
    ) {
        return this._abstract;
    }

    /**
     * Returns the value of field 'baseContainer'.
     * 
     * @return the value of field 'BaseContainer'.
     */
    public org.hbird.transport.xtce.castor.BaseContainer getBaseContainer(
    ) {
        return this._baseContainer;
    }

    /**
     * Returns the value of field 'entryList'.
     * 
     * @return the value of field 'EntryList'.
     */
    public org.hbird.transport.xtce.castor.EntryList getEntryList(
    ) {
        return this._entryList;
    }

    /**
     * Returns the value of field 'idlePattern'.
     * 
     * @return the value of field 'IdlePattern'.
     */
    public java.lang.String getIdlePattern(
    ) {
        return this._idlePattern;
    }

    /**
     * Method hasAbstract.
     * 
     * @return true if at least one Abstract has been added
     */
    public boolean hasAbstract(
    ) {
        return this._has_abstract;
    }

    /**
     * Returns the value of field 'abstract'.
     * 
     * @return the value of field 'Abstract'.
     */
    public boolean isAbstract(
    ) {
        return this._abstract;
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
     * Sets the value of field 'abstract'.
     * 
     * @param _abstract
     * @param abstract the value of field 'abstract'.
     */
    public void setAbstract(
            final boolean _abstract) {
        this._abstract = _abstract;
        this._has_abstract = true;
    }

    /**
     * Sets the value of field 'baseContainer'.
     * 
     * @param baseContainer the value of field 'baseContainer'.
     */
    public void setBaseContainer(
            final org.hbird.transport.xtce.castor.BaseContainer baseContainer) {
        this._baseContainer = baseContainer;
    }

    /**
     * Sets the value of field 'entryList'.
     * 
     * @param entryList the value of field 'entryList'.
     */
    public void setEntryList(
            final org.hbird.transport.xtce.castor.EntryList entryList) {
        this._entryList = entryList;
    }

    /**
     * Sets the value of field 'idlePattern'.
     * 
     * @param idlePattern the value of field 'idlePattern'.
     */
    public void setIdlePattern(
            final java.lang.String idlePattern) {
        this._idlePattern = idlePattern;
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
     * org.hbird.xtce.castor.SequenceContainerType
     */
    public static org.hbird.transport.xtce.castor.SequenceContainerType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.SequenceContainerType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.SequenceContainerType.class, reader);
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
