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
-- テーブルの構造 `favorite`
--

CREATE TABLE `favorite` (
  `favorite_id` int(11) NOT NULL COMMENT 'お気に入りID',
  `favorite_user_id` int(11) NOT NULL COMMENT 'お気に入りユーザーID',
  `favorite_product_id` int(11) NOT NULL COMMENT 'お気に入り商品番号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- テーブルの構造 `message_info`
--

CREATE TABLE `message_info` (
  `message_id` int(11) NOT NULL COMMENT 'メッセージ番号',
  `send_user_id` int(11) NOT NULL COMMENT '送信者ユーザーID',
  `receive_user_id` int(11) NOT NULL COMMENT '受信者ユーザーID',
  `text` text COMMENT '本文',
  `subject` text COMMENT '件名',
  `date` datetime NOT NULL COMMENT '日時',
  `message_status` varchar(1) NOT NULL COMMENT '(1：下書き、2：送信済)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- テーブルの構造 `product`
--

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL COMMENT '商品番号',
  `product_name` varchar(20) NOT NULL COMMENT '商品名',
  `kinds` varchar(20) NOT NULL COMMENT '種類',
  `price` int(11) NOT NULL COMMENT '価格',
  `quantity` int(11) NOT NULL COMMENT '個数',
  `remarks` text COMMENT '備考',
  `region` varchar(20) DEFAULT NULL COMMENT '地域',
  `exhibition_date` date NOT NULL COMMENT '出品日',
  `update_date` date NOT NULL COMMENT '更新日',
  `image` text NOT NULL COMMENT '画像パス',
  `transaction` varchar(1) NOT NULL COMMENT '取引状況（1：出品中、2：取引中、３：売却済み）',
  `user_id` int(11) DEFAULT NULL COMMENT '出品ユーザーID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `product`
--

INSERT INTO `product` (`product_id`, `product_name`, `kinds`, `price`, `quantity`, `remarks`, `region`, `exhibition_date`, `update_date`, `image`, `transaction`, `user_id`) VALUES
(1, '机', '家具', 10000, 1, '幅100cm\r\n奥行100cm\r\n高さ100cm', NULL, '2023-06-23', '2023-06-23', 'default.jpg', '1', 1),
(2, '掃除機', '家電', 5000, 1, NULL, NULL, '2023-06-23', '2023-06-23', 'default.jpg', '2', 1),
(3, '文学全集', '本', 1000, 5, '汚れあり', NULL, '2023-06-23', '2023-06-23', 'default.jpg', '3', 1);

-- --------------------------------------------------------

--
-- テーブルの構造 `purchase_info`
--

CREATE TABLE `purchase_info` (
  `purchase_number` int(11) NOT NULL COMMENT '購入番号',
  `product_number` int(11) NOT NULL COMMENT '購入商品番号',
  `purchase_user_id` int(11) NOT NULL COMMENT '購入ユーザーID',
  `purchase_date` date NOT NULL COMMENT '購入日',
  `money_received` varchar(1) NOT NULL COMMENT '入金状況（未入金：0、入金済み：1）',
  `delivery` varchar(1) NOT NULL COMMENT '発送状況（未発送：0、発送済み：1）'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `purchase_info`
--

INSERT INTO `purchase_info` (`purchase_number`, `product_number`, `purchase_user_id`, `purchase_date`, `money_received`, `delivery`) VALUES
(1, 2, 2, '2023-06-23', '1', '0'),
(2, 3, 2, '2023-06-23', '1', '1');

-- --------------------------------------------------------

--
-- テーブルの構造 `user_info`
--

CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL COMMENT 'ユーザーID',
  `password` varchar(20) NOT NULL COMMENT 'パスワード',
  `mail` varchar(100) NOT NULL COMMENT 'メールアドレス',
  `authority` varchar(1) NOT NULL COMMENT '権限（1：一般ユーザー、2：管理者）',
  `name` varchar(20) NOT NULL COMMENT '氏名',
  `nickname` varchar(20) NOT NULL COMMENT 'ニックネーム',
  `address` varchar(100) NOT NULL COMMENT '住所',
  `phone_number` varchar(20) DEFAULT NULL COMMENT '電話番号',
  `signup_date` date NOT NULL COMMENT '会員登録日',
  `update_date` date NOT NULL COMMENT 'マイページ更新日',
  `signout_date` date DEFAULT NULL COMMENT '退会日'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `user_info`
--

INSERT INTO `user_info` (`user_id`, `password`, `mail`, `authority`, `name`, `nickname`, `address`, `phone_number`, `signup_date`, `update_date`, `signout_date`) VALUES
(1, 'taro123', 'taro@example.com', '1', 'フリマ太郎', 'たろう', '神田県神田市1-1-1', '090-1111-xxxx', '2023-06-23', '2023-06-23', NULL),
(2, 'jiro123', 'jiro@example.com', '1', 'フリマ次郎', 'じろう', '神田県神田市2-2-2', '090-2222-xxxx', '2023-06-23', '2023-06-23', NULL),
(3, 'admin123', 'admin@example.com', '2', '神田雑貨店', '神田雑貨店', '神田県神田市0-0-0', '090-0000-xxxx', '2023-06-23', '2023-06-23', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `favorite`
--
ALTER TABLE `favorite`
  ADD PRIMARY KEY (`favorite_id`),
  ADD KEY `favorite_product_id` (`favorite_product_id`),
  ADD KEY `favorite_user_id` (`favorite_user_id`);

--
-- Indexes for table `message_info`
--
ALTER TABLE `message_info`
  ADD PRIMARY KEY (`message_id`),
  ADD KEY `send_user_id` (`send_user_id`),
  ADD KEY `receive_user_id` (`receive_user_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `product_ibfk_1` (`user_id`);

--
-- Indexes for table `purchase_info`
--
ALTER TABLE `purchase_info`
  ADD PRIMARY KEY (`purchase_number`),
  ADD KEY `product_number` (`product_number`),
  ADD KEY `purchase_user_id` (`purchase_user_id`);

--
-- Indexes for table `user_info`
--
ALTER TABLE `user_info`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `mail` (`mail`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `favorite`
--
ALTER TABLE `favorite`
  MODIFY `favorite_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'お気に入りID', AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `message_info`
--
ALTER TABLE `message_info`
  MODIFY `message_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'メッセージ番号';

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品番号', AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `purchase_info`
--
ALTER TABLE `purchase_info`
  MODIFY `purchase_number` int(11) NOT NULL AUTO_INCREMENT COMMENT '購入番号', AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user_info`
--
ALTER TABLE `user_info`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ユーザーID', AUTO_INCREMENT=4;

--
-- ダンプしたテーブルの制約
--

--
-- テーブルの制約 `favorite`
--
ALTER TABLE `favorite`
  ADD CONSTRAINT `favorite_ibfk_2` FOREIGN KEY (`favorite_user_id`) REFERENCES `user_info` (`user_id`),
  ADD CONSTRAINT `favorite_ibfk_1` FOREIGN KEY (`favorite_product_id`) REFERENCES `product` (`product_id`) ON UPDATE CASCADE;

--
-- テーブルの制約 `message_info`
--
ALTER TABLE `message_info`
  ADD CONSTRAINT `message_info_ibfk_2` FOREIGN KEY (`receive_user_id`) REFERENCES `user_info` (`user_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `message_info_ibfk_1` FOREIGN KEY (`send_user_id`) REFERENCES `user_info` (`user_id`) ON UPDATE CASCADE;

--
-- テーブルの制約 `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`) ON UPDATE CASCADE;

--
-- テーブルの制約 `purchase_info`
--
ALTER TABLE `purchase_info`
  ADD CONSTRAINT `purchase_info_ibfk_2` FOREIGN KEY (`purchase_user_id`) REFERENCES `user_info` (`user_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `purchase_info_ibfk_1` FOREIGN KEY (`product_number`) REFERENCES `product` (`product_id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
