/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * Use when different calibrations must be used on the Parameter in
 * different contexts. Use the first one that tests true
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class FloatDataEncodingTypeContextCalibratorList implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _contextCalibratorList.
     */
    private java.util.List<org.hbird.xtce.castor.FloatDataEncodingTypeContextCalibratorListContextCalibrator> _contextCalibratorList;


      //----------------/
     //- Constructors -/
    //----------------/

    public FloatDataEncodingTypeContextCalibratorList() {
        super();
        this._contextCalibratorList = new java.util.ArrayList<org.hbird.xtce.castor.FloatDataEncodingTypeContextCalibratorListContextCalibrator>();
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
            final org.hbird.xtce.castor.FloatDataEncodingTypeContextCalibratorListContextCalibrator vContextCalibrator)
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
            final org.hbird.xtce.castor.FloatDataEncodingTypeContextCalibratorListContextCalibrator vContextCalibrator)
    throws java.lang.IndexOutOfBoundsException {
        this._contextCalibratorList.add(index, vContextCalibrator);
    }

    /**
     * Method enumerateContextCalibrator.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends org.hbird.xtce.castor.FloatDataEncodingTypeContextCalibratorListContextCalibrator> enumerateContextCalibrator(
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
     * org.hbird.xtce.castor.FloatDataEncodingTypeContextCalibratorListContextCalibrator
     * at the given index
     */
    public org.hbird.xtce.castor.FloatDataEncodingTypeContextCalibratorListContextCalibrator getContextCalibrator(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._contextCalibratorList.size()) {
            throw new IndexOutOfBoundsException("getContextCalibrator: Index value '" + index + "' not in range [0.." + (this._contextCalibratorList.size() - 1) + "]");
        }

        return (org.hbird.xtce.castor.FloatDataEncodingTypeContextCalibratorListContextCalibrator) _contextCalibratorList.get(index);
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
    public org.hbird.xtce.castor.FloatDataEncodingTypeContextCalibratorListContextCalibrator[] getContextCalibrator(
    ) {
        org.hbird.xtce.castor.FloatDataEncodingTypeContextCalibratorListContextCalibrator[] array = new org.hbird.xtce.castor.FloatDataEncodingTypeContextCalibratorListContextCalibrator[0];
        return (org.hbird.xtce.castor.FloatDataEncodingTypeContextCalibratorListContextCalibrator[]) this._contextCalibratorList.toArray(array);
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
    public java.util.Iterator<? extends org.hbird.xtce.castor.FloatDataEncodingTypeContextCalibratorListContextCalibrator> iterateContextCalibrator(
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
            final org.hbird.xtce.castor.FloatDataEncodingTypeContextCalibratorListContextCalibrator vContextCalibrator) {
        boolean removed = _contextCalibratorList.remove(vContextCalibrator);
        return removed;
    }

    /**
     * Method removeContextCalibratorAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.hbird.xtce.castor.FloatDataEncodingTypeContextCalibratorListContextCalibrator removeContextCalibratorAt(
            final int index) {
        java.lang.Object obj = this._contextCalibratorList.remove(index);
        return (org.hbird.xtce.castor.FloatDataEncodingTypeContextCalibratorListContextCalibrator) obj;
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
            final org.hbird.xtce.castor.FloatDataEncodingTypeContextCalibratorListContextCalibrator vContextCalibrator)
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
            final org.hbird.xtce.castor.FloatDataEncodingTypeContextCalibratorListContextCalibrator[] vContextCalibratorArray) {
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
     * org.hbird.xtce.castor.FloatDataEncodingTypeContextCalibratorList
     */
    public static org.hbird.xtce.castor.FloatDataEncodingTypeContextCalibratorList unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.FloatDataEncodingTypeContextCalibratorList) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.FloatDataEncodingTypeContextCalibratorList.class, reader);
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
