/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Class ContextCalibratorList.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class NumericDataTypeContextCalibratorList implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _contextCalibratorList.
     */
    private java.util.List<com.logica.hummingbird.xtce.castor.ContextCalibrator> _contextCalibratorList;


      //----------------/
     //- Constructors -/
    //----------------/

    public NumericDataTypeContextCalibratorList() {
        super();
        this._contextCalibratorList = new java.util.ArrayList<com.logica.hummingbird.xtce.castor.ContextCalibrator>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vContextCalibrator
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addContextCalibrator(
            final com.logica.hummingbird.xtce.castor.ContextCalibrator vContextCalibrator)
    throws java.lang.IndexOutOfBoundsException {
        this._contextCalibratorList.add(vContextCalibrator);
    }

    /**
     * 
     * 
     * @param index
     * @param vContextCalibrator
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addContextCalibrator(
            final int index,
            final com.logica.hummingbird.xtce.castor.ContextCalibrator vContextCalibrator)
    throws java.lang.IndexOutOfBoundsException {
        this._contextCalibratorList.add(index, vContextCalibrator);
    }

    /**
     * Method enumerateContextCalibrator.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends com.logica.hummingbird.xtce.castor.ContextCalibrator> enumerateContextCalibrator(
    ) {
        return java.util.Collections.enumeration(this._contextCalibratorList);
    }

    /**
     * Method getContextCalibrator.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.logica.hummingbird.xtce.castor.ContextCalibrator at the
     * given index
     */
    public com.logica.hummingbird.xtce.castor.ContextCalibrator getContextCalibrator(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._contextCalibratorList.size()) {
            throw new IndexOutOfBoundsException("getContextCalibrator: Index value '" + index + "' not in range [0.." + (this._contextCalibratorList.size() - 1) + "]");
        }

        return (com.logica.hummingbird.xtce.castor.ContextCalibrator) _contextCalibratorList.get(index);
    }

    /**
     * Method getContextCalibrator.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.logica.hummingbird.xtce.castor.ContextCalibrator[] getContextCalibrator(
    ) {
        com.logica.hummingbird.xtce.castor.ContextCalibrator[] array = new com.logica.hummingbird.xtce.castor.ContextCalibrator[0];
        return (com.logica.hummingbird.xtce.castor.ContextCalibrator[]) this._contextCalibratorList.toArray(array);
    }

    /**
     * Method getContextCalibratorCount.
     * 
     * @return the size of this collection
     */
    public int getContextCalibratorCount(
    ) {
        return this._contextCalibratorList.size();
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
     * Method iterateContextCalibrator.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends com.logica.hummingbird.xtce.castor.ContextCalibrator> iterateContextCalibrator(
    ) {
        return this._contextCalibratorList.iterator();
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
    public void removeAllContextCalibrator(
    ) {
        this._contextCalibratorList.clear();
    }

    /**
     * Method removeContextCalibrator.
     * 
     * @param vContextCalibrator
     * @return true if the object was removed from the collection.
     */
    public boolean removeContextCalibrator(
            final com.logica.hummingbird.xtce.castor.ContextCalibrator vContextCalibrator) {
        boolean removed = _contextCalibratorList.remove(vContextCalibrator);
        return removed;
    }

    /**
     * Method removeContextCalibratorAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.logica.hummingbird.xtce.castor.ContextCalibrator removeContextCalibratorAt(
            final int index) {
        java.lang.Object obj = this._contextCalibratorList.remove(index);
        return (com.logica.hummingbird.xtce.castor.ContextCalibrator) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vContextCalibrator
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setContextCalibrator(
            final int index,
            final com.logica.hummingbird.xtce.castor.ContextCalibrator vContextCalibrator)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._contextCalibratorList.size()) {
            throw new IndexOutOfBoundsException("setContextCalibrator: Index value '" + index + "' not in range [0.." + (this._contextCalibratorList.size() - 1) + "]");
        }

        this._contextCalibratorList.set(index, vContextCalibrator);
    }

    /**
     * 
     * 
     * @param vContextCalibratorArray
     */
    public void setContextCalibrator(
            final com.logica.hummingbird.xtce.castor.ContextCalibrator[] vContextCalibratorArray) {
        //-- copy array
        _contextCalibratorList.clear();

        for (int i = 0; i < vContextCalibratorArray.length; i++) {
                this._contextCalibratorList.add(vContextCalibratorArray[i]);
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
     * com.logica.hummingbird.xtce.castor.NumericDataTypeContextCalibratorList
     */
    public static com.logica.hummingbird.xtce.castor.NumericDataTypeContextCalibratorList unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.NumericDataTypeContextCalibratorList) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.NumericDataTypeContextCalibratorList.class, reader);
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
