/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Class EntryListTypeItem.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class EntryListTypeItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _parameterRefEntry.
     */
    private com.logica.hummingbird.xtce.castor.ParameterRefEntry _parameterRefEntry;

    /**
     * Field _parameterSegmentRefEntry.
     */
    private com.logica.hummingbird.xtce.castor.ParameterSegmentRefEntry _parameterSegmentRefEntry;

    /**
     * Field _containerRefEntry.
     */
    private com.logica.hummingbird.xtce.castor.ContainerRefEntry _containerRefEntry;

    /**
     * Field _containerSegmentRefEntry.
     */
    private com.logica.hummingbird.xtce.castor.ContainerSegmentRefEntry _containerSegmentRefEntry;

    /**
     * Field _streamSegmentEntry.
     */
    private com.logica.hummingbird.xtce.castor.StreamSegmentEntry _streamSegmentEntry;

    /**
     * Field _indirectParameterRefEntry.
     */
    private com.logica.hummingbird.xtce.castor.IndirectParameterRefEntry _indirectParameterRefEntry;

    /**
     * Field _arrayParameterRefEntry.
     */
    private com.logica.hummingbird.xtce.castor.ArrayParameterRefEntry _arrayParameterRefEntry;


      //----------------/
     //- Constructors -/
    //----------------/

    public EntryListTypeItem() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'arrayParameterRefEntry'.
     * 
     * @return the value of field 'ArrayParameterRefEntry'.
     */
    public com.logica.hummingbird.xtce.castor.ArrayParameterRefEntry getArrayParameterRefEntry(
    ) {
        return this._arrayParameterRefEntry;
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
     * Returns the value of field 'containerRefEntry'.
     * 
     * @return the value of field 'ContainerRefEntry'.
     */
    public com.logica.hummingbird.xtce.castor.ContainerRefEntry getContainerRefEntry(
    ) {
        return this._containerRefEntry;
    }

    /**
     * Returns the value of field 'containerSegmentRefEntry'.
     * 
     * @return the value of field 'ContainerSegmentRefEntry'.
     */
    public com.logica.hummingbird.xtce.castor.ContainerSegmentRefEntry getContainerSegmentRefEntry(
    ) {
        return this._containerSegmentRefEntry;
    }

    /**
     * Returns the value of field 'indirectParameterRefEntry'.
     * 
     * @return the value of field 'IndirectParameterRefEntry'.
     */
    public com.logica.hummingbird.xtce.castor.IndirectParameterRefEntry getIndirectParameterRefEntry(
    ) {
        return this._indirectParameterRefEntry;
    }

    /**
     * Returns the value of field 'parameterRefEntry'.
     * 
     * @return the value of field 'ParameterRefEntry'.
     */
    public com.logica.hummingbird.xtce.castor.ParameterRefEntry getParameterRefEntry(
    ) {
        return this._parameterRefEntry;
    }

    /**
     * Returns the value of field 'parameterSegmentRefEntry'.
     * 
     * @return the value of field 'ParameterSegmentRefEntry'.
     */
    public com.logica.hummingbird.xtce.castor.ParameterSegmentRefEntry getParameterSegmentRefEntry(
    ) {
        return this._parameterSegmentRefEntry;
    }

    /**
     * Returns the value of field 'streamSegmentEntry'.
     * 
     * @return the value of field 'StreamSegmentEntry'.
     */
    public com.logica.hummingbird.xtce.castor.StreamSegmentEntry getStreamSegmentEntry(
    ) {
        return this._streamSegmentEntry;
    }

    /**
     * Sets the value of field 'arrayParameterRefEntry'.
     * 
     * @param arrayParameterRefEntry the value of field
     * 'arrayParameterRefEntry'.
     */
    public void setArrayParameterRefEntry(
            final com.logica.hummingbird.xtce.castor.ArrayParameterRefEntry arrayParameterRefEntry) {
        this._arrayParameterRefEntry = arrayParameterRefEntry;
        this._choiceValue = arrayParameterRefEntry;
    }

    /**
     * Sets the value of field 'containerRefEntry'.
     * 
     * @param containerRefEntry the value of field
     * 'containerRefEntry'.
     */
    public void setContainerRefEntry(
            final com.logica.hummingbird.xtce.castor.ContainerRefEntry containerRefEntry) {
        this._containerRefEntry = containerRefEntry;
        this._choiceValue = containerRefEntry;
    }

    /**
     * Sets the value of field 'containerSegmentRefEntry'.
     * 
     * @param containerSegmentRefEntry the value of field
     * 'containerSegmentRefEntry'.
     */
    public void setContainerSegmentRefEntry(
            final com.logica.hummingbird.xtce.castor.ContainerSegmentRefEntry containerSegmentRefEntry) {
        this._containerSegmentRefEntry = containerSegmentRefEntry;
        this._choiceValue = containerSegmentRefEntry;
    }

    /**
     * Sets the value of field 'indirectParameterRefEntry'.
     * 
     * @param indirectParameterRefEntry the value of field
     * 'indirectParameterRefEntry'.
     */
    public void setIndirectParameterRefEntry(
            final com.logica.hummingbird.xtce.castor.IndirectParameterRefEntry indirectParameterRefEntry) {
        this._indirectParameterRefEntry = indirectParameterRefEntry;
        this._choiceValue = indirectParameterRefEntry;
    }

    /**
     * Sets the value of field 'parameterRefEntry'.
     * 
     * @param parameterRefEntry the value of field
     * 'parameterRefEntry'.
     */
    public void setParameterRefEntry(
            final com.logica.hummingbird.xtce.castor.ParameterRefEntry parameterRefEntry) {
        this._parameterRefEntry = parameterRefEntry;
        this._choiceValue = parameterRefEntry;
    }

    /**
     * Sets the value of field 'parameterSegmentRefEntry'.
     * 
     * @param parameterSegmentRefEntry the value of field
     * 'parameterSegmentRefEntry'.
     */
    public void setParameterSegmentRefEntry(
            final com.logica.hummingbird.xtce.castor.ParameterSegmentRefEntry parameterSegmentRefEntry) {
        this._parameterSegmentRefEntry = parameterSegmentRefEntry;
        this._choiceValue = parameterSegmentRefEntry;
    }

    /**
     * Sets the value of field 'streamSegmentEntry'.
     * 
     * @param streamSegmentEntry the value of field
     * 'streamSegmentEntry'.
     */
    public void setStreamSegmentEntry(
            final com.logica.hummingbird.xtce.castor.StreamSegmentEntry streamSegmentEntry) {
        this._streamSegmentEntry = streamSegmentEntry;
        this._choiceValue = streamSegmentEntry;
    }

}
