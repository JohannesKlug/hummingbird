/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * Class NumberToStringTypeChoice.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class NumberToStringTypeChoice implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _items.
     */
    private java.util.List<org.hbird.transport.xtce.castor.NumberToStringTypeChoiceItem> _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public NumberToStringTypeChoice() {
        super();
        this._items = new java.util.ArrayList<org.hbird.transport.xtce.castor.NumberToStringTypeChoiceItem>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vNumberToStringTypeChoiceItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addNumberToStringTypeChoiceItem(
            final org.hbird.transport.xtce.castor.NumberToStringTypeChoiceItem vNumberToStringTypeChoiceItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(vNumberToStringTypeChoiceItem);
    }

    /**
     * 
     * 
     * @param index
     * @param vNumberToStringTypeChoiceItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addNumberToStringTypeChoiceItem(
            final int index,
            final org.hbird.transport.xtce.castor.NumberToStringTypeChoiceItem vNumberToStringTypeChoiceItem)
    throws java.lang.IndexOutOfBoundsException {
        this._items.add(index, vNumberToStringTypeChoiceItem);
    }

    /**
     * Method enumerateNumberToStringTypeChoiceItem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends org.hbird.transport.xtce.castor.NumberToStringTypeChoiceItem> enumerateNumberToStringTypeChoiceItem(
    ) {
        return java.util.Collections.enumeration(this._items);
    }

    /**
     * Method getNumberToStringTypeChoiceItem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.hbird.xtce.castor.NumberToStringTypeChoiceItem
     * at the given index
     */
    public org.hbird.transport.xtce.castor.NumberToStringTypeChoiceItem getNumberToStringTypeChoiceItem(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("getNumberToStringTypeChoiceItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        return (org.hbird.transport.xtce.castor.NumberToStringTypeChoiceItem) _items.get(index);
    }

    /**
     * Method getNumberToStringTypeChoiceItem.Returns the contents
     * of the collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.hbird.transport.xtce.castor.NumberToStringTypeChoiceItem[] getNumberToStringTypeChoiceItem(
    ) {
        org.hbird.transport.xtce.castor.NumberToStringTypeChoiceItem[] array = new org.hbird.transport.xtce.castor.NumberToStringTypeChoiceItem[0];
        return (org.hbird.transport.xtce.castor.NumberToStringTypeChoiceItem[]) this._items.toArray(array);
    }

    /**
     * Method getNumberToStringTypeChoiceItemCount.
     * 
     * @return the size of this collection
     */
    public int getNumberToStringTypeChoiceItemCount(
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
     * Method iterateNumberToStringTypeChoiceItem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends org.hbird.transport.xtce.castor.NumberToStringTypeChoiceItem> iterateNumberToStringTypeChoiceItem(
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
    public void removeAllNumberToStringTypeChoiceItem(
    ) {
        this._items.clear();
    }

    /**
     * Method removeNumberToStringTypeChoiceItem.
     * 
     * @param vNumberToStringTypeChoiceItem
     * @return true if the object was removed from the collection.
     */
    public boolean removeNumberToStringTypeChoiceItem(
            final org.hbird.transport.xtce.castor.NumberToStringTypeChoiceItem vNumberToStringTypeChoiceItem) {
        boolean removed = _items.remove(vNumberToStringTypeChoiceItem);
        return removed;
    }

    /**
     * Method removeNumberToStringTypeChoiceItemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.hbird.transport.xtce.castor.NumberToStringTypeChoiceItem removeNumberToStringTypeChoiceItemAt(
            final int index) {
        java.lang.Object obj = this._items.remove(index);
        return (org.hbird.transport.xtce.castor.NumberToStringTypeChoiceItem) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vNumberToStringTypeChoiceItem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setNumberToStringTypeChoiceItem(
            final int index,
            final org.hbird.transport.xtce.castor.NumberToStringTypeChoiceItem vNumberToStringTypeChoiceItem)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._items.size()) {
            throw new IndexOutOfBoundsException("setNumberToStringTypeChoiceItem: Index value '" + index + "' not in range [0.." + (this._items.size() - 1) + "]");
        }

        this._items.set(index, vNumberToStringTypeChoiceItem);
    }

    /**
     * 
     * 
     * @param vNumberToStringTypeChoiceItemArray
     */
    public void setNumberToStringTypeChoiceItem(
            final org.hbird.transport.xtce.castor.NumberToStringTypeChoiceItem[] vNumberToStringTypeChoiceItemArray) {
        //-- copy array
        _items.clear();

        for (int i = 0; i < vNumberToStringTypeChoiceItemArray.length; i++) {
                this._items.add(vNumberToStringTypeChoiceItemArray[i]);
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
     * org.hbird.xtce.castor.NumberToStringTypeChoice
     */
    public static org.hbird.transport.xtce.castor.NumberToStringTypeChoice unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.NumberToStringTypeChoice) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.NumberToStringTypeChoice.class, reader);
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
