DROP TABLE IF EXISTS `packet`;
CREATE TABLE `packet` (
  `packet_id` bigint(20) NOT NULL,
  `onboard_creation_time` DATE NOT NULL,
  `onground_reception_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `packet` blob(65535) NOT NULL,
  PRIMARY KEY (`packet_id`, `onboard_creation_time`,`onground_reception_time`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
