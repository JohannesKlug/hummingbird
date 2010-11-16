/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * Parameters that are set with a new value after the command has
 * been sent. Appended to the Base Command list
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ParameterToSetList implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Sets a Parameter to a new value after the command has been
     * verified (all verifications have passed)
     */
    private java.util.List<org.hbird.transport.xtce.castor.ParameterToSet> _parameterToSetList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ParameterToSetList() {
        super();
        this._parameterToSetList = new java.util.ArrayList<org.hbird.transport.xtce.castor.ParameterToSet>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vParameterToSet
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addParameterToSet(
            final org.hbird.transport.xtce.castor.ParameterToSet vParameterToSet)
    throws java.lang.IndexOutOfBoundsException {
        this._parameterToSetList.add(vParameterToSet);
    }

    /**
     * 
     * 
     * @param index
     * @param vParameterToSet
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addParameterToSet(
            final int index,
            final org.hbird.transport.xtce.castor.ParameterToSet vParameterToSet)
    throws java.lang.IndexOutOfBoundsException {
        this._parameterToSetList.add(index, vParameterToSet);
    }

    /**
     * Method enumerateParameterToSet.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends org.hbird.transport.xtce.castor.ParameterToSet> enumerateParameterToSet(
    ) {
        return java.util.Collections.enumeration(this._parameterToSetList);
    }

    /**
     * Method getParameterToSet.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.hbird.xtce.castor.ParameterToSet at the
     * given index
     */
    public org.hbird.transport.xtce.castor.ParameterToSet getParameterToSet(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._parameterToSetList.size()) {
            throw new IndexOutOfBoundsException("getParameterToSet: Index value '" + index + "' not in range [0.." + (this._parameterToSetList.size() - 1) + "]");
        }

        return (org.hbird.transport.xtce.castor.ParameterToSet) _parameterToSetList.get(index);
    }

    /**
     * Method getParameterToSet.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.hbird.transport.xtce.castor.ParameterToSet[] getParameterToSet(
    ) {
        org.hbird.transport.xtce.castor.ParameterToSet[] array = new org.hbird.transport.xtce.castor.ParameterToSet[0];
        return (org.hbird.transport.xtce.castor.ParameterToSet[]) this._parameterToSetList.toArray(array);
    }

    /**
     * Method getParameterToSetCount.
     * 
     * @return the size of this collection
     */
    public int getParameterToSetCount(
    ) {
        return this._parameterToSetList.size();
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
     * Method iterateParameterToSet.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends org.hbird.transport.xtce.castor.ParameterToSet> iterateParameterToSet(
    ) {
        return this._parameterToSetList.iterator();
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
    public void removeAllParameterToSet(
    ) {
        this._parameterToSetList.clear();
    }

    /**
     * Method removeParameterToSet.
     * 
     * @param vParameterToSet
     * @return true if the object was removed from the collection.
     */
    public boolean removeParameterToSet(
            final org.hbird.transport.xtce.castor.ParameterToSet vParameterToSet) {
        boolean removed = _parameterToSetList.remove(vParameterToSet);
        return removed;
    }

    /**
     * Method removeParameterToSetAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.hbird.transport.xtce.castor.ParameterToSet removeParameterToSetAt(
            final int index) {
        java.lang.Object obj = this._parameterToSetList.remove(index);
        return (org.hbird.transport.xtce.castor.ParameterToSet) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vParameterToSet
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setParameterToSet(
            final int index,
            final org.hbird.transport.xtce.castor.ParameterToSet vParameterToSet)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._parameterToSetList.size()) {
            throw new IndexOutOfBoundsException("setParameterToSet: Index value '" + index + "' not in range [0.." + (this._parameterToSetList.size() - 1) + "]");
        }

        this._parameterToSetList.set(index, vParameterToSet);
    }

    /**
     * 
     * 
     * @param vParameterToSetArray
     */
    public void setParameterToSet(
            final org.hbird.transport.xtce.castor.ParameterToSet[] vParameterToSetArray) {
        //-- copy array
        _parameterToSetList.clear();

        for (int i = 0; i < vParameterToSetArray.length; i++) {
                this._parameterToSetList.add(vParameterToSetArray[i]);
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
     * org.hbird.xtce.castor.ParameterToSetList
     */
    public static org.hbird.transport.xtce.castor.ParameterToSetList unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.ParameterToSetList) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.ParameterToSetList.class, reader);
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
