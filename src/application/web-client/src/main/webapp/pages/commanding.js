// The root URL for the RESTful services
var rootURL = "http://localhost:8181/hbird/halcyon/";

jQuery(document).ready(function() {
	getAllowedCommandList();
});


function getAllowedCommandList() {
	var jqxhr = $.getJSON(rootURL + "commandlist");
	
	jqxhr.done(
		function(parsedResponse, statusText, jqXhr) {
			updateAllowedCommands(jQuery.parseJSON(jqXhr.responseText)); 
		}
	);
}

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
			$("#shortDescription").text(cmd.shortDescription);
		}
	);
	
	$("#cmdModal").reveal();
}