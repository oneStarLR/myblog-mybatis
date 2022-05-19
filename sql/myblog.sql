/*
 Navicat Premium Data Transfer

 Source Server         : 81.68.74.42
 Source Server Type    : MySQL
 Source Server Version : 50735
 Source Host           : 81.68.74.42:3306
 Source Schema         : myblog

 Target Server Type    : MySQL
 Target Server Version : 50735
 File Encoding         : 65001

 Date: 20/05/2022 03:26:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = FIXED;

-- ----------------------------
-- Table structure for t_blog
-- ----------------------------
DROP TABLE IF EXISTS `t_blog`;
CREATE TABLE `t_blog`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `appreciation` bit(1) NOT NULL,
  `commentabled` bit(1) NOT NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `first_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `published` bit(1) NOT NULL,
  `recommend` bit(1) NOT NULL,
  `share_statement` bit(1) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `views` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type_id` bigint(20) NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comment_count` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK292449gwg5yf7ocdlmswv9w4j`(`type_id`) USING BTREE,
  INDEX `FK8ky5rrsxh01nkhctmo7d48p82`(`user_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 93 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_blog_tags
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_tags`;
CREATE TABLE `t_blog_tags`  (
  `blogs_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tags_id` bigint(20) NOT NULL,
  INDEX `FK5feau0gb4lq47fdb03uboswm8`(`tags_id`) USING BTREE,
  INDEX `FKh4pacwjwofrugxa9hpwaxg6mr`(`blogs_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = FIXED;

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `blog_id` bigint(20) NULL DEFAULT NULL,
  `parent_comment_id` bigint(20) NULL DEFAULT NULL,
  `admin_comment` bit(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2193 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_friend
-- ----------------------------
DROP TABLE IF EXISTS `t_friend`;
CREATE TABLE `t_friend`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `blogaddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `blogname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `pictureaddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 92 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_memory
-- ----------------------------
DROP TABLE IF EXISTS `t_memory`;
CREATE TABLE `t_memory`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `picture_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `memory` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `parent_message_id` bigint(20) NULL DEFAULT NULL,
  `admin_message` bit(1) NOT NULL,
  `parent_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8132 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_picture
-- ----------------------------
DROP TABLE IF EXISTS `t_picture`;
CREATE TABLE `t_picture`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pictureaddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `picturedescription` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `picturename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `picturetime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_resources
-- ----------------------------
DROP TABLE IF EXISTS `t_resources`;
CREATE TABLE `t_resources`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `resource_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `resource_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `first_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `second_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `picture_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `resource_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `sort` int(10) UNSIGNED NULL DEFAULT 0,
  `published` tinyint(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 472 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_type
-- ----------------------------
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 43 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
