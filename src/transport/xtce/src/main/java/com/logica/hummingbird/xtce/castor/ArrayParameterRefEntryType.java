/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * An entry that is an array parameter. This entry is somewhat
 * special because the entry may represent only a part of the Array
 * and it's important to decribe which diminsions of the array come
 * first in the sequence as well as the size of the array.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ArrayParameterRefEntryType extends com.logica.hummingbird.xtce.castor.SequenceEntryType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _parameterRef.
     */
    private java.lang.String _parameterRef;

    /**
     * Field _lastEntryForThisArrayInstance.
     */
    private boolean _lastEntryForThisArrayInstance = false;

    /**
     * keeps track of state for field: _lastEntryForThisArrayInstanc
     */
    private boolean _has_lastEntryForThisArrayInstance;

    /**
     * Where the Dimension list is in this form:
     * Array[1stDim][2ndDim][lastDim]. The last dimension is
     * assumed to be the least significant - that is this dimension
     * will cycle through it's combination before the next to last
     * dimension changes. The order MUST ascend or the array will
     * need to be broken out entry by entry. 
     */
    private com.logica.hummingbird.xtce.castor.DimensionList _dimensionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ArrayParameterRefEntryType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteLastEntryForThisArrayInstance(
    ) {
        this._has_lastEntryForThisArrayInstance= false;
    }

    /**
     * Returns the value of field 'dimensionList'. The field
     * 'dimensionList' has the following description: Where the
     * Dimension list is in this form:
     * Array[1stDim][2ndDim][lastDim]. The last dimension is
     * assumed to be the least significant - that is this dimension
     * will cycle through it's combination before the next to last
     * dimension changes. The order MUST ascend or the array will
     * need to be broken out entry by entry. 
     * 
     * @return the value of field 'DimensionList'.
     */
    public com.logica.hummingbird.xtce.castor.DimensionList getDimensionList(
    ) {
        return this._dimensionList;
    }

    /**
     * Returns the value of field 'lastEntryForThisArrayInstance'.
     * 
     * @return the value of field 'LastEntryForThisArrayInstance'.
     */
    public boolean getLastEntryForThisArrayInstance(
    ) {
        return this._lastEntryForThisArrayInstance;
    }

    /**
     * Returns the value of field 'parameterRef'.
     * 
     * @return the value of field 'ParameterRef'.
     */
    public java.lang.String getParameterRef(
    ) {
        return this._parameterRef;
    }

    /**
     * Method hasLastEntryForThisArrayInstance.
     * 
     * @return true if at least one LastEntryForThisArrayInstance
     * has been added
     */
    public boolean hasLastEntryForThisArrayInstance(
    ) {
        return this._has_lastEntryForThisArrayInstance;
    }

    /**
     * Returns the value of field 'lastEntryForThisArrayInstance'.
     * 
     * @return the value of field 'LastEntryForThisArrayInstance'.
     */
    public boolean isLastEntryForThisArrayInstance(
    ) {
        return this._lastEntryForThisArrayInstance;
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
     * Sets the value of field 'dimensionList'. The field
     * 'dimensionList' has the following description: Where the
     * Dimension list is in this form:
     * Array[1stDim][2ndDim][lastDim]. The last dimension is
     * assumed to be the least significant - that is this dimension
     * will cycle through it's combination before the next to last
     * dimension changes. The order MUST ascend or the array will
     * need to be broken out entry by entry. 
     * 
     * @param dimensionList the value of field 'dimensionList'.
     */
    public void setDimensionList(
            final com.logica.hummingbird.xtce.castor.DimensionList dimensionList) {
        this._dimensionList = dimensionList;
    }

    /**
     * Sets the value of field 'lastEntryForThisArrayInstance'.
     * 
     * @param lastEntryForThisArrayInstance the value of field
     * 'lastEntryForThisArrayInstance'.
     */
    public void setLastEntryForThisArrayInstance(
            final boolean lastEntryForThisArrayInstance) {
        this._lastEntryForThisArrayInstance = lastEntryForThisArrayInstance;
        this._has_lastEntryForThisArrayInstance = true;
    }

    /**
     * Sets the value of field 'parameterRef'.
     * 
     * @param parameterRef the value of field 'parameterRef'.
     */
    public void setParameterRef(
            final java.lang.String parameterRef) {
        this._parameterRef = parameterRef;
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
     * com.logica.hummingbird.xtce.castor.ArrayParameterRefEntryType
     */
    public static com.logica.hummingbird.xtce.castor.ArrayParameterRefEntryType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.ArrayParameterRefEntryType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.ArrayParameterRefEntryType.class, reader);
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
