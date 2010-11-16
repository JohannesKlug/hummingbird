/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * Contains an unordered set of Streams.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class StreamSetType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _items.
     */
    private java.util.List<org.hbird.transport.xtce.castor.StreamSetTypeItem> _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public StreamSetType() {
        super();
        this._items = new java.util.ArrayList<org.hbird.transport.xtce.castor.StreamSetTypeItem>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vStreamSetTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addStreamSetTypeItem(
            final org.hbird.transport.xtce.castor.StreamSetTypeItem vStreamSetTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(vStreamSetTypeItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vStreamSetTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addStreamSetTypeItem(
            final int index,
            final org.hbird.transport.xtce.castor.StreamSetTypeItem vStreamSetTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(index, vStreamSetTypeItem);
    }

    /**
     * Method enumerateStreamSetTypeItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends org.hbird.transport.xtce.castor.StreamSetTypeItem> enumerateStreamSetTypeItem(
    ) {
        return java.util.Collections.enumeration(this._items);
    }

    /**
     * Method getStreamSetTypeItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.hbird.xtce.castor.StreamSetTypeItem at the
     * given index
     */
    public org.hbird.transport.xtce.castor.StreamSetTypeItem getStreamSetTypeItem(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("getStreamSetTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        return (org.hbird.transport.xtce.castor.StreamSetTypeItem) _items.get(index);
    }

    /**
     * Method getStreamSetTypeItem.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.hbird.transport.xtce.castor.StreamSetTypeItem[] getStreamSetTypeItem(
    ) {
        org.hbird.transport.xtce.castor.StreamSetTypeItem[] array = new org.hbird.transport.xtce.castor.StreamSetTypeItem[0];
        return (org.hbird.transport.xtce.castor.StreamSetTypeItem[]) this._items.toArray(array);
    }

    /**
     * Method getStreamSetTypeItemCount.
     * 
     * @return the size of this collection
     */
    public int getStreamSetTypeItemCount(
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
     * Method iterateStreamSetTypeItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends org.hbird.transport.xtce.castor.StreamSetTypeItem> iterateStreamSetTypeItem(
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
    public void removeAllStreamSetTypeItem(
    ) {
        this._items.clear();
    }

    /**
     * Method removeStreamSetTypeItem.
     * 
     * @param vStreamSetTypeItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeStreamSetTypeItem(
            final org.hbird.transport.xtce.castor.StreamSetTypeItem vStreamSetTypeItem) {
        boolean removed = _items.remove(vStreamSetTypeItem);
        return removed;
    }

    /**
     * Method removeStreamSetTypeItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.hbird.transport.xtce.castor.StreamSetTypeItem removeStreamSetTypeItemAt(
            final int index) {
        java.lang.Object obj = this._items.remove(index);
        return (org.hbird.transport.xtce.castor.StreamSetTypeItem) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vStreamSetTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setStreamSetTypeItem(
            final int index,
            final org.hbird.transport.xtce.castor.StreamSetTypeItem vStreamSetTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("setStreamSetTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        this._items.set(index, vStreamSetTypeItem);
    }

    /**
     * 
     * 
     * @param vStreamSetTypeItemArray
     */
    public void setStreamSetTypeItem(
            final org.hbird.transport.xtce.castor.StreamSetTypeItem[] vStreamSetTypeItemArray) {
        //-- copy array
        _items.clear();

        for (int i = 0; i < vStreamSetTypeItemArray.length; i++) {
                this._items.add(vStreamSetTypeItemArray[i]);
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
     * org.hbird.xtce.castor.StreamSetType
     */
    public static org.hbird.transport.xtce.castor.StreamSetType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.StreamSetType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.StreamSetType.class, reader);
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
