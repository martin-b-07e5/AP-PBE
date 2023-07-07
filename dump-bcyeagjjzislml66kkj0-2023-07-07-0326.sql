-- MariaDB dump 10.19  Distrib 10.11.3-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: bcyeagjjzislml66kkj0
-- ------------------------------------------------------
-- Server version	10.11.3-MariaDB-1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `education`
--

DROP TABLE IF EXISTS `education`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `education` (
  `id_education` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` date DEFAULT NULL,
  `description` varchar(160) DEFAULT NULL,
  `name` varchar(60) DEFAULT NULL,
  `finished_at` date DEFAULT NULL,
  `started_at` date DEFAULT NULL,
  PRIMARY KEY (`id_education`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education`
--

LOCK TABLES `education` WRITE;
/*!40000 ALTER TABLE `education` DISABLE KEYS */;
INSERT INTO `education` VALUES
(1,'2023-01-08','Terciaria','Analista en Sistemas de Computación','2010-12-16','2008-03-15'),
(2,'2023-01-08','HTML, CSS, Javascript','Introducción a la Programación. (1 mes)','2022-01-02','2021-01-01'),
(3,'2023-01-08','Python, Django','Programación y Desarrollo Web. (240hs)','2021-10-30','2021-07-01'),
(4,'2023-01-08','Bases de Datos (MER, SQL, Git)','Programación y Desarrollo Web. (4 meses)','2021-10-30','2021-07-01'),
(5,'2023-01-08','React','Especialización en tecnologías de desarrollo. (4 meses)','2022-07-21','2022-04-01'),
(6,'2023-01-08','Testing (basado en certificación CTFL_2018-ISTQB)','Especialización en tecnologías de desarrollo. (4 meses)','2022-07-21','2022-04-01'),
(7,'2023-01-08','JAVA (Spring, JUnit, Mockito)','Especialización en tecnologías de desarrollo. (4 meses)','2022-07-21','2022-04-01');
/*!40000 ALTER TABLE `education` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `experience`
--

DROP TABLE IF EXISTS `experience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `experience` (
  `id_experience` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` date DEFAULT NULL,
  `description` varchar(160) DEFAULT NULL,
  `name` varchar(60) DEFAULT NULL,
  `finished_at` date DEFAULT NULL,
  `started_at` date DEFAULT NULL,
  PRIMARY KEY (`id_experience`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experience`
--

LOCK TABLES `experience` WRITE;
/*!40000 ALTER TABLE `experience` DISABLE KEYS */;
INSERT INTO `experience` VALUES
(1,'2023-01-10','System administrator, E-Commerce','Freelance','2023-07-07','2013-01-01'),
(2,'2023-01-10','System administrator','Ghiggeri','2012-12-01','2012-01-01'),
(3,'2023-01-10','System administrator, E-Commerce','ETG','2009-07-27','2007-03-13'),
(4,'2023-01-10','System administrator','Osprera','2007-01-14','2006-03-01');
/*!40000 ALTER TABLE `experience` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `id_person` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `published_at` date DEFAULT NULL,
  `id_project` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_person`),
  KEY `FKeulhmx4okyir32p3a1r6tue3s` (`id_project`),
  CONSTRAINT `FKeulhmx4okyir32p3a1r6tue3s` FOREIGN KEY (`id_project`) REFERENCES `project` (`id_project`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES
(1,'martin.bergagno@gmail.com','Martín','Bergagno','2023-01-08',1),
(2,'homero@simpson.com','Homero','Simpson','2023-01-08',1),
(3,'marge@simpson.com','Marge','Simpson','2023-01-08',1),
(4,'bart@simpson.com','Bart','Simpson','2023-01-08',1),
(5,'lisa@simpson.com','Lisa','Simpson','2023-01-08',1),
(6,'maggie@simpson.com','Maggie','Simpson','2023-01-08',1);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_education`
--

DROP TABLE IF EXISTS `person_education`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person_education` (
  `id_person` bigint(20) NOT NULL,
  `id_education` bigint(20) NOT NULL,
  PRIMARY KEY (`id_person`,`id_education`),
  KEY `FKmb6jsraynrx68fs7nuyr8b73w` (`id_education`),
  CONSTRAINT `FKmb6jsraynrx68fs7nuyr8b73w` FOREIGN KEY (`id_education`) REFERENCES `education` (`id_education`),
  CONSTRAINT `FKs1u71dtrlft7xqnckhut46jj5` FOREIGN KEY (`id_person`) REFERENCES `person` (`id_person`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_education`
--

LOCK TABLES `person_education` WRITE;
/*!40000 ALTER TABLE `person_education` DISABLE KEYS */;
INSERT INTO `person_education` VALUES
(1,1);
/*!40000 ALTER TABLE `person_education` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_experience`
--

DROP TABLE IF EXISTS `person_experience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person_experience` (
  `id_person` bigint(20) NOT NULL,
  `id_experience` bigint(20) NOT NULL,
  PRIMARY KEY (`id_person`,`id_experience`),
  KEY `FKsjehxd2g9t3uvto8prhxdr3wj` (`id_experience`),
  CONSTRAINT `FKeq5t8muum3b75mr0m3ycy6fpn` FOREIGN KEY (`id_person`) REFERENCES `person` (`id_person`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKsjehxd2g9t3uvto8prhxdr3wj` FOREIGN KEY (`id_experience`) REFERENCES `experience` (`id_experience`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_experience`
--

LOCK TABLES `person_experience` WRITE;
/*!40000 ALTER TABLE `person_experience` DISABLE KEYS */;
INSERT INTO `person_experience` VALUES
(1,1),
(1,2);
/*!40000 ALTER TABLE `person_experience` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_technology`
--

DROP TABLE IF EXISTS `person_technology`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person_technology` (
  `id_person` bigint(20) NOT NULL,
  `id_technology` bigint(20) NOT NULL,
  PRIMARY KEY (`id_person`,`id_technology`),
  KEY `FK7cglyl4fsgbynkaj2mgsvs9b8` (`id_technology`),
  CONSTRAINT `FK7cglyl4fsgbynkaj2mgsvs9b8` FOREIGN KEY (`id_technology`) REFERENCES `technology` (`id_technology`),
  CONSTRAINT `FKio6emitnvhc42dct6htxp1f7y` FOREIGN KEY (`id_person`) REFERENCES `person` (`id_person`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_technology`
--

LOCK TABLES `person_technology` WRITE;
/*!40000 ALTER TABLE `person_technology` DISABLE KEYS */;
INSERT INTO `person_technology` VALUES
(1,8);
/*!40000 ALTER TABLE `person_technology` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `id_project` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_project`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES
(1,'2023-01-08','ONU - THE 17 GOALS | Sustainable Development','Python Blog'),
(2,'2023-07-07','react2022--movies-react-v6--debounce','Movies - React'),
(3,'2023-07-07','react2022-news-app-v0.2.5.1--TFinal Public','News - React');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `technology`
--

DROP TABLE IF EXISTS `technology`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `technology` (
  `id_technology` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` date DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `percentage` int(11) NOT NULL,
  PRIMARY KEY (`id_technology`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `technology`
--

LOCK TABLES `technology` WRITE;
/*!40000 ALTER TABLE `technology` DISABLE KEYS */;
INSERT INTO `technology` VALUES
(1,'2023-01-08','html','html',40),
(2,'2023-01-08','css','css',30),
(3,'2023-01-08','javaScript','js',30),
(4,'2023-01-08','Phyton','Python',30),
(5,'2023-01-08','Django','Django',30),
(6,'2023-01-08','SQL','SQL, mysql, mariaDB',60),
(7,'2023-01-08','Testing','based on CTFL 2018 - ISTQB',30),
(8,'2023-01-08','Java','Java',40),
(9,'2023-01-08','Spring','spring boot, spring jpa',40),
(10,'2023-01-08','Junit & Mockito','Test with Java SpringBoot & JPA',30),
(11,'2023-01-08','React + testing','React + Jest',35),
(12,'2023-01-08','angular, java+spring','angular, java+spring',40);
/*!40000 ALTER TABLE `technology` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'bcyeagjjzislml66kkj0'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-07  3:26:01
