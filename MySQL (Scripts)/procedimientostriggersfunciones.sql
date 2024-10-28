-- P R O C E D I M I E N T O S

-- 1. Consultar las series creadas por un creador en concreto.

-- DROP PROCEDURE IF EXISTS consultargeneropelicula;

DELIMITER //
CREATE PROCEDURE consultarseriescreadas (
    IN creador_id INT
)
BEGIN
    SELECT s.titulo, c.nombre
    FROM series s
    JOIN creacion_series cs ON s.id_serie = cs.series_id
    JOIN creador_serie c ON cs.creador_id = c.idcreador_serie
    WHERE cs.creador_id = creador_id;
END //
DELIMITER ;

-- E J E C U C I Ó N

-- El 1 representa al id del creador en cuestion
CALL consultarseriescreadas(1);


-- 2. Consultar todas las películas del género que queramos.

DELIMITER //
CREATE PROCEDURE consultargeneropelicula (
    IN input_genero VARCHAR(100)
)
BEGIN
    SELECT titulo 
    FROM peliculas 
    WHERE genero = input_genero;
END //
DELIMITER ;

-- E J E C U C I Ó N
CALL consultargeneropelicula('Accion');

-- F U N C I O N E S

-- 1. Calcular el presupuesto total de todas las películas de un género determinado

DELIMITER $$
CREATE FUNCTION presupuestototalgenero (
    genero_pelicula VARCHAR(100)
) RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE total INT;
    SELECT SUM(presupuesto) INTO total 
    FROM peliculas 
    WHERE genero = genero_pelicula;
    RETURN total;
END $$
DELIMITER ;

SELECT presupuestototalgenero('Accion');

-- 2. Obtener el nombre de la película con el presupuesto más caro:

DELIMITER $$
CREATE FUNCTION peliculaconmayorpresupuesto () 
RETURNS VARCHAR(100)
DETERMINISTIC
BEGIN
    DECLARE titulo_pelicula VARCHAR(100);
    SELECT titulo INTO titulo_pelicula 
    FROM peliculas 
    ORDER BY presupuesto DESC 
    LIMIT 1;
    RETURN titulo_pelicula;
END $$
DELIMITER ;

SELECT peliculaconmayorpresupuesto();





-- T R I G G E R S


-- 1. Registra todas las inserciones en la tabla de series

DELIMITER //

CREATE TRIGGER log_inserciones_series
AFTER INSERT ON series
FOR EACH ROW
BEGIN
    INSERT INTO log_series (id_serie, titulo, fecha_insercion)
    VALUES (NEW.id_serie, NEW.titulo, NOW());
END//

DELIMITER ;

-- Creo la tabla log_series.

CREATE TABLE log_series (
    id_log INT NOT NULL AUTO_INCREMENT,
    id_serie INT,
    titulo VARCHAR(100),
    fecha_insercion DATETIME,
    PRIMARY KEY (id_log)
);

SELECT * from log_series;

-- Insert para hacer prueba
INSERT INTO series (titulo, genero, comienzo_serie, final_serie, pais_serie, num_temporadas, num_capitulos)
VALUES ('Better Call Saul', 'Crimen', '2015', '2022', 'USA', 6, 63);

-- Otra prueba para el profesor.

INSERT INTO series (titulo, genero, comienzo_serie, final_serie, pais_serie, num_temporadas, num_capitulos)
VALUES ('The Crown', 'Drama', '2016', 'Presente', 'Reino Unido', 6, 50);



-- 2. Hace que no se pueda insertar una serie con el mismo nombre.

DELIMITER //
CREATE TRIGGER negacionseriesduplicadas
BEFORE INSERT ON series
FOR EACH ROW
BEGIN
    DECLARE total INT;
    SELECT COUNT(*) INTO total 
    FROM series 
    WHERE titulo = NEW.titulo AND comienzo_serie = NEW.comienzo_serie;
    IF total > 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'La serie ya existe en la base de datos';
    END IF;
END//
DELIMITER 

-- P R U E B A  D E L  T R I G G E R

INSERT INTO series (titulo, genero, comienzo_serie, final_serie, pais_serie, num_temporadas, num_capitulos)
VALUES ('Better Call Saul', 'Crimen', '2015', '2022', 'USA', 6, 63);