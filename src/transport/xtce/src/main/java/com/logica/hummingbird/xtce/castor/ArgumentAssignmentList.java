/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Class ArgumentAssignmentList.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ArgumentAssignmentList implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _argumentAssignmentList.
     */
    private java.util.List<com.logica.hummingbird.xtce.castor.ArgumentAssignment> _argumentAssignmentList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ArgumentAssignmentList() {
        super();
        this._argumentAssignmentList = new java.util.ArrayList<com.logica.hummingbird.xtce.castor.ArgumentAssignment>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vArgumentAssignment
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addArgumentAssignment(
            final com.logica.hummingbird.xtce.castor.ArgumentAssignment vArgumentAssignment)
    throws java.lang.IndexOutOfBoundsException {
        this._argumentAssignmentList.add(vArgumentAssignment);
    }

    /**
     * 
     * 
     * @param index
     * @param vArgumentAssignment
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addArgumentAssignment(
            final int index,
            final com.logica.hummingbird.xtce.castor.ArgumentAssignment vArgumentAssignment)
    throws java.lang.IndexOutOfBoundsException {
        this._argumentAssignmentList.add(index, vArgumentAssignment);
    }

    /**
     * Method enumerateArgumentAssignment.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends com.logica.hummingbird.xtce.castor.ArgumentAssignment> enumerateArgumentAssignment(
    ) {
        return java.util.Collections.enumeration(this._argumentAssignmentList);
    }

    /**
     * Method getArgumentAssignment.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.logica.hummingbird.xtce.castor.ArgumentAssignment at the
     * given index
     */
    public com.logica.hummingbird.xtce.castor.ArgumentAssignment getArgumentAssignment(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._argumentAssignmentList.size()) {
            throw new IndexOutOfBoundsException("getArgumentAssignment: Index value '" + index + "' not in range [0.." + (this._argumentAssignmentList.size() - 1) + "]");
        }

        return (com.logica.hummingbird.xtce.castor.ArgumentAssignment) _argumentAssignmentList.get(index);
    }

    /**
     * Method getArgumentAssignment.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.logica.hummingbird.xtce.castor.ArgumentAssignment[] getArgumentAssignment(
    ) {
        com.logica.hummingbird.xtce.castor.ArgumentAssignment[] array = new com.logica.hummingbird.xtce.castor.ArgumentAssignment[0];
        return (com.logica.hummingbird.xtce.castor.ArgumentAssignment[]) this._argumentAssignmentList.toArray(array);
    }

    /**
     * Method getArgumentAssignmentCount.
     * 
     * @return the size of this collection
     */
    public int getArgumentAssignmentCount(
    ) {
        return this._argumentAssignmentList.size();
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
     * Method iterateArgumentAssignment.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends com.logica.hummingbird.xtce.castor.ArgumentAssignment> iterateArgumentAssignment(
    ) {
        return this._argumentAssignmentList.iterator();
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
    public void removeAllArgumentAssignment(
    ) {
        this._argumentAssignmentList.clear();
    }

    /**
     * Method removeArgumentAssignment.
     * 
     * @param vArgumentAssignment
     * @return true if the object was removed from the collection.
     */
    public boolean removeArgumentAssignment(
            final com.logica.hummingbird.xtce.castor.ArgumentAssignment vArgumentAssignment) {
        boolean removed = _argumentAssignmentList.remove(vArgumentAssignment);
        return removed;
    }

    /**
     * Method removeArgumentAssignmentAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.logica.hummingbird.xtce.castor.ArgumentAssignment removeArgumentAssignmentAt(
            final int index) {
        java.lang.Object obj = this._argumentAssignmentList.remove(index);
        return (com.logica.hummingbird.xtce.castor.ArgumentAssignment) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vArgumentAssignment
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setArgumentAssignment(
            final int index,
            final com.logica.hummingbird.xtce.castor.ArgumentAssignment vArgumentAssignment)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._argumentAssignmentList.size()) {
            throw new IndexOutOfBoundsException("setArgumentAssignment: Index value '" + index + "' not in range [0.." + (this._argumentAssignmentList.size() - 1) + "]");
        }

        this._argumentAssignmentList.set(index, vArgumentAssignment);
    }

    /**
     * 
     * 
     * @param vArgumentAssignmentArray
     */
    public void setArgumentAssignment(
            final com.logica.hummingbird.xtce.castor.ArgumentAssignment[] vArgumentAssignmentArray) {
        //-- copy array
        _argumentAssignmentList.clear();

        for (int i = 0; i < vArgumentAssignmentArray.length; i++) {
                this._argumentAssignmentList.add(vArgumentAssignmentArray[i]);
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
     * com.logica.hummingbird.xtce.castor.ArgumentAssignmentList
     */
    public static com.logica.hummingbird.xtce.castor.ArgumentAssignmentList unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.ArgumentAssignmentList) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.ArgumentAssignmentList.class, reader);
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
