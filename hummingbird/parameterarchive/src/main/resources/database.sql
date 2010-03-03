DROP TABLE IF EXISTS `parameter`;
CREATE TABLE `parameter` (
  `parameter_id` bigint(20) NOT NULL,
  `packet_id` bigint(20) NOT NULL,
  `onboard_creation_time` DATE NOT NULL,
  `onground_reception_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `Value` float(40,20) DEFAULT NULL,
  PRIMARY KEY (`parameter_id`, `onboard_creation_time`,`onground_reception_time`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
