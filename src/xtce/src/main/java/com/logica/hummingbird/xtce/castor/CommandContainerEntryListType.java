/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Similar to an EntryList type but also may include command
 * arguments or -as a convenience - fixed value entries.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CommandContainerEntryListType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _items.
     */
    private java.util.List<com.logica.hummingbird.xtce.castor.CommandContainerEntryListTypeItem> _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public CommandContainerEntryListType() {
        super();
        this._items = new java.util.ArrayList<com.logica.hummingbird.xtce.castor.CommandContainerEntryListTypeItem>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vCommandContainerEntryListTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCommandContainerEntryListTypeItem(
            final com.logica.hummingbird.xtce.castor.CommandContainerEntryListTypeItem vCommandContainerEntryListTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(vCommandContainerEntryListTypeItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vCommandContainerEntryListTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCommandContainerEntryListTypeItem(
            final int index,
            final com.logica.hummingbird.xtce.castor.CommandContainerEntryListTypeItem vCommandContainerEntryListTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(index, vCommandContainerEntryListTypeItem);
    }

    /**
     * Method enumerateCommandContainerEntryListTypeItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends com.logica.hummingbird.xtce.castor.CommandContainerEntryListTypeItem> enumerateCommandContainerEntryListTypeItem(
    ) {
        return java.util.Collections.enumeration(this._items);
    }

    /**
     * Method getCommandContainerEntryListTypeItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.logica.hummingbird.xtce.castor.CommandContainerEntryListTypeItem
     * at the given index
     */
    public com.logica.hummingbird.xtce.castor.CommandContainerEntryListTypeItem getCommandContainerEntryListTypeItem(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("getCommandContainerEntryListTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        return (com.logica.hummingbird.xtce.castor.CommandContainerEntryListTypeItem) _items.get(index);
    }

    /**
     * Method getCommandContainerEntryListTypeItem.Returns the
     * contents of the collection in an Array.  <p>Note:  Just in
     * case the collection contents are changing in another thread,
     * we pass a 0-length Array of the correct type into the API
     * call.  This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.logica.hummingbird.xtce.castor.CommandContainerEntryListTypeItem[] getCommandContainerEntryListTypeItem(
    ) {
        com.logica.hummingbird.xtce.castor.CommandContainerEntryListTypeItem[] array = new com.logica.hummingbird.xtce.castor.CommandContainerEntryListTypeItem[0];
        return (com.logica.hummingbird.xtce.castor.CommandContainerEntryListTypeItem[]) this._items.toArray(array);
    }

    /**
     * Method getCommandContainerEntryListTypeItemCount.
     * 
     * @return the size of this collection
     */
    public int getCommandContainerEntryListTypeItemCount(
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
     * Method iterateCommandContainerEntryListTypeItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends com.logica.hummingbird.xtce.castor.CommandContainerEntryListTypeItem> iterateCommandContainerEntryListTypeItem(
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
    public void removeAllCommandContainerEntryListTypeItem(
    ) {
        this._items.clear();
    }

    /**
     * Method removeCommandContainerEntryListTypeItem.
     * 
     * @param vCommandContainerEntryListTypeItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeCommandContainerEntryListTypeItem(
            final com.logica.hummingbird.xtce.castor.CommandContainerEntryListTypeItem vCommandContainerEntryListTypeItem) {
        boolean removed = _items.remove(vCommandContainerEntryListTypeItem);
        return removed;
    }

    /**
     * Method removeCommandContainerEntryListTypeItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.logica.hummingbird.xtce.castor.CommandContainerEntryListTypeItem removeCommandContainerEntryListTypeItemAt(
            final int index) {
        java.lang.Object obj = this._items.remove(index);
        return (com.logica.hummingbird.xtce.castor.CommandContainerEntryListTypeItem) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vCommandContainerEntryListTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCommandContainerEntryListTypeItem(
            final int index,
            final com.logica.hummingbird.xtce.castor.CommandContainerEntryListTypeItem vCommandContainerEntryListTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("setCommandContainerEntryListTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        this._items.set(index, vCommandContainerEntryListTypeItem);
    }

    /**
     * 
     * 
     * @param vCommandContainerEntryListTypeItemArray
     */
    public void setCommandContainerEntryListTypeItem(
            final com.logica.hummingbird.xtce.castor.CommandContainerEntryListTypeItem[] vCommandContainerEntryListTypeItemArray) {
        //-- copy array
        _items.clear();

        for (int i = 0; i < vCommandContainerEntryListTypeItemArray.length; i++) {
                this._items.add(vCommandContainerEntryListTypeItemArray[i]);
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
     * com.logica.hummingbird.xtce.castor.CommandContainerEntryListType
     */
    public static com.logica.hummingbird.xtce.castor.CommandContainerEntryListType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.CommandContainerEntryListType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.CommandContainerEntryListType.class, reader);
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
