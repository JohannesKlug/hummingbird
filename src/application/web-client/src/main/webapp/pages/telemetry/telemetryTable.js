// The root URL for the RESTful services
var host = window.location.hostname;
var url = "/hbird/halcyon/";
var rootURL = location.protocol + "//" + host + ":" + location.port + url;
var ws;

var table;
var maxRows = 500;

var live = true;

var startTime;
var endTime;

/**
 * On page ready do the following.
 */
jQuery(document).ready(function() {
	setupJqueryDefaults();
	setupGlobalJqueryUi();
	setupLayout();
	setupTableOptions();
	setupArchiveFilterOptions();
	setupWebsocket();
	setupDataTable();
});

function setupJqueryDefaults() {
	// Set json as default content-type for ajax. Since we are only sending JSON it means 
	// we can use the shorthand post. 
	$.ajaxSetup({
	    contentType: "application/json"
	});
}

/**
 * Sets up all global class replacements, widgets, options etc
 */
function setupGlobalJqueryUi() {
	$("button").button();
}

/**
 * Sets up all widgets involving filtering of retrieved parameters from the
 * archive.
 */
function setupArchiveFilterOptions() {
	var from, to;
	
	from = $("#from").datetimepicker({
		changeMonth : true,
		numberOfMonths : 1,
		showWeek : true,
		showSecond : true,
		timeFormat : "hh:mm:ss",
		defaultDate : new Date(),
		onSelect : function(selectedDate) {
			to.datetimepicker("option", "minDate", selectedDate);
			startTime = $(this).datetimepicker("getDate");
		}
	});

	to = $("#to").datetimepicker({
		changeMonth : true,
		numberOfMonths : 1,
		showWeek : true,
		showSecond : true,
		timeFormat : "hh:mm:ss",
		defaultDate : new Date(),
		onSelect : function(selectedDate) {
			from.datetimepicker("option", "maxDate", selectedDate);
			endTime = $(this).datetimepicker("getDate");
		}
	});
	
	from.datepicker('setDate', new Date());
	to.datepicker('setDate', new Date());
	
	$("#filterButton").click(function() {
		startArchiveMode();
	});
	
	$("#liveButton").click(function() {
		console.log("going live");
		startLiveMode();
	});
}

function startLiveMode() {
	live = true;
}

function startArchiveMode() {
	live = false;
	var filters = new Object();
	filters.startTime = new Number(startTime.getTime());
	filters.endTime = new Number(endTime.getTime());

	var jsonString = JSON.stringify(filters);
	var request = jQuery.post(rootURL + "tm/parameterarchive/query", jsonString, function(data) {
		updateDataTable(data);
	}, "json")
	request.success(function(jqXhr, status, error) {
		console.log(status);
	});
    request.error(function(jqXHR, status, error) {
    	console.log(status + " :: " + error);
    });
    request.complete(function() {
    	console.log("Archive request complete");
    });
}

function updateDataTable(data) {
	var newData = [];
	for(var i=0; i < data.length; i++) {
		newData[i] = [data[i].name, data[i].value, new Date(data[i].receivedTime) ];
	}
	table.fnClearTable();
	table.fnAddData(newData);
}

/**
 * Sets up the form which allows the user to control how the telemetry table
 * behaves.
 */
function setupTableOptions() {
	$("#maxRowsInput").val(maxRows);

	$("#accordion").accordion({
		fillSpace : true,
		heightStyle : "fill"
	});
}

/**
 * Data format is a 3 dimensional array. The first level is an associative array
 * using keys to separate data and table metadata (i.e. config). The second
 * level (n) is a 0..n index of each row. The third level (c) is the individual
 * cell, that is, the value for row n at column c.
 * 
 * e.g. to access row 0 column 0 of the data use: tmData["aaData"][0][0]
 */
function setupDataTable() {
	var tableOptions;
	tableOptions = {
		"bJQueryUI" : true,
		"sPaginationType" : "full_numbers",
		"aaData" : [],
		"aoColumns" : [ {
			"sTitle" : "Parameter",
			"sType" : "String"
		}, {
			"sTitle" : "Value",
			"sType" : "Numeric"
		}, {
			"sTitle" : "Received Time",
			"asSorting" : [ "desc" ]
		} ],
		"aaSorting" : [ [ 2, "desc" ] ]
	};

	table = $("#tmTable").dataTable(tableOptions);
}

/**
 * Sets up the jquery ui layout.
 */
function setupLayout() {
	var layoutOptions = {
		applyDefaultStyles : true,
		north : {
			resizable : false,
			size : 50,
			minSize : 50,
			maxSize : 50
		},
		south : {
			resizable : false,
			initClosed : true
		},
		west : {
			showOverflowOnHover : true
		},
		east : {
			size : 250
		},
		east__onresize : function() {
			$("#accordion").accordion("resize");
		}
	};

	$('body').layout(layoutOptions);
}

/**
 * Sets up the web socket with the correct protocol and configures it's
 * callbacks.
 */
function setupWebsocket() {
	var wsProtocol;
	if (location.protocol == "http:") {
		wsProtocol = "ws:";
	} else {
		wsProtocol = "wss:";
	}

	ws = $.gracefulWebSocket(wsProtocol + "//" + host + ":" + location.port
			+ url + "tmsock");

	ws.onopen = function() {
		console.log("Websocket connection established.");
	};

	ws.onmessage = function(event) {
		if (live) {
			parameterReceived($.parseJSON(event.data));
		}
	};
}

/**
 * Called when a new parameter arrives at the client.
 * 
 * This method builds a new array representing the table row from the parameter
 * and adds it to the table. It then checks the maximum allowed number of rows
 * and if the table now exceeds that limit, it removes the oldest entry.
 * 
 * @param parameter
 *            the new parameter
 */
function parameterReceived(parameter) {
	var newRow = [ parameter.name, parameter.value, new Date(parameter.receivedTime) ];
	table.fnAddData(newRow);
	if (table.fnGetData().length > maxRows) {
		table.fnDeleteRow(0);
	}
}
