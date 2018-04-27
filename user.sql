/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1_3306
Source Server Version : 50545
Source Host           : 127.0.0.1:3306
Source Database       : eman

Target Server Type    : MYSQL
Target Server Version : 50545
File Encoding         : 65001

Date: 2018-03-28 18:55:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `telephone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mail` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `createtime` datetime DEFAULT '0000-00-00 00:00:00',
  `begintime` datetime DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'xueyang', '123456', '222', '111', '333', '0000-00-00 00:00:00', null, null);
