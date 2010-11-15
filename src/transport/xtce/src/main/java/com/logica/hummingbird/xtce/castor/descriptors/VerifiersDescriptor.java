/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor.descriptors;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.hbird.xtce.castor.Verifiers;

/**
 * Class VerifiersDescriptor.
 * 
 * @version $Revision$ $Date$
 */
public class VerifiersDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {


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

    public VerifiersDescriptor() {
        super();
        _nsURI = "http://www.omg.org/space/xtce";
        _xmlName = "Verifiers";
        _elementDefinition = true;

        //-- set grouping compositor
        setCompositorAsSequence();
        org.exolab.castor.xml.util.XMLFieldDescriptorImpl  desc           = null;
        org.exolab.castor.mapping.FieldHandler             handler        = null;
        org.exolab.castor.xml.FieldValidator               fieldValidator = null;
        //-- initialize attribute descriptors

        //-- initialize element descriptors

        //-- _transferredToRangeVerifier
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(org.hbird.xtce.castor.TransferredToRangeVerifier.class, "_transferredToRangeVerifier", "TransferredToRangeVerifier", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Verifiers target = (Verifiers) object;
                return target.getTransferredToRangeVerifier();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Verifiers target = (Verifiers) object;
                    target.setTransferredToRangeVerifier( (org.hbird.xtce.castor.TransferredToRangeVerifier) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new org.hbird.xtce.castor.TransferredToRangeVerifier();
            }
        };
        desc.setSchemaType("org.hbird.xtce.castor.TransferredToRangeVerifier");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.omg.org/space/xtce");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _transferredToRangeVerifier
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _sentFromRangeVerifier
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(org.hbird.xtce.castor.SentFromRangeVerifier.class, "_sentFromRangeVerifier", "SentFromRangeVerifier", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Verifiers target = (Verifiers) object;
                return target.getSentFromRangeVerifier();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Verifiers target = (Verifiers) object;
                    target.setSentFromRangeVerifier( (org.hbird.xtce.castor.SentFromRangeVerifier) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new org.hbird.xtce.castor.SentFromRangeVerifier();
            }
        };
        desc.setSchemaType("org.hbird.xtce.castor.SentFromRangeVerifier");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.omg.org/space/xtce");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _sentFromRangeVerifier
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _receivedVerifier
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(org.hbird.xtce.castor.ReceivedVerifier.class, "_receivedVerifier", "ReceivedVerifier", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Verifiers target = (Verifiers) object;
                return target.getReceivedVerifier();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Verifiers target = (Verifiers) object;
                    target.setReceivedVerifier( (org.hbird.xtce.castor.ReceivedVerifier) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new org.hbird.xtce.castor.ReceivedVerifier();
            }
        };
        desc.setSchemaType("org.hbird.xtce.castor.ReceivedVerifier");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.omg.org/space/xtce");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _receivedVerifier
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _acceptedVerifier
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(org.hbird.xtce.castor.AcceptedVerifier.class, "_acceptedVerifier", "AcceptedVerifier", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Verifiers target = (Verifiers) object;
                return target.getAcceptedVerifier();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Verifiers target = (Verifiers) object;
                    target.setAcceptedVerifier( (org.hbird.xtce.castor.AcceptedVerifier) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new org.hbird.xtce.castor.AcceptedVerifier();
            }
        };
        desc.setSchemaType("org.hbird.xtce.castor.AcceptedVerifier");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.omg.org/space/xtce");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _acceptedVerifier
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _queuedVerifier
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(org.hbird.xtce.castor.QueuedVerifier.class, "_queuedVerifier", "QueuedVerifier", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Verifiers target = (Verifiers) object;
                return target.getQueuedVerifier();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Verifiers target = (Verifiers) object;
                    target.setQueuedVerifier( (org.hbird.xtce.castor.QueuedVerifier) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new org.hbird.xtce.castor.QueuedVerifier();
            }
        };
        desc.setSchemaType("org.hbird.xtce.castor.QueuedVerifier");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.omg.org/space/xtce");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _queuedVerifier
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _executionVerifier
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(org.hbird.xtce.castor.ExecutionVerifier.class, "_executionVerifier", "ExecutionVerifier", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Verifiers target = (Verifiers) object;
                return target.getExecutionVerifier();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Verifiers target = (Verifiers) object;
                    target.setExecutionVerifier( (org.hbird.xtce.castor.ExecutionVerifier) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new org.hbird.xtce.castor.ExecutionVerifier();
            }
        };
        desc.setSchemaType("org.hbird.xtce.castor.ExecutionVerifier");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.omg.org/space/xtce");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _executionVerifier
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _completeVerifierList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(org.hbird.xtce.castor.CompleteVerifier.class, "_completeVerifierList", "CompleteVerifier", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Verifiers target = (Verifiers) object;
                return target.getCompleteVerifier();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Verifiers target = (Verifiers) object;
                    target.addCompleteVerifier( (org.hbird.xtce.castor.CompleteVerifier) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public void resetValue(Object object) throws IllegalStateException, IllegalArgumentException {
                try {
                    Verifiers target = (Verifiers) object;
                    target.removeAllCompleteVerifier();
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new org.hbird.xtce.castor.CompleteVerifier();
            }
        };
        desc.setSchemaType("list");
        desc.setComponentType("org.hbird.xtce.castor.CompleteVerifier");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.omg.org/space/xtce");
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _completeVerifierList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(0);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _failedVerifier
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(org.hbird.xtce.castor.FailedVerifier.class, "_failedVerifier", "FailedVerifier", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                Verifiers target = (Verifiers) object;
                return target.getFailedVerifier();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    Verifiers target = (Verifiers) object;
                    target.setFailedVerifier( (org.hbird.xtce.castor.FailedVerifier) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new org.hbird.xtce.castor.FailedVerifier();
            }
        };
        desc.setSchemaType("org.hbird.xtce.castor.FailedVerifier");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.omg.org/space/xtce");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: _failedVerifier
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
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
        return org.hbird.xtce.castor.Verifiers.class;
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
