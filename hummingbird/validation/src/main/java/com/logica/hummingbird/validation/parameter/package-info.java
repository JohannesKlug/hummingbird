/**
 * @TITLE Configuring Limit States
 * To limit check a parameter, make the following route;
 * 
 *  <bean id="limit" class="com.logica.hummingbird.validation.parameter.LowerLimit">
 *		<constructor-arg index="0" value="[parameter name]"/>
 *		<constructor-arg index="1" value="[parameter limit state name]"/>
 *		<constructor-arg index="2" value="[optionally the limit initial value]"/>
 *	</bean>
 *
 * 	<camelContext xmlns="http://camel.apache.org/schema/spring">
 * 		<route>
 *			<from uri="activemq:topic:Parameter?selector='name=[parameter name]'" />
 *     		<to uri="bean:limit?method=processParameter"/>
 * 			<to uri="activemq:topic:Parameter" />
 *		</route>		
 *	</camelContext>
 *
 * This will create the parameter [parameter limit state name] being the parameter holding the
 * state of the limit checked parameter. The value will be true / false.
 *
 * To be able to dynamically change the limit value, add the following route to the existing camel context;
 * 		
 * 		<route>
 *			<from uri="activemq:topic:Parameter?selector='name=[limit parameter name]'" />
 *     		<to uri="bean:limit?method=processLimit"/>
 * 			<to uri="activemq:topic:Parameter" />
 *		</route>		
 * 
 * The parameter [limit parameter name] can now be used to change the value of the limit.
 * 
 * To be able to dynamically enable / disable the limit value, add the following route to the existing camel context;
 * 		
 * 		<route>
 *			<from uri="activemq:topic:Parameter?selector='name=[enable parameter name]'" />
 *     		<to uri="bean:limit?method=processEnable"/>
 * 			<to uri="activemq:topic:Parameter" />
 *		</route>		
 * 
 * @CATEGORY Configuration Guide
 * 
 * */

package com.logica.hummingbird.validation.parameter;

