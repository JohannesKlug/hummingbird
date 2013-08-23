// Test
var czml = [ {
	"id" : "satellite",
	"availability" : "2013-04-30T00:00:00Z/2013-04-30T21:00:00Z",
	"position" : {
		"cartographicDegrees" : [ -75.0, 40.0, 0.0 ]
	},
	"billboard" : {
		"eyeOffset" : {
			"cartesian" : [ 0.0, 0.0, 0.0 ]
		},
		"horizontalOrigin" : "CENTER",
		"image" : "https://dl.dropboxusercontent.com/u/10007025/icons/UFO.png",
		"pixelOffset" : {
			"cartesian2" : [ 0.0, 0.0 ]
		},
		"scale" : 0.8333333333333334,
		"show" : [ {
			"interval" : "2012-08-04T16:00:00Z/2012-08-04T18:00:00Z",
			"boolean" : true
		} ],
		"verticalOrigin" : "BOTTOM"
	},

} ];

var cesiumWidget;

/**
 * On page ready do the following.
 */
jQuery(document).ready(function() {
	setupGlobe();
});

function setupGlobe() {
	cesiumWidget = new Cesium.CesiumWidget('cesiumContainer');
	var layers = widget.centralBody.getImageryLayers();
	layers.removeAll();
	layers.addImageryProvider(new Cesium.TileMapServiceImageryProvider({
		url : 'http://cesium.agi.com/blackmarble',
		maximumLevel : 8,
		credit : 'Black Marble imagery courtesy NASA Earth Observatory'
	}));
}