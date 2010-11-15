/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * A polynomial expression. For example: 3 + 2x
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class PolynomialType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * A term in a polynomial expresssion. 
     */
    private java.util.List<com.logica.hummingbird.xtce.castor.Term> _termList;


      //----------------/
     //- Constructors -/
    //----------------/

    public PolynomialType() {
        super();
        this._termList = new java.util.ArrayList<com.logica.hummingbird.xtce.castor.Term>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vTerm
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addTerm(
            final com.logica.hummingbird.xtce.castor.Term vTerm)
    throws java.lang.IndexOutOfBoundsException {
        this._termList.add(vTerm);
    }

    /**
     * 
     * 
     * @param index
     * @param vTerm
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addTerm(
            final int index,
            final com.logica.hummingbird.xtce.castor.Term vTerm)
    throws java.lang.IndexOutOfBoundsException {
        this._termList.add(index, vTerm);
    }

    /**
     * Method enumerateTerm.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends com.logica.hummingbird.xtce.castor.Term> enumerateTerm(
    ) {
        return java.util.Collections.enumeration(this._termList);
    }

    /**
     * Method getTerm.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * com.logica.hummingbird.xtce.castor.Term at the given index
     */
    public com.logica.hummingbird.xtce.castor.Term getTerm(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._termList.size()) {
            throw new IndexOutOfBoundsException("getTerm: Index value '" + index + "' not in range [0.." + (this._termList.size() - 1) + "]");
        }

        return (com.logica.hummingbird.xtce.castor.Term) _termList.get(index);
    }

    /**
     * Method getTerm.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public com.logica.hummingbird.xtce.castor.Term[] getTerm(
    ) {
        com.logica.hummingbird.xtce.castor.Term[] array = new com.logica.hummingbird.xtce.castor.Term[0];
        return (com.logica.hummingbird.xtce.castor.Term[]) this._termList.toArray(array);
    }

    /**
     * Method getTermCount.
     * 
     * @return the size of this collection
     */
    public int getTermCount(
    ) {
        return this._termList.size();
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
     * Method iterateTerm.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends com.logica.hummingbird.xtce.castor.Term> iterateTerm(
    ) {
        return this._termList.iterator();
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
    public void removeAllTerm(
    ) {
        this._termList.clear();
    }

    /**
     * Method removeTerm.
     * 
     * @param vTerm
     * @return true if the object was removed from the collection.
     */
    public boolean removeTerm(
            final com.logica.hummingbird.xtce.castor.Term vTerm) {
        boolean removed = _termList.remove(vTerm);
        return removed;
    }

    /**
     * Method removeTermAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.logica.hummingbird.xtce.castor.Term removeTermAt(
            final int index) {
        java.lang.Object obj = this._termList.remove(index);
        return (com.logica.hummingbird.xtce.castor.Term) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vTerm
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setTerm(
            final int index,
            final com.logica.hummingbird.xtce.castor.Term vTerm)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._termList.size()) {
            throw new IndexOutOfBoundsException("setTerm: Index value '" + index + "' not in range [0.." + (this._termList.size() - 1) + "]");
        }

        this._termList.set(index, vTerm);
    }

    /**
     * 
     * 
     * @param vTermArray
     */
    public void setTerm(
            final com.logica.hummingbird.xtce.castor.Term[] vTermArray) {
        //-- copy array
        _termList.clear();

        for (int i = 0; i < vTermArray.length; i++) {
                this._termList.add(vTermArray[i]);
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
     * com.logica.hummingbird.xtce.castor.PolynomialType
     */
    public static com.logica.hummingbird.xtce.castor.PolynomialType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.PolynomialType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.PolynomialType.class, reader);
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
