-- phpMyAdmin SQL Dump
-- version 4.4.8
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 05, 2015 at 01:54 PM
-- Server version: 10.0.18-MariaDB-log
-- PHP Version: 5.6.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `nabta`
--
CREATE DATABASE IF NOT EXISTS `nabta` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `nabta`;

-- --------------------------------------------------------

--
-- Table structure for table `ACCIDENTS`
--

DROP TABLE IF EXISTS `ACCIDENTS`;
CREATE TABLE IF NOT EXISTS `ACCIDENTS` (
  `ID` int(11) NOT NULL,
  `CAUSE` varchar(10000) DEFAULT NULL,
  `PLACE` varchar(200) DEFAULT NULL,
  `DATE` date DEFAULT NULL,
  `REGISTRATION` varchar(10) DEFAULT NULL,
  `OWNER_ID` varchar(11) DEFAULT NULL,
  `DRIVER_ID` varchar(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ACCIDENTS`
--

INSERT INTO `ACCIDENTS` (`ID`, `CAUSE`, `PLACE`, `DATE`, `REGISTRATION`, `OWNER_ID`, `DRIVER_ID`) VALUES
(1, 'Bad Weather', 'corner of jackson and simpson street, windhoek', '2015-05-05', 'N 345 OT', '91090200220', '89129281910');

-- --------------------------------------------------------

--
-- Table structure for table `DRIVERS`
--

DROP TABLE IF EXISTS `DRIVERS`;
CREATE TABLE IF NOT EXISTS `DRIVERS` (
  `ID` int(11) NOT NULL,
  `DRIVER_ID` varchar(11) NOT NULL,
  `FIRST_NAMES` varchar(100) DEFAULT NULL,
  `SURNAME` varchar(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `DRIVERS`
--

INSERT INTO `DRIVERS` (`ID`, `DRIVER_ID`, `FIRST_NAMES`, `SURNAME`) VALUES
(1, '89129281910', 'John', 'Sindano'),
(2, '84129001910', 'Tyokela', 'Sindano'),
(3, '82129001510', 'Shimoshili Moses', 'Kalumbu'),
(4, '72120402104', 'Silas', 'Ndapuka');

-- --------------------------------------------------------

--
-- Table structure for table `OWNERS`
--

DROP TABLE IF EXISTS `OWNERS`;
CREATE TABLE IF NOT EXISTS `OWNERS` (
  `ID` int(11) NOT NULL,
  `OWNER_ID` varchar(11) NOT NULL,
  `DRIVER_ID` varchar(11) NOT NULL,
  `FIRST_NAMES` varchar(100) DEFAULT NULL,
  `SURNAME` varchar(50) DEFAULT NULL,
  `POSTAL_ADDR` varchar(1000) DEFAULT NULL,
  `RESIDENT_ADDR` varchar(1000) DEFAULT NULL,
  `REGION` varchar(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `OWNERS`
--

INSERT INTO `OWNERS` (`ID`, `OWNER_ID`, `DRIVER_ID`, `FIRST_NAMES`, `SURNAME`, `POSTAL_ADDR`, `RESIDENT_ADDR`, `REGION`) VALUES
(1, '91090200220', '89129281910', 'Martin', 'Hamakali', 'po box 782, windhoek', 'wanaheda', 'khomas'),
(2, '91090200230', '84129001910', 'Moses', 'Hamakali', 'P O Box 233, Tsumeb', 'Erf 34 Melber street, Tsumeb', 'Otjikoto'),
(3, '91080200320', '82129001510', 'Domingo', 'Silver', 'P O Box 23, Katutura', '11 Omongo street', 'Khomas'),
(4, '83090200672', '72120402104', 'Alfred', 'Damaseb', 'P O Box 783, Oshakati', '23 Phatum street, somewhere', 'Oshana');

-- --------------------------------------------------------

--
-- Table structure for table `VEHICLES`
--

DROP TABLE IF EXISTS `VEHICLES`;
CREATE TABLE IF NOT EXISTS `VEHICLES` (
  `ID` int(11) NOT NULL,
  `NABTA_ID` varchar(11) DEFAULT NULL,
  `OWNER_ID` varchar(11) NOT NULL,
  `DRIVER_ID` varchar(11) NOT NULL,
  `REGISTRATION` varchar(10) DEFAULT NULL,
  `TYPE` varchar(15) DEFAULT NULL,
  `MODEL` varchar(30) DEFAULT NULL,
  `MASS` varchar(5) DEFAULT NULL,
  `COLOUR` varchar(5) DEFAULT NULL,
  `REGISTERED` tinyint(1) DEFAULT '0',
  `FEES_DUE` decimal(10,0) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `VEHICLES`
--

INSERT INTO `VEHICLES` (`ID`, `NABTA_ID`, `OWNER_ID`, `DRIVER_ID`, `REGISTRATION`, `TYPE`, `MODEL`, `MASS`, `COLOUR`, `REGISTERED`, `FEES_DUE`) VALUES
(1, '34rt77', '91090200220', '89129281910', 'N 345 OT', 'Taxi', 'Toyota corolla 2007', '1500', 'White', 0, '1500'),
(2, '63273h23', '91090200230', '84129001910', 'N 677 W', 'Taxi', 'Toyota corolla 1986', '1200', 'White', 1, '1500'),
(3, 'ij272', '91080200320', '82129001510', 'N 783 W', 'Minibus', 'Quantum', '2000', 'White', 0, '2500'),
(4, '3n832', '83090200672', '72120402104', 'N 212212 W', 'Bus', 'Volvo m27', '3500', 'White', 0, '3500');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ACCIDENTS`
--
ALTER TABLE `ACCIDENTS`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `REGISTRATION` (`REGISTRATION`);

--
-- Indexes for table `DRIVERS`
--
ALTER TABLE `DRIVERS`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `DRIVER_ID` (`DRIVER_ID`);

--
-- Indexes for table `OWNERS`
--
ALTER TABLE `OWNERS`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `OWNER_ID` (`OWNER_ID`);

--
-- Indexes for table `VEHICLES`
--
ALTER TABLE `VEHICLES`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `REGISTRATION` (`REGISTRATION`),
  ADD UNIQUE KEY `REGISTRATION_2` (`REGISTRATION`),
  ADD UNIQUE KEY `NABTA_ID` (`NABTA_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ACCIDENTS`
--
ALTER TABLE `ACCIDENTS`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `DRIVERS`
--
ALTER TABLE `DRIVERS`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `OWNERS`
--
ALTER TABLE `OWNERS`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `VEHICLES`
--
ALTER TABLE `VEHICLES`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
