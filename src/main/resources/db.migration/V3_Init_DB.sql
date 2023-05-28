-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: hospitaldb
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `appointments`
--

DROP TABLE IF EXISTS `appointments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `procedures` varchar(255) DEFAULT NULL,
  `medications` varchar(255) DEFAULT NULL,
  `operations` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `status` varchar(45) DEFAULT 'appointed',
  `patient_Id_Appoint` int DEFAULT NULL,
  `nurse_Id` int DEFAULT NULL,
  `doctor_Id_Appoint` int DEFAULT NULL,
  `hospital_Card_Id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Id_UNIQUE` (`id`),
  KEY `Hospital_Card_Id` (`hospital_Card_Id`),
  KEY `Doctor_Id_idx` (`doctor_Id_Appoint`),
  KEY `Nurse_Id_idx` (`nurse_Id`),
  KEY `Patient_Id` (`patient_Id_Appoint`),
  CONSTRAINT `Doctor_Id_Appoint` FOREIGN KEY (`doctor_Id_Appoint`) REFERENCES `users` (`id`),
  CONSTRAINT `Hospital_Card_Id` FOREIGN KEY (`hospital_Card_Id`) REFERENCES `hospitalcards` (`id`),
  CONSTRAINT `Nurse_Id` FOREIGN KEY (`nurse_Id`) REFERENCES `users` (`id`),
  CONSTRAINT `Patient_Id_Appoint` FOREIGN KEY (`patient_Id_Appoint`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointments`
--

LOCK TABLES `appointments` WRITE;
/*!40000 ALTER TABLE `appointments` DISABLE KEYS */;
INSERT INTO `appointments` VALUES (6,'allied health treatments to improve, maintain or restore a person?s physical function, smth else.','Inhalers, pills',NULL,'2023-05-02','appointed',2,40,7,10),(8,'treatments to repair the effects of injury, disease or malfunctions, including medicines, physical and radiation therapies (therapeutic procedures)','','','2023-05-02','appointed',2,40,7,10),(9,'treatments to repair the effects of injury, disease or malfunctions, including medicines, physical and radiation therapies (therapeutic procedures)','','','2023-05-01','appointed',2,40,7,10),(12,'non-invasive scans – such as x-ray examinations, magnetic resonance imaging (MRI), ultrasound and computed tomography (CT)','',NULL,'2023-05-01','completed',2,40,NULL,10),(22,'endoscopy','pills',NULL,'2023-05-09','appointed',2,40,NULL,10),(23,'physical therapies','',NULL,'2023-05-18','appointed',2,40,NULL,10),(25,'','pills',NULL,'2023-05-24','appointed',2,40,NULL,10),(26,'test','adsf',NULL,'2023-05-31','appointed',2,40,NULL,10);
/*!40000 ALTER TABLE `appointments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name_Category` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Neurology'),(2,'Anesthesiology'),(3,'Dermatology'),(4,'Allergy and immunology'),(5,'Family medicine'),(6,'Ophthalmology'),(7,'Pediatrics'),(8,'Psychiatry'),(9,'Surgery');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospitalcards`
--

DROP TABLE IF EXISTS `hospitalcards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hospitalcards` (
  `id` int NOT NULL AUTO_INCREMENT,
  `discharged` varchar(45) DEFAULT 'false',
  `doctor_Id` int DEFAULT NULL,
  `patient_Id` int DEFAULT NULL,
  `preliminary_diagnosis` varchar(200) DEFAULT NULL,
  `clinical_diagnosis` varchar(200) DEFAULT NULL,
  `final_diagnosis` varchar(200) DEFAULT NULL,
  `nurse_Id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Id_UNIQUE` (`id`),
  KEY `Patient_Id` (`patient_Id`),
  KEY `Doctor_Id_idx` (`doctor_Id`),
  KEY `Nurse_Id_idx` (`nurse_Id`),
  CONSTRAINT `Doctor_Id` FOREIGN KEY (`doctor_Id`) REFERENCES `users` (`id`),
  CONSTRAINT `nurse_Id_Hospital_Card` FOREIGN KEY (`nurse_Id`) REFERENCES `users` (`id`),
  CONSTRAINT `Patient_Id` FOREIGN KEY (`patient_Id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospitalcards`
--

LOCK TABLES `hospitalcards` WRITE;
/*!40000 ALTER TABLE `hospitalcards` DISABLE KEYS */;
INSERT INTO `hospitalcards` VALUES (1,'false',28,3,'Asthma',NULL,NULL,40),(2,'false',28,3,'Seasonal allergies',NULL,NULL,NULL),(4,'false',28,3,'Osteoporosis','','',40),(6,'false',28,3,'Bronchitis','','',NULL),(10,'true',3,2,'Allergic rhinitis.','pop123','123123',3),(13,'false',3,2,'Astma','pop','123',3),(14,'false',46,45,'Плохое самочуствие','Хандра','Выгорание',40),(15,'false',7,45,'Простуда','Ринит','Синусит',40);
/*!40000 ALTER TABLE `hospitalcards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_Name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'admin'),(2,'user'),(3,'nurse'),(4,'patient'),(5,'doctor');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_Name` varchar(45) DEFAULT NULL,
  `last_Name` varchar(45) DEFAULT NULL,
  `date_Of_Birth` date DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone_Number` varchar(45) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `user_Name` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `category_Id` int DEFAULT NULL,
  `role_Id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `Category_Id_idx` (`category_Id`),
  KEY `Role_Id_idx` (`role_Id`),
  CONSTRAINT `Category_Id` FOREIGN KEY (`category_Id`) REFERENCES `categories` (`id`),
  CONSTRAINT `Role_Id` FOREIGN KEY (`role_Id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (2,'Janet ','Taylor','2000-02-29','Taylor2@gmail.com','+3698520478','FALSE PASS AK 99583-9800 USA',NULL,NULL,NULL,4),(3,'Pavel','Sergeev','1989-05-03','Sergeev@gmail.com','+96584225554',' BOX 81 FALSE PASS AK 99583-0081 USA','pavel123','$2a$10$33FGZps2D.bSMl.gr/r68O3Y.XNbF48c1Syf6yMOx1C26ThFvxakC',NULL,3),(4,'Tom','Pearson','1995-05-11','Pearson@gmail.com','+32458545214','DELIVERY MEKORYUK AK 99630-9999 USA',NULL,NULL,NULL,4),(5,'Linda ','Carter','2000-05-04','Carter@gmail.com','+5562455263','1 MAIN MEKORYUK AK 99630-9800 USA','258','$2a$10$2j5e3bniDmnfSiAOIGYrgeUcOZFSfZcW/hYhnfe8jycSVB8Ln0jQ6',3,5),(7,'Jerry ','Ford','2006-05-18','Ford@gmail.com','+55489656565','301 RHODES LEE KEYSVILLE GA 30816-4448 USA','258','$2a$10$8H1EsfaICCVCwkwvt9Fl/ejp6X3iXYAOHcEXK806JIzAnjxMPgQBG',3,5),(13,'Olga','Piha','1993-12-27','bonda1122@gmail.com','+5876531255','UMIAK FALSE PASS AK 99583-9800 USA',NULL,NULL,NULL,4),(16,'Anna','Petrova','2018-05-06','petrova@gmail.com','+5656598989','DELIVERY MEKORYUK AK 99630-9999 USA','petrova','$2a$10$U/YQfwLPlLR/VoaxPrEnueinpYXxPZj65BVGI6FbzFo/IAMZb/va.',2,5),(28,'Admin','Admin','2019-05-10','admin@gmail.com','+5455211144','admin address','123','$2a$10$NgV83nshmik5kzS.ChLjCO2d11OONDgAi8Gp7IP51sd/R4o4YyCSi',NULL,1),(40,'Анна','Гудвин','1968-05-01','nurse@gmail.com','+5455211144','KEYSVILLE GA 30816-4448 USA','nurse','$2a$10$BCkwDvj3Pit8qjLU01cf/.I8Rkyqf5Ta4dlDiyrFjqP52Z0NMc3BS',NULL,3),(43,'Admin','Admin','2015-06-24','admin@gmail.com','+5455211144','MEKORYUK AK 99630-9999 USA','Admin123','$2a$10$p3B0Hcha9cGgN8mvRgd15u.zZATp4iThvI5I75lGbHU3v1rIy0gqi',NULL,1),(44,'Stepan','Stepanov','2023-05-12','123@adf.re','+6456456456','sdadas','Stepan','$2a$10$fY/Mv5HXstqFy4Q9h5ktQuhF3a0XunK8XnCP3Ek8Mw1QqhCtmXk3u',NULL,3),(45,'Павел','Шевченко','1977-05-05','thipav@gmail.com','+5455211144','Ukraine, Kyiv',NULL,NULL,NULL,4),(46,'Leonid','Picaso','1986-04-27','qwe23@av.com','+86456456456','DELIVERY MEKORYUK AK 99630-9999 USA','doctor','$2a$10$/PSdK1eRbv5azHl2Fb/HpOK7Bgjw8fiwGxFfCGyoupS3ot4NuHY2y',7,5);
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

-- Dump completed on 2023-05-28 10:35:10
