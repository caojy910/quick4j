/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.27 : Database - quick4j
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sain_online` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sain_online`;

/*Table structure for table `permission` */


DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` char(64) DEFAULT NULL COMMENT '密码',
  `state` varchar(32) DEFAULT NULL COMMENT '状态',
  `role` int DEFAULT NULL COMMENT '角色',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='用户表';

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`state`,`create_time`) values (1,'starzou','111111',NULL,'2014-07-17 12:59:08');

/*Table structure for table `user_role` */


DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '公司id',
  `name` varchar(8) NOT NULL COMMENT '公司名',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='公司';


DROP TABLE IF EXISTS `device`;

CREATE TABLE `device` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '设备id',
  `name` varchar(32) DEFAULT NULL COMMENT '设备名称',
  `companyid` bigint(20) NOT NULL COMMENT '所属企业',
  `deliverydate` datetime DEFAULT NULL COMMENT '交付时间',
  state int DEFAULT NULL COMMENT '当前设备运行状态',
  enddate datetime DEFAULT NULL COMMENT '运维期限',
  brand varchar(32) DEFAULT NULL COMMENT '品牌',
  version varchar(32) DEFAULT NULL COMMENT '型号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='设备';

DROP TABLE IF EXISTS `oprecord`;

CREATE TABLE `oprecord` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '运维记录id',
  `deciveid` bigint(20) NOT NULL COMMENT '设备id',
  `opengineer` bigint(20) NOT NULL COMMENT '运维工程师',
  `opdate` datetime DEFAULT NULL COMMENT '运维时间',
  opcontent varchar(1024) DEFAULT NULL COMMENT '运维内容',
  type int DEFAULT NULL COMMENT '运维类型：0 为运维操作， 1 为更换耗材',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100001 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='运维记录';

DROP TABLE IF EXISTS `engineer`;

CREATE TABLE `engineer` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '工程师id',
  `name` varchar(8) NOT NULL COMMENT '姓名',
  `headimg` varchar(128) NOT NULL COMMENT '头像',
  `companyid` bigint(20) DEFAULT NULL COMMENT '所属公司id',
  partment varchar(20) DEFAULT NULL COMMENT '部门',
  type int DEFAULT NULL COMMENT '工程师类型：0 为现场工程师， 1 为专家工程师',
  level int DEFAULT NULL COMMENT '级别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='工程师';

DROP TABLE IF EXISTS `job`;

CREATE TABLE `job` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '工单号',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `type` int NOT NULL COMMENT '工单类型 ：0为日常维护 1为故障维修',
  `deciveid` bigint(20) NOT NULL COMMENT '设备id',
  description varchar(1024) DEFAULT NULL COMMENT '工单描述',
  lastsuggest varchar(1024) DEFAULT NULL COMMENT '上次运维的总结与建议',
  localengineerid bigint(20) NOT NULL COMMENT '分配的现场工程师',
  remoteengineerid bigint(20) DEFAULT NULL COMMENT '分配的远程工程师',
  devicestate int DEFAULT NULL COMMENT '设备状态：0  1 ',
  jobstate int DEFAULT NULL COMMENT '工单状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='工单';
