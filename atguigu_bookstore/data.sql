/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.0.27-community-nt : Database - pre_bookstore
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pre_bookstore` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `pre_bookstore`;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `accountid` varchar(30) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  `balance` float default NULL,
  PRIMARY KEY  (`accountid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `account` */

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `id` varchar(40) NOT NULL,
  `NAME` varchar(20) default NULL,
  `location` varchar(100) default NULL,
  `cellphone` varchar(20) default NULL,
  `usersid` varchar(40) default NULL,
  PRIMARY KEY  (`id`),
  KEY `usersid_FK` (`usersid`),
  CONSTRAINT `usersid_FK` FOREIGN KEY (`usersid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `address` */

insert  into `address`(`id`,`NAME`,`location`,`cellphone`,`usersid`) values ('12060d88-c2ba-473f-a07b-b71df9ec6586','dfd','fdf','2343','a83cdb41-7bc0-48b7-b6be-5d114633929b'),('7ac81365-e7ad-4933-b770-ee30ab329d8c','debug','BJ2','321321','a83cdb41-7bc0-48b7-b6be-5d114633929b'),('80d51863-7afa-4b68-a6f3-42d2cd5f2a98','ss','bb','123','933098ad-3737-423d-9cd7-733cfc6668e8'),('8dff3918-f53c-4fff-8360-6086882d9757','xx','ss','12323','933098ad-3737-423d-9cd7-733cfc6668e8'),('a06b9576-cf5e-466a-a528-aaab9f3ff61a','dd','ssss','12323','933098ad-3737-423d-9cd7-733cfc6668e8'),('d3e27465-8f66-4ea9-bf78-467add0246e7','ss','adf','123213','933098ad-3737-423d-9cd7-733cfc6668e8'),('ef96c205-2bf2-4829-b560-be08b97b4088','test','BJ','123123','a83cdb41-7bc0-48b7-b6be-5d114633929b');

/*Table structure for table `books` */

DROP TABLE IF EXISTS `books`;

CREATE TABLE `books` (
  `id` varchar(40) NOT NULL,
  `NAME` varchar(50) default NULL,
  `author` varchar(20) default NULL,
  `price` float default NULL,
  `salesamount` int(11) NOT NULL default '0',
  `storenumber` int(11) NOT NULL,
  `imagepath` varchar(100) default NULL,
  `categorysid` varchar(40) default NULL,
  PRIMARY KEY  (`id`),
  KEY `categorysid_FK` (`categorysid`),
  CONSTRAINT `categorysid_FK` FOREIGN KEY (`categorysid`) REFERENCES `categorys` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `books` */

insert  into `books`(`id`,`NAME`,`author`,`price`,`salesamount`,`storenumber`,`imagepath`,`categorysid`) values ('1536c475-e95a-4f20-a0ba-f75a073415d8','Spring实战',' Craig Walls',48,12,88,'/images/default.jpg','4d9e896e-dc65-42d3-a2a8-38c588932571'),('187fa13f-3c30-4f96-85ee-72949e9ad605','JavaScript高级程序设计','Nicholas',68.3,13,87,'/images/default.jpg','2aa38eb9-83cf-4291-ac1b-606d9c5ff424'),('1b9b8e01-80e3-4482-9fc3-812cb5dc71da','Java编程思想','Bruce Eckel',74.5,0,100,'/images/default.jpg','4d9e896e-dc65-42d3-a2a8-38c588932571'),('25980219-4486-46b3-87e2-ce4b6d557109','JAVA核心技术（卷1）','昊斯特曼',67.6,0,100,'/images/default.jpg','2aa38eb9-83cf-4291-ac1b-606d9c5ff424'),('3165a2a8-94a8-4d80-9b71-8f3de9dedacd','中国传统风水智慧一本通','陈晓倩 ',25.6,0,100,'/images/default.jpg','71e84241-f768-4de7-8775-d158646a70a8'),('317f9b27-ce09-4625-91a9-67dd704b7015','Java并发编程实战','Brian',52.3,0,100,'/images/default.jpg','2aa38eb9-83cf-4291-ac1b-606d9c5ff424'),('3fcc026f-1318-4cf3-95c9-d54a05de62c5','Java与模式','阎宏',70.5,0,100,'/images/default.jpg','2aa38eb9-83cf-4291-ac1b-606d9c5ff424'),('46c595d6-c8e8-4ea1-9d90-49c315552a0c','汤的100种做法','犀文图书',2.9,0,100,'/images/default.jpg','71e84241-f768-4de7-8775-d158646a70a8'),('60e2c99b-e389-4ee4-aa14-e6ae5cfe4394','婚姻心理学：婚姻是最好的修行','霍妮',20.3,0,100,'/images/default.jpg','71e84241-f768-4de7-8775-d158646a70a8'),('6d378712-73a5-4add-a1e4-c3e9cee3bbb4','Hibernate实战','鲍尔',87.1,0,100,'/images/default.jpg','2aa38eb9-83cf-4291-ac1b-606d9c5ff424'),('836d14fd-b037-4162-a587-aa5543ed42fc','跟着君之学烘焙','君之',19.4,0,100,'/images/default.jpg','4d9e896e-dc65-42d3-a2a8-38c588932571'),('933f23e4-cd26-45da-a0ae-c02ad60e4a2f','深入理解Java虚拟机','周志明',51.8,0,100,'/images/default.jpg','2aa38eb9-83cf-4291-ac1b-606d9c5ff424'),('a34c07c8-e3f0-4be9-a419-4a007ac087ce','男人来自火星，女人来自金星','约翰·格雷',14.9,0,100,'/images/default.jpg','71e84241-f768-4de7-8775-d158646a70a8'),('a563e59d-6fe8-451b-94fc-a253de8da498','海洋传','卡森',14,1,99,'/images/default.jpg','10373aa2-a4f5-4f66-bb60-1ef069d1453f'),('c56057bf-f812-4c1c-9186-e53bcab6c1fe','Tomcat与Java Web开发技术详解','孙卫琴',63.6,0,100,'/images/default.jpg','2aa38eb9-83cf-4291-ac1b-606d9c5ff424'),('c845f6dc-9be3-4c3c-8dd2-c95c9c204905','7天瘦肚子的神奇蔬果汁','藤井香江',16,0,100,'/images/default.jpg','71e84241-f768-4de7-8775-d158646a70a8'),('e0352593-738b-4984-b964-5c2da5a16a96','刘宇泽','柳土则',9.9,1,99,'/images/default.jpg','10373aa2-a4f5-4f66-bb60-1ef069d1453f'),('e83834e9-3e1a-48b0-9bbd-ea52d7e15a63','胡萝卜','胡萝卜',0,0,100,NULL,NULL),('e85da750-aa07-45d3-b59d-7ab5e97a166f','深入浅出Struts 2','Budi Kurniawan',44,0,100,'/images/default.jpg','2aa38eb9-83cf-4291-ac1b-606d9c5ff424'),('ee78a650-f04a-4cd6-be44-eff08f636a75','素描基础教程','张恒国',17.4,0,100,'/images/default.jpg','4d9e896e-dc65-42d3-a2a8-38c588932571'),('f1bc80cd-dfb4-46bc-ae5f-760720d98f64','Effective Java中文版','布洛克',35.9,0,100,'/images/default.jpg','2aa38eb9-83cf-4291-ac1b-606d9c5ff424'),('ffcddb60-8aa8-4c39-a1e1-396953af7ba2','怎样解题：数学思维的新方法','G·波利亚',23.2,0,100,'/images/default.jpg','10373aa2-a4f5-4f66-bb60-1ef069d1453f');

/*Table structure for table `categorys` */

DROP TABLE IF EXISTS `categorys`;

CREATE TABLE `categorys` (
  `id` varchar(40) NOT NULL,
  `NAME` varchar(30) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `categorys` */

insert  into `categorys`(`id`,`NAME`) values ('10373aa2-a4f5-4f66-bb60-1ef069d1453f','科学'),('2aa38eb9-83cf-4291-ac1b-606d9c5ff424','计算机'),('4d9e896e-dc65-42d3-a2a8-38c588932571','艺术'),('71e84241-f768-4de7-8775-d158646a70a8','生活');

/*Table structure for table `orderitems` */

DROP TABLE IF EXISTS `orderitems`;

CREATE TABLE `orderitems` (
  `id` varchar(40) NOT NULL,
  `quantity` int(11) default NULL,
  `price` float default NULL,
  `ordersid` varchar(40) default NULL,
  `booksid` varchar(40) default NULL,
  PRIMARY KEY  (`id`),
  KEY `ordersid_FK` (`ordersid`),
  KEY `booksid_FK` (`booksid`),
  CONSTRAINT `booksid_FK` FOREIGN KEY (`booksid`) REFERENCES `books` (`id`),
  CONSTRAINT `ordersid_FK` FOREIGN KEY (`ordersid`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orderitems` */

insert  into `orderitems`(`id`,`quantity`,`price`,`ordersid`,`booksid`) values ('088b339d-e9ce-4680-86cc-3452dff34a15',1,48,'64bd263b-9195-4457-b55f-ee512561d69b','1536c475-e95a-4f20-a0ba-f75a073415d8'),('09e3462a-d523-4058-8dfe-aeade804523e',1,14,'fe10eb86-cce2-4613-a8ec-1d487b2c05f1','a563e59d-6fe8-451b-94fc-a253de8da498'),('0a97508b-a336-49da-8fff-a171c895af84',1,68.3,'56bd8e5c-e9a0-401e-9c43-e371331ff0a3','187fa13f-3c30-4f96-85ee-72949e9ad605'),('16301939-5205-4beb-b5a4-694612d555a8',1,68.3,'fdd2c4cd-5ed9-4942-b195-818a1a7a86a2','187fa13f-3c30-4f96-85ee-72949e9ad605'),('358dcda6-d957-4309-b735-8422272d2418',4,273.2,'59a3652d-83fc-48e8-bc7c-52ca81f9d289','187fa13f-3c30-4f96-85ee-72949e9ad605'),('686e8395-62d6-49e7-b17f-8228c9167ec0',1,48,'624c6829-77c7-4240-8393-2391c3823796','1536c475-e95a-4f20-a0ba-f75a073415d8'),('87647fec-65b6-4971-879d-b40f8f065efc',1,48,'56bd8e5c-e9a0-401e-9c43-e371331ff0a3','1536c475-e95a-4f20-a0ba-f75a073415d8'),('8e037ac3-5b0f-4188-aa82-3a88cc633f3d',1,48,'433673c7-1ad2-47a7-8ffd-16d88f9281d5','1536c475-e95a-4f20-a0ba-f75a073415d8'),('99c75a74-0b02-4be0-9ffc-22bd6fbac679',1,48,'d6514386-d493-41ed-b650-3992e539bfe5','1536c475-e95a-4f20-a0ba-f75a073415d8'),('a8cb44b3-ea24-43b6-8240-77e01b6c7f89',1,48,'629fae53-1204-4d08-9599-4ff8ca29eb62','1536c475-e95a-4f20-a0ba-f75a073415d8'),('afea81ea-feb6-4ea1-b40e-725d954243d4',1,68.3,'629fae53-1204-4d08-9599-4ff8ca29eb62','187fa13f-3c30-4f96-85ee-72949e9ad605'),('b6df64aa-7663-47a7-90b5-f13f0ad641b8',3,204.9,'3be384f4-a939-4969-b843-ab843825d6dd','187fa13f-3c30-4f96-85ee-72949e9ad605'),('c47735a1-80ea-40ea-b28b-e24a0a5124f5',1,68.3,'cf73faad-f11a-419a-8a61-3dbe500663ec','187fa13f-3c30-4f96-85ee-72949e9ad605'),('c4ff4ca8-df61-40ed-a46e-2e49c323432c',5,338,'cdfcb636-2622-4cbf-99f5-8c8b6a58e0d8','25980219-4486-46b3-87e2-ce4b6d557109'),('c52d37e6-1fa8-4c5f-adcb-046e57c511ae',2,96,'fdd2c4cd-5ed9-4942-b195-818a1a7a86a2','1536c475-e95a-4f20-a0ba-f75a073415d8'),('c8847c8b-95a1-419f-bb83-859ec7758dd1',1,48,'59a3652d-83fc-48e8-bc7c-52ca81f9d289','1536c475-e95a-4f20-a0ba-f75a073415d8'),('cba0588f-ccb4-442c-960a-677a86068284',1,48,'3be384f4-a939-4969-b843-ab843825d6dd','1536c475-e95a-4f20-a0ba-f75a073415d8'),('cd29b12a-271a-4d7b-8760-60ed052a1ab0',1,48,'27a6fa73-2ce2-4a9a-8b77-dc24cdd7489c','1536c475-e95a-4f20-a0ba-f75a073415d8'),('d57674f9-e115-4f37-ad4a-92e1e6b86b9c',1,48,'cf73faad-f11a-419a-8a61-3dbe500663ec','1536c475-e95a-4f20-a0ba-f75a073415d8'),('da04f4f4-1f24-4aa7-b194-2adb6ac8dfe0',1,68.3,'433673c7-1ad2-47a7-8ffd-16d88f9281d5','187fa13f-3c30-4f96-85ee-72949e9ad605'),('dab81542-aeee-4b9c-ad34-c2c4d9a66888',1,9.9,'fe10eb86-cce2-4613-a8ec-1d487b2c05f1','e0352593-738b-4984-b964-5c2da5a16a96');

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` varchar(40) NOT NULL,
  `number` varchar(50) default NULL,
  `STATUS` tinyint(1) default '0',
  `price` float default NULL,
  `ordertime` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `usersid` varchar(40) default NULL,
  `addressid` varchar(40) default NULL,
  PRIMARY KEY  (`id`),
  KEY `usersid_FK1` (`usersid`),
  KEY `addressid_FK` (`addressid`),
  CONSTRAINT `addressid_FK` FOREIGN KEY (`addressid`) REFERENCES `address` (`id`),
  CONSTRAINT `usersid_FK1` FOREIGN KEY (`usersid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`id`,`number`,`STATUS`,`price`,`ordertime`,`usersid`,`addressid`) values ('27a6fa73-2ce2-4a9a-8b77-dc24cdd7489c','131208130000003',1,48,'2013-12-08 15:33:15','933098ad-3737-423d-9cd7-733cfc6668e8','d3e27465-8f66-4ea9-bf78-467add0246e7'),('3be384f4-a939-4969-b843-ab843825d6dd','131208090000001',1,252.9,'2013-12-08 16:13:11','933098ad-3737-423d-9cd7-733cfc6668e8','8dff3918-f53c-4fff-8360-6086882d9757'),('433673c7-1ad2-47a7-8ffd-16d88f9281d5','1312022100000004',1,116.3,'2013-12-05 14:27:17','933098ad-3737-423d-9cd7-733cfc6668e8','80d51863-7afa-4b68-a6f3-42d2cd5f2a98'),('56bd8e5c-e9a0-401e-9c43-e371331ff0a3','1312022000000003',1,116.3,'2013-12-08 16:19:42','933098ad-3737-423d-9cd7-733cfc6668e8','80d51863-7afa-4b68-a6f3-42d2cd5f2a98'),('59a3652d-83fc-48e8-bc7c-52ca81f9d289','131208140000006',0,321.2,'2013-12-08 14:47:44','933098ad-3737-423d-9cd7-733cfc6668e8','a06b9576-cf5e-466a-a528-aaab9f3ff61a'),('624c6829-77c7-4240-8393-2391c3823796','131208140000004',0,48,'2013-12-08 14:00:38','933098ad-3737-423d-9cd7-733cfc6668e8','d3e27465-8f66-4ea9-bf78-467add0246e7'),('629fae53-1204-4d08-9599-4ff8ca29eb62','131208140000005',0,116.3,'2013-12-08 14:25:59','933098ad-3737-423d-9cd7-733cfc6668e8','d3e27465-8f66-4ea9-bf78-467add0246e7'),('64bd263b-9195-4457-b55f-ee512561d69b','1312051600000002',0,48,'2013-12-05 16:31:23','933098ad-3737-423d-9cd7-733cfc6668e8','80d51863-7afa-4b68-a6f3-42d2cd5f2a98'),('cdfcb636-2622-4cbf-99f5-8c8b6a58e0d8','1311301600000001',0,338,'2013-11-30 16:50:33','933098ad-3737-423d-9cd7-733cfc6668e8','8dff3918-f53c-4fff-8360-6086882d9757'),('cf73faad-f11a-419a-8a61-3dbe500663ec','1312071500000001',1,116.3,'2013-12-07 15:28:12','933098ad-3737-423d-9cd7-733cfc6668e8','8dff3918-f53c-4fff-8360-6086882d9757'),('d6514386-d493-41ed-b650-3992e539bfe5','1312021400000001',0,48,'2013-12-02 14:11:01','933098ad-3737-423d-9cd7-733cfc6668e8','8dff3918-f53c-4fff-8360-6086882d9757'),('fdd2c4cd-5ed9-4942-b195-818a1a7a86a2','131208110000002',0,164.3,'2013-12-08 11:34:26','a83cdb41-7bc0-48b7-b6be-5d114633929b','ef96c205-2bf2-4829-b560-be08b97b4088'),('fe10eb86-cce2-4613-a8ec-1d487b2c05f1','1312022000000002',0,23.9,'2013-12-02 20:38:04','933098ad-3737-423d-9cd7-733cfc6668e8','8dff3918-f53c-4fff-8360-6086882d9757');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` varchar(40) NOT NULL,
  `username` varchar(20) default NULL,
  `PASSWORD` varchar(30) default NULL,
  `email` varchar(40) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`PASSWORD`,`email`) values ('3f248a38-eba4-429a-85a9-bef4397d1c52','ddddaa','123456',''),('46ad62a6-a311-42c1-9adb-7f61439d488b','dddsssa','123123',''),('46f1d662-eab5-411c-a454-1d13d6b3dc83','ttttaa','123456',''),('473003a7-4384-4063-a1d9-a7de2ced29e5','ttttqq','123456',''),('53b372d0-a102-4b73-8553-56d1bc47a67c','Jack33','123456',''),('5e2171c3-0cad-4b68-a8ec-edb548328114','bbbbbb','123123',''),('6a526316-53e9-4c35-889a-72c72b9e889b','sssddd','123123',''),('84f6a501-f109-42bf-a66b-ffcf296a3e8b','aaaqqq','123123','tt@gmail.com'),('933098ad-3737-423d-9cd7-733cfc6668e8','xfzhang','123456',''),('a83cdb41-7bc0-48b7-b6be-5d114633929b','cccccc','123123',''),('b1cc953d-5d33-44f1-9f62-125a8256cd3c','aaaaaaa','123123',''),('b2a3c7dd-c161-4458-901c-aca93afacce1','aabbcc','123456',''),('d8f71490-7029-46a8-9da8-9a937060585e','Jack22','123456',''),('de86307d-7e64-4138-bef6-1d73755cda7b','sssdddd','123123',''),('e43a4285-3e13-404f-afd8-2cc2bf88c598','aaaaaa','123123',''),('e5a7e84f-6aca-4fb4-b7e6-8238e489de56','dddddd','123123',''),('ee60205d-d9b2-4ec7-a5cd-01758a8f85b4','TomTom8','123123',''),('f794c053-87b3-4c5b-85d9-0e4d1f6548c8','dkdkdkdk','123456','');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
