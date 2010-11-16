/**
 * @TITLE Design of Validation Component 
 * TODO 
 * @CATEGORY Design
 * @END
 * 
 * 
 * @TITLE Configuring Validation Component
 * TODO
 * @CATEGORY Configuration Guide 
 * @END
 * 
 * 
 * @TITLE Configuring Parameter Limits
 * 
 * The configuration of a limit consists of the creation the limit object and the routing of a parameter to the limit 
 * object for checking. The limit itself is not configured with the parameter it needs to check; it will check 
 * any parameter routed to it. The parameter checked is thus defined as part of the route, not as part of the 
 * limit bean.
 * 
 * The limit check will result in the issue of a state parameter with the value true (valid) of false (invalid). The
 * name of the parameter state issued is configured on the limit. The parameter state will automatically be associated to
 * the parameter it has checked with the 'isStateOf' header flag.
 * 
 * The limit itself can be configured by routing a parameter value to the the limits 'processsLimit' method. The limit
 * can be enabled and disabled by routing a state parameter (Boolean) to the limits 'processEnabled' method.
 * 
 * A parameter received through any method will trigger the calculation of the limit.
 * 
 * h2. Basic Limit
 * 
 * To limit check parameter 'myParameter' against a lower level of '10', and issue the resulting state as 
 * parameter 'myParameterLowerLimitState' make the following route in the Spring XML bean file;
 * 
 * bq. < bean id="limit" class="org.hbird.validation.parameter.LowerLimit" >  
 *		< constructor-arg index="0" value="myParameterLowerLimitState"/ >
 *		< constructor-arg index="1" value="10"/ >
 *	< /bean >
 * 	< camelContext xmlns="http://camel.apache.org/schema/spring" >
 * 		< route >
 *			< from uri="activemq:topic:Parameter?selector=name='myParameter'" / >
 *     		< to uri="bean:limit?method=processParameter"/ >
 * 			< to uri="activemq:topic:Parameter"/ >
 *		< /route >		
 *	< /camelContext >
 *
 * This will result in the creation of a parameter state parameter named 'myParameterLowerLimitState' holding the
 * state of the limit checked parameter 'myParameter'. The value will be true / false.
 *
 * h2. Changing the Limit
 *
 * To be able to dynamically change the limit value through the value 'myParameterLowerLimit', add the following 
 * route to the existing camel context;
 * 		
 * bq. < route >
 *			< from uri="activemq:topic:Parameter?selector=name='myParameterLowerLimit'" / >
 *     		< to uri="bean:limit?method=processLimit"/ >
 * 			< to uri="activemq:topic:Parameter"/ >
 *		< /route >		
 * 
 * The parameter 'myParameterLowerLimit' can now be used to change the value of the limit. The change of the limit
 * will immediately lead to a recalculation of the state.
 * 
 * h2. Enable and Disable the Limit
 * 
 * To be able to dynamically enable / disable the limit value with the parameter 'myParameterLimitEnabling', add the following route to the existing camel context;
 * 		
 * bq. < route >
 *			< from uri="activemq:topic:Parameter?selector=name='myParameterLimitEnabling'" / >
 *     		< to uri="bean:limit?method=processEnable"/ >
 * 			< to uri="activemq:topic:Parameter"/ >
 *		< /route >		
 *
 * The parameter 'myParameterLimitEnabling' can now be used to enable disable the limit. The change of the limit
 * will immediately lead to a recalculation of the state.
 *
 * h2. Configure Trigger Limit
 * 
 * A trigger limit is a definition of the minimum number of violations that must occur for the 
 * limit to change state. If a trigger limit is '3', then only after 3 violations in succession will
 * the limit change state to 'false'.
 * 
 * bq. < bean id="limit" class="org.hbird.validation.parameter.LowerLimit" >  
 *		< constructor-arg index="0" value="myParameterLowerLimitState"/ >
 *		< constructor-arg index="1" value="10"/ >
 *	< /bean >
 *  < bean id="triggerLimit" class="org.hbird.validation.base.ViolationCountFilter" >
 *		< constructor-arg index="0" value="3"/ >
 *  < /bean >
 * 	< camelContext xmlns="http://camel.apache.org/schema/spring" >
 * 		< route >
 *			< from uri="activemq:topic:Parameter?selector=name='myParameter'" / >
 *     		< to uri="bean:limit?method=processParameter"/ >
 *     		< to uri="direct:filter"/ >
 *		< /route >
 *      < route >
 *			< from uri="activemq:topic:Parameter?selector=name='myParameterLowerLimit'" / >
 *     		< to uri="bean:limit?method=processLimit"/ >
 * 			< to uri="direct:filter"/ >
 *		< /route >		
 * 		< route >
 *			< from uri="activemq:topic:Parameter?selector=name='myParameterLimitEnabling'" / >
 *     		< to uri="bean:limit?method=process"/ >
 *     		< to uri="direct:filter"/ >
 *		< /route >
 *		< route >
 *          < from uri="direct:filter"/ >
 * 			< to uri="bean:triggerLimit"/ >
 * 			< to uri="activemq:topic:Parameter"/ >
 *	< /camelContext >
 *
 * Note that in this example a 'direct' route named 'filter' has been added, to which all other routes parse
 * the exchange.

 * 
 * h2. Get only Changes 
 * 
 * The limit will issue a state parameter each time an update is received, no matter whether the state is actually changed or not. To only
 * receive changes, configure a 'OnlyChangeFilter' as part of the route.
 * 		
 * bq. < bean id="limit" class="org.hbird.validation.parameter.LowerLimit" >  
 *		< constructor-arg index="0" value="myParameterLowerLimitState"/ >
 *		< constructor-arg index="1" value="10"/ >
 *	< /bean >
 *  < bean id="triggerLimit" class="org.hbird.validation.base.ViolationCountFilter" />
 *  < bean id="onlyChange" class="org.hbird.validation.base.OnlyChangeFilter" />
 * 	< camelContext xmlns="http://camel.apache.org/schema/spring" >
 * 		< route >
 *			< from uri="activemq:topic:Parameter?selector=name='myParameter'" / >
 *     		< to uri="bean:limit?method=processParameter"/ >
 *     		< to uri="direct:filter"/ >
 *		< /route >
 *      < route >
 *			< from uri="activemq:topic:Parameter?selector=name='myParameterLowerLimit'" / >
 *     		< to uri="bean:limit?method=processLimit"/ >
 * 			< to uri="direct:filter"/ >
 *		< /route >		
 * 		< route >
 *			< from uri="activemq:topic:Parameter?selector=name='myParameterLimitEnabling'" / >
 *     		< to uri="bean:limit?method=process"/ >
 *     		< to uri="direct:filter"/ >
 *		< /route >
 *		< route >
 *          < from uri="direct:filter"/ >
 * 			< to uri="bean:triggerLimit"/ >
 * 			< to uri="bean:onlyChange"/ >
 * 			< to uri="activemq:topic:Parameter"/ >
 *	< /camelContext >
 * 
 * @CATEGORY Configuring Validation Component
 * @END
 * 
 * @TITLE Configuring Gap Checking
 * TODO
 * @CATEGORY Configuring Validation Component
 * @END
 * 
 * */
package org.hbird.business.validation.parameter;

