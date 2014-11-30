CREATE DATABASE  IF NOT EXISTS `school` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `school`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: school
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
-- Table structure for table `courseoffered`
--

DROP TABLE IF EXISTS `courseoffered`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courseoffered` (
  `CourseID` int(10) NOT NULL,
  `CourseName` varchar(45) DEFAULT NULL,
  `DepartmentID` int(10) DEFAULT NULL,
  `Professor` varchar(45) DEFAULT NULL,
  `LABId` int(10) DEFAULT NULL,
  `Schedule` varchar(45) DEFAULT NULL,
  `SessionOffered` varchar(15) DEFAULT NULL,
  `AddDropDeadline` varchar(45) DEFAULT NULL,
  `PreRequisiteCourseID` int(10) DEFAULT NULL,
  `CapacityOfStudent` int(4) DEFAULT NULL,
  PRIMARY KEY (`CourseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courseoffered`
--

LOCK TABLES `courseoffered` WRITE;
/*!40000 ALTER TABLE `courseoffered` DISABLE KEYS */;
INSERT INTO `courseoffered` VALUES (0,'',0,'',0,'','','12/12/2014',1,0),
(999,'learning java',1,'Dr xyz',1,'FRIDAY 17002000','FALL 2014','20140901',123,50),
(100,'SOEN 112',1,'Dr xyz',1,'--M-V-- (13:30-14:15) SGW 201','FALL 2014','20140901',123,30),
(101, 'BIO 101', 7, 'Prof Markov', 1, '-M-J--- (10:30-11:15) SGW 201', 'FALL 2014', '20140901', 0, 20),
(102, 'PHYS 101', 2, 'Prof Subban', 1, '--M-V-- (10:30-11:15) SGW 201', 'FALL 2014', '20140901', 0, 20),
(103, 'CHEM 101', 3, 'Prof Price', 1, '-M-J--- (13:30-14:15) SGW 201', 'FALL 2014', '20140901', 0, 20),
(104, 'MATH 101', 4, 'Prof Plekanec', 1, '--M-V-- (13:30-14:15) SGW 201', 'FALL 2014', '20140901', 0, 20),
(105, 'ENG 101', 5, 'Prof Gallagher', 1, '-M-J--- (10:30-11:15) SGW 201', 'FALL 2014', '20140901', 0, 30),
(106, 'COMP 101', 6, 'Prof Galchenyuk', 1, '--M-V-- (10:30-11:15) SGW 201', 'FALL 2014', '20140901', 0, 20),
(107, 'BIO 201', 7, 'Prof Pacioretty', 1, '-M-J--- (10:30-11:15) SGW 201', 'FALL 2014', '20140901', 101, 20),
(108, 'PHYS 201', 2, 'Prof Tokarski', 1, '--M-V-- (10:30-11:15) SGW 201', 'FALL 2014', '20140901', 102, 20),
(109, 'CHEM 201', 3, 'Prof Desharnais', 1, '-M-J--- (13:30-14:15) SGW 201', 'FALL 2014', '20140901', 103, 20),
(110, 'MATH 201', 4, 'Prof Eller', 1, '--M-V-- (13:30-14:15) SGW 201', 'FALL 2014', '20140901', 104, 20),
(111, 'ENG 201', 5, 'Prof Parenteau', 1, '-M-J--- (10:30-11:15) SGW 201', 'FALL 2014', '20140901', 105, 20),
(112, 'COMP 201', 6, 'Prof Prust', 1, '--M-V-- (10:30-11:15) SGW 201', 'FALL 2014', '20140901', 106, 20),
(113, 'SOEN 101', 1, 'Prof Markov', 1, '-M-J--- (10:30-11:15) SGW 201', 'FALL 2014', '20140901', 0, 20),
(114, 'SOEN 102', 1, 'Prof Subban', 1, '--M-V-- (10:30-11:15) SGW 201', 'FALL 2014', '20140901', 0, 20),
(115, 'SOEN 103', 1, 'Prof Price', 1, '-M-J--- (13:30-14:15) SGW 201', 'FALL 2014', '20140901', 0, 20),
(116, 'SOEN 104', 1, 'Prof Plekanec', 1, '--M-V-- (13:30-14:15) SGW 201', 'FALL 2014', '20140901', 0, 20),
(117, 'SOEN 105', 1, 'Prof Gallagher', 1, '-M-J--- (10:30-11:15) SGW 201', 'FALL 2014', '20140901', 0, 30),
(118, 'SOEN 106', 1, 'Prof Galchenyuk', 1, '--M-V-- (10:30-11:15) SGW 201', 'FALL 2014', '20140901', 0, 20),
(119, 'SOEN 201', 1, 'Prof Pacioretty', 1, '-M-J--- (10:30-11:15) SGW 201', 'FALL 2014', '20140901', 113, 20),
(120, 'SOEN 202', 1, 'Prof Tokarski', 1, '--M-V-- (10:30-11:15) SGW 201', 'FALL 2014', '20140901', 114, 20),
(121, 'SOEN 203', 1, 'Prof Desharnais', 1, '-M-J--- (13:30-14:15) SGW 201', 'FALL 2014', '20140901', 115, 20),
(122, 'SOEN 204', 1, 'Prof Eller', 1, '--M-V-- (13:30-14:15) SGW 201', 'FALL 2014', '20140901', 116, 20),
(123, 'SOEN 205', 1, 'Prof Parenteau', 1, '-M-J--- (10:30-11:15) SGW 201', 'FALL 2014', '20140901', 117, 20),
(124, 'SOEN 206', 1, 'Prof Prust', 1, '--M-V-- (10:30-11:15) SGW 201', 'FALL 2014', '20140901', 118, 20);
/*!40000 ALTER TABLE `courseoffered` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-26 23:01:41
