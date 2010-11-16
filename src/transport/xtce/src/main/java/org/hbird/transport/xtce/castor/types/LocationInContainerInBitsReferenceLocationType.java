/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.transport.xtce.castor.types;

/**
 * Enumeration LocationInContainerInBitsReferenceLocationType.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public enum LocationInContainerInBitsReferenceLocationType implements java.io.Serializable {


      //------------------/
     //- Enum Constants -/
    //------------------/

    /**
     * Constant CONTAINERSTART
     */
    CONTAINERSTART("containerStart"),
    /**
     * Constant CONTAINEREND
     */
    CONTAINEREND("containerEnd"),
    /**
     * Constant PREVIOUSENTRY
     */
    PREVIOUSENTRY("previousEntry"),
    /**
     * Constant NEXTENTRY
     */
    NEXTENTRY("nextEntry");

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

    private LocationInContainerInBitsReferenceLocationType(final java.lang.String value) {
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
    public static org.hbird.transport.xtce.castor.types.LocationInContainerInBitsReferenceLocationType fromValue(
            final java.lang.String value) {
        for (LocationInContainerInBitsReferenceLocationType c: LocationInContainerInBitsReferenceLocationType.values()) {
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
