/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * A set of Command Definitions
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class MetaCommandSet implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _items.
     */
    private java.util.List<com.logica.hummingbird.xtce.castor.MetaCommandSetItem> _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public MetaCommandSet() {
        super();
        this._items = new java.util.ArrayList<com.logica.hummingbird.xtce.castor.MetaCommandSetItem>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vMetaCommandSetItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addMetaCommandSetItem(
            final com.logica.hummingbird.xtce.castor.MetaCommandSetItem vMetaCommandSetItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(vMetaCommandSetItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vMetaCommandSetItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addMetaCommandSetItem(
            final int index,
            final com.logica.hummingbird.xtce.castor.MetaCommandSetItem vMetaCommandSetItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(index, vMetaCommandSetItem);
    }

    /**
     * Method enumerateMetaCommandSetItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends com.logica.hummingbird.xtce.castor.MetaCommandSetItem> enumerateMetaCommandSetItem(
    ) {
        return java.util.Collections.enumeration(this._items);
    }

    /**
     * Method getMetaCommandSetItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.logica.hummingbird.xtce.castor.MetaCommandSetItem at the
     * given index
     */
    public com.logica.hummingbird.xtce.castor.MetaCommandSetItem getMetaCommandSetItem(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("getMetaCommandSetItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        return (com.logica.hummingbird.xtce.castor.MetaCommandSetItem) _items.get(index);
    }

    /**
     * Method getMetaCommandSetItem.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.logica.hummingbird.xtce.castor.MetaCommandSetItem[] getMetaCommandSetItem(
    ) {
        com.logica.hummingbird.xtce.castor.MetaCommandSetItem[] array = new com.logica.hummingbird.xtce.castor.MetaCommandSetItem[0];
        return (com.logica.hummingbird.xtce.castor.MetaCommandSetItem[]) this._items.toArray(array);
    }

    /**
     * Method getMetaCommandSetItemCount.
     * 
     * @return the size of this collection
     */
    public int getMetaCommandSetItemCount(
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
     * Method iterateMetaCommandSetItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends com.logica.hummingbird.xtce.castor.MetaCommandSetItem> iterateMetaCommandSetItem(
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
    public void removeAllMetaCommandSetItem(
    ) {
        this._items.clear();
    }

    /**
     * Method removeMetaCommandSetItem.
     * 
     * @param vMetaCommandSetItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeMetaCommandSetItem(
            final com.logica.hummingbird.xtce.castor.MetaCommandSetItem vMetaCommandSetItem) {
        boolean removed = _items.remove(vMetaCommandSetItem);
        return removed;
    }

    /**
     * Method removeMetaCommandSetItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.logica.hummingbird.xtce.castor.MetaCommandSetItem removeMetaCommandSetItemAt(
            final int index) {
        java.lang.Object obj = this._items.remove(index);
        return (com.logica.hummingbird.xtce.castor.MetaCommandSetItem) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vMetaCommandSetItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setMetaCommandSetItem(
            final int index,
            final com.logica.hummingbird.xtce.castor.MetaCommandSetItem vMetaCommandSetItem)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("setMetaCommandSetItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        this._items.set(index, vMetaCommandSetItem);
    }

    /**
     * 
     * 
     * @param vMetaCommandSetItemArray
     */
    public void setMetaCommandSetItem(
            final com.logica.hummingbird.xtce.castor.MetaCommandSetItem[] vMetaCommandSetItemArray) {
        //-- copy array
        _items.clear();

        for (int i = 0; i < vMetaCommandSetItemArray.length; i++) {
                this._items.add(vMetaCommandSetItemArray[i]);
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
     * com.logica.hummingbird.xtce.castor.MetaCommandSet
     */
    public static com.logica.hummingbird.xtce.castor.MetaCommandSet unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.MetaCommandSet) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.MetaCommandSet.class, reader);
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
