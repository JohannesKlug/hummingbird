/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package com.logica.hummingbird.xtce.castor.types;

/**
 * Operators to use when testing a boolean condition for a validity
 * check
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public enum ComparisonOperatorsType implements java.io.Serializable {


      //------------------/
     //- Enum Constants -/
    //------------------/

    /**
     * Constant VALUE_0
     */
    VALUE_0("=="),
    /**
     * Constant VALUE_1
     */
    VALUE_1("!="),
    /**
     * Constant VALUE_2
     */
    VALUE_2("<"),
    /**
     * Constant VALUE_3
     */
    VALUE_3("<="),
    /**
     * Constant VALUE_4
     */
    VALUE_4(">"),
    /**
     * Constant VALUE_5
     */
    VALUE_5(">=");

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

    private ComparisonOperatorsType(final java.lang.String value) {
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
    public static com.logica.hummingbird.xtce.castor.types.ComparisonOperatorsType fromValue(
            final java.lang.String value) {
        for (ComparisonOperatorsType c: ComparisonOperatorsType.values()) {
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
