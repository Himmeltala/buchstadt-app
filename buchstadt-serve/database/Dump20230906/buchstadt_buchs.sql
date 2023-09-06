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
-- Table structure for table `buchs`
--

DROP TABLE IF EXISTS `buchs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `buchs` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `profile` text,
  `price` float(8,2) DEFAULT '0.00',
  `discount` float(4,2) DEFAULT '1.00',
  `cover` text,
  `pub_id` int DEFAULT NULL,
  `is_prime` tinyint(1) DEFAULT '0' COMMENT '0false,1true',
  `post_date` date DEFAULT NULL COMMENT '出版时间',
  `type` varchar(50) NOT NULL COMMENT '书籍类型',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `book_publisher` (`pub_id`) USING BTREE,
  CONSTRAINT `book_publisher` FOREIGN KEY (`pub_id`) REFERENCES `pubs` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buchs`
--

LOCK TABLES `buchs` WRITE;
/*!40000 ALTER TABLE `buchs` DISABLE KEYS */;
INSERT INTO `buchs` VALUES (1,'吉尔伽美什史诗','人类历史上最早的史诗，一位富有传奇色彩的古代君王，书中包含了爱情、友谊、冒险、危险和悲情,以及一个骄傲的人在死亡面前的谦逊。',96.00,0.75,'http://img3m7.ddimg.cn/1/4/29176687-1_u_23.jpg',1,1,'2021-01-01','literature'),(2,'希尼三十年文选','黄灿然全新修订译文 诺贝尔文学奖得主，自叶芝以来爱尔兰蕞重要诗人 谢默斯·希尼亲自编选毕生文学精华，现当代诗学集大成之作 “像花了很多光年从远方而来，又要花很多光年才能抵达的星光”',95.00,0.45,'http://img3m3.ddimg.cn/95/6/29193413-1_u_12.jpg',2,1,'2021-01-01','literature'),(11,'儿童时间管理全书','为0-12岁儿童量身打造。对时间的掌控能力决定了孩子的未来，8大方面系统建立孩子的自我时间管理力，37个具体技巧让父母烦恼的儿童日常拖延问题一扫光。聪明的父母早知道早帮助孩子从中受益。',42.00,0.67,'http://img3m6.ddimg.cn/54/4/25347816-1_u_4.jpg',1,0,'2018-08-01','living'),(12,'游戏力：笑声，激活孩子天性中的合作与勇气','美国国家亲子出版奖金奖。',52.00,0.95,'http://img3m6.ddimg.cn/36/1/25282656-4_u_4.jpg',1,0,'2018-07-01','children'),(17,'史记','荣获商务印书馆2019人文社科十大好书，张大可先生《史记》研究的集成之作，精细考证，廓清原书真伪；题解语译，展现著者史观，是一部人人都能读懂、人人都会爱读的文白对照本《史记》。',143.00,0.40,'https://img3m7.ddimg.cn/14/14/27915737-1_w_9.jpg',1,0,'2021-02-16','literature'),(19,'自我突围',' 西湖大学校长、中国科学院院士施一公作品 * 韩启德 杨振宁 钱颖一 潘建伟 刘彭芝 白岩松 张磊 鼎力推荐',49.00,0.70,'https://img3m1.ddimg.cn/5/21/29557841-1_w_2.jpg',1,0,'2016-06-16','motivation'),(20,'设计人生','源自斯坦福大学好评如潮的《设计人生》课程，利用设计思维理论和工具，29位设计人生教练带你小步试错，快步迭代，找到自己的人生方向，创造美好的未来。',23.00,0.50,'https://img3m2.ddimg.cn/15/24/29555772-1_u_5.jpg',1,0,'2019-06-18','motivation'),(21,'时间是良药','当你厌倦了生活，想要躺下；当你身处焦虑时代，和身边人一样疯狂内卷；当你觉得工作遭遇瓶颈，难有起色；当你被人际关系所累，劳心伤神，就看这本书！',23.00,0.50,'https://img3m3.ddimg.cn/57/9/29304453-1_w_9.jpg',1,0,'2021-06-12','motivation'),(22,'数字化转型模式与创新：从数字化企业到产业互联网平台','数字化资深专家撰写，指导企业从0到1构建数字化企业，从1到10构建产业数字化平台，成为产业链领导者',74.00,0.70,'https://img3m5.ddimg.cn/96/35/29549715-1_w_4.jpg',1,0,'2019-02-14','technology'),(23,'Java高并发核心编程','深入浅出地讲解Java高并发应用开发核心技术',86.00,0.50,'https://img3m3.ddimg.cn/18/27/29504493-1_w_1.jpg',1,0,'2021-06-23','technology'),(24,'机器学习在算法交易中的应用','机器学习和金融投资图书作品，综合阐述机器学习算法在投资和交易领域中的实践应用。通过本书，读者可了解各种实用的机器学习算法，构建自己的预测模型，设计并评估自己的交易策略，更好地为投资和交易服务',89.00,0.50,'https://img3m8.ddimg.cn/81/0/29492478-1_w_3.jpg',2,0,'2020-01-13','technology'),(25,'鸿蒙应用开发零基础入门','基于的ArkUI JS开发框架和HarmonyOS 3.0应用开发技术，讲解了HarmonyOS应用开发从入门到精通的基础知识和关键技术。',69.00,0.50,'https://img3m0.ddimg.cn/38/15/29520650-1_w_1.jpg',1,0,'2022-07-23','technology'),(26,'全国计算机等级考试二级教程','团购电话:4001066666转6，100册以上更优惠',37.00,0.50,'https://img3m3.ddimg.cn/50/22/29379983-1_w_3.jpg',2,0,'2022-07-28','examine'),(27,'建设工程法规及相关知识 ','团购100册以上更优惠，电话:4001066666转6',50.00,0.50,'https://img3m8.ddimg.cn/57/5/29453448-1_w_5.jpg',2,0,'2023-02-15','examine'),(28,'中级会计教材2022','团购100册以上更优惠，电话:4001066666转6',70.00,0.50,'https://img3m6.ddimg.cn/95/20/29362406-1_w_9.jpg',2,0,'2023-06-05','examine'),(29,'国际汉语教师证书','团购100册以上更优惠，电话:4001066666转6',122.00,0.50,'https://img3m3.ddimg.cn/64/33/25089733-1_w_8.jpg',2,0,'2023-01-17','examine'),(30,'出版专业职业资格考试教材','出版专业从业人员教材',56.00,0.60,'https://img3m3.ddimg.cn/36/5/28994463-1_w_4.jpg',1,0,'2022-11-10','examine'),(31,'学术写作原来是这样','《中国研究生》杂志“学术写作”主题书单收录，国内57所优质院校联合推荐！中国人英文学术写作中有哪些误区？如何提升学术写作的效率？北京大学心理与认知科学学院博导易莉多年英文论文写作课程精华',70.85,0.95,'http://img3m1.ddimg.cn/17/23/29173931-1_x_15.jpg',4,0,'2019-06-12','academic'),(32,'活出健康——免疫力就是好医生','身处同样环境，有的人被病毒感染，有的人却安然无恙。身患同样疾病，有的人命悬一线，有的人却逐渐恢复，原因何在?免疫力决定健康，免疫力关乎生死。2020年度中国好书，第七届“中国科普作家协会优秀科普作品奖',66.00,0.50,'https://img3m5.ddimg.cn/28/20/28536085-1_w_18.jpg',1,0,'2021-02-05','encyclopedia'),(33,'法治的细节','罗翔解读热点案件，思辨法治要义，破解道德困境，从N号房事件到张玉环案，我们如何在现实中追求正义，在时事中保持理性思考。果麦出品',39.99,0.90,'http://img3m4.ddimg.cn/21/25/29323524-1_x_23.jpg',4,0,'2019-06-04','academic'),(34,'本草纲目：白话手绘彩图典藏本','影响中国人400年日常生活，中国药物学的著作！白话文译本，900张全彩手绘插图，一物一图， 700多页内文！内附7000多条生活附方，涵盖吃穿住行，适宜男女老少，是居家常用的生活用书。',98.00,0.50,'https://img3m6.ddimg.cn/65/31/26484446-1_w_4.jpg',1,0,'2023-01-04','encyclopedia'),(35,'间歇性禁食：优化健康和延缓衰老的科学','间歇性禁食——火爆全球的健康革命，专家全面阐述间歇性禁食对身体健康、疾病和衰老的影响机制。',58.00,0.50,'https://img3m1.ddimg.cn/28/33/29474011-1_w_4.jpg',2,0,'2022-11-17','encyclopedia'),(36,'学术访谈录','2020年是浙江大学中文系建系一百周年。目前的浙江大学中文学科，语言、文学与文献并驾齐驱，形成以文献史料为基础，将文学与语言、传统与现代、文献与文物、文学与影像、编纂与研究融为一体的研究格局，古今汇通，中西兼融，是浙江大学人文社会科学学科中既有悠久的历史底蕴又有强烈的现代气息的学科。作为浙大中文学科百年传承的历史，作者特别征集了20位学者的24篇访谈录。这些访谈，从学术研究的传承、学术道路的艰辛、学术研究的追求、教书育人的天职等方面，不仅突出表现了受访者的学术贡献，而且通过访谈得到学术成果之外的很多启示，包括受访者的学术背景、学术经历、学术理念、学术个性、治学方法等，同时能够提供教书育人的指引和因材施教的策略。这本访谈录在浙大中文学科的百年发展中体现出一定的学术史和教育史意义。',49.00,0.90,'http://img3m5.ddimg.cn/1/17/29543185-1_x_1.jpg',5,0,'2017-02-08','academic'),(37,'瘦身，重启人生','身体和心灵的自我重塑之书。 情绪管理+饮食调节+基本原理=可复制的减脂行动力',59.00,0.50,'https://img3m8.ddimg.cn/72/16/29126268-1_w_3.jpg',5,0,'2022-09-15','encyclopedia'),(38,'橡树见证的1000年.大奖科普绘本系列','回溯千年，塑造孩子大视野大格局；听万物，讲述自己的故事。穿越森林与大海，遇见自然奇观，见证乡村与城市的变迁、非洲草原大迁徙、亚马孙森林的毁灭与新生。特级教师推荐，牛津图书奖绘本（海豚传媒出品）',89.00,0.40,'https://img3m6.ddimg.cn/22/8/29570926-1_w_2.jpg',1,0,'2023-02-09','children'),(39,'给孩子看的趣味地理 全3册 ','儿童地理启蒙读物； 10大知识体系，搭建地理大框架，系统了解地理知识； 2000+开放式构图，更加吸引孩子的阅读兴趣； 为孩子打下地理科学基础',77.00,0.50,'https://img3m5.ddimg.cn/46/26/29565505-1_w_2.jpg',2,0,'2021-02-19','children'),(40,'高校学术研究论著丛刊','本书主要基于新视角而系统研究群众文化的建设与管理，首先阐述群众文化的基础知识、类型划分，其次对群众文化活动的组织、管理及辅导进行分析，后在公共文化服务体系、民俗学、新媒体等不同视角下研究群众文化建设。本书结构清晰，内容丰富新颖，历史性与时代性有机结合，对促进新时期我国群众文化的科学建设、繁荣发展以及推动中国特色社会主义精神文明建设、提高人民群众的精神文化生活水平具有重要意义，是一本值得学习研究的著作。\n\n',58.60,0.80,'http://img3m6.ddimg.cn/79/1/29577616-1_x_1.jpg',6,0,'2017-06-14','academic'),(41,'大侦探福尔摩斯·M博士外传','《大侦探福尔摩斯》系列是一套专属于小学生的福尔摩斯探案集，销量超过1400万册，常年位居各大平台儿童文学畅销榜（心喜阅童书出品）',49.00,0.50,'https://img3m3.ddimg.cn/93/22/29572383-1_w_3.jpg',1,0,'2023-03-08','literature'),(42,'学术圆桌','　加快构建中国特色哲学社会科学，归根结底是建构中国自主的知识体系。要以中国为观照、以时代为观照，立足中国实际，解决中国问题，不断推动中华优秀传统文化创造性转化、创新性发展，不断推进知识创新、理论创新、方法创新，使中国特色哲学社会科学真正屹立于世界学术之林。\n\n　　“学术圆桌”是人民日报学术版重点栏目，汇集全国哲学社会科学领域专家学者，针对某一热点话题展开深入探讨。\n\n　　《学术圆桌：人民日报学术版专题文章精选》汇集该栏目刊发的文章，围绕中国式现代化、中华优秀传统文化、中华文明起源、文物和文化遗产、马克思主义中国化时代化等哲学社会科学领域的热点话题，深入阐述如何发挥哲学社会科学在融通中外文化、增进文明交流中的独特作用，彰显中国之路、中国之治、中国之理，传播中国声音、中国理论、中国思想，有助于广大读者理解中国特色哲学社会科学学科体系、学术体系、话语体系建设，是一部思想性、指导性、可读性俱佳的著作。\n\n',43.50,0.85,'http://img3m8.ddimg.cn/16/20/29554288-1_x_1.jpg',7,0,'2023-06-01','academic'),(43,'财之道丛书·经营十二条','中文版首次出版！全面、完整、系统、准确的“经营十二条”读本！曹岫云、曹寓刚翻译，知名设计师刘晓翔担纲创意设计！附赠稻盛演讲视频，京瓷特别授权！',80.00,0.50,'https://img3m4.ddimg.cn/40/28/29578864-1_w_6.jpg',6,0,'2022-12-15','business'),(44,'中国少儿百科知识全书','中国少儿百科知识全书',34.30,0.90,'http://img3m8.ddimg.cn/68/20/29333768-1_x_4.jpg',8,0,'2017-05-31','children'),(45,'王志纲论战略:关键阶段的重大抉择','中国本土战略策划的开创者和领军人物王志纲近30年策划咨询工作总结',136.00,0.50,'https://img3m1.ddimg.cn/58/7/29288911-1_w_14.jpg',7,0,'2023-02-27','business'),(46,'慢煮生活','《慢煮生活》汪曾祺散文精选集——畅销经典之作，30万册畅销纪念版,汪曾祺写给大家的“生活观”！\n畅销多年，经典珍藏。是迄今为止全面、经典、值得珍藏的汪曾祺作品。既收录作者经久流传的经典文章，更囊括中高考阅读及作文试题。',18.10,0.95,'http://img3m4.ddimg.cn/21/16/27932574-1_x_34.jpg',9,0,'2014-06-03','living'),(47,'非文学翻译理论与实践：理解、表达、变通（上下册）','豆瓣评分8.6，位列热门翻译理论图书TOP10，重印近30次，北外高翻李长栓编写，多所高校考研指定用书，北外高翻官方推荐使用，翻译研究与实践，CATTI考试参考用书。团购电话:4001066666转6 ',260.00,0.50,'https://img3m3.ddimg.cn/9/30/29416473-1_w_10.jpg',7,0,'2023-01-27','language'),(48,'雅舍谈吃','本书是梁实秋代表散文“雅舍谈吃”系列的精选集。梁实秋自嘲嘴馋，一生中写下无数谈吃的文章，是名家谈吃中的经典作品。每一篇均以一种食物的名称为题目，海参、西施舌、火腿、醋溜鱼、烧鸭、狮子头、佛跳墙、豆汁儿……无论是记忆中故乡的味道，还是四方美食、异域食色，无论是酒楼饭庄的招牌菜，还是平常居民的家常菜、独具特色的地方小吃，篇篇风雅精致，旁征博引，令人大快朵颐。一代散文大师梁实秋留给我们的不仅仅是舌尖上的味道，还有历史的味道，人情的味道，故乡的味道和记忆的味道。',26.50,1.00,'http://img3m6.ddimg.cn/34/24/29498866-1_w_10.jpg',10,0,'1995-06-13','living'),(49,'禅者的初心','一本影响乔布斯学禅悟道的书；安妮宝贝30岁后看《禅者的初心》；不忘初心，方得始终',16.80,1.00,'http://img3m4.ddimg.cn/85/24/23725534-3_u_6.jpg',4,0,'2019-06-04','living'),(50,' 日语入门：零起点图解一看就会','　《日语入门：零起点图解一看就会》在内容上囊括了发音、语法、词汇、口语、文化等各个方面,在结构上采用全彩图和替换词的形式,从*基础的日语发音入手，其次是语法的突破，接下来是15大场景的口语学习，中间还会穿插一些文化趣闻。本书不管从内容还是结构上，都是非常有利于初学者学习日语的，学期起来也会非常轻松、有趣、不枯燥！\n　　● 发音：本书针对初学者学习日语的特点，从*基础的日语50音开始，搭配口型图、发音规则和字帖练习，其由浅入深，循序渐进，夯实发音关，保证读者学完此书就能学会真正地道、标准的日语！\n　　● 语法：选取人们*常用的动词、形容词、格助词以及敬语，突破语法关！\n　　● 口语：精选人们*熟悉的15个场景，每一场景都由人们*常说的常用句组成，搭配替换词和延伸句，练习口语的同时也增加了单词量！',99.00,1.00,'http://img3m5.ddimg.cn/31/16/23486395-1_u_30.jpg',11,0,'2020-06-18','language'),(51,'标准德语语法--精解与练习','学习德语的初学者一般都觉得德语难，且重点难在语法。《标准德语语法——精解与练习》中对语法规则的讲解和剖析则徐徐揭开了德语语法的“面纱”。本书中语法的出现和讲解顺序是循序渐进式的，也就是说，先是初级阶段的语法，然后才是学习者在中级阶段会碰到的语法。由于德语的介词用法相对比较复杂，且和其他用法紧密相连，因此介词的用法在第五部分，它应跟前面的四个部分结合起来学习。全书的后是练习答案。本书全面、精确地介绍了德语语法规则，并配以大量的列表、表格以及练习。阅读本书中的语法规则，使人有“茅塞顿开”之感，仿佛一切语法难题都迎刃而解。当然，语法规则只是帮助学习者理解或理顺语法，更重要的是应用。因此在每个语法讲解之后都有大量相应的语法练习，大家可以通过这些语法练习巩固并熟练掌握相应的语法规则。在难度较高的练习前有一个底纹颜色稍深些的方框。本书中的语法规则涉及到德语语法的方方面面，平时在一般语法书中无法求证的问题几乎都可以在本书中找到答案，而详细的目录则有助于您快速找到答案。本书不仅对于德语学习者来说是一本不可多得的语法学习和练习手册，对广大德语教师来说也是一本案头的绝佳参考书。',101.00,0.90,'http://img3m3.ddimg.cn/43/25/478213-1_u_1.jpg',11,0,'2021-06-15','language'),(52,'中文','《中文》是中华人民共和国普通高等学校联合招收华侨、港澳地区、台湾省学生入学考试模拟试题丛书之一本，是按照2016年*考试中心修订后的考试大纲要求及2017年以来全国联招考试出题的实际情况进行编写的，一共设计了19套模拟试题，在知识点、题型、题量、答案等方面，都按照全国联招考试真题的内容和格式要求进行编写，适用于参加全国联招及两校联招考试的港澳台侨及外籍学生。\n\n',999.00,0.50,'http://img3m2.ddimg.cn/46/15/29188612-1_u_2.jpg',11,0,'2021-06-09','children'),(53,'全新法语语法','　《全新法语语法（精装版）》是在法国巴黎索邦大学的经典教程基础上，考虑到国际语言文化的多样性以及法语教学新观点而加以革新和丰富内容的新一代对外法语语法著作。《全新法语语法（精装版）》语法内容按照教程方式编排，简洁而全，囊括所有的法语语现象，帮助具有初步法语知识的非法语国家学习者明确地认识法语语法，从而掌握法语书面和口语的表达法。  \n　　《全新法语语法（精装版）》的语法点紧密配合欧洲统一语言参考框架的法语系列考试，编写严密、可读性强，具有相当的权威性和实用性。',33.10,0.90,'http://img3m7.ddimg.cn/67/17/23318527-3_u_2.jpg',11,0,'2021-06-08','language'),(54,'深入理解计算机系统','本书是将计算机软件和硬件理论结合讲述的经典教程，内容覆盖计算机导论、体系结构和处理器设计等多门课程。本书的 优点是为程序员描述计算机系统的实现细节，通过描述程序是如何映射到系统上，以及程序是如何执行的，使读者更好地理解程序的行为为什么是这样的，以及造成效率低下的原因。',69.50,0.50,'http://img3m7.ddimg.cn/48/0/24106647-1_u_21.jpg',4,0,'2015-07-01','computer'),(55,'计算机是怎样跑起来的','《计算机是怎样跑起来的》倡导在计算机迅速发展、技术不断革新的今 天，回归到计算机的基础知识上。通过探究计算机的本质，提升工程师对计算机的兴趣，在面对复杂的**新技术时，能够迅速掌握其要点并灵活运用。\n《计算机是怎样跑起来的》以图配文，以计算机的三大原则为开端、相继介绍了计算机的结构、手工汇编、程序流程、算法、数据结构、面向对象编程、数据库、TCP IP 网络、数据加密、XML、计算机系统开发以及SE 的相关知识。本书适合计算机爱好者和相关从业人员阅读。\n《计算机是怎样跑起来的》图文并茂，通俗易懂，非常适合计算机爱好者和相关从业人员阅读。',44.80,0.90,'http://img3m5.ddimg.cn/42/7/29242365-2_u_1.jpg',4,0,'2020-06-02','computer'),(56,'这就是计算机','《这就是计算机》是一套专门为6-12岁的孩子设计的计算机科普书，一套8册6大主要领域，近200个知识点，这里面既有超硬核的知识体系，又有趣味十足的内容表达方式，用漫画的形式让孩子读懂枯燥复杂的计算机科学知识。\n\n这套书在内容上涉及了计算机重要组成的6大部分，包括芯片、数据、算法、编程、软件、互联网，了解计算机必先了解这六个方面。全套书从计算机发展现状开始讲起，然后分别从计算机这六大组成部分的角度依次向孩子讲解计算机科学知识，后立足现在展望计算机的未来发展。一个方向对应一册书，全套八册，体系完整，内容全面。\n\n本套书用漫画的形式，把计算机科学知识变成漫画故事，将计算机的重要组成拟人为漫画人物，用孩子喜欢的画风和简单的语言形式，科普计算机科学知识，让孩子对计算机看得懂、有兴趣，在感受计算机给生活带来的便利和无限可能的同时，并明确自我未来的发展方向。掌握计算机才能掌握未来。',99.00,0.50,'http://img3m0.ddimg.cn/95/16/29339240-1_u_7.jpg',4,0,'2021-06-08','computer'),(57,'计算机网络','本书自1989年首次出版以来，曾多次修订。在2006年本书通过了*的评审，被纳入普通高等教育“十一五”规划教材；2008年出版的第5版获得了*2009年精品教材称号。2013年出版的第6版是“十二五”普通高等教育本科规划教材。现在的第8版又在原有的基础上进行了一些修订。\n\n全书分为9章，比较全面系统地介绍了计算机网络的发展和原理体系结构、物理层、数据链路层（包括局域网）、网络层、运输层、应用层、网络安全、互联网上的音频/视频服务，以及无线网络和移动网络等内容。各章均附有习题（附录A给出了部分习题的答案和提示）。全书课件放在电子工业出版社华信教育资源网（www.hxedu.com.cn），供读者下载参考。\n\n本书的特点是概念准确、论述严谨、内容新颖、图文并茂，突出基本原理和基本概念的阐述，同时力图反映计算机网络的一些发展。本书可供电气信息类和计算机类专业的大学本科生和研究生使用，对从事计算机网络工作的工程技术人员也有参考价值。',50.90,0.99,'http://img3m4.ddimg.cn/55/13/29258614-1_u_21.jpg',4,0,'2020-07-02','computer'),(58,'舍得','　在《舍得》中，星云大师继续释发学识精义，对大众人生拓展、学业、事业、生活及修养心性诸方面进行分析和指导，启发人在成长成功的过程中把握住自己，沿着精进的方向完善自我，以和谐社会。',14.00,0.80,'http://img3m5.ddimg.cn/61/1/20744125-1_u_2.jpg',2,0,'2022-06-22','business'),(59,'阿米巴经营','阿米巴经营模式被誉为“京瓷经营成功的两大支柱之一”。本书详细阐述了阿米巴经营的操作方法，总结了稻盛和夫的经营观点和实践经验，是学习阿米巴经营的书。\n\n阿米巴经营基于牢固的经营哲学和精细的部门独立核算管理，将企业划分为“小集体”，像自由自在的重复进行细胞分裂的阿米巴——以各个阿米巴为核心，自行制订计划，独立核算，持续自主成长，让每一位员工成为主角，全员参与经营，打造激情燃烧的集体，依靠全体智慧和努力完成企业经营目标，实现企业的飞速发展。\n\n全球超过500家的企业引进了阿米巴经营模式，业绩得以大幅提升。',24.50,0.99,'http://img3m5.ddimg.cn/77/16/29304275-1_u_4.jpg',11,0,'2019-06-05','business'),(60,'社科创新：无价的价值：国外社科研究项目管理体制评述','郦莉，山东淄博人，外交学院中国外交理论研究中心助理研究员，2011—2012年作为中美富布赖特联合培养博士生赴美国康涅狄格大学政治学系学习。在《外交评论》《中国社会科学院研究生院学报》《复旦国际关系评论》等期刊和文集发表论文数十篇，主持或参与国家哲学社科、*、北京市和国际合作项目多项。著有《全球气候治理中的公私合作关系》一书。\n',72.00,0.80,'http://img3m9.ddimg.cn/75/10/25083309-1_u_3.jpg',5,0,'2020-06-03','social'),(61,'中国农村村民自治','20世纪80年代以来，随着家庭承包责任制的兴起和国家民主化进程的推进，中国农村出现了村民自治这一基层民主治理形式。村民通过村民自治组织，以民主选举、民主决策、民主管理和民主监督的方式，依法自主管理与村民利益相关的本村公共事务，实现自我管理、自我教育和自我服务。\n\n中国农村村民自治是有中国特色社会主义民主的一种重要形式，亦是在新的历史条件下农村治理的一种有效方式，在其发展与推广过程中，有其艰巨性与复杂性。在中国乡村推行三十年后，当下，村民自治进入到一个新的历史阶段，村民自治研究正伴随实践进行范式转换，由价值—制度范式向形式—条件范式转换。\n\n徐勇教授二十余年来坚持不懈有关村民自治的调查研究，深入梳理中国农村村民自治的产生、发展，以及在发展过程中所面临的难题与困境。本书的上篇由徐勇教授的博士学位论文构成，名为“制度分析”；下篇收录了2000年至今其代表性论文数十篇，名为“专题研究”。上下两篇可以完整地反映徐勇教授从事村民自治研究的全过程。本书的出版也算是对村民自治研究的一个阶段性总结。',38.60,0.67,'http://img3m5.ddimg.cn/29/6/25337495-1_u_3.jpg',4,0,'2021-06-01','social'),(62,'新教伦理与资本主义精神','《新教伦理与资本主义精神》是马克斯·韦伯著名的作品。在这部作品中，韦伯提出了一个知名的论点：新教教徒的思想影响了资本主义的发展。宗教教徒往往排斥世俗的事务，尤其是经济成就上的追求，但为什么新教教徒却是例外？\n\n　　韦伯在该书中论述宗教观念（新教伦理）与隐藏在资本主义发展背后的某种心理驱力（资本主义精神）之间的关系。韦伯列举了新教、清教、加尔文教等教徒生活、学习的例子并加以分析得出：资本主义的兴起和成功与新教盛行存在着相互影响的关系。新教入世禁欲主义伦理为资本主义企业家提供了心理驱动力和道德能量，从而成为现代资本主义得以兴起的重要条件之一。',39.50,0.95,'http://img3m5.ddimg.cn/66/12/29504145-1_u_1.jpg',2,0,'2021-06-10','social'),(63,'空间的生产','《空间的生产》首发于1974年，集中了列菲伏尔城市理论的核心内容。根据列菲伏尔的逻辑，空间是社会的产物。空间的生产包容一切的世界观和实践活动，其产物不同于自然空间与实际空间，而是包含三层含义：（1）空间包含了多重关系，任何一个社会从而任何一种生产方式，都会生产出它自身的空间。（2）空间是一个表征性空间，透过意象与象征而被生产出来。（3）空间通过知识与理论的诠释而被建构出来。在这部开创性的著作中，列菲伏尔尝试重建关于空间的元理论；同时又从空间实践的层面提出：空间不是既定的，而是具有建构性的力量，是生成的，具有实践的反思性。本书主体分为七章：一、当前工作的计划； 二、社会空间；三、空间的构型； 四、从空间到抽象空间；五、矛盾的空间；六、空间：从矛盾到异化；七、开放性与结论。',99.70,0.97,'http://img3m8.ddimg.cn/58/14/29386228-1_u_4.jpg',7,0,'2023-06-06','social'),(64,'成功励志系列',' 本书从人成功的三大法宝——心态、性格、习惯入手，将丰富动人的小故事与启人至深的哲理相结合，用睿智、生动的语言，由表及里，由浅入深地向人们诠释了心态、性格、习惯在我们人生中举足轻重的地位，并告诉你如何改变消极的心态，拥有阳光般的心境；如何认识自己的性格，用性格来改变你的人生；如何培养良好的习惯，成就自己的一生，传授给你成功的经验和方式。',20.50,0.90,'http://img56.ddimg.cn/99999990003689416.jpg',8,0,'2023-06-05','motivation'),(65,'艺术的慰藉','人们常常说道，艺术非常重要，却很少有人告诉我们它之所以重要的确切原因。现在，流行文化领域的两位权威人士阿兰·德波顿与约翰·阿姆斯特朗将解答这一困扰我们的私密但平凡的难题。\n我的工作为什么没有给我带来更多的满足感？\n别人的生活为什么看上去更加光鲜亮丽？\n我应该如何改善与恋人之间的关系？\n政治为什么总令人沮丧？',39.20,0.95,'http://img3m9.ddimg.cn/36/32/27899919-1_u_3.jpg',6,0,'2011-05-05','art'),(66,'大话西方艺术史','本书用浅白风趣的语言和逻辑清晰的脉络，梳理了30000多年西方艺术史的精髓，帮助你迅速构建完整的艺术史认知框架，提升你在生活中的独立审美意识。\n　　从艺术的起源、西方文明的源头开始，经过文艺复兴、巴洛克、新古典主义，再到浪漫派、印象派乃至20世纪之后的当代艺术，这些名目繁多的流派、艺术家和代表作，经由意公子轻松有趣的解读逐一串连，配合书中丰富精美的图片以及关键词索引附录，满足你阅读的不同需求。在这里不仅可以学到艺术领域的基础知识，也可以找到欣赏艺术作品的方法。这本句句有梗的极简艺术史，你值得拥有。',39.00,0.98,'http://img3m8.ddimg.cn/71/21/28516328-1_u_27.jpg',7,0,'2020-06-10','art'),(67,'现代艺术150年','如果我们还能从一百五十多年前莫奈的《日出》、梵高的《星空》中，依稀辨认出艺术“原来”的模样，那么，一百五十年后安迪·沃霍尔的金汤宝罐头、达米恩·赫斯特的腌制鲨鱼，还有翠西·艾敏乱糟糟的床，足以让我们看到艺术的其他可能。回顾现代艺术一个半世纪的反叛之路，我们见证了一代又一代人如何变得愈发反叛、大胆、混乱。这背后，是艺术家对“何为艺术”的无尽追问，是他们对周遭世界的回应与抵抗。现代艺术的故事仍在继续，也许永远不会完成。',39.00,0.85,'http://img3m5.ddimg.cn/33/14/24225135-1_u_4.jpg',10,0,'2021-06-01','art'),(68,'艺术哲学','《艺术哲学》是“一部有关艺术、历史及人类文化的巨著”，是一本带领大家畅游艺术天地的导游书，也是一本经典文艺理论著作。书中内容来自丹纳在巴黎美术学校授课时的讲稿，通俗易懂，深入浅出。丹纳在书中不仅对美学提出科学见解，还将理论结合欧洲艺术史，深入讲解了艺术发展的主要潮流，能够很好地帮助人们理解领会艺术。不论是艺术专业人士，还是业余爱好者，都可以从中获益。',34.90,1.00,'http://img3m0.ddimg.cn/88/25/29435560-1_u_4.jpg',4,0,'2023-05-08','art'),(69,'迪士尼英文原版','Judy Hopps is an upstanding police officer right out of the police academy. Nick Wilde, a fast-talking fox, lives by his wits in the city of Zootopia. Against all odds, these two natural enemies team up on a case that turns out to be a bigger mystery than either one could ever has guessed! \n生性耿直的兔朱迪是刚从警察学院毕业的一名警察。狐尼克则是一只油嘴滑舌的狐狸，靠着耍小聪明在动物城度日。尽管困难重重，这对自然界的天敌却能组成搭档，联手破案，揭露了一起令谁也猜测不出的惊天谜团！\n\n',12.60,1.00,'http://img3m9.ddimg.cn/57/15/24170709-1_u_8.jpg',9,0,'2020-06-16','origin'),(70,'莎士比亚十四行诗 软精装 名师注释英文原版','《莎士比亚十四行诗》收录了莎翁留传于世的全部154首十四行诗，大约陆续创作于1590年至1598年之间，诗歌表现的主题为友谊、爱情、艺术、时间。第1首至第126首写诗人与一位青年的友谊的变化；第127首至第152首写诗人对一位“黑肤女郎”的爱恋；*后两首结束。这些诗篇蕴含着丰富的思想内容，体现了诗人对真、善、美的看法和理想，以及对光明和未来的希望，也表现出诗人对人与人之间不和谐的失望和焦虑。在诗篇后两行中，莎翁常常以神来之笔，概括诗意，点明主题，使这一对偶句成为传世警句。',14.90,1.00,'http://img3m8.ddimg.cn/52/17/25289998-1_u_2.jpg',10,0,'2023-06-06','art'),(71,'迪士尼英文原版.飞屋环游记','The fantastic adventures are just beginning when Carl, a retired helium-balloon salesman, attaches thousands of colorful balloons to his house and takes off for a South American jungle. Everything goes according to plan until Carl discovers that an enthusiastic young Wilderness Explorer named Russell has stowed away for the ride. Soon Carl is dealing with all sorts of trouble, including dangerous dogs, a crazy adventurer, and even a mysterious creature…\n这是一个奇妙的探险故事。一名退休的氦气球售卖员卡尔，把成千上万只彩色气球系到自家的房子上，出发前往南美洲的丛林。一切都在按计划顺利进行，但是，热情而又年轻的探险家小罗的出现打乱了他的计划。很快，问题层出不穷，他们遇到了危险的狗、疯狂的探险家，甚至还遇到一只神秘的动物……',9.90,1.00,'http://img3m2.ddimg.cn/95/29/23910872-4_u_8.jpg',10,0,'2020-06-11','origin'),(72,'小王子+老人与海 全英文原版经典名著系列读物','《小王子》以一位飞行员的口吻，讲述了自己从小不被人理解，直到六年前因为飞机故障迫降在撒哈拉沙漠后遇到古怪奇特而又天真纯洁的小王子。小王子来自于一个非常小的星球。由于和他美丽又骄傲的玫瑰花闹了别扭，他离开了他的星球开始独自旅行。\n\n他先后拜访了其他六个星球，分别遇到了傲慢的国王、爱慕虚荣的人、酒鬼、商人、尽忠职守的点灯人和死守教条的地理学家，对一切充满了困惑，并觉得大人们实在是太奇怪了。*后，他来到了地球，遇到了蛇、狐狸和飞行员，同他们建立了友谊，渐渐明白了什么是爱、责任和生命，得到了人生的真谛。于是，他决定回到自己的星球……\n\n《老人与海》故事的背景发生在在二十世纪中叶的古巴。主人公是一位名叫圣地亚哥的老渔夫，配角是一个叫马诺林的小男孩。风烛残年的老渔夫一连八十四天都没有钓到一条鱼，但他仍不肯认输，而是充满着奋斗的精神，终于在第八十五天钓到一条身长十八尺，体重一千五百磅的大马林鱼。大鱼拖着船往海里走，老人依然死拉着不放，即使没有水，没有食物，没有武器，没有助手，左手抽筋，他也丝毫不灰心。经过两天两夜之后，他终于杀死大鱼，把它拴在船边。但许多鲨鱼立刻前来抢夺他的战利品。他一一地杀死它们，到*后只剩下一支折断的舵柄作为武器。结果，大鱼仍难逃被吃光的命运，*终，老人筋疲力尽地拖回一副鱼骨头。他回到家躺在床上，在梦中忆起那往日的美好岁月。',27.80,0.95,'http://img3m8.ddimg.cn/97/35/24102538-1_u_20.jpg',11,0,'2023-04-03','art'),(73,'简爱','《简·爱》（Jane Eyre）十九世纪英国著名女作家夏洛蒂·勃朗特的代表作，人们普遍认为《简·爱》是夏洛蒂·勃朗特“诗意的生平写照”，是一部具有自传色彩的作品。讲述了一位从小变成孤儿的英国女子在各种磨难中不断追求自由与尊严，坚持自我，*终获得幸福的故事。小说引人入胜地展示了男女主人公曲折起伏的爱情经历，歌颂了摆脱一切旧习俗和偏见，成功塑造了一个敢于反抗，敢于争取自由和平等地位的妇女形象。\n《简·爱》这本小说的主题通过对孤女坎坷不平的人生经历，成功地塑造了一个不安于现状、不甘受辱、敢于抗争的女性形象，反映了一个平凡心灵的坦诚倾诉的呼号和责难，由一个小写的人成为一个大写的人的渴望。小说通过罗切斯特两次截然不同的爱情经历，批判了以金钱为基础的婚姻和爱情观，并始终把简·爱和罗切斯特之间的爱情描写为思想、才能、品质与精神上的完全默契。\n《简·爱》为英文原版，同时附赠配套朗读音频免费下载（下载地址见图书封底），让读者在阅读精彩故事的同时，亦能提升英文阅读水平。',15.00,0.90,'http://img3m1.ddimg.cn/84/16/23902941-1_u_2.jpg',11,0,'2012-06-06','origin'),(75,'横断浪途（阿来力荐，七堇年再出发之作，一场走向群山也走向内心的壮游！）','七堇年SHOU部旅行随笔。三年时间，穿越横断山脉三万里，走过四十个地方，在中国蕞神秘地质带，触摸风景、文化、观念的断层。在天地辽阔中，抵达生命的和解，走到人生深处。',69.00,0.50,'http://img3m5.ddimg.cn/76/32/29617015-1_w_1693202273.jpg',6,1,'2023-08-31','literature'),(76,'行走中国 : 人文风情和自然生态发现之旅','在生态文明新时代，行走中国，展现一幅五彩斑斓、壮美妖娆的人文风情和自然生态画卷，体现人和人之间，人和环境之间，人和自然之间，生命与生命之间的和谐共生、交汇融合。',88.00,0.48,'https://img3m8.ddimg.cn/6/24/29353308-1_w_3.jpg',9,0,'2022-01-01','living'),(77,'不如读诗（当代诗人张执浩与16位古代诗人的灵魂对话，写尽诗词背后的曲折文心、壮阔命运！）','沉浸式体验古代大诗人的一生。一本书，重塑你的诗歌历史观。',10.00,0.50,'https://img3m5.ddimg.cn/23/35/29512715-1_u_8.jpg',6,0,'2023-01-01','literature');
/*!40000 ALTER TABLE `buchs` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-06 11:38:11