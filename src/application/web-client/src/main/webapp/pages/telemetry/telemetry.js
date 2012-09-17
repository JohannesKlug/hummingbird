// The root URL for the RESTful services
var host = "localhost";
var port = "8181";
var url = "/hbird/halcyon/";
var rootURL = "http://"+ host + ":" + port + url;

var ws = $.gracefulWebSocket("ws://"+ host + ":" + port + url + "tmsock");

var smoothie = new SmoothieChart({
//	grid: { 
//		lineWidth: 1, 
//		millisPerLine: 1000, 
//		verticalSections: 6,
//	},
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
	getTelemetryList();
	smoothie.streamTo(document.getElementById("tmRealTimeChart"), 1000 /*delay*/); 
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



