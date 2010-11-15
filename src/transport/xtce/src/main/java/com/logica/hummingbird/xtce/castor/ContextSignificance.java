/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * Class ContextSignificance.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ContextSignificance implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _contextMatch.
     */
    private org.hbird.xtce.castor.ContextMatch _contextMatch;

    /**
     * Field _significance.
     */
    private org.hbird.xtce.castor.Significance _significance;


      //----------------/
     //- Constructors -/
    //----------------/

    public ContextSignificance() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'contextMatch'.
     * 
     * @return the value of field 'ContextMatch'.
     */
    public org.hbird.xtce.castor.ContextMatch getContextMatch(
    ) {
        return this._contextMatch;
    }

    /**
     * Returns the value of field 'significance'.
     * 
     * @return the value of field 'Significance'.
     */
    public org.hbird.xtce.castor.Significance getSignificance(
    ) {
        return this._significance;
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
     * Sets the value of field 'contextMatch'.
     * 
     * @param contextMatch the value of field 'contextMatch'.
     */
    public void setContextMatch(
            final org.hbird.xtce.castor.ContextMatch contextMatch) {
        this._contextMatch = contextMatch;
    }

    /**
     * Sets the value of field 'significance'.
     * 
     * @param significance the value of field 'significance'.
     */
    public void setSignificance(
            final org.hbird.xtce.castor.Significance significance) {
        this._significance = significance;
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
     * org.hbird.xtce.castor.ContextSignificance
     */
    public static org.hbird.xtce.castor.ContextSignificance unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.ContextSignificance) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.ContextSignificance.class, reader);
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
