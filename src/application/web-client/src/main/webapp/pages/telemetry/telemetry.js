// The root URL for the RESTful services
var host = "localhost";
var port = "8181";
var url = "/hbird/halcyon/";
var rootURL = "http://"+ host + ":" + port + url;

var ws = $.gracefulWebSocket("ws://"+ host + ":" + port + url + "tmsock");

var seriesData = [];
var chartData = new Array();
var liveTmChart;

//-----------------


/**
 * On page ready do the following.
 */
jQuery(document).ready(function() {
	$('body').layout({ applyDefaultStyles: true });
	setupWebsocket();
	$(".chzn-select").chosen(); // Activate chosen plugin
	$(".chzn-select-deselect").chosen({allow_single_deselect:true});
	$("#parametersList").change(parameterSelectionChanged);

	getTelemetryList();

	var options = {
					xaxis: { 
						mode: "time" 
					}
				  };
	liveTmChart = $.plot($("#liveTmChart"), chartData, options);
});

/**
 * Sets up the web socket callbacks.
 */
function setupWebsocket() {
	ws.onopen = function() {
		console.log("Websocket connection established.");
	};
	
	ws.onmessage = function(event) {
		plotParameter($.parseJSON(event.data));   
	};
}


/**
 * Calls the Halcyon restful web service to gather the TM parameters list then
 * updated the TM list on the page. 
 */
function getTelemetryList() {
	var jqxhr = $.getJSON(rootURL + "tm/parameters");
	
	jqxhr.done(
		function(parsedResponse, statusText, jqXhr) {
			updateTelemetry(jQuery.parseJSON(jqXhr.responseText)); 
		}
	);
}

/**
 * Accepts an array of parameters (Hbird commons tmtc Parameter) and adds them to the 
 * parameter selection form as options.
 * @param param
 */
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

/**
 * 
 * [ 
 * 	{ label: "Foo", data: [ [10, 1], [17, -14], [30, 5] ] },
 * 	{ label: "Bar", data: [ [11, 13], [19, 11], [30, -7] ] }
 * ]
 * 
 * @param parameter JS object of Parameter object.
 */
function plotParameter(parameter) {
	// Get the parameters series data and append the new data to it. If the
	// series does not exist return and do nothing.
	var parameterSeries = getSeriesData(parameter.qualifiedName);
	if(typeof parameterSeries === "undefined") {
		return;
	}
	parameterSeries.push([parameter.receivedTime, parameter.value]);

	var newData = [];
	for(var i in seriesData) {
		newData.push({"label":i, "data":seriesData[i]});
	}
	
	console.log("Adding seriesData");
	liveTmChart.setData(newData);
	liveTmChart.setupGrid();
	liveTmChart.draw();
}

/**
 * Gets the series from the seriesData Map given the qualified name.
 * 
 * @param name
 * @returns
 */
function getSeriesData(name) {
	if(name in seriesData) {
		return seriesData[name];
	}
}

/**
 * Called when parameter combo-box selection has changed.
 */
function parameterSelectionChanged() {
	$("select option:selected").each(function () {
		createDataSeries($(this).val());
	});
}


/**
 * series data format as follows:
 * [ { qualifiedName:[], qualifiedName:[] } ]
 *
 * FIXME Will not remove existing plot lines that have been deselected.
 * 
 */
function createDataSeries(name) {
	if(name in seriesData) {
		console.log("Series already exists for " + name);
		return;
	}

	var data = [];
	seriesData[name] = data;
	console.log("Series created for " + name);
}



