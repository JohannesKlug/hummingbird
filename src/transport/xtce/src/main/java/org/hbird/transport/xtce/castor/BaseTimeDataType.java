/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * An abstract type used by within the schema to describe derive
 * other data types by the ground system. 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public abstract class BaseTimeDataType extends org.hbird.transport.xtce.castor.NameDescriptionType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _baseTimeDataTypeSequence.
     */
    private org.hbird.transport.xtce.castor.BaseTimeDataTypeSequence _baseTimeDataTypeSequence;

    /**
     * Field _baseTimeDataTypeSequence2.
     */
    private org.hbird.transport.xtce.castor.BaseTimeDataTypeSequence2 _baseTimeDataTypeSequence2;


      //----------------/
     //- Constructors -/
    //----------------/

    public BaseTimeDataType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'baseTimeDataTypeSequence'.
     * 
     * @return the value of field 'BaseTimeDataTypeSequence'.
     */
    public org.hbird.transport.xtce.castor.BaseTimeDataTypeSequence getBaseTimeDataTypeSequence(
    ) {
        return this._baseTimeDataTypeSequence;
    }

    /**
     * Returns the value of field 'baseTimeDataTypeSequence2'.
     * 
     * @return the value of field 'BaseTimeDataTypeSequence2'.
     */
    public org.hbird.transport.xtce.castor.BaseTimeDataTypeSequence2 getBaseTimeDataTypeSequence2(
    ) {
        return this._baseTimeDataTypeSequence2;
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
     * Sets the value of field 'baseTimeDataTypeSequence'.
     * 
     * @param baseTimeDataTypeSequence the value of field
     * 'baseTimeDataTypeSequence'.
     */
    public void setBaseTimeDataTypeSequence(
            final org.hbird.transport.xtce.castor.BaseTimeDataTypeSequence baseTimeDataTypeSequence) {
        this._baseTimeDataTypeSequence = baseTimeDataTypeSequence;
    }

    /**
     * Sets the value of field 'baseTimeDataTypeSequence2'.
     * 
     * @param baseTimeDataTypeSequence2 the value of field
     * 'baseTimeDataTypeSequence2'.
     */
    public void setBaseTimeDataTypeSequence2(
            final org.hbird.transport.xtce.castor.BaseTimeDataTypeSequence2 baseTimeDataTypeSequence2) {
        this._baseTimeDataTypeSequence2 = baseTimeDataTypeSequence2;
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
