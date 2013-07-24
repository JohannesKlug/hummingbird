var rootUrl = location.protocol + "//" + window.location.hostname + ":" + location.port;
var rootHbirdwebUrl = rootUrl + "/hbirdweb/";
var halcyonUrl = rootUrl + '/hbird/halcyon/';

var welcomeDiv;

/**
 * On page ready do the following.
 */
jQuery(document).ready(function() {
	setupSelectors();
	positionWelcomeText();
	addWelcomeText();
});

function setupSelectors() {
	welcomeDiv = $('#welcome');
}

// gets the backdrop image text position and then positions the welcome text accordingly.
function positionWelcomeText() {
	var position = getBackdropTextPosition();
	switch(position) {
		case 'left' :
			welcomeDiv.css('float', 'left');
			break;
		case 'right' :
			welcomeDiv.css('float', 'right');
			break;
		default:
			//error
	}
}


function addWelcomeText() {
	$.get(halcyonUrl + 'branding/welcomeHeader', null, function(data, textStatus, jqXHR) {
		$('#welcomeHeader').html('<h4>' + jqXHR.responseText + '</h4>');		
	}, 'text');
	
	$.get(halcyonUrl + 'branding/welcomeContent', null, function(data, textStatus, jqXHR) {
		$('#welcomeContent').html(jqXHR.responseText);		
	}, 'text');
	
}