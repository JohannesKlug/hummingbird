/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * A verifier that indicates that the command is being executed. An
 * optional Element indicates how far along the command has
 * progressed either as a fixed value or an (possibly scaled)
 * ParameterInstance value.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ExecutionVerifier extends org.hbird.transport.xtce.castor.CommandVerifierType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _percentComplete.
     */
    private org.hbird.transport.xtce.castor.PercentComplete _percentComplete;


      //----------------/
     //- Constructors -/
    //----------------/

    public ExecutionVerifier() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'percentComplete'.
     * 
     * @return the value of field 'PercentComplete'.
     */
    public org.hbird.transport.xtce.castor.PercentComplete getPercentComplete(
    ) {
        return this._percentComplete;
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
     * Sets the value of field 'percentComplete'.
     * 
     * @param percentComplete the value of field 'percentComplete'.
     */
    public void setPercentComplete(
            final org.hbird.transport.xtce.castor.PercentComplete percentComplete) {
        this._percentComplete = percentComplete;
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
     * org.hbird.xtce.castor.ExecutionVerifier
     */
    public static org.hbird.transport.xtce.castor.ExecutionVerifier unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.ExecutionVerifier) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.ExecutionVerifier.class, reader);
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
