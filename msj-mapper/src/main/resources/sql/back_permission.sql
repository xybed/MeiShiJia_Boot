/*
Navicat MySQL Data Transfer

Source Server         : mydb
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : meishijia

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-08-08 17:52:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for back_permission
-- ----------------------------
DROP TABLE IF EXISTS `back_permission`;
CREATE TABLE `back_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of back_permission
-- ----------------------------
INSERT INTO `back_permission` VALUES ('1', '/product/queryProduct', 'queryProduct', '查询商品');
INSERT INTO `back_permission` VALUES ('2', '/product/addProduct', 'addProduct', '增加商品');
INSERT INTO `back_permission` VALUES ('3', '/product/updateProduct', 'updateProduct', '修改商品');
INSERT INTO `back_permission` VALUES ('4', '/product/deleteProduct', 'deleteProduct', '删除商品');
INSERT INTO `back_permission` VALUES ('5', '/order/queryOrder', 'queryOrder', '查询订单');
INSERT INTO `back_permission` VALUES ('6', '/order/updateOrder', 'updateOrder', '修改订单');
INSERT INTO `back_permission` VALUES ('7', '/user/queryUser', 'queryUser', '查询用户');
INSERT INTO `back_permission` VALUES ('8', '/user/addUser', 'addUser', '增加用户');
INSERT INTO `back_permission` VALUES ('9', '/user/updateUser', 'updateUser', '修改用户');
INSERT INTO `back_permission` VALUES ('10', '/user/deleteUser', 'deleteUser', '删除用户');
