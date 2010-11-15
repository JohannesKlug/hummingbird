/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Class OutputSet.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class OutputSet implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Names an output parameter to the algorithm. There are two
     * attributes to OutputParm, outputName and parameterName.
     * parameterName is a parameter reference name for a parameter
     * that will be updated by this algorithm. outputName is an
     * optional "friendly" name for the output parameter.
     */
    private java.util.List<com.logica.hummingbird.xtce.castor.OutputParameterRef> _outputParameterRefList;


      //----------------/
     //- Constructors -/
    //----------------/

    public OutputSet() {
        super();
        this._outputParameterRefList = new java.util.ArrayList<com.logica.hummingbird.xtce.castor.OutputParameterRef>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vOutputParameterRef
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addOutputParameterRef(
            final com.logica.hummingbird.xtce.castor.OutputParameterRef vOutputParameterRef)
    throws java.lang.IndexOutOfBoundsException {
        this._outputParameterRefList.add(vOutputParameterRef);
    }

    /**
     * 
     * 
     * @param index
     * @param vOutputParameterRef
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addOutputParameterRef(
            final int index,
            final com.logica.hummingbird.xtce.castor.OutputParameterRef vOutputParameterRef)
    throws java.lang.IndexOutOfBoundsException {
        this._outputParameterRefList.add(index, vOutputParameterRef);
    }

    /**
     * Method enumerateOutputParameterRef.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends com.logica.hummingbird.xtce.castor.OutputParameterRef> enumerateOutputParameterRef(
    ) {
        return java.util.Collections.enumeration(this._outputParameterRefList);
    }

    /**
     * Method getOutputParameterRef.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.logica.hummingbird.xtce.castor.OutputParameterRef at the
     * given index
     */
    public com.logica.hummingbird.xtce.castor.OutputParameterRef getOutputParameterRef(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._outputParameterRefList.size()) {
            throw new IndexOutOfBoundsException("getOutputParameterRef: Index value '" + index + "' not in range [0.." + (this._outputParameterRefList.size() - 1) + "]");
        }

        return (com.logica.hummingbird.xtce.castor.OutputParameterRef) _outputParameterRefList.get(index);
    }

    /**
     * Method getOutputParameterRef.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.logica.hummingbird.xtce.castor.OutputParameterRef[] getOutputParameterRef(
    ) {
        com.logica.hummingbird.xtce.castor.OutputParameterRef[] array = new com.logica.hummingbird.xtce.castor.OutputParameterRef[0];
        return (com.logica.hummingbird.xtce.castor.OutputParameterRef[]) this._outputParameterRefList.toArray(array);
    }

    /**
     * Method getOutputParameterRefCount.
     * 
     * @return the size of this collection
     */
    public int getOutputParameterRefCount(
    ) {
        return this._outputParameterRefList.size();
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
     * Method iterateOutputParameterRef.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends com.logica.hummingbird.xtce.castor.OutputParameterRef> iterateOutputParameterRef(
    ) {
        return this._outputParameterRefList.iterator();
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
    public void removeAllOutputParameterRef(
    ) {
        this._outputParameterRefList.clear();
    }

    /**
     * Method removeOutputParameterRef.
     * 
     * @param vOutputParameterRef
     * @return true if the object was removed from the collection.
     */
    public boolean removeOutputParameterRef(
            final com.logica.hummingbird.xtce.castor.OutputParameterRef vOutputParameterRef) {
        boolean removed = _outputParameterRefList.remove(vOutputParameterRef);
        return removed;
    }

    /**
     * Method removeOutputParameterRefAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.logica.hummingbird.xtce.castor.OutputParameterRef removeOutputParameterRefAt(
            final int index) {
        java.lang.Object obj = this._outputParameterRefList.remove(index);
        return (com.logica.hummingbird.xtce.castor.OutputParameterRef) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vOutputParameterRef
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setOutputParameterRef(
            final int index,
            final com.logica.hummingbird.xtce.castor.OutputParameterRef vOutputParameterRef)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._outputParameterRefList.size()) {
            throw new IndexOutOfBoundsException("setOutputParameterRef: Index value '" + index + "' not in range [0.." + (this._outputParameterRefList.size() - 1) + "]");
        }

        this._outputParameterRefList.set(index, vOutputParameterRef);
    }

    /**
     * 
     * 
     * @param vOutputParameterRefArray
     */
    public void setOutputParameterRef(
            final com.logica.hummingbird.xtce.castor.OutputParameterRef[] vOutputParameterRefArray) {
        //-- copy array
        _outputParameterRefList.clear();

        for (int i = 0; i < vOutputParameterRefArray.length; i++) {
                this._outputParameterRefList.add(vOutputParameterRefArray[i]);
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
     * com.logica.hummingbird.xtce.castor.OutputSet
     */
    public static com.logica.hummingbird.xtce.castor.OutputSet unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.OutputSet) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.OutputSet.class, reader);
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
