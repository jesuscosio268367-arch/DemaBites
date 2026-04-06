DROP DATABASE demabitesbd;
CREATE DATABASE demabitesbd;

USE demabitesbd;

SELECT * FROM clientesfrecuentes;

-- 1. Ingredientes
CREATE TABLE IF NOT EXISTS ingredientes (
    id_ingrediente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    unidad_medida VARCHAR(20) NOT NULL, -- piezas, gramos, mililitros
    stock DECIMAL(10,2) NOT NULL
);

-- 2. Productos
CREATE TABLE IF NOT EXISTS productos (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    descripcion VARCHAR(255),
    precio DECIMAL(10,2) NOT NULL,
    tipo VARCHAR(30) NOT NULL, 
    estado VARCHAR(20) NOT NULL DEFAULT 'activo'
);

-- 3. Producto - Ingrediente
CREATE TABLE IF NOT EXISTS producto_ingrediente (
    id_producto INT,
    id_ingrediente INT,
    cantidad_requerida DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (id_producto, id_ingrediente),
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto),
    FOREIGN KEY (id_ingrediente) REFERENCES ingredientes(id_ingrediente)
);

-- ==========================================
-- INSERCIÓN DE DATOS DUMMY
-- ==========================================

-- Insertar Ingredientes
INSERT INTO ingredientes (nombre, unidad_medida, stock) VALUES
('Pan de hamburguesa', 'piezas', 100),
('Carne de res', 'gramos', 5000),
('Queso americano', 'piezas', 200),
('Lechuga', 'gramos', 1000),
('Tomate', 'gramos', 2000),
('Papas', 'gramos', 10000),
('Aceite', 'mililitros', 5000),
('Refresco de Cola', 'mililitros', 20000),
('Helado de vainilla', 'gramos', 3000);

-- Insertar Productos
INSERT INTO productos (nombre, descripcion, precio, tipo, estado) VALUES
('Hamburguesa Clásica', 'Deliciosa hamburguesa con queso, lechuga y tomate.', 120.00, 'platillo', 'activo'),
('Papas Fritas', 'Porción de 250g de papas fritas crujientes.', 50.00, 'platillo', 'activo'),
('Refresco Cola 500ml', 'Vaso de refresco bien frío.', 35.00, 'bebida', 'activo'),
('Helado Sencillo', 'Copa de helado de vainilla.', 45.00, 'postre', 'activo');

-- Receta: Hamburguesa Clásica (Pan x1, Carne x150g, Queso x1, Lechuga x20g, Tomate x30g)
INSERT INTO producto_ingrediente (id_producto, id_ingrediente, cantidad_requerida) VALUES
(1, 1, 1),
(1, 2, 150),
(1, 3, 1),
(1, 4, 20),
(1, 5, 30);

-- Receta: Papas Fritas (Papas x250g, Aceite x50ml)
INSERT INTO producto_ingrediente (id_producto, id_ingrediente, cantidad_requerida) VALUES
(2, 6, 250),
(2, 7, 50);

-- Receta: Refresco Cola 500ml (Refresco Cola x500ml)
INSERT INTO producto_ingrediente (id_producto, id_ingrediente, cantidad_requerida) VALUES
(3, 8, 500);

-- Receta: Helado Sencillo (Helado de vainilla x150g)
INSERT INTO producto_ingrediente (id_producto, id_ingrediente, cantidad_requerida) VALUES
(4, 9, 150);

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