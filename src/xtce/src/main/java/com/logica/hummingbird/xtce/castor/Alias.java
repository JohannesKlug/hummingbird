/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Used to contain an alias (alternate) name or ID for the the
 * object. For example, a parameter may have a mnemonic, an
 * on-board id, and special IDs used by various ground software
 * applications; all of these are alias's. Some ground system
 * processing equipent has some severe naming restrictions on
 * parameters (e.g., names must less then 12 characters, single
 * case or integral id's only); their alias's provide a means of
 * capturing each name in a "nameSpace".
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Alias implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _nameSpace.
     */
    private java.lang.String _nameSpace;

    /**
     * Field _alias.
     */
    private java.lang.String _alias;


      //----------------/
     //- Constructors -/
    //----------------/

    public Alias() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'alias'.
     * 
     * @return the value of field 'Alias'.
     */
    public java.lang.String getAlias(
    ) {
        return this._alias;
    }

    /**
     * Returns the value of field 'nameSpace'.
     * 
     * @return the value of field 'NameSpace'.
     */
    public java.lang.String getNameSpace(
    ) {
        return this._nameSpace;
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
     * Sets the value of field 'alias'.
     * 
     * @param alias the value of field 'alias'.
     */
    public void setAlias(
            final java.lang.String alias) {
        this._alias = alias;
    }

    /**
     * Sets the value of field 'nameSpace'.
     * 
     * @param nameSpace the value of field 'nameSpace'.
     */
    public void setNameSpace(
            final java.lang.String nameSpace) {
        this._nameSpace = nameSpace;
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
     * com.logica.hummingbird.xtce.castor.Alias
     */
    public static com.logica.hummingbird.xtce.castor.Alias unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.Alias) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.Alias.class, reader);
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
