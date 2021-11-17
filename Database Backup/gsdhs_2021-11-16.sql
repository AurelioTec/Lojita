-- MariaDB dump 10.17  Distrib 10.4.8-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: lojita
-- ------------------------------------------------------
-- Server version	10.4.8-MariaDB

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
-- Current Database: `lojita`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `lojita` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `lojita`;

--
-- Table structure for table `tbcliente`
--

DROP TABLE IF EXISTS `tbcliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbcliente` (
  `idcliente` int(11) NOT NULL AUTO_INCREMENT,
  `clinome` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cliendereco` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `clibairro` varchar(80) COLLATE utf8_unicode_ci DEFAULT NULL,
  `clicidade` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `clitelefone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbcliente`
--

LOCK TABLES `tbcliente` WRITE;
/*!40000 ALTER TABLE `tbcliente` DISABLE KEYS */;
INSERT INTO `tbcliente` VALUES (1,'Mario Jacinto','rua das malhadas','Benfica','Benguela','999999999'),(2,'Manuel Vicente Neto','Morro das Cegonhas','Barricada','Onolulu','932000234');
/*!40000 ALTER TABLE `tbcliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbformapagamento`
--

DROP TABLE IF EXISTS `tbformapagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbformapagamento` (
  `idformpag` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricaopag` varchar(80) DEFAULT NULL,
  `descontopag` double DEFAULT NULL,
  `parcelaspag` int(11) DEFAULT NULL,
  `situacao` int(11) DEFAULT NULL,
  PRIMARY KEY (`idformpag`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbformapagamento`
--

LOCK TABLES `tbformapagamento` WRITE;
/*!40000 ALTER TABLE `tbformapagamento` DISABLE KEYS */;
INSERT INTO `tbformapagamento` VALUES (1,'A vista',0,1,1);
/*!40000 ALTER TABLE `tbformapagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbitensvenda`
--

DROP TABLE IF EXISTS `tbitensvenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbitensvenda` (
  `iditensvenda` int(11) NOT NULL AUTO_INCREMENT,
  `codproduto` int(11) DEFAULT NULL,
  `codvenda` int(11) DEFAULT NULL,
  `itensvalor` double(7,2) DEFAULT NULL,
  `itensqtd` int(11) DEFAULT NULL,
  PRIMARY KEY (`iditensvenda`),
  KEY `fk_tbitensvenda_codproduto_idx` (`codproduto`),
  KEY `fk_tbitensvenda_codvenda` (`codvenda`),
  CONSTRAINT `fk_tbitensvenda_codproduto` FOREIGN KEY (`codproduto`) REFERENCES `tbproduto` (`idproduto`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tbitensvenda_codvenda` FOREIGN KEY (`codvenda`) REFERENCES `tbvenda` (`idvenda`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbitensvenda`
--

LOCK TABLES `tbitensvenda` WRITE;
/*!40000 ALTER TABLE `tbitensvenda` DISABLE KEYS */;
INSERT INTO `tbitensvenda` VALUES (29,4,10,40000.00,1),(30,3,10,4000.00,3),(31,1,10,3000.00,2),(34,1,11,3000.00,2),(35,2,12,58000.00,2),(36,4,13,40000.00,1),(37,4,16,40000.00,1),(38,1,17,3000.00,2),(39,3,17,4000.00,1),(40,6,17,8000.00,1),(41,2,18,58000.00,2),(42,1,18,3000.00,1),(43,2,19,58000.00,1),(44,2,19,58000.00,1),(45,2,20,58000.00,1),(55,3,28,4000.00,2),(56,2,28,58000.00,1),(57,3,29,4000.00,2),(58,6,30,8000.00,1),(59,6,31,8000.00,1),(60,2,32,58000.00,1),(61,3,33,4000.00,1),(62,3,33,4000.00,1),(63,6,34,8000.00,2),(64,3,34,4000.00,1),(65,2,34,58000.00,1),(66,3,35,4000.00,1),(67,1,35,3000.00,1);
/*!40000 ALTER TABLE `tbitensvenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbproduto`
--

DROP TABLE IF EXISTS `tbproduto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbproduto` (
  `idproduto` int(11) NOT NULL AUTO_INCREMENT,
  `pronome` varchar(80) COLLATE utf8_unicode_ci DEFAULT NULL,
  `provalor` double DEFAULT NULL,
  `proestoque` int(11) DEFAULT NULL,
  PRIMARY KEY (`idproduto`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbproduto`
--

LOCK TABLES `tbproduto` WRITE;
/*!40000 ALTER TABLE `tbproduto` DISABLE KEYS */;
INSERT INTO `tbproduto` VALUES (1,'Resma A4',3000,-1),(2,'Tonner 85A',58000,-4),(3,'Agrafador Stiffer',4000,19),(4,'Impressora LaserJect 4300',40000,15),(6,'Tinteiro HP 2012',8000,11);
/*!40000 ALTER TABLE `tbproduto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbusuario`
--

DROP TABLE IF EXISTS `tbusuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbusuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `nomeusu` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `login` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
  `senha` varchar(80) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbusuario`
--

LOCK TABLES `tbusuario` WRITE;
/*!40000 ALTER TABLE `tbusuario` DISABLE KEYS */;
INSERT INTO `tbusuario` VALUES (1,'Fabio Aurelio','admin@admin','123456'),(2,'José Francisco','jose.francisco','francisco1'),(3,'Paulo Teodoro','paulo.teodoro','teodoro1'),(5,'Aurelio Jose','aurelio.jose','aurelio1');
/*!40000 ALTER TABLE `tbusuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbvenda`
--

DROP TABLE IF EXISTS `tbvenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbvenda` (
  `idvenda` int(11) NOT NULL AUTO_INCREMENT,
  `idcliente` int(11) DEFAULT NULL,
  `datavenda` date DEFAULT current_timestamp(),
  `valor` double(10,2) DEFAULT NULL,
  `valortotal` double(10,2) DEFAULT NULL,
  `desconto` float(2,2) DEFAULT NULL,
  PRIMARY KEY (`idvenda`),
  KEY `fk_tbvendacliente_idcliente` (`idcliente`),
  CONSTRAINT `fk_tbvendacliente_idcliente` FOREIGN KEY (`idcliente`) REFERENCES `tbcliente` (`idcliente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbvenda`
--

LOCK TABLES `tbvenda` WRITE;
/*!40000 ALTER TABLE `tbvenda` DISABLE KEYS */;
INSERT INTO `tbvenda` VALUES (2,2,'2021-10-14',1000.00,1000.00,0.00),(7,2,'2021-10-15',72000.00,72000.00,0.00),(10,1,'2021-10-18',58000.00,58000.00,0.00),(11,2,'2021-10-18',6000.00,6000.00,0.00),(12,1,'2021-10-19',116000.00,116000.00,0.00),(13,2,'2021-10-19',40000.00,40000.00,0.00),(16,2,'2021-10-22',40000.00,40000.00,0.00),(17,2,'2021-10-24',18000.00,18000.00,0.00),(18,1,'2021-10-26',119000.00,119000.00,0.00),(19,1,'2021-10-26',58000.00,58000.00,0.00),(20,1,'2021-10-26',58000.00,58000.00,0.00),(28,2,'2021-11-12',66000.00,66000.00,0.00),(29,2,'2021-11-12',8000.00,8000.00,0.00),(30,1,'2021-11-12',8000.00,8000.00,0.00),(31,1,'2021-11-12',8000.00,8000.00,0.00),(32,1,'2021-11-12',58000.00,58000.00,0.00),(33,1,'2021-11-12',4000.00,4000.00,0.00),(34,2,'2021-11-12',78000.00,78000.00,0.00),(35,1,'2021-11-12',7000.00,7000.00,0.00);
/*!40000 ALTER TABLE `tbvenda` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-16 13:38:00
