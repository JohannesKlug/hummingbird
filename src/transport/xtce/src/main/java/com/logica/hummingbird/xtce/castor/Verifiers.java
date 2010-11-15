/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * A Command Verifier is a conditional check on the telemetry from
 * a SpaceSystem that provides positive indication on the
 * successful execution of a command. Completed verifiers are added
 * to the Base MetaCommand verifiers. All others will replace a
 * verifier defined in a Base MetaCommand.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Verifiers implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Transferred to range means the command has been received by
     * a the network that connects the ground system to the
     * spacecraft. Obviously, this verifier must come from
     * something other than the spacecraft. 
     */
    private org.hbird.xtce.castor.TransferredToRangeVerifier _transferredToRangeVerifier;

    /**
     * Sent from range means the command has been transmitted to
     * the spacecraft by a the network that connects the ground
     * system to the spacecraft. Obviously, this verifier must come
     * from something other than the spacecraft. 
     */
    private org.hbird.xtce.castor.SentFromRangeVerifier _sentFromRangeVerifier;

    /**
     * A verifier that simply means the SpaceSystem has received
     * the command.
     */
    private org.hbird.xtce.castor.ReceivedVerifier _receivedVerifier;

    /**
     * A verifier that means the SpaceSystem has accepted the comman
     */
    private org.hbird.xtce.castor.AcceptedVerifier _acceptedVerifier;

    /**
     * A verifyer that means the command is scheduled for execution
     * by the SpaceSystem.
     */
    private org.hbird.xtce.castor.QueuedVerifier _queuedVerifier;

    /**
     * A verifier that indicates that the command is being
     * executed. An optional Element indicates how far along the
     * command has progressed either as a fixed value or an
     * (possibly scaled) ParameterInstance value.
     */
    private org.hbird.xtce.castor.ExecutionVerifier _executionVerifier;

    /**
     * A possible set of verifiers that all must be true for the
     * command be considered completed. 
     */
    private java.util.List<org.hbird.xtce.castor.CompleteVerifier> _completeVerifierList;

    /**
     * When true, indicates that the command failed. timeToWait is
     * how long to wait for the FailedVerifier to test true.
     */
    private org.hbird.xtce.castor.FailedVerifier _failedVerifier;


      //----------------/
     //- Constructors -/
    //----------------/

    public Verifiers() {
        super();
        this._completeVerifierList = new java.util.ArrayList<org.hbird.xtce.castor.CompleteVerifier>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vCompleteVerifier
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCompleteVerifier(
            final org.hbird.xtce.castor.CompleteVerifier vCompleteVerifier)
    throws java.lang.IndexOutOfBoundsException {
        this._completeVerifierList.add(vCompleteVerifier);
    }

    /**
     * 
     * 
     * @param index
     * @param vCompleteVerifier
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCompleteVerifier(
            final int index,
            final org.hbird.xtce.castor.CompleteVerifier vCompleteVerifier)
    throws java.lang.IndexOutOfBoundsException {
        this._completeVerifierList.add(index, vCompleteVerifier);
    }

    /**
     * Method enumerateCompleteVerifier.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends org.hbird.xtce.castor.CompleteVerifier> enumerateCompleteVerifier(
    ) {
        return java.util.Collections.enumeration(this._completeVerifierList);
    }

    /**
     * Returns the value of field 'acceptedVerifier'. The field
     * 'acceptedVerifier' has the following description: A verifier
     * that means the SpaceSystem has accepted the command
     * 
     * @return the value of field 'AcceptedVerifier'.
     */
    public org.hbird.xtce.castor.AcceptedVerifier getAcceptedVerifier(
    ) {
        return this._acceptedVerifier;
    }

    /**
     * Method getCompleteVerifier.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.hbird.xtce.castor.CompleteVerifier at the
     * given index
     */
    public org.hbird.xtce.castor.CompleteVerifier getCompleteVerifier(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._completeVerifierList.size()) {
            throw new IndexOutOfBoundsException("getCompleteVerifier: Index value '" + index + "' not in range [0.." + (this._completeVerifierList.size() - 1) + "]");
        }

        return (org.hbird.xtce.castor.CompleteVerifier) _completeVerifierList.get(index);
    }

    /**
     * Method getCompleteVerifier.Returns the contents of the
     * collection in an Array.  <p>Note:  Just in case the
     * collection contents are changing in another thread, we pass
     * a 0-length Array of the correct type into the API call. 
     * This way we <i>know</i> that the Array returned is of
     * exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.hbird.xtce.castor.CompleteVerifier[] getCompleteVerifier(
    ) {
        org.hbird.xtce.castor.CompleteVerifier[] array = new org.hbird.xtce.castor.CompleteVerifier[0];
        return (org.hbird.xtce.castor.CompleteVerifier[]) this._completeVerifierList.toArray(array);
    }

    /**
     * Method getCompleteVerifierCount.
     * 
     * @return the size of this collection
     */
    public int getCompleteVerifierCount(
    ) {
        return this._completeVerifierList.size();
    }

    /**
     * Returns the value of field 'executionVerifier'. The field
     * 'executionVerifier' has the following description: A
     * verifier that indicates that the command is being executed.
     * An optional Element indicates how far along the command has
     * progressed either as a fixed value or an (possibly scaled)
     * ParameterInstance value.
     * 
     * @return the value of field 'ExecutionVerifier'.
     */
    public org.hbird.xtce.castor.ExecutionVerifier getExecutionVerifier(
    ) {
        return this._executionVerifier;
    }

    /**
     * Returns the value of field 'failedVerifier'. The field
     * 'failedVerifier' has the following description: When true,
     * indicates that the command failed. timeToWait is how long to
     * wait for the FailedVerifier to test true.
     * 
     * @return the value of field 'FailedVerifier'.
     */
    public org.hbird.xtce.castor.FailedVerifier getFailedVerifier(
    ) {
        return this._failedVerifier;
    }

    /**
     * Returns the value of field 'queuedVerifier'. The field
     * 'queuedVerifier' has the following description: A verifyer
     * that means the command is scheduled for execution by the
     * SpaceSystem.
     * 
     * @return the value of field 'QueuedVerifier'.
     */
    public org.hbird.xtce.castor.QueuedVerifier getQueuedVerifier(
    ) {
        return this._queuedVerifier;
    }

    /**
     * Returns the value of field 'receivedVerifier'. The field
     * 'receivedVerifier' has the following description: A verifier
     * that simply means the SpaceSystem has received the command.
     * 
     * @return the value of field 'ReceivedVerifier'.
     */
    public org.hbird.xtce.castor.ReceivedVerifier getReceivedVerifier(
    ) {
        return this._receivedVerifier;
    }

    /**
     * Returns the value of field 'sentFromRangeVerifier'. The
     * field 'sentFromRangeVerifier' has the following description:
     * Sent from range means the command has been transmitted to
     * the spacecraft by a the network that connects the ground
     * system to the spacecraft. Obviously, this verifier must come
     * from something other than the spacecraft. 
     * 
     * @return the value of field 'SentFromRangeVerifier'.
     */
    public org.hbird.xtce.castor.SentFromRangeVerifier getSentFromRangeVerifier(
    ) {
        return this._sentFromRangeVerifier;
    }

    /**
     * Returns the value of field 'transferredToRangeVerifier'. The
     * field 'transferredToRangeVerifier' has the following
     * description: Transferred to range means the command has been
     * received by a the network that connects the ground system to
     * the spacecraft. Obviously, this verifier must come from
     * something other than the spacecraft. 
     * 
     * @return the value of field 'TransferredToRangeVerifier'.
     */
    public org.hbird.xtce.castor.TransferredToRangeVerifier getTransferredToRangeVerifier(
    ) {
        return this._transferredToRangeVerifier;
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
     * Method iterateCompleteVerifier.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends org.hbird.xtce.castor.CompleteVerifier> iterateCompleteVerifier(
    ) {
        return this._completeVerifierList.iterator();
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
     */
    public void removeAllCompleteVerifier(
    ) {
        this._completeVerifierList.clear();
    }

    /**
     * Method removeCompleteVerifier.
     * 
     * @param vCompleteVerifier
     * @return true if the object was removed from the collection.
     */
    public boolean removeCompleteVerifier(
            final org.hbird.xtce.castor.CompleteVerifier vCompleteVerifier) {
        boolean removed = _completeVerifierList.remove(vCompleteVerifier);
        return removed;
    }

    /**
     * Method removeCompleteVerifierAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.hbird.xtce.castor.CompleteVerifier removeCompleteVerifierAt(
            final int index) {
        java.lang.Object obj = this._completeVerifierList.remove(index);
        return (org.hbird.xtce.castor.CompleteVerifier) obj;
    }

    /**
     * Sets the value of field 'acceptedVerifier'. The field
     * 'acceptedVerifier' has the following description: A verifier
     * that means the SpaceSystem has accepted the command
     * 
     * @param acceptedVerifier the value of field 'acceptedVerifier'
     */
    public void setAcceptedVerifier(
            final org.hbird.xtce.castor.AcceptedVerifier acceptedVerifier) {
        this._acceptedVerifier = acceptedVerifier;
    }

    /**
     * 
     * 
     * @param index
     * @param vCompleteVerifier
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCompleteVerifier(
            final int index,
            final org.hbird.xtce.castor.CompleteVerifier vCompleteVerifier)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._completeVerifierList.size()) {
            throw new IndexOutOfBoundsException("setCompleteVerifier: Index value '" + index + "' not in range [0.." + (this._completeVerifierList.size() - 1) + "]");
        }

        this._completeVerifierList.set(index, vCompleteVerifier);
    }

    /**
     * 
     * 
     * @param vCompleteVerifierArray
     */
    public void setCompleteVerifier(
            final org.hbird.xtce.castor.CompleteVerifier[] vCompleteVerifierArray) {
        //-- copy array
        _completeVerifierList.clear();

        for (int i = 0; i < vCompleteVerifierArray.length; i++) {
                this._completeVerifierList.add(vCompleteVerifierArray[i]);
        }
    }

    /**
     * Sets the value of field 'executionVerifier'. The field
     * 'executionVerifier' has the following description: A
     * verifier that indicates that the command is being executed.
     * An optional Element indicates how far along the command has
     * progressed either as a fixed value or an (possibly scaled)
     * ParameterInstance value.
     * 
     * @param executionVerifier the value of field
     * 'executionVerifier'.
     */
    public void setExecutionVerifier(
            final org.hbird.xtce.castor.ExecutionVerifier executionVerifier) {
        this._executionVerifier = executionVerifier;
    }

    /**
     * Sets the value of field 'failedVerifier'. The field
     * 'failedVerifier' has the following description: When true,
     * indicates that the command failed. timeToWait is how long to
     * wait for the FailedVerifier to test true.
     * 
     * @param failedVerifier the value of field 'failedVerifier'.
     */
    public void setFailedVerifier(
            final org.hbird.xtce.castor.FailedVerifier failedVerifier) {
        this._failedVerifier = failedVerifier;
    }

    /**
     * Sets the value of field 'queuedVerifier'. The field
     * 'queuedVerifier' has the following description: A verifyer
     * that means the command is scheduled for execution by the
     * SpaceSystem.
     * 
     * @param queuedVerifier the value of field 'queuedVerifier'.
     */
    public void setQueuedVerifier(
            final org.hbird.xtce.castor.QueuedVerifier queuedVerifier) {
        this._queuedVerifier = queuedVerifier;
    }

    /**
     * Sets the value of field 'receivedVerifier'. The field
     * 'receivedVerifier' has the following description: A verifier
     * that simply means the SpaceSystem has received the command.
     * 
     * @param receivedVerifier the value of field 'receivedVerifier'
     */
    public void setReceivedVerifier(
            final org.hbird.xtce.castor.ReceivedVerifier receivedVerifier) {
        this._receivedVerifier = receivedVerifier;
    }

    /**
     * Sets the value of field 'sentFromRangeVerifier'. The field
     * 'sentFromRangeVerifier' has the following description: Sent
     * from range means the command has been transmitted to the
     * spacecraft by a the network that connects the ground system
     * to the spacecraft. Obviously, this verifier must come from
     * something other than the spacecraft. 
     * 
     * @param sentFromRangeVerifier the value of field
     * 'sentFromRangeVerifier'.
     */
    public void setSentFromRangeVerifier(
            final org.hbird.xtce.castor.SentFromRangeVerifier sentFromRangeVerifier) {
        this._sentFromRangeVerifier = sentFromRangeVerifier;
    }

    /**
     * Sets the value of field 'transferredToRangeVerifier'. The
     * field 'transferredToRangeVerifier' has the following
     * description: Transferred to range means the command has been
     * received by a the network that connects the ground system to
     * the spacecraft. Obviously, this verifier must come from
     * something other than the spacecraft. 
     * 
     * @param transferredToRangeVerifier the value of field
     * 'transferredToRangeVerifier'.
     */
    public void setTransferredToRangeVerifier(
            final org.hbird.xtce.castor.TransferredToRangeVerifier transferredToRangeVerifier) {
        this._transferredToRangeVerifier = transferredToRangeVerifier;
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
     * org.hbird.xtce.castor.Verifiers
     */
    public static org.hbird.xtce.castor.Verifiers unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.Verifiers) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.Verifiers.class, reader);
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
