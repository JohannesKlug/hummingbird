/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor.types;

/**
 * Enumeration FloatDataEncodingTypeSizeInBitsType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public enum FloatDataEncodingTypeSizeInBitsType implements java.io.Serializable {


      //------------------/
     //- Enum Constants -/
    //------------------/

    /**
     * Constant VALUE_32
     */
    VALUE_32("32"),
    /**
     * Constant VALUE_64
     */
    VALUE_64("64"),
    /**
     * Constant VALUE_128
     */
    VALUE_128("128");

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

    private FloatDataEncodingTypeSizeInBitsType(final java.lang.String value) {
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
    public static com.logica.hummingbird.xtce.castor.types.FloatDataEncodingTypeSizeInBitsType fromValue(
            final java.lang.String value) {
        for (FloatDataEncodingTypeSizeInBitsType c: FloatDataEncodingTypeSizeInBitsType.values()) {
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
