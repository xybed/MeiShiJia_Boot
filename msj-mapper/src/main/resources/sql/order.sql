/*
Navicat MySQL Data Transfer

Source Server         : mydb
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : meishijia

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-09-07 11:37:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_number` varchar(255) DEFAULT '' COMMENT '订单号',
  `pay_amount` decimal(10,2) DEFAULT NULL COMMENT '订单总金额',
  `status` int(1) DEFAULT NULL COMMENT '订单状态：0-待付款，1-待发货，2-待收货，3-待评价，4-退款',
  `gmt_create` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
