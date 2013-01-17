// The root URL for the RESTful services
var host = window.location.hostname;
var url = "/hbird/halcyon/";
var rootURL = location.protocol + "//" + host + ":" + location.port + url;
var halcyonUrl = location.protocol + "//" + host + ":" + location.port + "/hbird/halcyon/";

var cols;

var dragSrcEl = null;

jQuery(document).ready(function() {
	setupJqueryDefaults();
	setupWebsocket();

	cols = $("#columns .column");
	[].forEach.call(cols, function(col) {
		addDragListeners(col);
	});
	$(".column").resizable();

	$("button").button();

	$("#wizard").smartWizard({onFinish:onFinishCallback});

	setupWidgetControlPanel();
});

function addDragListeners(col) {
	col.addEventListener("dragstart",	handleDragStart, false);
	col.addEventListener("dragover",	handleDragOver,  false);
	col.addEventListener("dragenter",	handleDragEnter, false);
	col.addEventListener("dragleave",	handleDragLeave, false);
	col.addEventListener('drop',		handleDrop,      false);
	col.addEventListener('dragend',		handleDragEnd,   false);
}

function onFinishCallback(aElements) {
	// for wizard widget creation.
}

var widgetNum = 0;
function setupWidgetControlPanel() {
	$("#hideControlPanel").click(function() {
		// TODO Add a way to unhide the panel!
		// $("#controlPanel").toggle();
	});

	$("#addParameterMonitor").click(function() {
		addNewParameterMonitorWidget();
	});
}

function addNewParameterMonitorWidget() {
	var widgetHtml = "<div id=\"" + widgetNum + "\" class=\"column\" draggable=\"true\"><header>New monitor</header></div>";
	var widget = $(widgetHtml);
	createMonitorSearchForm(widgetNum).appendTo(widget);
	createMonitorDiv(widgetNum).appendTo(widget);
	widget.appendTo("#columns");
	widget.resizable();
	addDragListeners(widget[0]);
	widgetNum++;
}

function createMonitorDiv(id) {
	var div = $("<div id=\"monitorDiv" + id + "\">");
	return div;
}

function createMonitorSearchForm(id) {
	var searchDiv = $("<div id=\"searchSection" + id + "\">");
	var input = $("<input id=\"parameterSearch\" list=\"parameterList" + id + "\" type=\"search\" results=5 placeholder=\"Type parameter name\"" +
						" autofocus=\"autofocus\">")
				.addClass("wide");
	
	// TODO parameterList datalist can be moved to a single location shared by all widgets right? - Mark
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


function configureMonitorDiv(id, inputValue) {
	console.log("configuring monitor div " + id);
	var mDiv = $("#monitorDiv" + id);
	mDiv.append("<h4>" + inputValue + "</h4>");
	
	mDiv.append("<div id=\"value" + inputValue + "\"></div>");
}


function handleDragStart(e) {
	// this / e.target is the source node.
	$(this).addClass("dragging");
	
	dragSrcEl = this;
	e.dataTransfer.effectAllowed = "move";
	e.dataTransfer.setData("text/html", this.innerHTML);
}

function handleDragOver(e) {
	if (e.preventDefault) {
		// Necessary. Allows us to drop.
		e.preventDefault();
	}

	e.dataTransfer.dropEffect = "move";

	return false;
}

function handleDragEnter(e) {
	// this / e.target is the current hover target.
	$(this).addClass("over");
}

function handleDragLeave(e) {
	// this / e.target is previous target element.
	$(this).removeClass("over");
	console.log("drag leave finished");
}


function handleDrop(e) {
	// this / e.target is current target element.
	if (e.stopPropagation) {
		// stops the browser from redirecting.
		e.stopPropagation();
	}

	// Don't do anything if dropping the same column we're dragging.
	if (dragSrcEl != this) {
		// Set the source column's HTML to the HTML of the column we dropped on.
		dragSrcEl.innerHTML = this.innerHTML;
		this.innerHTML = e.dataTransfer.getData("text/html");
	}

	return false;
}

function handleDragEnd(e) {
	$(".column").removeClass("over");
	$(".column").removeClass("dragging");
	
	// FIXME Not working! - Mark
	$(".column").each(function(i) {
		console.log("Resetting resizable for " + $(this).attr("id"));
		$(this).resizable("option", {
			minHeight: $(this).height(),
			maxWidth: $(this).width()
		});
	});
	
	console.log("Drag end finished");
}

function setupJqueryDefaults() {
	// Set json as default content-type for ajax. Since we are only sending JSON it means 
	// we can use the shorthand post. 
	$.ajaxSetup({
	    contentType: "application/json; charset=UTF-8"
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
