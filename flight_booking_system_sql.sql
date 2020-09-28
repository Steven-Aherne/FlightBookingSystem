-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: flight_booking_system
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aeroplane`
--

DROP TABLE IF EXISTS `aeroplane`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `aeroplane` (
  `aeroplaneId` int(11) NOT NULL AUTO_INCREMENT,
  `pilotId` int(11) DEFAULT NULL,
  `NumberOSeatsAvailable` int(11) DEFAULT NULL,
  `NumberOfSeatsBooked` int(11) DEFAULT NULL,
  `Model` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`aeroplaneId`),
  KEY `poiletReference_idx` (`pilotId`),
  CONSTRAINT `poiletReference` FOREIGN KEY (`pilotId`) REFERENCES `pilot` (`pilotId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aeroplane`
--

LOCK TABLES `aeroplane` WRITE;
/*!40000 ALTER TABLE `aeroplane` DISABLE KEYS */;
INSERT INTO `aeroplane` VALUES (1,2,50,0,'Test1'),(2,3,44,0,'44'),(6,4,12,0,'1'),(7,2,2,0,'243K'),(8,2,5,0,'768'),(9,2,64,0,'12'),(10,2,6,0,'g'),(11,2,3,0,'d'),(12,5,56,0,'867');
/*!40000 ALTER TABLE `aeroplane` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `airport`
--

DROP TABLE IF EXISTS `airport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `airport` (
  `airportId` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `contactNumber` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`airportId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airport`
--

LOCK TABLES `airport` WRITE;
/*!40000 ALTER TABLE `airport` DISABLE KEYS */;
INSERT INTO `airport` VALUES (2,'112','112','112'),(3,'114','114','114');
/*!40000 ALTER TABLE `airport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bookings` (
  `bookingId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `tripId` int(11) DEFAULT NULL,
  `tickets` int(11) DEFAULT NULL,
  `bookingDate` datetime DEFAULT NULL,
  PRIMARY KEY (`bookingId`),
  KEY `userId_idx` (`userId`),
  KEY `tripId_idx` (`tripId`),
  CONSTRAINT `tripId` FOREIGN KEY (`tripId`) REFERENCES `trips` (`tripId`),
  CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings`
--

LOCK TABLES `bookings` WRITE;
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
INSERT INTO `bookings` VALUES (1,2,3,3,'2019-11-11 00:00:00'),(2,2,3,2,'2019-11-26 01:48:37'),(3,2,4,3,'2019-11-26 01:59:39'),(4,3,3,5,'2019-11-26 02:11:45'),(5,4,3,1,'2019-11-27 16:52:21');
/*!40000 ALTER TABLE `bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cities`
--

DROP TABLE IF EXISTS `cities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cities` (
  `cityId` int(11) NOT NULL AUTO_INCREMENT,
  `cityName` varchar(45) DEFAULT NULL,
  `airportId` int(11) DEFAULT NULL,
  PRIMARY KEY (`cityId`),
  KEY `airport_idx` (`airportId`),
  CONSTRAINT `airport` FOREIGN KEY (`airportId`) REFERENCES `airport` (`airportId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cities`
--

LOCK TABLES `cities` WRITE;
/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
INSERT INTO `cities` VALUES (1,'Test',2),(3,'Test2',2);
/*!40000 ALTER TABLE `cities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pilot`
--

DROP TABLE IF EXISTS `pilot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pilot` (
  `pilotId` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(45) DEFAULT NULL,
  `LastName` varchar(45) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `phoneNumber` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pilotId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pilot`
--

LOCK TABLES `pilot` WRITE;
/*!40000 ALTER TABLE `pilot` DISABLE KEYS */;
INSERT INTO `pilot` VALUES (2,'John','Lane','2017-06-15','0846780976'),(3,'Test3','Test3','2019-06-15','234'),(4,'Test22','Test2','2019-06-15','234'),(5,'Test4','Test4','2019-11-11','158');
/*!40000 ALTER TABLE `pilot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trips`
--

DROP TABLE IF EXISTS `trips`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `trips` (
  `tripId` int(11) NOT NULL AUTO_INCREMENT,
  `tripName` varchar(45) DEFAULT NULL,
  `fromCity` int(11) DEFAULT NULL,
  `toCity` int(11) DEFAULT NULL,
  `departureDate` date DEFAULT NULL,
  `departureTIme` varchar(45) DEFAULT NULL,
  `planeId` int(11) DEFAULT NULL,
  `notes` varchar(45) DEFAULT NULL,
  `ticketPrice` double DEFAULT NULL,
  PRIMARY KEY (`tripId`),
  KEY `planeId_idx` (`planeId`),
  KEY `toCity_idx` (`toCity`),
  KEY `Fromcity_idx` (`fromCity`),
  CONSTRAINT `Fromcity` FOREIGN KEY (`fromCity`) REFERENCES `cities` (`cityId`),
  CONSTRAINT `planeId` FOREIGN KEY (`planeId`) REFERENCES `aeroplane` (`aeroplaneId`),
  CONSTRAINT `toCity` FOREIGN KEY (`toCity`) REFERENCES `cities` (`cityId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trips`
--

LOCK TABLES `trips` WRITE;
/*!40000 ALTER TABLE `trips` DISABLE KEYS */;
INSERT INTO `trips` VALUES (3,'Test12',1,3,'2019-01-01','12:12 PM',1,'123.0',123),(4,'TESTTT2',3,1,'2018-11-01','12:11 PM',1,'1233.0',1233);
/*!40000 ALTER TABLE `trips` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `dob` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `userType` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userId`,`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Admin','Admin','Admin@gmail.com','ADMIN',NULL,'000','Admin'),(2,'Test1','Test1','Test@gmail.com','User','Test','111','User'),(3,'TT','TT','TT@gmail.com','TT','TT','TT','User'),(4,'John','Doe','John.Doe@mycit.ie','0000','16-10-1998','0874567654','User');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-28  2:36:29
