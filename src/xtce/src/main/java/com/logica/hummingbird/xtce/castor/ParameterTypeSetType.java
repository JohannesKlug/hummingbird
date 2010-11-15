/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Holds the list of parameter definitions. A Parameter is a
 * description of something that can have a value; it is not the
 * value itself. 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ParameterTypeSetType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _items.
     */
    private java.util.List<com.logica.hummingbird.xtce.castor.ParameterTypeSetTypeItem> _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public ParameterTypeSetType() {
        super();
        this._items = new java.util.ArrayList<com.logica.hummingbird.xtce.castor.ParameterTypeSetTypeItem>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vParameterTypeSetTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addParameterTypeSetTypeItem(
            final com.logica.hummingbird.xtce.castor.ParameterTypeSetTypeItem vParameterTypeSetTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(vParameterTypeSetTypeItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vParameterTypeSetTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addParameterTypeSetTypeItem(
            final int index,
            final com.logica.hummingbird.xtce.castor.ParameterTypeSetTypeItem vParameterTypeSetTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(index, vParameterTypeSetTypeItem);
    }

    /**
     * Method enumerateParameterTypeSetTypeItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends com.logica.hummingbird.xtce.castor.ParameterTypeSetTypeItem> enumerateParameterTypeSetTypeItem(
    ) {
        return java.util.Collections.enumeration(this._items);
    }

    /**
     * Method getParameterTypeSetTypeItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.logica.hummingbird.xtce.castor.ParameterTypeSetTypeItem
     * at the given index
     */
    public com.logica.hummingbird.xtce.castor.ParameterTypeSetTypeItem getParameterTypeSetTypeItem(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("getParameterTypeSetTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        return (com.logica.hummingbird.xtce.castor.ParameterTypeSetTypeItem) _items.get(index);
    }

    /**
     * Method getParameterTypeSetTypeItem.Returns the contents of
     * the collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.logica.hummingbird.xtce.castor.ParameterTypeSetTypeItem[] getParameterTypeSetTypeItem(
    ) {
        com.logica.hummingbird.xtce.castor.ParameterTypeSetTypeItem[] array = new com.logica.hummingbird.xtce.castor.ParameterTypeSetTypeItem[0];
        return (com.logica.hummingbird.xtce.castor.ParameterTypeSetTypeItem[]) this._items.toArray(array);
    }

    /**
     * Method getParameterTypeSetTypeItemCount.
     * 
     * @return the size of this collection
     */
    public int getParameterTypeSetTypeItemCount(
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
     * Method iterateParameterTypeSetTypeItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends com.logica.hummingbird.xtce.castor.ParameterTypeSetTypeItem> iterateParameterTypeSetTypeItem(
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
    public void removeAllParameterTypeSetTypeItem(
    ) {
        this._items.clear();
    }

    /**
     * Method removeParameterTypeSetTypeItem.
     * 
     * @param vParameterTypeSetTypeItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeParameterTypeSetTypeItem(
            final com.logica.hummingbird.xtce.castor.ParameterTypeSetTypeItem vParameterTypeSetTypeItem) {
        boolean removed = _items.remove(vParameterTypeSetTypeItem);
        return removed;
    }

    /**
     * Method removeParameterTypeSetTypeItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.logica.hummingbird.xtce.castor.ParameterTypeSetTypeItem removeParameterTypeSetTypeItemAt(
            final int index) {
        java.lang.Object obj = this._items.remove(index);
        return (com.logica.hummingbird.xtce.castor.ParameterTypeSetTypeItem) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vParameterTypeSetTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setParameterTypeSetTypeItem(
            final int index,
            final com.logica.hummingbird.xtce.castor.ParameterTypeSetTypeItem vParameterTypeSetTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("setParameterTypeSetTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        this._items.set(index, vParameterTypeSetTypeItem);
    }

    /**
     * 
     * 
     * @param vParameterTypeSetTypeItemArray
     */
    public void setParameterTypeSetTypeItem(
            final com.logica.hummingbird.xtce.castor.ParameterTypeSetTypeItem[] vParameterTypeSetTypeItemArray) {
        //-- copy array
        _items.clear();

        for (int i = 0; i < vParameterTypeSetTypeItemArray.length; i++) {
                this._items.add(vParameterTypeSetTypeItemArray[i]);
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
     * com.logica.hummingbird.xtce.castor.ParameterTypeSetType
     */
    public static com.logica.hummingbird.xtce.castor.ParameterTypeSetType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.ParameterTypeSetType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.ParameterTypeSetType.class, reader);
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
