/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * Used to look for relative change in a Parameter value. Only
 * usefull for numeric Parameters
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ParameterValueChange implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _parameterRef.
     */
    private org.hbird.transport.xtce.castor.ParameterRef _parameterRef;

    /**
     * Field _change.
     */
    private org.hbird.transport.xtce.castor.Change _change;


      //----------------/
     //- Constructors -/
    //----------------/

    public ParameterValueChange() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'change'.
     * 
     * @return the value of field 'Change'.
     */
    public org.hbird.transport.xtce.castor.Change getChange(
    ) {
        return this._change;
    }

    /**
     * Returns the value of field 'parameterRef'.
     * 
     * @return the value of field 'ParameterRef'.
     */
    public org.hbird.transport.xtce.castor.ParameterRef getParameterRef(
    ) {
        return this._parameterRef;
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
     * Sets the value of field 'change'.
     * 
     * @param change the value of field 'change'.
     */
    public void setChange(
            final org.hbird.transport.xtce.castor.Change change) {
        this._change = change;
    }

    /**
     * Sets the value of field 'parameterRef'.
     * 
     * @param parameterRef the value of field 'parameterRef'.
     */
    public void setParameterRef(
            final org.hbird.transport.xtce.castor.ParameterRef parameterRef) {
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
     * org.hbird.xtce.castor.ParameterValueChange
     */
    public static org.hbird.transport.xtce.castor.ParameterValueChange unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.ParameterValueChange) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.ParameterValueChange.class, reader);
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
