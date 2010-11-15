/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * Used when the significance of a command varies by the operating
 * context
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ContextSignificanceList implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _contextSignificanceList.
     */
    private java.util.List<org.hbird.xtce.castor.ContextSignificance> _contextSignificanceList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ContextSignificanceList() {
        super();
        this._contextSignificanceList = new java.util.ArrayList<org.hbird.xtce.castor.ContextSignificance>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vContextSignificance
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addContextSignificance(
            final org.hbird.xtce.castor.ContextSignificance vContextSignificance)
    throws java.lang.IndexOutOfBoundsException {
        this._contextSignificanceList.add(vContextSignificance);
    }

    /**
     * 
     * 
     * @param index
     * @param vContextSignificance
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addContextSignificance(
            final int index,
            final org.hbird.xtce.castor.ContextSignificance vContextSignificance)
    throws java.lang.IndexOutOfBoundsException {
        this._contextSignificanceList.add(index, vContextSignificance);
    }

    /**
     * Method enumerateContextSignificance.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends org.hbird.xtce.castor.ContextSignificance> enumerateContextSignificance(
    ) {
        return java.util.Collections.enumeration(this._contextSignificanceList);
    }

    /**
     * Method getContextSignificance.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.hbird.xtce.castor.ContextSignificance at
     * the given index
     */
    public org.hbird.xtce.castor.ContextSignificance getContextSignificance(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._contextSignificanceList.size()) {
            throw new IndexOutOfBoundsException("getContextSignificance: Index value '" + index + "' not in range [0.." + (this._contextSignificanceList.size() - 1) + "]");
        }

        return (org.hbird.xtce.castor.ContextSignificance) _contextSignificanceList.get(index);
    }

    /**
     * Method getContextSignificance.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.hbird.xtce.castor.ContextSignificance[] getContextSignificance(
    ) {
        org.hbird.xtce.castor.ContextSignificance[] array = new org.hbird.xtce.castor.ContextSignificance[0];
        return (org.hbird.xtce.castor.ContextSignificance[]) this._contextSignificanceList.toArray(array);
    }

    /**
     * Method getContextSignificanceCount.
     * 
     * @return the size of this collection
     */
    public int getContextSignificanceCount(
    ) {
        return this._contextSignificanceList.size();
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
     * Method iterateContextSignificance.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends org.hbird.xtce.castor.ContextSignificance> iterateContextSignificance(
    ) {
        return this._contextSignificanceList.iterator();
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
    public void removeAllContextSignificance(
    ) {
        this._contextSignificanceList.clear();
    }

    /**
     * Method removeContextSignificance.
     * 
     * @param vContextSignificance
     * @return true if the object was removed from the collection.
     */
    public boolean removeContextSignificance(
            final org.hbird.xtce.castor.ContextSignificance vContextSignificance) {
        boolean removed = _contextSignificanceList.remove(vContextSignificance);
        return removed;
    }

    /**
     * Method removeContextSignificanceAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.hbird.xtce.castor.ContextSignificance removeContextSignificanceAt(
            final int index) {
        java.lang.Object obj = this._contextSignificanceList.remove(index);
        return (org.hbird.xtce.castor.ContextSignificance) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vContextSignificance
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setContextSignificance(
            final int index,
            final org.hbird.xtce.castor.ContextSignificance vContextSignificance)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._contextSignificanceList.size()) {
            throw new IndexOutOfBoundsException("setContextSignificance: Index value '" + index + "' not in range [0.." + (this._contextSignificanceList.size() - 1) + "]");
        }

        this._contextSignificanceList.set(index, vContextSignificance);
    }

    /**
     * 
     * 
     * @param vContextSignificanceArray
     */
    public void setContextSignificance(
            final org.hbird.xtce.castor.ContextSignificance[] vContextSignificanceArray) {
        //-- copy array
        _contextSignificanceList.clear();

        for (int i = 0; i < vContextSignificanceArray.length; i++) {
                this._contextSignificanceList.add(vContextSignificanceArray[i]);
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
     * org.hbird.xtce.castor.ContextSignificanceList
     */
    public static org.hbird.xtce.castor.ContextSignificanceList unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.ContextSignificanceList) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.ContextSignificanceList.class, reader);
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
