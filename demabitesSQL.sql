DROP DATABASE demabitesbd;
CREATE DATABASE demabitesbd;

USE demabitesbd;

SELECT * FROM clientesfrecuentes;

-- ==========================================
-- MESAS
-- ==========================================
CREATE TABLE IF NOT EXISTS mesas (
    id_mesa INT AUTO_INCREMENT PRIMARY KEY,
    numero_mesa INT NOT NULL UNIQUE,
    capacidad INT NOT NULL DEFAULT 4
);

INSERT INTO mesas (numero_mesa, capacidad) VALUES 
(1, 2), (2, 2), (3, 2), (4, 4), (5, 4), (6, 4), (7, 4), (8, 4), (9, 4), (10, 4),
(11, 6), (12, 6), (13, 6), (14, 6), (15, 6), (16, 8), (17, 8), (18, 8), (19, 10), (20, 10);

SELECT * FROM ingredientes;
SELECT * FROM mesas;
SELECT * FROM producto_ingrediente;
SELECT * FROM productos;

 