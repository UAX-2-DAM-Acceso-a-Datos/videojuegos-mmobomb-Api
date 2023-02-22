-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 22-02-2023 a las 10:11:08
-- Versión del servidor: 5.7.36
-- Versión de PHP: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `videojuegos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE IF NOT EXISTS `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `authorities`
--

INSERT INTO `authorities` (`username`, `authority`) VALUES
('Charlie', 'USER'),
('madreGonxoo', 'USER'),
('rafa', 'USER'),
('sergi', 'USER'),
('user', 'USER');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

DROP TABLE IF EXISTS `categorias`;
CREATE TABLE IF NOT EXISTS `categorias` (
  `id_categoria` int(11) NOT NULL,
  `categoria` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`id_categoria`, `categoria`) VALUES
(1, 'MMO'),
(2, 'MMORPG'),
(3, 'SHOOTER'),
(4, 'STRATEGY'),
(5, 'MOBA'),
(6, 'BATTLE ROYALE'),
(7, 'CARD GAMES'),
(8, 'RACING'),
(9, 'SPORTS'),
(10, 'SOCIAL'),
(11, 'FIGHTING'),
(12, 'MMOFPS'),
(13, 'ACTION RPG'),
(14, 'SANDBOX'),
(15, 'OPEN WORLD'),
(16, 'SURVIVAL'),
(17, 'MMOTPS'),
(18, 'ANIME'),
(19, 'PVP'),
(20, 'PVE'),
(21, 'PIXEL'),
(22, 'MMORTS'),
(23, 'FANTASY'),
(24, 'SCI-FI'),
(25, 'ACTION'),
(26, 'VOXEL'),
(27, 'ZOMBIE'),
(28, 'TURN-BASED'),
(29, 'FIRST PERSON VIEW'),
(30, 'THIRD PERSON VIEW'),
(31, 'TOP-DOWN VIEW'),
(32, '3D GRAPHICS'),
(33, '2D GRAPHICS'),
(34, 'TANK'),
(35, 'SPACE'),
(36, 'SAILING'),
(37, 'SIDE SCROLLER'),
(38, 'SUPERHERO'),
(39, 'PERMADEATH');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `favoritos`
--

DROP TABLE IF EXISTS `favoritos`;
CREATE TABLE IF NOT EXISTS `favoritos` (
  `id_videojuego` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id_videojuego`,`id_user`),
  KEY `id_user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `favoritos`
--

INSERT INTO `favoritos` (`id_videojuego`, `id_user`) VALUES
(2, 2),
(2, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(250) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id_user`, `username`, `password`, `enabled`) VALUES
(1, 'prueba', '1234', 0),
(2, 'madreGonxoo', '$2a$10$GyXo7Ss7wYdGLYEkmclx8.QppieOf.nmMKi0ixtNIu3vaJYMaxMmm', 1),
(3, 'madreGonxoo', '$2a$10$tDTK9C3Shbs6.K0D3uiOAuATfm3TgNUXVeCESl67HwniVsoSU1O/W', 1),
(4, 'Charlie', '$2a$10$LbPGkHDNEC8CPqRf0eSnN.KScb592osQXDrZE5fzz36.O/Jg8XT6a', 1),
(5, 'sergi', '$2a$10$s7IK/5NYeG7cMzB8cu4wY.aD4by/rHPuSv.sqcwHBx0EBdyIY.Uh.', 1),
(6, 'user', '$2a$10$rpUalYihcdMXsmYB2/Pf3.xvVdGX2dYzUaM8vzid1nndChJho8UC2', 1),
(7, 'rafa', '$2a$10$wl329fuw.PaeiHdQeb.kNecJRUQMIet8Bid7urMxtySm8VqXkeIUO', 1);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `favoritos`
--
ALTER TABLE `favoritos`
  ADD CONSTRAINT `favoritos_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
