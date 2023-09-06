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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `profile_photo` mediumtext,
  `level` int DEFAULT '1',
  `email` varchar(100) DEFAULT '',
  `phone` varchar(11) DEFAULT '',
  `profile` varchar(50) DEFAULT '',
  `sex` varchar(4) DEFAULT '未知',
  `register_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'himmelbleu','12345678','https://img2.baidu.com/it/u=3405892366,4055148693&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=531',6,'himmelbleu@outlook.com','18508153489','Time tick away,dream faded away.','男','2023-09-05 06:59:50'),(24,'Lonely','12345678','https://img0.baidu.com/it/u=4144323567,1745898593&fm=253&fmt=auto&app=138&f=JPEG?w=515&h=500',3,'','15323770099','','男','2023-09-05 08:48:22'),(25,'glorious','12345678','https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fsafe-img.xhscdn.com%2Fbw1%2F3a2ac0b3-f176-40a7-9a42-3b8d078519a5%3FimageView2%2F2%2Fw%2F1080%2Fformat%2Fjpg&refer=http%3A%2F%2Fsafe-img.xhscdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1696495672&t=4c1f7870c69d5f9fecd993a6e73b256e',3,'','18300001433','','男','2023-09-05 08:49:18'),(26,'Soulmate','12345678','https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fsafe-img.xhscdn.com%2Fbw1%2Fd8df29a8-efa1-4974-aaca-056a066dfdd6%3FimageView2%2F2%2Fw%2F1080%2Fformat%2Fjpg&refer=http%3A%2F%2Fsafe-img.xhscdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1696495672&t=7e8776f85a5dbec70dce05fda641ce63',3,'','18237466333','','男','2023-09-05 08:49:53'),(27,'Shine','12345678','https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fsafe-img.xhscdn.com%2Fbw1%2Fbbd81b13-35a2-46d6-9410-21e8f90ea4b3%3FimageView2%2F2%2Fw%2F1080%2Fformat%2Fjpg&refer=http%3A%2F%2Fsafe-img.xhscdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1696495672&t=00404b4e41881dd9e3b165529df1b134',1,'','17398333777','','女','2023-09-05 08:50:29'),(28,'Finish','12345678','https://img1.baidu.com/it/u=1271713505,867476965&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500',1,'','15844444527','','未知','2023-09-05 08:51:29'),(29,'Pretext','12345678','https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F202005%2F19%2F20200519193421_jzG2m.thumb.1000_0.jpeg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1696495874&t=2b1664b1c46f7ddfb743e129b05de5a6',1,'','13381080123','','未知','2023-09-05 08:52:30'),(30,'Delete','12345678','https://img2.baidu.com/it/u=2948679933,1856351064&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500',1,'','13370110123','','未知','2023-09-05 08:53:06'),(31,'CuteBaby','12345678','https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F202006%2F22%2F2020062291850_4uQfN.thumb.1000_0.jpeg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1696495972&t=91a3ec5aa373b86a8f9a2e5f20816c60',1,'','18689025678','','女','2023-09-05 08:53:47'),(32,'蒙德骑士优菈','12345678','https://img2.baidu.com/it/u=698774113,4021459836&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=507',1,'','17136369696','','女','2023-09-05 08:54:22'),(33,'稻妻雷神巴尔','12345678','https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fsafe-img.xhscdn.com%2Fbw1%2Fc161ee09-d403-4865-872e-9609467d0955%3FimageView2%2F2%2Fw%2F1080%2Fformat%2Fjpg&refer=http%3A%2F%2Fsafe-img.xhscdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1696496057&t=0f3a1f11ffb746846a35ad8fc746a3fd',6,'','13807486878','','女','2023-09-05 08:56:03'),(34,'璃月岩神钟离','12345678','https://img0.baidu.com/it/u=2667082695,327840119&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500',6,'','19937759999','','男','2023-09-05 08:57:35'),(35,'不干正事巴巴托斯','12345678','https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fsafe-img.xhscdn.com%2Fbw1%2F461170bf-9a5b-401f-bf39-ff299f834540%3FimageView2%2F2%2Fw%2F1080%2Fformat%2Fjpg&refer=http%3A%2F%2Fsafe-img.xhscdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1696496279&t=e8d9eb190e63bca815c2845c81a658db',1,'','18502162345','','男','2023-09-05 08:58:09'),(36,'须弥草神纳西妲','12345678','https://img1.baidu.com/it/u=2537290333,972939025&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500',6,'','15655511991','','女','2023-09-05 08:58:46');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
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
