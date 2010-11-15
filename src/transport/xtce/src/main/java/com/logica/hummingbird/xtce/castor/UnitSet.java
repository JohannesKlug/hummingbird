/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * Class UnitSet.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class UnitSet implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _unitList.
     */
    private java.util.List<org.hbird.xtce.castor.Unit> _unitList;


      //----------------/
     //- Constructors -/
    //----------------/

    public UnitSet() {
        super();
        this._unitList = new java.util.ArrayList<org.hbird.xtce.castor.Unit>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vUnit
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUnit(
            final org.hbird.xtce.castor.Unit vUnit)
    throws java.lang.IndexOutOfBoundsException {
        this._unitList.add(vUnit);
    }

    /**
     * 
     * 
     * @param index
     * @param vUnit
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addUnit(
            final int index,
            final org.hbird.xtce.castor.Unit vUnit)
    throws java.lang.IndexOutOfBoundsException {
        this._unitList.add(index, vUnit);
    }

    /**
     * Method enumerateUnit.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends org.hbird.xtce.castor.Unit> enumerateUnit(
    ) {
        return java.util.Collections.enumeration(this._unitList);
    }

    /**
     * Method getUnit.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.hbird.xtce.castor.Unit at the given index
     */
    public org.hbird.xtce.castor.Unit getUnit(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._unitList.size()) {
            throw new IndexOutOfBoundsException("getUnit: Index value '" + index + "' not in range [0.." + (this._unitList.size() - 1) + "]");
        }

        return (org.hbird.xtce.castor.Unit) _unitList.get(index);
    }

    /**
     * Method getUnit.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.hbird.xtce.castor.Unit[] getUnit(
    ) {
        org.hbird.xtce.castor.Unit[] array = new org.hbird.xtce.castor.Unit[0];
        return (org.hbird.xtce.castor.Unit[]) this._unitList.toArray(array);
    }

    /**
     * Method getUnitCount.
     * 
     * @return the size of this collection
     */
    public int getUnitCount(
    ) {
        return this._unitList.size();
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
     * Method iterateUnit.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends org.hbird.xtce.castor.Unit> iterateUnit(
    ) {
        return this._unitList.iterator();
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
    public void removeAllUnit(
    ) {
        this._unitList.clear();
    }

    /**
     * Method removeUnit.
     * 
     * @param vUnit
     * @return true if the object was removed from the collection.
     */
    public boolean removeUnit(
            final org.hbird.xtce.castor.Unit vUnit) {
        boolean removed = _unitList.remove(vUnit);
        return removed;
    }

    /**
     * Method removeUnitAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.hbird.xtce.castor.Unit removeUnitAt(
            final int index) {
        java.lang.Object obj = this._unitList.remove(index);
        return (org.hbird.xtce.castor.Unit) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vUnit
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setUnit(
            final int index,
            final org.hbird.xtce.castor.Unit vUnit)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._unitList.size()) {
            throw new IndexOutOfBoundsException("setUnit: Index value '" + index + "' not in range [0.." + (this._unitList.size() - 1) + "]");
        }

        this._unitList.set(index, vUnit);
    }

    /**
     * 
     * 
     * @param vUnitArray
     */
    public void setUnit(
            final org.hbird.xtce.castor.Unit[] vUnitArray) {
        //-- copy array
        _unitList.clear();

        for (int i = 0; i < vUnitArray.length; i++) {
                this._unitList.add(vUnitArray[i]);
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
     * org.hbird.xtce.castor.UnitSet
     */
    public static org.hbird.xtce.castor.UnitSet unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.UnitSet) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.UnitSet.class, reader);
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
