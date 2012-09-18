// The root URL for the RESTful services
var host = "localhost";
var port = "8181";
var url = "/hbird/halcyon/";
var rootURL = "http://"+ host + ":" + port + url;

var ws = $.gracefulWebSocket("ws://"+ host + ":" + port + url + "tmsock");

var smoothie = new SmoothieChart({
	labels: { 
		fillStyle:'rgb(255, 255, 255)' 
	}
});


var plotLines = new Array();

//-----------------

ws.onopen = function() {
	console.log("Websocket connection established.");
};

ws.onmessage = function(event) {
	plotParameter($.parseJSON(event.data));   
};

jQuery(document).ready(function() {
	$(".chzn-select").chosen(); // Activate chosen plugin
	$(".chzn-select-deselect").chosen({allow_single_deselect:true});
	getTelemetryList();
	smoothie.streamTo(document.getElementById("tmRealTimeChart"), 1000);
});

function getTelemetryList() {
	var jqxhr = $.getJSON(rootURL + "tm/parameters");
	
	jqxhr.done(
		function(parsedResponse, statusText, jqXhr) {
			updateTelemetry(jQuery.parseJSON(jqXhr.responseText)); 
		}
	);
}

function updateTelemetry(param) {
	$("#telemetryList").empty();
	$.each(param,
		function(i) {
			console.log("Adding parameter");
			$("#parametersList").append(new Option(param[i].name, param[i].qualifiedName, false, false));
		}
	);
	$("#parametersList").trigger("liszt:updated");
}

var line1 = new TimeSeries( { strokeStyle:'rgb(0, 255, 0)', fillStyle:'rgba(0, 255, 0, 0.4)', lineWidth:3 });
function plotParameter(parameter) {
	if(parameter.qualifiedName == "Thunderbird.tm.Temperature_BMP") {
	
//		line = getLine(parameter.qualifiedName);

		setInterval(function() {
			line1.append(new Date().getTime(), parameter.value);
		}, 1000);

		smoothie.addTimeSeries(line1);
	}
}

function getLine(qualifiedName) {
	
}



