-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-05-2022 a las 05:29:19
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autores`
--

CREATE TABLE `autores` (
  `id` int(11) NOT NULL,
  `nombre` char(50) NOT NULL,
  `fecha_nacimiento` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `autores`
--

INSERT INTO `autores` (`id`, `nombre`, `fecha_nacimiento`) VALUES
(1, 'Shakespeare', '1964-04-23'),
(3, 'Calderon de Labarca', '1600-01-17'),
(4, 'Sigmund Freud', '1856-05-06'),
(5, 'Marcela Paz', '1902-02-28'),
(6, 'Miguel de Cervantes', '1547-09-29'),
(9, 'Gabriela Mistral', '1889-04-07'),
(10, 'Pablo Neruda', '1889-04-07'),
(11, 'Gabriel García Marquez', '1927-03-06'),
(12, 'J. K. Rowling', '1965-07-31'),
(13, 'Isabel Allende', '1942-08-02'),
(14, 'Arnold Lobel', '1933-05-22'),
(15, 'Carlo Collodi', '1826-11-24'),
(16, 'Dante Alighieri', '1321-09-14'),
(17, 'Edgar Alla Poe', '1809-10-07'),
(18, 'José M° García López', '1945-10-10'),
(19, 'Rodolfo Anaya', '1937-10-30'),
(20, 'T. H. White', '1906-05-29'),
(21, 'J. R. R. Tolkien', '1892-01-03'),
(22, 'William Goldman', '1931-08-12');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

CREATE TABLE `libros` (
  `id` int(11) NOT NULL,
  `isbn` char(15) NOT NULL,
  `titulo` char(50) NOT NULL,
  `editorial` char(50) NOT NULL,
  `autor_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `libros`
--

INSERT INTO `libros` (`id`, `isbn`, `titulo`, `editorial`, `autor_id`) VALUES
(1, '8483086182', 'Romeo y Julieta', 'Almadraba. Hermes Editora General, S.A.', 1),
(2, '9563495683', 'Papelucho', 'SM', 5),
(3, '9789587231748', 'La interpretación de los sueños', 'SKLA', 4),
(4, '10109-91917', 'Un discreto a voces', 'Lopellau', 3),
(5, '12345-678901', 'Hamlet', 'Frontispicio', 1),
(6, '978292781405', 'Cien sonetos de Amor', 'University of Texas Pres', 10),
(7, '9781400087617', 'Confieso que he vivido', 'Seix Barral', 10),
(8, '9788497933056', 'Veinte poemas de amor', 'Nascimiento', 1),
(9, '9789562647465', 'Perico Trepa por Chile', 'SM ediciones', 5),
(10, '9789563495706', 'Papelucho Historiador', 'SM', 5),
(11, '97895634957', 'Papelucho en la Clínica', 'SM', 5),
(12, '197895634957', 'Papelucho en Vacaciones', 'SM', 5),
(13, '23895634957', 'Papelucho Perdido', 'SM', 5),
(14, '238934957', 'Papelucho Detective', 'SM', 5),
(15, '2389349778', 'El yo y el ello', 'Elejandria', 4),
(16, '13456729900', 'El Quijote de la Mancha', 'AlgaR editorial', 6),
(17, '9788497592208', 'Cien años de soledad', 'DeBolsillo', 11),
(18, '9789878000107', 'I Harry Potter y la piedra filosofal', 'Salamandra', 1),
(19, '9788498380187', 'II Harry Potter La cámara secreta', 'Salamandra', 1),
(20, '9789585234062', 'III Harry Potter El prisionero de azkaban', 'Salamandra', 12),
(21, '9788498389265', 'IV Harry Potter El cáliz de fuego', 'Salamandra', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `autores`
--
ALTER TABLE `autores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`id`),
  ADD KEY `autores_id` (`autor_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `autores`
--
ALTER TABLE `autores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `libros`
--
ALTER TABLE `libros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `libros`
--
ALTER TABLE `libros`
  ADD CONSTRAINT `libros_ibfk_1` FOREIGN KEY (`autor_id`) REFERENCES `autores` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
