/*
Navicat MySQL Data Transfer

Source Server         : mydb
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : meishijia

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-08-08 17:52:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for back_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `back_role_permission`;
CREATE TABLE `back_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of back_role_permission
-- ----------------------------
INSERT INTO `back_role_permission` VALUES ('1', '1', '1');
INSERT INTO `back_role_permission` VALUES ('2', '1', '2');
INSERT INTO `back_role_permission` VALUES ('3', '1', '3');
INSERT INTO `back_role_permission` VALUES ('4', '1', '4');
INSERT INTO `back_role_permission` VALUES ('5', '1', '5');
INSERT INTO `back_role_permission` VALUES ('6', '1', '6');
INSERT INTO `back_role_permission` VALUES ('7', '1', '7');
INSERT INTO `back_role_permission` VALUES ('8', '1', '8');
INSERT INTO `back_role_permission` VALUES ('9', '1', '9');
INSERT INTO `back_role_permission` VALUES ('10', '1', '10');
INSERT INTO `back_role_permission` VALUES ('11', '2', '1');
INSERT INTO `back_role_permission` VALUES ('12', '2', '2');
INSERT INTO `back_role_permission` VALUES ('13', '2', '3');
INSERT INTO `back_role_permission` VALUES ('14', '2', '4');
INSERT INTO `back_role_permission` VALUES ('15', '2', '5');
INSERT INTO `back_role_permission` VALUES ('16', '2', '6');
INSERT INTO `back_role_permission` VALUES ('17', '3', '1');
