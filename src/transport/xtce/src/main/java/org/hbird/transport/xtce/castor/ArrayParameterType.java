/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * An array type. Will be an array of parameters of the type
 * referenced in 'arrayTypeRef' and have the number of array
 * dimensions as specified in 'numberOfDimensions' 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ArrayParameterType extends org.hbird.transport.xtce.castor.NameDescriptionType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _arrayTypeRef.
     */
    private java.lang.String _arrayTypeRef;

    /**
     * Field _numberOfDimensions.
     */
    private long _numberOfDimensions;

    /**
     * keeps track of state for field: _numberOfDimensions
     */
    private boolean _has_numberOfDimensions;


      //----------------/
     //- Constructors -/
    //----------------/

    public ArrayParameterType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteNumberOfDimensions(
    ) {
        this._has_numberOfDimensions= false;
    }

    /**
     * Returns the value of field 'arrayTypeRef'.
     * 
     * @return the value of field 'ArrayTypeRef'.
     */
    public java.lang.String getArrayTypeRef(
    ) {
        return this._arrayTypeRef;
    }

    /**
     * Returns the value of field 'numberOfDimensions'.
     * 
     * @return the value of field 'NumberOfDimensions'.
     */
    public long getNumberOfDimensions(
    ) {
        return this._numberOfDimensions;
    }

    /**
     * Method hasNumberOfDimensions.
     * 
     * @return true if at least one NumberOfDimensions has been adde
     */
    public boolean hasNumberOfDimensions(
    ) {
        return this._has_numberOfDimensions;
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
     * Sets the value of field 'arrayTypeRef'.
     * 
     * @param arrayTypeRef the value of field 'arrayTypeRef'.
     */
    public void setArrayTypeRef(
            final java.lang.String arrayTypeRef) {
        this._arrayTypeRef = arrayTypeRef;
    }

    /**
     * Sets the value of field 'numberOfDimensions'.
     * 
     * @param numberOfDimensions the value of field
     * 'numberOfDimensions'.
     */
    public void setNumberOfDimensions(
            final long numberOfDimensions) {
        this._numberOfDimensions = numberOfDimensions;
        this._has_numberOfDimensions = true;
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
     * org.hbird.xtce.castor.ArrayParameterType
     */
    public static org.hbird.transport.xtce.castor.ArrayParameterType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.ArrayParameterType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.ArrayParameterType.class, reader);
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
