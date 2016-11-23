-- phpMyAdmin SQL Dump
-- version 4.5.0.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 07, 2016 at 03:50 PM
-- Server version: 10.0.17-MariaDB
-- PHP Version: 5.5.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `XYZ_Assoc`
--
CREATE DATABASE IF NOT EXISTS `XYZ_Assoc` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `XYZ_Assoc`;

-- --------------------------------------------------------

--
-- Table structure for table `Claims`
--

DROP TABLE IF EXISTS `Claims`;
CREATE TABLE IF NOT EXISTS `Claims` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mem_id` text NOT NULL,
  `date` date NOT NULL,
  `rationale` text NOT NULL,
  `status` varchar(10) NOT NULL,
  `amount` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `Claims`:
--

--
-- Truncate table before insert `Claims`
--

TRUNCATE TABLE `Claims`;

--- Test Data ---

INSERT INTO `Claims` (`mem_id`, `date`, `rationale`, `status`, `amount`) VALUES
('na-duran', '2016-4-05', 'Because Reasons', 'ACCEPTED', '105');

INSERT INTO `Claims` (`mem_id`, `date`, `rationale`, `status`, `amount`) VALUES
('an-curtain', '2016-2-03', 'Because Reasons', 'PENDING', '80');

INSERT INTO `Claims` (`mem_id`, `date`, `rationale`, `status`, `amount`) VALUES
('me-aydin', '2016-5-02', 'Because Reasons', 'ACCEPTED', '120');

INSERT INTO `Claims` (`mem_id`, `date`, `rationale`, `status`, `amount`) VALUES
('me-aydin', '2016-11-03', 'Because Reasons', 'ACCEPTED', '90');
-- --------------------------------------------------------

--
-- Table structure for table `Members`
--

DROP TABLE IF EXISTS `Members`;
CREATE TABLE IF NOT EXISTS `Members` (
  `id` text CHARACTER SET ascii NOT NULL,
  `name` text CHARACTER SET ascii,
  `address` text CHARACTER SET ascii,
  `dob` date DEFAULT NULL,
  `dor` date DEFAULT NULL,
  `status` text NOT NULL,
  `balance` float NOT NULL,
  PRIMARY KEY (`id`(10))
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `Members`:
--

--
-- Truncate table before insert `Members`
--

TRUNCATE TABLE `Members`;
--
-- Dumping data for table `Members`
--

INSERT INTO `Members` (`id`, `name`, `address`, `dob`, `dor`, `status`, `balance`) VALUES
('me-aydin', 'Mehmet Aydin', '148 Station Rd, London, N3 2SG', '1968-10-20', '2015-01-26', 'APPLIED', 0);

--- Test Data ---
INSERT INTO `Members` (`id`, `name`, `address`, `dob`, `dor`, `status`, `balance`) VALUES
('na-duran', 'Nathan Duran', '8 Guinea Lane, Bristol, BS16 2HB', '1983-09-13', '2016-01-01', 'ACCEPTED', 0);

INSERT INTO `Members` (`id`, `name`, `address`, `dob`, `dor`, `status`, `balance`) VALUES
('to-fisher', 'Tom Fisher', '123 Place Rd, Bristol, B1 4BS', '1994-10-20', '2016-01-26', 'APPLIED', 10);

INSERT INTO `Members` (`id`, `name`, `address`, `dob`, `dor`, `status`, `balance`) VALUES
('mi-mouse', 'Mickey Mouse', '12 Disney Rd, Magic Kingdom, M1 2CK', '1950-10-20', '2016-08-26', 'APPLIED', 10);

INSERT INTO `Members` (`id`, `name`, `address`, `dob`, `dor`, `status`, `balance`) VALUES
('an-curtain', 'Annet Curtain', '45 New Rd, Bath, BA1 5LY', '1988-12-20', '2015-09-26', 'ACCEPTED', 0);
-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
CREATE TABLE IF NOT EXISTS `payments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mem_id` text NOT NULL,
  `type_of_payment` char(10) NOT NULL,
  `amount` float NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `payments`:
--   `mem_id`
--       `Members` -> `id`
--

--
-- Truncate table before insert `payments`
--

TRUNCATE TABLE `payments`;

--- Test Data ---

INSERT INTO `payments` (`mem_id`, `type_of_payment`, `amount`, `date`) VALUES
('na-duran', 'CARD', '10', '2016-01-04');

INSERT INTO `payments` (`mem_id`, `type_of_payment`, `amount`, `date`) VALUES
('an-curtain', 'CARD', '10', '2016-10-01');
-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` text CHARACTER SET ascii NOT NULL,
  `password` text NOT NULL,
  `status` text NOT NULL,
  PRIMARY KEY (`id`(10))
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `users`:
--   `id`
--       `Members` -> `id`
--

--
-- Truncate table before insert `users`
--

TRUNCATE TABLE `users`;
--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `password`, `status`) VALUES
('me-aydin', '201068', 'APPLIED');

--- Test Data ---

INSERT INTO `users` (`id`, `password`, `status`) VALUES
('na-duran', '123', 'ACCEPTED');

INSERT INTO `users` (`id`, `password`, `status`) VALUES
('to-fisher', 'asd', 'APPLIED');

INSERT INTO `users` (`id`, `password`, `status`) VALUES
('mi-mouse', 'qwe', 'APPLIED');

INSERT INTO `users` (`id`, `password`, `status`) VALUES
('an-curtain', 'zxc', 'ACCEPTED');

INSERT INTO `users` (`id`, `password`, `status`) VALUES
('admin', 'admin', 'ADMIN');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
