-- MySQL dump 10.13  Distrib 5.7.44, for Win64 (x86_64)
--
-- Host: localhost    Database: bkp_clinica
-- ------------------------------------------------------
-- Server version	5.7.44-log

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
-- Current Database: `bkp_clinica`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `bkp_clinica` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `bkp_clinica`;

--
-- Table structure for table `log_agendamento`
--

DROP TABLE IF EXISTS `log_agendamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log_agendamento` (
  `IDLog` int(11) NOT NULL AUTO_INCREMENT,
  `Dia` date NOT NULL,
  `TipoConsulta` enum('Convenio','Particular','Retorno') NOT NULL,
  `OBSERVACOES` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IDLog`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_agendamento`
--

LOCK TABLES `log_agendamento` WRITE;
/*!40000 ALTER TABLE `log_agendamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `log_agendamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_atendente`
--

DROP TABLE IF EXISTS `log_atendente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log_atendente` (
  `IDLog` int(11) NOT NULL AUTO_INCREMENT,
  `IDAtendente` int(11) NOT NULL,
  `Telefone` char(9) NOT NULL,
  `CPF` varchar(11) NOT NULL,
  `Email` varchar(150) NOT NULL,
  `Nome` varchar(70) NOT NULL,
  PRIMARY KEY (`IDLog`),
  UNIQUE KEY `CPF` (`CPF`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_atendente`
--

LOCK TABLES `log_atendente` WRITE;
/*!40000 ALTER TABLE `log_atendente` DISABLE KEYS */;
/*!40000 ALTER TABLE `log_atendente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_convenio`
--

DROP TABLE IF EXISTS `log_convenio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log_convenio` (
  `IDLog` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(100) NOT NULL,
  `CNPJ` varchar(14) NOT NULL,
  PRIMARY KEY (`IDLog`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_convenio`
--

LOCK TABLES `log_convenio` WRITE;
/*!40000 ALTER TABLE `log_convenio` DISABLE KEYS */;
/*!40000 ALTER TABLE `log_convenio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_medico`
--

DROP TABLE IF EXISTS `log_medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log_medico` (
  `IDLog` int(11) NOT NULL AUTO_INCREMENT,
  `IDMedico` int(11) NOT NULL,
  `Telefone` varchar(9) NOT NULL,
  `CPF` varchar(11) NOT NULL,
  `Email` varchar(150) NOT NULL,
  `Nome` varchar(70) NOT NULL,
  PRIMARY KEY (`IDLog`),
  UNIQUE KEY `CPF` (`CPF`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_medico`
--

LOCK TABLES `log_medico` WRITE;
/*!40000 ALTER TABLE `log_medico` DISABLE KEYS */;
/*!40000 ALTER TABLE `log_medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_paciente`
--

DROP TABLE IF EXISTS `log_paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log_paciente` (
  `IDLog` int(11) NOT NULL AUTO_INCREMENT,
  `IDPaciente` int(11) NOT NULL,
  `Telefone` varchar(9) NOT NULL,
  `CPF` varchar(11) NOT NULL,
  `email` varchar(150) NOT NULL,
  `Nome` varchar(70) NOT NULL,
  PRIMARY KEY (`IDLog`),
  UNIQUE KEY `CPF` (`CPF`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_paciente`
--

LOCK TABLES `log_paciente` WRITE;
/*!40000 ALTER TABLE `log_paciente` DISABLE KEYS */;
/*!40000 ALTER TABLE `log_paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `clinica`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `clinica` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `clinica`;

--
-- Table structure for table `agendamento`
--

DROP TABLE IF EXISTS `agendamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agendamento` (
  `IDAgendamento` int(11) NOT NULL AUTO_INCREMENT,
  `IDPaciente` int(11) NOT NULL,
  `IDMedico` int(11) NOT NULL,
  `Dia` date NOT NULL,
  `TipoConsulta` enum('Convenio','Particular','Retorno') NOT NULL,
  `OBSERVACOES` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IDAgendamento`),
  KEY `IDPaciente` (`IDPaciente`),
  KEY `fk_agendamento_medico` (`IDMedico`),
  CONSTRAINT `agendamento_ibfk_1` FOREIGN KEY (`IDPaciente`) REFERENCES `paciente` (`IDPaciente`),
  CONSTRAINT `fk_agendamento_medico` FOREIGN KEY (`IDMedico`) REFERENCES `medico` (`IDMedico`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agendamento`
--

LOCK TABLES `agendamento` WRITE;
/*!40000 ALTER TABLE `agendamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `agendamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atendente`
--

DROP TABLE IF EXISTS `atendente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atendente` (
  `IDAtendente` int(11) NOT NULL AUTO_INCREMENT,
  `Telefone` char(9) NOT NULL,
  `CPF` varchar(11) NOT NULL,
  `sexo` enum('M','F') NOT NULL,
  `Email` varchar(150) NOT NULL,
  `Nome` varchar(70) NOT NULL,
  `Senha` varchar(50) NOT NULL,
  `IDUser` int(11) NOT NULL,
  PRIMARY KEY (`IDAtendente`),
  UNIQUE KEY `CPF` (`CPF`),
  KEY `IDUser` (`IDUser`),
  CONSTRAINT `atendente_ibfk_1` FOREIGN KEY (`IDUser`) REFERENCES `login` (`IDUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atendente`
--

LOCK TABLES `atendente` WRITE;
/*!40000 ALTER TABLE `atendente` DISABLE KEYS */;
/*!40000 ALTER TABLE `atendente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `convenio`
--

DROP TABLE IF EXISTS `convenio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `convenio` (
  `IDConvenio` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(100) NOT NULL,
  `DataInicio` date NOT NULL,
  `DataTermino` date NOT NULL,
  `CNPJ` varchar(14) NOT NULL,
  PRIMARY KEY (`IDConvenio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `convenio`
--

LOCK TABLES `convenio` WRITE;
/*!40000 ALTER TABLE `convenio` DISABLE KEYS */;
/*!40000 ALTER TABLE `convenio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `IDUser` int(11) NOT NULL AUTO_INCREMENT,
  `Usuario` varchar(15) NOT NULL,
  PRIMARY KEY (`IDUser`),
  UNIQUE KEY `Usuario` (`Usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medico`
--

DROP TABLE IF EXISTS `medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medico` (
  `IDMedico` int(11) NOT NULL AUTO_INCREMENT,
  `IDAgendamento` int(11) DEFAULT NULL,
  `Telefone` varchar(9) NOT NULL,
  `CPF` varchar(11) NOT NULL,
  `Sexo` enum('M','F') NOT NULL,
  `Email` varchar(150) NOT NULL,
  `Nome` varchar(70) NOT NULL,
  `Senha` varchar(50) NOT NULL,
  `IDUser` int(11) NOT NULL,
  `especialidade` varchar(50) NOT NULL,
  PRIMARY KEY (`IDMedico`),
  UNIQUE KEY `CPF` (`CPF`),
  UNIQUE KEY `Email` (`Email`),
  UNIQUE KEY `Senha` (`Senha`),
  UNIQUE KEY `IDUser` (`IDUser`),
  KEY `fk_medico_agendamento` (`IDAgendamento`),
  CONSTRAINT `fk_medico_agendamento` FOREIGN KEY (`IDAgendamento`) REFERENCES `agendamento` (`IDAgendamento`),
  CONSTRAINT `medico_ibfk_1` FOREIGN KEY (`IDUser`) REFERENCES `login` (`IDUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medico`
--

LOCK TABLES `medico` WRITE;
/*!40000 ALTER TABLE `medico` DISABLE KEYS */;
/*!40000 ALTER TABLE `medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paciente` (
  `IDPaciente` int(11) NOT NULL AUTO_INCREMENT,
  `Telefone` varchar(9) NOT NULL,
  `CPF` varchar(11) NOT NULL,
  `Sexo` enum('M','F') NOT NULL,
  `email` varchar(150) NOT NULL,
  `Nome` varchar(70) NOT NULL,
  `Nascimento` date NOT NULL,
  `IDProntuario` int(11) DEFAULT NULL,
  `IDConvenio` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDPaciente`),
  UNIQUE KEY `CPF` (`CPF`),
  UNIQUE KEY `email` (`email`),
  KEY `IDProntuario` (`IDProntuario`),
  KEY `IDConvenio` (`IDConvenio`),
  CONSTRAINT `paciente_ibfk_1` FOREIGN KEY (`IDProntuario`) REFERENCES `prontuario` (`IDProntuario`),
  CONSTRAINT `paciente_ibfk_2` FOREIGN KEY (`IDConvenio`) REFERENCES `convenio` (`IDConvenio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prontuario`
--

DROP TABLE IF EXISTS `prontuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prontuario` (
  `IDProntuario` int(11) NOT NULL AUTO_INCREMENT,
  `Historico` varchar(255) NOT NULL,
  `Receituario` varchar(255) NOT NULL,
  `Exames` varchar(255) NOT NULL,
  PRIMARY KEY (`IDProntuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prontuario`
--

LOCK TABLES `prontuario` WRITE;
/*!40000 ALTER TABLE `prontuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `prontuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-30  9:29:50
