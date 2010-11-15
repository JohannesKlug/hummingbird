/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Class RateInStreamSet.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class RateInStreamSet implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _rateInStreamList.
     */
    private java.util.List<com.logica.hummingbird.xtce.castor.RateInStream> _rateInStreamList;


      //----------------/
     //- Constructors -/
    //----------------/

    public RateInStreamSet() {
        super();
        this._rateInStreamList = new java.util.ArrayList<com.logica.hummingbird.xtce.castor.RateInStream>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vRateInStream
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addRateInStream(
            final com.logica.hummingbird.xtce.castor.RateInStream vRateInStream)
    throws java.lang.IndexOutOfBoundsException {
        this._rateInStreamList.add(vRateInStream);
    }

    /**
     * 
     * 
     * @param index
     * @param vRateInStream
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addRateInStream(
            final int index,
            final com.logica.hummingbird.xtce.castor.RateInStream vRateInStream)
    throws java.lang.IndexOutOfBoundsException {
        this._rateInStreamList.add(index, vRateInStream);
    }

    /**
     * Method enumerateRateInStream.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends com.logica.hummingbird.xtce.castor.RateInStream> enumerateRateInStream(
    ) {
        return java.util.Collections.enumeration(this._rateInStreamList);
    }

    /**
     * Method getRateInStream.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.logica.hummingbird.xtce.castor.RateInStream at the given
     * index
     */
    public com.logica.hummingbird.xtce.castor.RateInStream getRateInStream(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._rateInStreamList.size()) {
            throw new IndexOutOfBoundsException("getRateInStream: Index value '" + index + "' not in range [0.." + (this._rateInStreamList.size() - 1) + "]");
        }

        return (com.logica.hummingbird.xtce.castor.RateInStream) _rateInStreamList.get(index);
    }

    /**
     * Method getRateInStream.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.logica.hummingbird.xtce.castor.RateInStream[] getRateInStream(
    ) {
        com.logica.hummingbird.xtce.castor.RateInStream[] array = new com.logica.hummingbird.xtce.castor.RateInStream[0];
        return (com.logica.hummingbird.xtce.castor.RateInStream[]) this._rateInStreamList.toArray(array);
    }

    /**
     * Method getRateInStreamCount.
     * 
     * @return the size of this collection
     */
    public int getRateInStreamCount(
    ) {
        return this._rateInStreamList.size();
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
     * Method iterateRateInStream.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends com.logica.hummingbird.xtce.castor.RateInStream> iterateRateInStream(
    ) {
        return this._rateInStreamList.iterator();
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
    public void removeAllRateInStream(
    ) {
        this._rateInStreamList.clear();
    }

    /**
     * Method removeRateInStream.
     * 
     * @param vRateInStream
     * @return true if the object was removed from the collection.
     */
    public boolean removeRateInStream(
            final com.logica.hummingbird.xtce.castor.RateInStream vRateInStream) {
        boolean removed = _rateInStreamList.remove(vRateInStream);
        return removed;
    }

    /**
     * Method removeRateInStreamAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.logica.hummingbird.xtce.castor.RateInStream removeRateInStreamAt(
            final int index) {
        java.lang.Object obj = this._rateInStreamList.remove(index);
        return (com.logica.hummingbird.xtce.castor.RateInStream) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vRateInStream
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setRateInStream(
            final int index,
            final com.logica.hummingbird.xtce.castor.RateInStream vRateInStream)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._rateInStreamList.size()) {
            throw new IndexOutOfBoundsException("setRateInStream: Index value '" + index + "' not in range [0.." + (this._rateInStreamList.size() - 1) + "]");
        }

        this._rateInStreamList.set(index, vRateInStream);
    }

    /**
     * 
     * 
     * @param vRateInStreamArray
     */
    public void setRateInStream(
            final com.logica.hummingbird.xtce.castor.RateInStream[] vRateInStreamArray) {
        //-- copy array
        _rateInStreamList.clear();

        for (int i = 0; i < vRateInStreamArray.length; i++) {
                this._rateInStreamList.add(vRateInStreamArray[i]);
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
     * com.logica.hummingbird.xtce.castor.RateInStreamSet
     */
    public static com.logica.hummingbird.xtce.castor.RateInStreamSet unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.RateInStreamSet) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.RateInStreamSet.class, reader);
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
