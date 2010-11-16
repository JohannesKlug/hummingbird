/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * Class Message.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Message extends org.hbird.transport.xtce.castor.NameDescriptionType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _matchCriteria.
     */
    private org.hbird.transport.xtce.castor.MatchCriteria _matchCriteria;

    /**
     * The ContainerRef should point to ROOT container that will
     * describe an entire packet/minor frame or chunk of telemetry.
     */
    private org.hbird.transport.xtce.castor.ContainRef _containRef;


      //----------------/
     //- Constructors -/
    //----------------/

    public Message() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'containRef'. The field
     * 'containRef' has the following description: The ContainerRef
     * should point to ROOT container that will describe an entire
     * packet/minor frame or chunk of telemetry.
     * 
     * @return the value of field 'ContainRef'.
     */
    public org.hbird.transport.xtce.castor.ContainRef getContainRef(
    ) {
        return this._containRef;
    }

    /**
     * Returns the value of field 'matchCriteria'.
     * 
     * @return the value of field 'MatchCriteria'.
     */
    public org.hbird.transport.xtce.castor.MatchCriteria getMatchCriteria(
    ) {
        return this._matchCriteria;
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
     * Sets the value of field 'containRef'. The field 'containRef'
     * has the following description: The ContainerRef should point
     * to ROOT container that will describe an entire packet/minor
     * frame or chunk of telemetry.
     * 
     * @param containRef the value of field 'containRef'.
     */
    public void setContainRef(
            final org.hbird.transport.xtce.castor.ContainRef containRef) {
        this._containRef = containRef;
    }

    /**
     * Sets the value of field 'matchCriteria'.
     * 
     * @param matchCriteria the value of field 'matchCriteria'.
     */
    public void setMatchCriteria(
            final org.hbird.transport.xtce.castor.MatchCriteria matchCriteria) {
        this._matchCriteria = matchCriteria;
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
     * org.hbird.xtce.castor.Message
     */
    public static org.hbird.transport.xtce.castor.Message unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.Message) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.Message.class, reader);
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
