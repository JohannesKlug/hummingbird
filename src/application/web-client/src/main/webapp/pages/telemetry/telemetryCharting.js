// The root URL for the RESTful services
var host = window.location.hostname;
var url = "/hbird/halcyon/";
var rootURL = location.protocol + "//" + host + ":" + location.port + url;

var live = true;

/** 
 * A map of all parameters added to the chart. 
 * Key is name, value is qualifiedName.
 */
var parametersPlotted = {};

/**
 * Series data format as follows: { name : [], name : [] }
 */
var seriesData = [];
var chartData = new Array();
//		{
//	label : "Foo",
//	data : [ [ 10, 1 ], [ 17, -14 ], [ 30, 5 ] ]
//});
// for css styling ^
var liveTmChart;

var rollChartIntervalId;
var rollingChart;

var maxDataSeriesSize = 400;

var omniSearchInput;

var chartCreated = false;

var unitDescriptions;


// -----------------

/**
 * On page ready do the following.
 */
jQuery(document).ready(function() {
	setupJqueryDefaults();
	setupVariables();
	setupOmniSearch();
	setupWebsocket();
	setupChartOptionsForm();
	setupControls();
	cacheUnitDescriptions();
});

function cacheUnitDescriptions() {
	var url = rootURL + "parameter/unit/all";
	$.getJSON(url, null, function(data, textStatus, jqXHR) {
		unitDescriptions = jQuery.parseJSON(jqXHR.responseText);
		console.log(unitDescriptions);
	});
}

function setupControls() {
	setupTimeRangeSlider();
	setupArchiveSubmit();

	$("#goLiveButton").click(function(){
		var clear = liveTmChart.getData();
		clear = [];
		for(name in seriesData) {
			console.log("Switching to live; clearing data in " + name);
			seriesData[name] = [];
		}
		liveTmChart.setData(clear);
    	liveTmChart.setupGrid();
    	liveTmChart.draw();
		live = true;
	});
}

function setupArchiveSubmit() {
	$("#dateRangeOptionsForm").submit(function() {
		plotArchiveRequest();
	});
}

function plotArchiveRequest() {
	live = false;
	var dateRange = $("#dateRangeSlider").dateRangeSlider("values");
	
	var qualifiedNames = [];
	for(var key in parametersPlotted) {
		qualifiedNames.push(parametersPlotted[key]);
	}

	var queryRequest = new Object();
	queryRequest.startTime = dateRange.min.getTime();
	queryRequest.endTime = dateRange.max.getTime();
	queryRequest.parameterQualifiedName = qualifiedNames;
	queryRequest.sortColumn = "receivedTime";
	
	$.post(rootURL + "tm/parameterarchive/hbirdquery", JSON.stringify(queryRequest), function(results) {
		if(results.length === 0) {
			noDataReceived();
			return;
		}
		plotArchivedData(results);
	},
	"json");
}

function noDataReceived() {
	$('#liveTmChart').empty();
	$('#overview').empty();
	$('#chartPlaceholder').remove();
	$('<div/>').html("We don't seem to have any records for the requested parameters and given time range.").attr("id", "chartPlaceholder").appendTo('#liveTmChart');
	for(var key in parametersPlotted) {
		$('<p/>').append(key).appendTo('#chartPlaceholder');
	};
	$('<div/>').html("Sorry! Although it's not really our fault ;)").appendTo('#chartPlaceholder');
}

/**
 * Used for archive chart updates. 
 * Clears the existing data.
 * Creates or obtains series data for each parameter
 * Creates a new data array in the flot format
 * Creates a new plot with the flot data array.
 * 
 * @param parameters
 */
function plotArchivedData(parameters) {
	// We must clear out the old data otherwise we'll append the new data.
    seriesData = [];

    var series;
    var flotDataArray = [];
    // for every parameter...
	$.each(parameters, function(i) {
		// check if we have an existing series, if not create it and add it to the flot data
		// array with a label.
		series = getSeriesData(parameters[i].name);
		if(series === null) {
			series = createSeriesData(parameters[i].name, parameters[i].qualifiedName);

			flotDataArray.push({
				"label" : parameters[i].name,
				"data" : series
			});
		}
		// once we have a series, existing or newly created, we can add the data to it.
		series.push([parameters[i].receivedTime, parameters[i].value ]);
	});

	setNumParametersChartInfo(parameters.length);
	$("#chartInfo").addClass("visible");
	
	createChart(flotDataArray);
}


function setNumParametersChartInfo(num) {
	$("#numParametersPlotted").text(num);
}


function setupJqueryDefaults() {
	// Set json as default content-type for ajax. Since we are only sending JSON it means 
	// we can use the shorthand post. 
	$.ajaxSetup({
	    contentType: "application/json; charset=UTF-8"
	});
}

function setupTimeRangeSlider() {
	var future = $.post(url + "tm/parameterarchive/queryMin", "receivedTime", function(data, textStatus, jqXHR) {
		console.log("success");
		
		var maxRange = new Object();
		maxRange.days = $("#maxRangeInput").val();
		
		var timestamp = jQuery.parseJSON(jqXHR.responseText).receivedTime;
		var defaultUpper = new Date(timestamp);
		defaultUpper.setDate(defaultUpper.getDate() + maxRange.days);
		
		$("#dateRangeSlider").dateRangeSlider({
			bounds: { 
				min: timestamp, 
				max: new Date().valueOf()
			},
			defaultValues: {
				min: timestamp,
				max: defaultUpper.valueOf()
			},
			range: {
				min: false,
				max: maxRange
			}
		});
	}, 
	"json");
	
	future.error(function() {
		$("#dateRangeSlider").dateRangeSlider();
		$("#dateRangeSlider").removeClass("visible");
	});
	
	$("#maxRangeInput").change(function() {
		var newMax = $(this).val();
		if(newMax == false) {
			newMax = false;			
		}
		else {
			newMax = {"days" : $(this).val()};			
		}
		$("#dateRangeSlider").dateRangeSlider("option", "range", {
			min:false,
			max: newMax
		});
	});
	
}

function setupVariables() {
	omniSearchInput = $("#parameterAddInput");
}

function setupOmniSearch() {
	// Populate auto-complete datalist over AJAX request to Halcyon web-service in Hbird.
	$("#parameterAddInput").on("input", function(e) {
		var val = $(this).val();
		if(val < 1) {
			return;
		}
		var url = rootURL + "tm/parameters/";
		$.getJSON(url + val, null, function(data, textStatus, jqXHR) {
			parameters = jQuery.parseJSON(jqXHR.responseText);
			var parameterList = $("#parameterList");
			parameterList.empty();
			$.each(parameters, function(i) {
				parameterList.append(new Option(parameters[i].qualifiedName, parameters[i].name, false, false));
			});
		});
	});
	
	// On submit
	$("#parameterAddForm").submit(function() {
		var input = omniSearchInput.val();
		var option = $("#parameterList").children();
		var found = false;
		$.each(option, function(i) {
			console.log("input = " + input + ". child val = " + $(option[i]).val());
			if(input === option.val()) {
				if(getSeriesData(input) !== null) {
					notifyUserInfo("Not necessary", input + " already added!");
					found = true;
					return false;
				}

				// create the series so we are ready for live data immediately.
				createSeriesData(input, option.text());
				found = true;
				notifyUserSuccess("Added parameter", input);
				return false;
			}
		});

		if(!found) {
			notifyUserError("Search failure", "Could not find a parameter called " + input);
		}

		return false;
	});
}

function getChartOptions() {
	return {
		series : {
			lines : { 
				show : true,
				lineWidth: 0.2
			},
			points : { show : true},
			shadowSize : 0
		},
		grid : {
			show: true,
		    aboveData: false,
		    color: "rgb(40,40,40)",
		    hoverable: true,
			clickable: true
		},
		xaxis : {
			mode : "time",
			timezone: "UTC",
			color : "rgb(99,99,99)"
		},
		yaxis : {
			color : "rgb(99,99,99)"
		},
		legend : {
			backgroundColor : "#999",
			container : $("#legend"),
		    noColumns: 3
		},
		selection : {
			mode : "xy"
		}
	};
}

function getOverviewChartOptions() {
	return {
		legend : {
			show : false,
		},
		series : {
			lines : { 
				show : true,
				lineWidth: 1,
			},
			shadowSize : 0
		},
		xaxis: {
			ticks: []
		},
		yaxis: {
			ticks: [],
		},
		grid : {
			color: "rgb(40,40,40)",
		},
		selection : {
			mode : "xy"
		}
	};
}

function createChart(data) {
	if(!$("#chartArea").hasClass("visible")) {
		$("#chartArea").addClass("visible");
	}
	
	$(".chartInfo").show();
	$("#liveTmChart").css("border", "none");
	
	mainPlotSelection = $("#liveTmChart");
	
	liveTmChart = $.plot("#liveTmChart", data, getChartOptions());
	var overview = $.plot("#overview", data, getOverviewChartOptions());

	mainPlotSelection.on("plotselected", function(event, ranges) {
		if(live) {
			return;
		}
		// clamp the zooming to prevent eternal zoom
		if (ranges.xaxis.to - ranges.xaxis.from < 0.00001) {
			ranges.xaxis.to = ranges.xaxis.from + 0.00001;
		}
		if (ranges.yaxis.to - ranges.yaxis.from < 0.00001) {
			ranges.yaxis.to = ranges.yaxis.from + 0.00001;
		}

		// do the zooming
		liveTmChart = $.plot("#liveTmChart", data, 
			$.extend(true, {}, getChartOptions(), {
					xaxis : {
						min : ranges.xaxis.from,
						max : ranges.xaxis.to
					},
					yaxis : {
						min : ranges.yaxis.from,
						max : ranges.yaxis.to
					}
				}
			)
		);

		// don't fire event on the overview to prevent eternal loop
		overview.setSelection(ranges, true);
	});
	
	$("#overview").on("plotselected", function(event, ranges) {
		if(live) {
			console.log("overview plotselected handler returning as we are in live mode");
			return;
		}
		liveTmChart.setSelection(ranges);
	});
	
	mainPlotSelection.dblclick(function() {
		liveTmChart = $.plot("#liveTmChart", data, getChartOptions());
		overview = $.plot("#overview", data, getOverviewChartOptions());
	});

	var previousPoint = null;
	mainPlotSelection.bind("plothover", function (event, pos, item) {
		if (item) {
			if (previousPoint != item.dataIndex) {
				previousPoint = item.dataIndex;
				
				$("#chartTooltip").remove();
				showTooltip(item.pageX, item.pageY, item.datapoint[1]);
			}
		} 
		else {
			$("#chartTooltip").remove();
			previousPoint = null;
		}
	});
	
	var previousClicked = null;
	mainPlotSelection.bind("plotclick", function (event, pos, item) {
		if (item) {
			if (previousClicked != item.dataIndex) {
				previousClicked = item.dataIndex;
				$("#chartTooltip").empty();
				$('#plotPointDetail').empty();
				$('#plotPointDetail').hide();
				showPlotPointDetail(item.pageX, item.pageY, item);
			}
		}
		else {
			$('#plotPointDetail').empty();
			$('#plotPointDetail').hide();
			previousClicked = null;
		}
	});

	$("#overview").dblclick(function() {
		liveTmChart = $.plot("#liveTmChart", data, getChartOptions());
		overview = $.plot("#overview", data, getOverviewChartOptions());
	});
	
//	setupInteractiveLegend();

	chartCreated = true;
}

function setupInteractiveLegend() {
	$("#legend").delegate('td', 'click', function() {
		var td = $(this);
		if(td.hasClass("legendColorBox")) {
			removePlot(td.next('td').text());			
		}
		else {
			removePlot(td.text());
		}
	});
}

function removePlot(seriesName) {
	deleteSeries(seriesName);
	delete parametersPlotted[seriesName];
	plotArchiveRequest();
}

function setupChartOptionsForm() {
	$("#maxPointsInput").val(maxDataSeriesSize);

	$("#chartOptionsForm").submit(function(event) {
		maxDataSeriesSize = $("#maxPointsInput").val();
	});
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

	var liveTmWebsocket = $.gracefulWebSocket(wsProtocol + "//" + host + ":"
			+ location.port + url + "websocket");

	liveTmWebsocket.onopen = function() {
		console.log("Websocket connection established.");
	};

	liveTmWebsocket.onmessage = function(event) {
		if (live) {
			var message = $.parseJSON(event.data);
			if(message.id === "LIVE_TM") {
				plotParameter(message.content);
			}
		}
	};
}

/**
 * Calls the Halcyon restful web service to gather the TM parameters list then
 * updated the TM list on the page.
 */
function retreiveTmList() {
	var jqxhr = $.getJSON(rootURL + "tm/parameters");

	jqxhr.done(function(parsedResponse, statusText, jqXhr) {
		updateTelemetryList(jQuery.parseJSON(jqXhr.responseText));
	});
}

/**
 * Accepts an array of parameters (Hbird commons tmtc Parameter) and adds them
 * to the parameter selection form as options.
 * 
 * @param param
 */
function updateTelemetryList(param) {
	$("#telemetryList").empty();
	$("#parametersList").trigger("liszt:updated");

	$.each(param, function(i) {
		$("#parametersList").append(new Option(param[i].qualifiedName, param[i].name, false, false));
		$("#datalist1").append(new Option(param[i].qualifiedName, param[i].name, false, false));
	});
	
}

/**
 * 
 * Called on tm reception at websocket when Live plotting. 
 * [ 
 * 	{ label: "Foo", data: [ [10, 1], [17, -14], [30, 5] ] }, 
 * 	{ label: "Bar", data: [ [11, 13], [19, 11], [30, -7] ] } 
 * ]
 * 
 * @param parameter
 *            JS object of Parameter object.
 */
function plotParameter(parameter) {
	// Get the parameters series data and append the new data to it. If the
	// series does not exist return and do nothing.
	var series = getSeriesData(parameter.name);
	if (series === null) {
		return;
	}

	// Add the new data and shift array if it's is at the size limit (maxDataSeriesSize).
	if(series.push([parameter.receivedTime, parameter.value]) >= maxDataSeriesSize) {
		series.shift();
	};

	// Create the new data for the chart by added all seriesData to a new array
	// and setting on the plot.
	// FIXME Crap array copying code. Don't even need to do it! Idiot.
	var newData = [];
	var totalPlottedPoints = 0;
	for(var i in seriesData) {
		newData.push({
			"label" : i,
			"data" : seriesData[i]
		});
		totalPlottedPoints += seriesData[i].length;
	}

	$("#chartInfo").addClass("visible");
	setNumParametersChartInfo(totalPlottedPoints);

	// Redraw
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
	if (name in seriesData) {
		return seriesData[name];
	}
	return null;
}

function deleteSeries(name) {
	if(name in seriesData) {
		delete seriesData[name];
	}
}

/**
 * Creates or retrieves and existing series data given the parameter name and returns
 * it.
 * 
 * 
 * 
 * FIXME Will not remove existing plot lines that have been deselected.
 * 
 */
function createSeriesData(name, qualifiedName) {
	var existingSeries = getSeriesData(name);
	if(existingSeries) {
		return existingSeries;
	}

	seriesData[name] = [];
	parametersPlotted[name] = qualifiedName;
	
	return seriesData[name];
}

function showPlotPointDetail(x, y, plotItem) {
	var modal = $('#plotPointDetail').css({top: y + 5, left: x + 5});
	modal.fadeIn(100);
	
	$("<h4/>").append(plotItem.series.label).appendTo(modal);
	$("<p/>").append('Value: ' + plotItem.datapoint[1]).appendTo(modal);
	$("<p/>").append('Received: ' + new Date(plotItem.datapoint[0])).appendTo(modal);
	$("<p/>").append('Point ' + plotItem.dataIndex + ' of ' + plotItem.series.data.length + ' in the series.').appendTo(modal);
}

/**
 * Creates and appends a tooltip div to the body at the given absolute position and populated with 
 * the provide contents.
 * @param x
 * @param y
 * @param contents
 */
function showTooltip(x, y, contents) {
	$("<div id='chartTooltip'>" + contents + "</div>").css({
		position: "absolute",
		display: "none",
		top: y + 5,
		left: x + 5,
	}).appendTo("body").fadeIn(200);
}

function notifyUserSuccess(title, message) {
	$.pnotify({
	    title: title,
	    text: message,
	    type: "success"
	});
}

function notifyUserInfo(title, message) {
	$.pnotify({
		title: title,
		text: message,
		type: "info"
	});
}

function notifyUserError(title, message) {
	$.pnotify({
	    title: title,
	    text: message,
	    type: "error",
	    icon: "picon picon-page-zoom"
	});
}


