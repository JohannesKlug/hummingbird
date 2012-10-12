// The root URL for the RESTful services
var rootURL = location.protocol + "//" + window.location.hostname + ":" + location.port + "/hbird/halcyon/";

//TODO not worth it? maybe remove this cache and go with selectors on the forms arg list.
var cmdArgs = [];

jQuery(document).ready(function() {
	// Set json as default content-type for ajax. Since we are only sending JSON it means we can use the shorthand post. 
	$.ajaxSetup({
	    contentType: "application/json"
	});
	
	getAllowedCommandList();
//	setupCmdFormValidation();
});


/**
 * TODO all things validation.
 */
function setupCmdFormValidation() {
	$("#cmdFormSubmitButton").attr("disabled", true);
	var validator = $("#cmdConfigForm").validate({
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
			console.log("adding cmd: " + jqXhr.responseText);
			cmd = jQuery.parseJSON(jqXhr.responseText);
			addDescription(cmd);
			
			clearAllArgs();
			
			if(cmd.integerParameters != null) {
				addIntArgs(cmd.integerParameters);
			}
			if(cmd.longParameters!= null) {
				addLongArgs(cmd.longParameters);
			}
			if(cmd.stringParameters!= null) {
				addStringArgs(cmd.stringParameters);
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
			
			$("#cmdConfigForm").submit({cmd:cmd}, submitCommand);
		}
	);
	
	$("#cmdModal").reveal();
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
	jQuery.post(rootURL + "commanding/sendcommand", jsonString, function(){}, "application/json");

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
	var liHtml;
	var inputHtml;

	// for each integer parameter create a new list item and input field. Add metadata to input field 
	// for use by other functions
	$.each(intArgs, function(i) {
		if(!intArgs[i].readOnly) {
			console.log("Adding int arg" + intArgs[i].name);
			var id = "arg" + staticArgCounter;
			
			liHtml = "<li>" + intArgs[i].name + "</li>";
			var liSelector = $(liHtml).appendTo($("#cmdArguments"));
			
			inputHtml = " <input id=" + id + " type=text class=required name=value/>";
			var inputSelector = $(inputHtml).appendTo(liSelector);
			
			inputSelector.data("qualifiedName", intArgs[i].qualifiedName);
			inputSelector.data("type", "integer");
		}
	});
	
	staticArgCounter++;
}

function addLongArgs(longArgs) {
	var html;
	$.each(longArgs, function(i) {
		if(!longArgs[i].readOnly) {
			console.log("Adding long arg" + longArgs[i].name);
			html = "<li>" + longArgs[i].name + " <input id=arg" + staticArgCounter + " type=text class=required name=value/></li>";
			$("#cmdArguments").append(html);
			$(id).addClass("longParameter");
		}
	});
	staticArgCounter++;
}

function addStringArgs(stringArgs) {
	var html;
	$.each(stringArgs, function(i) {
		if(!stringArgs[i].readOnly) {
			console.log("Adding string arg" + stringArgs[i].name);
			html = "<li>" + stringArgs[i].name + " <input id=arg" + staticArgCounter + " type=text class=required name=value/></li>";
			$("#cmdArguments").append(html);
			$(id).addClass("stringParameter");
		}
	});
	staticArgCounter++;
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


