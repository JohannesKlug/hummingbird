/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * A calibration type where a segmented line in a raw vs calibrated
 * plane is described using a set of points. Raw values are
 * converted to calibrated values by finding a position on the line
 * coorosponding to the raw value. The algorithm triggers on the
 * input parameter.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SplineCalibrator implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _order.
     */
    private long _order = 1;

    /**
     * keeps track of state for field: _order
     */
    private boolean _has_order;

    /**
     * Field _extrapolate.
     */
    private boolean _extrapolate = false;

    /**
     * keeps track of state for field: _extrapolate
     */
    private boolean _has_extrapolate;

    /**
     * Field _splinePointList.
     */
    private java.util.List<org.hbird.transport.xtce.castor.SplinePoint> _splinePointList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SplineCalibrator() {
        super();
        this._splinePointList = new java.util.ArrayList<org.hbird.transport.xtce.castor.SplinePoint>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSplinePoint
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSplinePoint(
            final org.hbird.transport.xtce.castor.SplinePoint vSplinePoint)
    throws java.lang.IndexOutOfBoundsException {
        this._splinePointList.add(vSplinePoint);
    }

    /**
     * 
     * 
     * @param index
     * @param vSplinePoint
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSplinePoint(
            final int index,
            final org.hbird.transport.xtce.castor.SplinePoint vSplinePoint)
    throws java.lang.IndexOutOfBoundsException {
        this._splinePointList.add(index, vSplinePoint);
    }

    /**
     */
    public void deleteExtrapolate(
    ) {
        this._has_extrapolate= false;
    }

    /**
     */
    public void deleteOrder(
    ) {
        this._has_order= false;
    }

    /**
     * Method enumerateSplinePoint.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends org.hbird.transport.xtce.castor.SplinePoint> enumerateSplinePoint(
    ) {
        return java.util.Collections.enumeration(this._splinePointList);
    }

    /**
     * Returns the value of field 'extrapolate'.
     * 
     * @return the value of field 'Extrapolate'.
     */
    public boolean getExtrapolate(
    ) {
        return this._extrapolate;
    }

    /**
     * Returns the value of field 'order'.
     * 
     * @return the value of field 'Order'.
     */
    public long getOrder(
    ) {
        return this._order;
    }

    /**
     * Method getSplinePoint.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.hbird.xtce.castor.SplinePoint at the given
     * index
     */
    public org.hbird.transport.xtce.castor.SplinePoint getSplinePoint(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._splinePointList.size()) {
            throw new IndexOutOfBoundsException("getSplinePoint: Index value '" + index + "' not in range [0.." + (this._splinePointList.size() - 1) + "]");
        }

        return (org.hbird.transport.xtce.castor.SplinePoint) _splinePointList.get(index);
    }

    /**
     * Method getSplinePoint.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.hbird.transport.xtce.castor.SplinePoint[] getSplinePoint(
    ) {
        org.hbird.transport.xtce.castor.SplinePoint[] array = new org.hbird.transport.xtce.castor.SplinePoint[0];
        return (org.hbird.transport.xtce.castor.SplinePoint[]) this._splinePointList.toArray(array);
    }

    /**
     * Method getSplinePointCount.
     * 
     * @return the size of this collection
     */
    public int getSplinePointCount(
    ) {
        return this._splinePointList.size();
    }

    /**
     * Method hasExtrapolate.
     * 
     * @return true if at least one Extrapolate has been added
     */
    public boolean hasExtrapolate(
    ) {
        return this._has_extrapolate;
    }

    /**
     * Method hasOrder.
     * 
     * @return true if at least one Order has been added
     */
    public boolean hasOrder(
    ) {
        return this._has_order;
    }

    /**
     * Returns the value of field 'extrapolate'.
     * 
     * @return the value of field 'Extrapolate'.
     */
    public boolean isExtrapolate(
    ) {
        return this._extrapolate;
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
     * Method iterateSplinePoint.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends org.hbird.transport.xtce.castor.SplinePoint> iterateSplinePoint(
    ) {
        return this._splinePointList.iterator();
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
    public void removeAllSplinePoint(
    ) {
        this._splinePointList.clear();
    }

    /**
     * Method removeSplinePoint.
     * 
     * @param vSplinePoint
     * @return true if the object was removed from the collection.
     */
    public boolean removeSplinePoint(
            final org.hbird.transport.xtce.castor.SplinePoint vSplinePoint) {
        boolean removed = _splinePointList.remove(vSplinePoint);
        return removed;
    }

    /**
     * Method removeSplinePointAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.hbird.transport.xtce.castor.SplinePoint removeSplinePointAt(
            final int index) {
        java.lang.Object obj = this._splinePointList.remove(index);
        return (org.hbird.transport.xtce.castor.SplinePoint) obj;
    }

    /**
     * Sets the value of field 'extrapolate'.
     * 
     * @param extrapolate the value of field 'extrapolate'.
     */
    public void setExtrapolate(
            final boolean extrapolate) {
        this._extrapolate = extrapolate;
        this._has_extrapolate = true;
    }

    /**
     * Sets the value of field 'order'.
     * 
     * @param order the value of field 'order'.
     */
    public void setOrder(
            final long order) {
        this._order = order;
        this._has_order = true;
    }

    /**
     * 
     * 
     * @param index
     * @param vSplinePoint
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSplinePoint(
            final int index,
            final org.hbird.transport.xtce.castor.SplinePoint vSplinePoint)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._splinePointList.size()) {
            throw new IndexOutOfBoundsException("setSplinePoint: Index value '" + index + "' not in range [0.." + (this._splinePointList.size() - 1) + "]");
        }

        this._splinePointList.set(index, vSplinePoint);
    }

    /**
     * 
     * 
     * @param vSplinePointArray
     */
    public void setSplinePoint(
            final org.hbird.transport.xtce.castor.SplinePoint[] vSplinePointArray) {
        //-- copy array
        _splinePointList.clear();

        for (int i = 0; i < vSplinePointArray.length; i++) {
                this._splinePointList.add(vSplinePointArray[i]);
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
     * org.hbird.xtce.castor.SplineCalibrator
     */
    public static org.hbird.transport.xtce.castor.SplineCalibrator unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.SplineCalibrator) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.SplineCalibrator.class, reader);
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
