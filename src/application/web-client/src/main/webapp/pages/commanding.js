// The root URL for the RESTful services
var rootURL = "http://localhost:8181/hbird/halcyon/";

jQuery(document).ready(function() {
	getAllowedCommandList();
});


function getAllowedCommandList() {
	var jqxhr = $.getJSON(rootURL + "commandlist");
	
	jqxhr.done(
			function(parsedResponse, statusText, jqXhr) {
				updateAllowedCommands(jqXhr.responseText ); 
			}
	);
}

function updateAllowedCommands(cmdList) {
	alert(cmdList);
}

