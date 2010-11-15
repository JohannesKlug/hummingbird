/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Class EnumerationList.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class EnumerationList implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _enumerationList.
     */
    private java.util.List<com.logica.hummingbird.xtce.castor.Enumeration> _enumerationList;


      //----------------/
     //- Constructors -/
    //----------------/

    public EnumerationList() {
        super();
        this._enumerationList = new java.util.ArrayList<com.logica.hummingbird.xtce.castor.Enumeration>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vEnumeration
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addEnumeration(
            final com.logica.hummingbird.xtce.castor.Enumeration vEnumeration)
    throws java.lang.IndexOutOfBoundsException {
        this._enumerationList.add(vEnumeration);
    }

    /**
     * 
     * 
     * @param index
     * @param vEnumeration
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addEnumeration(
            final int index,
            final com.logica.hummingbird.xtce.castor.Enumeration vEnumeration)
    throws java.lang.IndexOutOfBoundsException {
        this._enumerationList.add(index, vEnumeration);
    }

    /**
     * Method enumerateEnumeration.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends com.logica.hummingbird.xtce.castor.Enumeration> enumerateEnumeration(
    ) {
        return java.util.Collections.enumeration(this._enumerationList);
    }

    /**
     * Method getEnumeration.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.logica.hummingbird.xtce.castor.Enumeration at the given
     * index
     */
    public com.logica.hummingbird.xtce.castor.Enumeration getEnumeration(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._enumerationList.size()) {
            throw new IndexOutOfBoundsException("getEnumeration: Index value '" + index + "' not in range [0.." + (this._enumerationList.size() - 1) + "]");
        }

        return (com.logica.hummingbird.xtce.castor.Enumeration) _enumerationList.get(index);
    }

    /**
     * Method getEnumeration.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.logica.hummingbird.xtce.castor.Enumeration[] getEnumeration(
    ) {
        com.logica.hummingbird.xtce.castor.Enumeration[] array = new com.logica.hummingbird.xtce.castor.Enumeration[0];
        return (com.logica.hummingbird.xtce.castor.Enumeration[]) this._enumerationList.toArray(array);
    }

    /**
     * Method getEnumerationCount.
     * 
     * @return the size of this collection
     */
    public int getEnumerationCount(
    ) {
        return this._enumerationList.size();
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
     * Method iterateEnumeration.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends com.logica.hummingbird.xtce.castor.Enumeration> iterateEnumeration(
    ) {
        return this._enumerationList.iterator();
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
    public void removeAllEnumeration(
    ) {
        this._enumerationList.clear();
    }

    /**
     * Method removeEnumeration.
     * 
     * @param vEnumeration
     * @return true if the object was removed from the collection.
     */
    public boolean removeEnumeration(
            final com.logica.hummingbird.xtce.castor.Enumeration vEnumeration) {
        boolean removed = _enumerationList.remove(vEnumeration);
        return removed;
    }

    /**
     * Method removeEnumerationAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.logica.hummingbird.xtce.castor.Enumeration removeEnumerationAt(
            final int index) {
        java.lang.Object obj = this._enumerationList.remove(index);
        return (com.logica.hummingbird.xtce.castor.Enumeration) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vEnumeration
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setEnumeration(
            final int index,
            final com.logica.hummingbird.xtce.castor.Enumeration vEnumeration)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._enumerationList.size()) {
            throw new IndexOutOfBoundsException("setEnumeration: Index value '" + index + "' not in range [0.." + (this._enumerationList.size() - 1) + "]");
        }

        this._enumerationList.set(index, vEnumeration);
    }

    /**
     * 
     * 
     * @param vEnumerationArray
     */
    public void setEnumeration(
            final com.logica.hummingbird.xtce.castor.Enumeration[] vEnumerationArray) {
        //-- copy array
        _enumerationList.clear();

        for (int i = 0; i < vEnumerationArray.length; i++) {
                this._enumerationList.add(vEnumerationArray[i]);
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
     * com.logica.hummingbird.xtce.castor.EnumerationList
     */
    public static com.logica.hummingbird.xtce.castor.EnumerationList unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.EnumerationList) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.EnumerationList.class, reader);
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
