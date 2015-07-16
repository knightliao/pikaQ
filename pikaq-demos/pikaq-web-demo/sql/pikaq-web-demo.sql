
DROP DATABASE IF EXISTS `pikaqDemoWeb`;
CREATE DATABASE IF NOT EXISTS `pikaqDemoWeb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pikaqDemoWeb`;

DROP TABLE IF EXISTS `campaign`;
CREATE TABLE `campaign` (
	`campaignId` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(256) NULL DEFAULT NULL,
	`price` DECIMAL(10,0) NULL DEFAULT NULL,
	PRIMARY KEY (`campaignId`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

INSERT INTO `campaign` (`campaignId`, `name`, `price`) VALUES
	(1, 'demo', 3);
INSERT INTO `campaign` (`campaignId`, `name`, `price`) VALUES (2, 'demo2', 4);
