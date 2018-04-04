-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 04, 2018 at 02:56 PM
-- Server version: 5.7.15-log
-- PHP Version: 5.6.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mia`
--

-- --------------------------------------------------------

--
-- Table structure for table `bid_job`
--

CREATE TABLE `bid_job` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `jobDetailId` int(11) NOT NULL,
  `bidAsk` decimal(15,2) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `isExpired` tinyint(1) DEFAULT NULL,
  `isSucceded` int(1) DEFAULT NULL,
  `bidTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `iBidTime` bigint(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bid_job`
--

INSERT INTO `bid_job` (`id`, `userId`, `jobDetailId`, `bidAsk`, `location`, `isExpired`, `isSucceded`, `bidTime`, `iBidTime`) VALUES
(1, 1, 1, '100.10', 'Quan 1 ', 0, 0, '2017-12-05 14:19:51', 0),
(2, 2, 1, '200.40', 'Quan 4', 0, 0, '2017-12-05 14:19:54', 0),
(3, 2, 2, '200.10', 'Quan 4', 1, 0, '2017-12-05 14:04:43', 0),
(4, 2, 2, '200.10', 'Quan 4', 0, 0, '2017-11-19 15:39:00', 0),
(5, 2, 2, '200.40', 'Quan 4', 0, 0, '2017-11-19 15:39:00', 0),
(8, 2, 2, '200.40', 'Quan 4', 0, 0, '2017-11-20 15:43:09', 1511192589),
(9, 2, 2, '200.40', 'Quan 4', 1, 0, '2017-12-05 14:06:29', 1511192612),
(11, 1, 1, NULL, NULL, NULL, NULL, '2018-03-13 10:59:30', 1520938770);

--
-- Triggers `bid_job`
--
DELIMITER $$
CREATE TRIGGER `triggerTimer` BEFORE INSERT ON `bid_job` FOR EACH ROW SET NEW.iBidTime = UNIX_TIMESTAMP(NOW())
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `bid_job_feedback`
--

CREATE TABLE `bid_job_feedback` (
  `id` int(11) NOT NULL,
  `bidJobId` int(11) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `iLevel` int(1) DEFAULT NULL,
  `userId` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bid_job_feedback`
--

INSERT INTO `bid_job_feedback` (`id`, `bidJobId`, `comment`, `iLevel`, `userId`) VALUES
(1, 1, 'Good Job edit', 4, 1),
(2, 2, 'Good job 2', 3, 2),
(3, 1, 'Hay qua ', 4, 4),
(4, 1, 'Good Job 2', 5, 1),
(5, 1, 'Good Job 3', 4, 1);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'PHỤC VỤ'),
(2, 'QUẢN LÝ'),
(3, 'GIAO HÀNG'),
(4, 'VIỆC KHÁC');

-- --------------------------------------------------------

--
-- Table structure for table `category_detail`
--

CREATE TABLE `category_detail` (
  `id` int(11) NOT NULL,
  `categoryId` int(11) NOT NULL,
  `categoryName` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `category_detail`
--

INSERT INTO `category_detail` (`id`, `categoryId`, `categoryName`) VALUES
(1, 1, ' Giúp việc gia đình'),
(2, 1, 'Giúp việc công ty'),
(3, 2, 'Phục vụ quán'),
(4, 2, 'Phục vụ shop'),
(5, 3, 'Trong nhà'),
(6, 3, 'Ngoài trời'),
(7, 4, 'Bán Hàng'),
(8, 5, 'Việc khác');

-- --------------------------------------------------------

--
-- Table structure for table `databasechangelog`
--

CREATE TABLE `databasechangelog` (
  `ID` varchar(255) NOT NULL,
  `AUTHOR` varchar(255) NOT NULL,
  `FILENAME` varchar(255) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(20) DEFAULT NULL,
  `CONTEXTS` varchar(255) DEFAULT NULL,
  `LABELS` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `databasechangeloglock`
--

CREATE TABLE `databasechangeloglock` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `databasechangeloglock`
--

INSERT INTO `databasechangeloglock` (`ID`, `LOCKED`, `LOCKGRANTED`, `LOCKEDBY`) VALUES
(1, b'0', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `job_detail`
--

CREATE TABLE `job_detail` (
  `id` int(11) NOT NULL,
  `employerId` int(11) NOT NULL,
  `categoryDetailId` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `priceOrder` decimal(15,0) DEFAULT NULL,
  `location` text,
  `distance` int(11) DEFAULT NULL,
  `datePost` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `iDatePost` bigint(15) NOT NULL,
  `isExpired` tinyint(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `job_detail`
--

INSERT INTO `job_detail` (`id`, `employerId`, `categoryDetailId`, `description`, `priceOrder`, `location`, `distance`, `datePost`, `iDatePost`, `isExpired`) VALUES
(1, 1, 1, 'test desc', '100', 'Hoc Mon', 10, '2017-12-05 14:19:39', 0, 0),
(2, 0, 3, 'test desc', '100', 'Hoc Mon', 10, '2017-11-19 15:36:17', 0, 0),
(3, 0, 3, 'description 1111', '300', '10 abc', 0, '2017-11-08 20:23:14', 0, 0),
(4, 0, 3, 'description 1111', '300', '10 abc', 0, '2017-11-08 20:23:14', 0, 0),
(5, 0, 3, 'description 1111', '300', '10 abc', 0, '2017-11-08 20:23:14', 0, 0),
(6, 0, 3, 'description 1', '300', '10 abc', 0, '2017-11-08 20:23:14', 0, 0),
(7, 0, 1, 'test desc', '100', 'Hoc Mon', 10, '2017-11-06 23:02:35', 0, 0),
(8, 0, 1, 'test desc', '100', 'Hoc Mon', 10, '2017-11-06 23:02:35', 0, 0),
(9, 0, 1, 'test desc', '100', 'Hoc Mon', 10, '2017-11-06 23:02:35', 0, 0),
(10, 0, 1, 'test desc', '100', 'Hoc Mon', 10, '2017-11-06 23:02:35', 0, 0),
(11, 0, 1, 'test desc', '100', 'Hoc Mon', 10, '2017-11-06 23:02:35', 0, 0),
(12, 0, 1, 'test desc', '100', 'Hoc Mon', 10, '2017-11-06 23:02:35', 0, 0),
(13, 0, 1, 'test desc', '100', 'Hoc Mon', 10, '2017-11-06 23:02:35', 0, 0),
(14, 0, 3, 'test desc', '100', 'Hoc Mon', 10, '2017-11-06 23:02:35', 0, 0),
(15, 0, 3, 'test desc', '100', 'Hoc Mon', 10, '2017-11-06 23:02:35', 0, 0),
(16, 0, 3, 'test desc aa', '100', 'Hoc Mon', 10, '2017-11-06 23:02:35', 0, 0),
(17, 0, 1, 'test desc xx', '100', 'Hoc Mon', 10, '2017-11-06 23:02:35', 0, 0),
(18, 10, 1, 'test desc', '100', 'Hoc Mon', 10, '2017-11-06 23:02:35', 0, 0),
(19, 0, 3, 'test desc new data', '100', 'Hoc Mon', 10, '2017-11-06 23:02:35', 0, 0),
(20, 10, 1, 'test desc aa', '100', 'Hoc Mon', 10, '2017-11-20 16:11:25', 1511194285, 0),
(21, 10, 1, 'test desc aa', '100', 'Hoc Mon', 10, '2017-12-03 09:42:26', 1511194730, 1),
(22, 10, 1, 'test desc aa', '100', 'Hoc Mon', 10, '2017-12-03 09:23:38', 1512293018, 0);

--
-- Triggers `job_detail`
--
DELIMITER $$
CREATE TRIGGER `jobDetailTriggerTimer` BEFORE INSERT ON `job_detail` FOR EACH ROW SET NEW.iDatePost = UNIX_TIMESTAMP(NOW())
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `partner`
--

CREATE TABLE `partner` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `idCard` varchar(255) DEFAULT NULL,
  `passportNumber` varchar(255) DEFAULT NULL,
  `tempAddress` varchar(255) DEFAULT NULL,
  `permanentAddress` varchar(255) DEFAULT NULL,
  `bankAccountNumberId` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `partner`
--

INSERT INTO `partner` (`id`, `userId`, `idCard`, `passportNumber`, `tempAddress`, `permanentAddress`, `bankAccountNumberId`) VALUES
(2, 2, '025208245', 'BB025208243', 'Hoc Mon', 'Go Vap', '1234567890');

-- --------------------------------------------------------

--
-- Table structure for table `position`
--

CREATE TABLE `position` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `longitude` int(11) DEFAULT NULL,
  `latitude` int(11) DEFAULT NULL,
  `dateChecked` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `position`
--

INSERT INTO `position` (`id`, `userId`, `longitude`, `latitude`, `dateChecked`) VALUES
(1, 1, 12345678, 23456789, '2017-10-29 14:40:30'),
(2, 3, 12345678, 23456789, '2017-10-29 14:40:30');

-- --------------------------------------------------------

--
-- Table structure for table `price_per_time`
--

CREATE TABLE `price_per_time` (
  `id` int(11) NOT NULL,
  `timeDurationId` int(11) NOT NULL,
  `jobId` int(11) NOT NULL,
  `price` double DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `price_reference`
--

CREATE TABLE `price_reference` (
  `id` int(11) NOT NULL,
  `timeDurationId` int(11) NOT NULL,
  `jobId` int(11) NOT NULL,
  `price` double DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `time_duration`
--

CREATE TABLE `time_duration` (
  `id` int(11) NOT NULL,
  `duration` varchar(255) DEFAULT NULL,
  `desciption` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `time_duration`
--

INSERT INTO `time_duration` (`id`, `duration`, `desciption`) VALUES
(1, '00:00 AM - 06:00 AM', 'Ca 1'),
(2, '06:00 AM - 12.00 AN', 'Ca 2'),
(3, '12:00 AM - 06:00 PM', 'Ca 3'),
(4, '06:00 PM - 12:00 PM', 'Ca 4');

-- --------------------------------------------------------

--
-- Table structure for table `transaction_history`
--

CREATE TABLE `transaction_history` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `transactionDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `moneyTransferred` double DEFAULT NULL,
  `jobId` int(11) NOT NULL,
  `transactionType` int(5) NOT NULL,
  `dateTranferred` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phoneNumber` varchar(15) NOT NULL,
  `dayOfBirth` varchar(15) DEFAULT NULL,
  `CMND` varchar(11) DEFAULT NULL,
  `passKey` varchar(6) DEFAULT NULL,
  `issuedDay` varchar(15) DEFAULT NULL,
  `frontPhoto` varchar(125) DEFAULT NULL,
  `backPhoto` varchar(125) DEFAULT NULL,
  `issuedPlace` varchar(15) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `degree` varchar(20) DEFAULT NULL,
  `certificateOfInformatics` varchar(25) DEFAULT NULL,
  `userType` int(1) NOT NULL,
  `registeredDay` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `iRegisteredDay` bigint(15) NOT NULL,
  `isActivated` int(1) DEFAULT NULL,
  `miaApproval` int(1) NOT NULL,
  `expiredPasskeyDay` timestamp NULL DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `phoneNumber`, `dayOfBirth`, `CMND`, `passKey`, `issuedDay`, `frontPhoto`, `backPhoto`, `issuedPlace`, `email`, `degree`, `certificateOfInformatics`, `userType`, `registeredDay`, `iRegisteredDay`, `isActivated`, `miaApproval`, `expiredPasskeyDay`, `sex`) VALUES
(10, 'Pham Thanh Vinh', '0936388480', '03/05/1983', '211631691', '123', '123', '', '', '', 'vinh.phamthanh16@gmail.com', 'Electronics Bachelor', '', 1, '2018-04-04 14:54:17', 1522852393, 0, 1, '2018-04-04 14:34:13', 'mail'),
(9, 'Vu Nguyen', '0987453106', '12/11/1986', '025206289', '5678', '20/09/2009', '', '', 'CA.HCM', 'vunguyenthe1976@gmail.com', 'Thac si CNTT', '', 0, '2018-03-14 00:02:05', 1520985725, 0, 0, '2018-03-14 00:03:05', 'Female'),
(8, 'Tuan Nguyen', '0987453106', '12/11/1986', '025206289', '5678', '5678', '', '', 'CA.HCM', 'vunguyenthe1976@gmail.com', 'Thac si CNTT', '', 0, '2018-03-14 00:01:01', 1520984492, 0, 0, '2018-03-13 23:42:32', 'Male');

--
-- Triggers `user`
--
DELIMITER $$
CREATE TRIGGER `convertIRegisterday` BEFORE INSERT ON `user` FOR EACH ROW SET NEW.iRegisteredDay = UNIX_TIMESTAMP(NOW()), NEW.expiredPasskeyDay = CURRENT_TIMESTAMP + INTERVAL 1 MINUTE
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `user_balance_info`
--

CREATE TABLE `user_balance_info` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `balance` double DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user_bank_account`
--

CREATE TABLE `user_bank_account` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `acountNumber` int(11) NOT NULL,
  `bankName` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user_rate_info`
--

CREATE TABLE `user_rate_info` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `level` float DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_rate_info`
--

INSERT INTO `user_rate_info` (`id`, `userId`, `level`) VALUES
(1, 1, 3),
(2, 3, 3),
(3, 4, 5);

-- --------------------------------------------------------

--
-- Table structure for table `user_rate_info_detail`
--

CREATE TABLE `user_rate_info_detail` (
  `id` int(11) NOT NULL,
  `userVotedId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `level` float NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bid_job`
--
ALTER TABLE `bid_job`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bid_job_feedback`
--
ALTER TABLE `bid_job_feedback`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `databasechangeloglock`
--
ALTER TABLE `databasechangeloglock`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `job_detail`
--
ALTER TABLE `job_detail`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `partner`
--
ALTER TABLE `partner`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `position`
--
ALTER TABLE `position`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `price_per_time`
--
ALTER TABLE `price_per_time`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `price_reference`
--
ALTER TABLE `price_reference`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `time_duration`
--
ALTER TABLE `time_duration`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaction_history`
--
ALTER TABLE `transaction_history`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_balance_info`
--
ALTER TABLE `user_balance_info`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_bank_account`
--
ALTER TABLE `user_bank_account`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_rate_info`
--
ALTER TABLE `user_rate_info`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_rate_info_detail`
--
ALTER TABLE `user_rate_info_detail`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bid_job`
--
ALTER TABLE `bid_job`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `bid_job_feedback`
--
ALTER TABLE `bid_job_feedback`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `job_detail`
--
ALTER TABLE `job_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT for table `partner`
--
ALTER TABLE `partner`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `position`
--
ALTER TABLE `position`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `price_per_time`
--
ALTER TABLE `price_per_time`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `price_reference`
--
ALTER TABLE `price_reference`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `time_duration`
--
ALTER TABLE `time_duration`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `transaction_history`
--
ALTER TABLE `transaction_history`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `user_balance_info`
--
ALTER TABLE `user_balance_info`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user_bank_account`
--
ALTER TABLE `user_bank_account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user_rate_info`
--
ALTER TABLE `user_rate_info`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `user_rate_info_detail`
--
ALTER TABLE `user_rate_info_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
