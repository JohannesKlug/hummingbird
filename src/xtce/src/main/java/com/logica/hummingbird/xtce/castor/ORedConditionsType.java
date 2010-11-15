/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * A list of boolean comparisons, or boolean groups that are
 * logically ORed together. Any ANDed conditions in the list are
 * evaluated first.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ORedConditionsType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _items.
     */
    private java.util.List<com.logica.hummingbird.xtce.castor.ORedConditionsTypeItem> _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public ORedConditionsType() {
        super();
        this._items = new java.util.ArrayList<com.logica.hummingbird.xtce.castor.ORedConditionsTypeItem>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vORedConditionsTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addORedConditionsTypeItem(
            final com.logica.hummingbird.xtce.castor.ORedConditionsTypeItem vORedConditionsTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(vORedConditionsTypeItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vORedConditionsTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addORedConditionsTypeItem(
            final int index,
            final com.logica.hummingbird.xtce.castor.ORedConditionsTypeItem vORedConditionsTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(index, vORedConditionsTypeItem);
    }

    /**
     * Method enumerateORedConditionsTypeItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends com.logica.hummingbird.xtce.castor.ORedConditionsTypeItem> enumerateORedConditionsTypeItem(
    ) {
        return java.util.Collections.enumeration(this._items);
    }

    /**
     * Method getORedConditionsTypeItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.logica.hummingbird.xtce.castor.ORedConditionsTypeItem at
     * the given index
     */
    public com.logica.hummingbird.xtce.castor.ORedConditionsTypeItem getORedConditionsTypeItem(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("getORedConditionsTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        return (com.logica.hummingbird.xtce.castor.ORedConditionsTypeItem) _items.get(index);
    }

    /**
     * Method getORedConditionsTypeItem.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.logica.hummingbird.xtce.castor.ORedConditionsTypeItem[] getORedConditionsTypeItem(
    ) {
        com.logica.hummingbird.xtce.castor.ORedConditionsTypeItem[] array = new com.logica.hummingbird.xtce.castor.ORedConditionsTypeItem[0];
        return (com.logica.hummingbird.xtce.castor.ORedConditionsTypeItem[]) this._items.toArray(array);
    }

    /**
     * Method getORedConditionsTypeItemCount.
     * 
     * @return the size of this collection
     */
    public int getORedConditionsTypeItemCount(
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
     * Method iterateORedConditionsTypeItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends com.logica.hummingbird.xtce.castor.ORedConditionsTypeItem> iterateORedConditionsTypeItem(
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
    public void removeAllORedConditionsTypeItem(
    ) {
        this._items.clear();
    }

    /**
     * Method removeORedConditionsTypeItem.
     * 
     * @param vORedConditionsTypeItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeORedConditionsTypeItem(
            final com.logica.hummingbird.xtce.castor.ORedConditionsTypeItem vORedConditionsTypeItem) {
        boolean removed = _items.remove(vORedConditionsTypeItem);
        return removed;
    }

    /**
     * Method removeORedConditionsTypeItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.logica.hummingbird.xtce.castor.ORedConditionsTypeItem removeORedConditionsTypeItemAt(
            final int index) {
        java.lang.Object obj = this._items.remove(index);
        return (com.logica.hummingbird.xtce.castor.ORedConditionsTypeItem) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vORedConditionsTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setORedConditionsTypeItem(
            final int index,
            final com.logica.hummingbird.xtce.castor.ORedConditionsTypeItem vORedConditionsTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("setORedConditionsTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        this._items.set(index, vORedConditionsTypeItem);
    }

    /**
     * 
     * 
     * @param vORedConditionsTypeItemArray
     */
    public void setORedConditionsTypeItem(
            final com.logica.hummingbird.xtce.castor.ORedConditionsTypeItem[] vORedConditionsTypeItemArray) {
        //-- copy array
        _items.clear();

        for (int i = 0; i < vORedConditionsTypeItemArray.length; i++) {
                this._items.add(vORedConditionsTypeItemArray[i]);
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
     * com.logica.hummingbird.xtce.castor.ORedConditionsType
     */
    public static com.logica.hummingbird.xtce.castor.ORedConditionsType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.ORedConditionsType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.ORedConditionsType.class, reader);
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
