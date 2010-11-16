/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor.types;

/**
 * Mathematical operators
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public enum MathOperatorsType implements java.io.Serializable {


      //------------------/
     //- Enum Constants -/
    //------------------/

    /**
     * Constant VALUE_0
     */
    VALUE_0("+"),
    /**
     * Constant VALUE_1
     */
    VALUE_1("-"),
    /**
     * Constant VALUE_2
     */
    VALUE_2("mult"),
    /**
     * Constant VALUE_3
     */
    VALUE_3("div"),
    /**
     * Constant VALUE_4
     */
    VALUE_4("mod"),
    /**
     * Constant VALUE_5
     */
    VALUE_5("exp"),
    /**
     * Constant VALUE_6
     */
    VALUE_6("bitor"),
    /**
     * Constant VALUE_7
     */
    VALUE_7("bitand"),
    /**
     * Constant VALUE_8
     */
    VALUE_8("bitxor");

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

    private MathOperatorsType(final java.lang.String value) {
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
    public static org.hbird.transport.xtce.castor.types.MathOperatorsType fromValue(
            final java.lang.String value) {
        for (MathOperatorsType c: MathOperatorsType.values()) {
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
