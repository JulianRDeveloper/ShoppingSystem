-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-08-2022 a las 15:09:18
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `store`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `address` varchar(50) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `mail` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `client`
--

INSERT INTO `client` (`id`, `address`, `phone`, `mail`) VALUES
(108, 'Villavicencio - Colombia', '3107671368', 'mycompany@gmail.com'),
(113, 'Barrio El Delirio, Villavicencio Colombia', '3024980299', 'julian.aicardy@gmail.com'),
(114, 'Medellin, Colombia', '6680078', 'mycorreo2@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historical`
--

CREATE TABLE `historical` (
  `order_id` int(11) NOT NULL,
  `rec_orderStatus` varchar(10) NOT NULL,
  `rec_orderDate` datetime NOT NULL,
  `rec_payDate` datetime DEFAULT NULL,
  `rec_sendDate` date DEFAULT NULL,
  `rec_sendCompany` varchar(15) NOT NULL,
  `rec_cartItems` int(11) NOT NULL,
  `rec_payment` double NOT NULL,
  `client_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `historical`
--

INSERT INTO `historical` (`order_id`, `rec_orderStatus`, `rec_orderDate`, `rec_payDate`, `rec_sendDate`, `rec_sendCompany`, `rec_cartItems`, `rec_payment`, `client_id`) VALUES
(83, 'FINISHED', '2022-08-23 00:00:00', '2022-08-23 00:00:00', '2022-08-23', 'FEDEX', 4, 17000, 108),
(86, 'FINISHED', '2022-08-23 00:00:00', '2022-08-23 00:00:00', '2022-08-23', 'FEDEX', 14, 40200, 108),
(87, 'FINISHED', '2022-08-23 00:00:00', '2022-08-23 00:00:00', '2022-08-23', 'FEDEX', 3, 14700, 108),
(88, 'FINISHED', '2022-08-23 00:00:00', '2022-08-23 00:00:00', '2022-08-23', 'FEDEX', 9, 23500, 108),
(90, 'CANCELED', '2022-08-23 00:00:00', NULL, NULL, 'NOT COMPANY', 5, 18400, 108),
(91, 'FINISHED', '2022-08-24 00:00:00', '2022-08-24 00:00:00', '2022-08-24', 'FEDEX', 12, 38600, 114);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `item`
--

CREATE TABLE `item` (
  `id` varchar(15) NOT NULL,
  `supplier` varchar(15) NOT NULL,
  `category` varchar(15) NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `item`
--

INSERT INTO `item` (`id`, `supplier`, `category`, `price`) VALUES
('AJAX_DETER', 'AJAX', 'Aseo', 3500),
('CAJE_MUSTAG', 'MUSTANG', 'Otros', 4500),
('CHOCLIT_LIM', 'CHOCLITOS', 'Alimentos', 1000),
('CORONA_CHOC', 'CORONA', 'Alimentos', 2800),
('Danny_CARN', 'Danny', 'Alimentos', 7000),
('DVALLE_NARAJ', 'DVALLE', 'Bebidas', 4700),
('EGO_GEL', 'EGO', 'Aseo', 3800),
('EGO_SHAMP', 'EGO', 'Aseo', 2500),
('FAB_POLV', 'FAB', 'Aseo', 3500),
('FAMILIA_PAPEL', 'FAMILIA', 'Aseo', 2000),
('FRUCO_TOMAT', 'FRUCO', 'Alimentos', 1000),
('IND_ESCOB', 'INDEP', 'Aseo', 4000),
('IND_UVA', 'INDEP', 'Alimentos', 4500),
('JET_CHOCO', 'JET', 'Alimentos', 900),
('MOSCATEL_UVA', 'MOSCATEL', 'Bebidas', 8000),
('NAT_AGUA', 'NATURA', 'Bebidas', 1700),
('PONDS_JAB', 'PONDS', 'Aseo', 2500),
('POSTOBON_GAS', 'POSTOBON', 'Bebidas', 5000),
('POSTOBON_PEPS', 'POSTOBON', 'Bebidas', 4000),
('REDBULL_LATA', 'REDBULL', 'Bebidas', 5500);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `item_line`
--

CREATE TABLE `item_line` (
  `amount` int(5) NOT NULL,
  `cost` double NOT NULL,
  `item_id` varchar(15) NOT NULL,
  `shopCart_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `item_line`
--

INSERT INTO `item_line` (`amount`, `cost`, `item_id`, `shopCart_id`) VALUES
(2, 9400, 'DVALLE_NARAJ', 153),
(1, 7000, 'Danny_CARN', 153),
(2, 2000, 'FRUCO_TOMAT', 153),
(4, 32000, 'MOSCATEL_UVA', 155),
(1, 5500, 'REDBULL_LATA', 155),
(5, 8500, 'NAT_AGUA', 155),
(10, 9000, 'JET_CHOCO', 155);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `legal_client`
--

CREATE TABLE `legal_client` (
  `company` varchar(30) NOT NULL,
  `NIT` varchar(20) NOT NULL,
  `client_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `legal_client`
--

INSERT INTO `legal_client` (`company`, `NIT`, `client_id`) VALUES
('MiCompany', '124545-5', 108);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `natural_client`
--

CREATE TABLE `natural_client` (
  `identification` varchar(20) NOT NULL,
  `names` varchar(50) NOT NULL,
  `lastnames` varchar(50) NOT NULL,
  `client_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `natural_client`
--

INSERT INTO `natural_client` (`identification`, `names`, `lastnames`, `client_id`) VALUES
('1121887922', 'Manuel Julian', 'Aicardy', 113),
('1254512', 'Felipe', 'Lopez', 114);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `payment`
--

CREATE TABLE `payment` (
  `id` int(11) NOT NULL,
  `pay_date` datetime NOT NULL,
  `payment` double NOT NULL,
  `order_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `payment`
--

INSERT INTO `payment` (`id`, `pay_date`, `payment`, `order_id`) VALUES
(49, '2022-08-24 00:00:00', 73400, 93);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `id` int(11) NOT NULL,
  `order_date` datetime NOT NULL,
  `status` varchar(10) NOT NULL,
  `cost` double NOT NULL,
  `client_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`id`, `order_date`, `status`, `cost`, `client_id`) VALUES
(92, '2022-08-24 00:00:00', 'WAITING', 18400, 108),
(93, '2022-08-24 00:00:00', 'PAYDED', 73400, 114);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `send`
--

CREATE TABLE `send` (
  `id` int(11) NOT NULL,
  `send_address` varchar(30) NOT NULL,
  `send_date` date NOT NULL,
  `send_company` varchar(15) NOT NULL,
  `payment_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `shop_cart`
--

CREATE TABLE `shop_cart` (
  `id` int(11) NOT NULL,
  `cart_date` varchar(30) NOT NULL,
  `client_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `shop_cart`
--

INSERT INTO `shop_cart` (`id`, `cart_date`, `client_id`) VALUES
(153, '23-08-2022 09:55:56', 108),
(155, '24-08-2022 00:07:16', 114);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `userkey`
--

CREATE TABLE `userkey` (
  `user` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `userType` int(1) NOT NULL,
  `client_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `userkey`
--

INSERT INTO `userkey` (`user`, `password`, `userType`, `client_id`) VALUES
('JulianA', '121245', 2, 108),
('mannypaa', '101010', 1, 113),
('admin', 'admin', 1, 114);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `historical`
--
ALTER TABLE `historical`
  ADD KEY `client_id` (`client_id`);

--
-- Indices de la tabla `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `item_line`
--
ALTER TABLE `item_line`
  ADD KEY `item_id` (`item_id`),
  ADD KEY `shopCart_id` (`shopCart_id`);

--
-- Indices de la tabla `legal_client`
--
ALTER TABLE `legal_client`
  ADD PRIMARY KEY (`NIT`),
  ADD KEY `client_id` (`client_id`);

--
-- Indices de la tabla `natural_client`
--
ALTER TABLE `natural_client`
  ADD PRIMARY KEY (`identification`),
  ADD KEY `client_id` (`client_id`);

--
-- Indices de la tabla `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `order_id` (`order_id`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `client_id` (`client_id`);

--
-- Indices de la tabla `send`
--
ALTER TABLE `send`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `payment_id` (`payment_id`),
  ADD KEY `order_id` (`order_id`);

--
-- Indices de la tabla `shop_cart`
--
ALTER TABLE `shop_cart`
  ADD PRIMARY KEY (`id`),
  ADD KEY `client_id` (`client_id`);

--
-- Indices de la tabla `userkey`
--
ALTER TABLE `userkey`
  ADD KEY `client_id` (`client_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=115;

--
-- AUTO_INCREMENT de la tabla `payment`
--
ALTER TABLE `payment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=94;

--
-- AUTO_INCREMENT de la tabla `send`
--
ALTER TABLE `send`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT de la tabla `shop_cart`
--
ALTER TABLE `shop_cart`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=156;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `historical`
--
ALTER TABLE `historical`
  ADD CONSTRAINT `historical_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `item_line`
--
ALTER TABLE `item_line`
  ADD CONSTRAINT `item_line_ibfk_1` FOREIGN KEY (`shopCart_id`) REFERENCES `shop_cart` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `item_line_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `legal_client`
--
ALTER TABLE `legal_client`
  ADD CONSTRAINT `legal_client_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `natural_client`
--
ALTER TABLE `natural_client`
  ADD CONSTRAINT `natural_client_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `pedido` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `send`
--
ALTER TABLE `send`
  ADD CONSTRAINT `send_ibfk_1` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `send_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `pedido` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `shop_cart`
--
ALTER TABLE `shop_cart`
  ADD CONSTRAINT `shop_cart_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `userkey`
--
ALTER TABLE `userkey`
  ADD CONSTRAINT `userkey_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
