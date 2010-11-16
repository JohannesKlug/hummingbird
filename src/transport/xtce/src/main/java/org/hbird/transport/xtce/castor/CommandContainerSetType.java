/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * Contains an unordered Set of Command Containers
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CommandContainerSetType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _commandContainerList.
     */
    private java.util.List<org.hbird.transport.xtce.castor.CommandContainerSetTypeCommandContainer> _commandContainerList;


      //----------------/
     //- Constructors -/
    //----------------/

    public CommandContainerSetType() {
        super();
        this._commandContainerList = new java.util.ArrayList<org.hbird.transport.xtce.castor.CommandContainerSetTypeCommandContainer>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vCommandContainer
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCommandContainer(
            final org.hbird.transport.xtce.castor.CommandContainerSetTypeCommandContainer vCommandContainer)
    throws java.lang.IndexOutOfBoundsException {
        this._commandContainerList.add(vCommandContainer);
    }

    /**
     * 
     * 
     * @param index
     * @param vCommandContainer
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCommandContainer(
            final int index,
            final org.hbird.transport.xtce.castor.CommandContainerSetTypeCommandContainer vCommandContainer)
    throws java.lang.IndexOutOfBoundsException {
        this._commandContainerList.add(index, vCommandContainer);
    }

    /**
     * Method enumerateCommandContainer.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends org.hbird.transport.xtce.castor.CommandContainerSetTypeCommandContainer> enumerateCommandContainer(
    ) {
        return java.util.Collections.enumeration(this._commandContainerList);
    }

    /**
     * Method getCommandContainer.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.hbird.xtce.castor.CommandContainerSetTypeCommandContainer
     * at the given index
     */
    public org.hbird.transport.xtce.castor.CommandContainerSetTypeCommandContainer getCommandContainer(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._commandContainerList.size()) {
            throw new IndexOutOfBoundsException("getCommandContainer: Index value '" + index + "' not in range [0.." + (this._commandContainerList.size() - 1) + "]");
        }

        return (org.hbird.transport.xtce.castor.CommandContainerSetTypeCommandContainer) _commandContainerList.get(index);
    }

    /**
     * Method getCommandContainer.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.hbird.transport.xtce.castor.CommandContainerSetTypeCommandContainer[] getCommandContainer(
    ) {
        org.hbird.transport.xtce.castor.CommandContainerSetTypeCommandContainer[] array = new org.hbird.transport.xtce.castor.CommandContainerSetTypeCommandContainer[0];
        return (org.hbird.transport.xtce.castor.CommandContainerSetTypeCommandContainer[]) this._commandContainerList.toArray(array);
    }

    /**
     * Method getCommandContainerCount.
     * 
     * @return the size of this collection
     */
    public int getCommandContainerCount(
    ) {
        return this._commandContainerList.size();
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
     * Method iterateCommandContainer.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends org.hbird.transport.xtce.castor.CommandContainerSetTypeCommandContainer> iterateCommandContainer(
    ) {
        return this._commandContainerList.iterator();
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
    public void removeAllCommandContainer(
    ) {
        this._commandContainerList.clear();
    }

    /**
     * Method removeCommandContainer.
     * 
     * @param vCommandContainer
     * @return true if the object was removed from the collection.
     */
    public boolean removeCommandContainer(
            final org.hbird.transport.xtce.castor.CommandContainerSetTypeCommandContainer vCommandContainer) {
        boolean removed = _commandContainerList.remove(vCommandContainer);
        return removed;
    }

    /**
     * Method removeCommandContainerAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.hbird.transport.xtce.castor.CommandContainerSetTypeCommandContainer removeCommandContainerAt(
            final int index) {
        java.lang.Object obj = this._commandContainerList.remove(index);
        return (org.hbird.transport.xtce.castor.CommandContainerSetTypeCommandContainer) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vCommandContainer
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCommandContainer(
            final int index,
            final org.hbird.transport.xtce.castor.CommandContainerSetTypeCommandContainer vCommandContainer)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._commandContainerList.size()) {
            throw new IndexOutOfBoundsException("setCommandContainer: Index value '" + index + "' not in range [0.." + (this._commandContainerList.size() - 1) + "]");
        }

        this._commandContainerList.set(index, vCommandContainer);
    }

    /**
     * 
     * 
     * @param vCommandContainerArray
     */
    public void setCommandContainer(
            final org.hbird.transport.xtce.castor.CommandContainerSetTypeCommandContainer[] vCommandContainerArray) {
        //-- copy array
        _commandContainerList.clear();

        for (int i = 0; i < vCommandContainerArray.length; i++) {
                this._commandContainerList.add(vCommandContainerArray[i]);
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
     * org.hbird.xtce.castor.CommandContainerSetType
     */
    public static org.hbird.transport.xtce.castor.CommandContainerSetType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.CommandContainerSetType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.CommandContainerSetType.class, reader);
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
