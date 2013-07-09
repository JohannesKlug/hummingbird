// The root URL for the RESTful services
var rootURL = location.protocol + "//" + window.location.hostname + ":" + location.port + "/hbird/halcyon/";
var host = window.location.hostname;
var halcyonUrl = "/hbird/halcyon/";

var cmdVerifySocket;

//TODO not worth it? maybe remove this cache and go with selectors on the forms arg list.
var cmdArgs = [];

var cmdTrackCompletedSteps = 0;

jQuery(document).ready(function() {
	$("#cmd").hide(0);
	
	setupWebSocket();
	
	// Set json as default content-type for ajax. Since we are only sending JSON it means we can use the shorthand post. 
	$.ajaxSetup({
	    contentType: "application/json"
	});
	
	getAllowedCommandList();
	
	$("#cmdFormSubmitButton").button();
	
	setupCommandTracker();
});

function setupWebSocket() {
	var wsProtocol;

	if (location.protocol == "http:") {
		wsProtocol = "ws:";
	} else {
		wsProtocol = "wss:";
	}

	cmdVerifySocket = $.gracefulWebSocket(wsProtocol + "//" + host + ":" + location.port + halcyonUrl + "websocket");
	
	cmdVerifySocket.onopen = function() {
		$.pnotify({
		    title: "System message",
		    text: "Websocket connection established.",
		    type: "info",
		    icon: "'picon picon-network-wireless'"
		});
	};
	
	cmdVerifySocket.onerror = function() {
		$.pnotify({
		    title: "System message",
		    text: "Websocket connection failed. Cannot receive commanding verification updates.",
		    type: "error",
		    icon: "'picon picon-network-wireless'"
		});
	};

	// When we receive a message from the websocket first check if there are any widgets on the dashboard,
	// if so, parse the message into a parameter object and call our handler.
	cmdVerifySocket.onmessage = function(event) {
		var message = $.parseJSON(event.data);
		if(message.id === "CMD_VERIFICATION_UPDATE") {
			processCmdVerifcationUpdate(message.content);
		}
	};
}

function processCmdVerifcationUpdate(update) {
	switch(update.stage) {
		case "ACCEPTED":
			setCompletedCmdTrackerStep(4);
			break;
		case "EXECUTED":
			setCompletedCmdTrackerStep(5);
			break;
		case "COMPLETE":
			setCompletedCmdTrackerStep(5);
			break;
		default:
			console.log("Unexpected update state: " + update.stage);			
	}
}

function setupCommandTracker() {
	// Set the data attribute to the number of list items, that is, the number of steps in the process
	$("ol.cmdTracker").each(function(){
        $(this).attr("data-cmdTracker-steps", $(this).children("li").length);
    });
}


function setCompletedCmdTrackerStep(step) {
	var index = step - 1;
	var incompleteSteps = $('.cmdTracker li:gt('+ index + ')');
	incompleteSteps.removeClass().addClass("cmdTracker-todo");
	
	var completedSteps = $('.cmdTracker li:lt('+ step + ')');
	completedSteps.removeClass().addClass("cmdTracker-done");
}


/**
 * TODO all things validation.
 */
function setupCmdFormValidation() {
	$("#cmdFormSubmitButton").attr("disabled", true);
	$("#cmdConfigForm").validate({
		submitHandler : function(form) {
			$("#cmdFormSubmitButton").attr("disabled", false);
		}
	});
}

/**
 * Uses the RESTful web service @ Halcyon to get the list of all available commands
 * and then updates the client web command list.
 */
function getAllowedCommandList() {
	var jqxhr = $.getJSON(rootURL + "commanding/info");
	
	jqxhr.done(function(parsedResponse, statusText, jqXhr) {
		updateAllowedCommands(jQuery.parseJSON(jqXhr.responseText)); 
	});
}

/**
 * Adds a command link to the command list given an array of CmdNames objects.
 * @see Halcyon project :: CommandListResource$CmdNames 
 * @param cmdList
 */
function updateAllowedCommands(cmdList) {
	console.log("Updating command list");
	$("#commandList").empty();
	$.each(cmdList, function(i) {
		addCommandLink("commandList", cmdList[i]);
	});
}

// TODO degrade to command page using href
var staticCounter = 0;
function addCommandLink(elementId, cmd) {
	var element = $("#" + elementId);
	var html ="<li><a id=cmd" + staticCounter + " href=\"#\">" + cmd.name + "</a></li>";
	element.append(html);

	$("#cmd" + staticCounter).click(function() {
		openCmdDialog(cmd.qualifiedName, cmd.name);
	});
	
	staticCounter++;
}

function openCmdDialog(qualifiedName, name) {
	console.log("Opening dialog for command " + name + " :: " + qualifiedName);

	$("#cmdName").text(name);
	var jqxhr = $.getJSON(rootURL + "commanding/info/command/" + qualifiedName);
	
	jqxhr.done(
		function(parsedResponse, statusText, jqXhr) {
			cmd = jQuery.parseJSON(jqXhr.responseText);
			addDescription(cmd);
			
			clearAllArgs();
			addedParameter = false;
			
			if(cmd.integerParameters != null) {
				if(addIntArgs(cmd.integerParameters)) {
					addedParameter = true;
				}
			}
			if(cmd.longParameters!= null) {
				if(addLongArgs(cmd.longParameters)) {
					addedParameter = true;
				}
			}
			if(cmd.stringParameters!= null) {
				if(addStringArgs(cmd.stringParameters)) {
					addedParameter = true;
				}
			}
			if(cmd.floatParameters!= null) {
				// TODO impl
			}
			if(cmd.doubleParameters!= null) {
				// TODO impl
			}
			if(cmd.bigDecimalParameters!= null) {
				// TODO impl
			}
			if(cmd.rawParameters!= null) {
				// TODO impl
			}
			
			if(!addedParameter) {
				$("#configureInstructions").hide();
				$("#parametersTitle").hide();
			}
			
			$("#cmdConfigForm").submit({cmd:cmd}, submitCommand);
		}
	);
	
	$("#cmd").fadeIn(50);
	
	setCompletedCmdTrackerStep(1);
}

function submitCommand(event) {	
	// Get the command object and populate the necessary parameter values
	var cmd = event.data.cmd;
	
	$("#cmdArguments li").each(function(index, element) {
		$(element).children("input").each(function(index, element) {
			var input = $(element);
			cmd = setValue(input.data("qualifiedName"), input.data("type"), input.val(), cmd);
		});
	});
	
	var jsonString = JSON.stringify(cmd);
	setCompletedCmdTrackerStep(2);
	jQuery.post(rootURL + "commanding/sendcommand", jsonString, function(data, textStatus, jqXHR){
		console.log("data: " + data);
		console.log("status: " + textStatus);
		console.log("jqXHR: " + jqXHR);
		setCompletedCmdTrackerStep(3);
	})
	.done(function() { 
		$.pnotify({
		    title: "Command",
		    text: "Command submitted successfully.",
		    type: "info",
		    icon: "'picon picon-network-wireless'"
		});
	})
	.fail(function(data, textStatus, error) { 
		$.pnotify({
		    title: "Command failure",
		    text: textStatus + " :: " + error,
		    type: "error",
		    icon: "picon picon-page-zoom"
		});
	});

	return false;
}

function setValue(tgtQualifiedName, type, newValue, cmdObject) {
	switch(type) {
		case "integer":
			$.each(cmdObject.integerParameters, function(i) {
				if(cmdObject.integerParameters[i].qualifiedName === tgtQualifiedName) {
					cmdObject.integerParameters[i].value = newValue;
					console.log("Set value on cmd to: " + cmdObject.integerParameters[i].value);
				}
			});
			break;
		default:
			console.log("Unsupported Type!");
	}
	
	return cmd;
}

function validateCommandForm(cmd) {
	
}


function clearAllArgs() {
	$("#cmdArguments").empty();
	cmdArgs.length = 0;
}


var staticArgCounter = 0;
function addIntArgs(intArgs) {
	var label;
	var liHtml;
	var inputHtml;
	var added = 0;

	// for each integer parameter create a new list item and input field. Add meta data to input field 
	// for use by other functions
	$.each(intArgs, function(i) {
		if(!intArgs[i].readOnly) {
			console.log("Adding int arg" + intArgs[i].name);
			var id = "arg" + staticArgCounter++;

			label = $('<label for=' + intArgs[i].name + '>' + intArgs[i].name + '</label>');
			label.appendTo($("#cmdArguments"));

			liHtml = $('<li id=' + intArgs[i].name + '></li>');
			liSelector = liHtml.appendTo($("#cmdArguments"));

			inputHtml = $(" <input id=" + id + " type=text class=required name=value/>");
			var inputSelector = inputHtml.appendTo(liSelector);
			
			inputHtml.focus(function() {
				commandArgInputClicked();
			});

			inputSelector.data("qualifiedName", intArgs[i].qualifiedName);
			inputSelector.data("type", "integer");
			added++;
		}
	});
	
	console.log(added);
	return added;
}

function commandArgInputClicked() {
	setCompletedCmdTrackerStep(1);
}

function addLongArgs(longArgs) {
	var html;
	var added = 0;
	
	$.each(longArgs, function(i) {
		if(!longArgs[i].readOnly) {
			console.log("Adding long arg" + longArgs[i].name);
			html = "<li>" + longArgs[i].name + " <input id=arg" + staticArgCounter + " type=text class=required name=value/></li>";
			$("#cmdArguments").append(html);
			$(id).addClass("longParameter");
			added++;
		}
	});
	staticArgCounter++;
	console.log(added);
	return added;
}

function addStringArgs(stringArgs) {
	var html;
	var added = 0;
	
	$.each(stringArgs, function(i) {
		if(!stringArgs[i].readOnly) {
			console.log("Adding string arg" + stringArgs[i].name);
			html = "<li>" + stringArgs[i].name + " <input id=arg" + staticArgCounter + " type=text class=required name=value/></li>";
			$("#cmdArguments").append(html);
			$(id).addClass("stringParameter");
			add++;
		}
	});
	staticArgCounter++;
	console.log(added);
	return added;
}


function addDescription() {
	if(cmd.longDescription != null) {
		$("#description").text(cmd.longDescription);
	}
	else if(cmd.shortDescription != null){
		$("#description").text(cmd.shortDescription);
	}
	else {
		$("#description").text("No description for this command is defined");
	}
}


