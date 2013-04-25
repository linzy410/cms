-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.27 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL version:             7.0.0.4053
-- Date/time:                    2013-04-25 17:23:27
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

-- Dumping database structure for cms
DROP DATABASE IF EXISTS `cms`;
CREATE DATABASE IF NOT EXISTS `cms` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cms`;


-- Dumping structure for table cms.Menu
DROP TABLE IF EXISTS `Menu`;
CREATE TABLE IF NOT EXISTS `Menu` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '中文名',
  `nameEn` varchar(50) NOT NULL COMMENT '英文名',
  `listOrder` smallint(6) DEFAULT '0' COMMENT '顺序',
  `url` varchar(250) DEFAULT NULL COMMENT '链接',
  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1=单张页面  2=特定链接 3=新闻资讯类',
  `isShow` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0=展示 1=隐藏',
  `lang` tinyint(4) NOT NULL DEFAULT '0',
  `creator` varchar(20) NOT NULL,
  `createTime` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='菜单';

-- Dumping data for table cms.Menu: ~9 rows (approximately)
/*!40000 ALTER TABLE `Menu` DISABLE KEYS */;
INSERT INTO `Menu` (`id`, `name`, `nameEn`, `listOrder`, `url`, `type`, `isShow`, `lang`, `creator`, `createTime`) VALUES
	(1, '新闻资讯', 'NEWS', 5, '/news.action', 2, 0, 0, '李四', '2013-04-22 10:21:38'),
	(4, '展会类别', 'EXHIBITOR', 3, '2312', 1, 0, 0, '李四', '2013-04-22 14:36:54'),
	(5, '首页', 'HOME', 1, '/home.action', 2, 0, 0, '李四', '2013-04-22 14:37:13'),
	(6, '展会概况', 'DATE & FACTS', 2, '13123', 1, 0, 0, '李四', '2013-04-22 14:37:41'),
	(7, '观众来源', 'VISITOR', 4, '312', 1, 0, 0, '李四', '2013-04-22 14:38:32'),
	(8, '合作伙伴', 'PARTNERS', 6, '312', 1, 0, 0, '李四', '2013-04-22 14:38:48'),
	(9, '展会服务', 'SERVICES', 7, '', 1, 0, 0, '李四', '2013-04-22 14:38:59'),
	(10, '往届回顾', 'REVIEW', 8, '312', 1, 0, 0, '李四', '2013-04-22 14:39:11'),
	(11, '联系我们', 'CONTACT', 9, '12123123', 1, 0, 0, '李四', '2013-04-22 14:39:21');
/*!40000 ALTER TABLE `Menu` ENABLE KEYS */;


-- Dumping structure for table cms.MenuContent
DROP TABLE IF EXISTS `MenuContent`;
CREATE TABLE IF NOT EXISTS `MenuContent` (
  `menuId` int(10) NOT NULL,
  `content` text NOT NULL,
  PRIMARY KEY (`menuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单页面内容';

-- Dumping data for table cms.MenuContent: ~2 rows (approximately)
/*!40000 ALTER TABLE `MenuContent` DISABLE KEYS */;
INSERT INTO `MenuContent` (`menuId`, `content`) VALUES
	(0, ''),
	(6, '<p><span style="font-size: medium;">sdfasdfasdfas</span></p>\r\n<p><span style="font-size: medium;">df</span></p>\r\n<p><span style="font-size: medium;">as</span></p>\r\n<p><span style="font-size: medium;">df夺工模压 基本原则塔顶 塔顶 <br /></span></p>\r\n<p><span style="font-size: medium;">asd</span></p>\r\n<p><span style="font-size: medium;">f</span></p>\r\n<p><span style="font-size: medium;">as</span></p>\r\n<p><span style="font-size: medium;">df</span></p>\r\n<p><span style="font-size: medium;">asd</span></p>\r\n<p><span style="font-size: medium;">f</span></p>');
/*!40000 ALTER TABLE `MenuContent` ENABLE KEYS */;


-- Dumping structure for table cms.News
DROP TABLE IF EXISTS `News`;
CREATE TABLE IF NOT EXISTS `News` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `type` tinyint(4) NOT NULL,
  `imageId` int(10) unsigned DEFAULT NULL,
  `content` text NOT NULL,
  `lang` tinyint(4) NOT NULL,
  `creator` varchar(20) NOT NULL,
  `createTime` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- Dumping data for table cms.News: ~15 rows (approximately)
/*!40000 ALTER TABLE `News` DISABLE KEYS */;
INSERT INTO `News` (`id`, `title`, `type`, `imageId`, `content`, `lang`, `creator`, `createTime`) VALUES
	(1, '土城啦12333123', 0, 0, '请大家帮助了解雅安破坏情况后告诉我们。目前由于通讯受阻，请无急事的朋友勿拨打手机。感谢！ //@中国国际救援队:请有震感的朋友参加评论，无感的朋友只转发不要评论，请有感的朋友注明地点、震感程度和看到的破坏程度。再次感谢大家的热心，请速转发！快快快！', 0, '张三', '2013-04-20 12:12:12'),
	(2, '土城啦12333123', 0, 0, '请大家帮助了解雅安破坏情况后告诉我们。目前由于通讯受阻，请无急事的朋友勿拨打手机。感谢！ //@中国国际救援队:请有震感的朋友参加评论，无感的朋友只转发不要评论，请有感的朋友注明地点、震感程度和看到的破坏程度。再次感谢大家的热心，请速转发！快快快！', 0, '张三', '2013-04-20 12:12:12'),
	(3, '土城啦12333123', 0, 0, '请大家帮助了解雅安破坏情况后告诉我们。目前由于通讯受阻，请无急事的朋友勿拨打手机。感谢！ //@中国国际救援队:请有震感的朋友参加评论，无感的朋友只转发不要评论，请有感的朋友注明地点、震感程度和看到的破坏程度。再次感谢大家的热心，请速转发！快快快！', 0, '张三', '2013-04-20 12:12:12'),
	(4, '土城啦12333123', 0, 0, '请大家帮助了解雅安破坏情况后告诉我们。目前由于通讯受阻，请无急事的朋友勿拨打手机。感谢！ //@中国国际救援队:请有震感的朋友参加评论，无感的朋友只转发不要评论，请有感的朋友注明地点、震感程度和看到的破坏程度。再次感谢大家的热心，请速转发！快快快！', 0, '张三', '2013-04-20 12:12:12'),
	(5, '土城啦12333123', 0, 0, '请大家帮助了解雅安破坏情况后告诉我们。目前由于通讯受阻，请无急事的朋友勿拨打手机。感谢！ //@中国国际救援队:请有震感的朋友参加评论，无感的朋友只转发不要评论，请有感的朋友注明地点、震感程度和看到的破坏程度。再次感谢大家的热心，请速转发！快快快！', 0, '张三', '2013-04-20 12:12:12'),
	(6, '土城啦12333123', 0, 0, '请大家帮助了解雅安破坏情况后告诉我们。目前由于通讯受阻，请无急事的朋友勿拨打手机。感谢！ //@中国国际救援队:请有震感的朋友参加评论，无感的朋友只转发不要评论，请有感的朋友注明地点、震感程度和看到的破坏程度。再次感谢大家的热心，请速转发！快快快！', 0, '张三', '2013-04-20 12:12:12'),
	(7, '土城啦12333123', 0, 0, '请大家帮助了解雅安破坏情况后告诉我们。目前由于通讯受阻，请无急事的朋友勿拨打手机。感谢！ //@中国国际救援队:请有震感的朋友参加评论，无感的朋友只转发不要评论，请有感的朋友注明地点、震感程度和看到的破坏程度。再次感谢大家的热心，请速转发！快快快！', 0, '张三', '2013-04-20 12:12:12'),
	(8, '土城啦12333123', 0, 0, '请大家帮助了解雅安破坏情况后告诉我们。目前由于通讯受阻，请无急事的朋友勿拨打手机。感谢！ //@中国国际救援队:请有震感的朋友参加评论，无感的朋友只转发不要评论，请有感的朋友注明地点、震感程度和看到的破坏程度。再次感谢大家的热心，请速转发！快快快！', 0, '张三', '2013-04-20 12:12:12'),
	(9, '土城啦12333123', 0, 0, '请大家帮助了解雅安破坏情况后告诉我们。目前由于通讯受阻，请无急事的朋友勿拨打手机。感谢！ //@中国国际救援队:请有震感的朋友参加评论，无感的朋友只转发不要评论，请有感的朋友注明地点、震感程度和看到的破坏程度。再次感谢大家的热心，请速转发！快快快！', 0, '张三', '2013-04-20 12:12:12'),
	(10, '土城啦12333123', 0, 0, '请大家帮助了解雅安破坏情况后告诉我们。目前由于通讯受阻，请无急事的朋友勿拨打手机。感谢！ //@中国国际救援队:请有震感的朋友参加评论，无感的朋友只转发不要评论，请有感的朋友注明地点、震感程度和看到的破坏程度。再次感谢大家的热心，请速转发！快快快！', 0, '张三', '2013-04-20 12:12:12'),
	(11, '土城啦12333123', 0, 0, '请大家帮助了解雅安破坏情况后告诉我们。目前由于通讯受阻，请无急事的朋友勿拨打手机。感谢！ //@中国国际救援队:请有震感的朋友参加评论，无感的朋友只转发不要评论，请有感的朋友注明地点、震感程度和看到的破坏程度。再次感谢大家的热心，请速转发！快快快！', 0, '张三', '2013-04-20 12:12:12'),
	(13, 'cdasdfa在在厅', 0, 0, '<p>sd在顶替枯</p>', 0, '张三', '2013-04-20 12:12:12'),
	(19, 'ab', 0, 0, 'b', 0, '李四', '2013-04-20 21:44:11'),
	(20, '一二', 0, 0, '三五', 0, '李四', '2013-04-21 21:32:25'),
	(21, 'a', 0, 0, '<p>b</p>', 0, '李四', '2013-04-23 09:18:13');
/*!40000 ALTER TABLE `News` ENABLE KEYS */;


-- Dumping structure for table cms.UploadFile
DROP TABLE IF EXISTS `UploadFile`;
CREATE TABLE IF NOT EXISTS `UploadFile` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fileName` varchar(100) NOT NULL COMMENT '文件保存名称',
  `filePath` varchar(100) NOT NULL COMMENT '文件保存路径',
  `uploadName` varchar(100) NOT NULL COMMENT '文件上传名称',
  `type` tinyint(4) NOT NULL COMMENT '文件类别 1=manual',
  `createTime` varchar(20) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 COMMENT='文件上传表';

-- Dumping data for table cms.UploadFile: ~0 rows (approximately)
/*!40000 ALTER TABLE `UploadFile` DISABLE KEYS */;
/*!40000 ALTER TABLE `UploadFile` ENABLE KEYS */;


-- Dumping structure for table cms.User
DROP TABLE IF EXISTS `User`;
CREATE TABLE IF NOT EXISTS `User` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` tinyint(4) NOT NULL,
  `createTime` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- Dumping data for table cms.User: ~0 rows (approximately)
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
