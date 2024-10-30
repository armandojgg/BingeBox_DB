-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bdpeliculasseries` DEFAULT CHARACTER SET utf8 ;
USE `bdpeliculasseries` ;

-- -----------------------------------------------------
-- Table `mydb`.`peliculas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdpeliculasseries`.`peliculas` (
  `id_pelicula` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(100) NULL,
  `genero` VARCHAR(100) NULL,
  `duracion` VARCHAR(100) NULL,
  `rating` VARCHAR(100) NULL,
  `pais_pelicula` VARCHAR(100) NULL,
  `presupuesto` INT NULL,
  PRIMARY KEY (`id_pelicula`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`series`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdpeliculasseries`.`series` (
  `id_serie` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(100) NULL,
  `genero` VARCHAR(100) NULL,
  `comienzo_serie` VARCHAR(100) NULL,
  `final_serie` VARCHAR(100) NULL,
  `pais_serie` VARCHAR(100) NULL,
  `num_temporadas` INT NULL,
  `num_capitulos` INT NULL,
  PRIMARY KEY (`id_serie`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`actors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdpeliculasseries`.`actors` (
  `id_actor` INT NOT NULL AUTO_INCREMENT,
  `nombre_actor` VARCHAR(100) NULL,
  `nacionalidad_actor` VARCHAR(100) NULL,
  `genero_actor` VARCHAR(100) NULL,
  PRIMARY KEY (`id_actor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`directors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdpeliculasseries`.`directors` (
  `id_director` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `nacionalidad` VARCHAR(45) NULL,
  `genero` VARCHAR(45) NULL,
  PRIMARY KEY (`id_director`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`temporadas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdpeliculasseries`.`temporadas` (
  `id_temporada` INT NOT NULL,
  `series_id` INT NOT NULL,
  `num_temporada` INT NULL,
  `año_estreno` INT NULL,
  `num_episodios` INT NULL,
  PRIMARY KEY (`id_temporada`, `series_id`),
  CONSTRAINT `fk_temporadas_series`
    FOREIGN KEY (`series_id`)
    REFERENCES `bdpeliculasseries`.`series` (`id_serie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`capitulos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdpeliculasseries`.`capitulos` (
  `id_capitulo` INT NOT NULL,
  `temporadas_id` INT NOT NULL,
  `temporadas_series` INT NOT NULL,
  `titulo_capitulo` VARCHAR(45) NULL,
  `numero_episodio` INT NULL,
  `duracion_episodio` VARCHAR(45) NULL,
  `director_episodio` VARCHAR(45) NULL,
  `guionista_episodio` VARCHAR(45) NULL,
  PRIMARY KEY (`id_capitulo`, `temporadas_id`, `temporadas_series`),
  INDEX `fk_capitulos_temporadas1_idx` (`temporadas_id` ASC, `temporadas_series` ASC) VISIBLE,
  CONSTRAINT `fk_capitulos_temporadas1`
    FOREIGN KEY (`temporadas_id` , `temporadas_series`)
    REFERENCES `bdpeliculasseries`.`temporadas` (`id_temporada` , `series_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`creador_serie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdpeliculasseries`.`creador_serie` (
  `idcreador_serie` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NULL,
  `nacionalidad` VARCHAR(100) NULL,
  `genero` VARCHAR(100) NULL,
  PRIMARY KEY (`idcreador_serie`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`participacion_actor_serie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdpeliculasseries`.`participacion_actor_serie` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `actors_id` INT NOT NULL,
  `series_id` INT NOT NULL,
  `papel_realiza` VARCHAR(45) NULL,
  PRIMARY KEY (`id`, `actors_id`, `series_id`),
  INDEX `fk_actors_has_series_series1_idx` (`series_id` ASC) VISIBLE,
  INDEX `fk_actors_has_series_actors1_idx` (`actors_id` ASC) VISIBLE,
  CONSTRAINT `fk_actors_has_series_actors1`
    FOREIGN KEY (`actors_id`)
    REFERENCES `bdpeliculasseries`.`actors` (`id_actor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_actors_has_series_series1`
    FOREIGN KEY (`series_id`)
    REFERENCES `bdpeliculasseries`.`series` (`id_serie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`participacion_actor_pelicula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdpeliculasseries`.`participacion_actor_pelicula` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `peliculas_id` INT NOT NULL,
  `actors_id` INT NOT NULL,
  `papel_realiza` VARCHAR(100) NULL,
  PRIMARY KEY (`id`, `peliculas_id`, `actors_id`),
  INDEX `fk_peliculas_has_actors_actors1_idx` (`actors_id` ASC) VISIBLE,
  INDEX `fk_peliculas_has_actors_peliculas1_idx` (`peliculas_id` ASC) VISIBLE,
  CONSTRAINT `fk_peliculas_has_actors_peliculas1`
    FOREIGN KEY (`peliculas_id`)
    REFERENCES `bdpeliculasseries`.`peliculas` (`id_pelicula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_peliculas_has_actors_actors1`
    FOREIGN KEY (`actors_id`)
    REFERENCES `bdpeliculasseries`.`actors` (`id_actor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`direccion_pelicula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdpeliculasseries`.`direccion_pelicula` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `peliculas_id_pelicula` INT NOT NULL,
  `directors_id_director` INT NOT NULL,
  PRIMARY KEY (`id`, `peliculas_id_pelicula`, `directors_id_director`),
  INDEX `fk_peliculas_has_directors_directors1_idx` (`directors_id_director` ASC) VISIBLE,
  INDEX `fk_peliculas_has_directors_peliculas1_idx` (`peliculas_id_pelicula` ASC) VISIBLE,
  CONSTRAINT `fk_peliculas_has_directors_peliculas1`
    FOREIGN KEY (`peliculas_id_pelicula`)
    REFERENCES `bdpeliculasseries`.`peliculas` (`id_pelicula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_peliculas_has_directors_directors1`
    FOREIGN KEY (`directors_id_director`)
    REFERENCES `bdpeliculasseries`.`directors` (`id_director`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`creacion_series`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdpeliculasseries`.`creacion_series` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `series_id` INT NOT NULL,
  `creador_id` INT NOT NULL,
  PRIMARY KEY (`id`, `series_id`, `creador_id`),
  INDEX `fk_series_has_creador_serie_creador_serie1_idx` (`creador_id` ASC) VISIBLE,
  INDEX `fk_series_has_creador_serie_series1_idx` (`series_id` ASC) VISIBLE,
  CONSTRAINT `fk_series_has_creador_serie_series1`
    FOREIGN KEY (`series_id`)
    REFERENCES `bdpeliculasseries`.`series` (`id_serie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_series_has_creador_serie_creador_serie1`
    FOREIGN KEY (`creador_id`)
    REFERENCES `bdpeliculasseries`.`creador_serie` (`idcreador_serie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- INSERTS -------------------------------------------------------------------------------------

-- I N S E R T S  P E L I C U L A S

INSERT INTO peliculas (titulo, genero, duracion, rating, pais_pelicula, presupuesto) VALUES
('El padrino', 'Crimen', '175 minutos', 'R', 'USA', 6000000),
('El caballero oscuro', 'Accion', '152 minutos', 'PG-13', 'USA', 185000000),
('El club de la lucha', 'Drama', '139 minutos', 'R', 'USA', 63000000),
('El silencio de los corderos', 'Suspenso', '118 minutos', 'R', 'USA', 19000000),
('Trainspotting', 'Drama', '94 minutos', 'R', 'UK', 1500000),
('El sexto sentido', 'Suspenso', '107 minutos', 'PG-13', 'USA', 40000000),
('Jurassic Park', 'Ciencia ficcion', '127 minutos', 'PG-13', 'USA', 63000000),
('Pulp Fiction', 'Crimen', '154 minutos', 'R', 'USA', 8000000),
('REC', 'Terror', '75 minutos', 'R', 'España', 1500000),
('El laberinto del fauno', 'Fantasia', '118 minutos', 'R', 'España', 19000000),
('Gladiator', 'Accion', '155 minutos', 'R', 'USA', 103000000);

SELECT * FROM peliculas;

-- I N S E R T  S E R I E S

INSERT INTO series (titulo, genero, comienzo_serie, final_serie, pais_serie, num_temporadas, num_capitulos) VALUES
('Los Soprano', 'Crimen', '1999', '2007', 'USA', 6, 86),
('Dexter', 'Suspenso', '2006', '2013', 'USA', 8, 96),
('Peaky Blinders', 'Crimen', '2013', '2022', 'Reino Unido', 6, 36),
('Breaking Bad', 'Crimen', '2008', '2013', 'USA', 5, 62),
('Juego de Tronos', 'Fantasia', '2011', '2019', 'USA', 8, 73),
('Stranger Things', 'Ciencia ficcion', '2016', 'Presente', 'USA', 4, 34),
('True Detective', 'Crimen', '2014', 'Presente', 'USA', 3, 24),
('Westworld', 'Ciencia ficcion', '2016', '2022', 'USA', 4, 36),
('Fargo', 'Crimen', '2014', 'Presente', 'USA', 5, 50),
('La Casa de Papel', 'Crimen', '2017', '2021', 'España', 5, 41);

SELECT * FROM series;

-- I N S E R T  A C T O R

INSERT INTO actors (nombre_actor, nacionalidad_actor, genero_actor) VALUES
('Marlon Brando', 'Estadounidense', 'Masculino'),
('Al Pacino', 'Estadounidense', 'Masculino'),
('Christian Bale', 'Reino Unido', 'Masculino'),
('Heath Ledger', 'Australia', 'Masculino'),
('Brad Pitt', 'Estadounidense', 'Masculino'),
('Edward Norton', 'Estadounidense', 'Masculino'),
('Anthony Hopkins', 'Reino Unido', 'Masculino'),
('Jodie Foster', 'Estadounidense', 'Femenino'),
('James Gandolfini', 'Estadounidense', 'Masculino'),
('Edie Falco', 'Estadounidense', 'Femenino'),
('Michael Imperioli', 'Estadounidense', 'Masculino'),
('Michael C. Hall', 'Estadounidense', 'Masculino'),
('Jennifer Carpenter', 'Estadounidense', 'Femenino'),
('Cillian Murphy', 'Irlanda', 'Masculino'),
('Ewan McGregor', 'Britanico', 'Masculino'),
('John Travolta', 'Estadounidense', 'Masculino'),
('Sam Neill', 'Neozelandes', 'Masculino');

SELECT * FROM actors;

-- I N S E R T   D I R E C T O R E S

INSERT INTO directors (nombre, nacionalidad, genero) VALUES
('Francis Ford Coppola', 'Estadounidense', 'Masculino'),
('Christopher Nolan', 'Reino Unido', 'Masculino'),
('David Fincher', 'Estadounidense', 'Masculino'),
('Jonathan Demme', 'Estadounidense', 'Masculino'),
('Danny Boyle', 'Britanico', 'Masculino'),
('M. Night Shyamalan', 'Estadounidense', 'Masculino'),
('Steven Spielberg', 'Estadounidense', 'Masculino'),
('Quentin Tarantino', 'Estadounidense', 'Masculino'),
('Guillermo del Toro', 'Mexicano', 'Masculino'),
('Ridley Scott', 'Britanico', 'Masculino');

SELECT * FROM directors;

-- I N S E R T  T E M P O R A D A S

INSERT INTO temporadas (id_temporada, series_id, num_temporada, año_estreno, num_episodios) VALUES
-- LOS SOPRANO
(1, 1, 1, 1999, 13),
(2, 1, 2, 2000, 13),
(3, 1, 3, 2001, 13),
(4, 1, 4, 2002, 13),
(5, 1, 5, 2004, 13),
(6, 1, 6, 2006, 21),
-- DEXTER
(7, 2, 1, 2006, 12),
(8, 2, 2, 2007, 12),
(9, 2, 3, 2008, 12),
(10, 2, 4, 2009, 12),
(11, 2, 5, 2010, 12),
(12, 2, 6, 2011, 12),
(13, 2, 7, 2012, 12),
(14, 2, 8, 2013, 12),
-- PEAKY BLINDERS
(15, 3, 1, 2013, 6),
(16, 3, 2, 2014, 6),
(17, 3, 3, 2016, 6),
(18, 3, 4, 2017, 6),
(19, 3, 5, 2019, 6),
(20, 3, 6, 2022, 6),
-- BREAKING BAD
(21, 4, 1, 2008, 7),
(22, 4, 2, 2009, 13),
(23, 4, 3, 2010, 13),
(24, 4, 4, 2011, 13),
(25, 4, 5, 2012, 16),
-- JUEGO DE TRONOS
(26, 5, 1, 2011, 10),
(27, 5, 2, 2012, 10),
(28, 5, 3, 2013, 10),
(29, 5, 4, 2014, 10),
(30, 5, 5, 2015, 10),
(31, 5, 6, 2016, 10),
(32, 5, 7, 2017, 7),
(33, 5, 8, 2019, 6),
-- STRANGER THINGS
(34, 6, 1, 2016, 8),
(35, 6, 2, 2017, 9),
(36, 6, 3, 2019, 8),
(37, 6, 4, 2022, 9),
-- TRUE DETECTIVE
(38, 7, 1, 2014, 8),
(39, 7, 2, 2015, 8),
(40, 7, 3, 2019, 8),
-- WESTWORLD
(41, 8, 1, 2016, 10),
(42, 8, 2, 2018, 10),
(43, 8, 3, 2020, 8),
(44, 8, 4, 2022, 8),
-- FARGO
(45, 9, 1, 2014, 10),
(46, 9, 2, 2015, 10),
(47, 9, 3, 2017, 10),
(48, 9, 4, 2020, 11),
(49, 9, 5, 2022, 10),
-- LA CASA DE PAPEL
(50, 10, 1, 2017, 13),
(51, 10, 2, 2018, 9),
(52, 10, 3, 2019, 8),
(53, 10, 4, 2019, 8),
(54, 10, 5, 2021, 10);

SELECT * FROM temporadas;

-- I N S E R T  C A P I T U L O S

-- temporadas_series hace referencia a la id de la serie.

-- temporadas_series = al id de la serie
INSERT INTO capitulos (id_capitulo, temporadas_id, temporadas_series, titulo_capitulo, numero_episodio, duracion_episodio, director_episodio, guionista_episodio) VALUES
-- Los Soprano
(1, 1, 1, 'Piloto', 1, '60 min.', 'David Chase', 'David Chase'),
(2, 1, 1, '46 Largo', 2, '50 min.', 'Daniel Attias', 'David Chase'),
(3, 1, 1, 'Negacion, enfado y aceptacion', 3, '50 min.', 'Nick Gomez', 'Mark Saraceni'),
-- Dexter
(6, 7, 2, 'Cocodrilo', 2, '50 minutos', 'Michael Cuesta', 'Clyde Phillips'),
(7, 7, 2, 'Resquebrajando a Cherry', 3, '50 minutos', 'Michael Cuesta', 'Daniel Cerone'),
-- Breaking Bad
(8, 21, 4, 'Piloto', 1, '58 minutos', 'Vince Gilligan', 'Vince Gilligan'),
(9, 22, 4, 'A la parrilla', 2, '48 minutos', 'Adam Bernstein', 'Vince Gilligan'),
-- Juego de Tronos
(10, 26, 5, 'Winter Is Coming', 1, '62 minutos', 'Tim Van Patten', 'David Benioff y D.B. Weiss'),
(11, 27, 5, 'El camino real', 2, '56 minutos', 'Tim Van Patten', 'David Benioff y D.B. Weiss'),
-- La Casa de Papel
(12, 50, 10, 'Efectuar lo acordado', 1, '47 minutos', 'Alex Pina', 'Alex Pina'),
(13, 51, 10, 'Imprudencias letales', 2, '42 minutos', 'Jesus Colmenar', 'Alex Pina'),
-- Peaky Blinders
(14, 15, 3, 'Episodio 1', 1, '55 minutos', 'Otto Bathurst', 'Steven Knight'),
(15, 16, 3, 'Episodio 2', 2, '58 minutos', 'Tom Harper', 'Steven Knight'),
-- Stranger Things
(16, 34, 6, 'La desaparicion de Will Byers ', 1, '47 minutos', 'The Duffer Brothers', 'The Duffer Brothers'),
(17, 35, 6, 'La loca de la calle Maple', 2, '55 minutos', 'The Duffer Brothers', 'The Duffer Brothers');

SELECT * FROM capitulos;

-- I N S E R T  C R E A D O R _ S E R I E

INSERT INTO creador_serie (nombre, nacionalidad, genero) VALUES
('David Chase', 'Estadounidense', 'Masculino'),
('James Manos Jr.', 'Estadounidense', 'Masculino'),
('Steven Knight', 'Britanico', 'Masculino'),
('Vince Gilligan', 'Estadounidense', 'Masculino'),
('David Benioff', 'Estadounidense', 'Masculino'),
('Matt Duffer', 'Estadounidense', 'Masculino'),
('Nic Pizzolatto', 'Estadounidense', 'Masculino'),
('Jonathan Nolan', 'Britanico', 'Masculino'),
('Noah Hawley', 'Estadounidense', 'Masculino'),
('Alex Pina', 'Español', 'Masculino');

SELECT * FROM creador_serie;

-- I N S E R T  PARTICIPACION_ACTOR_SERIE

INSERT INTO participacion_actor_serie (actors_id, series_id, papel_realiza) VALUES
(1, 1, 'Tony Soprano'),
(2, 1, 'Dr. Melfi'),
(3, 2, 'Dexter Morgan'),
(4, 2, 'Debra Morgan'),
(5, 3, 'Thomas Shelby'),
(6, 3, 'Arthur Shelby'),
(7, 4, 'Walter White'),
(8, 5, 'Jon Snow'),
(9, 6, 'Eleven');

SELECT * FROM participacion_actor_serie;

-- I N S E R T PARTICIPACION_ACTOR_PELICULA

INSERT INTO participacion_actor_pelicula (peliculas_id, actors_id, papel_realiza) VALUES
(1, 1, 'Michael Corleone'),
(1, 2, 'Vito Corleone'),
(2, 3, 'Bruce Wayne / Batman'),
(2, 4, 'Joker'),
(3, 5, 'Narrador'),
(3, 6, 'Tyler Durden'),
(4, 7, 'Clarice Starling'),
(4, 8, 'Hannibal Lecter');

SELECT * FROM participacion_actor_pelicula;

-- I N S E R T  DIRECCION_PELICULA

INSERT INTO direccion_pelicula (peliculas_id_pelicula, directors_id_director) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(10, 9),
(11, 10);

SELECT * FROM direccion_pelicula;

-- I N S E R T CREACION_SERIES

INSERT INTO creacion_series (series_id, creador_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

SELECT * FROM creacion_series;