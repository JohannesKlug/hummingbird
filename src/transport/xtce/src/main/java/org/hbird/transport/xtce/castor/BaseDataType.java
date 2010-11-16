/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor;

/**
 * An abstract type used by within the schema to derive other data
 * types by the ground system. 
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public abstract class BaseDataType extends org.hbird.transport.xtce.castor.NameDescriptionType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _unitSet.
     */
    private org.hbird.transport.xtce.castor.UnitSet _unitSet;

    /**
     * Field _baseDataTypeChoice.
     */
    private org.hbird.transport.xtce.castor.BaseDataTypeChoice _baseDataTypeChoice;


      //----------------/
     //- Constructors -/
    //----------------/

    public BaseDataType() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'baseDataTypeChoice'.
     * 
     * @return the value of field 'BaseDataTypeChoice'.
     */
    public org.hbird.transport.xtce.castor.BaseDataTypeChoice getBaseDataTypeChoice(
    ) {
        return this._baseDataTypeChoice;
    }

    /**
     * Returns the value of field 'unitSet'.
     * 
     * @return the value of field 'UnitSet'.
     */
    public org.hbird.transport.xtce.castor.UnitSet getUnitSet(
    ) {
        return this._unitSet;
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
     * Sets the value of field 'baseDataTypeChoice'.
     * 
     * @param baseDataTypeChoice the value of field
     * 'baseDataTypeChoice'.
     */
    public void setBaseDataTypeChoice(
            final org.hbird.transport.xtce.castor.BaseDataTypeChoice baseDataTypeChoice) {
        this._baseDataTypeChoice = baseDataTypeChoice;
    }

    /**
     * Sets the value of field 'unitSet'.
     * 
     * @param unitSet the value of field 'unitSet'.
     */
    public void setUnitSet(
            final org.hbird.transport.xtce.castor.UnitSet unitSet) {
        this._unitSet = unitSet;
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
