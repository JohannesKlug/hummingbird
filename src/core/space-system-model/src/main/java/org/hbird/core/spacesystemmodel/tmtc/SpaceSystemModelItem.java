package org.hbird.core.spacesystemmodel.tmtc;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * TODO Describe this better!
 * 
 * The root of all things that describe abstract or concrete parts of the in/out space system's binary data.
 * 
 * @author Mark Doyle
 * 
 */
@XmlRootElement
public interface SpaceSystemModelItem extends Serializable {

	String getQualifiedName();

	String getShortDescription();

	String getLongDescription();
}
