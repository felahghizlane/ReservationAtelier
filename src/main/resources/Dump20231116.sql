-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ateliers_reservation
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `artisan`
--

DROP TABLE IF EXISTS `artisan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artisan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `téléphone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artisan`
--

LOCK TABLES `artisan` WRITE;
/*!40000 ALTER TABLE `artisan` DISABLE KEYS */;
INSERT INTO `artisan` VALUES (1,'Alice Dupont','alice.dupont@example.com','0123456789'),(2,'Bob Martin','bob.martin@example.com','0987654321');
/*!40000 ALTER TABLE `artisan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atelier`
--

DROP TABLE IF EXISTS `atelier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atelier` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `description` text,
  `date` date NOT NULL,
  `capacité` int NOT NULL,
  `artisan_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `artisan_id` (`artisan_id`),
  CONSTRAINT `atelier_ibfk_1` FOREIGN KEY (`artisan_id`) REFERENCES `artisan` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atelier`
--

LOCK TABLES `atelier` WRITE;
/*!40000 ALTER TABLE `atelier` DISABLE KEYS */;
INSERT INTO `atelier` VALUES (1,'Atelier de Poterie','Apprenez à faire des poteries.','2023-12-10',10,1),(2,'Cours de Peinture','Cours de peinture pour débutants.','2023-12-15',15,2);
/*!40000 ALTER TABLE `atelier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creneau`
--

DROP TABLE IF EXISTS `creneau`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `creneau` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dateHeureDebut` datetime DEFAULT NULL,
  `atelier_id` bigint DEFAULT NULL,
  `dateHeureFin` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg14dlb2mrhyfktmwq6l2sh8nk` (`atelier_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creneau`
--

LOCK TABLES `creneau` WRITE;
/*!40000 ALTER TABLE `creneau` DISABLE KEYS */;
INSERT INTO `creneau` VALUES (1,'2023-11-15 09:00:00',1,'2023-11-15 11:00:00'),(2,'2023-11-16 14:00:00',2,'2023-11-16 16:00:00'),(3,'2023-11-18 09:00:00',1,'2023-11-18 11:00:00'),(4,'2023-11-20 09:00:00',1,'2023-11-20 11:00:00'),(5,'2023-11-20 13:00:00',1,'2023-11-20 15:00:00'),(6,'2023-11-21 10:00:00',2,'2023-11-21 11:00:00'),(7,'2023-11-23 12:00:00',2,'2023-11-23 14:00:00'),(8,'2023-11-19 14:00:00',2,'2023-11-19 16:00:00');
/*!40000 ALTER TABLE `creneau` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participant`
--

DROP TABLE IF EXISTS `participant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participant` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `téléphone` varchar(20) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participant`
--

LOCK TABLES `participant` WRITE;
/*!40000 ALTER TABLE `participant` DISABLE KEYS */;
INSERT INTO `participant` VALUES (1,'Charles Leclerc','charles.leclerc@example.com','0234567890',NULL),(2,'Danielle Moreau','danielle.moreau@example.com','0321654987',NULL);
/*!40000 ALTER TABLE `participant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `atelier_id` bigint DEFAULT NULL,
  `participant_id` bigint DEFAULT NULL,
  `dateReservation` datetime DEFAULT NULL,
  `creneau_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgt10xeqt8xb9p8ru6968ah5s2` (`atelier_id`),
  KEY `FKml8qpe1fym08f50p5c60w6e5i` (`creneau_id`),
  KEY `FKjda6c2xe6rdhsrm4emj8pewc9` (`participant_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (3,2,1,'2023-11-16 02:32:41',2),(4,1,2,'2023-11-16 03:31:53',1);
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservationdto`
--

DROP TABLE IF EXISTS `reservationdto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservationdto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dateReservation` datetime DEFAULT NULL,
  `atelier_id` bigint DEFAULT NULL,
  `creneau_id` bigint DEFAULT NULL,
  `participant_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2015fgyjrxnblho883cg8xrk3` (`atelier_id`),
  KEY `FKjtid5cy7eqv2iavkgc5teh2kn` (`creneau_id`),
  KEY `FKbji1t87go73wd7sghsiyt593y` (`participant_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservationdto`
--

LOCK TABLES `reservationdto` WRITE;
/*!40000 ALTER TABLE `reservationdto` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservationdto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-16 21:22:09
