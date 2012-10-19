var menus,
 	tmMenu,	
 	subMenu,
 	closeSubMenuBtn,
 	currentIndex;

/**
 * On page ready do the following.
 */
jQuery(document).ready(function() {
	setupFrequentUsedDomVars();
	setupMenu();
});

function setupFrequentUsedDomVars() {
	menus = $("#topMenu a");
	tmMenu = $("#menuTm");
	subMenu = $("#subMenu");
	closeSubMenuBtn = $("#closeButton");
}

function setupMenu() {
	menus.click(function() {
		// Style menu buttons
		$("#topMenu a").removeClass("activeMenuLink");
		$(this).toggleClass("activeMenuLink");
		
		var menuIndex = $(this).parent().index();
		if(!subMenu.hasClass("subMenuOpen")) {
			subMenu.toggleClass("subMenuOpen");
		}
		var divIndex = menuIndex + 1;
		var active = $($("#subMenu").children().get(divIndex)).addClass("subMenuOpen");
		$($("#subMenu").children().not(active)).removeClass("subMenuOpen");
		
		$("#backdrop img").removeClass("opaque");
		$("#backdrop img").eq(menuIndex).addClass("opaque");
	});
	
	closeSubMenuBtn.click(function() {
		subMenu.removeClass("subMenuOpen");
	});
}

function popTmMenu() {
}