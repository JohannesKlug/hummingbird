/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * Class ContainerSetTypeItem.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class ContainerSetTypeItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * SequenceContainers define sequences of parameters or other
     * containers. 
     */
    private org.hbird.transport.xtce.castor.SequenceContainer _sequenceContainer;


      //----------------/
     //- Constructors -/
    //----------------/

    public ContainerSetTypeItem() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'sequenceContainer'. The field
     * 'sequenceContainer' has the following description:
     * SequenceContainers define sequences of parameters or other
     * containers. 
     * 
     * @return the value of field 'SequenceContainer'.
     */
    public org.hbird.transport.xtce.castor.SequenceContainer getSequenceContainer(
    ) {
        return this._sequenceContainer;
    }

    /**
     * Sets the value of field 'sequenceContainer'. The field
     * 'sequenceContainer' has the following description:
     * SequenceContainers define sequences of parameters or other
     * containers. 
     * 
     * @param sequenceContainer the value of field
     * 'sequenceContainer'.
     */
    public void setSequenceContainer(
            final org.hbird.transport.xtce.castor.SequenceContainer sequenceContainer) {
        this._sequenceContainer = sequenceContainer;
        this._choiceValue = sequenceContainer;
    }

}
