/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Class ArgumentTypeSet.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ArgumentTypeSet implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _items.
     */
    private java.util.List<com.logica.hummingbird.xtce.castor.ArgumentTypeSetItem> _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public ArgumentTypeSet() {
        super();
        this._items = new java.util.ArrayList<com.logica.hummingbird.xtce.castor.ArgumentTypeSetItem>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vArgumentTypeSetItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addArgumentTypeSetItem(
            final com.logica.hummingbird.xtce.castor.ArgumentTypeSetItem vArgumentTypeSetItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(vArgumentTypeSetItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vArgumentTypeSetItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addArgumentTypeSetItem(
            final int index,
            final com.logica.hummingbird.xtce.castor.ArgumentTypeSetItem vArgumentTypeSetItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(index, vArgumentTypeSetItem);
    }

    /**
     * Method enumerateArgumentTypeSetItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends com.logica.hummingbird.xtce.castor.ArgumentTypeSetItem> enumerateArgumentTypeSetItem(
    ) {
        return java.util.Collections.enumeration(this._items);
    }

    /**
     * Method getArgumentTypeSetItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.logica.hummingbird.xtce.castor.ArgumentTypeSetItem at
     * the given index
     */
    public com.logica.hummingbird.xtce.castor.ArgumentTypeSetItem getArgumentTypeSetItem(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("getArgumentTypeSetItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        return (com.logica.hummingbird.xtce.castor.ArgumentTypeSetItem) _items.get(index);
    }

    /**
     * Method getArgumentTypeSetItem.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.logica.hummingbird.xtce.castor.ArgumentTypeSetItem[] getArgumentTypeSetItem(
    ) {
        com.logica.hummingbird.xtce.castor.ArgumentTypeSetItem[] array = new com.logica.hummingbird.xtce.castor.ArgumentTypeSetItem[0];
        return (com.logica.hummingbird.xtce.castor.ArgumentTypeSetItem[]) this._items.toArray(array);
    }

    /**
     * Method getArgumentTypeSetItemCount.
     * 
     * @return the size of this collection
     */
    public int getArgumentTypeSetItemCount(
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
     * Method iterateArgumentTypeSetItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends com.logica.hummingbird.xtce.castor.ArgumentTypeSetItem> iterateArgumentTypeSetItem(
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
    public void removeAllArgumentTypeSetItem(
    ) {
        this._items.clear();
    }

    /**
     * Method removeArgumentTypeSetItem.
     * 
     * @param vArgumentTypeSetItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeArgumentTypeSetItem(
            final com.logica.hummingbird.xtce.castor.ArgumentTypeSetItem vArgumentTypeSetItem) {
        boolean removed = _items.remove(vArgumentTypeSetItem);
        return removed;
    }

    /**
     * Method removeArgumentTypeSetItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.logica.hummingbird.xtce.castor.ArgumentTypeSetItem removeArgumentTypeSetItemAt(
            final int index) {
        java.lang.Object obj = this._items.remove(index);
        return (com.logica.hummingbird.xtce.castor.ArgumentTypeSetItem) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vArgumentTypeSetItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setArgumentTypeSetItem(
            final int index,
            final com.logica.hummingbird.xtce.castor.ArgumentTypeSetItem vArgumentTypeSetItem)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("setArgumentTypeSetItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        this._items.set(index, vArgumentTypeSetItem);
    }

    /**
     * 
     * 
     * @param vArgumentTypeSetItemArray
     */
    public void setArgumentTypeSetItem(
            final com.logica.hummingbird.xtce.castor.ArgumentTypeSetItem[] vArgumentTypeSetItemArray) {
        //-- copy array
        _items.clear();

        for (int i = 0; i < vArgumentTypeSetItemArray.length; i++) {
                this._items.add(vArgumentTypeSetItemArray[i]);
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
     * com.logica.hummingbird.xtce.castor.ArgumentTypeSet
     */
    public static com.logica.hummingbird.xtce.castor.ArgumentTypeSet unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.ArgumentTypeSet) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.ArgumentTypeSet.class, reader);
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
