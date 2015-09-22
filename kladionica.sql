-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 03, 2015 at 12:41 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `kladionica`
--
CREATE DATABASE IF NOT EXISTS `kladionica` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `kladionica`;

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

CREATE TABLE IF NOT EXISTS `administrator` (
  `emailAdministrator` varchar(50) CHARACTER SET latin1 NOT NULL,
  `ime` varchar(50) CHARACTER SET latin1 NOT NULL,
  `prezime` varchar(50) CHARACTER SET latin1 NOT NULL,
  `lozinka` varchar(15) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`emailAdministrator`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`emailAdministrator`, `ime`, `prezime`, `lozinka`) VALUES
('aa', 'a', 'a', 'aa'),
('ivan42382@gmail.com', 'Ivan', 'Petrovic', 'oneyakg');

-- --------------------------------------------------------

--
-- Table structure for table `drzava`
--

CREATE TABLE IF NOT EXISTS `drzava` (
  `drzavaID` int(11) NOT NULL,
  `naziv` varchar(30) NOT NULL,
  PRIMARY KEY (`drzavaID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `drzava`
--

INSERT INTO `drzava` (`drzavaID`, `naziv`) VALUES
(1, 'Srbija'),
(2, 'Engleska');

-- --------------------------------------------------------

--
-- Table structure for table `igrac`
--

CREATE TABLE IF NOT EXISTS `igrac` (
  `emailIgrac` varchar(50) CHARACTER SET latin1 NOT NULL,
  `ime` varchar(50) CHARACTER SET latin1 NOT NULL,
  `prezime` varchar(50) CHARACTER SET latin1 NOT NULL,
  `datumRodjenja` date NOT NULL,
  `lozinka` varchar(50) CHARACTER SET latin1 NOT NULL,
  `stanjeRacuna` double NOT NULL,
  PRIMARY KEY (`emailIgrac`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `igrac`
--

INSERT INTO `igrac` (`emailIgrac`, `ime`, `prezime`, `datumRodjenja`, `lozinka`, `stanjeRacuna`) VALUES
('ig', 'i', 'g', '2015-09-02', 'ig', 10000),
('ivan.ivanpetrovic.petrovic@gmail.com', 'Ivan', 'Petrovic', '1992-05-28', 'oneyakg', 8500),
('lazar.piper@gmail.com', 'Lazar', 'Piper', '1992-08-17', 'lazarpiper', 5000);

-- --------------------------------------------------------

--
-- Table structure for table `klub`
--

CREATE TABLE IF NOT EXISTS `klub` (
  `klubID` int(11) NOT NULL,
  `nazivKluba` varchar(50) CHARACTER SET latin1 NOT NULL,
  `drzavaID` int(11) NOT NULL,
  PRIMARY KEY (`klubID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `klub`
--

INSERT INTO `klub` (`klubID`, `nazivKluba`, `drzavaID`) VALUES
(1, 'Arsenal', 2),
(2, 'Borac', 1),
(3, 'Chelsea', 2),
(4, 'Crvena Zvezda', 1),
(5, 'Cukaricki', 1),
(6, 'Donji Srem', 1),
(7, 'FK Vozdovac', 1),
(8, 'Hull', 2),
(9, 'Jagodina', 1),
(10, 'Liverpool', 2),
(11, 'Manchester Utd', 2),
(12, 'Mladost', 1),
(13, 'Napredak', 1),
(14, 'Novi Pazar', 1),
(15, 'OFK Beograd', 1),
(16, 'Partizan', 1),
(17, 'Rad', 1),
(18, 'Radnicki 1932', 1),
(19, 'Radnicki Nis', 1),
(20, 'Spartak', 1),
(21, 'Tottenham', 2),
(22, 'Vojvodina', 1),
(23, 'Watford', 2),
(24, 'West Ham', 2);

-- --------------------------------------------------------

--
-- Table structure for table `obrada`
--

CREATE TABLE IF NOT EXISTS `obrada` (
  `obradaID` int(11) NOT NULL,
  `nazivObrade` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`obradaID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `obrada`
--

INSERT INTO `obrada` (`obradaID`, `nazivObrade`) VALUES
(1, 'Obradjena'),
(2, 'Bez rezultata');

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

CREATE TABLE IF NOT EXISTS `status` (
  `statusID` int(11) NOT NULL,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`statusID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `status`
--

INSERT INTO `status` (`statusID`, `status`) VALUES
(1, 'Pogodjen'),
(2, 'Promasen'),
(3, 'U toku');

-- --------------------------------------------------------

--
-- Table structure for table `tiket`
--

CREATE TABLE IF NOT EXISTS `tiket` (
  `emailIgrac` varchar(50) CHARACTER SET latin1 NOT NULL,
  `sifraTiketa` varchar(20) CHARACTER SET latin1 NOT NULL,
  `datumIgranja` datetime NOT NULL,
  `uplata` double NOT NULL,
  `ukupnaKvota` double NOT NULL,
  `moguciDobitak` double NOT NULL,
  `statusID` int(11) NOT NULL,
  PRIMARY KEY (`emailIgrac`,`sifraTiketa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tiket`
--

INSERT INTO `tiket` (`emailIgrac`, `sifraTiketa`, `datumIgranja`, `uplata`, `ukupnaKvota`, `moguciDobitak`, `statusID`) VALUES
('ivan.ivanpetrovic.petrovic@gmail.com', '1006150219508336', '2015-06-10 02:19:50', 1200, 9.11, 10932, 1),
('ivan.ivanpetrovic.petrovic@gmail.com', '1006150220382829', '2015-06-10 02:20:38', 1000, 4.7, 4700, 1),
('ivan.ivanpetrovic.petrovic@gmail.com', '1006150221119951', '2015-06-10 02:21:11', 1000, 7.35, 7350, 1),
('ivan.ivanpetrovic.petrovic@gmail.com', '1006151240558412', '2015-06-10 12:40:55', 1000, 11.2, 11200, 2),
('ivan.ivanpetrovic.petrovic@gmail.com', '1106152114029673', '2015-06-11 21:14:02', 500, 3, 1500, 2),
('ivan.ivanpetrovic.petrovic@gmail.com', '2306150145533220', '2015-06-23 01:45:53', 500, 8.96, 4480, 3),
('ivan.ivanpetrovic.petrovic@gmail.com', '2306151721274311', '2015-06-23 17:21:27', 500, 6.3, 3150, 3);

-- --------------------------------------------------------

--
-- Table structure for table `tiketutakmica`
--

CREATE TABLE IF NOT EXISTS `tiketutakmica` (
  `emailIgrac` varchar(50) CHARACTER SET latin1 NOT NULL,
  `sifraTiketa` varchar(20) CHARACTER SET latin1 NOT NULL,
  `sifraUtakmice` varchar(20) CHARACTER SET latin1 NOT NULL,
  `tip` int(1) NOT NULL,
  `kvota` double NOT NULL,
  `statusID` int(11) NOT NULL,
  PRIMARY KEY (`emailIgrac`,`sifraTiketa`,`sifraUtakmice`),
  KEY `utakmica_idfk` (`sifraUtakmice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tiketutakmica`
--

INSERT INTO `tiketutakmica` (`emailIgrac`, `sifraTiketa`, `sifraUtakmice`, `tip`, `kvota`, `statusID`) VALUES
('ivan.ivanpetrovic.petrovic@gmail.com', '1006150219508336', '1006150211292676', 0, 3.1, 1),
('ivan.ivanpetrovic.petrovic@gmail.com', '1006150219508336', '1006150212297246', 1, 1.4, 1),
('ivan.ivanpetrovic.petrovic@gmail.com', '1006150219508336', '1006150213005649', 1, 2.1, 1),
('ivan.ivanpetrovic.petrovic@gmail.com', '1006150220382829', '1006150211292676', 1, 1.6, 1),
('ivan.ivanpetrovic.petrovic@gmail.com', '1006150220382829', '1006150212297246', 1, 1.4, 1),
('ivan.ivanpetrovic.petrovic@gmail.com', '1006150220382829', '1006150213005649', 1, 2.1, 1),
('ivan.ivanpetrovic.petrovic@gmail.com', '1006150221119951', '1006150212297246', 1, 1.4, 1),
('ivan.ivanpetrovic.petrovic@gmail.com', '1006150221119951', '1006150213005649', 1, 2.1, 2),
('ivan.ivanpetrovic.petrovic@gmail.com', '1006150221119951', '1006150213294428', 2, 2.5, 2),
('ivan.ivanpetrovic.petrovic@gmail.com', '1006151240558412', '1006150215139882', 2, 4, 2),
('ivan.ivanpetrovic.petrovic@gmail.com', '1006151240558412', '1006150215513040', 0, 2.8, 2),
('ivan.ivanpetrovic.petrovic@gmail.com', '1106152114029673', '1106152004088386', 0, 3, 3),
('ivan.ivanpetrovic.petrovic@gmail.com', '2306150145533220', '2306150143354751', 1, 3.2, 3),
('ivan.ivanpetrovic.petrovic@gmail.com', '2306150145533220', '2306150144219183', 1, 2.8, 3),
('ivan.ivanpetrovic.petrovic@gmail.com', '2306151721274311', '2306150143354751', 2, 2.1, 3),
('ivan.ivanpetrovic.petrovic@gmail.com', '2306151721274311', '2306151711292723', 0, 3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `utakmica`
--

CREATE TABLE IF NOT EXISTS `utakmica` (
  `sifraUtakmice` varchar(20) CHARACTER SET latin1 NOT NULL,
  `vremeUtakmice` datetime NOT NULL,
  `kvotaDomacin` double NOT NULL,
  `kvotaNereseno` double NOT NULL,
  `kvotaGost` double NOT NULL,
  `rezultat` varchar(5) CHARACTER SET latin1 NOT NULL,
  `emailAdministrator` varchar(50) CHARACTER SET latin1 NOT NULL,
  `obradaID` int(11) NOT NULL DEFAULT '1',
  `klubDomacin` int(11) NOT NULL,
  `klubGost` int(11) NOT NULL,
  PRIMARY KEY (`sifraUtakmice`),
  KEY `administrator_idfk` (`emailAdministrator`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `utakmica`
--

INSERT INTO `utakmica` (`sifraUtakmice`, `vremeUtakmice`, `kvotaDomacin`, `kvotaNereseno`, `kvotaGost`, `rezultat`, `emailAdministrator`, `obradaID`, `klubDomacin`, `klubGost`) VALUES
('1006150211292676', '2015-05-24 17:00:00', 1.6, 3.1, 4.2, '3:3', 'ivan42382@gmail.com', 1, 1, 2),
('1006150212297246', '2015-05-24 17:00:00', 1.4, 3.3, 5.1, '3:1', 'ivan42382@gmail.com', 1, 8, 10),
('1006150213005649', '2015-05-24 17:00:00', 2.1, 3, 2.9, '5:3', 'ivan42382@gmail.com', 1, 11, 21),
('1006150213294428', '2015-05-24 17:00:00', 2.5, 3, 2.5, '2:3', 'ivan42382@gmail.com', 1, 23, 24),
('1006150215139882', '2015-05-24 17:00:00', 2, 2.5, 4, '2:3', 'ivan42382@gmail.com', 1, 1, 24),
('1006150215513040', '2015-05-24 17:00:00', 3.2, 2.8, 2, '2:2', 'ivan42382@gmail.com', 1, 8, 21),
('1006150216238796', '2015-05-24 17:00:00', 3.15, 2.75, 2.5, '4:1', 'ivan42382@gmail.com', 1, 11, 2),
('1006150216522710', '2015-05-24 17:00:00', 2.1, 3.5, 4.1, '2:2', 'ivan42382@gmail.com', 1, 23, 10),
('1006151238000825', '2015-06-11 18:00:00', 3, 3, 3, '2:1', 'ivan42382@gmail.com', 1, 3, 4),
('1106152004088386', '2015-06-14 20:00:00', 2.54, 3, 3.1, '2:1', 'ivan42382@gmail.com', 1, 5, 6),
('1106152033005048', '2015-06-11 21:00:00', 2.55, 3, 3.15, '2:2', 'ivan42382@gmail.com', 1, 7, 9),
('2306150141441409', '2015-06-24 20:30:00', 1.6, 3.5, 4.85, '1:1', 'ivan42382@gmail.com', 1, 12, 13),
('2306150142364581', '2015-06-24 20:30:00', 2.5, 3.1, 3.25, '', 'ivan42382@gmail.com', 1, 14, 15),
('2306150142544018', '2015-06-24 20:30:00', 3.5, 3, 2.1, '', 'ivan42382@gmail.com', 1, 16, 17),
('2306150143354751', '2015-06-24 02:30:00', 3.2, 2.8, 2.1, '', 'ivan42382@gmail.com', 2, 18, 19),
('2306150144219183', '2015-06-24 02:30:00', 2.8, 3, 2.5, '', 'ivan42382@gmail.com', 2, 20, 22),
('2306151711292723', '2015-06-24 18:00:00', 2.3, 3, 3.5, '', 'ivan42382@gmail.com', 2, 3, 15),
('2306151716291297', '2015-06-24 20:00:00', 2.1, 3, 2, '', 'ivan42382@gmail.com', 2, 4, 17);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tiket`
--
ALTER TABLE `tiket`
  ADD CONSTRAINT `igrac_idfk` FOREIGN KEY (`emailIgrac`) REFERENCES `igrac` (`emailIgrac`),
  ADD CONSTRAINT `status_idfk` FOREIGN KEY (`statusID`) REFERENCES `status` (`statusID`);

--
-- Constraints for table `tiketutakmica`
--
ALTER TABLE `tiketutakmica`
  ADD CONSTRAINT `tiket_idfk` FOREIGN KEY (`emailIgrac`, `sifraTiketa`) REFERENCES `tiket` (`emailIgrac`, `sifraTiketa`),
  ADD CONSTRAINT `utakmica_idfk` FOREIGN KEY (`sifraUtakmice`) REFERENCES `utakmica` (`sifraUtakmice`),
  ADD CONSTRAINT `statustu_idfk` FOREIGN KEY (`statusID`) REFERENCES `status` (`statusID`);

--
-- Constraints for table `utakmica`
--
ALTER TABLE `utakmica`
  ADD CONSTRAINT `administrator_idfk` FOREIGN KEY (`emailAdministrator`) REFERENCES `administrator` (`emailAdministrator`),
  ADD CONSTRAINT `domacin_idfk` FOREIGN KEY (`klubDomacin`) REFERENCES `klub` (`klubID`),
  ADD CONSTRAINT `gost_idfk` FOREIGN KEY (`klubGost`) REFERENCES `klub` (`klubID`),
  ADD CONSTRAINT `obrada_idfk` FOREIGN KEY (`obradaID`) REFERENCES `obrada` (`obradaID`);

--
-- Constraints for table `klub`
--
ALTER TABLE `klub`
  ADD CONSTRAINT `drzava_idfk` FOREIGN KEY (`drzavaID`) REFERENCES `drzava` (`drzavaID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
