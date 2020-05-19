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

 Date: 19/05/2020 08:43:32
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
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `to_user` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`announce_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_announce
-- ----------------------------
INSERT INTO `tb_announce` VALUES (1, 'sss', '2020-05-08 22:00:27', 'sss', 0);

-- ----------------------------
-- Table structure for tb_blog_record
-- ----------------------------
DROP TABLE IF EXISTS `tb_blog_record`;
CREATE TABLE `tb_blog_record`  (
  `br_id` int(11) NOT NULL AUTO_INCREMENT,
  `aggree_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comment_id` int(11) NULL DEFAULT NULL,
  `comment_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content_id` int(11) NULL DEFAULT NULL,
  `from_user` int(11) NULL DEFAULT NULL,
  `to_user` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`br_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_blog_record
-- ----------------------------
INSERT INTO `tb_blog_record` VALUES (1, NULL, 0, NULL, 1, 1, 0);
INSERT INTO `tb_blog_record` VALUES (2, NULL, 0, NULL, 1, 1, 0);
INSERT INTO `tb_blog_record` VALUES (3, NULL, 0, '2020-05-14 20:14:11', 1, 1, 1);
INSERT INTO `tb_blog_record` VALUES (4, NULL, 0, '2020-05-14 20:14:16', 1, 1, 1);
INSERT INTO `tb_blog_record` VALUES (5, NULL, 0, NULL, 2, 1, 0);

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment`  (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `agree` int(11) NULL DEFAULT 0,
  `comment_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content_id` int(11) NULL DEFAULT NULL,
  `from_user` int(11) NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  `to_user` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_comment
-- ----------------------------
INSERT INTO `tb_comment` VALUES (1, NULL, '2020-05-14 20:14:11', '<p>sas </p>', 1, 1, NULL, 1);
INSERT INTO `tb_comment` VALUES (2, NULL, '2020-05-14 20:14:16', '<p>dd </p>', 1, 1, 1, 1);

-- ----------------------------
-- Table structure for tb_content
-- ----------------------------
DROP TABLE IF EXISTS `tb_content`;
CREATE TABLE `tb_content`  (
  `content_id` int(11) NOT NULL AUTO_INCREMENT,
  `agree` int(11) NULL DEFAULT 0,
  `is_comment` bit(1) NULL DEFAULT NULL,
  `comments` int(11) NULL DEFAULT 0,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `knowledges1` int(11) NULL DEFAULT NULL,
  `knowledges2` int(11) NULL DEFAULT NULL,
  `knowledges3` int(11) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT 0,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `topic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT 0,
  `user_id` int(11) NULL DEFAULT NULL,
  `views` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`content_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_content
-- ----------------------------
INSERT INTO `tb_content` VALUES (1, 0, b'1', 0, '<p>11</p>', '2020-05-08 17:08:14', NULL, NULL, NULL, 0, '11', NULL, NULL, 1, 2);
INSERT INTO `tb_content` VALUES (2, 0, b'1', 0, '<p>xzzzzzzzzzzzzzzz</p>', '2020-05-08 22:07:09', NULL, NULL, NULL, 0, 'zxxz', NULL, NULL, 1, 1);
INSERT INTO `tb_content` VALUES (3, 0, b'1', 0, '<p>存储</p>', '2020-05-14 19:45:21', NULL, NULL, NULL, 1, '现象下', NULL, NULL, 1, 0);

-- ----------------------------
-- Table structure for tb_couerses
-- ----------------------------
DROP TABLE IF EXISTS `tb_couerses`;
CREATE TABLE `tb_couerses`  (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `basics` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `degree` int(11) NULL DEFAULT 0,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `direction` int(11) NULL DEFAULT NULL,
  `goal` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `knowledges1` int(11) NULL DEFAULT NULL,
  `knowledges2` int(11) NULL DEFAULT NULL,
  `knowledges3` int(11) NULL DEFAULT NULL,
  `subject` int(11) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_course_record_
-- ----------------------------
DROP TABLE IF EXISTS `tb_course_record_`;
CREATE TABLE `tb_course_record_`  (
  `rcid` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) NULL DEFAULT NULL,
  `study_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`rcid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_image
-- ----------------------------
DROP TABLE IF EXISTS `tb_image`;
CREATE TABLE `tb_image`  (
  `image_id` int(11) NOT NULL AUTO_INCREMENT,
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `link` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `publish_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` bit(1) NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`image_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_image
-- ----------------------------
INSERT INTO `tb_image` VALUES (1, '存储', 'http://www.baidu.com', '2020-05-08 22:00:12', NULL, 'http://192.168.183.130/group1/M00/00/00/wKi3gl61ZdSASGsGAACJTjs7_vA873.jpg');

-- ----------------------------
-- Table structure for tb_knowledge_record_
-- ----------------------------
DROP TABLE IF EXISTS `tb_knowledge_record_`;
CREATE TABLE `tb_knowledge_record_`  (
  `rkid` int(11) NOT NULL AUTO_INCREMENT,
  `knowledge_id` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`rkid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for tb_knowledges
-- ----------------------------
DROP TABLE IF EXISTS `tb_knowledges`;
CREATE TABLE `tb_knowledges`  (
  `knowledge_id` int(11) NOT NULL AUTO_INCREMENT,
  `next` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `previous` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `subject_id` int(11) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`knowledge_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_knowledges
-- ----------------------------
INSERT INTO `tb_knowledges` VALUES (1, NULL, NULL, 27, '基础');
INSERT INTO `tb_knowledges` VALUES (2, NULL, NULL, 27, '多线程');
INSERT INTO `tb_knowledges` VALUES (3, NULL, NULL, 27, 'JVM');
INSERT INTO `tb_knowledges` VALUES (4, NULL, NULL, 27, '集合');
INSERT INTO `tb_knowledges` VALUES (5, NULL, NULL, 27, 'IO');
INSERT INTO `tb_knowledges` VALUES (6, NULL, NULL, 27, '网络编程');
INSERT INTO `tb_knowledges` VALUES (7, NULL, '1', 27, '封装');
INSERT INTO `tb_knowledges` VALUES (8, NULL, '1', 27, '继承');
INSERT INTO `tb_knowledges` VALUES (9, NULL, '1', 27, '多态');
INSERT INTO `tb_knowledges` VALUES (10, NULL, '1', 27, '重写');
INSERT INTO `tb_knowledges` VALUES (11, NULL, '1', 27, '重载');
INSERT INTO `tb_knowledges` VALUES (12, NULL, '1', 27, '数据类型');
INSERT INTO `tb_knowledges` VALUES (13, NULL, '1', 27, '接口');
INSERT INTO `tb_knowledges` VALUES (14, NULL, '1', 27, '继承');
INSERT INTO `tb_knowledges` VALUES (15, NULL, '1', 27, '类');
INSERT INTO `tb_knowledges` VALUES (16, NULL, '2', 27, '线程创建');
INSERT INTO `tb_knowledges` VALUES (17, NULL, '2', 27, '同步');
INSERT INTO `tb_knowledges` VALUES (18, NULL, '2', 27, '锁');
INSERT INTO `tb_knowledges` VALUES (19, NULL, '2', 27, '线程池');
INSERT INTO `tb_knowledges` VALUES (20, NULL, '3', 27, 'GC');
INSERT INTO `tb_knowledges` VALUES (21, NULL, '4', 27, 'Map');
INSERT INTO `tb_knowledges` VALUES (22, NULL, '4', 27, 'Set');
INSERT INTO `tb_knowledges` VALUES (23, NULL, '4', 27, 'List');
INSERT INTO `tb_knowledges` VALUES (24, NULL, '4', 27, 'Queue');
INSERT INTO `tb_knowledges` VALUES (25, NULL, '5', 27, '字节流');
INSERT INTO `tb_knowledges` VALUES (26, NULL, '5', 27, '字符流');
INSERT INTO `tb_knowledges` VALUES (27, '', '21', 27, 'HashMap');
INSERT INTO `tb_knowledges` VALUES (28, NULL, '21', 27, 'CurrentHashMp');

-- ----------------------------
-- Table structure for tb_message
-- ----------------------------
DROP TABLE IF EXISTS `tb_message`;
CREATE TABLE `tb_message`  (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content_id` int(11) NULL DEFAULT NULL,
  `course_id` int(11) NULL DEFAULT NULL,
  `from_user` int(11) NULL DEFAULT NULL,
  `sent_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` tinyint(1) NULL DEFAULT 0,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `to_user` int(11) NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`message_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_message
-- ----------------------------
INSERT INTO `tb_message` VALUES (1, 'sss', NULL, NULL, -1, '2020-05-08 22:00:27', 1, 'sss', 1, 0);
INSERT INTO `tb_message` VALUES (2, NULL, 1, NULL, 1, '2020-05-14 20:14:11', 0, '对你进行了的评论', 1, 1);
INSERT INTO `tb_message` VALUES (3, NULL, 1, NULL, 1, '2020-05-14 20:14:16', 0, '对你进行了的评论', 1, 1);

-- ----------------------------
-- Table structure for tb_question
-- ----------------------------
DROP TABLE IF EXISTS `tb_question`;
CREATE TABLE `tb_question`  (
  `qid` int(11) NOT NULL AUTO_INCREMENT,
  `analysis` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `degree` int(11) NULL DEFAULT 0,
  `direction` int(11) NULL DEFAULT NULL,
  `knowledge` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `options` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `score` int(11) NULL DEFAULT 0,
  `subject` int(11) NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT NULL,
  `uid` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`qid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_record_daily
-- ----------------------------
DROP TABLE IF EXISTS `tb_record_daily`;
CREATE TABLE `tb_record_daily`  (
  `rdid` int(11) NOT NULL AUTO_INCREMENT,
  `knowledges1` int(11) NULL DEFAULT NULL,
  `knowledges2` int(11) NULL DEFAULT NULL,
  `knowledges3` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`rdid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for tb_record_quertions
-- ----------------------------
DROP TABLE IF EXISTS `tb_record_quertions`;
CREATE TABLE `tb_record_quertions`  (
  `rqid` int(11) NOT NULL AUTO_INCREMENT,
  `date_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `error` bit(1) NULL DEFAULT b'1',
  `qusertion_id` int(11) NULL DEFAULT NULL,
  `score` int(11) NULL DEFAULT 0,
  `test_id` int(11) NULL DEFAULT NULL,
  `user_answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`rqid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_record_tests
-- ----------------------------
DROP TABLE IF EXISTS `tb_record_tests`;
CREATE TABLE `tb_record_tests`  (
  `rtid` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `degree` int(11) NULL DEFAULT 0,
  `spend_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `test_id` int(11) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `total_num` int(11) NULL DEFAULT 0,
  `total_score` int(11) NULL DEFAULT 0,
  `true_num` int(11) NULL DEFAULT 0,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`rtid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
  `count` int(11) NULL DEFAULT 0,
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `degree` int(11) NULL DEFAULT 0,
  `done` int(11) NULL DEFAULT 0,
  `other` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `socre` int(11) NULL DEFAULT 0,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT 0,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`test_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `birthday` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `direction` int(11) NULL DEFAULT NULL,
  `head_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `identity` int(11) NULL DEFAULT NULL,
  `join_day` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `school` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` bit(1) NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, '2020-05-11T16:00:00.000Z', '11', 1, 'http://192.168.183.130/group1/M00/00/00/wKi3gl61ZauAUaykAACJTjs7_vA014.jpg', 0, '2020-05-08 17:07:07', '11', '11', b'0', '涛涛');

SET FOREIGN_KEY_CHECKS = 1;
