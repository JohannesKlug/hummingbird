/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor.types;

/**
 * Enumeration StringDataEncodingTypeEncodingType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public enum StringDataEncodingTypeEncodingType implements java.io.Serializable {


      //------------------/
     //- Enum Constants -/
    //------------------/

    /**
     * Constant UTF_8
     */
    UTF_8("UTF-8"),
    /**
     * Constant UTF_16
     */
    UTF_16("UTF-16");

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

    private StringDataEncodingTypeEncodingType(final java.lang.String value) {
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
    public static org.hbird.transport.xtce.castor.types.StringDataEncodingTypeEncodingType fromValue(
            final java.lang.String value) {
        for (StringDataEncodingTypeEncodingType c: StringDataEncodingTypeEncodingType.values()) {
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
