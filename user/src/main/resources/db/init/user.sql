/*
Navicat MySQL Data Transfer

Source Server         : wyc
Source Server Version : 50512
Source Host           : localhost:3306
Source Database       : hyylt

Target Server Type    : MYSQL
Target Server Version : 50512
File Encoding         : 65001

Date: 2017-09-10 21:54:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` varchar(20) NOT NULL COMMENT '主键id 用户名',
  `username` varchar(20) DEFAULT NULL COMMENT '昵称',
  `userpassword` varchar(20) DEFAULT NULL COMMENT '密码',
  `usersignature` varchar(200) DEFAULT NULL COMMENT '个性签名',
  `usergrade` int(11) DEFAULT NULL COMMENT '等级',
  `usergold` int(11) DEFAULT NULL COMMENT '赏金',
  `userphoto` varchar(30) DEFAULT NULL COMMENT '头像图片',
  `reserved1` varchar(20) DEFAULT NULL COMMENT '预留字段1',
  `reserved2` varchar(20) DEFAULT NULL COMMENT '预留字段2',
  `reserved3` varchar(20) DEFAULT NULL COMMENT '预留字段3',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('wyc', null, 'YY', null, null, null, null, null, null, null);
