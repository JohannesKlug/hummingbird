var rootUrl = location.protocol + "//" + window.location.hostname + ":" + location.port;
var rootHbirdwebUrl = rootUrl + "/hbirdweb/";

var title,
	helpModal,
	helpMenu,
	rootHtmlElement;

/**
 * Add the following code to your html
 * 
 *	 	<div id="helpModal" class="md-modal">
 *			<h2 id="helpHeader">Help</h2>
 *			<div id="helpContent" class=md-content></div>
 *			<div id="helpControls" class=md-controls></div>
 *		</div>
 *	
 *	Wrap any element part of the 3D shift in container
 *	
 *	Add 
 *		<div class="md-overlay"></div>
 *	as the final element of the body
 *	
 */
jQuery(document).ready(function() {
	if(!grabHelpMenu()) {
		console.log("No help menu item, bailing out.");
		return;
	}
	
	if(!setupHelpDiv()) {
		console.log("No hbird-help div in HTML, bailing out.");
		return;
	}
	
	rootHtmlElement = $(document.documentElement);
	title = $(document).attr('title');
	
	populateHelpModal();
	setupHelpMenuLink();
});

/**
 * Loads HTML from the help pages folder using the page title as the filename.
 */
function populateHelpModal() {
	// Load content
	$('#helpContent').load(rootHbirdwebUrl + 'help/' + title + '.html', function(rsp, status, xhr) {
		if(status === "error") {
			$('#helpHeader').html('Help content unavailable');
			$('#helpContent').append('<p>' + xhr.status + " :: " + xhr.statusText + '</p>');
		}
	});

	addCloseButton($('#helpControls'));
}

function addCloseButton(controls) {
	var closeButton = $("<button class=md-close>I am enlightened!</button>");
	closeButton.click(function() {
		toggleHelp();
	});
	controls.append(closeButton);
}

function setupHelpMenuLink() {
	helpMenu.click(function() {
		toggleHelp();
	});
}

function grabHelpMenu() {
	helpMenu = $('#menuHelp');
	if(helpMenu.length) {
		return true;
	}
	return false;
}

/**
 * Adds the hbird-help div to the global variable.
 * 
 * @returns {Boolean} True if there is a hbird-help otherwise false.
 */
function setupHelpDiv() {
	helpModal = $('#helpModal');
	if(helpModal.length) {
		return true;
	}
	return false;
}

function toggleHelp() {
	console.log("DEBUG - showing helpDiv");
	rootHtmlElement.toggleClass('md-perspective');	
	helpModal.toggleClass('md-show');
	helpModal.toggleClass('md-effect-18');
}
