/*
Navicat MySQL Data Transfer

Source Server         : mydb
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : meishijia

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-08-08 17:52:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for back_menu_role
-- ----------------------------
DROP TABLE IF EXISTS `back_menu_role`;
CREATE TABLE `back_menu_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of back_menu_role
-- ----------------------------
INSERT INTO `back_menu_role` VALUES ('1', '1', '1');
INSERT INTO `back_menu_role` VALUES ('2', '2', '1');
INSERT INTO `back_menu_role` VALUES ('3', '3', '1');
INSERT INTO `back_menu_role` VALUES ('4', '4', '1');
INSERT INTO `back_menu_role` VALUES ('5', '1', '2');
INSERT INTO `back_menu_role` VALUES ('6', '2', '2');
INSERT INTO `back_menu_role` VALUES ('7', '3', '2');
INSERT INTO `back_menu_role` VALUES ('8', '1', '3');
INSERT INTO `back_menu_role` VALUES ('9', '2', '3');
