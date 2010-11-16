/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor.types;

/**
 * Enumeration ParameterPropertiesTypeDataSourceType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public enum ParameterPropertiesTypeDataSourceType implements java.io.Serializable {


      //------------------/
     //- Enum Constants -/
    //------------------/

    /**
     * Constant TELEMETERED
     */
    TELEMETERED("telemetered"),
    /**
     * Constant DERIVED
     */
    DERIVED("derived"),
    /**
     * Constant CONSTANT
     */
    CONSTANT("constant"),
    /**
     * Constant LOCAL
     */
    LOCAL("local");

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

    private ParameterPropertiesTypeDataSourceType(final java.lang.String value) {
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
    public static org.hbird.transport.xtce.castor.types.ParameterPropertiesTypeDataSourceType fromValue(
            final java.lang.String value) {
        for (ParameterPropertiesTypeDataSourceType c: ParameterPropertiesTypeDataSourceType.values()) {
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
