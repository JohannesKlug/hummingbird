/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor;

/**
 * Class MetaCommandSetItem.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class MetaCommandSetItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * All commands to be sent on this mission are listed here. In
     * addition this area has verification and validation informatio
     */
    private com.logica.hummingbird.xtce.castor.MetaCommand _metaCommand;

    /**
     * Used to include a MetaCommand defined in another sub-system
     * in this sub-system.
     */
    private java.lang.String _metaCommandRef;

    /**
     * BlockMetaCommands are simply a list of individual
     * MetaCommands that can be packaged up in a single
     * BlockMetaCommand.
     */
    private com.logica.hummingbird.xtce.castor.BlockMetaCommand _blockMetaCommand;


      //----------------/
     //- Constructors -/
    //----------------/

    public MetaCommandSetItem() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'blockMetaCommand'. The field
     * 'blockMetaCommand' has the following description:
     * BlockMetaCommands are simply a list of individual
     * MetaCommands that can be packaged up in a single
     * BlockMetaCommand.
     * 
     * @return the value of field 'BlockMetaCommand'.
     */
    public com.logica.hummingbird.xtce.castor.BlockMetaCommand getBlockMetaCommand(
    ) {
        return this._blockMetaCommand;
    }

    /**
     * Returns the value of field 'choiceValue'. The field
     * 'choiceValue' has the following description: Internal choice
     * value storage
     * 
     * @return the value of field 'ChoiceValue'.
     */
    public java.lang.Object getChoiceValue(
    ) {
        return this._choiceValue;
    }

    /**
     * Returns the value of field 'metaCommand'. The field
     * 'metaCommand' has the following description: All commands to
     * be sent on this mission are listed here. In addition this
     * area has verification and validation information
     * 
     * @return the value of field 'MetaCommand'.
     */
    public com.logica.hummingbird.xtce.castor.MetaCommand getMetaCommand(
    ) {
        return this._metaCommand;
    }

    /**
     * Returns the value of field 'metaCommandRef'. The field
     * 'metaCommandRef' has the following description: Used to
     * include a MetaCommand defined in another sub-system in this
     * sub-system.
     * 
     * @return the value of field 'MetaCommandRef'.
     */
    public java.lang.String getMetaCommandRef(
    ) {
        return this._metaCommandRef;
    }

    /**
     * Sets the value of field 'blockMetaCommand'. The field
     * 'blockMetaCommand' has the following description:
     * BlockMetaCommands are simply a list of individual
     * MetaCommands that can be packaged up in a single
     * BlockMetaCommand.
     * 
     * @param blockMetaCommand the value of field 'blockMetaCommand'
     */
    public void setBlockMetaCommand(
            final com.logica.hummingbird.xtce.castor.BlockMetaCommand blockMetaCommand) {
        this._blockMetaCommand = blockMetaCommand;
        this._choiceValue = blockMetaCommand;
    }

    /**
     * Sets the value of field 'metaCommand'. The field
     * 'metaCommand' has the following description: All commands to
     * be sent on this mission are listed here. In addition this
     * area has verification and validation information
     * 
     * @param metaCommand the value of field 'metaCommand'.
     */
    public void setMetaCommand(
            final com.logica.hummingbird.xtce.castor.MetaCommand metaCommand) {
        this._metaCommand = metaCommand;
        this._choiceValue = metaCommand;
    }

    /**
     * Sets the value of field 'metaCommandRef'. The field
     * 'metaCommandRef' has the following description: Used to
     * include a MetaCommand defined in another sub-system in this
     * sub-system.
     * 
     * @param metaCommandRef the value of field 'metaCommandRef'.
     */
    public void setMetaCommandRef(
            final java.lang.String metaCommandRef) {
        this._metaCommandRef = metaCommandRef;
        this._choiceValue = metaCommandRef;
    }

}
