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
-- Table structure for table `studentdetails`
--

DROP TABLE IF EXISTS `studentdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studentdetails` (
  `UserID` int(11) NOT NULL,
  `FirstName` varchar(45) DEFAULT NULL,
  `LastName` varchar(45) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `PhoneNumber` varchar(20) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `SessionJoined` varchar(45) DEFAULT NULL,
  `DepartmentID` int(10) DEFAULT NULL,
  `EnrollProgram` varchar(45) DEFAULT NULL,
  `DateOfBirth` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentdetails`
--

LOCK TABLES `studentdetails` WRITE;
/*!40000 ALTER TABLE `studentdetails` DISABLE KEYS */;
INSERT INTO `studentdetails` VALUES (1,'a','a','a','1','a','a',1,'a','12/08/1988'),(66,'aa','bb','bb','88','bb','bb',1,'bb','11'),(123,'Ankita','Mishra','india','22222','mishraankita88@live.com','SUMMER 2014',1,'test','12082013'),(155,'Max','Well','Montreal','666666','max@gmail.com','Fall 2014',6,'Masters','12/08/88'),(345,'ankita','mishra','india','199999','ankita.mishra@gmail.com','Fall - 2013',1,'Masters','12-08-1988'),(555,'ooo','mmm','nnn','12345','hhhh','ff ff',2,'masters','12222'),(678,'sahil ankita','aa','aa','123','aaa','aa',1,'w','ee'),(777,'z','z','z','6','z','z',5,'5','5'),(888,'aa','aa','aa','77','aa','aa',1,'masters','11'),(120000,'Stefan','aa','uu','7777777','stefan@gmail.com','Summer 2013',1,'Masters','15/02/88'),(555555,'Rachita','Mishra','india','777777','rachita@gmail','Fall 2012',1,'Masters','01/02/1999'),(999999,'swasti','mishra','USA','999999','swasti@gmail.com','',1,'hgg','hjhg'),(1234567,'qwerty','zxcvbnm','asdfg','514122222','qwerty@gmail','Fall - 2013',4,'masters','12/08/1988'),(1255185,'Gilles','Desrochers','252 Markham Pl','514444444','gilles.desrochers@homtail.com','Summer 2012',1,'Sw Eng','16 Nov 1972'),(3434343,'Alex','Medson','St, Marc','5141234567','alex@gmail.com','FAll 2014',1,'Masters of Engineering','01/04/1988'),(4545454,'jjj','jjjj','jjjj','7777','jjj@gmail.com','yyyy',8,'jkjkj','77777'),(6776973,'sahil','chaudhary','dil','100','sahil','FALL 2012',1,'Masters','05/02/1987'),(7654321,'Akashi','Malhotra','Laval Montreal','514-466-9509','Akshi@gmail.com','FALL 2014',1,'Masters in Engineering','01/03/1986'),(8765432,'hh','hh','hh','8765','hahah@gmail.com','Fall',7,'uuuu','777');
/*!40000 ALTER TABLE `studentdetails` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-03 23:55:01
