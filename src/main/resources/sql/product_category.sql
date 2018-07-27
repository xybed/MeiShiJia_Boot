/*
Navicat MySQL Data Transfer

Source Server         : mydb
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : meishijia

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-07-27 18:14:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES ('1', '1', '102');
INSERT INTO `product_category` VALUES ('2', '2', '102');
INSERT INTO `product_category` VALUES ('3', '3', '102');
INSERT INTO `product_category` VALUES ('4', '4', '102');
INSERT INTO `product_category` VALUES ('5', '5', '102');
INSERT INTO `product_category` VALUES ('6', '6', '102');
INSERT INTO `product_category` VALUES ('7', '7', '102');
INSERT INTO `product_category` VALUES ('8', '8', '102');
INSERT INTO `product_category` VALUES ('9', '9', '102');
INSERT INTO `product_category` VALUES ('10', '10', '102');
INSERT INTO `product_category` VALUES ('11', '11', '102');
INSERT INTO `product_category` VALUES ('12', '12', '102');
INSERT INTO `product_category` VALUES ('13', '13', '102');
INSERT INTO `product_category` VALUES ('14', '14', '102');
INSERT INTO `product_category` VALUES ('15', '15', '102');
INSERT INTO `product_category` VALUES ('16', '16', '102');
INSERT INTO `product_category` VALUES ('17', '17', '102');
INSERT INTO `product_category` VALUES ('18', '18', '102');
INSERT INTO `product_category` VALUES ('19', '19', '102');
INSERT INTO `product_category` VALUES ('20', '20', '102');
INSERT INTO `product_category` VALUES ('21', '21', '102');
INSERT INTO `product_category` VALUES ('22', '22', '102');
INSERT INTO `product_category` VALUES ('23', '23', '102');
INSERT INTO `product_category` VALUES ('24', '24', '102');
INSERT INTO `product_category` VALUES ('25', '25', '102');
INSERT INTO `product_category` VALUES ('26', '26', '102');
INSERT INTO `product_category` VALUES ('27', '27', '102');
INSERT INTO `product_category` VALUES ('28', '28', '102');
INSERT INTO `product_category` VALUES ('29', '29', '102');
INSERT INTO `product_category` VALUES ('30', '30', '102');
INSERT INTO `product_category` VALUES ('31', '31', '102');
INSERT INTO `product_category` VALUES ('32', '32', '102');
INSERT INTO `product_category` VALUES ('33', '33', '102');
INSERT INTO `product_category` VALUES ('34', '34', '102');
INSERT INTO `product_category` VALUES ('35', '35', '102');
INSERT INTO `product_category` VALUES ('36', '36', '102');
INSERT INTO `product_category` VALUES ('37', '37', '102');
INSERT INTO `product_category` VALUES ('38', '38', '102');
INSERT INTO `product_category` VALUES ('39', '39', '102');
INSERT INTO `product_category` VALUES ('40', '40', '102');
INSERT INTO `product_category` VALUES ('41', '41', '102');
INSERT INTO `product_category` VALUES ('42', '42', '102');
INSERT INTO `product_category` VALUES ('43', '43', '102');
INSERT INTO `product_category` VALUES ('44', '44', '102');
INSERT INTO `product_category` VALUES ('45', '45', '102');
INSERT INTO `product_category` VALUES ('46', '46', '102');
INSERT INTO `product_category` VALUES ('47', '47', '102');
INSERT INTO `product_category` VALUES ('48', '48', '102');
INSERT INTO `product_category` VALUES ('49', '49', '102');
INSERT INTO `product_category` VALUES ('50', '50', '102');
INSERT INTO `product_category` VALUES ('51', '51', '102');
INSERT INTO `product_category` VALUES ('52', '52', '102');
INSERT INTO `product_category` VALUES ('53', '53', '102');
INSERT INTO `product_category` VALUES ('54', '54', '102');
INSERT INTO `product_category` VALUES ('55', '55', '102');
INSERT INTO `product_category` VALUES ('56', '56', '102');
INSERT INTO `product_category` VALUES ('57', '57', '102');
INSERT INTO `product_category` VALUES ('58', '58', '102');
INSERT INTO `product_category` VALUES ('59', '59', '102');
INSERT INTO `product_category` VALUES ('60', '60', '102');
INSERT INTO `product_category` VALUES ('61', '61', '103');
INSERT INTO `product_category` VALUES ('62', '62', '103');
INSERT INTO `product_category` VALUES ('63', '63', '103');
INSERT INTO `product_category` VALUES ('64', '64', '103');
INSERT INTO `product_category` VALUES ('65', '65', '103');
INSERT INTO `product_category` VALUES ('66', '66', '103');
INSERT INTO `product_category` VALUES ('67', '67', '103');
INSERT INTO `product_category` VALUES ('68', '68', '103');
INSERT INTO `product_category` VALUES ('69', '69', '103');
INSERT INTO `product_category` VALUES ('70', '70', '103');
INSERT INTO `product_category` VALUES ('71', '71', '103');
INSERT INTO `product_category` VALUES ('72', '72', '103');
INSERT INTO `product_category` VALUES ('73', '73', '103');
INSERT INTO `product_category` VALUES ('74', '74', '103');
INSERT INTO `product_category` VALUES ('75', '75', '103');
INSERT INTO `product_category` VALUES ('76', '76', '103');
INSERT INTO `product_category` VALUES ('77', '3', '103');
INSERT INTO `product_category` VALUES ('78', '77', '103');
INSERT INTO `product_category` VALUES ('79', '78', '103');
INSERT INTO `product_category` VALUES ('80', '79', '103');
INSERT INTO `product_category` VALUES ('81', '80', '103');
INSERT INTO `product_category` VALUES ('82', '81', '103');
INSERT INTO `product_category` VALUES ('83', '5', '103');
INSERT INTO `product_category` VALUES ('84', '82', '103');
INSERT INTO `product_category` VALUES ('85', '83', '103');
INSERT INTO `product_category` VALUES ('86', '84', '103');
INSERT INTO `product_category` VALUES ('87', '7', '103');
INSERT INTO `product_category` VALUES ('88', '85', '103');
INSERT INTO `product_category` VALUES ('89', '86', '103');
INSERT INTO `product_category` VALUES ('90', '87', '103');
INSERT INTO `product_category` VALUES ('91', '88', '103');
INSERT INTO `product_category` VALUES ('92', '89', '103');
INSERT INTO `product_category` VALUES ('93', '90', '103');
INSERT INTO `product_category` VALUES ('94', '91', '103');
INSERT INTO `product_category` VALUES ('95', '92', '103');
INSERT INTO `product_category` VALUES ('96', '93', '103');
INSERT INTO `product_category` VALUES ('97', '94', '103');
INSERT INTO `product_category` VALUES ('98', '95', '103');
INSERT INTO `product_category` VALUES ('99', '96', '103');
INSERT INTO `product_category` VALUES ('100', '97', '103');
INSERT INTO `product_category` VALUES ('101', '98', '103');
INSERT INTO `product_category` VALUES ('102', '99', '103');
INSERT INTO `product_category` VALUES ('103', '100', '103');
INSERT INTO `product_category` VALUES ('104', '101', '103');
INSERT INTO `product_category` VALUES ('105', '102', '103');
INSERT INTO `product_category` VALUES ('106', '103', '103');
INSERT INTO `product_category` VALUES ('107', '104', '103');
INSERT INTO `product_category` VALUES ('108', '105', '103');
INSERT INTO `product_category` VALUES ('109', '106', '103');
INSERT INTO `product_category` VALUES ('110', '107', '103');
INSERT INTO `product_category` VALUES ('111', '108', '103');
INSERT INTO `product_category` VALUES ('112', '109', '103');
INSERT INTO `product_category` VALUES ('113', '12', '103');
INSERT INTO `product_category` VALUES ('114', '110', '103');
INSERT INTO `product_category` VALUES ('115', '111', '103');
INSERT INTO `product_category` VALUES ('116', '112', '103');
INSERT INTO `product_category` VALUES ('117', '113', '103');
INSERT INTO `product_category` VALUES ('118', '114', '103');
INSERT INTO `product_category` VALUES ('119', '115', '103');
INSERT INTO `product_category` VALUES ('120', '116', '103');
INSERT INTO `product_category` VALUES ('121', '117', '104');
INSERT INTO `product_category` VALUES ('122', '118', '104');
INSERT INTO `product_category` VALUES ('123', '119', '104');
INSERT INTO `product_category` VALUES ('124', '120', '104');
INSERT INTO `product_category` VALUES ('125', '121', '104');
INSERT INTO `product_category` VALUES ('126', '122', '104');
INSERT INTO `product_category` VALUES ('127', '61', '104');
INSERT INTO `product_category` VALUES ('128', '123', '104');
INSERT INTO `product_category` VALUES ('129', '124', '104');
INSERT INTO `product_category` VALUES ('130', '125', '104');
INSERT INTO `product_category` VALUES ('131', '126', '104');
INSERT INTO `product_category` VALUES ('132', '62', '104');
INSERT INTO `product_category` VALUES ('133', '127', '104');
INSERT INTO `product_category` VALUES ('134', '128', '104');
INSERT INTO `product_category` VALUES ('135', '63', '104');
INSERT INTO `product_category` VALUES ('136', '129', '104');
INSERT INTO `product_category` VALUES ('137', '130', '104');
INSERT INTO `product_category` VALUES ('138', '64', '104');
INSERT INTO `product_category` VALUES ('139', '65', '104');
INSERT INTO `product_category` VALUES ('140', '131', '104');
INSERT INTO `product_category` VALUES ('141', '132', '104');
INSERT INTO `product_category` VALUES ('142', '66', '104');
INSERT INTO `product_category` VALUES ('143', '67', '104');
INSERT INTO `product_category` VALUES ('144', '68', '104');
INSERT INTO `product_category` VALUES ('145', '69', '104');
INSERT INTO `product_category` VALUES ('146', '133', '104');
INSERT INTO `product_category` VALUES ('147', '70', '104');
INSERT INTO `product_category` VALUES ('148', '71', '104');
INSERT INTO `product_category` VALUES ('149', '72', '104');
INSERT INTO `product_category` VALUES ('150', '134', '104');
INSERT INTO `product_category` VALUES ('151', '135', '104');
INSERT INTO `product_category` VALUES ('152', '136', '104');
INSERT INTO `product_category` VALUES ('153', '1', '104');
INSERT INTO `product_category` VALUES ('154', '137', '104');
INSERT INTO `product_category` VALUES ('155', '138', '104');
INSERT INTO `product_category` VALUES ('156', '139', '104');
INSERT INTO `product_category` VALUES ('157', '140', '104');
INSERT INTO `product_category` VALUES ('158', '141', '104');
INSERT INTO `product_category` VALUES ('159', '75', '104');
INSERT INTO `product_category` VALUES ('160', '142', '104');
INSERT INTO `product_category` VALUES ('161', '143', '104');
INSERT INTO `product_category` VALUES ('162', '144', '104');
INSERT INTO `product_category` VALUES ('163', '4', '104');
INSERT INTO `product_category` VALUES ('164', '145', '104');
INSERT INTO `product_category` VALUES ('165', '2', '104');
INSERT INTO `product_category` VALUES ('166', '146', '104');
INSERT INTO `product_category` VALUES ('167', '147', '104');
INSERT INTO `product_category` VALUES ('168', '76', '104');
INSERT INTO `product_category` VALUES ('169', '3', '104');
INSERT INTO `product_category` VALUES ('170', '148', '104');
INSERT INTO `product_category` VALUES ('171', '149', '104');
INSERT INTO `product_category` VALUES ('172', '150', '104');
INSERT INTO `product_category` VALUES ('173', '151', '104');
INSERT INTO `product_category` VALUES ('174', '152', '104');
INSERT INTO `product_category` VALUES ('175', '77', '104');
INSERT INTO `product_category` VALUES ('176', '153', '104');
INSERT INTO `product_category` VALUES ('177', '154', '104');
INSERT INTO `product_category` VALUES ('178', '79', '104');
INSERT INTO `product_category` VALUES ('179', '155', '104');
INSERT INTO `product_category` VALUES ('180', '80', '104');
INSERT INTO `product_category` VALUES ('181', '156', '105');
INSERT INTO `product_category` VALUES ('182', '157', '105');
INSERT INTO `product_category` VALUES ('183', '158', '105');
INSERT INTO `product_category` VALUES ('184', '159', '105');
INSERT INTO `product_category` VALUES ('185', '160', '105');
INSERT INTO `product_category` VALUES ('186', '161', '105');
INSERT INTO `product_category` VALUES ('187', '162', '105');
INSERT INTO `product_category` VALUES ('188', '163', '105');
INSERT INTO `product_category` VALUES ('189', '164', '105');
INSERT INTO `product_category` VALUES ('190', '165', '105');
INSERT INTO `product_category` VALUES ('191', '166', '105');
INSERT INTO `product_category` VALUES ('192', '167', '105');
INSERT INTO `product_category` VALUES ('193', '168', '105');
INSERT INTO `product_category` VALUES ('194', '169', '105');
INSERT INTO `product_category` VALUES ('195', '170', '105');
INSERT INTO `product_category` VALUES ('196', '171', '105');
INSERT INTO `product_category` VALUES ('197', '57', '105');
INSERT INTO `product_category` VALUES ('198', '172', '105');
INSERT INTO `product_category` VALUES ('199', '173', '105');
INSERT INTO `product_category` VALUES ('200', '174', '105');
INSERT INTO `product_category` VALUES ('201', '175', '105');
INSERT INTO `product_category` VALUES ('202', '176', '105');
INSERT INTO `product_category` VALUES ('203', '177', '105');
INSERT INTO `product_category` VALUES ('204', '178', '105');
INSERT INTO `product_category` VALUES ('205', '179', '105');
INSERT INTO `product_category` VALUES ('206', '180', '105');
INSERT INTO `product_category` VALUES ('207', '181', '105');
INSERT INTO `product_category` VALUES ('208', '182', '105');
INSERT INTO `product_category` VALUES ('209', '183', '105');
INSERT INTO `product_category` VALUES ('210', '184', '105');
INSERT INTO `product_category` VALUES ('211', '185', '105');
INSERT INTO `product_category` VALUES ('212', '186', '105');
INSERT INTO `product_category` VALUES ('213', '187', '105');
INSERT INTO `product_category` VALUES ('214', '188', '105');
INSERT INTO `product_category` VALUES ('215', '189', '105');
INSERT INTO `product_category` VALUES ('216', '190', '105');
INSERT INTO `product_category` VALUES ('217', '191', '105');
INSERT INTO `product_category` VALUES ('218', '192', '105');
INSERT INTO `product_category` VALUES ('219', '193', '105');
INSERT INTO `product_category` VALUES ('220', '194', '105');
INSERT INTO `product_category` VALUES ('221', '195', '105');
INSERT INTO `product_category` VALUES ('222', '196', '105');
INSERT INTO `product_category` VALUES ('223', '197', '105');
INSERT INTO `product_category` VALUES ('224', '198', '105');
INSERT INTO `product_category` VALUES ('225', '199', '105');
INSERT INTO `product_category` VALUES ('226', '200', '105');
INSERT INTO `product_category` VALUES ('227', '201', '105');
INSERT INTO `product_category` VALUES ('228', '202', '105');
INSERT INTO `product_category` VALUES ('229', '203', '105');
INSERT INTO `product_category` VALUES ('230', '204', '105');
INSERT INTO `product_category` VALUES ('231', '205', '105');
INSERT INTO `product_category` VALUES ('232', '206', '105');
INSERT INTO `product_category` VALUES ('233', '207', '105');
INSERT INTO `product_category` VALUES ('234', '208', '105');
INSERT INTO `product_category` VALUES ('235', '209', '105');
INSERT INTO `product_category` VALUES ('236', '210', '105');
INSERT INTO `product_category` VALUES ('237', '211', '105');
INSERT INTO `product_category` VALUES ('238', '212', '105');
INSERT INTO `product_category` VALUES ('239', '213', '105');
INSERT INTO `product_category` VALUES ('240', '214', '105');
