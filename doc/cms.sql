-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.27 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL version:             7.0.0.4053
-- Date/time:                    2013-05-07 17:45:17
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

-- Dumping database structure for cms
DROP DATABASE IF EXISTS `cms`;
CREATE DATABASE IF NOT EXISTS `cms` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cms`;


-- Dumping structure for table cms.Ad
DROP TABLE IF EXISTS `Ad`;
CREATE TABLE IF NOT EXISTS `Ad` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `imgId` int(11) NOT NULL,
  `type` tinyint(4) NOT NULL,
  `isShow` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0=展示 1=隐藏',
  `creator` varchar(50) NOT NULL,
  `createTime` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table cms.Ad: ~0 rows (approximately)
/*!40000 ALTER TABLE `Ad` DISABLE KEYS */;
/*!40000 ALTER TABLE `Ad` ENABLE KEYS */;


-- Dumping structure for table cms.Image
DROP TABLE IF EXISTS `Image`;
CREATE TABLE IF NOT EXISTS `Image` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `saveFile` varchar(100) NOT NULL COMMENT '文件保存名称',
  `name` varchar(100) NOT NULL COMMENT '文件保存路径',
  `type` tinyint(4) NOT NULL COMMENT '文件类别 1=manual',
  `lang` tinyint(4) NOT NULL,
  `creator` varchar(20) NOT NULL,
  `createTime` varchar(20) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=gb2312 COMMENT='文件上传表';

-- Dumping data for table cms.Image: ~23 rows (approximately)
/*!40000 ALTER TABLE `Image` DISABLE KEYS */;
INSERT INTO `Image` (`id`, `saveFile`, `name`, `type`, `lang`, `creator`, `createTime`) VALUES
	(10, '201305/16510000004.jpg', '5f204f4a3070442e09f7ef87.jpg', 2, 0, '张三', '2013-05-06 16:51:04'),
	(11, '201305/1651000000426.jpg', '2111801_jietu.jpg', 2, 0, '张三', '2013-05-06 16:51:04'),
	(12, '201305/16510000004293.jpg', '3050636_082642593076_2.jpg', 2, 0, '张三', '2013-05-06 16:51:04'),
	(13, '201305/16510000005.jpg', '3546312_103013013206_2.jpg', 2, 0, '张三', '2013-05-06 16:51:05'),
	(14, '201305/16510000005686.jpg', '3781343_144710048593_2.jpg', 2, 0, '张三', '2013-05-06 16:51:05'),
	(15, '201305/16510000005842.jpg', '5900523_143830081572_2.jpg', 2, 0, '张三', '2013-05-06 16:51:05'),
	(16, '201305/16510000005377.jpg', '6062870_035324015793_2.jpg', 2, 0, '张三', '2013-05-06 16:51:05'),
	(17, '201305/16510000006.png', '6109148_155907604000_2.png', 2, 0, '张三', '2013-05-06 16:51:06'),
	(18, '201305/16510000006.jpg', '8444952_130307297172_2.jpg', 2, 0, '张三', '2013-05-06 16:51:06'),
	(19, '201305/16510000007.jpg', '8860088_202405441127_2.jpg', 2, 0, '张三', '2013-05-06 16:51:07'),
	(20, '201305/16510000007896.jpg', '01300000196866121655107279124.jpg', 2, 0, '张三', '2013-05-06 16:51:07'),
	(21, '201305/16510000007323.jpg', 'bf39b899c2f02a286f068c4b.jpg', 2, 0, '张三', '2013-05-06 16:51:07'),
	(22, '201305/16510000007765.jpg', 'e9d63261fb4132b6257fb532.jpg', 2, 0, '张三', '2013-05-06 16:51:07'),
	(23, '201305/14470000024.jpg', '3781343_144710048593_2.jpg', 3, 0, '管理员', '2013-05-07 14:47:24'),
	(24, '201305/14470000038.jpg', '5900523_143830081572_2.jpg', 3, 0, '管理员', '2013-05-07 14:47:38'),
	(25, '201305/14480000012.jpg', '3781343_144710048593_2.jpg', 3, 0, '管理员', '2013-05-07 14:48:12'),
	(26, '201305/14480000024.jpg', '3781343_144710048593_2.jpg', 3, 0, '管理员', '2013-05-07 14:48:24'),
	(27, '201305/14490000052.jpg', '5900523_143830081572_2.jpg', 3, 0, '管理员', '2013-05-07 14:49:52'),
	(28, '201305/17100000012.jpg', '3781343_144710048593_2.jpg', 3, 0, '管理员', '2013-05-07 17:10:12'),
	(29, '201305/17110000032.jpg', '3546312_103013013206_2.jpg', 3, 0, '管理员', '2013-05-07 17:11:32'),
	(30, '201305/17110000050.jpg', '3781343_144710048593_2.jpg', 3, 0, '管理员', '2013-05-07 17:11:50'),
	(31, '201305/17220000038.jpg', '3781343_144710048593_2.jpg', 3, 0, '管理员', '2013-05-07 17:22:38'),
	(32, '201305/17230000039.jpg', '3781343_144710048593_2.jpg', 3, 0, '管理员', '2013-05-07 17:23:39');
/*!40000 ALTER TABLE `Image` ENABLE KEYS */;


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
	(1, '新闻资讯', 'NEWS', 5, '/news.action', 3, 0, 0, '李四', '2013-04-22 10:21:38'),
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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- Dumping data for table cms.News: ~16 rows (approximately)
/*!40000 ALTER TABLE `News` DISABLE KEYS */;
INSERT INTO `News` (`id`, `title`, `type`, `imageId`, `content`, `lang`, `creator`, `createTime`) VALUES
	(1, '土城啦12333123', 1, 0, '请大家帮助了解雅安破坏情况后告诉我们。目前由于通讯受阻，请无急事的朋友勿拨打手机。感谢！ //@中国国际救援队:请有震感的朋友参加评论，无感的朋友只转发不要评论，请有感的朋友注明地点、震感程度和看到的破坏程度。再次感谢大家的热心，请速转发！快快快！', 0, '张三', '2013-04-20 12:12:12'),
	(2, '土城啦12333123', 1, 0, '请大家帮助了解雅安破坏情况后告诉我们。目前由于通讯受阻，请无急事的朋友勿拨打手机。感谢！ //@中国国际救援队:请有震感的朋友参加评论，无感的朋友只转发不要评论，请有感的朋友注明地点、震感程度和看到的破坏程度。再次感谢大家的热心，请速转发！快快快！', 0, '张三', '2013-04-20 12:12:12'),
	(3, '土城啦12333123', 1, 0, '请大家帮助了解雅安破坏情况后告诉我们。目前由于通讯受阻，请无急事的朋友勿拨打手机。感谢！ //@中国国际救援队:请有震感的朋友参加评论，无感的朋友只转发不要评论，请有感的朋友注明地点、震感程度和看到的破坏程度。再次感谢大家的热心，请速转发！快快快！', 0, '张三', '2013-04-20 12:12:12'),
	(4, '土城啦12333123', 1, 0, '请大家帮助了解雅安破坏情况后告诉我们。目前由于通讯受阻，请无急事的朋友勿拨打手机。感谢！ //@中国国际救援队:请有震感的朋友参加评论，无感的朋友只转发不要评论，请有感的朋友注明地点、震感程度和看到的破坏程度。再次感谢大家的热心，请速转发！快快快！', 0, '张三', '2013-04-20 12:12:12'),
	(5, '土城啦12333123', 1, 0, '请大家帮助了解雅安破坏情况后告诉我们。目前由于通讯受阻，请无急事的朋友勿拨打手机。感谢！ //@中国国际救援队:请有震感的朋友参加评论，无感的朋友只转发不要评论，请有感的朋友注明地点、震感程度和看到的破坏程度。再次感谢大家的热心，请速转发！快快快！', 0, '张三', '2013-04-20 12:12:12'),
	(6, '土城啦12333123', 1, 0, '请大家帮助了解雅安破坏情况后告诉我们。目前由于通讯受阻，请无急事的朋友勿拨打手机。感谢！ //@中国国际救援队:请有震感的朋友参加评论，无感的朋友只转发不要评论，请有感的朋友注明地点、震感程度和看到的破坏程度。再次感谢大家的热心，请速转发！快快快！', 0, '张三', '2013-04-20 12:12:12'),
	(7, '土城啦12333123', 1, 0, '请大家帮助了解雅安破坏情况后告诉我们。目前由于通讯受阻，请无急事的朋友勿拨打手机。感谢！ //@中国国际救援队:请有震感的朋友参加评论，无感的朋友只转发不要评论，请有感的朋友注明地点、震感程度和看到的破坏程度。再次感谢大家的热心，请速转发！快快快！', 0, '张三', '2013-04-20 12:12:12'),
	(8, '土城啦12333123', 1, 0, '请大家帮助了解雅安破坏情况后告诉我们。目前由于通讯受阻，请无急事的朋友勿拨打手机。感谢！ //@中国国际救援队:请有震感的朋友参加评论，无感的朋友只转发不要评论，请有感的朋友注明地点、震感程度和看到的破坏程度。再次感谢大家的热心，请速转发！快快快！', 0, '张三', '2013-04-20 12:12:12'),
	(9, '土城啦12333123', 1, 0, '请大家帮助了解雅安破坏情况后告诉我们。目前由于通讯受阻，请无急事的朋友勿拨打手机。感谢！ //@中国国际救援队:请有震感的朋友参加评论，无感的朋友只转发不要评论，请有感的朋友注明地点、震感程度和看到的破坏程度。再次感谢大家的热心，请速转发！快快快！', 0, '张三', '2013-04-20 12:12:12'),
	(10, '土城啦12333123', 1, 0, '请大家帮助了解雅安破坏情况后告诉我们。目前由于通讯受阻，请无急事的朋友勿拨打手机。感谢！ //@中国国际救援队:请有震感的朋友参加评论，无感的朋友只转发不要评论，请有感的朋友注明地点、震感程度和看到的破坏程度。再次感谢大家的热心，请速转发！快快快！', 0, '张三', '2013-04-20 12:12:12'),
	(11, '土城啦12333123', 1, 0, '请大家帮助了解雅安破坏情况后告诉我们。目前由于通讯受阻，请无急事的朋友勿拨打手机。感谢！ //@中国国际救援队:请有震感的朋友参加评论，无感的朋友只转发不要评论，请有感的朋友注明地点、震感程度和看到的破坏程度。再次感谢大家的热心，请速转发！快快快！', 0, '张三', '2013-04-20 12:12:12'),
	(13, 'cdasdfa在在厅', 1, 0, '<p>sd在顶替枯</p>', 0, '张三', '2013-04-20 12:12:12'),
	(19, 'ab', 1, 0, 'b', 0, '李四', '2013-04-20 21:44:11'),
	(20, '一二', 1, 0, '三五', 0, '李四', '2013-04-21 21:32:25'),
	(21, 'a', 1, 0, '<p>b</p>', 0, '李四', '2013-04-23 09:18:13'),
	(22, 'asdfasd基本原则塔顶 塔顶 ', 1, 0, '<p>fasdfasdf</p>\r\n<p>枯</p>\r\n<p>塔顶 塔顶</p>', 0, '李四', '2013-04-26 10:36:21');
/*!40000 ALTER TABLE `News` ENABLE KEYS */;


-- Dumping structure for table cms.User
DROP TABLE IF EXISTS `User`;
CREATE TABLE IF NOT EXISTS `User` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `createTime` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- Dumping data for table cms.User: ~1 rows (approximately)
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` (`id`, `username`, `name`, `password`, `createTime`) VALUES
	(1, 'admin', '管理员', '123456', '2013-05-06 16:20:44');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
