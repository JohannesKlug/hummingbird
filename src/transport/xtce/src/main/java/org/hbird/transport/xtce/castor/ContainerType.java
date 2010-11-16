/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * An abstract block of data; used as the base type for more
 * specific container types
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public abstract class ContainerType extends org.hbird.transport.xtce.castor.NameDescriptionType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _defaultRateInStream.
     */
    private org.hbird.transport.xtce.castor.DefaultRateInStream _defaultRateInStream;

    /**
     * Field _rateInStreamSet.
     */
    private org.hbird.transport.xtce.castor.RateInStreamSet _rateInStreamSet;

    /**
     * May be used to indicate error detection and correction,
     * chage byte order, provide the size (when it can't be
     * derived), or perform some custom processing.
     */
    private org.hbird.transport.xtce.castor.BinaryEncoding _binaryEncoding;


      //----------------/
     //- Constructors -/
    //----------------/

    public ContainerType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'binaryEncoding'. The field
     * 'binaryEncoding' has the following description: May be used
     * to indicate error detection and correction, chage byte
     * order, provide the size (when it can't be derived), or
     * perform some custom processing.
     * 
     * @return the value of field 'BinaryEncoding'.
     */
    public org.hbird.transport.xtce.castor.BinaryEncoding getBinaryEncoding(
    ) {
        return this._binaryEncoding;
    }

    /**
     * Returns the value of field 'defaultRateInStream'.
     * 
     * @return the value of field 'DefaultRateInStream'.
     */
    public org.hbird.transport.xtce.castor.DefaultRateInStream getDefaultRateInStream(
    ) {
        return this._defaultRateInStream;
    }

    /**
     * Returns the value of field 'rateInStreamSet'.
     * 
     * @return the value of field 'RateInStreamSet'.
     */
    public org.hbird.transport.xtce.castor.RateInStreamSet getRateInStreamSet(
    ) {
        return this._rateInStreamSet;
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
     * Sets the value of field 'binaryEncoding'. The field
     * 'binaryEncoding' has the following description: May be used
     * to indicate error detection and correction, chage byte
     * order, provide the size (when it can't be derived), or
     * perform some custom processing.
     * 
     * @param binaryEncoding the value of field 'binaryEncoding'.
     */
    public void setBinaryEncoding(
            final org.hbird.transport.xtce.castor.BinaryEncoding binaryEncoding) {
        this._binaryEncoding = binaryEncoding;
    }

    /**
     * Sets the value of field 'defaultRateInStream'.
     * 
     * @param defaultRateInStream the value of field
     * 'defaultRateInStream'.
     */
    public void setDefaultRateInStream(
            final org.hbird.transport.xtce.castor.DefaultRateInStream defaultRateInStream) {
        this._defaultRateInStream = defaultRateInStream;
    }

    /**
     * Sets the value of field 'rateInStreamSet'.
     * 
     * @param rateInStreamSet the value of field 'rateInStreamSet'.
     */
    public void setRateInStreamSet(
            final org.hbird.transport.xtce.castor.RateInStreamSet rateInStreamSet) {
        this._rateInStreamSet = rateInStreamSet;
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
