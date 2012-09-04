// The root URL for the RESTful services
var rootURL = "http://localhost:8181/hbird/halcyon/";

jQuery(document).ready(function() {
	getTelemetryList();
});


function getTelemetryList() {
	var jqxhr = $.getJSON(rootURL + "telemetrylist");
	
	jqxhr.done(
		function(parsedResponse, statusText, jqXhr) {
			updateTelemetry( jQuery.parseJSON(jqXhr.responseText)); 
		}
	);
}

function updateTelemetry(param) {
	$("#telemetryList").empty();
	$.each(param,
		function(i) {
			$("#telemetryList").append(param[i].name + ":" + param[i].qualifiedName + "</br>");
		}
	);
}

