// The root URL for the RESTful services
var rootURL = "http://localhost:8181/hbird/halcyon/";

jQuery(document).ready(function() {
	getAllowedCommandList();
});


function getAllowedCommandList() {
	var jqxhr = $.getJSON(rootURL + "commandlist");
	
	jqxhr.done(
		function(parsedResponse, statusText, jqXhr) {
			updateAllowedCommands( jQuery.parseJSON(jqXhr.responseText)); 
		}
	);
}

function updateAllowedCommands(cmdList) {
	$("#commandList").empty();
	$.each(cmdList,
		function(i) {
			$("#commandList").append("<li>" + cmdList[i].name + ":" + cmdList[i].qualifiedName + "</li>");
		}
	);
}

