// The root URL for the RESTful services
var host = window.location.hostname;
var url = "/hbird/halcyon/";
var rootURL = location.protocol + "//" + host + ":" + location.port + url;

var live = true;

var seriesData = [];
var chartData = new Array();
var liveTmChart;

var rollChartIntervalId;
var rollingChart;

var maxDataSeriesSize = 400;
// -----------------

/**
 * On page ready do the following.
 */
jQuery(document).ready(function() {
	setupLayout();
	setupChosen();
	setupWebsocket();
	setupChartOptionsForm();
	setupChart();
	getTelemetryList();
});

function setupLayout() {
	var layoutOptions = {
		applyDefaultStyles : false,
		spacing_open : 3,
		north : {
			resizable : false,
			size : 50,
			minSize : 50,
			maxSize : 50
		},
		south : {
			resizable : false,
			closable : false,
			resizable : false,
			size : 30,
			minSize : 30,
			maxSize : 30
		},
		west : {
			showOverflowOnHover : true
		},
		east : {},
		east__onresize : function() {
			$("#accordion").accordion("resize");
		}
	};

	$('body').layout(layoutOptions);

	setupEastAccordion();
}

function setupChart() {
	var options = {
		xaxis : {
			mode : "time"
		}
	};
	liveTmChart = $.plot($("#liveTmChart"), chartData, options);
}

function setupChartOptionsForm() {
	$("#maxPointsInput").val(maxDataSeriesSize);

	$("#chartOptionsForm").submit(function(event) {
		maxDataSeriesSize = $("#maxPointsInput").val();
	});
}


function setupEastAccordion() {
	$("#accordion").accordion();
}

function setupChosen() {
	$(".chzn-select").chosen(); // Activate chosen plugin
	$(".chzn-select-deselect").chosen({
		allow_single_deselect : true
	});
	$("#parametersList").change(parameterSelectionChanged);
}

/**
 * Sets up the web socket and it's callbacks.
 */
function setupWebsocket() {
	var wsProtocol;

	if (location.protocol == "http:") {
		wsProtocol = "ws:";
	} else {
		wsProtocol = "wss:";
	}

	var liveTmWebsocket = $.gracefulWebSocket(wsProtocol + "//" + host + ":" + location.port + url + "tmsock");

	liveTmWebsocket.onopen = function() {
		console.log("Websocket connection established.");
	};

	liveTmWebsocket.onmessage = function(event) {
		if(live) {
			plotParameter($.parseJSON(event.data));
		}
	};
}

/**
 * Calls the Halcyon restful web service to gather the TM parameters list then
 * updated the TM list on the page.
 */
function getTelemetryList() {
	var jqxhr = $.getJSON(rootURL + "tm/parameters");

	jqxhr.done(function(parsedResponse, statusText, jqXhr) {
		updateTelemetry(jQuery.parseJSON(jqXhr.responseText));
	});
}

/**
 * Accepts an array of parameters (Hbird commons tmtc Parameter) and adds them
 * to the parameter selection form as options.
 * 
 * @param param
 */
function updateTelemetry(param) {
	$("#telemetryList").empty();
	$.each(param, function(i) {
		console.log("Adding parameter");
		$("#parametersList").append(new Option(param[i].name, param[i].qualifiedName,false, false));
	});
	$("#parametersList").trigger("liszt:updated");
}

/**
 * [ { label: "Foo", data: [ [10, 1], [17, -14], [30, 5] ] }, { label: "Bar",
 * data: [ [11, 13], [19, 11], [30, -7] ] } ]
 * 
 * @param parameter
 *            JS object of Parameter object.
 */
function plotParameter(parameter) {
	// Get the parameters series data and append the new data to it. If the
	// series does not exist return and do nothing.
	var parameterSeries = getSeriesData(parameter.qualifiedName);
	if (typeof parameterSeries === "undefined") {
		return;
	}

	// Push the new data into the parameter series array and remove the oldest
	// entry if the array
	// has grown too large.
	var size = parameterSeries
			.push([ parameter.receivedTime, parameter.value ]);
	if (size >= maxDataSeriesSize) {
		parameterSeries.shift();
	}

	// Create the new data for the chart by added all seriesData to a new array
	// and setting on the plot.
	var newData = [];
	for ( var i in seriesData) {
		newData.push({
			"label" : i,
			"data" : seriesData[i]
		});
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
	if (name in seriesData) {
		return seriesData[name];
	}
}

/**
 * Called when parameter combo-box selection has changed.
 */
function parameterSelectionChanged() {
	$("select option:selected").each(function() {
		createDataSeries($(this).val());
	});
}

/**
 * series data format as follows: [ { qualifiedName:[], qualifiedName:[] } ]
 * 
 * FIXME Will not remove existing plot lines that have been deselected.
 * 
 */
function createDataSeries(name) {
	if (name in seriesData) {
		console.log("Series already exists for " + name);
		return;
	}

	var data = [];
	seriesData[name] = data;
	console.log("Series created for " + name);
}
