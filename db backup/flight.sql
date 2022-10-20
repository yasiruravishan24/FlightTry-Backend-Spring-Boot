-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 24, 2022 at 08:42 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `flight`
--

-- --------------------------------------------------------

--
-- Table structure for table `flights`
--

CREATE TABLE `flights` (
  `id` int(11) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `aircraft_iata` varchar(255) DEFAULT NULL,
  `airline_iata` varchar(255) DEFAULT NULL,
  `airline_name` varchar(255) DEFAULT NULL,
  `flight_date` date DEFAULT NULL,
  `flight_status` bit(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `flights`
--

INSERT INTO `flights` (`id`, `created_at`, `updated_at`, `aircraft_iata`, `airline_iata`, `airline_name`, `flight_date`, `flight_status`) VALUES
(1, '2022-09-24 04:46:35', '2022-09-24 04:46:35', 'AA', 'AA', 'nova', '2020-01-01', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `segments`
--

CREATE TABLE `segments` (
  `id` int(11) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `airport` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `iata` varchar(255) DEFAULT NULL,
  `lat` varchar(255) DEFAULT NULL,
  `lng` varchar(255) DEFAULT NULL,
  `segment_order` int(11) DEFAULT NULL,
  `segment_type` varchar(255) DEFAULT NULL,
  `flights_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `segments`
--

INSERT INTO `segments` (`id`, `created_at`, `updated_at`, `airport`, `city`, `country`, `iata`, `lat`, `lng`, `segment_order`, `segment_type`, `flights_id`) VALUES
(1, '2022-09-24 04:46:35', '2022-09-24 04:46:35', 'San Francisco International', 'Atlanta', 'United States', 'SFO', '33.636719', '-84.428067', 2, 'departure', 1),
(2, '2022-09-24 04:46:35', '2022-09-24 04:46:35', 'Dallas/Fort Worth International', 'Atlanta', 'United States', 'DFW', '40.080111', '116.584556', 1, 'arrival', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `flights`
--
ALTER TABLE `flights`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `segments`
--
ALTER TABLE `segments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK72iwwcaax1bq579fecyqliboq` (`flights_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `flights`
--
ALTER TABLE `flights`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `segments`
--
ALTER TABLE `segments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
