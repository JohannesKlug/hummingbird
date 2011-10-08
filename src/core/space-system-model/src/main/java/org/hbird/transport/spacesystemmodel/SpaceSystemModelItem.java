package org.hbird.transport.spacesystemmodel;

/**
 * TODO Describe this better!
 *
 * The root of all things that describe abstract or concrete parts of the in/out space system's binary data.
 *
 * @author Mark Doyle
 *
 */
public interface SpaceSystemModelItem {

	String getQualifiedName();

	String getShortDescription();

	String getLongDescription();
}
