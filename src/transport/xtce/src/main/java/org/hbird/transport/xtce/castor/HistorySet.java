/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * Class HistorySet.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class HistorySet implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _historyList.
     */
    private java.util.List<java.lang.String> _historyList;


      //----------------/
     //- Constructors -/
    //----------------/

    public HistorySet() {
        super();
        this._historyList = new java.util.ArrayList<java.lang.String>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vHistory
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addHistory(
            final java.lang.String vHistory)
    throws java.lang.IndexOutOfBoundsException {
        this._historyList.add(vHistory);
    }

    /**
     * 
     * 
     * @param index
     * @param vHistory
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addHistory(
            final int index,
            final java.lang.String vHistory)
    throws java.lang.IndexOutOfBoundsException {
        this._historyList.add(index, vHistory);
    }

    /**
     * Method enumerateHistory.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends java.lang.String> enumerateHistory(
    ) {
        return java.util.Collections.enumeration(this._historyList);
    }

    /**
     * Method getHistory.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getHistory(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._historyList.size()) {
            throw new IndexOutOfBoundsException("getHistory: Index value '" + index + "' not in range [0.." + (this._historyList.size() - 1) + "]");
        }

        return (java.lang.String) _historyList.get(index);
    }

    /**
     * Method getHistory.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getHistory(
    ) {
        java.lang.String[] array = new java.lang.String[0];
        return (java.lang.String[]) this._historyList.toArray(array);
    }

    /**
     * Method getHistoryCount.
     * 
     * @return the size of this collection
     */
    public int getHistoryCount(
    ) {
        return this._historyList.size();
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
     * Method iterateHistory.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends java.lang.String> iterateHistory(
    ) {
        return this._historyList.iterator();
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
    public void removeAllHistory(
    ) {
        this._historyList.clear();
    }

    /**
     * Method removeHistory.
     * 
     * @param vHistory
     * @return true if the object was removed from the collection.
     */
    public boolean removeHistory(
            final java.lang.String vHistory) {
        boolean removed = _historyList.remove(vHistory);
        return removed;
    }

    /**
     * Method removeHistoryAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeHistoryAt(
            final int index) {
        java.lang.Object obj = this._historyList.remove(index);
        return (java.lang.String) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vHistory
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setHistory(
            final int index,
            final java.lang.String vHistory)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._historyList.size()) {
            throw new IndexOutOfBoundsException("setHistory: Index value '" + index + "' not in range [0.." + (this._historyList.size() - 1) + "]");
        }

        this._historyList.set(index, vHistory);
    }

    /**
     * 
     * 
     * @param vHistoryArray
     */
    public void setHistory(
            final java.lang.String[] vHistoryArray) {
        //-- copy array
        _historyList.clear();

        for (int i = 0; i < vHistoryArray.length; i++) {
                this._historyList.add(vHistoryArray[i]);
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
     * org.hbird.xtce.castor.HistorySet
     */
    public static org.hbird.transport.xtce.castor.HistorySet unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.HistorySet) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.HistorySet.class, reader);
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
