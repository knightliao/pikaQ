
DROP DATABASE IF EXISTS `pikaqDemoWeb`;
CREATE DATABASE IF NOT EXISTS `pikaqDemoWeb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pikaqDemoWeb`;

DROP TABLE IF EXISTS `campaign`;
CREATE TABLE IF NOT EXISTS `campaign` (
  `campaignId` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`campaignId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `campaign` (`campaignId`, `name`, `price`) VALUES
	(1, 'demo', 3);
INSERT INTO `campaign` (`campaignId`, `name`, `price`) VALUES (2, 'demo2', 4);
