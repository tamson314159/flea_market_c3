-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 
-- サーバのバージョン： 5.5.39
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `flea_market_db`
--

-- --------------------------------------------------------

--
-- テーブルの構造 `purchase_info`
--

DROP TABLE IF EXISTS `purchase_info`;
CREATE TABLE IF NOT EXISTS `purchase_info` (
  `purchase_number` int(11) NOT NULL AUTO_INCREMENT,
  `product_number` int(11) NOT NULL,
  `purchase_user_id` int(11) NOT NULL,
  `purchase_date` date NOT NULL,
  `money_received` varchar(1) NOT NULL,
  `delivery` varchar(1) NOT NULL,
  PRIMARY KEY (`purchase_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
