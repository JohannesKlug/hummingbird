/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * Contains an unordered collection of Alias's
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class AliasSetType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Used to contain an alias (alternate) name or ID for the the
     * object. For example, a parameter may have a mnemonic, an
     * on-board id, and special IDs used by various ground software
     * applications; all of these are alias's. Some ground system
     * processing equipent has some severe naming restrictions on
     * parameters (e.g., names must less then 12 characters, single
     * case or integral id's only); their alias's provide a means
     * of capturing each name in a "nameSpace".
     */
    private java.util.List<org.hbird.transport.xtce.castor.Alias> _aliasList;


      //----------------/
     //- Constructors -/
    //----------------/

    public AliasSetType() {
        super();
        this._aliasList = new java.util.ArrayList<org.hbird.transport.xtce.castor.Alias>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vAlias
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAlias(
            final org.hbird.transport.xtce.castor.Alias vAlias)
    throws java.lang.IndexOutOfBoundsException {
        this._aliasList.add(vAlias);
    }

    /**
     * 
     * 
     * @param index
     * @param vAlias
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addAlias(
            final int index,
            final org.hbird.transport.xtce.castor.Alias vAlias)
    throws java.lang.IndexOutOfBoundsException {
        this._aliasList.add(index, vAlias);
    }

    /**
     * Method enumerateAlias.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends org.hbird.transport.xtce.castor.Alias> enumerateAlias(
    ) {
        return java.util.Collections.enumeration(this._aliasList);
    }

    /**
     * Method getAlias.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.hbird.xtce.castor.Alias at the given index
     */
    public org.hbird.transport.xtce.castor.Alias getAlias(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._aliasList.size()) {
            throw new IndexOutOfBoundsException("getAlias: Index value '" + index + "' not in range [0.." + (this._aliasList.size() - 1) + "]");
        }

        return (org.hbird.transport.xtce.castor.Alias) _aliasList.get(index);
    }

    /**
     * Method getAlias.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.hbird.transport.xtce.castor.Alias[] getAlias(
    ) {
        org.hbird.transport.xtce.castor.Alias[] array = new org.hbird.transport.xtce.castor.Alias[0];
        return (org.hbird.transport.xtce.castor.Alias[]) this._aliasList.toArray(array);
    }

    /**
     * Method getAliasCount.
     * 
     * @return the size of this collection
     */
    public int getAliasCount(
    ) {
        return this._aliasList.size();
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
     * Method iterateAlias.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends org.hbird.transport.xtce.castor.Alias> iterateAlias(
    ) {
        return this._aliasList.iterator();
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
     * Method removeAlias.
     * 
     * @param vAlias
     * @return true if the object was removed from the collection.
     */
    public boolean removeAlias(
            final org.hbird.transport.xtce.castor.Alias vAlias) {
        boolean removed = _aliasList.remove(vAlias);
        return removed;
    }

    /**
     * Method removeAliasAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.hbird.transport.xtce.castor.Alias removeAliasAt(
            final int index) {
        java.lang.Object obj = this._aliasList.remove(index);
        return (org.hbird.transport.xtce.castor.Alias) obj;
    }

    /**
     */
    public void removeAllAlias(
    ) {
        this._aliasList.clear();
    }

    /**
     * 
     * 
     * @param index
     * @param vAlias
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setAlias(
            final int index,
            final org.hbird.transport.xtce.castor.Alias vAlias)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._aliasList.size()) {
            throw new IndexOutOfBoundsException("setAlias: Index value '" + index + "' not in range [0.." + (this._aliasList.size() - 1) + "]");
        }

        this._aliasList.set(index, vAlias);
    }

    /**
     * 
     * 
     * @param vAliasArray
     */
    public void setAlias(
            final org.hbird.transport.xtce.castor.Alias[] vAliasArray) {
        //-- copy array
        _aliasList.clear();

        for (int i = 0; i < vAliasArray.length; i++) {
                this._aliasList.add(vAliasArray[i]);
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
     * org.hbird.xtce.castor.AliasSetType
     */
    public static org.hbird.transport.xtce.castor.AliasSetType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.AliasSetType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.AliasSetType.class, reader);
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
