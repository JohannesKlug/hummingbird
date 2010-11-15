/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * Class NumberToStringTypeChoiceItem.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class NumberToStringTypeChoiceItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * A number or range assigned to a string.
     */
    private org.hbird.xtce.castor.ValueEnumeration _valueEnumeration;

    /**
     * A string value associated with a numerical range.
     */
    private org.hbird.xtce.castor.RangeEnumeration _rangeEnumeration;


      //----------------/
     //- Constructors -/
    //----------------/

    public NumberToStringTypeChoiceItem() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'rangeEnumeration'. The field
     * 'rangeEnumeration' has the following description: A string
     * value associated with a numerical range.
     * 
     * @return the value of field 'RangeEnumeration'.
     */
    public org.hbird.xtce.castor.RangeEnumeration getRangeEnumeration(
    ) {
        return this._rangeEnumeration;
    }

    /**
     * Returns the value of field 'valueEnumeration'. The field
     * 'valueEnumeration' has the following description: A number
     * or range assigned to a string.
     * 
     * @return the value of field 'ValueEnumeration'.
     */
    public org.hbird.xtce.castor.ValueEnumeration getValueEnumeration(
    ) {
        return this._valueEnumeration;
    }

    /**
     * Sets the value of field 'rangeEnumeration'. The field
     * 'rangeEnumeration' has the following description: A string
     * value associated with a numerical range.
     * 
     * @param rangeEnumeration the value of field 'rangeEnumeration'
     */
    public void setRangeEnumeration(
            final org.hbird.xtce.castor.RangeEnumeration rangeEnumeration) {
        this._rangeEnumeration = rangeEnumeration;
    }

    /**
     * Sets the value of field 'valueEnumeration'. The field
     * 'valueEnumeration' has the following description: A number
     * or range assigned to a string.
     * 
     * @param valueEnumeration the value of field 'valueEnumeration'
     */
    public void setValueEnumeration(
            final org.hbird.xtce.castor.ValueEnumeration valueEnumeration) {
        this._valueEnumeration = valueEnumeration;
    }

}
