/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * Command Meta Data contains information about commands
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class CommandMetaDataType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * A list of parameter types
     */
    private org.hbird.xtce.castor.ParameterTypeSet _parameterTypeSet;

    /**
     * Parameters referenced by MetaCommands. This Parameter Set is
     * located here so that MetaCommand data can be built
     * independantly of TelemetryMetaData.
     */
    private org.hbird.xtce.castor.ParameterSet _parameterSet;

    /**
     * Field _argumentTypeSet.
     */
    private org.hbird.xtce.castor.ArgumentTypeSet _argumentTypeSet;

    /**
     * A set of Command Definitions
     */
    private org.hbird.xtce.castor.MetaCommandSet _metaCommandSet;

    /**
     * The Command Container defines the construction of a Command.
     */
    private org.hbird.xtce.castor.CommandContainerSet _commandContainerSet;

    /**
     * Field _streamSet.
     */
    private org.hbird.xtce.castor.StreamSet _streamSet;

    /**
     * Field _algorithmSet.
     */
    private org.hbird.xtce.castor.AlgorithmSet _algorithmSet;


      //----------------/
     //- Constructors -/
    //----------------/

    public CommandMetaDataType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'algorithmSet'.
     * 
     * @return the value of field 'AlgorithmSet'.
     */
    public org.hbird.xtce.castor.AlgorithmSet getAlgorithmSet(
    ) {
        return this._algorithmSet;
    }

    /**
     * Returns the value of field 'argumentTypeSet'.
     * 
     * @return the value of field 'ArgumentTypeSet'.
     */
    public org.hbird.xtce.castor.ArgumentTypeSet getArgumentTypeSet(
    ) {
        return this._argumentTypeSet;
    }

    /**
     * Returns the value of field 'commandContainerSet'. The field
     * 'commandContainerSet' has the following description: The
     * Command Container defines the construction of a Command.
     * 
     * @return the value of field 'CommandContainerSet'.
     */
    public org.hbird.xtce.castor.CommandContainerSet getCommandContainerSet(
    ) {
        return this._commandContainerSet;
    }

    /**
     * Returns the value of field 'metaCommandSet'. The field
     * 'metaCommandSet' has the following description: A set of
     * Command Definitions
     * 
     * @return the value of field 'MetaCommandSet'.
     */
    public org.hbird.xtce.castor.MetaCommandSet getMetaCommandSet(
    ) {
        return this._metaCommandSet;
    }

    /**
     * Returns the value of field 'parameterSet'. The field
     * 'parameterSet' has the following description: Parameters
     * referenced by MetaCommands. This Parameter Set is located
     * here so that MetaCommand data can be built independantly of
     * TelemetryMetaData.
     * 
     * @return the value of field 'ParameterSet'.
     */
    public org.hbird.xtce.castor.ParameterSet getParameterSet(
    ) {
        return this._parameterSet;
    }

    /**
     * Returns the value of field 'parameterTypeSet'. The field
     * 'parameterTypeSet' has the following description: A list of
     * parameter types
     * 
     * @return the value of field 'ParameterTypeSet'.
     */
    public org.hbird.xtce.castor.ParameterTypeSet getParameterTypeSet(
    ) {
        return this._parameterTypeSet;
    }

    /**
     * Returns the value of field 'streamSet'.
     * 
     * @return the value of field 'StreamSet'.
     */
    public org.hbird.xtce.castor.StreamSet getStreamSet(
    ) {
        return this._streamSet;
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
     * Sets the value of field 'algorithmSet'.
     * 
     * @param algorithmSet the value of field 'algorithmSet'.
     */
    public void setAlgorithmSet(
            final org.hbird.xtce.castor.AlgorithmSet algorithmSet) {
        this._algorithmSet = algorithmSet;
    }

    /**
     * Sets the value of field 'argumentTypeSet'.
     * 
     * @param argumentTypeSet the value of field 'argumentTypeSet'.
     */
    public void setArgumentTypeSet(
            final org.hbird.xtce.castor.ArgumentTypeSet argumentTypeSet) {
        this._argumentTypeSet = argumentTypeSet;
    }

    /**
     * Sets the value of field 'commandContainerSet'. The field
     * 'commandContainerSet' has the following description: The
     * Command Container defines the construction of a Command.
     * 
     * @param commandContainerSet the value of field
     * 'commandContainerSet'.
     */
    public void setCommandContainerSet(
            final org.hbird.xtce.castor.CommandContainerSet commandContainerSet) {
        this._commandContainerSet = commandContainerSet;
    }

    /**
     * Sets the value of field 'metaCommandSet'. The field
     * 'metaCommandSet' has the following description: A set of
     * Command Definitions
     * 
     * @param metaCommandSet the value of field 'metaCommandSet'.
     */
    public void setMetaCommandSet(
            final org.hbird.xtce.castor.MetaCommandSet metaCommandSet) {
        this._metaCommandSet = metaCommandSet;
    }

    /**
     * Sets the value of field 'parameterSet'. The field
     * 'parameterSet' has the following description: Parameters
     * referenced by MetaCommands. This Parameter Set is located
     * here so that MetaCommand data can be built independantly of
     * TelemetryMetaData.
     * 
     * @param parameterSet the value of field 'parameterSet'.
     */
    public void setParameterSet(
            final org.hbird.xtce.castor.ParameterSet parameterSet) {
        this._parameterSet = parameterSet;
    }

    /**
     * Sets the value of field 'parameterTypeSet'. The field
     * 'parameterTypeSet' has the following description: A list of
     * parameter types
     * 
     * @param parameterTypeSet the value of field 'parameterTypeSet'
     */
    public void setParameterTypeSet(
            final org.hbird.xtce.castor.ParameterTypeSet parameterTypeSet) {
        this._parameterTypeSet = parameterTypeSet;
    }

    /**
     * Sets the value of field 'streamSet'.
     * 
     * @param streamSet the value of field 'streamSet'.
     */
    public void setStreamSet(
            final org.hbird.xtce.castor.StreamSet streamSet) {
        this._streamSet = streamSet;
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
     * org.hbird.xtce.castor.CommandMetaDataType
     */
    public static org.hbird.xtce.castor.CommandMetaDataType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.CommandMetaDataType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.CommandMetaDataType.class, reader);
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
