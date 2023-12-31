-- MySQL dump 10.13  Distrib 5.7.44, for Win64 (x86_64)
--
-- Host: localhost    Database: clinica
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
  `observacoes` varchar(255) DEFAULT NULL,
  `hora` time NOT NULL,
  `IDConvenio` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDAgendamento`),
  KEY `IDPaciente` (`IDPaciente`),
  KEY `fk_agendamento_medico` (`IDMedico`),
  KEY `agendamento_convenio` (`IDConvenio`),
  CONSTRAINT `agendamento_convenio` FOREIGN KEY (`IDConvenio`) REFERENCES `convenio` (`IDConvenio`),
  CONSTRAINT `agendamento_ibfk_1` FOREIGN KEY (`IDPaciente`) REFERENCES `paciente` (`IDPaciente`),
  CONSTRAINT `fk_agendamento_medico` FOREIGN KEY (`IDMedico`) REFERENCES `medico` (`IDMedico`) ON DELETE CASCADE
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
  `IDAtendente` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `email` varchar(255) NOT NULL,
  `senha` varchar(70) DEFAULT NULL,
  `CPF` varchar(11) NOT NULL,
  `telefone` varchar(9) NOT NULL,
  `sexo` enum('M','F') NOT NULL,
  `nascimento` date NOT NULL,
  PRIMARY KEY (`IDAtendente`),
  UNIQUE KEY `IDAtendente` (`IDAtendente`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `CPF` (`CPF`),
  UNIQUE KEY `senha` (`senha`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atendente`
--

LOCK TABLES `atendente` WRITE;
/*!40000 ALTER TABLE `atendente` DISABLE KEYS */;
/*!40000 ALTER TABLE `atendente` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`clinica`@`localhost`*/ /*!50003 TRIGGER AFTERINSERT_ATENDENTE
AFTER INSERT
ON ATENDENTE FOR EACH ROW
INSERT INTO LOGIN (CPF, senha, cargo)
VALUES(NEW.CPF, NEW.senha, 'Atendente') */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
-- Table structure for table `especialidade`
--

DROP TABLE IF EXISTS `especialidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `especialidade` (
  `IDEspecialidade` int(11) NOT NULL,
  `especialidade` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`IDEspecialidade`),
  UNIQUE KEY `IDEspecialidade` (`IDEspecialidade`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especialidade`
--

LOCK TABLES `especialidade` WRITE;
/*!40000 ALTER TABLE `especialidade` DISABLE KEYS */;
/*!40000 ALTER TABLE `especialidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `IDLogin` int(11) NOT NULL,
  `CPF` varchar(11) NOT NULL,
  `SENHA` varchar(70) DEFAULT NULL,
  `CARGO` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`IDLogin`),
  UNIQUE KEY `IDLogin` (`IDLogin`),
  UNIQUE KEY `CPF` (`CPF`),
  UNIQUE KEY `senha` (`SENHA`)
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
  `SENHA` varchar(70) DEFAULT NULL,
  `IDEspecialidade` int(11) NOT NULL,
  `Nascimento` date DEFAULT NULL,
  PRIMARY KEY (`IDMedico`),
  UNIQUE KEY `CPF` (`CPF`),
  UNIQUE KEY `Email` (`Email`),
  UNIQUE KEY `Senha` (`SENHA`),
  KEY `fk_medico_agendamento` (`IDAgendamento`),
  KEY `med_espec` (`IDEspecialidade`),
  CONSTRAINT `fk_medico_agendamento` FOREIGN KEY (`IDAgendamento`) REFERENCES `agendamento` (`IDAgendamento`),
  CONSTRAINT `med_espec` FOREIGN KEY (`IDEspecialidade`) REFERENCES `especialidade` (`IDEspecialidade`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medico`
--

LOCK TABLES `medico` WRITE;
/*!40000 ALTER TABLE `medico` DISABLE KEYS */;
/*!40000 ALTER TABLE `medico` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`clinica`@`localhost`*/ /*!50003 TRIGGER AFTERINSERT_MEDICO
AFTER INSERT
ON MEDICO FOR EACH ROW
INSERT INTO LOGIN (CPF, senha, cargo)
VALUES(NEW.CPF, NEW.senha, 'Medico') */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
  `NomePaciente` varchar(255) DEFAULT NULL,
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

-- Dump completed on 2023-12-09 13:33:37
