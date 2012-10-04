// The root URL for the RESTful services
var host = window.location.hostname;
var url = "/hbird/halcyon/";
var rootURL = location.protocol + "//"+ host + ":" + location.port + url;

var ws;

var seriesData = [];
var chartData = new Array();
var liveTmChart;

var rollChartIntervalId;
var rollingChart;

var maxDataSeriesSize = 400;
//-----------------


/**
 * On page ready do the following.
 */
jQuery(document).ready(function() {
	setupWebsocket();
	
	$('body').layout({ applyDefaultStyles: true });
	
	setupEastAccordion();
	
	setupChosen();

	getTelemetryList();
	
	setupChartOptionsForm();

	var options = {
					xaxis:	{ mode: "time" }
				  };
	liveTmChart = $.plot($("#liveTmChart"), chartData, options);
});

function setupChartOptionsForm() {
	$("#maxPointsInput").val(maxDataSeriesSize);

	$("#chartOptionsForm").submit(function(event) {
		maxDataSeriesSize = $("#maxPointsInput").val();
	});
	
	$("#rollChartToggle").click(function(event) {
		if ($("#rollChartToggle").is(":checked")) {
			toggleUpdateChartTimer(true);
		}
		else {
			toggleUpdateChartTimer(false);
		}
	});
}

function toggleUpdateChartTimer(state) {
	if(state) {
		rollChartIntervalId = window.setInterval(rollChartUpdate, 50);
		rollingChart = true;
	}
	else {
		if(typeof rollChartIntervalId !== "undefined") {
			console.log("Clearing roll chart interval");
			window.clearInterval(rollChartIntervalId);
			rollingChart = false;
		}
	}
}

function rollChartUpdate() {
	var newData = [];
	for(var i in seriesData) {
		var latestEntry = seriesData[i][[(seriesData[i].length) - 1]];
		console.log("Pushing latest entry onto series: " + latestEntry[0] + " :: " + latestEntry[1]);
		var size = seriesData[i].push(latestEntry);
		if(size >= maxDataSeriesSize) {
			seriesData[i].shift();
		}
//		var latestEntry = series[(series.length) - 1];
		newData.push({"label":i, "data":seriesData[i]});
	}
	
	if(!rollingChart) {
		liveTmChart.setData(newData);
		liveTmChart.draw();
	}
}

function setupEastAccordion() {
	$("#accordion").accordion();
	
	$("body").layout({
		west__onresize: function () {
			console.log("west resize");
			// $('#accordion').accordion("resize")
		}
	});
	
}

function setupChosen() {
	$(".chzn-select").chosen(); // Activate chosen plugin
	$(".chzn-select-deselect").chosen({allow_single_deselect:true});
	$("#parametersList").change(parameterSelectionChanged);
}


/**
 * Sets up the web socket callbacks.
 */
function setupWebsocket() {
	var wsProtocol;
	if(location.protocol == "http:") {
        	wsProtocol = "ws:";
	}
	else {
        	wsProtocol = "wss:";
	}

 	ws = $.gracefulWebSocket(wsProtocol + "//" + host + ":" + location.port + url + "tmsock");
	
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
	
	// Push the new data into the parameter series array and remove the oldest entry if the array
	// has grown too large.
	var size = parameterSeries.push([parameter.receivedTime, parameter.value]);
	if(size >= maxDataSeriesSize) {
		parameterSeries.shift();
	}

	// Create the new data for the chart by added all seriesData to a new array and setting on the plot.
	var newData = [];
	for(var i in seriesData) {
		newData.push({"label":i, "data":seriesData[i]});
	}
	liveTmChart.setData(newData);
	
	// Redraw
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



