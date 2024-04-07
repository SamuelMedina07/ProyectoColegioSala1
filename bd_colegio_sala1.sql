-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-04-2024 a las 06:47:10
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

--
-- Volcado de datos para la tabla `tbl_alumnos`
--

INSERT INTO `tbl_alumnos` (`alumno_numCuenta`, `alumno_nombreCompleto`, `alumno_genero`, `alumno_fechaNac`, `alumno_direccion`, `alumno_telefono`, `alumno_foto`, `padres_id`, `grados_id`, `alumnos_estado`) VALUES
(20240001, 'Juan Perez', 'Masculino', '2000-01-01', 'Calle Principal 123', '12345678', '/imagenes/sinPerfil.jpg', 1, 1, 'Activo'),
(20240002, 'Angel Damian Crack Garcie', 'MASCULINO', '2018-04-13', 'Sanata Rita', '(504)1234-56-78', 'src\\imagenes\\fotos\\20240002.jpg', 1, 1, 'Activo'),
(20240003, 'Tania Elizabeth Ramirez Cruz', 'FEMENINO', '2010-04-06', 'Ramirez Reina', '(504)9999-99-99', 'src\\imagenes\\fotos\\20240003.jpg', 1, 11, 'Activo'),
(20240004, 'Cesar Augusto Cuello Aguilar', 'MASCULINO', '2010-07-23', 'San Pedro Sula', '(504)9595-95-95', 'src/imagenes/sinPerfil.jpg', 1, 11, 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_asignacion_grados_materias`
--

CREATE TABLE `tbl_asignacion_grados_materias` (
  `asignacion_id` int(11) NOT NULL,
  `grados_id` int(11) DEFAULT NULL,
  `materia_id` int(11) DEFAULT NULL,
  `asignacion_estado` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbl_asignacion_grados_materias`
--

INSERT INTO `tbl_asignacion_grados_materias` (`asignacion_id`, `grados_id`, `materia_id`, `asignacion_estado`) VALUES
(1, 1, 1, 'Activo'),
(2, 1, 2, 'Activo'),
(3, 1, 3, 'Activo'),
(4, 1, 4, 'Activo'),
(5, 1, 5, 'Activo'),
(6, 1, 8, 'Activo'),
(7, 1, 9, 'Activo'),
(8, 1, 10, 'Activo'),
(9, 1, 11, 'Activo'),
(10, 2, 1, 'Activo'),
(11, 2, 2, 'Activo'),
(12, 2, 3, 'Activo'),
(13, 2, 4, 'Activo'),
(14, 2, 5, 'Activo'),
(15, 2, 8, 'Activo'),
(16, 2, 9, 'Activo'),
(17, 2, 10, 'Activo'),
(18, 2, 11, 'Activo'),
(19, 3, 1, 'Activo'),
(20, 3, 2, 'Activo'),
(21, 3, 3, 'Activo'),
(22, 3, 4, 'Activo'),
(23, 3, 5, 'Activo'),
(24, 3, 8, 'Activo'),
(25, 3, 9, 'Activo'),
(26, 3, 10, 'Activo'),
(27, 3, 11, 'Activo'),
(28, 4, 1, 'Activo'),
(29, 4, 2, 'Activo'),
(30, 4, 3, 'Activo'),
(31, 4, 4, 'Activo'),
(32, 4, 5, 'Activo'),
(33, 4, 8, 'Activo'),
(34, 4, 9, 'Activo'),
(35, 4, 10, 'Activo'),
(36, 4, 11, 'Activo'),
(37, 5, 1, 'Activo'),
(38, 5, 2, 'Activo'),
(39, 5, 3, 'Activo'),
(40, 5, 4, 'Activo'),
(41, 5, 5, 'Activo'),
(42, 5, 8, 'Activo'),
(43, 5, 9, 'Activo'),
(44, 5, 10, 'Activo'),
(45, 5, 11, 'Activo'),
(46, 6, 1, 'Activo'),
(47, 6, 2, 'Activo'),
(48, 6, 3, 'Activo'),
(49, 6, 4, 'Activo'),
(50, 6, 5, 'Activo'),
(51, 6, 8, 'Activo'),
(52, 6, 9, 'Activo'),
(53, 6, 10, 'Activo'),
(54, 6, 11, 'Activo'),
(55, 7, 1, 'Activo'),
(56, 7, 2, 'Activo'),
(57, 7, 3, 'Activo'),
(58, 7, 4, 'Activo'),
(59, 7, 5, 'Activo'),
(60, 7, 7, 'Activo'),
(61, 7, 14, 'Activo'),
(62, 7, 13, 'Activo'),
(63, 7, 12, 'Activo'),
(64, 8, 1, 'Activo'),
(65, 8, 2, 'Activo'),
(66, 8, 3, 'Activo'),
(67, 8, 4, 'Activo'),
(68, 8, 5, 'Activo'),
(69, 8, 7, 'Activo'),
(70, 8, 14, 'Activo'),
(71, 8, 13, 'Activo'),
(72, 8, 12, 'Activo'),
(73, 9, 1, 'Activo'),
(74, 9, 2, 'Activo'),
(75, 9, 3, 'Activo'),
(76, 9, 4, 'Activo'),
(77, 9, 5, 'Activo'),
(78, 9, 7, 'Activo'),
(79, 9, 14, 'Activo'),
(80, 9, 13, 'Activo'),
(81, 9, 12, 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_asignacion_profesores_materias`
--

CREATE TABLE `tbl_asignacion_profesores_materias` (
  `asignacion_id` int(11) NOT NULL,
  `profesor_id` int(11) DEFAULT NULL,
  `materia_id` int(11) DEFAULT NULL,
  `asignacion_estado` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbl_asignacion_profesores_materias`
--

INSERT INTO `tbl_asignacion_profesores_materias` (`asignacion_id`, `profesor_id`, `materia_id`, `asignacion_estado`) VALUES
(1, 4, 1, 'Activo'),
(2, 5, 2, 'Activo'),
(3, 6, 3, 'Activo'),
(4, 7, 4, 'Activo'),
(5, 8, 5, 'Activo'),
(6, 4, 7, 'Activo'),
(7, 5, 8, 'Activo'),
(8, 6, 9, 'Activo'),
(9, 7, 10, 'Activo'),
(10, 8, 11, 'Activo'),
(11, 6, 12, 'Activo'),
(12, 7, 13, 'Activo'),
(13, 8, 14, 'Activo');

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
  `calificaciones_parcial` varchar(20) DEFAULT NULL,
  `calificaciones_nota` decimal(5,2) DEFAULT NULL,
  `materia_id` int(11) DEFAULT NULL,
  `alumno_numCuenta` int(11) DEFAULT NULL,
  `profesor_id` int(11) DEFAULT NULL,
  `calificaciones_estado` varchar(20) DEFAULT NULL,
  `idGrado` int(11) DEFAULT NULL
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

--
-- Volcado de datos para la tabla `tbl_grados`
--

INSERT INTO `tbl_grados` (`grados_id`, `grados_nombre`, `grados_estado`) VALUES
(1, 'PRIMER GRADO', 'Activo'),
(2, 'SEGUNDO GRADO', 'Activo'),
(3, 'TERCER GRADO', 'Activo'),
(4, 'CUARTO GRADO', 'Activo'),
(5, 'QUINTO GRADO', 'Activo'),
(6, 'SEXTO GRADO', 'Activo'),
(7, 'SEPTIMO GRADO', 'Activo'),
(8, 'OCTAVO GRADO', 'Activo'),
(9, 'NOVENO GRADO', 'Activo'),
(10, 'DECIMO GRADO', 'Activo'),
(11, 'UNDECIMO GRADO', 'Activo'),
(12, 'DUODECIMO GRADO', 'Activo'),
(13, 'SEPTIMOS', 'Inactivo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_materias`
--

CREATE TABLE `tbl_materias` (
  `materia_id` int(11) NOT NULL,
  `materia_nombre` varchar(100) NOT NULL,
  `materia_estado` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbl_materias`
--

INSERT INTO `tbl_materias` (`materia_id`, `materia_nombre`, `materia_estado`) VALUES
(1, 'MATEMATICAS', 'Activo'),
(2, 'ESPAÑOL', 'Activo'),
(3, 'CIENCIAS SOCIALES', 'Activo'),
(4, 'CIENCIAS NATURALES', 'Activo'),
(5, 'INGLES', 'Activo'),
(6, 'PRUEBA', 'Inactivo'),
(7, 'HISTORIA', 'Activo'),
(8, 'LENGUA Y LITERATURA', 'Activo'),
(9, 'EDUCACIÓN FÍSICA', 'Activo'),
(10, 'ARTE', 'Activo'),
(11, 'MÚSICA', 'Activo'),
(12, 'TECNOLOGÍA', 'Activo'),
(13, 'REDACCION', 'Activo'),
(14, 'BIOLOGÍA', 'Activo');

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

--
-- Volcado de datos para la tabla `tbl_padres`
--

INSERT INTO `tbl_padres` (`padres_id`, `padres_nombreCompleto`, `padres_genero`, `padres_cedula`, `padres_telefono`, `padres_direccion`, `padres_estado`) VALUES
(1, 'Padre ejemplo numero uno', 'MASCULINO', '1804', '(504)9595-55-55', 'ejemplo direccionm', 'Activo'),
(2, 'padre ejemplo numero tres', 'FEMENINO', '18045251', '(504)9595-95-95', 'aaaa', 'Inactivo');

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

--
-- Volcado de datos para la tabla `tbl_profesor`
--

INSERT INTO `tbl_profesor` (`profesor_id`, `profesor_nombreCompleto`, `profesor_cedula`, `profesor_genero`, `usuario_codigo`, `profesor_telefono`, `profesor_direccion`, `profesor_foto`, `profesor_estado`) VALUES
(1, 'Carlos Roberto Diaz Cruz', '1804', 'MASCULINO', 6, '(504)    -  -  ', 'calle', 'src\\imagenes\\fotos\\1.jpg', 'Activo'),
(2, 'Yesmin Paola Florentina Reyes', '18045', 'FEMENINO', 7, '(504)5050-50-50', 'adsf', 'src/imagenes/sinPerfil.jpg', 'Activo'),
(3, 'a b v b', '18888', 'MASCULINO', 8, '(504)5050-50-50', 'af', 'src/imagenes/sinPerfil.jpg', 'Inactivo'),
(4, 'Ana Paola Díaz Medina', '2314567890', 'FEMENINO', 9, '23456789', 'Avenida Independencia #123', 'src/imagenes/sinPerfil.jpg', 'Activo'),
(5, 'Carlos Antonio López García', '1098765432', 'MASCULINO', 10, '56789012', 'Calle Libertad #456', 'src/imagenes/sinPerfil.jpg', 'Activo'),
(6, 'Laura Sofía Pérez Ramírez', '3456789012', 'FEMENINO', 11, '67890123', 'Boulevard Libertadores #789', 'src/imagenes/sinPerfil.jpg', 'Activo'),
(7, 'Diego Alejandro Rodríguez González', '5678901234', 'MASCULINO', 12, '89012345', 'Carrera Principal #234', 'src/imagenes/sinPerfil.jpg', 'Activo'),
(8, 'María José García López', '7890123456', 'FEMENINO', 13, '90123456', 'Avenida Central #567', 'src/imagenes/sinPerfil.jpg', 'Activo');

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
(1, 'sala1', '123', 'ADMIN', 'Activo'),
(3, 'PRUEBA', '111', 'ADMIN', 'Inactivo'),
(4, 'PRUEBA2', '101', 'PROFESOR', 'Inactivo'),
(5, 'PRUEBA3', '1011', 'ADMIN', 'Inactivo'),
(6, 'carlos123', '111', 'ADMIN', 'Activo'),
(7, 'yesmin21', '000', 'PROFESOR', 'Activo'),
(8, 'a b', '0000', 'PROFESOR', 'Activo'),
(9, 'AnaPaola', 'contraseña1', 'PROFESOR', 'Activo'),
(10, 'CarlosAntonio', 'contraseña2', 'PROFESOR', 'Activo'),
(11, 'LauraSofía', 'contraseña3', 'PROFESOR', 'Activo'),
(12, 'DiegoAlejandro', 'contraseña4', 'PROFESOR', 'Activo'),
(13, 'MaríaJosé', 'contraseña5', 'PROFESOR', 'Activo');

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
-- Indices de la tabla `tbl_asignacion_grados_materias`
--
ALTER TABLE `tbl_asignacion_grados_materias`
  ADD PRIMARY KEY (`asignacion_id`),
  ADD KEY `grados_id` (`grados_id`),
  ADD KEY `materia_id` (`materia_id`);

--
-- Indices de la tabla `tbl_asignacion_profesores_materias`
--
ALTER TABLE `tbl_asignacion_profesores_materias`
  ADD PRIMARY KEY (`asignacion_id`),
  ADD KEY `profesor_id` (`profesor_id`),
  ADD KEY `materia_id` (`materia_id`);

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
  ADD KEY `profesor_id` (`profesor_id`),
  ADD KEY `idGrado` (`idGrado`);

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
  MODIFY `alumno_numCuenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20240005;

--
-- AUTO_INCREMENT de la tabla `tbl_asignacion_grados_materias`
--
ALTER TABLE `tbl_asignacion_grados_materias`
  MODIFY `asignacion_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=82;

--
-- AUTO_INCREMENT de la tabla `tbl_asignacion_profesores_materias`
--
ALTER TABLE `tbl_asignacion_profesores_materias`
  MODIFY `asignacion_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

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
  MODIFY `grados_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `tbl_materias`
--
ALTER TABLE `tbl_materias`
  MODIFY `materia_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `tbl_padres`
--
ALTER TABLE `tbl_padres`
  MODIFY `padres_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tbl_profesor`
--
ALTER TABLE `tbl_profesor`
  MODIFY `profesor_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20240009;

--
-- AUTO_INCREMENT de la tabla `tbl_usuarios`
--
ALTER TABLE `tbl_usuarios`
  MODIFY `usuario_codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

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
-- Filtros para la tabla `tbl_asignacion_grados_materias`
--
ALTER TABLE `tbl_asignacion_grados_materias`
  ADD CONSTRAINT `tbl_asignacion_grados_materias_ibfk_1` FOREIGN KEY (`grados_id`) REFERENCES `tbl_grados` (`grados_id`),
  ADD CONSTRAINT `tbl_asignacion_grados_materias_ibfk_2` FOREIGN KEY (`materia_id`) REFERENCES `tbl_materias` (`materia_id`);

--
-- Filtros para la tabla `tbl_asignacion_profesores_materias`
--
ALTER TABLE `tbl_asignacion_profesores_materias`
  ADD CONSTRAINT `tbl_asignacion_profesores_materias_ibfk_1` FOREIGN KEY (`profesor_id`) REFERENCES `tbl_profesor` (`profesor_id`),
  ADD CONSTRAINT `tbl_asignacion_profesores_materias_ibfk_2` FOREIGN KEY (`materia_id`) REFERENCES `tbl_materias` (`materia_id`);

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
  ADD CONSTRAINT `tbl_calificaciones_ibfk_3` FOREIGN KEY (`profesor_id`) REFERENCES `tbl_profesor` (`profesor_id`),
  ADD CONSTRAINT `tbl_calificaciones_ibfk_4` FOREIGN KEY (`idGrado`) REFERENCES `tbl_grados` (`grados_id`);

--
-- Filtros para la tabla `tbl_profesor`
--
ALTER TABLE `tbl_profesor`
  ADD CONSTRAINT `tbl_profesor_ibfk_1` FOREIGN KEY (`usuario_codigo`) REFERENCES `tbl_usuarios` (`usuario_codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
