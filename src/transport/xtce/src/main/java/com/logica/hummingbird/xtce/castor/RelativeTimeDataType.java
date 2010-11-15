/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * Used to contain a relative time value. Used to describe a
 * relative time. Normally used for time offsets. A Relative time
 * is expressed as PnYn MnDTnH nMnS, where nY represents the number
 * of years, nM the number of months, nD the number of days, 'T' is
 * the date/time separator, nH the number of hours, nM the number
 * of minutes and nS the number of seconds. The number of seconds
 * can include decimal digits to arbitrary precision. For example,
 * to indicate a duration of 1 year, 2 months, 3 days, 10 hours,
 * and 30 minutes, one would write: P1Y2M3DT10H30M. One could also
 * indicate a duration of minus 120 days as: -P120D. An extension
 * of Schema duration type. 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class RelativeTimeDataType extends org.hbird.xtce.castor.BaseTimeDataType 
implements java.io.Serializable
{


      //----------------/
     //- Constructors -/
    //----------------/

    public RelativeTimeDataType() {
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
     * org.hbird.xtce.castor.RelativeTimeDataType
     */
    public static org.hbird.xtce.castor.RelativeTimeDataType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.RelativeTimeDataType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.RelativeTimeDataType.class, reader);
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
