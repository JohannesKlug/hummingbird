/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * A type definition used as the base type for a CommandDefinition
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class MetaCommandType extends com.logica.hummingbird.xtce.castor.NameDescriptionType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _abstract.
     */
    private boolean _abstract = false;

    /**
     * keeps track of state for field: _abstract
     */
    private boolean _has_abstract;

    /**
     * The MetaCommand is derived from this Base. Arguments of the
     * base MetaCommand are further specified.
     */
    private com.logica.hummingbird.xtce.castor.BaseMetaCommand _baseMetaCommand;

    /**
     * Optional. Normally used when the database is built in a
     * flat, non-hierarchical format
     */
    private java.lang.String _systemName;

    /**
     * Many commands have one or more options. These are called
     * command arguments. Command arguments may be of any of the
     * standard data types. MetaCommand arguments are local to the
     * MetaCommand.
     */
    private com.logica.hummingbird.xtce.castor.ArgumentList _argumentList;

    /**
     * Tells how to package this command
     */
    private com.logica.hummingbird.xtce.castor.CommandContainer _commandContainer;

    /**
     * Appended to the TramsmissionConstraint List of the base
     * command. Constraints are checked in order. 
     */
    private com.logica.hummingbird.xtce.castor.TransmissionConstraintList _transmissionConstraintList;

    /**
     * Some Command and Control Systems may require special user
     * access our confirmations before transmitting commands with
     * certain levels. Will inherit any level defined in the Base
     * MetaCommand.
     */
    private com.logica.hummingbird.xtce.castor.DefaultSignificance _defaultSignificance;

    /**
     * Used when the significance of a command varies by the
     * operating context
     */
    private com.logica.hummingbird.xtce.castor.ContextSignificanceList _contextSignificanceList;

    /**
     * An Interlock is a type of Constraint, but not on Command
     * instances of this MetaCommand; Interlocks apply instead to
     * the next command. An Interlock will block successive
     * commands until this command has reached a certain stage
     * (through verifications). Interlocks are scoped to a
     * SpaceSystem basis.
     */
    private com.logica.hummingbird.xtce.castor.Interlock _interlock;

    /**
     * A Command Verifier is a conditional check on the telemetry
     * from a SpaceSystem that provides positive indication on the
     * successful execution of a command. Completed verifiers are
     * added to the Base MetaCommand verifiers. All others will
     * replace a verifier defined in a Base MetaCommand.
     */
    private com.logica.hummingbird.xtce.castor.Verifiers _verifiers;

    /**
     * Parameters that are set with a new value after the command
     * has been sent. Appended to the Base Command list
     */
    private com.logica.hummingbird.xtce.castor.ParameterToSetList _parameterToSetList;


      //----------------/
     //- Constructors -/
    //----------------/

    public MetaCommandType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteAbstract(
    ) {
        this._has_abstract= false;
    }

    /**
     * Returns the value of field 'abstract'.
     * 
     * @return the value of field 'Abstract'.
     */
    public boolean getAbstract(
    ) {
        return this._abstract;
    }

    /**
     * Returns the value of field 'argumentList'. The field
     * 'argumentList' has the following description: Many commands
     * have one or more options. These are called command
     * arguments. Command arguments may be of any of the standard
     * data types. MetaCommand arguments are local to the
     * MetaCommand.
     * 
     * @return the value of field 'ArgumentList'.
     */
    public com.logica.hummingbird.xtce.castor.ArgumentList getArgumentList(
    ) {
        return this._argumentList;
    }

    /**
     * Returns the value of field 'baseMetaCommand'. The field
     * 'baseMetaCommand' has the following description: The
     * MetaCommand is derived from this Base. Arguments of the base
     * MetaCommand are further specified.
     * 
     * @return the value of field 'BaseMetaCommand'.
     */
    public com.logica.hummingbird.xtce.castor.BaseMetaCommand getBaseMetaCommand(
    ) {
        return this._baseMetaCommand;
    }

    /**
     * Returns the value of field 'commandContainer'. The field
     * 'commandContainer' has the following description: Tells how
     * to package this command
     * 
     * @return the value of field 'CommandContainer'.
     */
    public com.logica.hummingbird.xtce.castor.CommandContainer getCommandContainer(
    ) {
        return this._commandContainer;
    }

    /**
     * Returns the value of field 'contextSignificanceList'. The
     * field 'contextSignificanceList' has the following
     * description: Used when the significance of a command varies
     * by the operating context
     * 
     * @return the value of field 'ContextSignificanceList'.
     */
    public com.logica.hummingbird.xtce.castor.ContextSignificanceList getContextSignificanceList(
    ) {
        return this._contextSignificanceList;
    }

    /**
     * Returns the value of field 'defaultSignificance'. The field
     * 'defaultSignificance' has the following description: Some
     * Command and Control Systems may require special user access
     * our confirmations before transmitting commands with certain
     * levels. Will inherit any level defined in the Base
     * MetaCommand.
     * 
     * @return the value of field 'DefaultSignificance'.
     */
    public com.logica.hummingbird.xtce.castor.DefaultSignificance getDefaultSignificance(
    ) {
        return this._defaultSignificance;
    }

    /**
     * Returns the value of field 'interlock'. The field
     * 'interlock' has the following description: An Interlock is a
     * type of Constraint, but not on Command instances of this
     * MetaCommand; Interlocks apply instead to the next command.
     * An Interlock will block successive commands until this
     * command has reached a certain stage (through verifications).
     * Interlocks are scoped to a SpaceSystem basis.
     * 
     * @return the value of field 'Interlock'.
     */
    public com.logica.hummingbird.xtce.castor.Interlock getInterlock(
    ) {
        return this._interlock;
    }

    /**
     * Returns the value of field 'parameterToSetList'. The field
     * 'parameterToSetList' has the following description:
     * Parameters that are set with a new value after the command
     * has been sent. Appended to the Base Command list
     * 
     * @return the value of field 'ParameterToSetList'.
     */
    public com.logica.hummingbird.xtce.castor.ParameterToSetList getParameterToSetList(
    ) {
        return this._parameterToSetList;
    }

    /**
     * Returns the value of field 'systemName'. The field
     * 'systemName' has the following description: Optional.
     * Normally used when the database is built in a flat,
     * non-hierarchical format
     * 
     * @return the value of field 'SystemName'.
     */
    public java.lang.String getSystemName(
    ) {
        return this._systemName;
    }

    /**
     * Returns the value of field 'transmissionConstraintList'. The
     * field 'transmissionConstraintList' has the following
     * description: Appended to the TramsmissionConstraint List of
     * the base command. Constraints are checked in order. 
     * 
     * @return the value of field 'TransmissionConstraintList'.
     */
    public com.logica.hummingbird.xtce.castor.TransmissionConstraintList getTransmissionConstraintList(
    ) {
        return this._transmissionConstraintList;
    }

    /**
     * Returns the value of field 'verifiers'. The field
     * 'verifiers' has the following description: A Command
     * Verifier is a conditional check on the telemetry from a
     * SpaceSystem that provides positive indication on the
     * successful execution of a command. Completed verifiers are
     * added to the Base MetaCommand verifiers. All others will
     * replace a verifier defined in a Base MetaCommand.
     * 
     * @return the value of field 'Verifiers'.
     */
    public com.logica.hummingbird.xtce.castor.Verifiers getVerifiers(
    ) {
        return this._verifiers;
    }

    /**
     * Method hasAbstract.
     * 
     * @return true if at least one Abstract has been added
     */
    public boolean hasAbstract(
    ) {
        return this._has_abstract;
    }

    /**
     * Returns the value of field 'abstract'.
     * 
     * @return the value of field 'Abstract'.
     */
    public boolean isAbstract(
    ) {
        return this._abstract;
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
     * Sets the value of field 'abstract'.
     * 
     * @param _abstract
     * @param abstract the value of field 'abstract'.
     */
    public void setAbstract(
            final boolean _abstract) {
        this._abstract = _abstract;
        this._has_abstract = true;
    }

    /**
     * Sets the value of field 'argumentList'. The field
     * 'argumentList' has the following description: Many commands
     * have one or more options. These are called command
     * arguments. Command arguments may be of any of the standard
     * data types. MetaCommand arguments are local to the
     * MetaCommand.
     * 
     * @param argumentList the value of field 'argumentList'.
     */
    public void setArgumentList(
            final com.logica.hummingbird.xtce.castor.ArgumentList argumentList) {
        this._argumentList = argumentList;
    }

    /**
     * Sets the value of field 'baseMetaCommand'. The field
     * 'baseMetaCommand' has the following description: The
     * MetaCommand is derived from this Base. Arguments of the base
     * MetaCommand are further specified.
     * 
     * @param baseMetaCommand the value of field 'baseMetaCommand'.
     */
    public void setBaseMetaCommand(
            final com.logica.hummingbird.xtce.castor.BaseMetaCommand baseMetaCommand) {
        this._baseMetaCommand = baseMetaCommand;
    }

    /**
     * Sets the value of field 'commandContainer'. The field
     * 'commandContainer' has the following description: Tells how
     * to package this command
     * 
     * @param commandContainer the value of field 'commandContainer'
     */
    public void setCommandContainer(
            final com.logica.hummingbird.xtce.castor.CommandContainer commandContainer) {
        this._commandContainer = commandContainer;
    }

    /**
     * Sets the value of field 'contextSignificanceList'. The field
     * 'contextSignificanceList' has the following description:
     * Used when the significance of a command varies by the
     * operating context
     * 
     * @param contextSignificanceList the value of field
     * 'contextSignificanceList'.
     */
    public void setContextSignificanceList(
            final com.logica.hummingbird.xtce.castor.ContextSignificanceList contextSignificanceList) {
        this._contextSignificanceList = contextSignificanceList;
    }

    /**
     * Sets the value of field 'defaultSignificance'. The field
     * 'defaultSignificance' has the following description: Some
     * Command and Control Systems may require special user access
     * our confirmations before transmitting commands with certain
     * levels. Will inherit any level defined in the Base
     * MetaCommand.
     * 
     * @param defaultSignificance the value of field
     * 'defaultSignificance'.
     */
    public void setDefaultSignificance(
            final com.logica.hummingbird.xtce.castor.DefaultSignificance defaultSignificance) {
        this._defaultSignificance = defaultSignificance;
    }

    /**
     * Sets the value of field 'interlock'. The field 'interlock'
     * has the following description: An Interlock is a type of
     * Constraint, but not on Command instances of this
     * MetaCommand; Interlocks apply instead to the next command.
     * An Interlock will block successive commands until this
     * command has reached a certain stage (through verifications).
     * Interlocks are scoped to a SpaceSystem basis.
     * 
     * @param interlock the value of field 'interlock'.
     */
    public void setInterlock(
            final com.logica.hummingbird.xtce.castor.Interlock interlock) {
        this._interlock = interlock;
    }

    /**
     * Sets the value of field 'parameterToSetList'. The field
     * 'parameterToSetList' has the following description:
     * Parameters that are set with a new value after the command
     * has been sent. Appended to the Base Command list
     * 
     * @param parameterToSetList the value of field
     * 'parameterToSetList'.
     */
    public void setParameterToSetList(
            final com.logica.hummingbird.xtce.castor.ParameterToSetList parameterToSetList) {
        this._parameterToSetList = parameterToSetList;
    }

    /**
     * Sets the value of field 'systemName'. The field 'systemName'
     * has the following description: Optional. Normally used when
     * the database is built in a flat, non-hierarchical format
     * 
     * @param systemName the value of field 'systemName'.
     */
    public void setSystemName(
            final java.lang.String systemName) {
        this._systemName = systemName;
    }

    /**
     * Sets the value of field 'transmissionConstraintList'. The
     * field 'transmissionConstraintList' has the following
     * description: Appended to the TramsmissionConstraint List of
     * the base command. Constraints are checked in order. 
     * 
     * @param transmissionConstraintList the value of field
     * 'transmissionConstraintList'.
     */
    public void setTransmissionConstraintList(
            final com.logica.hummingbird.xtce.castor.TransmissionConstraintList transmissionConstraintList) {
        this._transmissionConstraintList = transmissionConstraintList;
    }

    /**
     * Sets the value of field 'verifiers'. The field 'verifiers'
     * has the following description: A Command Verifier is a
     * conditional check on the telemetry from a SpaceSystem that
     * provides positive indication on the successful execution of
     * a command. Completed verifiers are added to the Base
     * MetaCommand verifiers. All others will replace a verifier
     * defined in a Base MetaCommand.
     * 
     * @param verifiers the value of field 'verifiers'.
     */
    public void setVerifiers(
            final com.logica.hummingbird.xtce.castor.Verifiers verifiers) {
        this._verifiers = verifiers;
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
     * com.logica.hummingbird.xtce.castor.MetaCommandType
     */
    public static com.logica.hummingbird.xtce.castor.MetaCommandType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.logica.hummingbird.xtce.castor.MetaCommandType) org.exolab.castor.xml.Unmarshaller.unmarshal(com.logica.hummingbird.xtce.castor.MetaCommandType.class, reader);
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
