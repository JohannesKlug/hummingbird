// The root URL for the RESTful services
var host = window.location.hostname;
var url = "/hbird/halcyon/";
var rootURL = location.protocol + "//" + host + ":" + location.port + url;
var archiveUrl = rootURL + "tm/parameterarchive/datatablesquery";
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
	    contentType: "application/json; charset=UTF-8"
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
	var from, to = null;
	
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
	toggleTableModeSettings(false);
	table.fnClearTable();
	live = true;
}

function startArchiveMode() {
	live = false;
	toggleTableModeSettings(true);
	table.fnDraw();
}

/**
 * Given a state parameter representing whether we are switching to archive or 
 * live mode this function alters the table settings between server-side and
 * client-side processing.
 * 
 * @param archive if true archive mode, if false live mode.
 */
function toggleTableModeSettings(archive) {
	var settings = table.fnSettings();
	// If archive change the table to use server-side processing and provide a 
	// custom function for retrieving the data via Ajax. We want to use a POST
	// method so we can send filter data to a JAX RS restful service.
	if(archive) {
		console.log("changing table settings to archive mode");
		settings.oFeatures.bServerSide = true;
		settings.fnServerData = function(sSource, aoData, fnCallback, oSettings) {
			console.log("fnServerData triggered; sending aoData:");
			aoData.push({"name" : "startTime", "value" : startTime.getTime()});
			aoData.push({"name" : "endTime", "value" : endTime.getTime()});
			oSettings.jqXHR = $.ajax( {
		        "dataType": "json",
		        "type": "POST",
		        "url": archiveUrl,
		        "data": JSON.stringify(aoData),
		        "success": fnCallback
		     });
			
			oSettings.jqXHR.success = function() {
				console.log("Request successful");
			};
		};
	}
	// else we are going to live mode and need to switch the table settings back to 
	// client side processing.
	else {
		settings.oFeatures.bServerSide = false;
		settings.fnServerData = null;
	}
}

/**
 * Sets up the form which allows the user to control how the telemetry table
 * behaves.
 */
function setupTableOptions() {
	$("#maxRowsInput").val(maxRows);
	$("#maxRowsInput").submit(function(){
		console.log($(this).val());
		maxRows = $(this).val();
	});

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
			"sType" : "String",
			"mData" : "name",
			"mRender": function(data, type, full) {
				return data;
			}
		}, {
			"sTitle" : "Value",
			"sType" : "Numeric",
			"mData" : "value",
			"mRender": function(data, type, full) {
				return data;
			}
		}, {
			"sTitle" : "Received Time",
			"mData" : "receivedTime",
			"mRender": function(data, type, full) {
				return new Date(new Number(data));
			},
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
	var newRow = [ parameter ];
	table.fnAddData(newRow);
	if (table.fnGetData().length > maxRows) {
		table.fnDeleteRow(0);
	}
}
