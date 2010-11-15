/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.0.1</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hbird.xtce.castor;

/**
 * SpaceSystem is a collection of SpaceSystem(s) including space
 * assets, ground assets, multi-satellite systems and sub-systems.
 * A SpaceSystem is the root element for the set of data necessary
 * to monitor and command an arbitrary space device - this includes
 * the binary decomposition the data streams going into and out of
 * a device.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class SpaceSystemType extends org.hbird.xtce.castor.NameDescriptionType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _header.
     */
    private org.hbird.xtce.castor.Header _header;

    /**
     * Field _telemetryMetaData.
     */
    private org.hbird.xtce.castor.TelemetryMetaData _telemetryMetaData;

    /**
     * Field _commandMetaData.
     */
    private org.hbird.xtce.castor.CommandMetaData _commandMetaData;

    /**
     * A service is a logical grouping of container and/or messages.
     */
    private org.hbird.xtce.castor.ServiceSet _serviceSet;

    /**
     * Defaults has default data encoding for ParameterTypes and
     * ArgumentTypes and default parameter time association that
     * will be applied to all Parameters within this SpaceSystem.
     * These defaults may be overidden by sub-SpaceSystems or by
     * the Types or Parameters themselves. Defaults simply provides
     * a means to avoid repeating attributes such as ‘bit order’
     * for every Type definition.
     */
    private org.hbird.xtce.castor.Defaults _defaults;

    /**
     * The ROOT Element
     */
    private java.util.List<org.hbird.xtce.castor.SpaceSystem> _spaceSystemList;


      //----------------/
     //- Constructors -/
    //----------------/

    public SpaceSystemType() {
        super();
        this._spaceSystemList = new java.util.ArrayList<org.hbird.xtce.castor.SpaceSystem>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vSpaceSystem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSpaceSystem(
            final org.hbird.xtce.castor.SpaceSystem vSpaceSystem)
    throws java.lang.IndexOutOfBoundsException {
        this._spaceSystemList.add(vSpaceSystem);
    }

    /**
     * 
     * 
     * @param index
     * @param vSpaceSystem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addSpaceSystem(
            final int index,
            final org.hbird.xtce.castor.SpaceSystem vSpaceSystem)
    throws java.lang.IndexOutOfBoundsException {
        this._spaceSystemList.add(index, vSpaceSystem);
    }

    /**
     * Method enumerateSpaceSystem.
     * 
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<? extends org.hbird.xtce.castor.SpaceSystem> enumerateSpaceSystem(
    ) {
        return java.util.Collections.enumeration(this._spaceSystemList);
    }

    /**
     * Returns the value of field 'commandMetaData'.
     * 
     * @return the value of field 'CommandMetaData'.
     */
    public org.hbird.xtce.castor.CommandMetaData getCommandMetaData(
    ) {
        return this._commandMetaData;
    }

    /**
     * Returns the value of field 'defaults'. The field 'defaults'
     * has the following description: Defaults has default data
     * encoding for ParameterTypes and ArgumentTypes and default
     * parameter time association that will be applied to all
     * Parameters within this SpaceSystem. These defaults may be
     * overidden by sub-SpaceSystems or by the Types or Parameters
     * themselves. Defaults simply provides a means to avoid
     * repeating attributes such as ‘bit order’ for every Type
     * definition.
     * 
     * @return the value of field 'Defaults'.
     */
    public org.hbird.xtce.castor.Defaults getDefaults(
    ) {
        return this._defaults;
    }

    /**
     * Returns the value of field 'header'.
     * 
     * @return the value of field 'Header'.
     */
    public org.hbird.xtce.castor.Header getHeader(
    ) {
        return this._header;
    }

    /**
     * Returns the value of field 'serviceSet'. The field
     * 'serviceSet' has the following description: A service is a
     * logical grouping of container and/or messages.
     * 
     * @return the value of field 'ServiceSet'.
     */
    public org.hbird.xtce.castor.ServiceSet getServiceSet(
    ) {
        return this._serviceSet;
    }

    /**
     * Method getSpaceSystem.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * org.hbird.xtce.castor.SpaceSystem at the given
     * index
     */
    public org.hbird.xtce.castor.SpaceSystem getSpaceSystem(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._spaceSystemList.size()) {
            throw new IndexOutOfBoundsException("getSpaceSystem: Index value '" + index + "' not in range [0.." + (this._spaceSystemList.size() - 1) + "]");
        }

        return (org.hbird.xtce.castor.SpaceSystem) _spaceSystemList.get(index);
    }

    /**
     * Method getSpaceSystem.Returns the contents of the collection
     * in an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public org.hbird.xtce.castor.SpaceSystem[] getSpaceSystem(
    ) {
        org.hbird.xtce.castor.SpaceSystem[] array = new org.hbird.xtce.castor.SpaceSystem[0];
        return (org.hbird.xtce.castor.SpaceSystem[]) this._spaceSystemList.toArray(array);
    }

    /**
     * Method getSpaceSystemCount.
     * 
     * @return the size of this collection
     */
    public int getSpaceSystemCount(
    ) {
        return this._spaceSystemList.size();
    }

    /**
     * Returns the value of field 'telemetryMetaData'.
     * 
     * @return the value of field 'TelemetryMetaData'.
     */
    public org.hbird.xtce.castor.TelemetryMetaData getTelemetryMetaData(
    ) {
        return this._telemetryMetaData;
    }

    /**
     * Method isValid.
     * 
     * @return true if this object is valid according to the schema
     */
    public boolean isValid(
    ) {
        try {
            validate();
        } catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    }

    /**
     * Method iterateSpaceSystem.
     * 
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<? extends org.hbird.xtce.castor.SpaceSystem> iterateSpaceSystem(
    ) {
        return this._spaceSystemList.iterator();
    }

    /**
     * 
     * 
     * @param out
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void marshal(
            final java.io.Writer out)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, out);
    }

    /**
     * 
     * 
     * @param handler
     * @throws java.io.IOException if an IOException occurs during
     * marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     */
    public void marshal(
            final org.xml.sax.ContentHandler handler)
    throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, handler);
    }

    /**
     */
    public void removeAllSpaceSystem(
    ) {
        this._spaceSystemList.clear();
    }

    /**
     * Method removeSpaceSystem.
     * 
     * @param vSpaceSystem
     * @return true if the object was removed from the collection.
     */
    public boolean removeSpaceSystem(
            final org.hbird.xtce.castor.SpaceSystem vSpaceSystem) {
        boolean removed = _spaceSystemList.remove(vSpaceSystem);
        return removed;
    }

    /**
     * Method removeSpaceSystemAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public org.hbird.xtce.castor.SpaceSystem removeSpaceSystemAt(
            final int index) {
        java.lang.Object obj = this._spaceSystemList.remove(index);
        return (org.hbird.xtce.castor.SpaceSystem) obj;
    }

    /**
     * Sets the value of field 'commandMetaData'.
     * 
     * @param commandMetaData the value of field 'commandMetaData'.
     */
    public void setCommandMetaData(
            final org.hbird.xtce.castor.CommandMetaData commandMetaData) {
        this._commandMetaData = commandMetaData;
    }

    /**
     * Sets the value of field 'defaults'. The field 'defaults' has
     * the following description: Defaults has default data
     * encoding for ParameterTypes and ArgumentTypes and default
     * parameter time association that will be applied to all
     * Parameters within this SpaceSystem. These defaults may be
     * overidden by sub-SpaceSystems or by the Types or Parameters
     * themselves. Defaults simply provides a means to avoid
     * repeating attributes such as ‘bit order’ for every Type
     * definition.
     * 
     * @param defaults the value of field 'defaults'.
     */
    public void setDefaults(
            final org.hbird.xtce.castor.Defaults defaults) {
        this._defaults = defaults;
    }

    /**
     * Sets the value of field 'header'.
     * 
     * @param header the value of field 'header'.
     */
    public void setHeader(
            final org.hbird.xtce.castor.Header header) {
        this._header = header;
    }

    /**
     * Sets the value of field 'serviceSet'. The field 'serviceSet'
     * has the following description: A service is a logical
     * grouping of container and/or messages.
     * 
     * @param serviceSet the value of field 'serviceSet'.
     */
    public void setServiceSet(
            final org.hbird.xtce.castor.ServiceSet serviceSet) {
        this._serviceSet = serviceSet;
    }

    /**
     * 
     * 
     * @param index
     * @param vSpaceSystem
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setSpaceSystem(
            final int index,
            final org.hbird.xtce.castor.SpaceSystem vSpaceSystem)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._spaceSystemList.size()) {
            throw new IndexOutOfBoundsException("setSpaceSystem: Index value '" + index + "' not in range [0.." + (this._spaceSystemList.size() - 1) + "]");
        }

        this._spaceSystemList.set(index, vSpaceSystem);
    }

    /**
     * 
     * 
     * @param vSpaceSystemArray
     */
    public void setSpaceSystem(
            final org.hbird.xtce.castor.SpaceSystem[] vSpaceSystemArray) {
        //-- copy array
        _spaceSystemList.clear();

        for (int i = 0; i < vSpaceSystemArray.length; i++) {
                this._spaceSystemList.add(vSpaceSystemArray[i]);
        }
    }

    /**
     * Sets the value of field 'telemetryMetaData'.
     * 
     * @param telemetryMetaData the value of field
     * 'telemetryMetaData'.
     */
    public void setTelemetryMetaData(
            final org.hbird.xtce.castor.TelemetryMetaData telemetryMetaData) {
        this._telemetryMetaData = telemetryMetaData;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * org.hbird.xtce.castor.SpaceSystemType
     */
    public static org.hbird.xtce.castor.SpaceSystemType unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.hbird.xtce.castor.SpaceSystemType) org.exolab.castor.xml.Unmarshaller.unmarshal(org.hbird.xtce.castor.SpaceSystemType.class, reader);
    }

    /**
     * 
     * 
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void validate(
    )
    throws org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    }

}
