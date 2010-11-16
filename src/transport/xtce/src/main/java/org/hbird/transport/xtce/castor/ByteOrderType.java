/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * An ordered list of bytes where the order of the bytes is in
 * stream order. Each byte has an attribute giving its
 * significance.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ByteOrderType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _items.
     */
    private java.util.List<org.hbird.transport.xtce.castor.ByteOrderTypeItem> _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public ByteOrderType() {
        super();
        this._items = new java.util.ArrayList<org.hbird.transport.xtce.castor.ByteOrderTypeItem>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vByteOrderTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addByteOrderTypeItem(
            final org.hbird.transport.xtce.castor.ByteOrderTypeItem vByteOrderTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(vByteOrderTypeItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vByteOrderTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addByteOrderTypeItem(
            final int index,
            final org.hbird.transport.xtce.castor.ByteOrderTypeItem vByteOrderTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(index, vByteOrderTypeItem);
    }

    /**
     * Method enumerateByteOrderTypeItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends org.hbird.transport.xtce.castor.ByteOrderTypeItem> enumerateByteOrderTypeItem(
    ) {
        return java.util.Collections.enumeration(this._items);
    }

    /**
     * Method getByteOrderTypeItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.hbird.xtce.castor.ByteOrderTypeItem at the
     * given index
     */
    public org.hbird.transport.xtce.castor.ByteOrderTypeItem getByteOrderTypeItem(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("getByteOrderTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        return (org.hbird.transport.xtce.castor.ByteOrderTypeItem) _items.get(index);
    }

    /**
     * Method getByteOrderTypeItem.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.hbird.transport.xtce.castor.ByteOrderTypeItem[] getByteOrderTypeItem(
    ) {
        org.hbird.transport.xtce.castor.ByteOrderTypeItem[] array = new org.hbird.transport.xtce.castor.ByteOrderTypeItem[0];
        return (org.hbird.transport.xtce.castor.ByteOrderTypeItem[]) this._items.toArray(array);
    }

    /**
     * Method getByteOrderTypeItemCount.
     * 
     * @return the size of this collection
     */
    public int getByteOrderTypeItemCount(
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
     * Method iterateByteOrderTypeItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends org.hbird.transport.xtce.castor.ByteOrderTypeItem> iterateByteOrderTypeItem(
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
    public void removeAllByteOrderTypeItem(
    ) {
        this._items.clear();
    }

    /**
     * Method removeByteOrderTypeItem.
     * 
     * @param vByteOrderTypeItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeByteOrderTypeItem(
            final org.hbird.transport.xtce.castor.ByteOrderTypeItem vByteOrderTypeItem) {
        boolean removed = _items.remove(vByteOrderTypeItem);
        return removed;
    }

    /**
     * Method removeByteOrderTypeItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.hbird.transport.xtce.castor.ByteOrderTypeItem removeByteOrderTypeItemAt(
            final int index) {
        java.lang.Object obj = this._items.remove(index);
        return (org.hbird.transport.xtce.castor.ByteOrderTypeItem) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vByteOrderTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setByteOrderTypeItem(
            final int index,
            final org.hbird.transport.xtce.castor.ByteOrderTypeItem vByteOrderTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("setByteOrderTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        this._items.set(index, vByteOrderTypeItem);
    }

    /**
     * 
     * 
     * @param vByteOrderTypeItemArray
     */
    public void setByteOrderTypeItem(
            final org.hbird.transport.xtce.castor.ByteOrderTypeItem[] vByteOrderTypeItemArray) {
        //-- copy array
        _items.clear();

        for (int i = 0; i < vByteOrderTypeItemArray.length; i++) {
                this._items.add(vByteOrderTypeItemArray[i]);
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
     * org.hbird.xtce.castor.ByteOrderType
     */
    public static org.hbird.transport.xtce.castor.ByteOrderType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.ByteOrderType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.ByteOrderType.class, reader);
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
