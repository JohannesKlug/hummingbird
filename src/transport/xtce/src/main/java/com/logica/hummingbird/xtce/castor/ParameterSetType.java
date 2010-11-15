/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * Used by both the TelemetryMetaData and the CommandMetaData
 * components each may be built independently.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ParameterSetType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _items.
     */
    private java.util.List<org.hbird.xtce.castor.ParameterSetTypeItem> _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public ParameterSetType() {
        super();
        this._items = new java.util.ArrayList<org.hbird.xtce.castor.ParameterSetTypeItem>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vParameterSetTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addParameterSetTypeItem(
            final org.hbird.xtce.castor.ParameterSetTypeItem vParameterSetTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(vParameterSetTypeItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vParameterSetTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addParameterSetTypeItem(
            final int index,
            final org.hbird.xtce.castor.ParameterSetTypeItem vParameterSetTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(index, vParameterSetTypeItem);
    }

    /**
     * Method enumerateParameterSetTypeItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends org.hbird.xtce.castor.ParameterSetTypeItem> enumerateParameterSetTypeItem(
    ) {
        return java.util.Collections.enumeration(this._items);
    }

    /**
     * Method getParameterSetTypeItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.hbird.xtce.castor.ParameterSetTypeItem at
     * the given index
     */
    public org.hbird.xtce.castor.ParameterSetTypeItem getParameterSetTypeItem(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("getParameterSetTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        return (org.hbird.xtce.castor.ParameterSetTypeItem) _items.get(index);
    }

    /**
     * Method getParameterSetTypeItem.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.hbird.xtce.castor.ParameterSetTypeItem[] getParameterSetTypeItem(
    ) {
        org.hbird.xtce.castor.ParameterSetTypeItem[] array = new org.hbird.xtce.castor.ParameterSetTypeItem[0];
        return (org.hbird.xtce.castor.ParameterSetTypeItem[]) this._items.toArray(array);
    }

    /**
     * Method getParameterSetTypeItemCount.
     * 
     * @return the size of this collection
     */
    public int getParameterSetTypeItemCount(
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
     * Method iterateParameterSetTypeItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends org.hbird.xtce.castor.ParameterSetTypeItem> iterateParameterSetTypeItem(
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
    public void removeAllParameterSetTypeItem(
    ) {
        this._items.clear();
    }

    /**
     * Method removeParameterSetTypeItem.
     * 
     * @param vParameterSetTypeItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeParameterSetTypeItem(
            final org.hbird.xtce.castor.ParameterSetTypeItem vParameterSetTypeItem) {
        boolean removed = _items.remove(vParameterSetTypeItem);
        return removed;
    }

    /**
     * Method removeParameterSetTypeItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.hbird.xtce.castor.ParameterSetTypeItem removeParameterSetTypeItemAt(
            final int index) {
        java.lang.Object obj = this._items.remove(index);
        return (org.hbird.xtce.castor.ParameterSetTypeItem) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vParameterSetTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setParameterSetTypeItem(
            final int index,
            final org.hbird.xtce.castor.ParameterSetTypeItem vParameterSetTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("setParameterSetTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        this._items.set(index, vParameterSetTypeItem);
    }

    /**
     * 
     * 
     * @param vParameterSetTypeItemArray
     */
    public void setParameterSetTypeItem(
            final org.hbird.xtce.castor.ParameterSetTypeItem[] vParameterSetTypeItemArray) {
        //-- copy array
        _items.clear();

        for (int i = 0; i < vParameterSetTypeItemArray.length; i++) {
                this._items.add(vParameterSetTypeItemArray[i]);
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
     * org.hbird.xtce.castor.ParameterSetType
     */
    public static org.hbird.xtce.castor.ParameterSetType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.ParameterSetType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.ParameterSetType.class, reader);
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
