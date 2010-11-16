/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * Used to contain an absolute time. Contains an absolute (to a
 * known epoch) time. Use the [ISO 8601] extended format
 * CCYY-MM-DDThh:mm:ss where "CC" represents the century, "YY" the
 * year, "MM" the month and "DD" the day, preceded by an optional
 * leading "-" sign to indicate a negative number. If the sign is
 * omitted, "+" is assumed. The letter "T" is the date/time
 * separator and "hh", "mm", "ss" represent hour, minute and second
 * respectively. Additional digits can be used to increase the
 * precision of fractional seconds if desired i.e the format
 * ss.ss... with any number of digits after the decimal point is
 * supported. 
 * 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class AbsoluteTimeDataType extends org.hbird.transport.xtce.castor.BaseTimeDataType 
implements java.io.Serializable
{


      //----------------/
     //- Constructors -/
    //----------------/

    public AbsoluteTimeDataType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

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
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * org.hbird.xtce.castor.AbsoluteTimeDataType
     */
    public static org.hbird.transport.xtce.castor.AbsoluteTimeDataType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.transport.xtce.castor.AbsoluteTimeDataType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.transport.xtce.castor.AbsoluteTimeDataType.class, reader);
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
