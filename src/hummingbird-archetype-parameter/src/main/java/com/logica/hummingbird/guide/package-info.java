package org.hbird.guide;
/**
 * @TITLE Getting Started Guide
 * h1. Getting Started with Hummingbird development
 * 
 * h2. Mailing lists
 * 
 * As a first step, you might want to join our mailinglists. If you are a current or prospective user, subscribe to the “users” list. If you’d like to join the development team, subscribe to the “developers” list:
 * 
 * * "User Group":http://groups.google.com/group/hummingbird-users
 * * "Developer Group":http://groups.google.com/group/hummingbird-dev
 * 
 * You don’t have to sign up with Google Groups. If you prefer not to, just send an email to hummingbird-users+subscribe@googlegroups.com or hummingbird-dev+subscribe@googlegroups.com, respectively.
 * 
 * h2. Project structure
 * 
 * The Hummingbird core system is contained within the _hummingbird_ repository. All of telemetry processing, archiving, commanding go in there. This repository is hosted publicly at Github. See the next section on how to get the source code.
 * 
 * For the graphical user interface, two additional repositories are maintained, both hosted on a server run by Logica. If you are interested in testing or improving the user interface, drop an email to either of the mailing lists. Some at Logica can grant you access to the repositories in question.
 * 
 * h2. Check out the source code
 * 
 * Source code is hosted on github:
 * 
 * "Hummingbird Website":http://github.com/JohannesKlug/hummingbird
 * 
 * You need to install git, create an account at github and submit your public key. Comprehensive documentation is available
 * 
 * After signing up, you can check out the code by using this git URL: git@github.com:JohannesKlug/hummingbird.git
 * 
 * On the command line, that would be accomplished using "git clone _url_".
 * 
 * The Hummingbird Core is defined as a Maven project, so you will need Maven to build the software conveniently. On the command line, you can do so with _mvn install_ or _mvn.bat install_ on Windows.
 * 
 * For usage in Eclipse, see the next section.
 * 
 * h3. (Optional) Importing Hummingbird into Eclipse
 * 
 * If you haven't got it installed yet, get yourself the "m2eclipse" plugin for Eclipse, see "m2eclipse Website":http://m2eclipse.sonatype.org/ .
 * 
 * Now the Import Projects tool will let you locate Hummingbird ("Existing Maven project"). Choose the "hummingbird" sub-directory, so that all the sub-modules are selected as well. After that, you can trigger a full build with a right-click on the root project ("hummingbird"), and selecting "Run As" -> "Maven Install".
 * 
 * h3. Importing the GUI projects into Eclipse
 * 
 * TODO: OSGi services setup, run-target definition
 * 
 * @CATEGORY Design
 * @END
 * 
 * 
 * @TITLE Archetypes
 * A maven archetype is a template for a project or module. The hummingbird parameter archetype create a new hummingbird module for parameter processing. The archetype creates the following directory structure.
 * 
 * [[TODO]]
 * 
 * 1. A java class ('ParameterProcessor.java') with one method ('process') for processing an exchange as part of a Camel route. In add its simplicity a fully fledged Camel bean.
 * 2. A single Camel test class ('ParameterProcessorTest.java') with the skeleton for configuring a test Camel path and accessing the data.
 * 3. The module POM, preconfigured to build a web application (war).
 * 4. The webapplication configuration configuration files needed to build the component as a Web Application (war) for deployment in for example Tomcat.
 * 
 * h2. Using the Archetype
 * 
 * h3. ... in Eclipse
 * 
 * 1. In Eclipse, right click the root project of hummingbird called just 'hummingbird'.
 * 2. Select 'Maven->New Maven Module Project'. A wizard starts.
 * 3. In the first window, give your component a cool name and click next.
 * 4. In the second window, select 'Add Archetype...'.
 * 5. In the new window, insert the archetype details and the hummingbird repository as shown below.
 * 
 * [[http://open.logicaspace.com:8080/sites/default/files/archetypes.jpg]]
 * 
 * 6. In the filter field, type 'hummingbird'. The hummingbird archetype is listed. Select it and click next.
 * 7. Complete the wizard.
 * 
 * h3. ... from the Command Line
 * 
 * Enter the root directory of Hummingbird. Then enter the command (one line)
 * 
 * bq. mvn archetype:create                                                                         
 * -DarchetypeGroupId=org.hbird                        
 * -DarchetypeArtifactId=hummingbird-archetype-parameter        
 * -DarchetypeVersion=0.0.2                                 
 * -DgroupId=org.hbird                                      
 * -DartifactId=[Name of component]
 * 
 * Notice that on Windows systems the arguments must be within quotes, i.e. "-DarchetypeGroupId=org.hbird".
 * @CATEGORY Getting Started Guide
 * @END
 * 
 * */


