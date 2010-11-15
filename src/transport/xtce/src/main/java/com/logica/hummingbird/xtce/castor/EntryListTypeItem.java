/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

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
    private org.hbird.xtce.castor.ParameterRefEntry _parameterRefEntry;

    /**
     * Field _parameterSegmentRefEntry.
     */
    private org.hbird.xtce.castor.ParameterSegmentRefEntry _parameterSegmentRefEntry;

    /**
     * Field _containerRefEntry.
     */
    private org.hbird.xtce.castor.ContainerRefEntry _containerRefEntry;

    /**
     * Field _containerSegmentRefEntry.
     */
    private org.hbird.xtce.castor.ContainerSegmentRefEntry _containerSegmentRefEntry;

    /**
     * Field _streamSegmentEntry.
     */
    private org.hbird.xtce.castor.StreamSegmentEntry _streamSegmentEntry;

    /**
     * Field _indirectParameterRefEntry.
     */
    private org.hbird.xtce.castor.IndirectParameterRefEntry _indirectParameterRefEntry;

    /**
     * Field _arrayParameterRefEntry.
     */
    private org.hbird.xtce.castor.ArrayParameterRefEntry _arrayParameterRefEntry;


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
    public org.hbird.xtce.castor.ArrayParameterRefEntry getArrayParameterRefEntry(
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
    public org.hbird.xtce.castor.ContainerRefEntry getContainerRefEntry(
    ) {
        return this._containerRefEntry;
    }

    /**
     * Returns the value of field 'containerSegmentRefEntry'.
     * 
     * @return the value of field 'ContainerSegmentRefEntry'.
     */
    public org.hbird.xtce.castor.ContainerSegmentRefEntry getContainerSegmentRefEntry(
    ) {
        return this._containerSegmentRefEntry;
    }

    /**
     * Returns the value of field 'indirectParameterRefEntry'.
     * 
     * @return the value of field 'IndirectParameterRefEntry'.
     */
    public org.hbird.xtce.castor.IndirectParameterRefEntry getIndirectParameterRefEntry(
    ) {
        return this._indirectParameterRefEntry;
    }

    /**
     * Returns the value of field 'parameterRefEntry'.
     * 
     * @return the value of field 'ParameterRefEntry'.
     */
    public org.hbird.xtce.castor.ParameterRefEntry getParameterRefEntry(
    ) {
        return this._parameterRefEntry;
    }

    /**
     * Returns the value of field 'parameterSegmentRefEntry'.
     * 
     * @return the value of field 'ParameterSegmentRefEntry'.
     */
    public org.hbird.xtce.castor.ParameterSegmentRefEntry getParameterSegmentRefEntry(
    ) {
        return this._parameterSegmentRefEntry;
    }

    /**
     * Returns the value of field 'streamSegmentEntry'.
     * 
     * @return the value of field 'StreamSegmentEntry'.
     */
    public org.hbird.xtce.castor.StreamSegmentEntry getStreamSegmentEntry(
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
            final org.hbird.xtce.castor.ArrayParameterRefEntry arrayParameterRefEntry) {
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
            final org.hbird.xtce.castor.ContainerRefEntry containerRefEntry) {
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
            final org.hbird.xtce.castor.ContainerSegmentRefEntry containerSegmentRefEntry) {
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
            final org.hbird.xtce.castor.IndirectParameterRefEntry indirectParameterRefEntry) {
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
            final org.hbird.xtce.castor.ParameterRefEntry parameterRefEntry) {
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
            final org.hbird.xtce.castor.ParameterSegmentRefEntry parameterSegmentRefEntry) {
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
            final org.hbird.xtce.castor.StreamSegmentEntry streamSegmentEntry) {
        this._streamSegmentEntry = streamSegmentEntry;
        this._choiceValue = streamSegmentEntry;
    }

}
