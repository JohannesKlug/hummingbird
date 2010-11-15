/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * Contains an ordered list of Entries. Used in Sequence Container
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class EntryListType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _items.
     */
    private java.util.List<org.hbird.xtce.castor.EntryListTypeItem> _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public EntryListType() {
        super();
        this._items = new java.util.ArrayList<org.hbird.xtce.castor.EntryListTypeItem>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vEntryListTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addEntryListTypeItem(
            final org.hbird.xtce.castor.EntryListTypeItem vEntryListTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(vEntryListTypeItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vEntryListTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addEntryListTypeItem(
            final int index,
            final org.hbird.xtce.castor.EntryListTypeItem vEntryListTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(index, vEntryListTypeItem);
    }

    /**
     * Method enumerateEntryListTypeItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends org.hbird.xtce.castor.EntryListTypeItem> enumerateEntryListTypeItem(
    ) {
        return java.util.Collections.enumeration(this._items);
    }

    /**
     * Method getEntryListTypeItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.hbird.xtce.castor.EntryListTypeItem at the
     * given index
     */
    public org.hbird.xtce.castor.EntryListTypeItem getEntryListTypeItem(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("getEntryListTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        return (org.hbird.xtce.castor.EntryListTypeItem) _items.get(index);
    }

    /**
     * Method getEntryListTypeItem.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.hbird.xtce.castor.EntryListTypeItem[] getEntryListTypeItem(
    ) {
        org.hbird.xtce.castor.EntryListTypeItem[] array = new org.hbird.xtce.castor.EntryListTypeItem[0];
        return (org.hbird.xtce.castor.EntryListTypeItem[]) this._items.toArray(array);
    }

    /**
     * Method getEntryListTypeItemCount.
     * 
     * @return the size of this collection
     */
    public int getEntryListTypeItemCount(
    ) {
        return this._items.size();
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
     * Method iterateEntryListTypeItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends org.hbird.xtce.castor.EntryListTypeItem> iterateEntryListTypeItem(
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
    public void removeAllEntryListTypeItem(
    ) {
        this._items.clear();
    }

    /**
     * Method removeEntryListTypeItem.
     * 
     * @param vEntryListTypeItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeEntryListTypeItem(
            final org.hbird.xtce.castor.EntryListTypeItem vEntryListTypeItem) {
        boolean removed = _items.remove(vEntryListTypeItem);
        return removed;
    }

    /**
     * Method removeEntryListTypeItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.hbird.xtce.castor.EntryListTypeItem removeEntryListTypeItemAt(
            final int index) {
        java.lang.Object obj = this._items.remove(index);
        return (org.hbird.xtce.castor.EntryListTypeItem) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vEntryListTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setEntryListTypeItem(
            final int index,
            final org.hbird.xtce.castor.EntryListTypeItem vEntryListTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("setEntryListTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        this._items.set(index, vEntryListTypeItem);
    }

    /**
     * 
     * 
     * @param vEntryListTypeItemArray
     */
    public void setEntryListTypeItem(
            final org.hbird.xtce.castor.EntryListTypeItem[] vEntryListTypeItemArray) {
        //-- copy array
        _items.clear();

        for (int i = 0; i < vEntryListTypeItemArray.length; i++) {
                this._items.add(vEntryListTypeItemArray[i]);
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
     * org.hbird.xtce.castor.EntryListType
     */
    public static org.hbird.xtce.castor.EntryListType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.EntryListType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.EntryListType.class, reader);
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
