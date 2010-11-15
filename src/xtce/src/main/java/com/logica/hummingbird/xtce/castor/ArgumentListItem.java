/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Class ArgumentListItem.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ArgumentListItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _argumentList.
     */
    private java.util.List<com.logica.hummingbird.xtce.castor.Argument> _argumentList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ArgumentListItem() {
        super();
        this._argumentList = new java.util.ArrayList<com.logica.hummingbird.xtce.castor.Argument>();
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
            final com.logica.hummingbird.xtce.castor.Argument vArgument)
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
            final com.logica.hummingbird.xtce.castor.Argument vArgument)
    throws java.lang.IndexOutOfBoundsException {
        this._argumentList.add(index, vArgument);
    }

    /**
     * Method enumerateArgument.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends com.logica.hummingbird.xtce.castor.Argument> enumerateArgument(
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
     * com.logica.hummingbird.xtce.castor.Argument at the given inde
     */
    public com.logica.hummingbird.xtce.castor.Argument getArgument(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._argumentList.size()) {
            throw new IndexOutOfBoundsException("getArgument: Index value '" + index + "' not in range [0.." + (this._argumentList.size() - 1) + "]");
        }

        return (com.logica.hummingbird.xtce.castor.Argument) _argumentList.get(index);
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
    public com.logica.hummingbird.xtce.castor.Argument[] getArgument(
    ) {
        com.logica.hummingbird.xtce.castor.Argument[] array = new com.logica.hummingbird.xtce.castor.Argument[0];
        return (com.logica.hummingbird.xtce.castor.Argument[]) this._argumentList.toArray(array);
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
     * Returns the value of field 'choiceValue'. The field
     * 'choiceValue' has the following description: Internal choice
     * value storage
     * 
     * @return the value of field 'ChoiceValue'.
     */
    public java.lang.Object getChoiceValue(
    ) {
        return this._choiceValue;
    }

    /**
     * Method iterateArgument.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends com.logica.hummingbird.xtce.castor.Argument> iterateArgument(
    ) {
        return this._argumentList.iterator();
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
            final com.logica.hummingbird.xtce.castor.Argument vArgument) {
        boolean removed = _argumentList.remove(vArgument);
        return removed;
    }

    /**
     * Method removeArgumentAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public com.logica.hummingbird.xtce.castor.Argument removeArgumentAt(
            final int index) {
        java.lang.Object obj = this._argumentList.remove(index);
        return (com.logica.hummingbird.xtce.castor.Argument) obj;
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
            final com.logica.hummingbird.xtce.castor.Argument vArgument)
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
            final com.logica.hummingbird.xtce.castor.Argument[] vArgumentArray) {
        //-- copy array
        _argumentList.clear();

        for (int i = 0; i < vArgumentArray.length; i++) {
                this._argumentList.add(vArgumentArray[i]);
        }
    }

}
