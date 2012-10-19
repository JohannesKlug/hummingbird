var menus,
 	tmMenu,	
 	subMenu,
 	closeSubMenuBtn;
var currentIndex = 0;

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

/**
 * Setup menu and submenus.
 */
function setupMenu() {
	menus.click(function() {
		// Style menu buttons
		$("#topMenu a").removeClass("activeMenuLink");
		$(this).toggleClass("activeMenuLink");
		
		var menuIndex = $(this).parent().index();
		if(currentIndex != menuIndex) {
			if(!subMenu.hasClass("subMenuOpen")) {
				subMenu.toggleClass("subMenuOpen");
			}
		}
		else {
			subMenu.toggleClass("subMenuOpen");
			if(!subMenu.hasClass("subMenuOpen")) {
				$(this).toggleClass("activeMenuLink");
			}
		}
		currentIndex = menuIndex;
		
		var divIndex = menuIndex + 1; // +1 to ignore close button in subMenu HTML.
		// Open a subMenuContent and hide the others.
		var active = $($("#subMenu").children().get(divIndex)).addClass("subMenuOpen");
		$($("#subMenu").children().not(active)).removeClass("subMenuOpen");
		
		// Change backdrop
		$("#backdrop img").removeClass("opaque");
		$("#backdrop img").eq(menuIndex).addClass("opaque");
	});
	
	closeSubMenuBtn.click(function() {
		subMenu.removeClass("subMenuOpen");
	});
}

