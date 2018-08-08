/*
Navicat MySQL Data Transfer

Source Server         : mydb
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : meishijia

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-08-08 17:52:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for back_user
-- ----------------------------
DROP TABLE IF EXISTS `back_user`;
CREATE TABLE `back_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `salt` varchar(100) DEFAULT '' COMMENT '加密盐（用户名+salt）',
  `real_name` varchar(100) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `locked` int(1) DEFAULT NULL COMMENT '锁住状态：0-未锁住，1-锁住',
  `gmt_create` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `remark` varchar(10) DEFAULT '' COMMENT '备注下密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of back_user
-- ----------------------------
INSERT INTO `back_user` VALUES ('1', 'admin', '6d695aae34a26c7a34ce0b13edc4d6ca', 'admindecd1519b0346c9895c6520c8f614e3c', '李琪', '', '0', '2018-08-08 14:47:35', '2018-08-08 14:47:35', '123456');
INSERT INTO `back_user` VALUES ('2', 'test', '6ab1c74b2a7ed0da6b146926a697aed7', 'test94a60189db84e7ea233c5a9a98df68de', '测试', '', '0', '2018-08-08 14:47:38', '2018-08-08 14:47:38', 'test123');
INSERT INTO `back_user` VALUES ('3', 'guest', '42317398b11098a8b6933751ada4c82f', 'guestea8b8f034fd0ae8dc3e0f3bfb3df3223', '游客', '', '0', '2018-08-08 14:47:53', '2018-08-08 14:47:53', '111111');
