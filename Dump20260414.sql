-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: demabitesbd
-- ------------------------------------------------------
-- Server version	8.0.44

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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id_cliente` bigint NOT NULL AUTO_INCREMENT,
  `apellidoMaterno` varchar(30) NOT NULL,
  `apellidoPaterno` varchar(30) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientesfrecuentes`
--

DROP TABLE IF EXISTS `clientesfrecuentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientesfrecuentes` (
  `id_cliente` bigint NOT NULL AUTO_INCREMENT,
  `apellidoMaterno` varchar(30) NOT NULL,
  `apellidoPaterno` varchar(30) NOT NULL,
  `email` varchar(60) DEFAULT NULL,
  `fechaRegistro` date NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `telefono_encriptado` varchar(255) NOT NULL,
  `telefono_hash` varchar(64) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `telefono_hash` (`telefono_hash`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientesfrecuentes`
--

LOCK TABLES `clientesfrecuentes` WRITE;
/*!40000 ALTER TABLE `clientesfrecuentes` DISABLE KEYS */;
INSERT INTO `clientesfrecuentes` VALUES (1,'Tineo','Verdugo','','2026-04-14','Dario','lkrWoyiGpA2aS/qnIUYGDg==','f48a479eacd61e7d2d20d4855762695faeb322c13f3f764db920a1e8ccd3feb9');
/*!40000 ALTER TABLE `clientesfrecuentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comandas`
--

DROP TABLE IF EXISTS `comandas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comandas` (
  `id_comanda` bigint NOT NULL AUTO_INCREMENT,
  `estado` varchar(20) NOT NULL,
  `fecha_hora` datetime(3) NOT NULL,
  `folio` varchar(20) NOT NULL,
  `total` double NOT NULL,
  `id_cliente` bigint DEFAULT NULL,
  `id_mesa` bigint NOT NULL,
  PRIMARY KEY (`id_comanda`),
  UNIQUE KEY `folio` (`folio`),
  KEY `FK_comandas_id_mesa` (`id_mesa`),
  KEY `FK_comandas_id_cliente` (`id_cliente`),
  CONSTRAINT `FK_comandas_id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `clientesfrecuentes` (`id_cliente`),
  CONSTRAINT `FK_comandas_id_mesa` FOREIGN KEY (`id_mesa`) REFERENCES `mesas` (`id_mesa`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comandas`
--

LOCK TABLES `comandas` WRITE;
/*!40000 ALTER TABLE `comandas` DISABLE KEYS */;
INSERT INTO `comandas` VALUES (1,'ENTREGADA','2026-04-14 02:58:43.650','OB-20260414-001',40,NULL,1),(2,'ENTREGADA','2026-04-14 03:28:48.102','OB-20260414-002',40,1,1);
/*!40000 ALTER TABLE `comandas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalles_comanda`
--

DROP TABLE IF EXISTS `detalles_comanda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalles_comanda` (
  `id_detalle` bigint NOT NULL AUTO_INCREMENT,
  `cantidad` int NOT NULL,
  `comentarios` varchar(255) DEFAULT NULL,
  `precio_venta` double NOT NULL,
  `id_comanda` bigint NOT NULL,
  `id_producto` bigint NOT NULL,
  PRIMARY KEY (`id_detalle`),
  KEY `FK_detalles_comanda_id_comanda` (`id_comanda`),
  KEY `FK_detalles_comanda_id_producto` (`id_producto`),
  CONSTRAINT `FK_detalles_comanda_id_comanda` FOREIGN KEY (`id_comanda`) REFERENCES `comandas` (`id_comanda`),
  CONSTRAINT `FK_detalles_comanda_id_producto` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalles_comanda`
--

LOCK TABLES `detalles_comanda` WRITE;
/*!40000 ALTER TABLE `detalles_comanda` DISABLE KEYS */;
INSERT INTO `detalles_comanda` VALUES (1,1,'',40,1,9),(2,1,'',40,2,9);
/*!40000 ALTER TABLE `detalles_comanda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredientes`
--

DROP TABLE IF EXISTS `ingredientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingredientes` (
  `id_ingrediente` bigint NOT NULL AUTO_INCREMENT,
  `imagen` longblob,
  `nombre` varchar(100) NOT NULL,
  `stock` double NOT NULL,
  `unidad` varchar(255) NOT NULL,
  PRIMARY KEY (`id_ingrediente`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredientes`
--

LOCK TABLES `ingredientes` WRITE;
/*!40000 ALTER TABLE `ingredientes` DISABLE KEYS */;
INSERT INTO `ingredientes` VALUES (10,NULL,'hola',6,'PIEZAS');
/*!40000 ALTER TABLE `ingredientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mesas`
--

DROP TABLE IF EXISTS `mesas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mesas` (
  `id_mesa` bigint NOT NULL AUTO_INCREMENT,
  `capacidad` int NOT NULL,
  `numero_mesa` int NOT NULL,
  PRIMARY KEY (`id_mesa`),
  UNIQUE KEY `numero_mesa` (`numero_mesa`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mesas`
--

LOCK TABLES `mesas` WRITE;
/*!40000 ALTER TABLE `mesas` DISABLE KEYS */;
INSERT INTO `mesas` VALUES (1,2,1),(2,2,2),(3,2,3),(4,4,4),(5,4,5),(6,4,6),(7,4,7),(8,4,8),(9,4,9),(10,4,10),(11,6,11),(12,6,12),(13,6,13),(14,6,14),(15,6,15),(16,8,16),(17,8,17),(18,8,18),(19,10,19),(20,10,20);
/*!40000 ALTER TABLE `mesas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productoingrediente`
--

DROP TABLE IF EXISTS `productoingrediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productoingrediente` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `cantidad` double NOT NULL,
  `id_ingrediente` bigint NOT NULL,
  `id_producto` bigint NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_PRODUCTOINGREDIENTE_id_ingrediente` (`id_ingrediente`),
  KEY `FK_PRODUCTOINGREDIENTE_id_producto` (`id_producto`),
  CONSTRAINT `FK_PRODUCTOINGREDIENTE_id_ingrediente` FOREIGN KEY (`id_ingrediente`) REFERENCES `ingredientes` (`id_ingrediente`),
  CONSTRAINT `FK_PRODUCTOINGREDIENTE_id_producto` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productoingrediente`
--

LOCK TABLES `productoingrediente` WRITE;
/*!40000 ALTER TABLE `productoingrediente` DISABLE KEYS */;
INSERT INTO `productoingrediente` VALUES (2,1,10,9);
/*!40000 ALTER TABLE `productoingrediente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `id_producto` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) NOT NULL,
  `estado` varchar(255) NOT NULL,
  `imagen` longblob,
  `nombre` varchar(50) NOT NULL,
  `precio` double NOT NULL,
  `tipoProducto` varchar(255) NOT NULL,
  PRIMARY KEY (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (9,'afaf','ACTIVO',NULL,'hola',40,'PLATILLO');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-04-14 18:21:37
