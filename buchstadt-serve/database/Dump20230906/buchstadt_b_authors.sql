-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: buchstadt
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `b_authors`
--

DROP TABLE IF EXISTS `b_authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `b_authors` (
  `id` int NOT NULL AUTO_INCREMENT,
  `buch_id` int NOT NULL,
  `author` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `book_authors` (`buch_id`) USING BTREE,
  CONSTRAINT `book_authors` FOREIGN KEY (`buch_id`) REFERENCES `buchs` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `b_authors`
--

LOCK TABLES `b_authors` WRITE;
/*!40000 ALTER TABLE `b_authors` DISABLE KEYS */;
INSERT INTO `b_authors` VALUES (1,1,'谢默斯·希尼'),(3,2,'拱玉书'),(6,11,'甘开全'),(7,12,'科恩'),(11,17,'张大可'),(13,19,'施一公'),(14,20,'李海峰，王成'),(15,21,'比留间荣子'),(16,22,'数字化转型模式与创新：从数字化企业到产业互联网平台'),(17,23,'尼恩、陈健、徐明冠、岳阳博'),(18,24,'斯蒂芬·詹森'),(19,25,'倪红军'),(20,26,'教育部考试中心'),(21,27,'全国二级建造师执业资格考试用书编写委员会'),(22,28,'财政部会计资格评价中心'),(23,29,'张淑男 等'),(24,30,'国家新闻出版署出版专业资格考试办公室'),(25,31,'易莉'),(26,32,'王贵强、王立祥、张文宏'),(27,33,'罗翔'),(28,34,'李时珍 著，凤凰联动 出品'),(29,35,'马克·P.马特森'),(30,36,'胡可先'),(31,37,'珞宁'),(32,38,'夏洛特·吉兰/著 山姆·亚瑟/绘'),(33,39,'介于 绘 叁川上 编著 凤凰含章出品'),(34,40,'郝玉'),(35,41,'厉河'),(36,42,'人民日报理论部'),(37,43,'稻盛和夫'),(38,44,'赵序茅'),(39,45,'王志纲'),(40,46,'汪曾祺'),(41,47,'李长栓'),(42,48,'梁实秋'),(43,49,'铃木俊隆'),(44,50,'川边城'),(45,51,'德雷尔'),(46,52,'温宗俊'),(47,53,'德拉图尔'),(48,54,'兰德尔'),(49,55,'石泽久雄'),(50,56,'米莱'),(51,57,'谢希仁'),(52,58,'星云大师'),(53,59,'稻盛和夫'),(54,60,'李莉'),(55,61,'徐勇'),(56,62,'马克思韦伯'),(57,63,'亨利 列斐伏尔'),(58,64,'文思源'),(59,65,'阿兰德波顿'),(60,66,'意公子'),(61,67,'维尔贡培兹'),(62,68,'丹纳'),(63,69,'迪士尼'),(64,70,'威廉莎士比亚'),(65,71,'迪士尼'),(66,73,'夏洛蒂勃朗特'),(67,75,'七堇年'),(70,76,'雷东军'),(71,77,'张执浩');
/*!40000 ALTER TABLE `b_authors` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-06 11:38:08
