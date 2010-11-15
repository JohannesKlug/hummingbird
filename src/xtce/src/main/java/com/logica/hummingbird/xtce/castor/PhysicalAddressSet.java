/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * One or more physical addresses may be associated with each
 * Parameter. Examples of phyical addresses include a location on
 * the spacecraft or a location on a data collection bus. 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PhysicalAddressSet implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Contains the address (e.g., channel information) required to
     * process the spacecraft telemetry streams. May be an onboard
     * id, a mux address, or a physical location.
     */
    private java.util.List<com.logica.hummingbird.xtce.castor.PhysicalAddress> _physicalAddressList;


      //----------------/
     //- Constructors -/
    //----------------/

    public PhysicalAddressSet() {
        super();
        this._physicalAddressList = new java.util.ArrayList<com.logica.hummingbird.xtce.castor.PhysicalAddress>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vPhysicalAddress
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPhysicalAddress(
            final com.logica.hummingbird.xtce.castor.PhysicalAddress vPhysicalAddress)
    throws java.lang.IndexOutOfBoundsException {
        this._physicalAddressList.add(vPhysicalAddress);
    }

    /**
     * 
     * 
     * @param index
     * @param vPhysicalAddress
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addPhysicalAddress(
            final int index,
            final com.logica.hummingbird.xtce.castor.PhysicalAddress vPhysicalAddress)
    throws java.lang.IndexOutOfBoundsException {
        this._physicalAddressList.add(index, vPhysicalAddress);
    }

    /**
     * Method enumeratePhysicalAddress.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends com.logica.hummingbird.xtce.castor.PhysicalAddress> enumeratePhysicalAddress(
    ) {
        return java.util.Collections.enumeration(this._physicalAddressList);
    }

    /**
     * Method getPhysicalAddress.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.logica.hummingbird.xtce.castor.PhysicalAddress at the
     * given index
     */
    public com.logica.hummingbird.xtce.castor.PhysicalAddress getPhysicalAddress(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._physicalAddressList.size()) {
            throw new IndexOutOfBoundsException("getPhysicalAddress: Index value '" + index + "' not in range [0.." + (this._physicalAddressList.size() - 1) + "]");
        }

        return (com.logica.hummingbird.xtce.castor.PhysicalAddress) _physicalAddressList.get(index);
    }

    /**
     * Method getPhysicalAddress.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.logica.hummingbird.xtce.castor.PhysicalAddress[] getPhysicalAddress(
    ) {
        com.logica.hummingbird.xtce.castor.PhysicalAddress[] array = new com.logica.hummingbird.xtce.castor.PhysicalAddress[0];
        return (com.logica.hummingbird.xtce.castor.PhysicalAddress[]) this._physicalAddressList.toArray(array);
    }

    /**
     * Method getPhysicalAddressCount.
     * 
     * @return the size of this collection
     */
    public int getPhysicalAddressCount(
    ) {
        return this._physicalAddressList.size();
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
     * Method iteratePhysicalAddress.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends com.logica.hummingbird.xtce.castor.PhysicalAddress> iteratePhysicalAddress(
    ) {
        return this._physicalAddressList.iterator();
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
    public void removeAllPhysicalAddress(
    ) {
        this._physicalAddressList.clear();
    }

    /**
     * Method removePhysicalAddress.
     * 
     * @param vPhysicalAddress
     * @return true if the object was removed from the collection.
     */
    public boolean removePhysicalAddress(
            final com.logica.hummingbird.xtce.castor.PhysicalAddress vPhysicalAddress) {
        boolean removed = _physicalAddressList.remove(vPhysicalAddress);
        return removed;
    }

    /**
     * Method removePhysicalAddressAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.logica.hummingbird.xtce.castor.PhysicalAddress removePhysicalAddressAt(
            final int index) {
        java.lang.Object obj = this._physicalAddressList.remove(index);
        return (com.logica.hummingbird.xtce.castor.PhysicalAddress) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vPhysicalAddress
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setPhysicalAddress(
            final int index,
            final com.logica.hummingbird.xtce.castor.PhysicalAddress vPhysicalAddress)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._physicalAddressList.size()) {
            throw new IndexOutOfBoundsException("setPhysicalAddress: Index value '" + index + "' not in range [0.." + (this._physicalAddressList.size() - 1) + "]");
        }

        this._physicalAddressList.set(index, vPhysicalAddress);
    }

    /**
     * 
     * 
     * @param vPhysicalAddressArray
     */
    public void setPhysicalAddress(
            final com.logica.hummingbird.xtce.castor.PhysicalAddress[] vPhysicalAddressArray) {
        //-- copy array
        _physicalAddressList.clear();

        for (int i = 0; i < vPhysicalAddressArray.length; i++) {
                this._physicalAddressList.add(vPhysicalAddressArray[i]);
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
     * com.logica.hummingbird.xtce.castor.PhysicalAddressSet
     */
    public static com.logica.hummingbird.xtce.castor.PhysicalAddressSet unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.PhysicalAddressSet) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.PhysicalAddressSet.class, reader);
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
