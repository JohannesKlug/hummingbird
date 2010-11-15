/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * Many commands have one or more options. These are called command
 * arguments. Command arguments may be of any of the standard data
 * types. MetaCommand arguments are local to the MetaCommand.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ArgumentList implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _items.
     */
    private java.util.List<org.hbird.xtce.castor.ArgumentListItem> _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public ArgumentList() {
        super();
        this._items = new java.util.ArrayList<org.hbird.xtce.castor.ArgumentListItem>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vArgumentListItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addArgumentListItem(
            final org.hbird.xtce.castor.ArgumentListItem vArgumentListItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(vArgumentListItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vArgumentListItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addArgumentListItem(
            final int index,
            final org.hbird.xtce.castor.ArgumentListItem vArgumentListItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(index, vArgumentListItem);
    }

    /**
     * Method enumerateArgumentListItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends org.hbird.xtce.castor.ArgumentListItem> enumerateArgumentListItem(
    ) {
        return java.util.Collections.enumeration(this._items);
    }

    /**
     * Method getArgumentListItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.hbird.xtce.castor.ArgumentListItem at the
     * given index
     */
    public org.hbird.xtce.castor.ArgumentListItem getArgumentListItem(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("getArgumentListItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        return (org.hbird.xtce.castor.ArgumentListItem) _items.get(index);
    }

    /**
     * Method getArgumentListItem.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.hbird.xtce.castor.ArgumentListItem[] getArgumentListItem(
    ) {
        org.hbird.xtce.castor.ArgumentListItem[] array = new org.hbird.xtce.castor.ArgumentListItem[0];
        return (org.hbird.xtce.castor.ArgumentListItem[]) this._items.toArray(array);
    }

    /**
     * Method getArgumentListItemCount.
     * 
     * @return the size of this collection
     */
    public int getArgumentListItemCount(
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
     * Method iterateArgumentListItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends org.hbird.xtce.castor.ArgumentListItem> iterateArgumentListItem(
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
    public void removeAllArgumentListItem(
    ) {
        this._items.clear();
    }

    /**
     * Method removeArgumentListItem.
     * 
     * @param vArgumentListItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeArgumentListItem(
            final org.hbird.xtce.castor.ArgumentListItem vArgumentListItem) {
        boolean removed = _items.remove(vArgumentListItem);
        return removed;
    }

    /**
     * Method removeArgumentListItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.hbird.xtce.castor.ArgumentListItem removeArgumentListItemAt(
            final int index) {
        java.lang.Object obj = this._items.remove(index);
        return (org.hbird.xtce.castor.ArgumentListItem) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vArgumentListItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setArgumentListItem(
            final int index,
            final org.hbird.xtce.castor.ArgumentListItem vArgumentListItem)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("setArgumentListItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        this._items.set(index, vArgumentListItem);
    }

    /**
     * 
     * 
     * @param vArgumentListItemArray
     */
    public void setArgumentListItem(
            final org.hbird.xtce.castor.ArgumentListItem[] vArgumentListItemArray) {
        //-- copy array
        _items.clear();

        for (int i = 0; i < vArgumentListItemArray.length; i++) {
                this._items.add(vArgumentListItemArray[i]);
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
     * org.hbird.xtce.castor.ArgumentList
     */
    public static org.hbird.xtce.castor.ArgumentList unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.ArgumentList) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.ArgumentList.class, reader);
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
