/**
 * Hidget = hbird widget 
 */

/** The root URL for the RESTful services */
var host = window.location.hostname;
var url = "/hbird/halcyon/";
var rootURL = location.protocol + "//" + host + ":" + location.port + url;
var halcyonUrl = location.protocol + "//" + host + ":" + location.port + "/hbird/halcyon/";

var gridster;

var colours = ["metroPurple",
               "metroMagenta",
               "metroTeal",
               "metroLime",
               "metroBrown",
               "metroPink",
               "metroOrange",
               "metroBlue",
               "metroRed",
               "metroGreen"];

/** Map of object references to all hidgets to save using dom selection. Keyed on id. */
var hidgets = {};

var defaultHidget = '<li class="hidget"><span><h3>Monitor</h3></span><button type="button" class="hidgetSettingsButton">Settings</button></li>'; 

jQuery(document).ready(function() {
	setupJqueryDefaults();
	setupWebsocket();
	setupGridster();
	setupControls();
});

var hidgetId = 0;
function setupControls() {
	$("#addParameterMonitor").click(function(){
		var hidget = gridster.add_widget(defaultHidget, 2, 1);
		var currentId = hidgetId++;
		hidget.attr("id", id="hidget" + currentId);
		createMonitorSearchForm(currentId).appendTo(hidget);
		var colourIndex = Math.floor((Math.random()*9)+1);
		hidget.addClass(colours[colourIndex]);
		
		$(".hidgetSettingsButton").button({
			icons: {
				primary: "ui-icon-gear",
				secondary: "ui-icon-triangle-1-s"
			},
		    text: false
		}).click(function() {
			console.log("Adding visible to search section " + currentId);
			$("searchSection" + currentId).addClass("visible");
		});
		
		hidgets[currentId] = hidget;
	});
}

function setupGridster() {
	$(".gridster ul").gridster({
        widget_margins: [10, 10],
        widget_base_dimensions: [140, 140]
    });
	gridster = $(".gridster ul").
				gridster({widget_margins: [10, 10]}).
				data("gridster");
}


function setupJqueryDefaults() {
	// Set json as default content-type for ajax. Since we are only sending JSON it means 
	// we can use the shorthand post. 
	$.ajaxSetup({
	    contentType: "application/json; charset=UTF-8"
	});
}


function createMonitorSearchForm(id) {
	var searchDiv = $("<div id=\"searchSection" + id + "\">").addClass("hidden");;
	var input = $("<input id=\"parameterSearch\" list=\"parameterList" + id + "\" type=\"search\" results=5 placeholder=\"Type parameter name\"" +
						" autofocus=\"autofocus\">")
				.addClass("parameterSearchInput");
	
	// TODO parameterList datalist can be moved to a single location shared by all widgets, right? - Mark
	var form = $("<form id=\"searchForm" + id + "\">")
				.append(input)
				.append("<datalist id=\"parameterList" + id + "\" >");
	
	form.appendTo(searchDiv);
	
	// Create AJAX based Restful request to build parameter list based upon input.
	input.on("input", function(e) {
		var val = $(this).val();
		if(val < 1) {
			return;
		}
		var url = halcyonUrl + "tm/parameters/";
		$.getJSON(url + val, null, function(data, textStatus, jqXHR) {
			parameters = jQuery.parseJSON(jqXHR.responseText);
			var parameterList = $("#parameterList" + id);
			parameterList.empty();
			console.log("Received: " + parameters.length);
			$.each(parameters, function(i) {
				parameterList.append(new Option(parameters[i].qualifiedName, parameters[i].name, false, false));
			});
		});
	});
	
	// On submit
	form.submit(function() {
		var inputValue = input.val();
		var option = $("#parameterList" + id).children();
		var found = false;
		console.log("Input submitted: " + inputValue);
		$.each(option, function(i) {
			console.log("input = " + inputValue + ". child val = " + $(option[i]).val());
			if(inputValue === $(option[i]).val()) {
				configureMonitorDiv(id, inputValue);
				found = true;
				return false; // this is the same as a break in the jquery each function
			}
		});
		if(!found) {
			$.pnotify({
			    title: "Search failure",
			    text: "Could not find a parameter called " + inputValue,
			    type: "error",
			    icon: "picon picon-page-zoom"
			});
		}
		return false;
	});
	
	return searchDiv;
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
			+ location.port + url + "tmsock");

	liveTmWebsocket.onopen = function() {
		console.log("Websocket connection established.");
	};

	liveTmWebsocket.onmessage = function(event) {
		if (live) {
			parameterReceived($.parseJSON(event.data));
		}
	};
}

function parameterReceived(parameter) {
	
}
