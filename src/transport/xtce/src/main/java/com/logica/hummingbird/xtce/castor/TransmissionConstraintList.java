/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * Appended to the TramsmissionConstraint List of the base command.
 * Constraints are checked in order. 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class TransmissionConstraintList implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * A CommandTransmission constraint is used to check that the
     * command can be run in the current operating mode and may
     * block the transmission of the command if the constraint
     * condition is true.
     */
    private java.util.List<org.hbird.xtce.castor.TransmissionConstraint> _transmissionConstraintList;


      //----------------/
     //- Constructors -/
    //----------------/

    public TransmissionConstraintList() {
        super();
        this._transmissionConstraintList = new java.util.ArrayList<org.hbird.xtce.castor.TransmissionConstraint>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vTransmissionConstraint
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addTransmissionConstraint(
            final org.hbird.xtce.castor.TransmissionConstraint vTransmissionConstraint)
    throws java.lang.IndexOutOfBoundsException {
        this._transmissionConstraintList.add(vTransmissionConstraint);
    }

    /**
     * 
     * 
     * @param index
     * @param vTransmissionConstraint
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addTransmissionConstraint(
            final int index,
            final org.hbird.xtce.castor.TransmissionConstraint vTransmissionConstraint)
    throws java.lang.IndexOutOfBoundsException {
        this._transmissionConstraintList.add(index, vTransmissionConstraint);
    }

    /**
     * Method enumerateTransmissionConstraint.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends org.hbird.xtce.castor.TransmissionConstraint> enumerateTransmissionConstraint(
    ) {
        return java.util.Collections.enumeration(this._transmissionConstraintList);
    }

    /**
     * Method getTransmissionConstraint.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.hbird.xtce.castor.TransmissionConstraint at
     * the given index
     */
    public org.hbird.xtce.castor.TransmissionConstraint getTransmissionConstraint(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._transmissionConstraintList.size()) {
            throw new IndexOutOfBoundsException("getTransmissionConstraint: Index value '" + index + "' not in range [0.." + (this._transmissionConstraintList.size() - 1) + "]");
        }

        return (org.hbird.xtce.castor.TransmissionConstraint) _transmissionConstraintList.get(index);
    }

    /**
     * Method getTransmissionConstraint.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.hbird.xtce.castor.TransmissionConstraint[] getTransmissionConstraint(
    ) {
        org.hbird.xtce.castor.TransmissionConstraint[] array = new org.hbird.xtce.castor.TransmissionConstraint[0];
        return (org.hbird.xtce.castor.TransmissionConstraint[]) this._transmissionConstraintList.toArray(array);
    }

    /**
     * Method getTransmissionConstraintCount.
     * 
     * @return the size of this collection
     */
    public int getTransmissionConstraintCount(
    ) {
        return this._transmissionConstraintList.size();
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
     * Method iterateTransmissionConstraint.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends org.hbird.xtce.castor.TransmissionConstraint> iterateTransmissionConstraint(
    ) {
        return this._transmissionConstraintList.iterator();
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
    public void removeAllTransmissionConstraint(
    ) {
        this._transmissionConstraintList.clear();
    }

    /**
     * Method removeTransmissionConstraint.
     * 
     * @param vTransmissionConstraint
     * @return true if the object was removed from the collection.
     */
    public boolean removeTransmissionConstraint(
            final org.hbird.xtce.castor.TransmissionConstraint vTransmissionConstraint) {
        boolean removed = _transmissionConstraintList.remove(vTransmissionConstraint);
        return removed;
    }

    /**
     * Method removeTransmissionConstraintAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.hbird.xtce.castor.TransmissionConstraint removeTransmissionConstraintAt(
            final int index) {
        java.lang.Object obj = this._transmissionConstraintList.remove(index);
        return (org.hbird.xtce.castor.TransmissionConstraint) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vTransmissionConstraint
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setTransmissionConstraint(
            final int index,
            final org.hbird.xtce.castor.TransmissionConstraint vTransmissionConstraint)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._transmissionConstraintList.size()) {
            throw new IndexOutOfBoundsException("setTransmissionConstraint: Index value '" + index + "' not in range [0.." + (this._transmissionConstraintList.size() - 1) + "]");
        }

        this._transmissionConstraintList.set(index, vTransmissionConstraint);
    }

    /**
     * 
     * 
     * @param vTransmissionConstraintArray
     */
    public void setTransmissionConstraint(
            final org.hbird.xtce.castor.TransmissionConstraint[] vTransmissionConstraintArray) {
        //-- copy array
        _transmissionConstraintList.clear();

        for (int i = 0; i < vTransmissionConstraintArray.length; i++) {
                this._transmissionConstraintList.add(vTransmissionConstraintArray[i]);
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
     * org.hbird.xtce.castor.TransmissionConstraintList
     */
    public static org.hbird.xtce.castor.TransmissionConstraintList unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.TransmissionConstraintList) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.TransmissionConstraintList.class, reader);
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
