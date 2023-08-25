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
-- Table structure for table `buch_previews`
--

DROP TABLE IF EXISTS `buch_previews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `buch_previews` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buch_id` int(11) NOT NULL,
  `url` mediumtext,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `book_previews` (`buch_id`) USING BTREE,
  CONSTRAINT `book_previews` FOREIGN KEY (`buch_id`) REFERENCES `buchs` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buch_previews`
--

LOCK TABLES `buch_previews` WRITE;
/*!40000 ALTER TABLE `buch_previews` DISABLE KEYS */;
INSERT INTO `buch_previews` VALUES (1,1,'http://img3m7.ddimg.cn/1/4/29176687-1_u_23.jpg'),(2,1,'http://img3m7.ddimg.cn/1/4/29176687-2_u_17.jpg'),(3,1,'http://img3m7.ddimg.cn/1/4/29176687-4_u_11.jpg'),(6,2,'http://img3m3.ddimg.cn/95/6/29193413-1_u_12.jpg'),(7,2,'http://img3m3.ddimg.cn/95/6/29193413-2_u_5.jpg'),(8,2,'http://img3m3.ddimg.cn/95/6/29193413-3_u_3.jpg'),(9,2,'http://img3m3.ddimg.cn/95/6/29193413-4_u_3.jpg'),(10,11,'http://img3m6.ddimg.cn/54/4/25347816-1_u_4.jpg'),(11,12,'http://img3m6.ddimg.cn/36/1/25282656-4_u_4.jpg'),(17,17,'https://img3m7.ddimg.cn/14/14/27915737-2_u_10.jpg'),(18,18,'https://img3m8.ddimg.cn/68/30/29483258-4_u_5.jpg'),(19,19,'https://img3m1.ddimg.cn/5/21/29557841-2_u_2.jpg'),(20,20,'https://img3m2.ddimg.cn/15/24/29555772-3_u_4.jpg'),(21,21,'https://img3m3.ddimg.cn/57/9/29304453-3_u_8.jpg'),(22,22,'https://img3m5.ddimg.cn/96/35/29549715-3_u_3.jpg'),(23,23,'https://img3m3.ddimg.cn/18/27/29504493-4_u_1.jpg'),(24,24,'https://img3m8.ddimg.cn/81/0/29492478-4_u_2.jpg'),(25,25,'https://img3m0.ddimg.cn/38/15/29520650-1_w_1.jpg'),(26,26,'https://img3m3.ddimg.cn/50/22/29379983-1_w_3.jpg'),(27,27,'https://img3m8.ddimg.cn/57/5/29453448-1_w_5.jpg'),(28,28,'https://img3m6.ddimg.cn/95/20/29362406-1_w_9.jpg'),(29,29,'https://img3m3.ddimg.cn/64/33/25089733-1_w_8.jpg'),(30,30,'https://img3m3.ddimg.cn/36/5/28994463-1_w_4.jpg'),(31,31,'http://img3m1.ddimg.cn/17/23/29173931-3_x_14.jpg'),(32,31,'http://img3m1.ddimg.cn/17/23/29173931-4_x_12.jpg'),(33,32,'https://img3m5.ddimg.cn/28/20/28536085-1_w_18.jpg'),(34,33,'http://img3m4.ddimg.cn/21/25/29323524-2_x_24.jpg'),(35,33,'http://img3m4.ddimg.cn/21/25/29323524-3_x_24.jpg'),(36,33,'http://img3m4.ddimg.cn/21/25/29323524-5_x_24.jpg'),(37,34,'https://img3m6.ddimg.cn/65/31/26484446-1_w_4.jpg'),(38,35,'https://img3m1.ddimg.cn/28/33/29474011-1_w_4.jpg'),(39,36,'http://img3m5.ddimg.cn/1/17/29543185-1_x_1.jpg'),(40,37,'https://img3m8.ddimg.cn/72/16/29126268-1_w_3.jpg'),(41,38,'https://img3m6.ddimg.cn/22/8/29570926-1_w_2.jpg'),(42,39,'https://img3m5.ddimg.cn/46/26/29565505-1_w_2.jpg'),(43,40,'http://img3m6.ddimg.cn/79/1/29577616-1_x_1.jpg'),(44,40,'http://img3m6.ddimg.cn/79/1/29577616-2_x_1.jpg'),(45,41,'https://img3m3.ddimg.cn/93/22/29572383-1_w_3.jpg'),(46,42,''),(47,43,'https://img3m4.ddimg.cn/40/28/29578864-1_w_6.jpg'),(48,44,'http://img53.ddimg.cn/99999990362946693.jpg'),(49,44,'http://img53.ddimg.cn/99999990362946693.jpg'),(50,45,'https://img3m1.ddimg.cn/58/7/29288911-1_w_14.jpg'),(51,46,'http://img3m4.ddimg.cn/21/16/27932574-2_x_35.jpg'),(52,46,'http://img3m4.ddimg.cn/21/16/27932574-4_x_33.jpg'),(53,47,'https://img3m3.ddimg.cn/9/30/29416473-1_w_10.jpg'),(54,48,'http://img3m6.ddimg.cn/34/24/29498866-1_x_10.jpg'),(55,48,'http://img3m6.ddimg.cn/34/24/29498866-2_x_10.jpg'),(56,48,'http://img3m6.ddimg.cn/34/24/29498866-3_x_4.jpg'),(57,49,'http://img3m4.ddimg.cn/85/24/23725534-3_u_6.jpg'),(58,49,'http://img3m4.ddimg.cn/85/24/23725534-4_u_6.jpg'),(59,50,'http://img3m5.ddimg.cn/31/16/23486395-1_u_30.jpg'),(60,50,'http://img3m5.ddimg.cn/31/16/23486395-4_u_9.jpg'),(61,50,'http://img3m5.ddimg.cn/31/16/23486395-4_u_9.jpg'),(62,51,'http://img3m3.ddimg.cn/43/25/478213-1_u_1.jpg'),(63,52,'http://img3m2.ddimg.cn/46/15/29188612-1_u_2.jpg'),(64,53,'http://img55.ddimg.cn/99999990464273555.jpg'),(65,53,'http://img55.ddimg.cn/99999990464273555.jpg'),(66,54,'http://img3m7.ddimg.cn/48/0/24106647-1_u_21.jpg'),(67,54,'http://img3m7.ddimg.cn/48/0/24106647-4_u_7.jpg'),(68,55,'http://img3m5.ddimg.cn/42/7/29242365-2_u_1.jpg'),(69,55,'http://img3m5.ddimg.cn/42/7/29242365-3_u_1.jpg'),(70,56,'http://img3m0.ddimg.cn/95/16/29339240-1_u_7.jpg'),(71,56,'http://img3m0.ddimg.cn/95/16/29339240-3_u_6.jpg'),(72,57,'http://img3m4.ddimg.cn/55/13/29258614-1_u_21.jpg'),(73,57,''),(74,58,'http://img3m5.ddimg.cn/61/1/20744125-1_u_2.jpg'),(75,58,'http://img35.ddimg.cn/imgother1/61/1/20744125_310078.jpg'),(76,59,'http://img3m5.ddimg.cn/77/16/29304275-1_u_4.jpg'),(77,59,'http://img3m5.ddimg.cn/77/16/29304275-2_u_1.jpg'),(78,59,'http://img3m5.ddimg.cn/77/16/29304275-4_u_1.jpg'),(79,60,'http://img3m9.ddimg.cn/75/10/25083309-1_u_3.jpg'),(80,61,'http://img3m5.ddimg.cn/29/6/25337495-1_u_3.jpg'),(81,61,'http://img3m5.ddimg.cn/29/6/25337495-2_u_2.jpg'),(82,61,'http://img3m5.ddimg.cn/29/6/25337495-3_u_3.jpg'),(83,62,'http://img3m5.ddimg.cn/66/12/29504145-1_u_1.jpg'),(84,63,''),(85,64,'http://img56.ddimg.cn/99999990003689416.jpg'),(86,65,'http://img3m9.ddimg.cn/36/32/27899919-1_u_3.jpg'),(87,65,'http://img3m9.ddimg.cn/36/32/27899919-2_u_3.jpg'),(88,65,'http://img3m9.ddimg.cn/36/32/27899919-5_u_3.jpg'),(89,66,'http://img3m8.ddimg.cn/71/21/28516328-1_u_27.jpg'),(90,66,'http://img3m8.ddimg.cn/71/21/28516328-3_u_23.jpg'),(91,66,'http://img3m8.ddimg.cn/71/21/28516328-4_u_28.jpg'),(92,67,'http://img3m5.ddimg.cn/33/14/24225135-1_u_4.jpg'),(93,67,''),(94,68,'http://img3m0.ddimg.cn/88/25/29435560-1_u_4.jpg'),(95,68,'http://img3m0.ddimg.cn/88/25/29435560-2_u_4.jpg'),(96,68,'http://img56.ddimg.cn/99999990429363636.jpg'),(97,69,'http://img3m9.ddimg.cn/57/15/24170709-1_u_8.jpg'),(98,70,'http://img3m8.ddimg.cn/52/17/25289998-1_u_2.jpg'),(99,70,'http://img3m8.ddimg.cn/52/17/25289998-2_u_2.jpg'),(100,70,'http://img3m8.ddimg.cn/52/17/25289998-3_u_2.jpg'),(101,71,'http://img3m2.ddimg.cn/95/29/23910872-4_u_8.jpg'),(102,71,'http://img3m2.ddimg.cn/95/29/23910872-3_u_9.jpg'),(103,71,'http://img3m2.ddimg.cn/95/29/23910872-5_u_8.jpg'),(104,73,'http://img3m1.ddimg.cn/84/16/23902941-1_u_2.jpg'),(105,73,'http://img3m1.ddimg.cn/84/16/23902941-2_u_5.jpg');
/*!40000 ALTER TABLE `buch_previews` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-09 16:13:45
