-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 20, 2023 at 06:01 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `garden`
--

-- --------------------------------------------------------

--
-- Table structure for table `flowers`
--

CREATE TABLE `flowers` (
  `FlowerID` varchar(6) NOT NULL,
  `FlowerName` varchar(50) NOT NULL,
  `PetalCount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `flowers`
--

INSERT INTO `flowers` (`FlowerID`, `FlowerName`, `PetalCount`) VALUES
('023', 'Rose', 32),
('104', 'Tulip', 6),
('105', 'Daisy', 21),
('106', 'Lily', 18),
('111', 'Sunflower', 12),
('114', 'Orchid', 8),
('150', 'Violet', 5);

-- --------------------------------------------------------

--
-- Table structure for table `gardeners`
--

CREATE TABLE `gardeners` (
  `GardenerID` varchar(13) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `FlowerID` varchar(5) NOT NULL,
  `Experience` float NOT NULL,
  `Awarded` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `gardeners`
--

INSERT INTO `gardeners` (`GardenerID`, `Name`, `FlowerID`, `Experience`, `Awarded`) VALUES
('311113104025', 'Kaytlyn', '104', 8.4, 'YES'),
('311113104039', 'Rishab', '023', 7.3, 'NO');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `flowers`
--
ALTER TABLE `flowers`
  ADD PRIMARY KEY (`FlowerID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
