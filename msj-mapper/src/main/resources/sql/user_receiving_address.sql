/*
Navicat MySQL Data Transfer

Source Server         : mydb
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : meishijia

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-10-22 17:44:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_receiving_address
-- ----------------------------
DROP TABLE IF EXISTS `user_receiving_address`;
CREATE TABLE `user_receiving_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT '' COMMENT '收件人姓名',
  `phone` char(11) DEFAULT '' COMMENT '手机号码',
  `province` varchar(255) DEFAULT '' COMMENT '省',
  `city` varchar(255) DEFAULT '' COMMENT '城市',
  `address` varchar(255) DEFAULT '' COMMENT '详细收货地址',
  `type` int(1) DEFAULT NULL COMMENT '地址类型：0-普通，1-默认',
  `status` int(1) DEFAULT NULL COMMENT '收货地址状态：0-无效，1-有效',
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
