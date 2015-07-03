CREATE TABLE `pikaq_data` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`create_time` VARCHAR(14) NOT NULL,
	`correlation` CHAR(36) NOT NULL COMMENT '唯一标识',
	`data` MEDIUMTEXT NOT NULL COMMENT '最大16MB，UTF-8',
	`status` TINYINT(4) NOT NULL DEFAULT '0',
	PRIMARY KEY (`id`),
	INDEX `correlation_id` (`correlation`),
	INDEX `status` (`status`)
)
COMMENT='pikaq数据存储'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;
