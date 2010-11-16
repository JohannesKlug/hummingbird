/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor.descriptors;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.hbird.transport.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentList;

/**
 * Class
 * CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentListDescriptor.
 * 
 * @version $Revision$ $Date$
 */
public class CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentListDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _elementDefinition.
     */
    private boolean _elementDefinition;

    /**
     * Field _nsPrefix.
     */
    private java.lang.String _nsPrefix;

    /**
     * Field _nsURI.
     */
    private java.lang.String _nsURI;

    /**
     * Field _xmlName.
     */
    private java.lang.String _xmlName;

    /**
     * Field _identity.
     */
    private org.exolab.castor.xml.XMLFieldDescriptor _identity;


      //----------------/
     //- Constructors -/
    //----------------/

    public CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentListDescriptor() {
        super();
        _nsURI = "http://www.omg.org/space/xtce";
        _xmlName = "ArgumentList";
        _elementDefinition = true;

        //-- set grouping compositor
        setCompositorAsSequence();
        org.exolab.castor.xml.util.XMLFieldDescriptorImpl  desc           = null;
        org.exolab.castor.mapping.FieldHandler             handler        = null;
        org.exolab.castor.xml.FieldValidator               fieldValidator = null;
        //-- initialize attribute descriptors

        //-- initialize element descriptors

        //-- _argumentList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(org.hbird.transport.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentListArgument.class, "_argumentList", "Argument", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentList target = (CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentList) object;
                return target.getArgument();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentList target = (CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentList) object;
                    target.addArgument( (org.hbird.transport.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentListArgument) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
                try {
                    CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentList target = (CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentList) object;
                    target.removeAllArgument();
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new org.hbird.transport.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentListArgument();
            }
        };
        desc.setSchemaType("list");
        desc.setComponentType("org.hbird.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentListArgument");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.omg.org/space/xtce");
        desc.setRequired(true);
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _argumentList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(1);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method getAccessMode.
     * 
     * @return the access mode specified for this class.
     */
    @Override()
    public org.exolab.castor.mapping.AccessMode getAccessMode(
    ) {
        return null;
    }

    /**
     * Method getIdentity.
     * 
     * @return the identity field, null if this class has no
     * identity.
     */
    @Override()
    public org.exolab.castor.mapping.FieldDescriptor getIdentity(
    ) {
        return _identity;
    }

    /**
     * Method getJavaClass.
     * 
     * @return the Java class represented by this descriptor.
     */
    @Override()
    public java.lang.Class getJavaClass(
    ) {
        return org.hbird.transport.xtce.castor.CommandMetaDataTypeMetaCommandSetBlockMetaCommandMetaCommandStepListMetaCommandStepArgumentList.class;
    }

    /**
     * Method getNameSpacePrefix.
     * 
     * @return the namespace prefix to use when marshaling as XML.
     */
    @Override()
    public java.lang.String getNameSpacePrefix(
    ) {
        return _nsPrefix;
    }

    /**
     * Method getNameSpaceURI.
     * 
     * @return the namespace URI used when marshaling and
     * unmarshaling as XML.
     */
    @Override()
    public java.lang.String getNameSpaceURI(
    ) {
        return _nsURI;
    }

    /**
     * Method getValidator.
     * 
     * @return a specific validator for the class described by this
     * ClassDescriptor.
     */
    @Override()
    public org.exolab.castor.xml.TypeValidator getValidator(
    ) {
        return this;
    }

    /**
     * Method getXMLName.
     * 
     * @return the XML Name for the Class being described.
     */
    @Override()
    public java.lang.String getXMLName(
    ) {
        return _xmlName;
    }

    /**
     * Method isElementDefinition.
     * 
     * @return true if XML schema definition of this Class is that
     * of a global
     * element or element with anonymous type definition.
     */
    public boolean isElementDefinition(
    ) {
        return _elementDefinition;
    }

}
