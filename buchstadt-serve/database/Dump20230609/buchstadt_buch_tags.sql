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
-- Table structure for table `buch_tags`
--

DROP TABLE IF EXISTS `buch_tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `buch_tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buch_id` int(11) NOT NULL,
  `tag` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `book_tags` (`buch_id`) USING BTREE,
  CONSTRAINT `book_tags` FOREIGN KEY (`buch_id`) REFERENCES `buchs` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buch_tags`
--

LOCK TABLES `buch_tags` WRITE;
/*!40000 ALTER TABLE `buch_tags` DISABLE KEYS */;
INSERT INTO `buch_tags` VALUES (17,11,'300减40'),(18,12,'99减10'),(20,2,'满100减10'),(21,2,'满200减20'),(24,1,'满100减10'),(27,17,'满100-10'),(28,18,'满100-50'),(29,19,'满100-10'),(30,20,'满100-10'),(31,21,'满100-10'),(32,22,'满100-10'),(33,23,'满100-10'),(34,24,'满300-30'),(35,25,'满100-20'),(36,26,'满100-10'),(37,27,'100-10'),(38,28,'100-10'),(39,29,'100-10'),(40,30,'100-10'),(41,31,''),(42,32,'100-10'),(43,33,''),(44,34,'100-10'),(45,35,'100-10'),(46,36,''),(47,37,'100-10'),(48,38,'300-20'),(49,39,'100-10'),(50,40,''),(51,41,'100-10'),(52,42,''),(53,43,'100-10'),(54,44,''),(55,45,'100-10'),(56,46,''),(57,47,'300-50'),(58,48,''),(59,49,''),(60,50,''),(61,51,''),(62,52,''),(63,53,''),(64,54,''),(65,55,''),(66,56,''),(67,57,'http://img3m4.ddimg.cn/55/13/29258614-3_u_12.jpg'),(68,57,''),(69,58,''),(70,59,''),(71,60,''),(72,61,''),(73,62,''),(74,63,''),(75,64,''),(76,65,''),(77,66,''),(78,67,''),(79,68,''),(80,69,''),(81,70,''),(82,71,''),(83,73,'');
/*!40000 ALTER TABLE `buch_tags` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-09 16:13:28
