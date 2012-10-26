var series;
var started = false;

self.addEventListener("message", function(e) {
	 var data = e.data;
	 switch(data.cmd) {
		case "start":
			postMessage("Starting...");
			series = data.series;
			started = true;
			createSeries(data.parameters);
			break;
	    default:
	      postMessage("Unknown command : " + data.cmd);
	 }
}, false);

function createSeries(parameters) {
	if(!started) {
		return;
	}
	var crement = 100 / (parameters.length);
	var returnData = new Object();
	returnData.prog = 0;
	returnData.data = [];
	returnData.done = false;

	// Push the new data into the series.
	for(var i = 0; i < parameters.length; i++) {
		var series = getSeriesData(parameters[i].qualifiedName);
		series.push([parameters[i].receivedTime, parameters[i].value ]);
		returnData.prog += crement;
		postMessage(returnData);
	};
	
	returnData.done = true;
	started = false;
	postMessage(returnData);
}

function getSeriesData(qName) {
	if(!started) {
		return;
	}
	for(var i = 0; i < series.length; i++) {
		if(qName == series[i]) {
			return series[i];
		}
	}
}
