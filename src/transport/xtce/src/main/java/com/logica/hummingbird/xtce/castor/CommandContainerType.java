/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * The Key = Command Op Code. Each MetaCommand may have one
 * CommandContainer. The sequence may now contain command fields
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CommandContainerType extends com.logica.hummingbird.xtce.castor.ContainerType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _entryList.
     */
    private com.logica.hummingbird.xtce.castor.CommandContainerTypeEntryList _entryList;

    /**
     * Field _baseContainer.
     */
    private com.logica.hummingbird.xtce.castor.CommandContainerTypeBaseContainer _baseContainer;


      //----------------/
     //- Constructors -/
    //----------------/

    public CommandContainerType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'baseContainer'.
     * 
     * @return the value of field 'BaseContainer'.
     */
    public com.logica.hummingbird.xtce.castor.CommandContainerTypeBaseContainer getBaseContainer(
    ) {
        return this._baseContainer;
    }

    /**
     * Returns the value of field 'entryList'.
     * 
     * @return the value of field 'EntryList'.
     */
    public com.logica.hummingbird.xtce.castor.CommandContainerTypeEntryList getEntryList(
    ) {
        return this._entryList;
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
     * Sets the value of field 'baseContainer'.
     * 
     * @param baseContainer the value of field 'baseContainer'.
     */
    public void setBaseContainer(
            final com.logica.hummingbird.xtce.castor.CommandContainerTypeBaseContainer baseContainer) {
        this._baseContainer = baseContainer;
    }

    /**
     * Sets the value of field 'entryList'.
     * 
     * @param entryList the value of field 'entryList'.
     */
    public void setEntryList(
            final com.logica.hummingbird.xtce.castor.CommandContainerTypeEntryList entryList) {
        this._entryList = entryList;
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
     * com.logica.hummingbird.xtce.castor.CommandContainerType
     */
    public static com.logica.hummingbird.xtce.castor.CommandContainerType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.CommandContainerType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.CommandContainerType.class, reader);
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
