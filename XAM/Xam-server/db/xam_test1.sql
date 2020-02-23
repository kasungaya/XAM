-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 16, 2019 at 07:44 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `xam_test1`
--

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `studentID` varchar(10) NOT NULL,
  `firstname` varchar(15) DEFAULT NULL,
  `lastname` varchar(15) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phone` char(10) DEFAULT NULL,
  `xamStatus` varchar(10) DEFAULT NULL,
  `password` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`studentID`, `firstname`, `lastname`, `email`, `phone`, `xamStatus`, `password`) VALUES
('1', 'kasun', 'gayan', 'kasun123@gmail.com', '12345678', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `teacherID` varchar(10) NOT NULL,
  `firstname` varchar(15) DEFAULT NULL,
  `lastname` varchar(15) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phone` char(10) DEFAULT NULL,
  `xamStatus` varchar(10) DEFAULT NULL,
  `password` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`teacherID`, `firstname`, `lastname`, `email`, `phone`, `xamStatus`, `password`) VALUES
('1', 'kamal', 'perera', 'kamal123@gmail.com', '345678876', NULL, NULL),
('2', 'yasas', 'perera', 'yasas123@gmail.com', '3645765', NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`studentID`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`teacherID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
