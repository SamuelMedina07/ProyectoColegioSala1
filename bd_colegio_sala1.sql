-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-03-2024 a las 06:16:02
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.2.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_colegio_sala1`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_alumnos`
--

CREATE TABLE `tbl_alumnos` (
  `alumno_numCuenta` int(11) NOT NULL,
  `alumno_nombreCompleto` varchar(100) NOT NULL,
  `alumno_genero` varchar(10) DEFAULT NULL,
  `alumno_fechaNac` date DEFAULT NULL,
  `alumno_direccion` varchar(255) DEFAULT NULL,
  `alumno_telefono` varchar(20) DEFAULT NULL,
  `alumno_foto` varchar(255) DEFAULT NULL,
  `padres_id` int(11) DEFAULT NULL,
  `grados_id` int(11) DEFAULT NULL,
  `alumnos_estado` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_asistencias`
--

CREATE TABLE `tbl_asistencias` (
  `asistencia_id` int(11) NOT NULL,
  `alumnos_numCuenta` int(11) DEFAULT NULL,
  `asistencia_fecha` date DEFAULT NULL,
  `asistencia_estado` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_calificaciones`
--

CREATE TABLE `tbl_calificaciones` (
  `calificaciones_id` int(11) NOT NULL,
  `calificaciones_parcial` int(11) DEFAULT NULL,
  `calificaciones_nota` decimal(5,2) DEFAULT NULL,
  `materia_id` int(11) DEFAULT NULL,
  `alumno_numCuenta` int(11) DEFAULT NULL,
  `profesor_id` int(11) DEFAULT NULL,
  `calificaciones_estado` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_empresa`
--

CREATE TABLE `tbl_empresa` (
  `empresa_id` int(11) NOT NULL,
  `empresa_nombre` varchar(100) NOT NULL,
  `empresa_direccion` varchar(255) NOT NULL,
  `empresa_rtn` varchar(20) DEFAULT NULL,
  `empresa_telefono` varchar(20) DEFAULT NULL,
  `empresa_correo` varchar(100) DEFAULT NULL,
  `empresa_logo` blob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_grados`
--

CREATE TABLE `tbl_grados` (
  `grados_id` int(11) NOT NULL,
  `grados_nombre` varchar(100) NOT NULL,
  `grados_estado` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_materias`
--

CREATE TABLE `tbl_materias` (
  `materia_id` int(11) NOT NULL,
  `materia_inombre` varchar(100) NOT NULL,
  `materia_estado` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_padres`
--

CREATE TABLE `tbl_padres` (
  `padres_id` int(11) NOT NULL,
  `padres_nombreCompleto` varchar(100) NOT NULL,
  `padres_genero` varchar(10) DEFAULT NULL,
  `padres_cedula` varchar(20) DEFAULT NULL,
  `padres_telefono` varchar(20) DEFAULT NULL,
  `padres_direccion` varchar(255) DEFAULT NULL,
  `padres_estado` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_profesor`
--

CREATE TABLE `tbl_profesor` (
  `profesor_id` int(11) NOT NULL,
  `profesor_nombreCompleto` varchar(100) NOT NULL,
  `profesor_cedula` varchar(20) DEFAULT NULL,
  `profesor_genero` varchar(10) DEFAULT NULL,
  `usuario_codigo` int(11) DEFAULT NULL,
  `profesor_telefono` varchar(20) DEFAULT NULL,
  `profesor_direccion` varchar(100) DEFAULT NULL,
  `profesor_foto` varchar(255) DEFAULT NULL,
  `profesor_estado` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_usuarios`
--

CREATE TABLE `tbl_usuarios` (
  `usuario_codigo` int(11) NOT NULL,
  `usuario_nombre` varchar(100) NOT NULL,
  `usuario_contrasena` varchar(50) DEFAULT NULL,
  `usuario_rol` varchar(20) DEFAULT NULL,
  `usuario_estado` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbl_usuarios`
--

INSERT INTO `tbl_usuarios` (`usuario_codigo`, `usuario_nombre`, `usuario_contrasena`, `usuario_rol`, `usuario_estado`) VALUES
(1, 'sala1', '123', 'ADMIN', 'Activo');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tbl_alumnos`
--
ALTER TABLE `tbl_alumnos`
  ADD PRIMARY KEY (`alumno_numCuenta`),
  ADD KEY `padres_id` (`padres_id`),
  ADD KEY `grados_id` (`grados_id`);

--
-- Indices de la tabla `tbl_asistencias`
--
ALTER TABLE `tbl_asistencias`
  ADD PRIMARY KEY (`asistencia_id`),
  ADD KEY `alumnos_numCuenta` (`alumnos_numCuenta`);

--
-- Indices de la tabla `tbl_calificaciones`
--
ALTER TABLE `tbl_calificaciones`
  ADD PRIMARY KEY (`calificaciones_id`),
  ADD KEY `materia_id` (`materia_id`),
  ADD KEY `alumno_numCuenta` (`alumno_numCuenta`),
  ADD KEY `profesor_id` (`profesor_id`);

--
-- Indices de la tabla `tbl_empresa`
--
ALTER TABLE `tbl_empresa`
  ADD PRIMARY KEY (`empresa_id`);

--
-- Indices de la tabla `tbl_grados`
--
ALTER TABLE `tbl_grados`
  ADD PRIMARY KEY (`grados_id`);

--
-- Indices de la tabla `tbl_materias`
--
ALTER TABLE `tbl_materias`
  ADD PRIMARY KEY (`materia_id`);

--
-- Indices de la tabla `tbl_padres`
--
ALTER TABLE `tbl_padres`
  ADD PRIMARY KEY (`padres_id`);

--
-- Indices de la tabla `tbl_profesor`
--
ALTER TABLE `tbl_profesor`
  ADD PRIMARY KEY (`profesor_id`),
  ADD KEY `usuario_codigo` (`usuario_codigo`);

--
-- Indices de la tabla `tbl_usuarios`
--
ALTER TABLE `tbl_usuarios`
  ADD PRIMARY KEY (`usuario_codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbl_alumnos`
--
ALTER TABLE `tbl_alumnos`
  MODIFY `alumno_numCuenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20240001;

--
-- AUTO_INCREMENT de la tabla `tbl_asistencias`
--
ALTER TABLE `tbl_asistencias`
  MODIFY `asistencia_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_calificaciones`
--
ALTER TABLE `tbl_calificaciones`
  MODIFY `calificaciones_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_empresa`
--
ALTER TABLE `tbl_empresa`
  MODIFY `empresa_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_grados`
--
ALTER TABLE `tbl_grados`
  MODIFY `grados_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_materias`
--
ALTER TABLE `tbl_materias`
  MODIFY `materia_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_padres`
--
ALTER TABLE `tbl_padres`
  MODIFY `padres_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_profesor`
--
ALTER TABLE `tbl_profesor`
  MODIFY `profesor_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20240001;

--
-- AUTO_INCREMENT de la tabla `tbl_usuarios`
--
ALTER TABLE `tbl_usuarios`
  MODIFY `usuario_codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tbl_alumnos`
--
ALTER TABLE `tbl_alumnos`
  ADD CONSTRAINT `tbl_alumnos_ibfk_1` FOREIGN KEY (`padres_id`) REFERENCES `tbl_padres` (`padres_id`),
  ADD CONSTRAINT `tbl_alumnos_ibfk_2` FOREIGN KEY (`grados_id`) REFERENCES `tbl_grados` (`grados_id`);

--
-- Filtros para la tabla `tbl_asistencias`
--
ALTER TABLE `tbl_asistencias`
  ADD CONSTRAINT `tbl_asistencias_ibfk_1` FOREIGN KEY (`alumnos_numCuenta`) REFERENCES `tbl_alumnos` (`alumno_numCuenta`);

--
-- Filtros para la tabla `tbl_calificaciones`
--
ALTER TABLE `tbl_calificaciones`
  ADD CONSTRAINT `tbl_calificaciones_ibfk_1` FOREIGN KEY (`materia_id`) REFERENCES `tbl_materias` (`materia_id`),
  ADD CONSTRAINT `tbl_calificaciones_ibfk_2` FOREIGN KEY (`alumno_numCuenta`) REFERENCES `tbl_alumnos` (`alumno_numCuenta`),
  ADD CONSTRAINT `tbl_calificaciones_ibfk_3` FOREIGN KEY (`profesor_id`) REFERENCES `tbl_profesor` (`profesor_id`);

--
-- Filtros para la tabla `tbl_profesor`
--
ALTER TABLE `tbl_profesor`
  ADD CONSTRAINT `tbl_profesor_ibfk_1` FOREIGN KEY (`usuario_codigo`) REFERENCES `tbl_usuarios` (`usuario_codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
