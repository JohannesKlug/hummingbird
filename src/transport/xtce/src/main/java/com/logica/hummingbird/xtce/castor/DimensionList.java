/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * Where the Dimension list is in this form:
 * Array[1stDim][2ndDim][lastDim]. The last dimension is assumed to
 * be the least significant - that is this dimension will cycle
 * through it's combination before the next to last dimension
 * changes. The order MUST ascend or the array will need to be
 * broken out entry by entry. 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class DimensionList implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * For partial entries of an array, the starting and ending
     * index for each dimension, OR the Size must be specified.
     * Indexes are zero based.
     */
    private java.util.List<org.hbird.xtce.castor.Dimension> _dimensionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public DimensionList() {
        super();
        this._dimensionList = new java.util.ArrayList<org.hbird.xtce.castor.Dimension>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vDimension
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDimension(
            final org.hbird.xtce.castor.Dimension vDimension)
    throws java.lang.IndexOutOfBoundsException {
        this._dimensionList.add(vDimension);
    }

    /**
     * 
     * 
     * @param index
     * @param vDimension
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDimension(
            final int index,
            final org.hbird.xtce.castor.Dimension vDimension)
    throws java.lang.IndexOutOfBoundsException {
        this._dimensionList.add(index, vDimension);
    }

    /**
     * Method enumerateDimension.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends org.hbird.xtce.castor.Dimension> enumerateDimension(
    ) {
        return java.util.Collections.enumeration(this._dimensionList);
    }

    /**
     * Method getDimension.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.hbird.xtce.castor.Dimension at the given
     * index
     */
    public org.hbird.xtce.castor.Dimension getDimension(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._dimensionList.size()) {
            throw new IndexOutOfBoundsException("getDimension: Index value '" + index + "' not in range [0.." + (this._dimensionList.size() - 1) + "]");
        }

        return (org.hbird.xtce.castor.Dimension) _dimensionList.get(index);
    }

    /**
     * Method getDimension.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.hbird.xtce.castor.Dimension[] getDimension(
    ) {
        org.hbird.xtce.castor.Dimension[] array = new org.hbird.xtce.castor.Dimension[0];
        return (org.hbird.xtce.castor.Dimension[]) this._dimensionList.toArray(array);
    }

    /**
     * Method getDimensionCount.
     * 
     * @return the size of this collection
     */
    public int getDimensionCount(
    ) {
        return this._dimensionList.size();
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
     * Method iterateDimension.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends org.hbird.xtce.castor.Dimension> iterateDimension(
    ) {
        return this._dimensionList.iterator();
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
    public void removeAllDimension(
    ) {
        this._dimensionList.clear();
    }

    /**
     * Method removeDimension.
     * 
     * @param vDimension
     * @return true if the object was removed from the collection.
     */
    public boolean removeDimension(
            final org.hbird.xtce.castor.Dimension vDimension) {
        boolean removed = _dimensionList.remove(vDimension);
        return removed;
    }

    /**
     * Method removeDimensionAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.hbird.xtce.castor.Dimension removeDimensionAt(
            final int index) {
        java.lang.Object obj = this._dimensionList.remove(index);
        return (org.hbird.xtce.castor.Dimension) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vDimension
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setDimension(
            final int index,
            final org.hbird.xtce.castor.Dimension vDimension)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._dimensionList.size()) {
            throw new IndexOutOfBoundsException("setDimension: Index value '" + index + "' not in range [0.." + (this._dimensionList.size() - 1) + "]");
        }

        this._dimensionList.set(index, vDimension);
    }

    /**
     * 
     * 
     * @param vDimensionArray
     */
    public void setDimension(
            final org.hbird.xtce.castor.Dimension[] vDimensionArray) {
        //-- copy array
        _dimensionList.clear();

        for (int i = 0; i < vDimensionArray.length; i++) {
                this._dimensionList.add(vDimensionArray[i]);
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
     * org.hbird.xtce.castor.DimensionList
     */
    public static org.hbird.xtce.castor.DimensionList unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.DimensionList) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.DimensionList.class, reader);
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
