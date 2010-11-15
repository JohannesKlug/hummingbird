/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Used for custom user properties
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PropertyType extends com.logica.hummingbird.xtce.castor.NameDescriptionType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _value.
     */
    private java.lang.String _value;

    /**
     * Field _items.
     */
    private java.util.List<com.logica.hummingbird.xtce.castor.PropertyTypeItem> _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public PropertyType() {
        super();
        this._items = new java.util.ArrayList<com.logica.hummingbird.xtce.castor.PropertyTypeItem>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vPropertyTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPropertyTypeItem(
            final com.logica.hummingbird.xtce.castor.PropertyTypeItem vPropertyTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(vPropertyTypeItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vPropertyTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPropertyTypeItem(
            final int index,
            final com.logica.hummingbird.xtce.castor.PropertyTypeItem vPropertyTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(index, vPropertyTypeItem);
    }

    /**
     * Method enumeratePropertyTypeItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends com.logica.hummingbird.xtce.castor.PropertyTypeItem> enumeratePropertyTypeItem(
    ) {
        return java.util.Collections.enumeration(this._items);
    }

    /**
     * Method getPropertyTypeItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.logica.hummingbird.xtce.castor.PropertyTypeItem at the
     * given index
     */
    public com.logica.hummingbird.xtce.castor.PropertyTypeItem getPropertyTypeItem(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("getPropertyTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        return (com.logica.hummingbird.xtce.castor.PropertyTypeItem) _items.get(index);
    }

    /**
     * Method getPropertyTypeItem.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.logica.hummingbird.xtce.castor.PropertyTypeItem[] getPropertyTypeItem(
    ) {
        com.logica.hummingbird.xtce.castor.PropertyTypeItem[] array = new com.logica.hummingbird.xtce.castor.PropertyTypeItem[0];
        return (com.logica.hummingbird.xtce.castor.PropertyTypeItem[]) this._items.toArray(array);
    }

    /**
     * Method getPropertyTypeItemCount.
     * 
     * @return the size of this collection
     */
    public int getPropertyTypeItemCount(
    ) {
        return this._items.size();
    }

    /**
     * Returns the value of field 'value'.
     * 
     * @return the value of field 'Value'.
     */
    public java.lang.String getValue(
    ) {
        return this._value;
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
     * Method iteratePropertyTypeItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends com.logica.hummingbird.xtce.castor.PropertyTypeItem> iteratePropertyTypeItem(
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
    public void removeAllPropertyTypeItem(
    ) {
        this._items.clear();
    }

    /**
     * Method removePropertyTypeItem.
     * 
     * @param vPropertyTypeItem
     * @return true if the object was removed from the collection.
     */
    public boolean removePropertyTypeItem(
            final com.logica.hummingbird.xtce.castor.PropertyTypeItem vPropertyTypeItem) {
        boolean removed = _items.remove(vPropertyTypeItem);
        return removed;
    }

    /**
     * Method removePropertyTypeItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.logica.hummingbird.xtce.castor.PropertyTypeItem removePropertyTypeItemAt(
            final int index) {
        java.lang.Object obj = this._items.remove(index);
        return (com.logica.hummingbird.xtce.castor.PropertyTypeItem) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vPropertyTypeItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setPropertyTypeItem(
            final int index,
            final com.logica.hummingbird.xtce.castor.PropertyTypeItem vPropertyTypeItem)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("setPropertyTypeItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        this._items.set(index, vPropertyTypeItem);
    }

    /**
     * 
     * 
     * @param vPropertyTypeItemArray
     */
    public void setPropertyTypeItem(
            final com.logica.hummingbird.xtce.castor.PropertyTypeItem[] vPropertyTypeItemArray) {
        //-- copy array
        _items.clear();

        for (int i = 0; i < vPropertyTypeItemArray.length; i++) {
                this._items.add(vPropertyTypeItemArray[i]);
        }
    }

    /**
     * Sets the value of field 'value'.
     * 
     * @param value the value of field 'value'.
     */
    public void setValue(
            final java.lang.String value) {
        this._value = value;
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
     * com.logica.hummingbird.xtce.castor.PropertyType
     */
    public static com.logica.hummingbird.xtce.castor.PropertyType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.PropertyType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.PropertyType.class, reader);
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
