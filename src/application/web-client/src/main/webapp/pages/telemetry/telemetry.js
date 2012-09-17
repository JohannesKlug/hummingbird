// The root URL for the RESTful services
var host = "localhost";
var port = "8181";
var url = "/hbird/halcyon/";
var rootURL = "http://"+ host + ":" + port + url;

var ws = $.gracefulWebSocket("ws://"+ host + ":" + port + url + "tmsock");

ws.onopen = function() {
	console.log("Websocket connection established.");
};

ws.onmessage = function(event) {
	console.log("Received message on socket");
	plotParameter(event.data);   
};

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

function plotParameter(parameter) {
	console.log(parameter);
}