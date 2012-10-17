// The root URL for the RESTful services
var host = "localhost";
var port = "8181";
var url = "/hbird/halcyon/";
var rootURL = "http://"+ host + ":" + port + url;

var ws = $.gracefulWebSocket("ws://"+ host + ":" + port + url + "tmsock");

var smoothie = new SmoothieChart({
	labels : { 
		fillStyle:'rgb(255, 255, 255)'
	},
	minValue: "0",
	maxValue: "450"
});


var plotLines = [];

var seriesData = [];
var seriesGraphIndexMap = [];
var liveTmChart;

//-----------------


jQuery(document).ready(function() {
	setupLayout();
	setupWebsocket();
	$(".chzn-select").chosen(); // Activate chosen plugin
	$(".chzn-select-deselect").chosen({allow_single_deselect:true});
	$("#parametersList").change(parameterSelectionChanged);

	getTelemetryList();

//	smoothie.streamTo(document.getElementById("tmRealTimeChart"), 1500);
	liveTmChart = $.jqplot("chartdiv", [new Array(1)], {
		axes: {
            xaxis: {
                renderer: $.jqplot.DateAxisRenderer,
                tickOptions: {
                    formatString: '%H-%M-%S'
                },
                numberTicks: 10
            }
        }
	});
});

function setupLayout() {
	$('body').layout({
		applyDefaultStyles: true 
	});
}

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
	// Get the parameters series data and append the new data to it. If the
	// series does not exist return and do nothing.
	var parameterSeries = getSeriesData(parameter.qualifiedName);
	if(typeof parameterSeries === "undefined") {
		return;
	}
	parameterSeries.push([parameter.receivedTime, parameter.value]);

	// Find the index of the series in the jqPlot and append the new data
	var seriesIndex = seriesGraphIndexMap[parameter.qualifiedName];
	if(liveTmChart.series.length <= seriesIndex) {
		console.log("Parameter does not have a series in the chart!");
		liveTmChart.series[seriesIndex] = parameterSeries; // Can't do this
	}
	else {
		var series = liveTmChart.series[seriesIndex];
		series.data = parameterSeries;
	}

	// reconfigure and replot (draws the updated plots).
	liveTmChart.resetAxesScale();
	liveTmChart.replot(false);
}

function getSeriesData(name) {
	if(name in seriesData) {
//		console.log("Found existing series for " + name);
		return seriesData[name];
	}
}

function parameterSelectionChanged() {
	$("select option:selected").each(function () {
		createDataSeries($(this).val());
	});
}

// FIXME Will not remove existing plot lines that have been deselected.
var seriesIndex = 0;
function createDataSeries(name) {
	if(name in seriesData) {
		console.log("Series already exists for " + name);
		return;
	}

	var data = [];
	seriesData[name] = data;
	seriesGraphIndexMap[name] = seriesIndex++;
	console.log("Series created for " + name + " indexed at " + seriesGraphIndexMap[name]);
}

/**
 * Creates a line in the PlotLines array for the given plotName.
 * If line already exists it does nothing.
 * @param plotName
 */
//function createPlotLine(plotName) {
//	console.log("Creating plot line for " + plotName);
//	for(var i in plotLines) {
//		if(plotLines[i] == plotName) {
//			return;
//		}
//	}
//	
//	// If we got here there is no plot for plotName so we create a new one.
//	
//	var line = new TimeSeries();
//	plotLines[plotName] = line;
//	var colour = "rgb(" + Math.round(Math.random()*256) + ", "+Math.round(Math.random()*256)+", "+Math.round(Math.random()*256)+")";
//	console.log(colour);
//	smoothie.addTimeSeries(line, {strokeStyle:colour, lineWidth:3});
//}



