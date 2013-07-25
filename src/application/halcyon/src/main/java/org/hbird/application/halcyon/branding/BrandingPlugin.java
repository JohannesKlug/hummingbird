package org.hbird.application.halcyon.branding;


public interface BrandingPlugin {
	String getMcsName();

	String getMissionName();

	String getFooterMessage();

	String getWelcomeHeader();

	String getWelcomeContent();

	String getHelpUrl();
}
