-- Script de creación de la base de datos para LoL Dodge Trainer
CREATE DATABASE IF NOT EXISTS dodge_game;
USE dodge_game;

DROP TABLE IF EXISTS oleadas_amenazas;

CREATE TABLE oleadas_amenazas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo_amenaza VARCHAR(30) NOT NULL,
    posicion_x DECIMAL(8,2) NOT NULL,
    posicion_y DECIMAL(8,2) NOT NULL,
    danio INT NOT NULL,
    velocidad DECIMAL(8,2),
    angulo_direccion DECIMAL(8,2),
    radio_impacto DECIMAL(8,2),
    tiempo_detonacion INT,
    ancho_muro DECIMAL(8,2)
);

-- Datos de prueba opcionales para la corrección
INSERT INTO oleadas_amenazas (tipo_amenaza, posicion_x, posicion_y, danio, velocidad, angulo_direccion) 
VALUES ('PROYECTIL_LINEAL', 50.00, 50.00, 30, 15.00, 90.00);

INSERT INTO oleadas_amenazas (tipo_amenaza, posicion_x, posicion_y, danio, radio_impacto) 
VALUES ('TRAMPA_SUELO', 20.00, 20.00, 50, 2.00);