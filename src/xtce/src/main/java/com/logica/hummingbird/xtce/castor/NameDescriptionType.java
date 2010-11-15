/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * The type definition used by most elements that require a name
 * with optional descriptions. The short description is intended to
 * be used for quick "memory jogger" descriptions of the object. 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class NameDescriptionType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name.
     */
    private java.lang.String _name;

    /**
     * It is strongly recommended that the short description be
     * kept under 80 characters in length
     */
    private java.lang.String _shortDescription;

    /**
     * The Long Description is intended to be used for explanitory
     * descriptions of the object and may include HTML markup. Long
     * Decriptions are of unbounded length
     */
    private java.lang.String _longDescription;

    /**
     * Field _aliasSet.
     */
    private com.logica.hummingbird.xtce.castor.AliasSet _aliasSet;


      //----------------/
     //- Constructors -/
    //----------------/

    public NameDescriptionType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'aliasSet'.
     * 
     * @return the value of field 'AliasSet'.
     */
    public com.logica.hummingbird.xtce.castor.AliasSet getAliasSet(
    ) {
        return this._aliasSet;
    }

    /**
     * Returns the value of field 'longDescription'. The field
     * 'longDescription' has the following description: The Long
     * Description is intended to be used for explanitory
     * descriptions of the object and may include HTML markup. Long
     * Decriptions are of unbounded length
     * 
     * @return the value of field 'LongDescription'.
     */
    public java.lang.String getLongDescription(
    ) {
        return this._longDescription;
    }

    /**
     * Returns the value of field 'name'.
     * 
     * @return the value of field 'Name'.
     */
    public java.lang.String getName(
    ) {
        return this._name;
    }

    /**
     * Returns the value of field 'shortDescription'. The field
     * 'shortDescription' has the following description: It is
     * strongly recommended that the short description be kept
     * under 80 characters in length
     * 
     * @return the value of field 'ShortDescription'.
     */
    public java.lang.String getShortDescription(
    ) {
        return this._shortDescription;
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
     * Sets the value of field 'aliasSet'.
     * 
     * @param aliasSet the value of field 'aliasSet'.
     */
    public void setAliasSet(
            final com.logica.hummingbird.xtce.castor.AliasSet aliasSet) {
        this._aliasSet = aliasSet;
    }

    /**
     * Sets the value of field 'longDescription'. The field
     * 'longDescription' has the following description: The Long
     * Description is intended to be used for explanitory
     * descriptions of the object and may include HTML markup. Long
     * Decriptions are of unbounded length
     * 
     * @param longDescription the value of field 'longDescription'.
     */
    public void setLongDescription(
            final java.lang.String longDescription) {
        this._longDescription = longDescription;
    }

    /**
     * Sets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(
            final java.lang.String name) {
        this._name = name;
    }

    /**
     * Sets the value of field 'shortDescription'. The field
     * 'shortDescription' has the following description: It is
     * strongly recommended that the short description be kept
     * under 80 characters in length
     * 
     * @param shortDescription the value of field 'shortDescription'
     */
    public void setShortDescription(
            final java.lang.String shortDescription) {
        this._shortDescription = shortDescription;
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
     * com.logica.hummingbird.xtce.castor.NameDescriptionType
     */
    public static com.logica.hummingbird.xtce.castor.NameDescriptionType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.NameDescriptionType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.NameDescriptionType.class, reader);
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
