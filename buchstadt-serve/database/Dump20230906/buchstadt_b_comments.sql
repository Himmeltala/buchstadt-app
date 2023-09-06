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
-- Table structure for table `b_comments`
--

DROP TABLE IF EXISTS `b_comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `b_comments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `buch_id` int NOT NULL,
  `user_id` int NOT NULL,
  `content` text,
  `digg` int DEFAULT '0',
  `bury` int DEFAULT '0',
  `type` varchar(10) NOT NULL DEFAULT '好评',
  `post_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `book_comment` (`buch_id`) USING BTREE,
  KEY `user_comment` (`user_id`) USING BTREE,
  CONSTRAINT `book_comment` FOREIGN KEY (`buch_id`) REFERENCES `buchs` (`id`),
  CONSTRAINT `user_comment` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `b_comments`
--

LOCK TABLES `b_comments` WRITE;
/*!40000 ALTER TABLE `b_comments` DISABLE KEYS */;
INSERT INTO `b_comments` VALUES (47,1,24,'这本书真是一次精彩的冒险！故事情节扣人心弦，角色深入人心，绝对值得一读。',1,1,'好评','2023-09-05 09:09:00'),(48,1,25,'作者的文字魔法令人叹为观止。他的描述如此生动，把我带入了故事的世界。',0,0,'好评','2023-09-05 09:10:53'),(49,1,26,'这本书是一部改变我生活的力作。它不仅娱乐性十足，还让我思考了很多深刻的问题。',0,0,'好评','2023-09-05 09:12:08'),(50,1,27,'读完这本书后，我感到心情愉悦。它的幽默和温情令人陶醉。',0,0,'好评','2023-09-05 09:12:31'),(51,2,28,'这本书真是令人失望。故事情节毫无新意，角色扁平无趣，我甚至无法坚持看到最后。',0,0,'差评','2023-09-05 09:13:30'),(52,1,25,'这本书的编辑工作显然不够仔细，充满了拼写和语法错误。这些错误让我感到非常不舒服。',0,0,'差评','2023-09-05 09:14:23'),(53,2,24,'封面和宣传广告让我对这本书寄予了很高的期望，但实际阅读过程中我觉得自己被忽悠了。',0,0,'差评','2023-09-05 09:15:08');
/*!40000 ALTER TABLE `b_comments` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-06 11:38:10
