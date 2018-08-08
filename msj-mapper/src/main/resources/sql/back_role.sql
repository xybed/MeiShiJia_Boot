/*
Navicat MySQL Data Transfer

Source Server         : mydb
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : meishijia

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-08-08 17:52:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for back_role
-- ----------------------------
DROP TABLE IF EXISTS `back_role`;
CREATE TABLE `back_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT '' COMMENT '角色名称',
  `remark` varchar(100) DEFAULT '' COMMENT '角色备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of back_role
-- ----------------------------
INSERT INTO `back_role` VALUES ('1', 'admin', '管理员');
INSERT INTO `back_role` VALUES ('2', 'editor', '编辑人员');
INSERT INTO `back_role` VALUES ('3', 'guest', '游客');
