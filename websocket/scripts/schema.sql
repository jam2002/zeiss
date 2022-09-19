DROP TABLE IF EXISTS `t_machine_event`;
CREATE TABLE `t_machine_event`  (
    `id` varchar(50) NOT NULL COMMENT '主键',
    `topic` varchar(50) NOT NULL DEFAULT '' COMMENT '主题',
	`ref` varchar(50) NOT NULL DEFAULT '' COMMENT '引用',
	`event` varchar(50) NOT NULL DEFAULT '' COMMENT '事件类型',
	`machine_id` varchar(50) NOT NULL DEFAULT '' COMMENT '机器ID',
	`status` varchar(50) NOT NULL DEFAULT '' COMMENT '状态',
	`timestamp` datetime(6) NOT NULL COMMENT '时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4;