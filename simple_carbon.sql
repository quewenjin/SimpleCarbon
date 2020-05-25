/*
 Navicat Premium Data Transfer

 Source Server         : QWJ
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : simple_carbon

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 21/05/2020 22:58:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for exchange_record
-- ----------------------------
DROP TABLE IF EXISTS `exchange_record`;
CREATE TABLE `exchange_record`  (
  `exchangRecordId` int(16) NOT NULL AUTO_INCREMENT,
  `productName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `productNum` int(16) NULL DEFAULT NULL,
  `exchangerId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `exchangeTime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`exchangRecordId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for friend_system
-- ----------------------------
DROP TABLE IF EXISTS `friend_system`;
CREATE TABLE `friend_system`  (
  `userId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `friendId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of friend_system
-- ----------------------------
INSERT INTO `friend_system` VALUES ('12345601', '12345602');
INSERT INTO `friend_system` VALUES ('12345601', '12345604');
INSERT INTO `friend_system` VALUES ('12345601', '12345605');
INSERT INTO `friend_system` VALUES ('12345601', '12345603');
INSERT INTO `friend_system` VALUES ('12345601', '12345606');
INSERT INTO `friend_system` VALUES ('12345601', '12345610');
INSERT INTO `friend_system` VALUES ('12345601', '12345607');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `productId` int(16) NOT NULL AUTO_INCREMENT,
  `productName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `productNum` int(16) NULL DEFAULT NULL,
  PRIMARY KEY (`productId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for score_record
-- ----------------------------
DROP TABLE IF EXISTS `score_record`;
CREATE TABLE `score_record`  (
  `scoreRecordId` int(16) NOT NULL AUTO_INCREMENT,
  `scoreRecordTime` date NULL DEFAULT NULL,
  `scoreRecordType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `scoreRecordNum` int(16) NULL DEFAULT 0,
  `theUserId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`scoreRecordId`, `theUserId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score_record
-- ----------------------------
INSERT INTO `score_record` VALUES (1, '2020-05-11', '步行', 5, '12345601');
INSERT INTO `score_record` VALUES (2, '2020-05-11', '绿色购物', 1, '12345601');
INSERT INTO `score_record` VALUES (3, '2020-05-12', '公交', 1, '12345601');
INSERT INTO `score_record` VALUES (4, '2020-05-13', '积分消费', -1, '12345601');
INSERT INTO `score_record` VALUES (5, '2020-05-01', '公交', 1, '12345601');
INSERT INTO `score_record` VALUES (6, '2020-05-01', '积分消费', 1, '12345601');
INSERT INTO `score_record` VALUES (7, '2020-05-14', '步行', 5, '12345601');
INSERT INTO `score_record` VALUES (8, '2020-05-14', '绿色购物', 1, '12345601');
INSERT INTO `score_record` VALUES (9, '2020-05-14', '积分交易', -3, '12345601');
INSERT INTO `score_record` VALUES (10, '2020-05-14', '积分交易', -10, '12345601');
INSERT INTO `score_record` VALUES (11, '2020-05-14', '积分交易', -10, '12345601');
INSERT INTO `score_record` VALUES (12, '2020-05-14', '积分交易', -10, '12345601');
INSERT INTO `score_record` VALUES (13, '2020-05-14', '积分交易', -10, '12345601');
INSERT INTO `score_record` VALUES (14, '2020-05-14', '积分交易', -10, '12345601');
INSERT INTO `score_record` VALUES (15, '2020-05-16', '步行', 5, '12345601');
INSERT INTO `score_record` VALUES (16, '2020-05-16', '绿色购物', 1, '12345601');
INSERT INTO `score_record` VALUES (17, '2020-05-17', '步行', 5, '12345601');
INSERT INTO `score_record` VALUES (18, '2020-05-17', '绿色购物', 1, '12345601');
INSERT INTO `score_record` VALUES (19, '2020-05-17', '积分交易', -180, '12345601');
INSERT INTO `score_record` VALUES (20, '2020-05-17', '积分交易', -200, '12345601');
INSERT INTO `score_record` VALUES (21, '2020-05-17', '积分交易', -230, '12345601');
INSERT INTO `score_record` VALUES (22, '2020-05-17', '积分交易', -230, '12345601');
INSERT INTO `score_record` VALUES (23, '2020-05-17', '积分捐赠', -50, '12345601');
INSERT INTO `score_record` VALUES (24, '2020-05-17', '积分交易', -100, '12345601');
INSERT INTO `score_record` VALUES (25, '2020-05-18', '步行', 5, '12345601');
INSERT INTO `score_record` VALUES (26, '2020-05-18', '公交', 1, '12345601');
INSERT INTO `score_record` VALUES (27, '2020-05-18', '绿色购物', 1, '12345601');
INSERT INTO `score_record` VALUES (28, '2020-05-18', '积分交易', -180, '12345601');
INSERT INTO `score_record` VALUES (29, '2020-05-18', '积分交易', -12, '12345601');
INSERT INTO `score_record` VALUES (30, '2020-05-19', '步行', 5, '12345601');
INSERT INTO `score_record` VALUES (31, '2020-05-19', '公交', 1, '12345601');
INSERT INTO `score_record` VALUES (32, '2020-05-19', '绿色购物', 1, '12345601');
INSERT INTO `score_record` VALUES (33, '2020-05-19', '积分交易', -10, '12345601');
INSERT INTO `score_record` VALUES (34, '2020-05-19', '积分交易', -180, '12345601');
INSERT INTO `score_record` VALUES (35, '2020-05-19', '积分捐赠', -10, '12345601');
INSERT INTO `score_record` VALUES (36, '2020-05-19', '积分捐赠', -7, '12345601');
INSERT INTO `score_record` VALUES (37, '2020-05-19', '积分交易', -180, '12345601');
INSERT INTO `score_record` VALUES (38, '2020-05-20', '步行', 5, '12345601');
INSERT INTO `score_record` VALUES (39, '2020-05-20', '公交', 1, '12345601');
INSERT INTO `score_record` VALUES (40, '2020-05-20', '绿色购物', 1, '12345601');
INSERT INTO `score_record` VALUES (41, '2020-05-20', '积分交易', -10, '12345601');
INSERT INTO `score_record` VALUES (42, '2020-05-20', '积分交易', -10, '12345601');
INSERT INTO `score_record` VALUES (43, '2020-05-20', '积分交易', -180, '12345601');
INSERT INTO `score_record` VALUES (44, '2020-05-20', '积分捐赠', -27, '12345601');
INSERT INTO `score_record` VALUES (45, '2020-05-20', '积分交易', -10, '12345601');
INSERT INTO `score_record` VALUES (46, '2020-05-20', '积分交易', -180, '12345601');
INSERT INTO `score_record` VALUES (47, '2020-05-20', '积分捐赠', -50, '12345601');
INSERT INTO `score_record` VALUES (48, '2020-05-21', '步行', 5, '12345601');
INSERT INTO `score_record` VALUES (49, '2020-05-21', '公交', 1, '12345601');
INSERT INTO `score_record` VALUES (50, '2020-05-21', '绿色购物', 1, '12345601');

-- ----------------------------
-- Table structure for trend
-- ----------------------------
DROP TABLE IF EXISTS `trend`;
CREATE TABLE `trend`  (
  `trendId` int(11) NOT NULL AUTO_INCREMENT,
  `theUserName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `TrendPicture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`trendId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of trend
-- ----------------------------
INSERT INTO `trend` VALUES (1, '12345602', 'https://pic.downk.cc/item/5ec11ee5c2a9a83be55143cb.jpg');
INSERT INTO `trend` VALUES (2, '12345602', 'https://pic.downk.cc/item/5ec11ee3c2a9a83be5514211.jpg');
INSERT INTO `trend` VALUES (3, '12345602', 'https://pic.downk.cc/item/5ec11ee1c2a9a83be551401d.jpg');
INSERT INTO `trend` VALUES (4, '12345601', 'https://pic.downk.cc/item/5ec11edac2a9a83be551384a.jpg');
INSERT INTO `trend` VALUES (5, '12345601', 'https://pic.downk.cc/item/5ec11ee0c2a9a83be5513f49.jpg');
INSERT INTO `trend` VALUES (6, '12345603', 'https://pic.downk.cc/item/5ec11ed7c2a9a83be55134d8.jpg');
INSERT INTO `trend` VALUES (7, '12345604', 'https://pic.downk.cc/item/5ec11ed2c2a9a83be5512fd7.jpg');
INSERT INTO `trend` VALUES (8, '12345605', 'https://pic.downk.cc/item/5ec11ecbc2a9a83be55128ca.jpg');
INSERT INTO `trend` VALUES (9, '12345606', 'https://pic.downk.cc/item/5ec11ed5c2a9a83be5513313.jpg');
INSERT INTO `trend` VALUES (10, '12345607', 'https://pic.downk.cc/item/5ec11e37c2a9a83be5508c5a.jpg');
INSERT INTO `trend` VALUES (11, '12345607', 'https://pic.downk.cc/item/5ec11dc4c2a9a83be54ffe27.jpg');
INSERT INTO `trend` VALUES (12, '12345608', 'https://pic.downk.cc/item/5ec11ec5c2a9a83be55122f1.jpg');
INSERT INTO `trend` VALUES (13, '12345609', 'https://pic.downk.cc/item/5ec11c40c2a9a83be54e7826.jpg');
INSERT INTO `trend` VALUES (14, '12345610', 'https://pic.downk.cc/item/5ec11e2cc2a9a83be5508011.jpg');
INSERT INTO `trend` VALUES (15, '12345610', 'https://pic.downk.cc/item/5ec11dc4c2a9a83be54ffe27.jpg');
INSERT INTO `trend` VALUES (16, '12345610', 'https://pic.downk.cc/item/5ec11db5c2a9a83be54feb91.jpg');
INSERT INTO `trend` VALUES (17, '12345611', 'https://pic.downk.cc/item/5ec11eecc2a9a83be5514bec.jpg');
INSERT INTO `trend` VALUES (18, '12345612', 'https://pic.downk.cc/item/5ec11ee7c2a9a83be55145f9.jpg');
INSERT INTO `trend` VALUES (19, '12345613', 'https://pic.downk.cc/item/5ec11ed7c2a9a83be55134d8.jpg');
INSERT INTO `trend` VALUES (20, '12345614', 'https://pic.downk.cc/item/5ec11ed4c2a9a83be5513180.jpg');
INSERT INTO `trend` VALUES (21, '12345615', 'https://pic.downk.cc/item/5ec11ed4c2a9a83be5513180.jpg');
INSERT INTO `trend` VALUES (22, '12345616', 'https://pic.downk.cc/item/5ec11ecdc2a9a83be5512a86.jpg');
INSERT INTO `trend` VALUES (23, '12345617', 'https://pic.downk.cc/item/5ec11ec5c2a9a83be55122f1.jpg');
INSERT INTO `trend` VALUES (24, '12345618', 'https://pic.downk.cc/item/5ec11ed7c2a9a83be55134d8.jpg');
INSERT INTO `trend` VALUES (25, '12345619', 'https://pic.downk.cc/item/5ec11e39c2a9a83be5508eee.jpg');
INSERT INTO `trend` VALUES (26, '12345620', 'https://pic.downk.cc/item/5ec11e2cc2a9a83be5508011.jpg');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `userPassword` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '环保主义者',
  `userCity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '福州',
  `userScore` int(16) NULL DEFAULT 0,
  `userAccount` float(255, 2) NULL DEFAULT 0.00,
  `userCheck` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0',
  `userSlogn` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '(Blank)',
  `userPhoto` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `walkToday` int(16) NULL DEFAULT 0,
  `busToday` int(16) NULL DEFAULT 0,
  `shopToday` int(16) NULL DEFAULT 0,
  `today` date NULL DEFAULT '2020-01-01',
  `theFriendId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('12345601', '11111111', '舟卫兵', '福州', 367, 130.66, '0', 'Green', 'https://pic.downk.cc/item/5ec11ee5c2a9a83be55143cb.jpg', 8985, 1, 1, '2020-05-21', '');
INSERT INTO `user` VALUES ('12345602', '22222222', '注水小能手', '福州', 433, 222.00, '0', 'hahaha', 'https://pic.downk.cc/item/5ec11eecc2a9a83be5514bec.jpg', 0, 0, 0, '2020-05-13', '');
INSERT INTO `user` VALUES ('12345603', '33333333', 'Amiya', '福州', 204, 333.00, '0', '@_@', 'https://pic.downk.cc/item/5ec11eeac2a9a83be55149b8.jpg', 0, 0, 0, '2020-05-13', '');
INSERT INTO `user` VALUES ('12345604', '44444444', 'Astesia', '福州', 312, 444.00, '0', 'orz', 'https://pic.downk.cc/item/5ec11ee0c2a9a83be5513f49.jpg', 0, 0, 0, '2020-05-13', '');
INSERT INTO `user` VALUES ('12345605', '55555555', '影蕴', '福州', 198, 0.00, '0', '~~~', 'https://pic.downk.cc/item/5ec11ee8c2a9a83be5514776.jpg', 0, 0, 0, '2020-01-01', '');
INSERT INTO `user` VALUES ('12345606', '66666666', 'Coincidence', '北京', 57, 666.00, '0', 'emmmmm', 'https://pic.downk.cc/item/5ec11edec2a9a83be5513c45.jpg', 0, 0, 0, '2020-01-01', '');
INSERT INTO `user` VALUES ('12345607', '77777777', '环保主义者', '福州', 453, 156.00, '0', '(Blank)', 'https://pic.downk.cc/item/5ec11c6dc2a9a83be54e9e49.jpg', 0, 0, 0, '2020-01-01', '');
INSERT INTO `user` VALUES ('12345608', '88888888', '同好', '福州', 213, 123.00, '0', '( = _ - )', 'https://pic.downk.cc/item/5ec11dc4c2a9a83be54ffe27.jpg', 0, 0, 0, '2020-01-01', '');
INSERT INTO `user` VALUES ('12345609', '99999999', '新辉', '厦门', 234, 131.00, '0', 'juejuesun', 'https://pic.downk.cc/item/5ec11dcec2a9a83be55009c4.jpg', 0, 0, 0, '2020-01-01', '');
INSERT INTO `user` VALUES ('12345610', '00000000', '王伟', '贵州', 666, 666.00, '0', '快乐就完事了', 'https://pic.downk.cc/item/5ec11e31c2a9a83be55085f3.jpg', 0, 0, 0, '2020-01-01', '');
INSERT INTO `user` VALUES ('12345611', '11111111', 'kunkun', '福州', 44, 45.00, '0', '加油', 'https://pic.downk.cc/item/5ec11e33c2a9a83be5508884.jpg', 0, 0, 0, '2020-01-01', '');
INSERT INTO `user` VALUES ('12345612', '22222222', '农夫山泉', '福州', 841, 123.00, '0', '低碳', 'https://pic.downk.cc/item/5ec11ecbc2a9a83be55128ca.jpg', 0, 0, 0, '2020-01-01', '');
INSERT INTO `user` VALUES ('12345613', '33333333', '利安得', '福州', 521, 110.00, '0', '(Blank)', 'https://pic.downk.cc/item/5ec11ed7c2a9a83be55134d8.jpg', 0, 0, 0, '2020-01-01', '');
INSERT INTO `user` VALUES ('12345614', '44444444', '海伦娜', '福州', 345, 20.00, '0', '(Blank)', 'https://pic.downk.cc/item/5ec11ed9c2a9a83be551366f.jpg', 0, 0, 0, '2020-01-01', '');
INSERT INTO `user` VALUES ('12345615', '55555555', '82年的拉菲', '福州', 866, 5460.00, '0', '(Blank)', 'https://pic.downk.cc/item/5ec11ecbc2a9a83be55128ca.jpg', 0, 0, 0, '2020-01-01', '');
INSERT INTO `user` VALUES ('12345616', '66666666', '天城', '福州', 10, 10.00, '0', '(Blank)', 'https://pic.downk.cc/item/5ec11ee3c2a9a83be5514211.jpg', 0, 0, 0, '2020-01-01', '');
INSERT INTO `user` VALUES ('12345617', '77777777', '6194', '福州', 242, 42.00, '0', '(Blank)', 'https://pic.downk.cc/item/5ec11e37c2a9a83be5508c5a.jpg', 0, 0, 0, '2020-01-01', '');
INSERT INTO `user` VALUES ('12345618', '88888888', '莲大人', '福州', 333, 33.00, '0', '夸赞我吧', 'https://pic.downk.cc/item/5ec11dd8c2a9a83be55014ea.jpg', 0, 0, 0, '2020-01-01', '');
INSERT INTO `user` VALUES ('12345619', '99999999', '奸商', '福州', 123, 111.00, '0', '买东西吗？', 'https://pic.downk.cc/item/5ec11dd2c2a9a83be5500e98.jpg', 0, 0, 0, '2020-01-01', '');
INSERT INTO `user` VALUES ('12345620', '00000000', '小锉刀', '福州', 134, 220.00, '0', '小加加nb', 'https://pic.downk.cc/item/5ec11db5c2a9a83be54feb91.jpg', 0, 0, 0, '2020-01-01', '');

SET FOREIGN_KEY_CHECKS = 1;
