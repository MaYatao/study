/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 50712
 Source Host           : localhost:3306
 Source Schema         : study

 Target Server Type    : MySQL
 Target Server Version : 50712
 File Encoding         : 65001

 Date: 15/04/2020 22:01:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_announce
-- ----------------------------
DROP TABLE IF EXISTS `tb_announce`;
CREATE TABLE `tb_announce`  (
  `announce_id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sent_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `to_user` int(11) NULL DEFAULT 0,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`announce_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_announce
-- ----------------------------
INSERT INTO `tb_announce` VALUES (6, '撒旦', '2020-03-21 21:56:21', 0, NULL);
INSERT INTO `tb_announce` VALUES (2, '是的', '2020-03-20 23:11:28', 0, NULL);

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment`  (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `agree` int(11) NULL DEFAULT 0,
  `comment_time` datetime(0) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content_id` int(11) NULL DEFAULT NULL,
  `from_user` int(11) NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  `to_user` int(11) NULL DEFAULT NULL,
  `course_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_comment
-- ----------------------------
INSERT INTO `tb_comment` VALUES (13, NULL, '2020-02-19 19:32:09', '<p>士大夫地方</p>', 2, 1, NULL, 1, NULL);
INSERT INTO `tb_comment` VALUES (14, NULL, '2020-03-18 21:36:21', '<p>慷慨解囊</p>', NULL, 1, NULL, NULL, 14);
INSERT INTO `tb_comment` VALUES (15, NULL, '2020-03-18 21:36:30', '<p>反对反对</p>', NULL, 1, 14, 1, 14);
INSERT INTO `tb_comment` VALUES (16, NULL, '2020-03-18 21:36:40', '<p>现场出现</p>', NULL, 1, 14, 1, 14);
INSERT INTO `tb_comment` VALUES (17, NULL, '2020-03-18 21:36:47', '<p>撒大都市</p>', NULL, 1, NULL, NULL, 14);
INSERT INTO `tb_comment` VALUES (18, NULL, '2020-03-20 19:31:19', '<p>撒大都市</p>', 3, 1, NULL, 1, NULL);
INSERT INTO `tb_comment` VALUES (19, NULL, '2020-03-21 20:31:03', '<p>撒旦到</p>', NULL, 1, NULL, NULL, 10);
INSERT INTO `tb_comment` VALUES (20, NULL, '2020-03-21 20:34:07', '<p>撒大苏打</p>', NULL, 1, 19, 1, 10);
INSERT INTO `tb_comment` VALUES (21, NULL, '2020-03-21 20:43:15', '<p>啊是大多数v阿斯蒂芬v</p>', NULL, 1, NULL, NULL, 14);
INSERT INTO `tb_comment` VALUES (22, NULL, '2020-03-21 20:59:45', '<p>是顶顶顶顶顶</p>', NULL, 1, NULL, NULL, 14);
INSERT INTO `tb_comment` VALUES (23, NULL, '2020-03-21 21:00:36', '<p>撒旦</p>', NULL, 1, NULL, NULL, 14);
INSERT INTO `tb_comment` VALUES (24, NULL, '2020-03-21 21:58:54', '<p>assssv </p>', NULL, 1, NULL, NULL, 14);
INSERT INTO `tb_comment` VALUES (25, NULL, '2020-03-21 22:02:19', '<p>sdds</p>', NULL, 1, 14, 1, 14);

-- ----------------------------
-- Table structure for tb_content
-- ----------------------------
DROP TABLE IF EXISTS `tb_content`;
CREATE TABLE `tb_content`  (
  `content_id` int(11) NOT NULL AUTO_INCREMENT,
  `agree` int(11) NULL DEFAULT 0,
  `collection` int(11) NULL DEFAULT 0,
  `comments` int(11) NULL DEFAULT 0,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `content_time` datetime(0) NULL DEFAULT NULL,
  `flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT 0,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `views` int(11) NULL DEFAULT 0,
  `comment` bit(1) NULL DEFAULT NULL,
  PRIMARY KEY (`content_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_content
-- ----------------------------
INSERT INTO `tb_content` VALUES (3, 0, 0, 0, '<p>啊的方法烦烦烦烦烦烦v</p>', '2020-02-19 22:00:50', '计算机网络', 0, '测试2', 1, 2, b'1');
INSERT INTO `tb_content` VALUES (2, 0, 0, 0, '<p>阿凡达vv</p>', '2020-02-19 22:11:54', 'Java', 0, '测试1 ', 1, 1, b'1');
INSERT INTO `tb_content` VALUES (6, 0, 0, 0, '<p>嘿嘿</p>', '2020-04-10 20:49:00', 'Java,标签二,标签三', 0, '哈哈哈', 1, 0, b'1');

-- ----------------------------
-- Table structure for tb_couerses
-- ----------------------------
DROP TABLE IF EXISTS `tb_couerses`;
CREATE TABLE `tb_couerses`  (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `basics` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `degree` int(11) NULL DEFAULT 0,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `direction` int(11) NULL DEFAULT NULL,
  `goal` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `knowledges` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `subject` int(11) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `upload_time` datetime(0) NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_couerses
-- ----------------------------
INSERT INTO `tb_couerses` VALUES (10, '0基础', 2, '这是测试', 2, '大佬', 'Java', 27, '测试题1', '2020-03-16 14:52:58', 'http://192.168.183.130/group1/M00/00/00/wKi3gl5vIiGAElRHAABUA67-KI8341.mp4', 1, 'http://192.168.183.130/group1/M00/00/00/wKi3gl5vIkSARFjvAABUA67-KI8728.jpg', NULL);
INSERT INTO `tb_couerses` VALUES (14, '哈哈哈', 3, '无所谓', 1, '嘻嘻嘻', 'Java', 12, '测试111', '2020-03-18 20:49:11', 'http://192.168.183.130/group1/M00/00/00/wKi3gl5yGG6ANVS_AJVu01nQgdI788.mp4', 1, 'http://192.168.183.130/group1/M00/00/00/wKi3gl5yGLOAJhhvAABUA67-KI8792.jpg', 'http://192.168.183.130/group1/M00/00/00/wKi3gl5yGMGAX8zLAABUA67-KI8740.jpg');
INSERT INTO `tb_couerses` VALUES (13, 'fdf', 3, 'dfs f', 3, 'f豆瓣', '较大', 43, 'hahah ', '2020-03-16 15:22:19', 'http://192.168.183.130/group1/M00/00/00/wKi3gl5vKReAEphPAABUA67-KI8245.mp4', 1, 'http://192.168.183.130/group1/M00/00/00/wKi3gl5vKR2AZOGeAABUA67-KI8738.jpg', 'http://192.168.183.130/group1/M00/00/00/wKi3gl5vKSGADMXjAACJTjs7_vA266.jpg');

-- ----------------------------
-- Table structure for tb_direction
-- ----------------------------
DROP TABLE IF EXISTS `tb_direction`;
CREATE TABLE `tb_direction`  (
  `direction_id` int(11) NOT NULL AUTO_INCREMENT,
  `direction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `skill_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`direction_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_fans
-- ----------------------------
DROP TABLE IF EXISTS `tb_fans`;
CREATE TABLE `tb_fans`  (
  `fans_id` int(11) NOT NULL AUTO_INCREMENT,
  `fans` int(11) NOT NULL,
  `follwer_time` datetime(0) NULL DEFAULT NULL,
  `follwoee` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`fans_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for tb_image
-- ----------------------------
DROP TABLE IF EXISTS `tb_image`;
CREATE TABLE `tb_image`  (
  `image_id` int(11) NOT NULL AUTO_INCREMENT,
  `delete_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `link` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `publish_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` bit(1) NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`image_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_image
-- ----------------------------
INSERT INTO `tb_image` VALUES (2, NULL, '是的', 'www.baidu.com', '2020-03-20 23:23:30', NULL, 'http://192.168.183.130/group1/M00/00/00/wKi3gl503--AJRSrAABUA67-KI8066.jpg');

-- ----------------------------
-- Table structure for tb_message
-- ----------------------------
DROP TABLE IF EXISTS `tb_message`;
CREATE TABLE `tb_message`  (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `from_user` int(11) NULL DEFAULT NULL,
  `sent_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` bit(1) NULL DEFAULT NULL,
  `to_user` int(11) NULL DEFAULT NULL,
  `type` int(11) NOT NULL,
  `content_id` int(11) NULL DEFAULT NULL,
  `course_id` int(11) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`message_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_message
-- ----------------------------
INSERT INTO `tb_message` VALUES (1, '撒旦', -1, '2020-03-21 21:56:21', b'0', 1, 0, NULL, NULL, NULL);
INSERT INTO `tb_message` VALUES (2, '<p>assssv </p>', 1, '2020-03-21 21:58:54', b'0', 1, 1, NULL, NULL, NULL);
INSERT INTO `tb_message` VALUES (3, '<p>sdds</p>', 1, '2020-03-21 22:02:19', b'0', 1, 1, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for tb_mkdir
-- ----------------------------
DROP TABLE IF EXISTS `tb_mkdir`;
CREATE TABLE `tb_mkdir`  (
  `mkdir_id` int(11) NOT NULL AUTO_INCREMENT,
  `chepter_id` int(11) NOT NULL,
  `cource_id` int(11) NOT NULL,
  `creat_time` datetime(0) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`mkdir_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_question
-- ----------------------------
DROP TABLE IF EXISTS `tb_question`;
CREATE TABLE `tb_question`  (
  `qid` int(11) NOT NULL AUTO_INCREMENT,
  `analysis` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `degree` int(11) NULL DEFAULT 0,
  `direction` int(11) NULL DEFAULT NULL,
  `knowledge` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `options` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `score` int(11) NULL DEFAULT 0,
  `subject` int(11) NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT NULL,
  `uid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`qid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_question
-- ----------------------------
INSERT INTO `tb_question` VALUES (1, '<p>就是这样</p>', '1', '<p>我是怎么笑的</p>', '2020-03-11 17:16:47', 3, 2, 'Java,标签二,标签三', '哈哈,嘻嘻嘻,呵呵呵', 5, 27, 1, 1);
INSERT INTO `tb_question` VALUES (2, '<p>阿萨飒</p>', '1，2，0', '<p>人是怎么笑的</p>', '2020-03-11 17:17:55', 3, 2, 'Java,标签二,标签三', '哈,嘻,呵', 55, 27, 2, NULL);

-- ----------------------------
-- Table structure for tb_record_course
-- ----------------------------
DROP TABLE IF EXISTS `tb_record_course`;
CREATE TABLE `tb_record_course`  (
  `rcid` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) NOT NULL,
  `totle_time` datetime(0) NULL DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`rcid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for tb_record_daily
-- ----------------------------
DROP TABLE IF EXISTS `tb_record_daily`;
CREATE TABLE `tb_record_daily`  (
  `rdid` int(11) NOT NULL AUTO_INCREMENT,
  `login_time` datetime(0) NULL DEFAULT NULL,
  `out_time` datetime(0) NULL DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`rdid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for tb_record_history
-- ----------------------------
DROP TABLE IF EXISTS `tb_record_history`;
CREATE TABLE `tb_record_history`  (
  `record_history_id` int(11) NOT NULL AUTO_INCREMENT,
  `aggree_time` datetime(0) NULL DEFAULT NULL,
  `collection_ime` datetime(0) NULL DEFAULT NULL,
  `comment_id` int(11) NULL DEFAULT NULL,
  `comment_time` datetime(0) NULL DEFAULT NULL,
  `content_id` int(11) NULL DEFAULT NULL,
  `from_user` int(11) NULL DEFAULT NULL,
  `to_user` int(11) NULL DEFAULT NULL,
  `view_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`record_history_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 68 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of tb_record_history
-- ----------------------------
INSERT INTO `tb_record_history` VALUES (1, NULL, NULL, 0, NULL, 1, 1, 0, '2020-02-16 18:34:55');
INSERT INTO `tb_record_history` VALUES (2, NULL, NULL, 0, '2020-02-16 18:35:00', 1, 1, 1, NULL);
INSERT INTO `tb_record_history` VALUES (3, NULL, NULL, 0, '2020-02-16 18:35:08', 1, 1, 0, NULL);
INSERT INTO `tb_record_history` VALUES (4, NULL, NULL, 0, NULL, 1, 1, 0, '2020-02-16 18:37:43');
INSERT INTO `tb_record_history` VALUES (5, NULL, NULL, 0, NULL, 1, 1, 0, '2020-02-16 18:38:09');
INSERT INTO `tb_record_history` VALUES (6, NULL, NULL, 0, NULL, 1, 1, 0, '2020-02-16 18:45:59');
INSERT INTO `tb_record_history` VALUES (7, NULL, NULL, 0, NULL, 1, 1, 0, '2020-02-16 18:48:23');
INSERT INTO `tb_record_history` VALUES (8, NULL, NULL, 0, NULL, 1, 1, 0, '2020-02-16 18:51:28');
INSERT INTO `tb_record_history` VALUES (9, NULL, NULL, 0, NULL, 1, 1, 0, '2020-02-16 19:33:31');
INSERT INTO `tb_record_history` VALUES (10, NULL, NULL, 0, NULL, 1, 1, 0, '2020-02-16 19:36:14');
INSERT INTO `tb_record_history` VALUES (11, NULL, NULL, 0, NULL, 1, 1, 0, '2020-02-16 19:40:16');
INSERT INTO `tb_record_history` VALUES (12, NULL, NULL, 0, NULL, 1, 1, 0, '2020-02-16 19:58:33');
INSERT INTO `tb_record_history` VALUES (13, NULL, NULL, 0, '2020-02-16 20:12:12', 1, 1, 1, NULL);
INSERT INTO `tb_record_history` VALUES (14, NULL, NULL, 0, NULL, 1, 1, 0, '2020-02-16 20:19:03');
INSERT INTO `tb_record_history` VALUES (15, NULL, NULL, 0, NULL, 1, 1, 0, '2020-02-16 20:21:57');
INSERT INTO `tb_record_history` VALUES (16, NULL, NULL, 0, '2020-02-16 20:22:09', 1, 1, 1, NULL);
INSERT INTO `tb_record_history` VALUES (17, NULL, NULL, 0, '2020-02-16 20:22:28', 1, 1, 1, NULL);
INSERT INTO `tb_record_history` VALUES (18, NULL, NULL, 0, NULL, 1, 1, 0, '2020-02-16 20:23:18');
INSERT INTO `tb_record_history` VALUES (19, NULL, NULL, 0, '2020-02-16 20:23:34', 1, 1, 1, NULL);
INSERT INTO `tb_record_history` VALUES (20, NULL, NULL, 0, NULL, 1, 1, 0, '2020-02-16 20:29:08');
INSERT INTO `tb_record_history` VALUES (21, NULL, NULL, 0, '2020-02-16 20:31:15', 1, 1, 1, NULL);
INSERT INTO `tb_record_history` VALUES (22, NULL, NULL, 0, '2020-02-16 20:31:34', 1, 1, 1, NULL);
INSERT INTO `tb_record_history` VALUES (23, NULL, NULL, 0, '2020-02-16 20:34:21', 1, 1, 1, NULL);
INSERT INTO `tb_record_history` VALUES (24, NULL, NULL, 0, NULL, 1, 1, 0, '2020-02-16 20:54:59');
INSERT INTO `tb_record_history` VALUES (25, NULL, NULL, 0, NULL, 1, 1, 0, '2020-02-16 20:55:02');
INSERT INTO `tb_record_history` VALUES (26, NULL, NULL, 0, NULL, 1, 1, 0, '2020-02-16 21:12:12');
INSERT INTO `tb_record_history` VALUES (27, NULL, NULL, 0, NULL, 1, 1, 0, '2020-02-16 21:15:43');
INSERT INTO `tb_record_history` VALUES (28, NULL, '2020-02-16 21:15:48', 0, NULL, 1, 1, 1, NULL);
INSERT INTO `tb_record_history` VALUES (29, NULL, '2020-02-16 21:16:05', 0, NULL, 1, 1, 1, NULL);
INSERT INTO `tb_record_history` VALUES (30, NULL, NULL, 0, NULL, 1, 1, 0, '2020-02-18 19:13:32');
INSERT INTO `tb_record_history` VALUES (31, NULL, '2020-02-18 19:13:36', 0, NULL, 1, 1, 1, NULL);
INSERT INTO `tb_record_history` VALUES (32, NULL, NULL, 0, NULL, 1, 1, 0, '2020-02-18 19:14:25');
INSERT INTO `tb_record_history` VALUES (33, NULL, NULL, 0, NULL, 2, 1, 0, '2020-02-18 19:14:30');
INSERT INTO `tb_record_history` VALUES (34, NULL, NULL, 0, NULL, 1, 1, 0, '2020-02-18 19:14:38');
INSERT INTO `tb_record_history` VALUES (35, NULL, NULL, 0, NULL, 1, 1, 0, '2020-02-18 19:14:44');
INSERT INTO `tb_record_history` VALUES (36, NULL, NULL, 0, NULL, 2, 1, 0, '2020-02-18 19:14:47');
INSERT INTO `tb_record_history` VALUES (37, NULL, NULL, 0, NULL, 2, 1, 0, '2020-02-18 19:14:59');
INSERT INTO `tb_record_history` VALUES (38, NULL, NULL, 0, NULL, 1, 1, 0, '2020-02-18 19:18:38');
INSERT INTO `tb_record_history` VALUES (39, NULL, NULL, 0, NULL, 2, 1, 0, '2020-02-18 19:18:48');
INSERT INTO `tb_record_history` VALUES (40, NULL, NULL, 0, '2020-02-18 19:18:55', 2, 1, 1, NULL);
INSERT INTO `tb_record_history` VALUES (41, NULL, NULL, 0, '2020-02-18 19:19:00', 2, 1, 1, NULL);
INSERT INTO `tb_record_history` VALUES (42, NULL, NULL, 0, '2020-02-18 19:19:04', 2, 1, 1, NULL);
INSERT INTO `tb_record_history` VALUES (43, NULL, NULL, 0, NULL, 2, 1, 0, '2020-02-18 19:19:17');
INSERT INTO `tb_record_history` VALUES (44, NULL, NULL, 0, NULL, 1, 1, 0, '2020-02-19 16:42:05');
INSERT INTO `tb_record_history` VALUES (45, NULL, NULL, 0, NULL, 2, 1, 0, '2020-02-19 16:42:15');
INSERT INTO `tb_record_history` VALUES (46, NULL, NULL, 0, NULL, 2, 1, 0, '2020-02-19 19:32:04');
INSERT INTO `tb_record_history` VALUES (47, NULL, NULL, 0, '2020-02-19 19:32:09', 2, 1, 1, NULL);
INSERT INTO `tb_record_history` VALUES (48, NULL, NULL, 0, NULL, 2, 1, 0, '2020-02-19 19:32:36');
INSERT INTO `tb_record_history` VALUES (49, NULL, NULL, 0, NULL, 2, 1, 0, '2020-02-19 20:25:12');
INSERT INTO `tb_record_history` VALUES (50, NULL, NULL, 0, NULL, 2, 1, 0, '2020-02-19 20:25:47');
INSERT INTO `tb_record_history` VALUES (51, NULL, NULL, 0, NULL, 2, 1, 0, '2020-02-19 20:27:34');
INSERT INTO `tb_record_history` VALUES (52, NULL, NULL, 0, NULL, 2, 1, 0, '2020-02-19 21:03:05');
INSERT INTO `tb_record_history` VALUES (53, NULL, NULL, 14, '2020-03-18 21:36:21', 0, 1, 0, NULL);
INSERT INTO `tb_record_history` VALUES (54, NULL, NULL, 14, '2020-03-18 21:36:30', 0, 1, 1, NULL);
INSERT INTO `tb_record_history` VALUES (55, NULL, NULL, 14, '2020-03-18 21:36:40', 0, 1, 1, NULL);
INSERT INTO `tb_record_history` VALUES (56, NULL, NULL, 14, '2020-03-18 21:36:47', 0, 1, 0, NULL);
INSERT INTO `tb_record_history` VALUES (57, NULL, NULL, 0, NULL, 3, 1, 0, '2020-03-20 19:31:13');
INSERT INTO `tb_record_history` VALUES (58, NULL, NULL, 0, '2020-03-20 19:31:19', 3, 1, 1, NULL);
INSERT INTO `tb_record_history` VALUES (59, NULL, NULL, 10, '2020-03-21 20:31:03', 0, 1, 0, NULL);
INSERT INTO `tb_record_history` VALUES (60, NULL, NULL, 10, '2020-03-21 20:34:07', 0, 1, 1, NULL);
INSERT INTO `tb_record_history` VALUES (61, NULL, NULL, 14, '2020-03-21 20:43:15', 0, 1, 0, NULL);
INSERT INTO `tb_record_history` VALUES (62, NULL, NULL, 14, '2020-03-21 20:59:45', 0, 1, 0, NULL);
INSERT INTO `tb_record_history` VALUES (63, NULL, NULL, 14, '2020-03-21 21:00:36', 0, 1, 0, NULL);
INSERT INTO `tb_record_history` VALUES (64, NULL, NULL, 14, '2020-03-21 21:58:54', 0, 1, 0, NULL);
INSERT INTO `tb_record_history` VALUES (65, NULL, NULL, 14, '2020-03-21 22:02:19', 0, 1, 1, NULL);
INSERT INTO `tb_record_history` VALUES (66, NULL, NULL, 0, NULL, 2, 1, 0, '2020-04-15 19:42:34');
INSERT INTO `tb_record_history` VALUES (67, NULL, NULL, 0, NULL, 3, 1, 0, '2020-04-15 19:42:39');

-- ----------------------------
-- Table structure for tb_record_quertions
-- ----------------------------
DROP TABLE IF EXISTS `tb_record_quertions`;
CREATE TABLE `tb_record_quertions`  (
  `rqid` int(11) NOT NULL AUTO_INCREMENT,
  `date_time` datetime(0) NULL DEFAULT NULL,
  `error` bit(1) NOT NULL,
  `qusertion_id` int(11) NULL DEFAULT NULL,
  `score` int(11) NULL DEFAULT NULL,
  `test_id` int(11) NULL DEFAULT NULL,
  `user_answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`rqid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_record_quertions
-- ----------------------------
INSERT INTO `tb_record_quertions` VALUES (24, '2020-03-13 22:45:23', b'1', 2, 0, 3, '1', 1);
INSERT INTO `tb_record_quertions` VALUES (23, '2020-03-13 22:45:23', b'1', 1, 0, 3, '1', 1);
INSERT INTO `tb_record_quertions` VALUES (25, '2020-03-24 18:25:47', b'1', 1, 0, 3, '1', 1);
INSERT INTO `tb_record_quertions` VALUES (26, '2020-03-24 18:25:47', b'1', 2, 0, 3, '', 1);
INSERT INTO `tb_record_quertions` VALUES (27, '2020-04-15 19:44:46', b'1', 1, 0, 15, '', 1);
INSERT INTO `tb_record_quertions` VALUES (28, '2020-04-15 19:44:46', b'1', 2, 0, 15, '[]', 1);

-- ----------------------------
-- Table structure for tb_record_search
-- ----------------------------
DROP TABLE IF EXISTS `tb_record_search`;
CREATE TABLE `tb_record_search`  (
  `rsid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`rsid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for tb_record_tests
-- ----------------------------
DROP TABLE IF EXISTS `tb_record_tests`;
CREATE TABLE `tb_record_tests`  (
  `rtid` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime(0) NULL DEFAULT NULL,
  `spend_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `test_id` int(11) NULL DEFAULT NULL,
  `total_num` int(11) NULL DEFAULT NULL,
  `total_score` int(11) NOT NULL,
  `true_num` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ststus` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`rtid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_record_tests
-- ----------------------------
INSERT INTO `tb_record_tests` VALUES (12, '2020-04-15 19:44:46', '00:00:04', 15, 2, 0, 0, 1, '专项练习', 3);
INSERT INTO `tb_record_tests` VALUES (11, '2020-03-24 18:25:47', '00:00:45', 3, 2, 0, 0, 1, '测试1', 0);
INSERT INTO `tb_record_tests` VALUES (10, '2020-03-13 22:45:23', '00:00:10', 3, 2, 0, 0, 1, '测试1', 0);
INSERT INTO `tb_record_tests` VALUES (7, '2020-03-13 20:56:49', '00:00:10', 3, 2, 0, 0, 1, '测试1', 0);
INSERT INTO `tb_record_tests` VALUES (8, '2020-03-13 22:02:29', '00:00:07', 3, 2, 0, 0, 1, '测试1', 0);
INSERT INTO `tb_record_tests` VALUES (9, '2020-03-13 22:16:31', '00:00:06', 3, 2, 0, 0, 1, '测试1', 0);

-- ----------------------------
-- Table structure for tb_skill
-- ----------------------------
DROP TABLE IF EXISTS `tb_skill`;
CREATE TABLE `tb_skill`  (
  `skill_id` int(11) NOT NULL AUTO_INCREMENT,
  `did` int(11) NULL DEFAULT NULL,
  `kill_id` int(11) NOT NULL,
  PRIMARY KEY (`skill_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for tb_subject
-- ----------------------------
DROP TABLE IF EXISTS `tb_subject`;
CREATE TABLE `tb_subject`  (
  `subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`subject_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 91 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_subject
-- ----------------------------
INSERT INTO `tb_subject` VALUES (1, NULL, '前端开发');
INSERT INTO `tb_subject` VALUES (2, NULL, '后端开发');
INSERT INTO `tb_subject` VALUES (3, NULL, '移动开发');
INSERT INTO `tb_subject` VALUES (4, NULL, '计算机基础');
INSERT INTO `tb_subject` VALUES (5, NULL, '前沿技术');
INSERT INTO `tb_subject` VALUES (6, NULL, '云计算&大数据');
INSERT INTO `tb_subject` VALUES (7, NULL, '运维&测试');
INSERT INTO `tb_subject` VALUES (8, NULL, '数据库');
INSERT INTO `tb_subject` VALUES (9, NULL, 'UI设计&多媒体');
INSERT INTO `tb_subject` VALUES (10, NULL, '游戏');
INSERT INTO `tb_subject` VALUES (11, NULL, '全栈工程师');
INSERT INTO `tb_subject` VALUES (12, 1, 'HTML/CSS');
INSERT INTO `tb_subject` VALUES (13, 1, 'JavaScript');
INSERT INTO `tb_subject` VALUES (14, 1, 'Vue.js');
INSERT INTO `tb_subject` VALUES (15, 1, 'React.JS');
INSERT INTO `tb_subject` VALUES (16, 1, 'Angular');
INSERT INTO `tb_subject` VALUES (17, 1, 'Node.js');
INSERT INTO `tb_subject` VALUES (18, 1, 'jQuery');
INSERT INTO `tb_subject` VALUES (19, 1, 'Bootstrap');
INSERT INTO `tb_subject` VALUES (20, 1, 'Sass/Less');
INSERT INTO `tb_subject` VALUES (21, 1, 'WebApp');
INSERT INTO `tb_subject` VALUES (22, 1, '小程序');
INSERT INTO `tb_subject` VALUES (23, 1, '前端工具');
INSERT INTO `tb_subject` VALUES (24, 1, 'CSS');
INSERT INTO `tb_subject` VALUES (25, 1, 'Html5');
INSERT INTO `tb_subject` VALUES (26, 1, 'CSS3');
INSERT INTO `tb_subject` VALUES (27, 2, 'Java');
INSERT INTO `tb_subject` VALUES (28, 2, 'SpringBoot');
INSERT INTO `tb_subject` VALUES (29, 2, 'Spring Cloud');
INSERT INTO `tb_subject` VALUES (30, 2, 'SSM');
INSERT INTO `tb_subject` VALUES (31, 2, 'Python');
INSERT INTO `tb_subject` VALUES (32, 2, '爬虫');
INSERT INTO `tb_subject` VALUES (33, 2, 'Django');
INSERT INTO `tb_subject` VALUES (34, 2, 'Tornado');
INSERT INTO `tb_subject` VALUES (35, 2, 'Go');
INSERT INTO `tb_subject` VALUES (36, 2, 'PHP');
INSERT INTO `tb_subject` VALUES (37, 2, 'C');
INSERT INTO `tb_subject` VALUES (38, 2, 'C++');
INSERT INTO `tb_subject` VALUES (39, 2, 'C#');
INSERT INTO `tb_subject` VALUES (40, 2, 'Ruby');
INSERT INTO `tb_subject` VALUES (41, 3, 'Android');
INSERT INTO `tb_subject` VALUES (42, 3, 'iOS');
INSERT INTO `tb_subject` VALUES (43, 3, 'React native');
INSERT INTO `tb_subject` VALUES (44, 3, 'WEEX');
INSERT INTO `tb_subject` VALUES (45, 4, '计算机网络');
INSERT INTO `tb_subject` VALUES (46, 4, '算法与数据结构');
INSERT INTO `tb_subject` VALUES (47, 4, '数学');
INSERT INTO `tb_subject` VALUES (48, 5, '微服务');
INSERT INTO `tb_subject` VALUES (49, 5, '区块链');
INSERT INTO `tb_subject` VALUES (50, 5, '以太坊');
INSERT INTO `tb_subject` VALUES (51, 5, '机器学习');
INSERT INTO `tb_subject` VALUES (52, 5, '深度学习');
INSERT INTO `tb_subject` VALUES (53, 5, '计算机视觉');
INSERT INTO `tb_subject` VALUES (54, 5, '自然语言处理');
INSERT INTO `tb_subject` VALUES (55, 5, '数据分析&挖掘');
INSERT INTO `tb_subject` VALUES (56, 6, '大数据');
INSERT INTO `tb_subject` VALUES (57, 6, 'Hadoop');
INSERT INTO `tb_subject` VALUES (58, 6, 'Spark');
INSERT INTO `tb_subject` VALUES (59, 6, 'Hbase');
INSERT INTO `tb_subject` VALUES (60, 6, 'Storm');
INSERT INTO `tb_subject` VALUES (61, 6, '云计算');
INSERT INTO `tb_subject` VALUES (62, 6, 'AWS');
INSERT INTO `tb_subject` VALUES (63, 6, 'Docker');
INSERT INTO `tb_subject` VALUES (64, 6, 'Kubernetes');
INSERT INTO `tb_subject` VALUES (65, 7, '运维');
INSERT INTO `tb_subject` VALUES (66, 7, '自动化运维');
INSERT INTO `tb_subject` VALUES (67, 7, '运维工具');
INSERT INTO `tb_subject` VALUES (68, 7, '中间件');
INSERT INTO `tb_subject` VALUES (69, 7, 'Linux');
INSERT INTO `tb_subject` VALUES (70, 7, '测试');
INSERT INTO `tb_subject` VALUES (71, 7, '功能测试');
INSERT INTO `tb_subject` VALUES (72, 7, '性能测试');
INSERT INTO `tb_subject` VALUES (73, 7, '自动化测试');
INSERT INTO `tb_subject` VALUES (74, 7, '接口测试');
INSERT INTO `tb_subject` VALUES (75, 7, '安全测试');
INSERT INTO `tb_subject` VALUES (76, 8, 'MySQL');
INSERT INTO `tb_subject` VALUES (77, 8, 'Redis');
INSERT INTO `tb_subject` VALUES (78, 8, 'MongoDB');
INSERT INTO `tb_subject` VALUES (79, 8, 'Oracle');
INSERT INTO `tb_subject` VALUES (80, 8, 'SQL Server');
INSERT INTO `tb_subject` VALUES (81, 8, 'NoSql');
INSERT INTO `tb_subject` VALUES (82, 9, '模型制作');
INSERT INTO `tb_subject` VALUES (83, 9, '动效动画');
INSERT INTO `tb_subject` VALUES (84, 9, '设计基础');
INSERT INTO `tb_subject` VALUES (85, 9, '设计工具');
INSERT INTO `tb_subject` VALUES (86, 9, 'APPUI设计');
INSERT INTO `tb_subject` VALUES (87, 9, '产品交互');
INSERT INTO `tb_subject` VALUES (88, 10, 'Unity 3D');
INSERT INTO `tb_subject` VALUES (89, 10, 'Cocos2d-x');
INSERT INTO `tb_subject` VALUES (90, 11, 'Javafullstack');

-- ----------------------------
-- Table structure for tb_test
-- ----------------------------
DROP TABLE IF EXISTS `tb_test`;
CREATE TABLE `tb_test`  (
  `test_id` int(11) NOT NULL AUTO_INCREMENT,
  `blank_score` int(11) NULL DEFAULT NULL,
  `choice_questios` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `choices_questios` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content_questios` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `count` int(11) NULL DEFAULT 0,
  `other` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `socre` int(11) NULL DEFAULT 0,
  `status` int(11) NULL DEFAULT 0,
  `test_time` datetime(0) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT 0,
  `user_id` int(11) NULL DEFAULT NULL,
  `views` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`test_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_test
-- ----------------------------
INSERT INTO `tb_test` VALUES (10, 0, '1', '', NULL, 1, NULL, 0, 3, '2020-03-12 19:52:08', '专项练习', 0, 1, 0);
INSERT INTO `tb_test` VALUES (3, 0, '1', '2', '', 2, NULL, 0, 0, '2020-03-11 17:20:43', '测试1', 1, 1, 0);
INSERT INTO `tb_test` VALUES (6, 0, '1', '2', '', 2, NULL, 0, 0, '2020-03-11 17:27:57', '测试2', 1, 1, 0);
INSERT INTO `tb_test` VALUES (9, 0, '1', '', NULL, 1, NULL, 0, 3, '2020-03-12 19:47:13', '专项练习', 0, 1, 0);
INSERT INTO `tb_test` VALUES (11, 0, '1', '2', NULL, 2, NULL, 0, 3, '2020-03-12 19:56:06', '专项练习', 0, 1, 0);
INSERT INTO `tb_test` VALUES (12, 0, '1', '2', NULL, 2, NULL, 0, 3, '2020-03-12 19:58:34', '专项练习', 0, 1, 0);
INSERT INTO `tb_test` VALUES (13, 0, '', '', NULL, 0, NULL, 0, 3, '2020-03-24 18:23:19', '专项练习', 0, 1, 0);
INSERT INTO `tb_test` VALUES (14, 0, '', '', NULL, 0, NULL, 0, 3, '2020-04-15 19:44:26', '专项练习', 0, 1, 0);
INSERT INTO `tb_test` VALUES (15, 0, '1', '2', NULL, 2, NULL, 0, 3, '2020-04-15 19:44:41', '专项练习', 0, 1, 0);
INSERT INTO `tb_test` VALUES (16, 0, '1', '2', NULL, 2, NULL, 0, 3, '2020-04-15 20:32:33', '专项练习', 0, 1, 0);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `expectation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `head_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `identity` int(11) NOT NULL,
  `join_day` datetime(0) NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `school` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` bit(1) NOT NULL DEFAULT b'0',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, NULL, '2020-02-03 11:07:30', '111', '111', 'http://192.168.183.130/group1/M00/00/00/wKi3gl50wyeAYA0EAACJTjs7_vA111.jpg', 0, '2020-02-03 11:07:30', '111', NULL, '111', b'0', '111');

SET FOREIGN_KEY_CHECKS = 1;
