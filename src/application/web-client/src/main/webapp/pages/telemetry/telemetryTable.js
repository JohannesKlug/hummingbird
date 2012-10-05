// The root URL for the RESTful services
var host = window.location.hostname;
var url = "/hbird/halcyon/";
var rootURL = location.protocol + "//"+ host + ":" + location.port + url;
var ws;

var table;
var maxRows = 500;


/**
 * On page ready do the following.
 */
jQuery(document).ready(function() {
	setupLayout();
	setupTableOptions();
	setupWebsocket();
	setupDataTable();
});

function setupTableOptions() {
	$("#maxRowsInput").val(maxRows);
}

/**
 * Data format is a 3 dimensional array.
 * The first level is an associative array using keys to separate data and table metadata (i.e. config).
 * The second level (n) is a 0..n index of each row.
 * The third level (c) is the individual cell, that is, the value for row n at column c.
 * 
 * e.g. to access row 0 column 0 of the data use: 
 * tmData["aaData"][0][0]
 */
function setupDataTable() {
	var tableInputData;
	tableInputData = { 
		"aaData": [ 
		],
		"aoColumns": [
	              { 
	            	  "sTitle"	: "Parameter",
	            	  "sType"	: "String"
	              },
	              { 
	            	  "sTitle"	: "Value",
	            	  "sType"	: "Numeric"
	              },
		          { 
	            	  "sTitle"		: "Received Time",
	            	  "asSorting"	: ["desc"]
		          }
		],
		"aaSorting" : [
		          [2, "desc"]
	    ]
	};
			
	table = $("#tmTable").dataTable(tableInputData);	
}

/**
 * Sets up the jquery ui layout.
 */
function setupLayout() {
	var layoutOptions = { 
		applyDefaultStyles: true,
		north: {
			resizable		: false,
			size			: 50,
			minSize			: 50,
			maxSize			: 50
		},
		south: {
			resizable		: false,
			initClosed		: true
		}
	};
	
	$('body').layout(layoutOptions);
}

/**
 * Sets up the web socket with the correct protocol and configures it's callbacks.
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
		parameterReceived($.parseJSON(event.data));   
	};
}

/**
 * Called when a new parameter arrives at the client.
 * 
 * @param parameter the new parameter
 */
function parameterReceived(parameter) {
	var newRow = [parameter.name , parameter.value, new Date(parameter.receivedTime)];
	table.fnAddData(newRow);
	if(table.fnGetData().length > maxRows) {
		table.fnDeleteRow(0);
	}
}

