/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * An Interlock is a type of Constraint, but not on Command
 * instances of this MetaCommand; Interlocks apply instead to the
 * next command. An Interlock will block successive commands until
 * this command has reached a certain stage (through
 * verifications). Interlocks are scoped to a SpaceSystem basis.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Interlock implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The name of a SpaceSystem this Interlock applies to. By
     * default, it only applies to the SpaceSystem that contains
     * this MetaCommand.
     */
    private java.lang.String _scopeToSpaceSystem;

    /**
     * Field _verificationToWaitFor.
     */
    private com.logica.hummingbird.xtce.castor.types.InterlockVerificationToWaitForType _verificationToWaitFor = com.logica.hummingbird.xtce.castor.types.InterlockVerificationToWaitForType.fromValue("complete");

    /**
     * Only applies when the verificationToWaitFor attribute is
     * 'queued' or 'executing'.
     */
    private java.math.BigDecimal _verificationProgressPercentage;

    /**
     * A flag that indicates that under special circumstances, this
     * Interlock can be suspended.
     */
    private boolean _suspendable = false;

    /**
     * keeps track of state for field: _suspendable
     */
    private boolean _has_suspendable;


      //----------------/
     //- Constructors -/
    //----------------/

    public Interlock() {
        super();
        setVerificationToWaitFor(com.logica.hummingbird.xtce.castor.types.InterlockVerificationToWaitForType.fromValue("complete"));
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
     * Returns the value of field 'scopeToSpaceSystem'. The field
     * 'scopeToSpaceSystem' has the following description: The name
     * of a SpaceSystem this Interlock applies to. By default, it
     * only applies to the SpaceSystem that contains this
     * MetaCommand.
     * 
     * @return the value of field 'ScopeToSpaceSystem'.
     */
    public java.lang.String getScopeToSpaceSystem(
    ) {
        return this._scopeToSpaceSystem;
    }

    /**
     * Returns the value of field 'suspendable'. The field
     * 'suspendable' has the following description: A flag that
     * indicates that under special circumstances, this Interlock
     * can be suspended.
     * 
     * @return the value of field 'Suspendable'.
     */
    public boolean getSuspendable(
    ) {
        return this._suspendable;
    }

    /**
     * Returns the value of field 'verificationProgressPercentage'.
     * The field 'verificationProgressPercentage' has the following
     * description: Only applies when the verificationToWaitFor
     * attribute is 'queued' or 'executing'.
     * 
     * @return the value of field 'VerificationProgressPercentage'.
     */
    public java.math.BigDecimal getVerificationProgressPercentage(
    ) {
        return this._verificationProgressPercentage;
    }

    /**
     * Returns the value of field 'verificationToWaitFor'.
     * 
     * @return the value of field 'VerificationToWaitFor'.
     */
    public com.logica.hummingbird.xtce.castor.types.InterlockVerificationToWaitForType getVerificationToWaitFor(
    ) {
        return this._verificationToWaitFor;
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
     * 'suspendable' has the following description: A flag that
     * indicates that under special circumstances, this Interlock
     * can be suspended.
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
     * Sets the value of field 'scopeToSpaceSystem'. The field
     * 'scopeToSpaceSystem' has the following description: The name
     * of a SpaceSystem this Interlock applies to. By default, it
     * only applies to the SpaceSystem that contains this
     * MetaCommand.
     * 
     * @param scopeToSpaceSystem the value of field
     * 'scopeToSpaceSystem'.
     */
    public void setScopeToSpaceSystem(
            final java.lang.String scopeToSpaceSystem) {
        this._scopeToSpaceSystem = scopeToSpaceSystem;
    }

    /**
     * Sets the value of field 'suspendable'. The field
     * 'suspendable' has the following description: A flag that
     * indicates that under special circumstances, this Interlock
     * can be suspended.
     * 
     * @param suspendable the value of field 'suspendable'.
     */
    public void setSuspendable(
            final boolean suspendable) {
        this._suspendable = suspendable;
        this._has_suspendable = true;
    }

    /**
     * Sets the value of field 'verificationProgressPercentage'.
     * The field 'verificationProgressPercentage' has the following
     * description: Only applies when the verificationToWaitFor
     * attribute is 'queued' or 'executing'.
     * 
     * @param verificationProgressPercentage the value of field
     * 'verificationProgressPercentage'.
     */
    public void setVerificationProgressPercentage(
            final java.math.BigDecimal verificationProgressPercentage) {
        this._verificationProgressPercentage = verificationProgressPercentage;
    }

    /**
     * Sets the value of field 'verificationToWaitFor'.
     * 
     * @param verificationToWaitFor the value of field
     * 'verificationToWaitFor'.
     */
    public void setVerificationToWaitFor(
            final com.logica.hummingbird.xtce.castor.types.InterlockVerificationToWaitForType verificationToWaitFor) {
        this._verificationToWaitFor = verificationToWaitFor;
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
     * com.logica.hummingbird.xtce.castor.Interlock
     */
    public static com.logica.hummingbird.xtce.castor.Interlock unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.Interlock) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.Interlock.class, reader);
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
