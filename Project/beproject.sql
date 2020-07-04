-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 15, 2020 at 04:09 PM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `beproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `cluster1`
--

CREATE TABLE `cluster1` (
  `encryptedtext` varchar(44) NOT NULL,
  `fileinfo` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cluster1`
--

INSERT INTO `cluster1` (`encryptedtext`, `fileinfo`) VALUES
('ankita is same', 'xyz.txt-2'),
('gitesh is boy', 'xyz.txt-3,pqr.txt-3'),
('ketaki is girl', 'xyz.txt-1,pqr.txt-2'),
('nikhita is idk', 'abc.txt-1,pqr.txt-1'),
('yash is boy', 'abc.txt-2');

-- --------------------------------------------------------

--
-- Table structure for table `cluster2`
--

CREATE TABLE `cluster2` (
  `encryptedtext` varchar(64) NOT NULL,
  `fileinfo` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cluster2`
--

INSERT INTO `cluster2` (`encryptedtext`, `fileinfo`) VALUES
('ADLxBHi7ZUiNlbKs+oqB/+1wr9m3xbZtNuJBY7hQVO0IH2K4upWiRAj4LF6cEzLm', 'Lol.txt-4,Lol.txt-11');

-- --------------------------------------------------------

--
-- Table structure for table `cluster3`
--

CREATE TABLE `cluster3` (
  `encryptedtext` varchar(88) NOT NULL,
  `fileinfo` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cluster3`
--

INSERT INTO `cluster3` (`encryptedtext`, `fileinfo`) VALUES
('LxEzG2AimVilPkhRceRBya2geqWjpPe36dyfY+twcj/9DtJP+4TVRUZy/ulIIYJm', 'Lol.txt-8,Lol.txt-12,Lol.txt-14');

-- --------------------------------------------------------

--
-- Table structure for table `cluster4`
--

CREATE TABLE `cluster4` (
  `encryptedtext` varchar(128) NOT NULL,
  `fileinfo` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `cluster5`
--

CREATE TABLE `cluster5` (
  `encryptedtext` varchar(152) NOT NULL,
  `fileinfo` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cluster5`
--

INSERT INTO `cluster5` (`encryptedtext`, `fileinfo`) VALUES
('VFCNrsqicpVPgvpKLwAQw1M2bNsYRIPnf3ATgamhiZtnGinCtzrgFfU21lnqsC104hXCiCq20E/2i9EUnJZl3X+5xWqyy/8tlCpMGuJpXVjvID+st2x6rbZUFYLxVWDJ', 'Lol.txt-7,Lol.txt-13');

-- --------------------------------------------------------

--
-- Table structure for table `cluster6`
--

CREATE TABLE `cluster6` (
  `encryptedtext` varchar(172) NOT NULL,
  `fileinfo` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cluster6`
--

INSERT INTO `cluster6` (`encryptedtext`, `fileinfo`) VALUES
('XERlepvifdSGs6yvaSDjaf0S65bCwI240YRWwBCjCJBu88VIqk5gawXU3qwCdQdjl66Dqb/YLU1n/rClDxsDWvbEv8i0ANwC9bFRw5bccnURuqnFahx8RtjX9wxftdYiLWvIEcAnujDKMJymxOtLQuAZ43H735kU9AppZETbkqc=', 'Lol.txt-3'),
('Zb3/NzHy38uMqLouIT1C9tJXW3GAzasX8yaGQgbVNnZ6NI3m0+QLxz/8wvlKT3UedPIaTH8xjUFvqIj4sGvtKwYbTtN10LCPc+obtWGHNNP80+DIje8iA2/fjw1qOJBmEXGojdbGWoepQcOqeV/1TfoYMqd6V+yNJzFNRfSRgew=', 'Lol.txt-5');

-- --------------------------------------------------------

--
-- Table structure for table `cluster7`
--

CREATE TABLE `cluster7` (
  `encryptedtext` varchar(192) NOT NULL,
  `fileinfo` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cluster7`
--

INSERT INTO `cluster7` (`encryptedtext`, `fileinfo`) VALUES
('a+wNPmR8A/U6royP53iHs5WJ3pO6MaqkDdaVAUxVwgCCxhCFHNeyqbfTODUxDM6sE217rLToZWbCPXL6N2tlEy/5jzCfDudchbbroT55xRSDWUlnhId9A4HCOA7mGIlRUv/x0B6kDy9wYCd0lX/flWLcYfWeF/QCVrUIvUBHY3PKg1nF6zDa7MQuWcoggAnF', 'Lol.txt-1'),
('dPgxI0mTY80s400dPdX9vjOTttWG59gaJbcjEmPAwuM9SOG1pfbLp1wvAAtiIgy+nCBTGs851YCPsZ+rPti+uolv8+Z4uxVyffmjwT6gyvcz2JM1THQJqtEfKFz9DjAQcYceoFYf3vNze/hIMwamszwdjM0j4EHSTqPLzACFBkQ=', 'Lol.txt-2');

-- --------------------------------------------------------

--
-- Table structure for table `cluster8`
--

CREATE TABLE `cluster8` (
  `encryptedtext` varchar(236) NOT NULL,
  `fileinfo` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `cluster9`
--

CREATE TABLE `cluster9` (
  `encryptedtext` varchar(256) NOT NULL,
  `fileinfo` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cluster9`
--

INSERT INTO `cluster9` (`encryptedtext`, `fileinfo`) VALUES
('N0J2Lar+bD/JhUdWc58EDSTW2JQ9lBvLUtlX5O0jRH7iKM0LV1I889i3jacAC7le9G5YIWX1gBv+RNoxdvxgPdmDb7Izwr7FJV/jq2CHCTBFvkGNzFecDwhv41xIHyrEQOLyLYDhqLVS54mK49WQkA1Odixa/p5eb2ZQgGASeIJ4VCbe1FRDuSO2bvX6GzJ1FCjc8PGbm82c7YNwwN6vPMkwpJ8vLqZx4Vsr3tZA0No=', 'Lol.txt-6');

-- --------------------------------------------------------

--
-- Table structure for table `cluster10`
--

CREATE TABLE `cluster10` (
  `encryptedtext` varchar(280) NOT NULL,
  `fileinfo` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `cluster11`
--

CREATE TABLE `cluster11` (
  `encryptedtext` varchar(408) NOT NULL,
  `fileinfo` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `filerecord`
--

CREATE TABLE `filerecord` (
  `filename` varchar(20) DEFAULT NULL,
  `clusternumbers` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `filerecord`
--

INSERT INTO `filerecord` (`filename`, `clusternumbers`) VALUES
('Lol.txt', '1,2,3,5,6,7,9'),
('pqr.txt', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cluster1`
--
ALTER TABLE `cluster1`
  ADD PRIMARY KEY (`encryptedtext`);

--
-- Indexes for table `cluster2`
--
ALTER TABLE `cluster2`
  ADD PRIMARY KEY (`encryptedtext`);

--
-- Indexes for table `cluster3`
--
ALTER TABLE `cluster3`
  ADD PRIMARY KEY (`encryptedtext`);

--
-- Indexes for table `cluster4`
--
ALTER TABLE `cluster4`
  ADD PRIMARY KEY (`encryptedtext`);

--
-- Indexes for table `cluster5`
--
ALTER TABLE `cluster5`
  ADD PRIMARY KEY (`encryptedtext`);

--
-- Indexes for table `cluster6`
--
ALTER TABLE `cluster6`
  ADD PRIMARY KEY (`encryptedtext`);

--
-- Indexes for table `cluster7`
--
ALTER TABLE `cluster7`
  ADD PRIMARY KEY (`encryptedtext`);

--
-- Indexes for table `cluster8`
--
ALTER TABLE `cluster8`
  ADD PRIMARY KEY (`encryptedtext`);

--
-- Indexes for table `cluster9`
--
ALTER TABLE `cluster9`
  ADD PRIMARY KEY (`encryptedtext`);

--
-- Indexes for table `cluster10`
--
ALTER TABLE `cluster10`
  ADD PRIMARY KEY (`encryptedtext`);

--
-- Indexes for table `cluster11`
--
ALTER TABLE `cluster11`
  ADD PRIMARY KEY (`encryptedtext`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
