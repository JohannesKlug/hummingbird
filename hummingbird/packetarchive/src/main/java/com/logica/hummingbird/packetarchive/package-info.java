/** The packer archive component stores CCSDS space packets.
 * 
 * The component is based on Camel and iBATIS.
 * 
 * The file src/main/resources/database.sql defines the SQL database layout. Use this to 
 * create a database. For example;
 * - Install mySQL.
 * - login.
 * - Create the database using .\ [hummingbird]/src/main/resources/database.sql'
 * 
 * Based on the database layout, iBATOR is used to auto generate the iBATIS configuration
 * files, i.e. the classes representing packets as well as the XML mapping files. The
 * iBATOR configuration file 'src/main/resources/ibatorConfig.xml' defines the
 * configuration used by iBATOR to do this. To run, a JDBC connection must exist to a 
 * RDBMS database within which the database has been created.
 * 
 * In Eclipse, right click on the ibatorConfig.xml file and select 
 *  
 */
package com.logica.hummingbird.packetarchive;
