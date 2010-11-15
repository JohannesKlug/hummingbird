/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * A list of boolean comparisons, or boolean groups that are
 * logically ANDed together. Any ORed conditions in the list are
 * evaluated first.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ANDedConditionsType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _items.
     */
    private java.util.List<com.logica.hummingbird.xtce.castor.ANDedConditionsTypeItem> _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public ANDedConditionsType() {
        super();
        this._items = new java.util.ArrayList<com.logica.hummingbird.xtce.castor.ANDedConditionsTypeItem>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vANDedConditionsTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addANDedConditionsTypeItem(
            final com.logica.hummingbird.xtce.castor.ANDedConditionsTypeItem vANDedConditionsTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(vANDedConditionsTypeItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vANDedConditionsTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addANDedConditionsTypeItem(
            final int index,
            final com.logica.hummingbird.xtce.castor.ANDedConditionsTypeItem vANDedConditionsTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(index, vANDedConditionsTypeItem);
    }

    /**
     * Method enumerateANDedConditionsTypeItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends com.logica.hummingbird.xtce.castor.ANDedConditionsTypeItem> enumerateANDedConditionsTypeItem(
    ) {
        return java.util.Collections.enumeration(this._items);
    }

    /**
     * Method getANDedConditionsTypeItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.logica.hummingbird.xtce.castor.ANDedConditionsTypeItem
     * at the given index
     */
    public com.logica.hummingbird.xtce.castor.ANDedConditionsTypeItem getANDedConditionsTypeItem(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("getANDedConditionsTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        return (com.logica.hummingbird.xtce.castor.ANDedConditionsTypeItem) _items.get(index);
    }

    /**
     * Method getANDedConditionsTypeItem.Returns the contents of
     * the collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.logica.hummingbird.xtce.castor.ANDedConditionsTypeItem[] getANDedConditionsTypeItem(
    ) {
        com.logica.hummingbird.xtce.castor.ANDedConditionsTypeItem[] array = new com.logica.hummingbird.xtce.castor.ANDedConditionsTypeItem[0];
        return (com.logica.hummingbird.xtce.castor.ANDedConditionsTypeItem[]) this._items.toArray(array);
    }

    /**
     * Method getANDedConditionsTypeItemCount.
     * 
     * @return the size of this collection
     */
    public int getANDedConditionsTypeItemCount(
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
     * Method iterateANDedConditionsTypeItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends com.logica.hummingbird.xtce.castor.ANDedConditionsTypeItem> iterateANDedConditionsTypeItem(
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
     * Method removeANDedConditionsTypeItem.
     * 
     * @param vANDedConditionsTypeItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeANDedConditionsTypeItem(
            final com.logica.hummingbird.xtce.castor.ANDedConditionsTypeItem vANDedConditionsTypeItem) {
        boolean removed = _items.remove(vANDedConditionsTypeItem);
        return removed;
    }

    /**
     * Method removeANDedConditionsTypeItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.logica.hummingbird.xtce.castor.ANDedConditionsTypeItem removeANDedConditionsTypeItemAt(
            final int index) {
        java.lang.Object obj = this._items.remove(index);
        return (com.logica.hummingbird.xtce.castor.ANDedConditionsTypeItem) obj;
    }

    /**
     */
    public void removeAllANDedConditionsTypeItem(
    ) {
        this._items.clear();
    }

    /**
     * 
     * 
     * @param index
     * @param vANDedConditionsTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setANDedConditionsTypeItem(
            final int index,
            final com.logica.hummingbird.xtce.castor.ANDedConditionsTypeItem vANDedConditionsTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("setANDedConditionsTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        this._items.set(index, vANDedConditionsTypeItem);
    }

    /**
     * 
     * 
     * @param vANDedConditionsTypeItemArray
     */
    public void setANDedConditionsTypeItem(
            final com.logica.hummingbird.xtce.castor.ANDedConditionsTypeItem[] vANDedConditionsTypeItemArray) {
        //-- copy array
        _items.clear();

        for (int i = 0; i < vANDedConditionsTypeItemArray.length; i++) {
                this._items.add(vANDedConditionsTypeItemArray[i]);
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
     * com.logica.hummingbird.xtce.castor.ANDedConditionsType
     */
    public static com.logica.hummingbird.xtce.castor.ANDedConditionsType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.ANDedConditionsType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.ANDedConditionsType.class, reader);
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
