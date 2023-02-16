-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 16, 2023 at 04:36 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java_practice`
--

-- --------------------------------------------------------

--
-- Table structure for table `lic_client`
--

CREATE TABLE `lic_client` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `ClientNumber` int(11) NOT NULL,
  `ClientName` varchar(20) NOT NULL,
  `Age` double NOT NULL,
  `PolicyType` varchar(10) NOT NULL,
  `Premium` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `lic_client`
--

INSERT INTO `lic_client` (`id`, `ClientNumber`, `ClientName`, `Age`, `PolicyType`, `Premium`) VALUES
(1, 101, 'abc', 30, 'li', 23000),
(2, 102, 'xyz', 55, 'li', 31500),
(3, 103, 'pqr', 35, 'elss', 34500);

-- --------------------------------------------------------

--
-- Table structure for table `marks`
--

CREATE TABLE `marks` (
  `mId` int(11) NOT NULL,
  `sub1` int(11) NOT NULL,
  `sub2` int(11) NOT NULL,
  `sub3` int(11) NOT NULL,
  `sub4` int(11) NOT NULL,
  `sub5` int(11) NOT NULL,
  `total` float NOT NULL,
  `sId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `marks`
--

INSERT INTO `marks` (`mId`, `sub1`, `sub2`, `sub3`, `sub4`, `sub5`, `total`, `sId`) VALUES
(10, 44, 55, 66, 77, 88, 330, 46),
(11, 78, 77, 90, 99, 98, 442, 47),
(13, 80, 81, 82, 83, 84, 410, 49),
(14, 22, 33, 44, 55, 66, 220, 50);

-- --------------------------------------------------------

--
-- Table structure for table `result`
--

CREATE TABLE `result` (
  `rId` int(11) NOT NULL,
  `percentage` float NOT NULL,
  `grade` varchar(1) NOT NULL,
  `sId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `result`
--

INSERT INTO `result` (`rId`, `percentage`, `grade`, `sId`) VALUES
(8, 66, 'D', 46),
(9, 88.4, 'B', 47),
(11, 82, 'B', 49),
(12, 44, 'F', 50);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `sId` int(11) NOT NULL,
  `FirstName` varchar(20) NOT NULL,
  `LastName` varchar(20) NOT NULL,
  `mobile` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`sId`, `FirstName`, `LastName`, `mobile`) VALUES
(46, 'Pragnesg', 'Maru', '74102589630'),
(47, 'Rishabh', 'Soni', '7410258963'),
(49, 'Ajay', 'Mayani', '9737497028'),
(50, 'aa', 'aa', 'aa');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `lic_client`
--
ALTER TABLE `lic_client`
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `marks`
--
ALTER TABLE `marks`
  ADD PRIMARY KEY (`mId`),
  ADD KEY `sId` (`sId`);

--
-- Indexes for table `result`
--
ALTER TABLE `result`
  ADD PRIMARY KEY (`rId`),
  ADD KEY `sId` (`sId`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`sId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `lic_client`
--
ALTER TABLE `lic_client`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `marks`
--
ALTER TABLE `marks`
  MODIFY `mId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `result`
--
ALTER TABLE `result`
  MODIFY `rId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `sId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `marks`
--
ALTER TABLE `marks`
  ADD CONSTRAINT `marks_ibfk_1` FOREIGN KEY (`sId`) REFERENCES `student` (`sId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `result`
--
ALTER TABLE `result`
  ADD CONSTRAINT `result_ibfk_1` FOREIGN KEY (`sId`) REFERENCES `student` (`sId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
