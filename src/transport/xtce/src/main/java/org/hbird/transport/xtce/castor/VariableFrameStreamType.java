/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * For streams that contain a series of frames with a variable
 * frame length where the frames are found by looking for a series
 * of one's or zero's (usually one's). The series is called the
 * flag. in the PCM stream that are usually made to be illegal in
 * the PCM stream by zero or one bit insertion. 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class VariableFrameStreamType extends org.hbird.transport.xtce.castor.FrameStreamType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _syncStrategy.
     */
    private org.hbird.transport.xtce.castor.VariableFrameStreamTypeSyncStrategy _syncStrategy;


      //----------------/
     //- Constructors -/
    //----------------/

    public VariableFrameStreamType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'syncStrategy'.
     * 
     * @return the value of field 'SyncStrategy'.
     */
    public org.hbird.transport.xtce.castor.VariableFrameStreamTypeSyncStrategy getSyncStrategy(
    ) {
        return this._syncStrategy;
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
     * Sets the value of field 'syncStrategy'.
     * 
     * @param syncStrategy the value of field 'syncStrategy'.
     */
    public void setSyncStrategy(
            final org.hbird.transport.xtce.castor.VariableFrameStreamTypeSyncStrategy syncStrategy) {
        this._syncStrategy = syncStrategy;
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
     * org.hbird.xtce.castor.VariableFrameStreamType
     */
    public static org.hbird.transport.xtce.castor.VariableFrameStreamType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.VariableFrameStreamType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.VariableFrameStreamType.class, reader);
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
