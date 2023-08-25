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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `profile_photo` mediumtext,
  `level` int(11) DEFAULT '1',
  `email` varchar(100) DEFAULT '',
  `phone` varchar(11) DEFAULT '',
  `profile` varchar(50) DEFAULT '',
  `sex` varchar(4) DEFAULT '未知',
  `register_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'himmelbleu','123456','https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F202006%2F30%2F20200630165226_s3X82.thumb.1000_0.jpeg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1688005823&t=2953d79278ac6ea117f82338365ca27e',3,'himmelbleu@outlook.com','09876543211','Time tick away,dream faded away.','男','2023-05-29 17:40:28'),(2,'汪梓浩','123456','https://img0.baidu.com/it/u=2322283728,1741375128&fm=253&fmt=auto&app=138&f=JPEG?w=504&h=500',1,'','12345678901','','男','2023-05-31 15:44:27'),(10,'孙永坤','123456','https://pic4.zhimg.com/v2-d81f45bcbda578ba89e3ebcfa90baa87_r.jpg',1,'','','','男','2023-06-07 18:17:26'),(11,'杨皓然','123456','https://pic4.zhimg.com/v2-09dffd88d349fd41408f5753a897ad13_r.jpg',1,'','','','男','2023-06-07 18:18:21'),(12,'王鹏霏','123456','https://pic3.zhimg.com/v2-96100437959cce14ab0aaeb60b54edf6_r.jpg',1,'','','','男','2023-06-07 18:18:32'),(13,'高樊宇阳','123456','https://ts1.cn.mm.bing.net/th/id/R-C.459cf93218aee7a1bd2fca8c5fd0cc98?rik=pUNK6SsiYLzvrA&riu=http%3a%2f%2fwww.gx8899.com%2fuploads%2fallimg%2f2017112908%2fc2tocoecn0b.jpg&ehk=0LymMMFUHiJIisrw3vKnJw53e5qjdVvuiXeyiJnNlj8%3d&risl=&pid=ImgRaw&r=0',1,'','','','男','2023-06-07 18:18:55');
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

-- Dump completed on 2023-06-09 16:13:34
