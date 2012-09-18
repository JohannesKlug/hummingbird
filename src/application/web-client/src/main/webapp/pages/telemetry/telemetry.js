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


var plotLines = [];
var parameterPlotsMap = [];

//-----------------


jQuery(document).ready(function() {
	setupWebsocket();
	$(".chzn-select").chosen(); // Activate chosen plugin
	$(".chzn-select-deselect").chosen({allow_single_deselect:true});
	$("#parametersList").change(parameterSelectionChanged);
	getTelemetryList();
	smoothie.streamTo(document.getElementById("tmRealTimeChart"), 1500);
});

function setupWebsocket() {
	ws.onopen = function() {
		console.log("Websocket connection established.");
	};
	
	ws.onmessage = function(event) {
		plotParameter($.parseJSON(event.data));   
	};
}


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

function plotParameter(parameter) {
	var line = plotLines[parameter.qualifiedName];
	if(line) {
		line.append(new Date().getTime(), parameter.value);
	}
}

function parameterSelectionChanged() {
	$("select option:selected").each(function () {
		// FIXME Will not remove existing plot lines that have been deselected.
		createPlotLine($(this).val());
	});
}

/**
 * Creates a line in the PlotLines array for the given plotName.
 * If line already exists it does nothing.
 * @param plotName
 */
function createPlotLine(plotName) {
	console.log("Creating plot line for " + plotName);
	for(var i in plotLines) {
		if(plotLines[i] == plotName) {
			return;
		}
	}
	
	// If we got here there is no plot for plotName so we create a new one.
	
	var line = new TimeSeries();
	plotLines[plotName] = line
	var colour = "rgb(" + Math.round(Math.random()*256) + ", "+Math.round(Math.random()*256)+", "+Math.round(Math.random()*256)+")";
	console.log(colour);
	smoothie.addTimeSeries(line, {strokeStyle:colour, lineWidth:3});
}



