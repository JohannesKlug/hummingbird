/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * Messages are an alternative method of uniquely identifying
 * containers within a Service. A message provides a test in the
 * form of MatchCriteria to match to a container. A simple example
 * might be: [When minorframeID=21, the message is the 21st
 * minorframe container. The collection of messages to search thru
 * will be bound by a Service.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class MessageSet implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name.
     */
    private java.lang.String _name;

    /**
     * Field _messageList.
     */
    private java.util.List<org.hbird.transport.xtce.castor.Message> _messageList;


      //----------------/
     //- Constructors -/
    //----------------/

    public MessageSet() {
        super();
        this._messageList = new java.util.ArrayList<org.hbird.transport.xtce.castor.Message>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vMessage
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addMessage(
            final org.hbird.transport.xtce.castor.Message vMessage)
    throws java.lang.IndexOutOfBoundsException {
        this._messageList.add(vMessage);
    }

    /**
     * 
     * 
     * @param index
     * @param vMessage
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addMessage(
            final int index,
            final org.hbird.transport.xtce.castor.Message vMessage)
    throws java.lang.IndexOutOfBoundsException {
        this._messageList.add(index, vMessage);
    }

    /**
     * Method enumerateMessage.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends org.hbird.transport.xtce.castor.Message> enumerateMessage(
    ) {
        return java.util.Collections.enumeration(this._messageList);
    }

    /**
     * Method getMessage.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.hbird.xtce.castor.Message at the given index
     */
    public org.hbird.transport.xtce.castor.Message getMessage(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._messageList.size()) {
            throw new IndexOutOfBoundsException("getMessage: Index value '" + index + "' not in range [0.." + (this._messageList.size() - 1) + "]");
        }

        return (org.hbird.transport.xtce.castor.Message) _messageList.get(index);
    }

    /**
     * Method getMessage.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.hbird.transport.xtce.castor.Message[] getMessage(
    ) {
        org.hbird.transport.xtce.castor.Message[] array = new org.hbird.transport.xtce.castor.Message[0];
        return (org.hbird.transport.xtce.castor.Message[]) this._messageList.toArray(array);
    }

    /**
     * Method getMessageCount.
     * 
     * @return the size of this collection
     */
    public int getMessageCount(
    ) {
        return this._messageList.size();
    }

    /**
     * Returns the value of field 'name'.
     * 
     * @return the value of field 'Name'.
     */
    public java.lang.String getName(
    ) {
        return this._name;
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
     * Method iterateMessage.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends org.hbird.transport.xtce.castor.Message> iterateMessage(
    ) {
        return this._messageList.iterator();
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
    public void removeAllMessage(
    ) {
        this._messageList.clear();
    }

    /**
     * Method removeMessage.
     * 
     * @param vMessage
     * @return true if the object was removed from the collection.
     */
    public boolean removeMessage(
            final org.hbird.transport.xtce.castor.Message vMessage) {
        boolean removed = _messageList.remove(vMessage);
        return removed;
    }

    /**
     * Method removeMessageAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.hbird.transport.xtce.castor.Message removeMessageAt(
            final int index) {
        java.lang.Object obj = this._messageList.remove(index);
        return (org.hbird.transport.xtce.castor.Message) obj;
    }

    /**
     * 
     * 
     * @param index
     * @param vMessage
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setMessage(
            final int index,
            final org.hbird.transport.xtce.castor.Message vMessage)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._messageList.size()) {
            throw new IndexOutOfBoundsException("setMessage: Index value '" + index + "' not in range [0.." + (this._messageList.size() - 1) + "]");
        }

        this._messageList.set(index, vMessage);
    }

    /**
     * 
     * 
     * @param vMessageArray
     */
    public void setMessage(
            final org.hbird.transport.xtce.castor.Message[] vMessageArray) {
        //-- copy array
        _messageList.clear();

        for (int i = 0; i < vMessageArray.length; i++) {
                this._messageList.add(vMessageArray[i]);
        }
    }

    /**
     * Sets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(
            final java.lang.String name) {
        this._name = name;
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
     * org.hbird.xtce.castor.MessageSet
     */
    public static org.hbird.transport.xtce.castor.MessageSet unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.MessageSet) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.MessageSet.class, reader);
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
