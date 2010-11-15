/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * Class ExternalAlgorithmSet.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ExternalAlgorithmSet implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * This is the external algorithm. Multiple entries are
     * provided so that the same database may be used for multiple
     * implementation s
     */
    private java.util.List<org.hbird.xtce.castor.ExternalAlgorithm> _externalAlgorithmList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ExternalAlgorithmSet() {
        super();
        this._externalAlgorithmList = new java.util.ArrayList<org.hbird.xtce.castor.ExternalAlgorithm>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vExternalAlgorithm
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addExternalAlgorithm(
            final org.hbird.xtce.castor.ExternalAlgorithm vExternalAlgorithm)
    throws java.lang.IndexOutOfBoundsException {
        this._externalAlgorithmList.add(vExternalAlgorithm);
    }

    /**
     * 
     * 
     * @param index
     * @param vExternalAlgorithm
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addExternalAlgorithm(
            final int index,
            final org.hbird.xtce.castor.ExternalAlgorithm vExternalAlgorithm)
    throws java.lang.IndexOutOfBoundsException {
        this._externalAlgorithmList.add(index, vExternalAlgorithm);
    }

    /**
     * Method enumerateExternalAlgorithm.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends org.hbird.xtce.castor.ExternalAlgorithm> enumerateExternalAlgorithm(
    ) {
        return java.util.Collections.enumeration(this._externalAlgorithmList);
    }

    /**
     * Method getExternalAlgorithm.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.hbird.xtce.castor.ExternalAlgorithm at the
     * given index
     */
    public org.hbird.xtce.castor.ExternalAlgorithm getExternalAlgorithm(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._externalAlgorithmList.size()) {
            throw new IndexOutOfBoundsException("getExternalAlgorithm: Index value '" + index + "' not in range [0.." + (this._externalAlgorithmList.size() - 1) + "]");
        }

        return (org.hbird.xtce.castor.ExternalAlgorithm) _externalAlgorithmList.get(index);
    }

    /**
     * Method getExternalAlgorithm.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.hbird.xtce.castor.ExternalAlgorithm[] getExternalAlgorithm(
    ) {
        org.hbird.xtce.castor.ExternalAlgorithm[] array = new org.hbird.xtce.castor.ExternalAlgorithm[0];
        return (org.hbird.xtce.castor.ExternalAlgorithm[]) this._externalAlgorithmList.toArray(array);
    }

    /**
     * Method getExternalAlgorithmCount.
     * 
     * @return the size of this collection
     */
    public int getExternalAlgorithmCount(
    ) {
        return this._externalAlgorithmList.size();
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
     * Method iterateExternalAlgorithm.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends org.hbird.xtce.castor.ExternalAlgorithm> iterateExternalAlgorithm(
    ) {
        return this._externalAlgorithmList.iterator();
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
    public void removeAllExternalAlgorithm(
    ) {
        this._externalAlgorithmList.clear();
    }

    /**
     * Method removeExternalAlgorithm.
     * 
     * @param vExternalAlgorithm
     * @return true if the object was removed from the collection.
     */
    public boolean removeExternalAlgorithm(
            final org.hbird.xtce.castor.ExternalAlgorithm vExternalAlgorithm) {
        boolean removed = _externalAlgorithmList.remove(vExternalAlgorithm);
        return removed;
    }

    /**
     * Method removeExternalAlgorithmAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.hbird.xtce.castor.ExternalAlgorithm removeExternalAlgorithmAt(
            final int index) {
        java.lang.Object obj = this._externalAlgorithmList.remove(index);
        return (org.hbird.xtce.castor.ExternalAlgorithm) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vExternalAlgorithm
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setExternalAlgorithm(
            final int index,
            final org.hbird.xtce.castor.ExternalAlgorithm vExternalAlgorithm)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._externalAlgorithmList.size()) {
            throw new IndexOutOfBoundsException("setExternalAlgorithm: Index value '" + index + "' not in range [0.." + (this._externalAlgorithmList.size() - 1) + "]");
        }

        this._externalAlgorithmList.set(index, vExternalAlgorithm);
    }

    /**
     * 
     * 
     * @param vExternalAlgorithmArray
     */
    public void setExternalAlgorithm(
            final org.hbird.xtce.castor.ExternalAlgorithm[] vExternalAlgorithmArray) {
        //-- copy array
        _externalAlgorithmList.clear();

        for (int i = 0; i < vExternalAlgorithmArray.length; i++) {
                this._externalAlgorithmList.add(vExternalAlgorithmArray[i]);
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
     * org.hbird.xtce.castor.ExternalAlgorithmSet
     */
    public static org.hbird.xtce.castor.ExternalAlgorithmSet unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.ExternalAlgorithmSet) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.ExternalAlgorithmSet.class, reader);
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
