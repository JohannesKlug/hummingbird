/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * Class NoteSet.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class NoteSet implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _noteList.
     */
    private java.util.List<java.lang.String> _noteList;


      //----------------/
     //- Constructors -/
    //----------------/

    public NoteSet() {
        super();
        this._noteList = new java.util.ArrayList<java.lang.String>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vNote
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addNote(
            final java.lang.String vNote)
    throws java.lang.IndexOutOfBoundsException {
        this._noteList.add(vNote);
    }

    /**
     * 
     * 
     * @param index
     * @param vNote
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addNote(
            final int index,
            final java.lang.String vNote)
    throws java.lang.IndexOutOfBoundsException {
        this._noteList.add(index, vNote);
    }

    /**
     * Method enumerateNote.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends java.lang.String> enumerateNote(
    ) {
        return java.util.Collections.enumeration(this._noteList);
    }

    /**
     * Method getNote.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the java.lang.String at the given index
     */
    public java.lang.String getNote(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._noteList.size()) {
            throw new IndexOutOfBoundsException("getNote: Index value '" + index + "' not in range [0.." + (this._noteList.size() - 1) + "]");
        }

        return (java.lang.String) _noteList.get(index);
    }

    /**
     * Method getNote.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public java.lang.String[] getNote(
    ) {
        java.lang.String[] array = new java.lang.String[0];
        return (java.lang.String[]) this._noteList.toArray(array);
    }

    /**
     * Method getNoteCount.
     * 
     * @return the size of this collection
     */
    public int getNoteCount(
    ) {
        return this._noteList.size();
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
     * Method iterateNote.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends java.lang.String> iterateNote(
    ) {
        return this._noteList.iterator();
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
    public void removeAllNote(
    ) {
        this._noteList.clear();
    }

    /**
     * Method removeNote.
     * 
     * @param vNote
     * @return true if the object was removed from the collection.
     */
    public boolean removeNote(
            final java.lang.String vNote) {
        boolean removed = _noteList.remove(vNote);
        return removed;
    }

    /**
     * Method removeNoteAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public java.lang.String removeNoteAt(
            final int index) {
        java.lang.Object obj = this._noteList.remove(index);
        return (java.lang.String) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vNote
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setNote(
            final int index,
            final java.lang.String vNote)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._noteList.size()) {
            throw new IndexOutOfBoundsException("setNote: Index value '" + index + "' not in range [0.." + (this._noteList.size() - 1) + "]");
        }

        this._noteList.set(index, vNote);
    }

    /**
     * 
     * 
     * @param vNoteArray
     */
    public void setNote(
            final java.lang.String[] vNoteArray) {
        //-- copy array
        _noteList.clear();

        for (int i = 0; i < vNoteArray.length; i++) {
                this._noteList.add(vNoteArray[i]);
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
     * org.hbird.xtce.castor.NoteSet
     */
    public static org.hbird.transport.xtce.castor.NoteSet unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.NoteSet) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.NoteSet.class, reader);
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
