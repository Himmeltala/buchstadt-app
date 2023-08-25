-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 47.120.15.114    Database: buchstadt
-- ------------------------------------------------------
-- Server version	5.5.62-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `publishers`
--

DROP TABLE IF EXISTS `publishers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publishers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `profile_photo` mediumtext NOT NULL,
  `profile` varchar(100) NOT NULL,
  `desc` float(4,2) DEFAULT '5.00' COMMENT '描述得分',
  `serv` float(4,2) DEFAULT '5.00' COMMENT '服务得分',
  `logistics` float(4,2) DEFAULT '5.00' COMMENT '物流得分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publishers`
--

LOCK TABLES `publishers` WRITE;
/*!40000 ALTER TABLE `publishers` DISABLE KEYS */;
INSERT INTO `publishers` VALUES (1,'商务印书馆','http://img50.ddimg.cn/9002550039867960.jpg','商务印书馆，现代出版的起点',4.80,4.80,4.70),(2,'浙江文艺出版社','https://img30.360buyimg.com/popshop/jfs/t3169/279/117788189/2842/3259f7f/57a58140N84f612e7.jpg','浙江文艺出版社成立于1983年，是浙江省一个以出版文学艺术书籍为主的专业出版社。',5.00,5.00,5.00),(4,'机械工业出版社','http://img63.ddimg.cn/topic_img/gys_04001/newlogojgs17060.jpg','是国内知名出版社',5.00,5.00,5.00),(5,'浙江大学出版社','http://img59.ddimg.cn/226330174266029_y.jpg','中国知名出版社',5.00,5.00,5.00),(6,'中国书籍出版社','http://img52.ddimg.cn/9006940029399332.jpg','书写中国，阅读中国',5.00,5.00,5.00),(7,'人民日报出版社','http://img57.ddimg.cn/9006320028866747.jpg','做治国理政图书 做文化传承图书 做读者枕边图书',5.00,5.00,5.00),(8,'少年儿童出版社','http://img56.ddimg.cn/9001500014725766.jpg','中国第一专业少儿出版社',5.00,5.00,5.00),(9,'北京联合出版公司','https://ts1.cn.mm.bing.net/th?id=OIP.np_30KK9NY9Jxts1TsQBPgAAAA&w=197&h=113&c=7&o=6&pid=3.1','北京出版公司',5.00,5.00,5.00),(10,'北方文艺出版社','https://pic4.zhimg.com/80/v2-013a638d9e38d523a04a4df8b2ec451b_720w.webp','北方文艺出版社',5.00,5.00,5.00),(11,'中译出版社','https://img11.360buyimg.com/cms/jfs/t1/82250/10/18769/4247/6390839bE9e8d695d/3a040abd5f0af3ef.jpg','中译出版社',5.00,5.00,5.00);
/*!40000 ALTER TABLE `publishers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-09 16:13:32
