/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * Lookup a value using the lookup list supplied. Use the first
 * match found.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class DiscreteLookupList implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _discreteLookupList.
     */
    private java.util.List<org.hbird.transport.xtce.castor.DiscreteLookup> _discreteLookupList;


      //----------------/
     //- Constructors -/
    //----------------/

    public DiscreteLookupList() {
        super();
        this._discreteLookupList = new java.util.ArrayList<org.hbird.transport.xtce.castor.DiscreteLookup>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vDiscreteLookup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDiscreteLookup(
            final org.hbird.transport.xtce.castor.DiscreteLookup vDiscreteLookup)
    throws java.lang.IndexOutOfBoundsException {
        this._discreteLookupList.add(vDiscreteLookup);
    }

    /**
     * 
     * 
     * @param index
     * @param vDiscreteLookup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addDiscreteLookup(
            final int index,
            final org.hbird.transport.xtce.castor.DiscreteLookup vDiscreteLookup)
    throws java.lang.IndexOutOfBoundsException {
        this._discreteLookupList.add(index, vDiscreteLookup);
    }

    /**
     * Method enumerateDiscreteLookup.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends org.hbird.transport.xtce.castor.DiscreteLookup> enumerateDiscreteLookup(
    ) {
        return java.util.Collections.enumeration(this._discreteLookupList);
    }

    /**
     * Method getDiscreteLookup.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.hbird.xtce.castor.DiscreteLookup at the
     * given index
     */
    public org.hbird.transport.xtce.castor.DiscreteLookup getDiscreteLookup(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._discreteLookupList.size()) {
            throw new IndexOutOfBoundsException("getDiscreteLookup: Index value '" + index + "' not in range [0.." + (this._discreteLookupList.size() - 1) + "]");
        }

        return (org.hbird.transport.xtce.castor.DiscreteLookup) _discreteLookupList.get(index);
    }

    /**
     * Method getDiscreteLookup.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.hbird.transport.xtce.castor.DiscreteLookup[] getDiscreteLookup(
    ) {
        org.hbird.transport.xtce.castor.DiscreteLookup[] array = new org.hbird.transport.xtce.castor.DiscreteLookup[0];
        return (org.hbird.transport.xtce.castor.DiscreteLookup[]) this._discreteLookupList.toArray(array);
    }

    /**
     * Method getDiscreteLookupCount.
     * 
     * @return the size of this collection
     */
    public int getDiscreteLookupCount(
    ) {
        return this._discreteLookupList.size();
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
     * Method iterateDiscreteLookup.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends org.hbird.transport.xtce.castor.DiscreteLookup> iterateDiscreteLookup(
    ) {
        return this._discreteLookupList.iterator();
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
    public void removeAllDiscreteLookup(
    ) {
        this._discreteLookupList.clear();
    }

    /**
     * Method removeDiscreteLookup.
     * 
     * @param vDiscreteLookup
     * @return true if the object was removed from the collection.
     */
    public boolean removeDiscreteLookup(
            final org.hbird.transport.xtce.castor.DiscreteLookup vDiscreteLookup) {
        boolean removed = _discreteLookupList.remove(vDiscreteLookup);
        return removed;
    }

    /**
     * Method removeDiscreteLookupAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.hbird.transport.xtce.castor.DiscreteLookup removeDiscreteLookupAt(
            final int index) {
        java.lang.Object obj = this._discreteLookupList.remove(index);
        return (org.hbird.transport.xtce.castor.DiscreteLookup) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vDiscreteLookup
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setDiscreteLookup(
            final int index,
            final org.hbird.transport.xtce.castor.DiscreteLookup vDiscreteLookup)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._discreteLookupList.size()) {
            throw new IndexOutOfBoundsException("setDiscreteLookup: Index value '" + index + "' not in range [0.." + (this._discreteLookupList.size() - 1) + "]");
        }

        this._discreteLookupList.set(index, vDiscreteLookup);
    }

    /**
     * 
     * 
     * @param vDiscreteLookupArray
     */
    public void setDiscreteLookup(
            final org.hbird.transport.xtce.castor.DiscreteLookup[] vDiscreteLookupArray) {
        //-- copy array
        _discreteLookupList.clear();

        for (int i = 0; i < vDiscreteLookupArray.length; i++) {
                this._discreteLookupList.add(vDiscreteLookupArray[i]);
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
     * org.hbird.xtce.castor.DiscreteLookupList
     */
    public static org.hbird.transport.xtce.castor.DiscreteLookupList unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.DiscreteLookupList) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.DiscreteLookupList.class, reader);
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
