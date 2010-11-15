/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * Hold a structure that can be repeated X times, where X is the
 * Count
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class RepeatType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Value (either fixed or dynamic) that contains the count of
     * repeated structures.
     */
    private org.hbird.xtce.castor.Count _count;

    /**
     * Indicates the distance between repeating entries (the last
     * bit of one entry to the start bit of the next entry)
     */
    private org.hbird.xtce.castor.Offset _offset;


      //----------------/
     //- Constructors -/
    //----------------/

    public RepeatType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'count'. The field 'count' has
     * the following description: Value (either fixed or dynamic)
     * that contains the count of repeated structures.
     * 
     * @return the value of field 'Count'.
     */
    public org.hbird.xtce.castor.Count getCount(
    ) {
        return this._count;
    }

    /**
     * Returns the value of field 'offset'. The field 'offset' has
     * the following description: Indicates the distance between
     * repeating entries (the last bit of one entry to the start
     * bit of the next entry)
     * 
     * @return the value of field 'Offset'.
     */
    public org.hbird.xtce.castor.Offset getOffset(
    ) {
        return this._offset;
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
     * Sets the value of field 'count'. The field 'count' has the
     * following description: Value (either fixed or dynamic) that
     * contains the count of repeated structures.
     * 
     * @param count the value of field 'count'.
     */
    public void setCount(
            final org.hbird.xtce.castor.Count count) {
        this._count = count;
    }

    /**
     * Sets the value of field 'offset'. The field 'offset' has the
     * following description: Indicates the distance between
     * repeating entries (the last bit of one entry to the start
     * bit of the next entry)
     * 
     * @param offset the value of field 'offset'.
     */
    public void setOffset(
            final org.hbird.xtce.castor.Offset offset) {
        this._offset = offset;
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
     * org.hbird.xtce.castor.RepeatType
     */
    public static org.hbird.xtce.castor.RepeatType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.RepeatType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.RepeatType.class, reader);
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
