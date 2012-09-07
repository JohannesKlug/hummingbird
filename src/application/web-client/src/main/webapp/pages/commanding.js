// The root URL for the RESTful services
var rootURL = "http://localhost:8181/hbird/halcyon/";

jQuery(document).ready(function() {
	getAllowedCommandList();
});

/**
 * Uses the RESTful web service @ Halcyon to get the list of all available commands
 * and then updates the client web command list.
 */
function getAllowedCommandList() {
	var jqxhr = $.getJSON(rootURL + "commandlist");
	
	jqxhr.done(
		function(parsedResponse, statusText, jqXhr) {
			updateAllowedCommands(jQuery.parseJSON(jqXhr.responseText)); 
		}
	);
}

/**
 * Adds a command link to the commmand list given an array of CmdNames objects.
 * @see Halcyon project :: CommandListResource$CmdNames 
 * @param cmdList
 */
function updateAllowedCommands(cmdList) {
	console.log("[DEBUG - Commanding] - Received " + cmdList.length + " command(s)");
	$("#commandList").empty();
	$.each(cmdList,
		function(i) {
			addCommandLink("commandList", cmdList[i]);
		}
	);
}

function addCommandLink(elementId, cmd) {
	var html ="<li><a href=\"#\" onclick=\"openCmdDialog('" + cmd.qualifiedName + "', '" + cmd.name + "')\">" + cmd.name + "</a></li>";
	console.log(html);
	$("#" + elementId).append(html);
}

function openCmdDialog(qualifiedName, name) {
	console.log("Opening dialog for command " + name + " :: " + qualifiedName);
	$("#cmdName").text(name);
	
	var jqxhr = $.getJSON(rootURL + "commandlist/command/" + qualifiedName);
	
	jqxhr.done(
		function(parsedResponse, statusText, jqXhr) {
			console.log("Found command: " + jqXhr.responseText);
			cmd = jQuery.parseJSON(jqXhr.responseText); 
			$("#longDescription").text(cmd.longDescription);
			
			clearAllArgs();
			
			if(cmd.integerParameters != null) {
				addIntArgs(cmd.integerParameters);
			}
			if(cmd.longParameters!= null) {
				// TODO impl
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
			if(cmd.stringParameters!= null) {
				// TODO impl
			}
			if(cmd.rawParameters!= null) {
				// TODO impl
			}
		}
	);
	
	$("#cmdModal").reveal();
}

function clearAllArgs() {
	$("#cmdArguments").empty();
}

function addIntArgs(intArgs) {
	var html;
	$.each(intArgs, function(i) {
		console.log("Adding arg" + intArgs[i].name);
		html = "<li>" + intArgs[i].name + "</li>"; 
		$("#cmdArguments").append(html);
	});
}

