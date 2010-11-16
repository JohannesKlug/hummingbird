/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * Class ArgumentList.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentList implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _argumentList.
     */
    private java.util.List<org.hbird.transport.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentListArgument> _argumentList;


      //----------------/
     //- Constructors -/
    //----------------/

    public CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentList() {
        super();
        this._argumentList = new java.util.ArrayList<org.hbird.transport.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentListArgument>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vArgument
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addArgument(
            final org.hbird.transport.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentListArgument vArgument)
    throws java.lang.IndexOutOfBoundsException {
        this._argumentList.add(vArgument);
    }

    /**
     * 
     * 
     * @param index
     * @param vArgument
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addArgument(
            final int index,
            final org.hbird.transport.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentListArgument vArgument)
    throws java.lang.IndexOutOfBoundsException {
        this._argumentList.add(index, vArgument);
    }

    /**
     * Method enumerateArgument.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends org.hbird.transport.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentListArgument> enumerateArgument(
    ) {
        return java.util.Collections.enumeration(this._argumentList);
    }

    /**
     * Method getArgument.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.hbird.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentListArgument
     * at the given index
     */
    public org.hbird.transport.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentListArgument getArgument(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._argumentList.size()) {
            throw new IndexOutOfBoundsException("getArgument: Index value '" + index + "' not in range [0.." + (this._argumentList.size() - 1) + "]");
        }

        return (org.hbird.transport.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentListArgument) _argumentList.get(index);
    }

    /**
     * Method getArgument.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.hbird.transport.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentListArgument[] getArgument(
    ) {
        org.hbird.transport.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentListArgument[] array = new org.hbird.transport.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentListArgument[0];
        return (org.hbird.transport.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentListArgument[]) this._argumentList.toArray(array);
    }

    /**
     * Method getArgumentCount.
     * 
     * @return the size of this collection
     */
    public int getArgumentCount(
    ) {
        return this._argumentList.size();
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
     * Method iterateArgument.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends org.hbird.transport.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentListArgument> iterateArgument(
    ) {
        return this._argumentList.iterator();
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
    public void removeAllArgument(
    ) {
        this._argumentList.clear();
    }

    /**
     * Method removeArgument.
     * 
     * @param vArgument
     * @return true if the object was removed from the collection.
     */
    public boolean removeArgument(
            final org.hbird.transport.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentListArgument vArgument) {
        boolean removed = _argumentList.remove(vArgument);
        return removed;
    }

    /**
     * Method removeArgumentAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.hbird.transport.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentListArgument removeArgumentAt(
            final int index) {
        java.lang.Object obj = this._argumentList.remove(index);
        return (org.hbird.transport.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentListArgument) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vArgument
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setArgument(
            final int index,
            final org.hbird.transport.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentListArgument vArgument)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._argumentList.size()) {
            throw new IndexOutOfBoundsException("setArgument: Index value '" + index + "' not in range [0.." + (this._argumentList.size() - 1) + "]");
        }

        this._argumentList.set(index, vArgument);
    }

    /**
     * 
     * 
     * @param vArgumentArray
     */
    public void setArgument(
            final org.hbird.transport.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentListArgument[] vArgumentArray) {
        //-- copy array
        _argumentList.clear();

        for (int i = 0; i < vArgumentArray.length; i++) {
                this._argumentList.add(vArgumentArray[i]);
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
     * org.hbird.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentList
     */
    public static org.hbird.transport.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentList unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentList) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentList.class, reader);
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
