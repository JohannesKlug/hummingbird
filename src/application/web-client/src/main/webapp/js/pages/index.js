var menuContainer;


/**
 * On page ready do the following.
 */
jQuery(document).ready(function() {
	setupFrequentUsedDomVars();
	setupMenu();
});

function setupFrequentUsedDomVars() {
	menuContainer = $("#menuContainer");
}

function setupMenu() {
	$("#menuTm").click(function(){
		popTmMenu();
	});
}

function popTmMenu() {
	menuContainer.toggleClass("hidden");
	menuContainer.toggleClass("visible");
}