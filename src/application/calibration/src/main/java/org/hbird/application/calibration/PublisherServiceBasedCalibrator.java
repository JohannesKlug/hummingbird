package org.hbird.application.calibration;

import org.hbird.application.calibration.exceptions.CalibratorConfigurationException;
import org.hbird.core.spacesystemmodel.exceptions.CalibrationException;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.core.spacesystempublisher.exceptions.UnavailableSpaceSystemModelException;
import org.hbird.core.spacesystempublisher.interfaces.SpaceSystemPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PublisherServiceBasedCalibrator {
	private static final Logger LOG = LoggerFactory.getLogger(PublisherServiceBasedCalibrator.class);

	private SpaceSystemPublisher publisherService;

	private InMemoryCalibrator calibrator;

	public void createHostCalibrator() {
		if (publisherService != null) {
			try {
				calibrator = new InMemoryCalibrator(publisherService.getAllCalibrators());
			}
			catch (UnavailableSpaceSystemModelException e) {
				calibrator = null;
			}
		}
		else {
			LOG.warn("Attempt to cache space system model information when there is no publisher service available");
		}
	}

	public Parameter<?> calibrate(Parameter<?> parameter) throws CalibrationException, CalibratorConfigurationException {
		checkCalibrator();
		return calibrator.calibrate(parameter);
	}

	private void checkCalibrator() throws CalibratorConfigurationException {
		if (calibrator == null) {
			throw new CalibratorConfigurationException("The calibrator is not configured, cannot perform calibration");
		}
	}

	public SpaceSystemPublisher getPublisherService() {
		return publisherService;
	}

	public void setPublisherService(SpaceSystemPublisher publisherService) {
		this.publisherService = publisherService;
	}
}
