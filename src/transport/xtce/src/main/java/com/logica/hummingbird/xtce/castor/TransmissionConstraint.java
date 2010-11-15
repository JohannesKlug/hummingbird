/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * A CommandTransmission constraint is used to check that the
 * command can be run in the current operating mode and may block
 * the transmission of the command if the constraint condition is
 * true.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class TransmissionConstraint extends org.hbird.xtce.castor.MatchCriteriaType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Pause during timeOut, fail when the timeout passes
     */
    private org.exolab.castor.types.Duration _timeOut;

    /**
     * Indicates whether the contraints for a Command may be
     * suspended.
     */
    private boolean _suspendable = false;

    /**
     * keeps track of state for field: _suspendable
     */
    private boolean _has_suspendable;


      //----------------/
     //- Constructors -/
    //----------------/

    public TransmissionConstraint() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteSuspendable(
    ) {
        this._has_suspendable= false;
    }

    /**
     * Returns the value of field 'suspendable'. The field
     * 'suspendable' has the following description: Indicates
     * whether the contraints for a Command may be suspended.
     * 
     * @return the value of field 'Suspendable'.
     */
    public boolean getSuspendable(
    ) {
        return this._suspendable;
    }

    /**
     * Returns the value of field 'timeOut'. The field 'timeOut'
     * has the following description: Pause during timeOut, fail
     * when the timeout passes
     * 
     * @return the value of field 'TimeOut'.
     */
    public org.exolab.castor.types.Duration getTimeOut(
    ) {
        return this._timeOut;
    }

    /**
     * Method hasSuspendable.
     * 
     * @return true if at least one Suspendable has been added
     */
    public boolean hasSuspendable(
    ) {
        return this._has_suspendable;
    }

    /**
     * Returns the value of field 'suspendable'. The field
     * 'suspendable' has the following description: Indicates
     * whether the contraints for a Command may be suspended.
     * 
     * @return the value of field 'Suspendable'.
     */
    public boolean isSuspendable(
    ) {
        return this._suspendable;
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
     * Sets the value of field 'suspendable'. The field
     * 'suspendable' has the following description: Indicates
     * whether the contraints for a Command may be suspended.
     * 
     * @param suspendable the value of field 'suspendable'.
     */
    public void setSuspendable(
            final boolean suspendable) {
        this._suspendable = suspendable;
        this._has_suspendable = true;
    }

    /**
     * Sets the value of field 'timeOut'. The field 'timeOut' has
     * the following description: Pause during timeOut, fail when
     * the timeout passes
     * 
     * @param timeOut the value of field 'timeOut'.
     */
    public void setTimeOut(
            final org.exolab.castor.types.Duration timeOut) {
        this._timeOut = timeOut;
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
     * org.hbird.xtce.castor.TransmissionConstraint
     */
    public static org.hbird.xtce.castor.TransmissionConstraint unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.TransmissionConstraint) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.TransmissionConstraint.class, reader);
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
