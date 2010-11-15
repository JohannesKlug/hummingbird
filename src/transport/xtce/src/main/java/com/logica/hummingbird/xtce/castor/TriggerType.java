/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * A trigger is used to initiate the processing of some algorithm.
 * A trigger may be based on an update of a Parameter or on a time
 * basis. Triggers may also have a rate that limits their firing to
 * a 1/rate basis.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class TriggerType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name.
     */
    private java.lang.String _name;

    /**
     * Field _triggerRate.
     */
    private long _triggerRate = 1;

    /**
     * keeps track of state for field: _triggerRate
     */
    private boolean _has_triggerRate;

    /**
     * Field _items.
     */
    private java.util.List<org.hbird.xtce.castor.TriggerTypeItem> _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public TriggerType() {
        super();
        this._items = new java.util.ArrayList<org.hbird.xtce.castor.TriggerTypeItem>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vTriggerTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addTriggerTypeItem(
            final org.hbird.xtce.castor.TriggerTypeItem vTriggerTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(vTriggerTypeItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vTriggerTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addTriggerTypeItem(
            final int index,
            final org.hbird.xtce.castor.TriggerTypeItem vTriggerTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(index, vTriggerTypeItem);
    }

    /**
     */
    public void deleteTriggerRate(
    ) {
        this._has_triggerRate= false;
    }

    /**
     * Method enumerateTriggerTypeItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends org.hbird.xtce.castor.TriggerTypeItem> enumerateTriggerTypeItem(
    ) {
        return java.util.Collections.enumeration(this._items);
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
     * Returns the value of field 'triggerRate'.
     * 
     * @return the value of field 'TriggerRate'.
     */
    public long getTriggerRate(
    ) {
        return this._triggerRate;
    }

    /**
     * Method getTriggerTypeItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.hbird.xtce.castor.TriggerTypeItem at the
     * given index
     */
    public org.hbird.xtce.castor.TriggerTypeItem getTriggerTypeItem(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("getTriggerTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        return (org.hbird.xtce.castor.TriggerTypeItem) _items.get(index);
    }

    /**
     * Method getTriggerTypeItem.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.hbird.xtce.castor.TriggerTypeItem[] getTriggerTypeItem(
    ) {
        org.hbird.xtce.castor.TriggerTypeItem[] array = new org.hbird.xtce.castor.TriggerTypeItem[0];
        return (org.hbird.xtce.castor.TriggerTypeItem[]) this._items.toArray(array);
    }

    /**
     * Method getTriggerTypeItemCount.
     * 
     * @return the size of this collection
     */
    public int getTriggerTypeItemCount(
    ) {
        return this._items.size();
    }

    /**
     * Method hasTriggerRate.
     * 
     * @return true if at least one TriggerRate has been added
     */
    public boolean hasTriggerRate(
    ) {
        return this._has_triggerRate;
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
     * Method iterateTriggerTypeItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends org.hbird.xtce.castor.TriggerTypeItem> iterateTriggerTypeItem(
    ) {
        return this._items.iterator();
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
     */
    public void removeAllTriggerTypeItem(
    ) {
        this._items.clear();
    }

    /**
     * Method removeTriggerTypeItem.
     * 
     * @param vTriggerTypeItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeTriggerTypeItem(
            final org.hbird.xtce.castor.TriggerTypeItem vTriggerTypeItem) {
        boolean removed = _items.remove(vTriggerTypeItem);
        return removed;
    }

    /**
     * Method removeTriggerTypeItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.hbird.xtce.castor.TriggerTypeItem removeTriggerTypeItemAt(
            final int index) {
        java.lang.Object obj = this._items.remove(index);
        return (org.hbird.xtce.castor.TriggerTypeItem) obj;
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
     * Sets the value of field 'triggerRate'.
     * 
     * @param triggerRate the value of field 'triggerRate'.
     */
    public void setTriggerRate(
            final long triggerRate) {
        this._triggerRate = triggerRate;
        this._has_triggerRate = true;
    }

    /**
     * 
     * 
     * @param index
     * @param vTriggerTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setTriggerTypeItem(
            final int index,
            final org.hbird.xtce.castor.TriggerTypeItem vTriggerTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("setTriggerTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        this._items.set(index, vTriggerTypeItem);
    }

    /**
     * 
     * 
     * @param vTriggerTypeItemArray
     */
    public void setTriggerTypeItem(
            final org.hbird.xtce.castor.TriggerTypeItem[] vTriggerTypeItemArray) {
        //-- copy array
        _items.clear();

        for (int i = 0; i < vTriggerTypeItemArray.length; i++) {
                this._items.add(vTriggerTypeItemArray[i]);
        }
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
     * org.hbird.xtce.castor.TriggerType
     */
    public static org.hbird.xtce.castor.TriggerType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.TriggerType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.TriggerType.class, reader);
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
