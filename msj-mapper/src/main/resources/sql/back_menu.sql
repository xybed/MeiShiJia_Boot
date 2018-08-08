/*
Navicat MySQL Data Transfer

Source Server         : mydb
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : meishijia

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-08-08 17:51:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for back_menu
-- ----------------------------
DROP TABLE IF EXISTS `back_menu`;
CREATE TABLE `back_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fid` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT '' COMMENT '菜单名称',
  `url` varchar(100) DEFAULT NULL,
  `icon` varchar(50) DEFAULT '' COMMENT '菜单图标',
  `type` int(1) DEFAULT NULL COMMENT '0-菜单，1-按钮',
  `order` int(2) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of back_menu
-- ----------------------------
INSERT INTO `back_menu` VALUES ('1', '0', '系统管理', null, 'fa fa-desktop', '0', '1');
INSERT INTO `back_menu` VALUES ('2', '1', '商品管理', '/product', 'fa fa-window-restore', '0', '1');
INSERT INTO `back_menu` VALUES ('3', '1', '订单管理', '/order', 'fa fa-modx', '0', '2');
INSERT INTO `back_menu` VALUES ('4', '1', '用户管理', '/user', 'fa fa-user', '0', '3');
