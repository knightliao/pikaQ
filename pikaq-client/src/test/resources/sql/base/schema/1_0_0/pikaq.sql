
CREATE SCHEMA IF NOT EXISTS "pikaq" /*!40100 DEFAULT CHARACTER SET utf8 */;


DROP TABLE  IF EXISTS pikaq."campaign";
CREATE TABLE pikaq.`campaign` (
	`campaignId` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(256) NULL DEFAULT NULL,
	`price` DECIMAL(10,0) NULL DEFAULT NULL,
	`createTime` VARCHAR(14) NULL DEFAULT '',
	`updateTime` VARCHAR(14) NULL DEFAULT '',
	PRIMARY KEY (`campaignId`)
);


DROP TABLE  IF EXISTS pikaq."pikaq_data";
CREATE TABLE pikaq.`pikaq_data` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`createTime` VARCHAR(14) NOT NULL,
	`updateTime` VARCHAR(14) NOT NULL,
	`correlation` CHAR(36) NOT NULL COMMENT '唯一标识',
	`data` MEDIUMTEXT NOT NULL COMMENT '最大16MB，UTF-8',
	`status` TINYINT(4) NOT NULL DEFAULT '0',
	`infoMsg` VARCHAR(256) NOT NULL DEFAULT '',
	`consumeTime` BIGINT(20) NOT NULL DEFAULT '0' COMMENT '上次消耗时间，精确到毫妙',
	`retryCount` INT(11) NOT NULL DEFAULT '0' COMMENT '重试次数',
	`exchange` VARCHAR(50) NOT NULL DEFAULT '',
	`routerKey` VARCHAR(50) NOT NULL DEFAULT '',
	PRIMARY KEY (`id`),
	INDEX `correlation_id` (`correlation`),
	INDEX `status` (`status`)
);
