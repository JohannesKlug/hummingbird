/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * A set of labled outputs are added to the
 * SimpleInputAlgorithmType
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class InputOutputAlgorithmType extends org.hbird.transport.xtce.castor.InputAlgorithmType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _thread.
     */
    private boolean _thread;

    /**
     * keeps track of state for field: _thread
     */
    private boolean _has_thread;

    /**
     * Field _outputSet.
     */
    private org.hbird.transport.xtce.castor.OutputSet _outputSet;


      //----------------/
     //- Constructors -/
    //----------------/

    public InputOutputAlgorithmType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteThread(
    ) {
        this._has_thread= false;
    }

    /**
     * Returns the value of field 'outputSet'.
     * 
     * @return the value of field 'OutputSet'.
     */
    public org.hbird.transport.xtce.castor.OutputSet getOutputSet(
    ) {
        return this._outputSet;
    }

    /**
     * Returns the value of field 'thread'.
     * 
     * @return the value of field 'Thread'.
     */
    public boolean getThread(
    ) {
        return this._thread;
    }

    /**
     * Method hasThread.
     * 
     * @return true if at least one Thread has been added
     */
    public boolean hasThread(
    ) {
        return this._has_thread;
    }

    /**
     * Returns the value of field 'thread'.
     * 
     * @return the value of field 'Thread'.
     */
    public boolean isThread(
    ) {
        return this._thread;
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
     * Sets the value of field 'outputSet'.
     * 
     * @param outputSet the value of field 'outputSet'.
     */
    public void setOutputSet(
            final org.hbird.transport.xtce.castor.OutputSet outputSet) {
        this._outputSet = outputSet;
    }

    /**
     * Sets the value of field 'thread'.
     * 
     * @param thread the value of field 'thread'.
     */
    public void setThread(
            final boolean thread) {
        this._thread = thread;
        this._has_thread = true;
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
     * org.hbird.xtce.castor.InputOutputAlgorithmType
     */
    public static org.hbird.transport.xtce.castor.InputOutputAlgorithmType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.InputOutputAlgorithmType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.InputOutputAlgorithmType.class, reader);
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
