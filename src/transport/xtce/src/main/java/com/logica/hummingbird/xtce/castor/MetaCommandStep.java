/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * Class MetaCommandStep.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class MetaCommandStep implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _metaCommandRef.
     */
    private java.lang.String _metaCommandRef;

    /**
     * Field _argumentList.
     */
    private org.hbird.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentList _argumentList;


      //----------------/
     //- Constructors -/
    //----------------/

    public MetaCommandStep() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'argumentList'.
     * 
     * @return the value of field 'ArgumentList'.
     */
    public org.hbird.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentList getArgumentList(
    ) {
        return this._argumentList;
    }

    /**
     * Returns the value of field 'metaCommandRef'.
     * 
     * @return the value of field 'MetaCommandRef'.
     */
    public java.lang.String getMetaCommandRef(
    ) {
        return this._metaCommandRef;
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
     * Sets the value of field 'argumentList'.
     * 
     * @param argumentList the value of field 'argumentList'.
     */
    public void setArgumentList(
            final org.hbird.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentList argumentList) {
        this._argumentList = argumentList;
    }

    /**
     * Sets the value of field 'metaCommandRef'.
     * 
     * @param metaCommandRef the value of field 'metaCommandRef'.
     */
    public void setMetaCommandRef(
            final java.lang.String metaCommandRef) {
        this._metaCommandRef = metaCommandRef;
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
     * org.hbird.xtce.castor.MetaCommandStep
     */
    public static org.hbird.xtce.castor.MetaCommandStep unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.MetaCommandStep) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.MetaCommandStep.class, reader);
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
