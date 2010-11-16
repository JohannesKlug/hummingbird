/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * Class MetaCommandStepList.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class MetaCommandStepList implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _metaCommandStepList.
     */
    private java.util.List<org.hbird.transport.xtce.castor.MetaCommandStep> _metaCommandStepList;


      //----------------/
     //- Constructors -/
    //----------------/

    public MetaCommandStepList() {
        super();
        this._metaCommandStepList = new java.util.ArrayList<org.hbird.transport.xtce.castor.MetaCommandStep>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vMetaCommandStep
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addMetaCommandStep(
            final org.hbird.transport.xtce.castor.MetaCommandStep vMetaCommandStep)
    throws java.lang.IndexOutOfBoundsException {
        this._metaCommandStepList.add(vMetaCommandStep);
    }

    /**
     * 
     * 
     * @param index
     * @param vMetaCommandStep
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addMetaCommandStep(
            final int index,
            final org.hbird.transport.xtce.castor.MetaCommandStep vMetaCommandStep)
    throws java.lang.IndexOutOfBoundsException {
        this._metaCommandStepList.add(index, vMetaCommandStep);
    }

    /**
     * Method enumerateMetaCommandStep.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends org.hbird.transport.xtce.castor.MetaCommandStep> enumerateMetaCommandStep(
    ) {
        return java.util.Collections.enumeration(this._metaCommandStepList);
    }

    /**
     * Method getMetaCommandStep.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.hbird.xtce.castor.MetaCommandStep at the
     * given index
     */
    public org.hbird.transport.xtce.castor.MetaCommandStep getMetaCommandStep(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._metaCommandStepList.size()) {
            throw new IndexOutOfBoundsException("getMetaCommandStep: Index value '" + index + "' not in range [0.." + (this._metaCommandStepList.size() - 1) + "]");
        }

        return (org.hbird.transport.xtce.castor.MetaCommandStep) _metaCommandStepList.get(index);
    }

    /**
     * Method getMetaCommandStep.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.hbird.transport.xtce.castor.MetaCommandStep[] getMetaCommandStep(
    ) {
        org.hbird.transport.xtce.castor.MetaCommandStep[] array = new org.hbird.transport.xtce.castor.MetaCommandStep[0];
        return (org.hbird.transport.xtce.castor.MetaCommandStep[]) this._metaCommandStepList.toArray(array);
    }

    /**
     * Method getMetaCommandStepCount.
     * 
     * @return the size of this collection
     */
    public int getMetaCommandStepCount(
    ) {
        return this._metaCommandStepList.size();
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
     * Method iterateMetaCommandStep.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends org.hbird.transport.xtce.castor.MetaCommandStep> iterateMetaCommandStep(
    ) {
        return this._metaCommandStepList.iterator();
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
    public void removeAllMetaCommandStep(
    ) {
        this._metaCommandStepList.clear();
    }

    /**
     * Method removeMetaCommandStep.
     * 
     * @param vMetaCommandStep
     * @return true if the object was removed from the collection.
     */
    public boolean removeMetaCommandStep(
            final org.hbird.transport.xtce.castor.MetaCommandStep vMetaCommandStep) {
        boolean removed = _metaCommandStepList.remove(vMetaCommandStep);
        return removed;
    }

    /**
     * Method removeMetaCommandStepAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.hbird.transport.xtce.castor.MetaCommandStep removeMetaCommandStepAt(
            final int index) {
        java.lang.Object obj = this._metaCommandStepList.remove(index);
        return (org.hbird.transport.xtce.castor.MetaCommandStep) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vMetaCommandStep
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setMetaCommandStep(
            final int index,
            final org.hbird.transport.xtce.castor.MetaCommandStep vMetaCommandStep)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._metaCommandStepList.size()) {
            throw new IndexOutOfBoundsException("setMetaCommandStep: Index value '" + index + "' not in range [0.." + (this._metaCommandStepList.size() - 1) + "]");
        }

        this._metaCommandStepList.set(index, vMetaCommandStep);
    }

    /**
     * 
     * 
     * @param vMetaCommandStepArray
     */
    public void setMetaCommandStep(
            final org.hbird.transport.xtce.castor.MetaCommandStep[] vMetaCommandStepArray) {
        //-- copy array
        _metaCommandStepList.clear();

        for (int i = 0; i < vMetaCommandStepArray.length; i++) {
                this._metaCommandStepList.add(vMetaCommandStepArray[i]);
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
     * org.hbird.xtce.castor.MetaCommandStepList
     */
    public static org.hbird.transport.xtce.castor.MetaCommandStepList unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.MetaCommandStepList) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.MetaCommandStepList.class, reader);
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
