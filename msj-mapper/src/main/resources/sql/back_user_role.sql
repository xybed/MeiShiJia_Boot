/*
Navicat MySQL Data Transfer

Source Server         : mydb
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : meishijia

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-08-08 17:52:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for back_user_role
-- ----------------------------
DROP TABLE IF EXISTS `back_user_role`;
CREATE TABLE `back_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of back_user_role
-- ----------------------------
INSERT INTO `back_user_role` VALUES ('1', '1', '1');
INSERT INTO `back_user_role` VALUES ('2', '2', '2');
INSERT INTO `back_user_role` VALUES ('3', '3', '3');
