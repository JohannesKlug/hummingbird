/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * The simplest form of algorithm, a SimpleAlgorithmType contains
 * an area for a free-form pseudo code description of the algorithm
 * plus a Set of references to external algorithms. External
 * algorithms are usually unique to a ground system type. Multiple
 * external algorithms are possible because XTCE documents may be
 * used across multiple ground systems.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SimpleAlgorithmType extends com.logica.hummingbird.xtce.castor.NameDescriptionType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * This optional element may be used to enter Pseudo or actual
     * code for the algorithm. The language for the algorithm is
     * specified with the language attribute
     */
    private com.logica.hummingbird.xtce.castor.AlgorithmText _algorithmText;

    /**
     * Field _externalAlgorithmSet.
     */
    private com.logica.hummingbird.xtce.castor.ExternalAlgorithmSet _externalAlgorithmSet;


      //----------------/
     //- Constructors -/
    //----------------/

    public SimpleAlgorithmType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'algorithmText'. The field
     * 'algorithmText' has the following description: This optional
     * element may be used to enter Pseudo or actual code for the
     * algorithm. The language for the algorithm is specified with
     * the language attribute
     * 
     * @return the value of field 'AlgorithmText'.
     */
    public com.logica.hummingbird.xtce.castor.AlgorithmText getAlgorithmText(
    ) {
        return this._algorithmText;
    }

    /**
     * Returns the value of field 'externalAlgorithmSet'.
     * 
     * @return the value of field 'ExternalAlgorithmSet'.
     */
    public com.logica.hummingbird.xtce.castor.ExternalAlgorithmSet getExternalAlgorithmSet(
    ) {
        return this._externalAlgorithmSet;
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
     * Sets the value of field 'algorithmText'. The field
     * 'algorithmText' has the following description: This optional
     * element may be used to enter Pseudo or actual code for the
     * algorithm. The language for the algorithm is specified with
     * the language attribute
     * 
     * @param algorithmText the value of field 'algorithmText'.
     */
    public void setAlgorithmText(
            final com.logica.hummingbird.xtce.castor.AlgorithmText algorithmText) {
        this._algorithmText = algorithmText;
    }

    /**
     * Sets the value of field 'externalAlgorithmSet'.
     * 
     * @param externalAlgorithmSet the value of field
     * 'externalAlgorithmSet'.
     */
    public void setExternalAlgorithmSet(
            final com.logica.hummingbird.xtce.castor.ExternalAlgorithmSet externalAlgorithmSet) {
        this._externalAlgorithmSet = externalAlgorithmSet;
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
     * com.logica.hummingbird.xtce.castor.SimpleAlgorithmType
     */
    public static com.logica.hummingbird.xtce.castor.SimpleAlgorithmType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.SimpleAlgorithmType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.SimpleAlgorithmType.class, reader);
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
