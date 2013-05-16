-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.27 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL version:             7.0.0.4053
-- Date/time:                    2013-05-16 09:30:20
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
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 COMMENT='文件上传表';

-- Dumping data for table cms.Image: ~0 rows (approximately)
/*!40000 ALTER TABLE `Image` DISABLE KEYS */;
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
  `imgId` int(10) NOT NULL DEFAULT '0',
  `creator` varchar(20) NOT NULL,
  `createTime` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='菜单';

-- Dumping data for table cms.Menu: ~9 rows (approximately)
/*!40000 ALTER TABLE `Menu` DISABLE KEYS */;
INSERT INTO `Menu` (`id`, `name`, `nameEn`, `listOrder`, `url`, `type`, `isShow`, `imgId`, `creator`, `createTime`) VALUES
	(1, '新闻资讯', 'NEWS', 5, '/news.action', 3, 0, 0, '李四', '2013-04-22 10:21:38'),
	(4, '展会类别', 'EXHIBITOR', 3, '', 1, 0, 7, '李四', '2013-04-22 14:36:54'),
	(5, '首页', 'HOME', 1, '/', 2, 0, 0, '李四', '2013-04-22 14:37:13'),
	(6, '展会概况', 'DATE & FACTS', 2, '', 1, 0, 6, '李四', '2013-04-22 14:37:41'),
	(7, '观众来源', 'VISITOR', 4, '', 1, 0, 8, '李四', '2013-04-22 14:38:32'),
	(8, '合作伙伴', 'PARTNERS', 6, '', 1, 0, 9, '李四', '2013-04-22 14:38:48'),
	(9, '展会服务', 'SERVICES', 7, '', 1, 0, 11, '李四', '2013-04-22 14:38:59'),
	(10, '往届回顾', 'REVIEW', 8, '', 1, 0, 12, '李四', '2013-04-22 14:39:11'),
	(11, '联系我们', 'CONTACT', 9, '', 1, 0, 13, '李四', '2013-04-22 14:39:21');
/*!40000 ALTER TABLE `Menu` ENABLE KEYS */;


-- Dumping structure for table cms.MenuContent
DROP TABLE IF EXISTS `MenuContent`;
CREATE TABLE IF NOT EXISTS `MenuContent` (
  `menuId` int(10) NOT NULL,
  `content` text NOT NULL,
  `contentEn` text NOT NULL,
  PRIMARY KEY (`menuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单页面内容';

-- Dumping data for table cms.MenuContent: ~0 rows (approximately)
/*!40000 ALTER TABLE `MenuContent` DISABLE KEYS */;
/*!40000 ALTER TABLE `MenuContent` ENABLE KEYS */;


-- Dumping structure for table cms.News
DROP TABLE IF EXISTS `News`;
CREATE TABLE IF NOT EXISTS `News` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `type` tinyint(4) NOT NULL COMMENT '与menuId对应',
  `imgPath` varchar(250) DEFAULT NULL,
  `content` text NOT NULL,
  `summary` varchar(1000) NOT NULL,
  `lang` tinyint(4) NOT NULL,
  `creator` varchar(20) NOT NULL,
  `createTime` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table cms.News: ~0 rows (approximately)
/*!40000 ALTER TABLE `News` DISABLE KEYS */;
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


-- Dumping structure for table cms.WebSite
DROP TABLE IF EXISTS `WebSite`;
CREATE TABLE IF NOT EXISTS `WebSite` (
  `title` varchar(500) NOT NULL COMMENT '标题',
  `description` varchar(5000) NOT NULL COMMENT '描述',
  `keywords` varchar(5000) NOT NULL COMMENT '关键词',
  `topImg` varchar(100) NOT NULL COMMENT '顶部图片',
  `bottomImg` varchar(100) NOT NULL COMMENT '底部图片',
  `lang` tinyint(4) NOT NULL DEFAULT '0' COMMENT '语言'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='网站信息';

-- Dumping data for table cms.WebSite: ~0 rows (approximately)
/*!40000 ALTER TABLE `WebSite` DISABLE KEYS */;
/*!40000 ALTER TABLE `WebSite` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
