/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor.types;

/**
 * Specifies the number base
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public enum RadixType implements java.io.Serializable {


      //------------------/
     //- Enum Constants -/
    //------------------/

    /**
     * Constant DECIMAL
     */
    DECIMAL("Decimal"),
    /**
     * Constant HEXADECIMAL
     */
    HEXADECIMAL("Hexadecimal"),
    /**
     * Constant OCTAL
     */
    OCTAL("Octal"),
    /**
     * Constant BINARY
     */
    BINARY("Binary");

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

    private RadixType(final java.lang.String value) {
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
    public static com.logica.hummingbird.xtce.castor.types.RadixType fromValue(
            final java.lang.String value) {
        for (RadixType c: RadixType.values()) {
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
