package org.hbird.application.halcyon.branding;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;

public class Branding implements BrandingPlugin {
	private final static Logger LOG = org.slf4j.LoggerFactory.getLogger(Branding.class);

	private final static String BRANDING_PROPERTIES = "/META-INF/hbird-web.properties";

	private String brandName;

	private String missionName;

	private String footerMessage;

	private String welcomeHeader;

	private String welcomeContent;

	private String helpUrl;

	public final void loadProperties() {
		Properties props = new Properties();

		// try to load the branding properties
		InputStream ins = getClass().getResourceAsStream(BRANDING_PROPERTIES);
		if (ins != null) {
			try {
				props.load(ins);
			}
			catch (IOException ignore) {
				LOG.warn("IOException when loading hbird-web.proerties. Will use default branding");
			}
			finally {
				IOUtils.closeQuietly(ins);
			}
		}

		brandName = props.getProperty("mcs.name", "Hummingbird"); //$NON-NLS-1$
		missionName = props.getProperty("mission.name", "Hummingbird"); //$NON-NLS-1$
		footerMessage = props.getProperty("footer.msg", "Mission Control System"); //$NON-NLS-1$
		welcomeHeader = props.getProperty("welcome.header", "Welcome to your control system"); //$NON-NLS-1$
		welcomeContent = props.getProperty("welcome.content", ""); //$NON-NLS-1$
		helpUrl = props.getProperty("help.url", "");
	}

	@Override
	public String getMcsName() {
		return brandName;
	}

	@Override
	public String getMissionName() {
		return missionName;
	}

	@Override
	public String getFooterMessage() {
		return footerMessage;
	}

	@Override
	public String getWelcomeHeader() {
		return welcomeHeader;
	}

	@Override
	public String getWelcomeContent() {
		return welcomeContent;
	}

	@Override
	public String getHelpUrl() {
		return helpUrl;
	}
}
