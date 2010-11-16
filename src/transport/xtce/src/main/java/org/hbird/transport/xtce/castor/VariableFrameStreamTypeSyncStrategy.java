/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * Class SyncStrategy.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class VariableFrameStreamTypeSyncStrategy extends org.hbird.transport.xtce.castor.SyncStrategyType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The pattern of bits used to look for frame synchronization.
     */
    private org.hbird.transport.xtce.castor.Flag _flag;


      //----------------/
     //- Constructors -/
    //----------------/

    public VariableFrameStreamTypeSyncStrategy() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'flag'. The field 'flag' has the
     * following description: The pattern of bits used to look for
     * frame synchronization.
     * 
     * @return the value of field 'Flag'.
     */
    public org.hbird.transport.xtce.castor.Flag getFlag(
    ) {
        return this._flag;
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
     * Sets the value of field 'flag'. The field 'flag' has the
     * following description: The pattern of bits used to look for
     * frame synchronization.
     * 
     * @param flag the value of field 'flag'.
     */
    public void setFlag(
            final org.hbird.transport.xtce.castor.Flag flag) {
        this._flag = flag;
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
     * org.hbird.xtce.castor.VariableFrameStreamTypeSyncStrategy
     */
    public static org.hbird.transport.xtce.castor.VariableFrameStreamTypeSyncStrategy unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.VariableFrameStreamTypeSyncStrategy) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.VariableFrameStreamTypeSyncStrategy.class, reader);
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
