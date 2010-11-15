/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor.types;

/**
 * Enumeration IntegerDataEncodingTypeEncodingType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public enum IntegerDataEncodingTypeEncodingType implements java.io.Serializable {


      //------------------/
     //- Enum Constants -/
    //------------------/

    /**
     * Constant UNSIGNED
     */
    UNSIGNED("unsigned"),
    /**
     * Constant SIGNMAGNITUDE
     */
    SIGNMAGNITUDE("signMagnitude"),
    /**
     * Constant TWOSCOMPLIMENT
     */
    TWOSCOMPLIMENT("twosCompliment"),
    /**
     * Constant ONESCOMPLIMENT
     */
    ONESCOMPLIMENT("onesCompliment"),
    /**
     * Constant BCD
     */
    BCD("BCD"),
    /**
     * Constant PACKEDBCD
     */
    PACKEDBCD("packedBCD");

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

    private IntegerDataEncodingTypeEncodingType(final java.lang.String value) {
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
    public static com.logica.hummingbird.xtce.castor.types.IntegerDataEncodingTypeEncodingType fromValue(
            final java.lang.String value) {
        for (IntegerDataEncodingTypeEncodingType c: IntegerDataEncodingTypeEncodingType.values()) {
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
