-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 14, 2021 at 03:02 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `coursemanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `bibm_lv4`
--

CREATE TABLE `bibm_lv4` (
  `first_name` varchar(15) DEFAULT NULL,
  `second_name` varchar(15) DEFAULT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `address` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bibm_lv4`
--

INSERT INTO `bibm_lv4` (`first_name`, `second_name`, `phone_number`, `address`) VALUES
('Sajat Prasad', 'Shrestha', '9876543210', 'Bhaktapur'),
('Srijana', 'Shrestha', '9876532140', 'Bhaktapur'),
('Kareena', 'Tamang', '9876532401', 'Lalitpur'),
('Kareena', 'Pokhrel', '9784562130', 'Boudha');

-- --------------------------------------------------------

--
-- Table structure for table `bibm_lv5`
--

CREATE TABLE `bibm_lv5` (
  `first_name` varchar(15) DEFAULT NULL,
  `second_name` varchar(15) DEFAULT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `address` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bibm_lv5`
--

INSERT INTO `bibm_lv5` (`first_name`, `second_name`, `phone_number`, `address`) VALUES
('Anushka', 'G.C', '9856471230', 'Kalanki'),
('Hari', 'G.C', '9856471230', 'Budanilkantha'),
('Hari', 'Bahadur', '9856471230', 'Swoyambhu'),
('Prajal', 'Bhandari', '9856471230', 'Swoyambhu'),
('Aayush', 'Bhandari', '9856471230', 'Nawalparasi');

-- --------------------------------------------------------

--
-- Table structure for table `bibm_lv6`
--

CREATE TABLE `bibm_lv6` (
  `first_name` varchar(15) DEFAULT NULL,
  `second_name` varchar(15) DEFAULT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `address` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bibm_lv6`
--

INSERT INTO `bibm_lv6` (`first_name`, `second_name`, `phone_number`, `address`) VALUES
('Kunga', 'Nyima', '9867625070', 'Swoyambhu'),
('Kunga', 'Gurung', '9818871332', 'Swoyambhu'),
('Sandesh Raj', 'Gurung', '9818871456', 'Budanilkantha'),
('Madan', 'Bandari', '9875462130', 'Kapilvastu');

-- --------------------------------------------------------

--
-- Table structure for table `bit_lv4`
--

CREATE TABLE `bit_lv4` (
  `first_name` varchar(15) DEFAULT NULL,
  `second_name` varchar(15) DEFAULT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `address` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bit_lv4`
--

INSERT INTO `bit_lv4` (`first_name`, `second_name`, `phone_number`, `address`) VALUES
('Kunga', 'Nyima', '9840532603', 'Swoyambhu'),
('Jitender', 'Bandari', '9865741203', 'Tanahu'),
('Hari', 'Lamichaney', '9865471203', 'Jamal'),
('Nanda Das', 'Tharu', '9852014637', 'Boudhanath'),
('Nanda', 'Thakuri', '9852014672', 'Shimla');

-- --------------------------------------------------------

--
-- Table structure for table `bit_lv5`
--

CREATE TABLE `bit_lv5` (
  `first_name` varchar(15) DEFAULT NULL,
  `second_name` varchar(15) DEFAULT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `address` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bit_lv5`
--

INSERT INTO `bit_lv5` (`first_name`, `second_name`, `phone_number`, `address`) VALUES
('Rapsang', 'Gurung', '9876543210', 'Swoyambhu'),
('Hari bahadur', 'Rana', '9887546632', 'Butwal'),
('Tamding', 'Dhindup', '987755462', 'Kalanki');

-- --------------------------------------------------------

--
-- Table structure for table `bit_lv6`
--

CREATE TABLE `bit_lv6` (
  `first_name` varchar(15) DEFAULT NULL,
  `second_name` varchar(15) DEFAULT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `address` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bit_lv6`
--

INSERT INTO `bit_lv6` (`first_name`, `second_name`, `phone_number`, `address`) VALUES
('Sonam Wangdi', 'Lama', '9857462130', 'Boudha'),
('Tsering Dickey', 'Lama', '9857462301', 'Boudha,Tusal'),
('Yangchen', 'Gurung', '9865744123', 'Swoyambhu');

-- --------------------------------------------------------

--
-- Table structure for table `mbibm4`
--

CREATE TABLE `mbibm4` (
  `student_id` varchar(15) DEFAULT NULL,
  `4IB004` int(11) DEFAULT NULL,
  `4MK007` int(11) DEFAULT NULL,
  `4MK006` int(11) DEFAULT NULL,
  `4HR002` int(11) DEFAULT NULL,
  `4AC013` int(11) DEFAULT NULL,
  `4HR017` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mbibm4`
--

INSERT INTO `mbibm4` (`student_id`, `4IB004`, `4MK007`, `4MK006`, `4HR002`, `4AC013`, `4HR017`) VALUES
('NP02A190113', 84, 59, 68, 78, 87, 90),
('NP03A190155', 20, 57, 88, 75, 62, 55),
('NP03A190235', 85, 75, 88, 75, 62, 59),
('NP03A190566', 89, 70, 89, 35, 61, 59);

-- --------------------------------------------------------

--
-- Table structure for table `mbibm5`
--

CREATE TABLE `mbibm5` (
  `student_id` varchar(15) DEFAULT NULL,
  `5FC003` int(11) DEFAULT NULL,
  `5IB004` int(11) DEFAULT NULL,
  `5IB005` int(11) DEFAULT NULL,
  `5BU010` int(11) DEFAULT NULL,
  `5BU012` int(11) DEFAULT NULL,
  `5HR006` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mbibm5`
--

INSERT INTO `mbibm5` (`student_id`, `5FC003`, `5IB004`, `5IB005`, `5BU010`, `5BU012`, `5HR006`) VALUES
('NP02A190115', 85, 75, 60, 55, 45, 75),
('NP01A190112', 58, 75, 90, 32, 55, 85),
('NP01A190117', 59, 75, 91, 75, 55, 38),
('NP01A190117', 59, 75, 85, 75, 55, 85),
('NP01A190184', 50, 88, 85, 75, 55, 85),
('NP01A190198', 21, 88, 85, 75, 55, 89);

-- --------------------------------------------------------

--
-- Table structure for table `mbibm6`
--

CREATE TABLE `mbibm6` (
  `student_id` varchar(15) DEFAULT NULL,
  `6IB003` int(11) DEFAULT NULL,
  `6IB006` int(11) DEFAULT NULL,
  `6IB011` int(11) DEFAULT NULL,
  `6MK001` int(11) DEFAULT NULL,
  `6BE003` int(11) DEFAULT NULL,
  `6BU013` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mbibm6`
--

INSERT INTO `mbibm6` (`student_id`, `6IB003`, `6IB006`, `6IB011`, `6MK001`, `6BE003`, `6BU013`) VALUES
('NP03A190133', 85, 75, 85, 95, 45, 75),
('NP03A190557', 85, 56, 98, 35, 85, 74),
('NP03A190585', 21, 56, 98, 88, 85, 75),
('NP03A190600', 95, 56, 45, 88, 83, 22);

-- --------------------------------------------------------

--
-- Table structure for table `mbit4`
--

CREATE TABLE `mbit4` (
  `student_id` varchar(15) DEFAULT NULL,
  `4CI018` int(11) DEFAULT NULL,
  `4CS001` int(11) DEFAULT NULL,
  `4CS015` int(11) DEFAULT NULL,
  `4CS016` int(11) DEFAULT NULL,
  `4CS017` int(11) DEFAULT NULL,
  `4MM013` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mbit4`
--

INSERT INTO `mbit4` (`student_id`, `4CI018`, `4CS001`, `4CS015`, `4CS016`, `4CS017`, `4MM013`) VALUES
('NP03A190113', 95, 89, 90, 85, 80, 79),
('NP03A854166', 86, 75, 25, 55, 64, 37),
('NP03A854986', 87, 70, 66, 55, 68, 35),
('NP03A854986', 87, 70, 66, 55, 68, 35),
('NP03A85478', 87, 70, 66, 55, 68, 80),
('NP03A86874', 87, 20, 52, 55, 68, 80);

-- --------------------------------------------------------

--
-- Table structure for table `mbit5`
--

CREATE TABLE `mbit5` (
  `student_id` varchar(15) DEFAULT NULL,
  `5CS037` int(11) DEFAULT NULL,
  `5CS019` int(11) DEFAULT NULL,
  `5CS021` int(11) DEFAULT NULL,
  `5CS022` int(11) DEFAULT NULL,
  `5CS024` int(11) DEFAULT NULL,
  `5CS020` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mbit5`
--

INSERT INTO `mbit5` (`student_id`, `5CS037`, `5CS019`, `5CS021`, `5CS022`, `5CS024`, `5CS020`) VALUES
('NP03A190113', 90, 95, 87, 80, 85, 97),
('NP03A195668', 25, 54, 66, 85, 75, 66),
('NP03A1903547', 75, 54, 66, 85, 13, 85),
('NP03A1903864', 78, 59, 65, 30, 64, 85),
('NP03A1903854', 15, 54, 65, 85, 64, 85);

-- --------------------------------------------------------

--
-- Table structure for table `mbit6`
--

CREATE TABLE `mbit6` (
  `student_id` varchar(15) DEFAULT NULL,
  `6CS014` int(11) DEFAULT NULL,
  `6CS005` int(11) DEFAULT NULL,
  `6CS007` int(11) DEFAULT NULL,
  `6CS012` int(11) DEFAULT NULL,
  `6CS030` int(11) DEFAULT NULL,
  `6CS011` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mbit6`
--

INSERT INTO `mbit6` (`student_id`, `6CS014`, `6CS005`, `6CS007`, `6CS012`, `6CS030`, `6CS011`) VALUES
('NP01A190113', 85, 75, 99, 85, 75, 85),
('NP01A195648', 85, 75, 47, 85, 98, 54),
('NP01A195666', 85, 79, 20, 85, 65, 54),
('NP01A195777', 87, 79, 54, 88, 65, 24);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `module_id` varchar(15) DEFAULT NULL,
  `module_name` varchar(50) DEFAULT NULL,
  `course` varchar(15) DEFAULT NULL,
  `level` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `module_id`, `module_name`, `course`, `level`) VALUES
(1, '4CI018', 'Academic Skills and Team Based Learning', 'BIT', 'Level-4/Year-I'),
(2, '4CS001', 'Introductory Programming and Problem Solving', 'BIT', 'Level-4/Year-I'),
(3, '4CS015', 'Fundamentals of Computing', 'BIT', 'Level-4/Year-I'),
(4, '4CS016', 'Embedded System Programming', 'BIT', 'Level-4/Year-I'),
(5, '4CS017', 'Internet Software Architecture', 'BIT', 'Level-4/Year-I'),
(6, '4MM013', 'Computational Mathematics', 'BIT', 'Level-4/Year-I'),
(7, '5CS037', 'Concepts and Technologies of AI', 'BIT', 'Level-5/Year-II'),
(8, '5CS019', 'Object-Oriented Design and Programming', 'BIT', 'Level-5/Year-II'),
(9, '5CS021', 'Numerical Methods and Concurrency', 'BIT', 'Level-5/Year-II'),
(10, '5CS022', 'Distributed and Cloud System Programming', 'BIT', 'Level-5/Year-II'),
(11, '5CS024', 'Collaborative Development', 'BIT', 'Level-5/Year-II'),
(12, '5CS020', 'Human Computer Interaction', 'BIT', 'Level-5/Year-II'),
(13, '6CS014', 'Complex System', 'BIT', 'Level-6/Year-3'),
(14, '6CS005', 'High Performance Computing', 'BIT', 'Level-6/Year-3'),
(15, '6CS007', 'Project and Professionalism', 'BIT', 'Level-6/Year-3'),
(16, '6CS012', 'Artificial Intelligence and Machine Learning', 'BIT', 'Level-6/Year-3'),
(17, '6CS030', 'Big Data', 'BIT', 'Level-6/Year-3'),
(18, '4IB004', 'Business in a Global Context', 'BIBM', 'Level-4/Year-I'),
(19, '4MK007', 'Principles of Marketing', 'BIBM', 'Level-4/Year-I'),
(20, '4MK006', 'Introduction to Brand Communication', 'BIBM', 'Level-4/Year-I'),
(21, '4HR002', 'Introduction to People at work', 'BIBM', 'Level-4/Year-I'),
(22, '4AC013', 'Financial Management', 'BIBM', 'Level-4/Year-I'),
(23, '4HR017', 'Diversity Management in a Global Context', 'BIBM', 'Level-4/Year-I'),
(24, '5FC003', 'International Financial Institutions and Market', 'BIBM', 'Level-5/Year-II'),
(25, '5IB004', 'Economics of Managerial Decision-Making', 'BIBM', 'Level-5/Year-II'),
(26, '5IB005', 'Contemporary Issues in IBM', 'BIBM', 'Level-5/Year-II'),
(27, '5BU010', 'Digital Business and Innovation', 'BIBM', 'Level-5/Year-II'),
(28, '5BU012', 'Operations and Supply Management', 'BIBM', 'Level-5/Year-II'),
(29, '5HR006', 'International Human Resources – The Key Issues', 'BIBM', 'Level-5/Year-II'),
(30, '6IB003', 'Dynamics of Multinational Companies', 'BIBM', 'Level-6/Year-3'),
(31, '6IB006', 'Debating Globalisation', 'BIBM', 'Level-6/Year-3'),
(32, '6IB011', 'Business Research Methods', 'BIBM', 'Level-6/Year-3'),
(33, '6MK001', 'International Marketing', 'BIBM', 'Level-6/Year-3'),
(34, '6BE003', 'Strategic Management', 'BIBM', 'Level-6/Year-3'),
(35, '6BU013', 'Independent Projec', 'BIBM', 'Level-6/Year-3');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
