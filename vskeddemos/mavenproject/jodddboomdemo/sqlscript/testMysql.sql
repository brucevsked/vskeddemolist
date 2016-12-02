
CREATE USER 'test'@'%' IDENTIFIED BY 'test'; 

CREATE DATABASE test DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

grant all  on test.* to 'test'@'%' ;

-- ----------------------------
-- Table structure for mysqltesttablea1
-- ----------------------------
DROP TABLE IF EXISTS `mysqltesttablea1`;
CREATE TABLE `mysqltesttablea1` (
  `userid` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `userpass` varchar(255) NOT NULL,
  `userage` int(11) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mysqltesttablea1
-- ----------------------------
INSERT INTO `mysqltesttablea1` VALUES ('0', 'admin', 'admin', '10');
INSERT INTO `mysqltesttablea1` VALUES ('1', 'user1', 'user1', '18');
INSERT INTO `mysqltesttablea1` VALUES ('2', 'user2', 'user2', '19');
INSERT INTO `mysqltesttablea1` VALUES ('3', 'user3', 'user3', '20');
INSERT INTO `mysqltesttablea1` VALUES ('4', 'user4', 'user4', '30');
INSERT INTO `mysqltesttablea1` VALUES ('5', 'guest5', 'guest5', '18');
INSERT INTO `mysqltesttablea1` VALUES ('6', 'guest6', 'guest6', '19');