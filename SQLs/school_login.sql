CREATE DATABASE  IF NOT EXISTS `school` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `school`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: school
-- ------------------------------------------------------
-- Server version	5.6.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `UserID` int(11) NOT NULL,
  `Password` varchar(15) NOT NULL,
  `SecurityQuestion` varchar(45) DEFAULT NULL,
  `Answer` varchar(45) DEFAULT NULL,
  `AccountType` varchar(10) DEFAULT NULL,
  `Status` tinyint(1) DEFAULT '1',
  `LoginAttemptCount` int(1) DEFAULT '0',
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (66,'abc','kk','maths','student',1,0),(100,'Abc@123','What is your Pet Name ?','100','dpd',0,3),(111,'abc','Whats your favorite subject?','maths','admin',1,0),(123,'Def@123','Whats your favorite subject?','math','student',1,0),(155,'Maxwel@123','whats your fav subject','maths','student',1,0),(222,'Def@123','Whats your favorite subject?','math','dpd',1,0),(666,'abc','hh','maths','dpd',1,1),(678,'abc','fexx','maths','student',1,0),(777,'5555','z','maths','student',1,0),(888,'abc','aa','maths','student',1,0),(120000,'Stefan@123','Whats your fav subject','english','student',1,0),(444444,'Ggggg@123','whats your fav sub','maths','dpd',1,0),(555555,'Rachita@123','whats your fav subject','maths','student',1,0),(765678,'Asdf@123','g','h','dpd',1,0),(987777,'Elli@123','fav subject','maths','dpd',1,0),(999999,'pppp','khkuh','maths','student',1,0),(1234567,'Qwerty@12345','What is your favorite subject?','maths','student',1,0),(1255185,'','What is your favorite subject?','Math','student',1,1),(3434343,'Alex@123','Whats your fav subject','English','student',1,0),(4545454,'Ankita@123','jkjkj','maths','student',1,0),(6666666,'Chhavi@123','ma','ma','m',0,3),(6776973,'defg','whats your fav subject?','maths','student',1,2),(7654321,'Akashi@123','Whats your fav subject','English','student',1,0),(8765432,'Hhhhh@123','jajaj`','maths','student',1,0);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-03 23:54:58
