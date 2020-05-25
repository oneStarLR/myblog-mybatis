# myblog-mybaits
个人博客系统（SpringBoot+Mybatis）

博客地址：https://onestar.newstar.net.cn/

**使用该源码希望能够注明原博客以及源码出处，并禁止商用，谢谢！**


> 本文将从技术栈、功能需求、数据库设计来讲述，前端页面展示可以看我上一篇文章[：【SpringBoot搭建个人博客】- 前端页面展示（一）](https://onestar.newstar.net.cn/blog/37)

### 一、技术栈
#### 1.前端
- JS框架：JQuery
- CSS框架：[Semantic UI官网](https://semantic-ui.com/)
- Markdown编辑器：[编辑器 Markdown](https://pandao.github.io/editor.md/)
- 代码高亮：[代码高亮 prism](https://github.com/PrismJS/prism)
- 动画效果：[动画 animate.css](https://daneden.github.io/animate.css/)
- 文章目录：[目录生成 Tocbot](https://tscanlin.github.io/tocbot/)
- 音乐盒[：zplayer](https://gitee.com/supperzh/zplayer)
- 照片墙[：lightbox插件](https://github.com/JavaScript-Kit/jkresponsivegallery)

#### 2.后端
- 核心框架：SpringBoot 2.2.5
- 项目构建：jdk1.8、Maven 3
- 持久层框架：Mybatis
- 模板框架：Thymeleaf
- 分页插件：PageHelper
- 加密：MD5加密
- 运行环境：腾讯云Centos7

#### 3.数据库
- MySQL 5.7

### 二、功能需求
因为是个人博客，所以没有做用户权限管理，只是简单的区分了一下普通用户和管理员用户，这里就根据普通用户和管理员用户来讲述功能需求，其实从上一篇博文的前端页面就能大致的看出需求了

#### 1.普通用户
- 查看文章信息：文章列表、推荐文章、文章标题、文章内容、发布时间、访问量以及评论等信息
- 查看分类文章：分类列表、分类文章信息
- 查看时间轴：按照文章时间发布顺序查看文章
- 搜索文章：导航栏右边搜索框根据关键字搜索
- 听音乐：上一曲、下一曲、音量控制、播放顺序控制、查看歌词等
- 留言：留言并回复
- 查看友链：查看并访问博主在友链页面添加的友链连接
- 查看相册信息：相册列表、照片名称、照片拍摄地点、时间、照片描述

#### 2.管理员用户（栈主）
- 拥有普通用户所有功能权限
- 登录：在主页路径下加“/admin”，可进入登录页面，根据数据库的用户名和密码进行登录
- 文章管理：查询文章列表、新增文章、编辑文章、删除文章、搜索文章
- 分类管理：查询分类列表、新增分类、编辑分类、删除分类
- 友链管理：查询友链列表、新增友链、编辑友链、删除友链
- 相册管理：查询相册列表、新增照片、编辑照片、删除照片
- 消息管理：登录后恢复评论留言会显示栈主的头像信息，并能显示删除消息按键，可以对消息进行删除

### 三、数据库设计
> 由于博主最开始是使用jpa作为持久层开发此博客的，数据表是由jpa框架自动生成的，在使用mybatis为持久层的时候就沿用了jpa生成的数据库，但是对评论表和留言表进行了改动，如果同样是先用jpa，再用mybatis开发的伙伴这里要注意一下，如果直接使用mybatis开发的则可以忽略

#### 1.数据表
- 博客数据表：t_blog
- 分类数据表：t_type
- 用户数据表：t_user
- 评论数据表：t_comment
- 留言数据表：t_message
- 友链数据表：t_friend
- 相册数据表：t_picture

#### 2.实体关系

![image](https://note.youdao.com/yws/api/personal/file/CACBEF653E6745BF834B892952BFA816?method=download&shareKey=946ce6c8c2a0c84b107053cc254088f2)

- 博客和分类是多对一的关系：一个博客对应一个分类，一个分类可以对应多个博客
- 博客和用户是多对一的关系：一个博客对应一个用户，一个用户可以对应多个博客
- 博客和评论是一对多的关系：一个博客可以对应多个评论，一个评论对应一个博客
- 评论和回复是一对多的关系：一个评论可以对应多个回复，一个回复对应一个评论

> 留言和评论是一样的，还有友链和相册数据表和其他表没有关联

#### 3.实体属性
博客属性：

![image](https://note.youdao.com/yws/api/personal/file/CF5106DE22344BB481B3412A5BFAAAB9?method=download&shareKey=ae43526cd18465a53011fccbbe6e25c8)

分类属性：

![image](https://note.youdao.com/yws/api/personal/file/6C78F81369EB477B98D540266E5F4F58?method=download&shareKey=a820cfe6f3d6ebd860f0dff1b3bf8ba8)

用户属性：

![image](https://note.youdao.com/yws/api/personal/file/74338146706B4DB18C392C58C6287257?method=download&shareKey=2ad9cd5685461de2d57b983e85d97612)

评论属性：

![image](https://note.youdao.com/yws/api/personal/file/012FA484A82F47F5834BDB3FF7F1F668?method=download&shareKey=e971a831c76926da204a87ec5ac41a48)

留言属性：

![image](https://note.youdao.com/yws/api/personal/file/DC140E28066C4A54BAF8CDD351B4E479?method=download&shareKey=a39cdf3a8661671ac1a5de0b27a3e855)

友链属性：

![image](https://note.youdao.com/yws/api/personal/file/D4A2CC8BA02C4CFAA1279A8C5BF95B83?method=download&shareKey=fc02df1a79a3d6086be94758c5370918)

相册属性：

![image](https://note.youdao.com/yws/api/personal/file/0648E5B2CA874903919E01F8854A36E4?method=download&shareKey=ef3e79e99d83615b6020eb8e9356c8c2)


- 博客属性：标题、内容、首图、标记、浏览次数、赞赏开启、版权开启、评论开启、是否发布、创建时间、更新时间、描述
- 分类属性：分类名称
- 用户属性：昵称、用户名、密码、邮箱、类型、头像、创建时间、更新时间
- 评论属性：昵称、邮箱、头像、评论内容、创建时间、博客id、父评论id、管理员id
- 留言属性：昵称、邮箱、头像、留言内容、创建时间、父留言id、管理员id
- 友链属性：网址、名称、创建时间、图片地址
- 相册属性：图片地址、图片描述、图片名称、拍摄时间地点

#### 4.表结构
博客表：

![image](https://note.youdao.com/yws/api/personal/file/6559F08528F24F7195279C5FEDF52644?method=download&shareKey=3aa33f0533b03214f163cd601fae0c9c)

分类表：

![image](https://note.youdao.com/yws/api/personal/file/D06135B93E2048B6924BD236BC255BDA?method=download&shareKey=f5f91a8cc8735f708cef2b1cae775231)

用户表：

![image](https://note.youdao.com/yws/api/personal/file/290F867E30DB4660B43DCF3DA29ED32F?method=download&shareKey=d180fe4a8e610b72bc250292a85ab1f9)

评论表：

![image](https://note.youdao.com/yws/api/personal/file/1B76BB89DD3545108A0116E9ABAFF35C?method=download&shareKey=44605f12ba7c296616de066f9d18edfc)


留言表：

![image](https://note.youdao.com/yws/api/personal/file/D29424D70CD44AD787B5B2BA74D0AEE2?method=download&shareKey=2070c81708cc3588f4de7fc303369df2)


友链表：

![image](https://note.youdao.com/yws/api/personal/file/0575501118154154BE53910A0D3F843B?method=download&shareKey=acf785dae919b80c235ddca9d6a1df38)


相册表：

![image](https://note.youdao.com/yws/api/personal/file/DE3BFFBA1DB5415F8C1B70E30B676BF0?method=download&shareKey=526904984ef591f552a72c6cb48e9404)




#### 4.建表语句

```sql
/*
 Navicat MySQL Data Transfer

 Source Server         : myblog-localhost
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : myblog

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 30/04/2020 17:02:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `first_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `published` bit(1) NOT NULL,
  `recommend` bit(1) NOT NULL,
  `share_statement` bit(1) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `views` int(11) NULL DEFAULT NULL,
  `type_id` bigint(20) NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  `comment_count` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK292449gwg5yf7ocdlmswv9w4j`(`type_id`) USING BTREE,
  INDEX `FK8ky5rrsxh01nkhctmo7d48p82`(`user_id`) USING BTREE,
  CONSTRAINT `FK292449gwg5yf7ocdlmswv9w4j` FOREIGN KEY (`type_id`) REFERENCES `t_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK8ky5rrsxh01nkhctmo7d48p82` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 62 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `parent_message_id` bigint(20) NULL DEFAULT NULL,
  `admin_message` bit(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_type
-- ----------------------------
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

```

下一篇将讲述后端框架的搭建

【点关注，不迷路，欢迎关注本站】

地址：https://onestar.newstar.net.cn/
