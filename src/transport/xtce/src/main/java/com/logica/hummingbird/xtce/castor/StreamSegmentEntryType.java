/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * An entry that is a portion of a stream (streams are by
 * definition, assumed continuous) It is assumed that stream
 * segments happen sequentially in time, that is the first part if
 * a steam first, however, if this is not the case the order of the
 * stream segments may be supplied with the order attribute where
 * the first segment order="0".
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class StreamSegmentEntryType extends org.hbird.xtce.castor.SequenceEntryType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _streamRef.
     */
    private java.lang.String _streamRef;

    /**
     * Field _order.
     */
    private long _order;

    /**
     * keeps track of state for field: _order
     */
    private boolean _has_order;

    /**
     * Field _sizeInBits.
     */
    private long _sizeInBits;

    /**
     * keeps track of state for field: _sizeInBits
     */
    private boolean _has_sizeInBits;


      //----------------/
     //- Constructors -/
    //----------------/

    public StreamSegmentEntryType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteOrder(
    ) {
        this._has_order= false;
    }

    /**
     */
    public void deleteSizeInBits(
    ) {
        this._has_sizeInBits= false;
    }

    /**
     * Returns the value of field 'order'.
     * 
     * @return the value of field 'Order'.
     */
    public long getOrder(
    ) {
        return this._order;
    }

    /**
     * Returns the value of field 'sizeInBits'.
     * 
     * @return the value of field 'SizeInBits'.
     */
    public long getSizeInBits(
    ) {
        return this._sizeInBits;
    }

    /**
     * Returns the value of field 'streamRef'.
     * 
     * @return the value of field 'StreamRef'.
     */
    public java.lang.String getStreamRef(
    ) {
        return this._streamRef;
    }

    /**
     * Method hasOrder.
     * 
     * @return true if at least one Order has been added
     */
    public boolean hasOrder(
    ) {
        return this._has_order;
    }

    /**
     * Method hasSizeInBits.
     * 
     * @return true if at least one SizeInBits has been added
     */
    public boolean hasSizeInBits(
    ) {
        return this._has_sizeInBits;
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
     * Sets the value of field 'order'.
     * 
     * @param order the value of field 'order'.
     */
    public void setOrder(
            final long order) {
        this._order = order;
        this._has_order = true;
    }

    /**
     * Sets the value of field 'sizeInBits'.
     * 
     * @param sizeInBits the value of field 'sizeInBits'.
     */
    public void setSizeInBits(
            final long sizeInBits) {
        this._sizeInBits = sizeInBits;
        this._has_sizeInBits = true;
    }

    /**
     * Sets the value of field 'streamRef'.
     * 
     * @param streamRef the value of field 'streamRef'.
     */
    public void setStreamRef(
            final java.lang.String streamRef) {
        this._streamRef = streamRef;
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
     * org.hbird.xtce.castor.StreamSegmentEntryType
     */
    public static org.hbird.xtce.castor.StreamSegmentEntryType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.StreamSegmentEntryType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.StreamSegmentEntryType.class, reader);
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
