/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Class ContainerRefSet.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ContainerRefSet implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _containerRefList.
     */
    private java.util.List<com.logica.hummingbird.xtce.castor.ContainerRef> _containerRefList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ContainerRefSet() {
        super();
        this._containerRefList = new java.util.ArrayList<com.logica.hummingbird.xtce.castor.ContainerRef>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vContainerRef
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addContainerRef(
            final com.logica.hummingbird.xtce.castor.ContainerRef vContainerRef)
    throws java.lang.IndexOutOfBoundsException {
        this._containerRefList.add(vContainerRef);
    }

    /**
     * 
     * 
     * @param index
     * @param vContainerRef
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addContainerRef(
            final int index,
            final com.logica.hummingbird.xtce.castor.ContainerRef vContainerRef)
    throws java.lang.IndexOutOfBoundsException {
        this._containerRefList.add(index, vContainerRef);
    }

    /**
     * Method enumerateContainerRef.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends com.logica.hummingbird.xtce.castor.ContainerRef> enumerateContainerRef(
    ) {
        return java.util.Collections.enumeration(this._containerRefList);
    }

    /**
     * Method getContainerRef.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.logica.hummingbird.xtce.castor.ContainerRef at the given
     * index
     */
    public com.logica.hummingbird.xtce.castor.ContainerRef getContainerRef(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._containerRefList.size()) {
            throw new IndexOutOfBoundsException("getContainerRef: Index value '" + index + "' not in range [0.." + (this._containerRefList.size() - 1) + "]");
        }

        return (com.logica.hummingbird.xtce.castor.ContainerRef) _containerRefList.get(index);
    }

    /**
     * Method getContainerRef.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.logica.hummingbird.xtce.castor.ContainerRef[] getContainerRef(
    ) {
        com.logica.hummingbird.xtce.castor.ContainerRef[] array = new com.logica.hummingbird.xtce.castor.ContainerRef[0];
        return (com.logica.hummingbird.xtce.castor.ContainerRef[]) this._containerRefList.toArray(array);
    }

    /**
     * Method getContainerRefCount.
     * 
     * @return the size of this collection
     */
    public int getContainerRefCount(
    ) {
        return this._containerRefList.size();
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
     * Method iterateContainerRef.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends com.logica.hummingbird.xtce.castor.ContainerRef> iterateContainerRef(
    ) {
        return this._containerRefList.iterator();
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
    public void removeAllContainerRef(
    ) {
        this._containerRefList.clear();
    }

    /**
     * Method removeContainerRef.
     * 
     * @param vContainerRef
     * @return true if the object was removed from the collection.
     */
    public boolean removeContainerRef(
            final com.logica.hummingbird.xtce.castor.ContainerRef vContainerRef) {
        boolean removed = _containerRefList.remove(vContainerRef);
        return removed;
    }

    /**
     * Method removeContainerRefAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.logica.hummingbird.xtce.castor.ContainerRef removeContainerRefAt(
            final int index) {
        java.lang.Object obj = this._containerRefList.remove(index);
        return (com.logica.hummingbird.xtce.castor.ContainerRef) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vContainerRef
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setContainerRef(
            final int index,
            final com.logica.hummingbird.xtce.castor.ContainerRef vContainerRef)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._containerRefList.size()) {
            throw new IndexOutOfBoundsException("setContainerRef: Index value '" + index + "' not in range [0.." + (this._containerRefList.size() - 1) + "]");
        }

        this._containerRefList.set(index, vContainerRef);
    }

    /**
     * 
     * 
     * @param vContainerRefArray
     */
    public void setContainerRef(
            final com.logica.hummingbird.xtce.castor.ContainerRef[] vContainerRefArray) {
        //-- copy array
        _containerRefList.clear();

        for (int i = 0; i < vContainerRefArray.length; i++) {
                this._containerRefList.add(vContainerRefArray[i]);
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
     * com.logica.hummingbird.xtce.castor.ContainerRefSet
     */
    public static com.logica.hummingbird.xtce.castor.ContainerRefSet unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.ContainerRefSet) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.ContainerRefSet.class, reader);
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
