/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * Class MessageRefSet.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class MessageRefSet implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _messageRefList.
     */
    private java.util.List<java.lang.Object> _messageRefList;


      //----------------/
     //- Constructors -/
    //----------------/

    public MessageRefSet() {
        super();
        this._messageRefList = new java.util.ArrayList<java.lang.Object>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vMessageRef
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addMessageRef(
            final java.lang.Object vMessageRef)
    throws java.lang.IndexOutOfBoundsException {
        this._messageRefList.add(vMessageRef);
    }

    /**
     * 
     * 
     * @param index
     * @param vMessageRef
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addMessageRef(
            final int index,
            final java.lang.Object vMessageRef)
    throws java.lang.IndexOutOfBoundsException {
        this._messageRefList.add(index, vMessageRef);
    }

    /**
     * Method enumerateMessageRef.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends java.lang.Object> enumerateMessageRef(
    ) {
        return java.util.Collections.enumeration(this._messageRefList);
    }

    /**
     * Method getMessageRef.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.Object at the given index
     */
    public java.lang.Object getMessageRef(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._messageRefList.size()) {
            throw new IndexOutOfBoundsException("getMessageRef: Index value '" + index + "' not in range [0.." + (this._messageRefList.size() - 1) + "]");
        }

        return (java.lang.Object) _messageRefList.get(index);
    }

    /**
     * Method getMessageRef.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public java.lang.Object[] getMessageRef(
    ) {
        java.lang.Object[] array = new java.lang.Object[0];
        return (java.lang.Object[]) this._messageRefList.toArray(array);
    }

    /**
     * Method getMessageRefCount.
     * 
     * @return the size of this collection
     */
    public int getMessageRefCount(
    ) {
        return this._messageRefList.size();
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
     * Method iterateMessageRef.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends java.lang.Object> iterateMessageRef(
    ) {
        return this._messageRefList.iterator();
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
    public void removeAllMessageRef(
    ) {
        this._messageRefList.clear();
    }

    /**
     * Method removeMessageRef.
     * 
     * @param vMessageRef
     * @return true if the object was removed from the collection.
     */
    public boolean removeMessageRef(
            final java.lang.Object vMessageRef) {
        boolean removed = _messageRefList.remove(vMessageRef);
        return removed;
    }

    /**
     * Method removeMessageRefAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.Object removeMessageRefAt(
            final int index) {
        java.lang.Object obj = this._messageRefList.remove(index);
        return (java.lang.Object) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vMessageRef
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setMessageRef(
            final int index,
            final java.lang.Object vMessageRef)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._messageRefList.size()) {
            throw new IndexOutOfBoundsException("setMessageRef: Index value '" + index + "' not in range [0.." + (this._messageRefList.size() - 1) + "]");
        }

        this._messageRefList.set(index, vMessageRef);
    }

    /**
     * 
     * 
     * @param vMessageRefArray
     */
    public void setMessageRef(
            final java.lang.Object[] vMessageRefArray) {
        //-- copy array
        _messageRefList.clear();

        for (int i = 0; i < vMessageRefArray.length; i++) {
                this._messageRefList.add(vMessageRefArray[i]);
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
     * org.hbird.xtce.castor.MessageRefSet
     */
    public static org.hbird.xtce.castor.MessageRefSet unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.MessageRefSet) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.MessageRefSet.class, reader);
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
