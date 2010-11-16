/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * Class ArgumementArrayType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ArgumementArrayType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _arrayType.
     */
    private java.lang.String _arrayType;

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

    public ArgumementArrayType() {
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
     * Returns the value of field 'arrayType'.
     * 
     * @return the value of field 'ArrayType'.
     */
    public java.lang.String getArrayType(
    ) {
        return this._arrayType;
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
     * Sets the value of field 'arrayType'.
     * 
     * @param arrayType the value of field 'arrayType'.
     */
    public void setArrayType(
            final java.lang.String arrayType) {
        this._arrayType = arrayType;
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
     * org.hbird.xtce.castor.ArgumementArrayType
     */
    public static org.hbird.transport.xtce.castor.ArgumementArrayType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.ArgumementArrayType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.ArgumementArrayType.class, reader);
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
