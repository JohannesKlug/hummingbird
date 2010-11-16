/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * This is the external algorithm. Multiple entries are provided so
 * that the same database may be used for multiple implementation s
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ExternalAlgorithm implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _implementationName.
     */
    private java.lang.String _implementationName;

    /**
     * Field _algorithmLocation.
     */
    private java.lang.String _algorithmLocation;


      //----------------/
     //- Constructors -/
    //----------------/

    public ExternalAlgorithm() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'algorithmLocation'.
     * 
     * @return the value of field 'AlgorithmLocation'.
     */
    public java.lang.String getAlgorithmLocation(
    ) {
        return this._algorithmLocation;
    }

    /**
     * Returns the value of field 'implementationName'.
     * 
     * @return the value of field 'ImplementationName'.
     */
    public java.lang.String getImplementationName(
    ) {
        return this._implementationName;
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
     * Sets the value of field 'algorithmLocation'.
     * 
     * @param algorithmLocation the value of field
     * 'algorithmLocation'.
     */
    public void setAlgorithmLocation(
            final java.lang.String algorithmLocation) {
        this._algorithmLocation = algorithmLocation;
    }

    /**
     * Sets the value of field 'implementationName'.
     * 
     * @param implementationName the value of field
     * 'implementationName'.
     */
    public void setImplementationName(
            final java.lang.String implementationName) {
        this._implementationName = implementationName;
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
     * org.hbird.xtce.castor.ExternalAlgorithm
     */
    public static org.hbird.transport.xtce.castor.ExternalAlgorithm unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.ExternalAlgorithm) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.ExternalAlgorithm.class, reader);
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
