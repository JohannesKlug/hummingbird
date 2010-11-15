/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor.types;

/**
 * Enumeration HeaderTypeValidationStatusType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public enum HeaderTypeValidationStatusType implements java.io.Serializable {


      //------------------/
     //- Enum Constants -/
    //------------------/

    /**
     * Constant UNKNOWN
     */
    UNKNOWN("Unknown"),
    /**
     * Constant WORKING
     */
    WORKING("Working"),
    /**
     * Constant DRAFT
     */
    DRAFT("Draft"),
    /**
     * Constant TEST
     */
    TEST("Test"),
    /**
     * Constant VALIDATED
     */
    VALIDATED("Validated"),
    /**
     * Constant RELEASED
     */
    RELEASED("Released"),
    /**
     * Constant WITHDRAWN
     */
    WITHDRAWN("Withdrawn");

      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field value.
     */
    private final java.lang.String value;


      //----------------/
     //- Constructors -/
    //----------------/

    private HeaderTypeValidationStatusType(final java.lang.String value) {
        this.value = value;
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method fromValue.
     * 
     * @param value
     * @return the constant for this value
     */
    public static org.hbird.xtce.castor.types.HeaderTypeValidationStatusType fromValue(
            final java.lang.String value) {
        for (HeaderTypeValidationStatusType c: HeaderTypeValidationStatusType.values()) {
            if (c.value.equals(value)) {
                return c;
            }
        }
        throw new IllegalArgumentException(value);
    }

    /**
     * 
     * 
     * @param value
     */
    public void setValue(
            final java.lang.String value) {
    }

    /**
     * Method toString.
     * 
     * @return the value of this constant
     */
    public java.lang.String toString(
    ) {
        return this.value;
    }

    /**
     * Method value.
     * 
     * @return the value of this constant
     */
    public java.lang.String value(
    ) {
        return this.value;
    }

}
