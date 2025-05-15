-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hr1_table
-- ------------------------------------------------------
-- Server version	8.4.0

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
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name_dep` varchar(128) NOT NULL,
  `namesdep` varchar(8) NOT NULL,
  `code_dep` varchar(3) NOT NULL,
  `email_head` varchar(64) NOT NULL,
  `phone_head` varchar(6) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_dep_UNIQUE` (`name_dep`),
  UNIQUE KEY `code_dep_UNIQUE` (`code_dep`),
  UNIQUE KEY `email_head_UNIQUE` (`email_head`),
  UNIQUE KEY `check03` (`name_dep`),
  UNIQUE KEY `check04` (`namesdep`),
  UNIQUE KEY `check05` (`code_dep`),
  UNIQUE KEY `check06` (`email_head`)
) ENGINE=InnoDB AUTO_INCREMENT=403 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (178,'Human Resource','HR','HR1','hr_head@company.com','12-345'),(179,'Information Technology','IT','IT1','it_head@company.com','65-432'),(180,'Sales Department','Sales','SA1','sales_head@company.com','98-765'),(181,'Finance Department','Finance','FN1','finance_head@company.com','45-678'),(182,'Marketing','MKT','MK1','marketing_head@company.com','11-223'),(183,'Customer Support','CS','CS1','support_head@company.com','44-556'),(184,'Legal','Legal','LG1','legal_head@company.com','77-889'),(185,'Research and Development','R&D','RD1','rd_head@company.com','22-334'),(186,'Procurement','Proc','PR1','procurement_head@company.com','33-445'),(187,'Quality Assurance','QA','QA1','qa_head@company.com','55-667'),(188,'Operations','Ops','OP1','ops_head@company.com','99-887'),(189,'Supply Chain','SC','SC1','supply_head@company.com','66-778'),(190,'IT Support','ITS','ITS','its_head@company.com','33-449'),(191,'Public Relations','PR','PR2','pr_head@company.com','11-223'),(192,'Accounting','Acct','AC1','accounting_head@company.com','66-778'),(193,'Compliance','Comp','CO1','compliance_head@company.com','22-334'),(194,'Health & Safety','H&S','HS1','health_head@company.com','99-887'),(195,'Business Development','BD','BD1','bd_head@company.com','44-556'),(196,'Training & Development','T&D','TD1','training_head@company.com','55-667'),(197,'Product Management','PM','PM1','pm_head@company.com','77-889'),(198,'Engineering','Eng','EN1','eng_head@company.com','22-334'),(199,'Administration','Admin','AD1','admin_head@company.com','33-445'),(200,'Strategy','Strat','ST1','strategy_head@company.com','99-887'),(201,'Corporate Communications','CorpComs','CC1','corp_head@company.com','66-778'),(202,'Investor Relations','IR','IR1','investor_head@company.com','55-667');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department_seq`
--

DROP TABLE IF EXISTS `department_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department_seq`
--

LOCK TABLES `department_seq` WRITE;
/*!40000 ALTER TABLE `department_seq` DISABLE KEYS */;
INSERT INTO `department_seq` VALUES (501);
/*!40000 ALTER TABLE `department_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worker`
--

DROP TABLE IF EXISTS `worker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `worker` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(3) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `start_work` date NOT NULL,
  `end_work` date DEFAULT NULL,
  `department` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `FK4yaatxgtg0bmi5k8nt5wdci2a` (`department`),
  CONSTRAINT `FK4yaatxgtg0bmi5k8nt5wdci2a` FOREIGN KEY (`department`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worker`
--

LOCK TABLES `worker` WRITE;
/*!40000 ALTER TABLE `worker` DISABLE KEYS */;
INSERT INTO `worker` VALUES (1,'001','Ivanov','Ivan','2020-01-15','2022-12-31',192),(2,'002','Petrov','Petr','2021-05-10','2023-03-20',179),(3,'003','Sidorov','Sidor','2019-09-12','2021-08-15',180),(4,'004','Kuznetsov','Nikolai','2018-03-25','2022-11-10',181),(5,'005','Smirnov','Alexei','2022-06-01','2024-06-01',182),(6,'006','Popov','Evgeny','2017-12-15','2020-09-30',183),(7,'007','Fedorov','Sergey','2016-07-22','2022-01-14',184),(8,'008','Mikhailov','Mikhail','2021-01-17','2023-07-18',185),(9,'009','Alexeev','Aleksandr','2020-11-02','2022-11-02',186),(10,'010','Morozov','Dmitry','2015-06-30','2021-05-25',187),(11,'011','Vasiliev','Andrei','2019-04-18','2021-04-18',188),(12,'012','Zhukov','Vladimir','2018-12-05','2023-01-10',189),(13,'013','Semenov','Valery','2020-08-09','2022-04-10',190),(14,'014','Chernov','Konstantin','2021-03-28','2023-02-28',191),(15,'015','Alekseev','Yury','2022-09-20','2024-03-01',192),(16,'016','Tikhonov','Sergei','2017-05-13','2020-07-31',193),(17,'017','Stepanov','Igor','2020-10-15','2022-09-15',194),(18,'018','Kozlov','Oleg','2016-11-30','2019-12-31',195),(19,'019','Belov','Denis','2018-04-03','2021-12-31',196),(20,'020','Nikolaev','Viktor','2019-02-25','2023-02-25',197),(21,'021','Orlov','Roman','2021-07-30','2023-06-30',198),(22,'022','Volkov','Maxim','2020-04-05','2022-06-30',199),(23,'023','Zaharov','Igor','2017-09-10','2021-09-10',200),(24,'024','Pavlov','Alexandr','2021-02-01','2023-02-01',201);
/*!40000 ALTER TABLE `worker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'hr1_table'
--

--
-- Dumping routines for database 'hr1_table'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-11 18:19:14
