-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 04, 2023 at 05:30 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sgi2`
--

-- --------------------------------------------------------

--
-- Table structure for table `annexe`
--

CREATE TABLE `annexe` (
  `id` int(11) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `district_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `annexe`
--

INSERT INTO `annexe` (`id`, `designation`, `district_id`) VALUES
(1, 'الملحقة الإدارية 1', 1),
(2, 'الملحقة الإدارية 2', 1),
(3, 'الملحقة الإدارية 3', 1),
(4, 'الملحقة الإدارية 4', 2),
(5, 'الملحقة الإدارية 5', 2),
(6, 'الملحقة الإدارية 6', 2),
(7, 'الملحقة الإدارية 7', 3),
(8, 'الملحقة الإدارية 8', 3),
(9, 'الملحقة الإدارية 9', 4),
(10, 'الملحقة الإدارية 10', 4),
(11, 'الملحقة الإدارية 11', 4),
(12, 'الملحقة الإدارية 12', 5),
(13, 'الملحقة الإدارية 13', 5),
(14, 'الملحقة الإدارية 14', 5),
(15, 'الملحقة الإدارية 20', 5),
(16, 'الملحقة الإدارية 21', 5),
(17, 'الملحقة الإدارية 15', 6),
(18, 'الملحقة الإدارية 16', 6),
(19, 'الملحقة الإدارية 17', 6),
(20, 'الملحقة الإدارية 18', 6),
(21, 'الملحقة الإدارية 19', 6),
(22, 'بوكراع', 7),
(23, 'الدشيرة', 7),
(24, 'فم الواد', 7),
(25, 'الملحقة الحضرية 1 المسيرة', 8),
(26, 'الملحقة الحضرية 2 الحي الصناعي', 8);

-- --------------------------------------------------------

--
-- Table structure for table `app_role`
--

CREATE TABLE `app_role` (
  `id` bigint(20) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `app_role`
--

INSERT INTO `app_role` (`id`, `role_name`) VALUES
(1, 'ADMIN'),
(2, 'USER');

-- --------------------------------------------------------

--
-- Table structure for table `app_user`
--

CREATE TABLE `app_user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `annexe_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `app_user`
--

INSERT INTO `app_user` (`id`, `email`, `password`, `username`, `annexe_id`) VALUES
(1, NULL, '$2a$10$/jipeqXdUpLtN0yVBIsLDeFYGzPQ5mzVgVxf9hcNBB.ONt4XdmXYq', 'sgi', NULL),
(2, NULL, '$2a$10$V4Sgov7TTiRJch2S3EdkVuRpo5/2fCRFfwOyl217mnsxmOtcRcu2u', 'aal1', NULL),
(3, NULL, '$2a$10$U7daA8BgeI9XzSXTWrG69ueJwwGnu2W74g3SnYq.LpUbtZfP1evE2', 'aal2', NULL),
(4, NULL, '$2a$10$lKAiIVgudsIverP/Is2bp.pbsKX.LcDiNrfMW4j0GRQCcbjRUCKSe', 'aal3', NULL),
(5, NULL, '$2a$10$yGo.fEM1jkBZRLwXt8MGiufG3/o2wwf1U6YdJvWCdSQV1EJoizzrC', 'aal4', NULL),
(6, NULL, '$2a$10$Nha.Cng3eJQZDxy3XFdPReGtBBbirPO.jNVqdVkw.ON4abi00nuE2', 'aal5', NULL),
(7, NULL, '$2a$10$oj3HXggNcg9FtciE6qtkVOTirRVYRzZyT3DFRLF3pLsk5suEtf1fa', 'aal6', NULL),
(8, NULL, '$2a$10$1l17fqzMslPb5qiNiOS1.OpjFODWw40Ff825qGfd4uHri7FGmhVOq', 'aal7', NULL),
(9, NULL, '$2a$10$20aSa3YzIWTxAil3rj/WIejAlahqKv3gD5T29AiebG2p33Pmzl2EW', 'aal8', NULL),
(10, NULL, '$2a$10$zCtnJ1yZPwkCXQUHcSScZeZhc7KZg0Z0bffrKTxxJnlBZPvRjycZ.', 'aal9', NULL),
(11, NULL, '$2a$10$CqUVmvSY94PbmK.Hz0obrOOs/IjSKd0kU2cFtclI41SznnP8k6flO', 'aal10', NULL),
(12, NULL, '$2a$10$ucbxMiIVcJ.1dCHt4aKfjulekPCpeG1tnzsQ0YCozNGpTnlCxT4DK', 'aal11', NULL),
(13, NULL, '$2a$10$dO5RJlwHmxdNHAk2Tz98m.1kxA3shWeqnzTmfXKJI.hElhE6MDqEG', 'aal12', NULL),
(14, NULL, '$2a$10$yK2tFxq5LvF8HW/6l..uK.YxySn4aPRox.EN3N7zRfrdft0pLcPGi', 'aal13', NULL),
(15, NULL, '$2a$10$b25LQVrFuQXhMX06WlN0cOWSPpPha0P0LvlaZvmVVCixAuzQ0eGwm', 'aal14', NULL),
(16, NULL, '$2a$10$LwijHh20KaThEVcq1GXHRO8LY.8DJ7bV2wrrDn/iscmI9rxEpgiGe', 'aal15', NULL),
(17, NULL, '$2a$10$HnBO9cNADHa3Hh1E6XbNLu5o3Ssugt60iTrtIAJ0zUHMpndoqMnP6', 'aal16', NULL),
(18, NULL, '$2a$10$3qiLQqmHBlpOMCjgvcJHH.Z1g0VxDT1UUlusCXDlg683mNCmbLUFe', 'aal17', NULL),
(19, NULL, '$2a$10$HiTwOID17Cn9AnicES38ouzZhT0wAxSODxkgK3h.AOFuWjA3yM396', 'aal18', NULL),
(20, NULL, '$2a$10$eGFq7mmUd1vp.fkPTt/qwuNtoXGlA/oxzGz9rehjeiZIdNEBiLcdm', 'aal19', NULL),
(21, NULL, '$2a$10$4YFhYkaoqYz6c5OoOML3uu0BS75hHcgYwrwRNX4A5W.mdD6YPB06G', 'aal20', NULL),
(22, NULL, '$2a$10$iaviRpce72GMB/b8Z4076O72UVsM2aseM16TFr7Dt49axbbg1N2xS', 'aal21', NULL),
(23, NULL, '$2a$10$nYpHfG0zV7glD1w8YGHTIuPGRTlI3tzNPo9n1rV33O3/zD4NH/Oaa', 'boucraa', NULL),
(24, NULL, '$2a$10$Q3AWbs9X2JVwtkQG0hu8ceYcNe/ofyeSUyTYyvVkHwIkOxEZwtpH2', 'Dcheira', NULL),
(25, NULL, '$2a$10$lp5n2/DxjHSfezIyuJOu5ey2KRK8N/r4ybj34pmIG6SwClICgixI2', 'foumElOued', NULL),
(26, NULL, '$2a$10$bU39qfZtLYUdwuivlWxnv.R5tMMh2P8tQXmuqTzBs95gf.uAweSyK', 'aal1 almarsa', NULL),
(27, NULL, '$2a$10$27qFBvUlZoELDAzQzB61k.gJm2Vz5iteAt.djDSgCz7lvH8WqGTfW', 'aal2 almarsa', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `app_user_roles`
--

CREATE TABLE `app_user_roles` (
  `app_user_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `app_user_roles`
--

INSERT INTO `app_user_roles` (`app_user_id`, `roles_id`) VALUES
(1, 1),
(1, 2),
(2, 1),
(2, 2),
(3, 1),
(3, 2),
(4, 1),
(4, 2),
(5, 1),
(5, 2),
(6, 1),
(6, 2),
(7, 1),
(7, 2),
(8, 1),
(8, 2),
(9, 1),
(9, 2),
(10, 1),
(10, 2),
(11, 1),
(11, 2),
(12, 1),
(12, 2),
(13, 1),
(13, 2),
(14, 1),
(14, 2),
(15, 1),
(15, 2),
(16, 1),
(16, 2),
(17, 1),
(17, 2),
(18, 1),
(18, 2),
(19, 1),
(19, 2),
(20, 1),
(20, 2),
(21, 1),
(21, 2),
(22, 1),
(22, 2);

-- --------------------------------------------------------

--
-- Table structure for table `categorie`
--

CREATE TABLE `categorie` (
  `id` int(11) NOT NULL,
  `designation` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `categorie`
--

INSERT INTO `categorie` (`id`, `designation`) VALUES
(1, 'قاعات الحفلات'),
(2, 'المستشفيات'),
(3, 'الصيدليات');

-- --------------------------------------------------------

--
-- Table structure for table `district`
--

CREATE TABLE `district` (
  `id` int(11) NOT NULL,
  `designation` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `district`
--

INSERT INTO `district` (`id`, `designation`) VALUES
(1, 'الدائرة الحضرية الأولى'),
(2, 'الدائرة الحضرية الثانية'),
(3, 'الدائرة الحضرية الثالتة'),
(4, 'الدائرة الحضرية الرابعة'),
(5, 'الدائرة الحضرية الخامسة'),
(6, 'الدائرة الحضرية السادسة'),
(7, 'دائرة العيون'),
(8, 'باشوية المرسى');

-- --------------------------------------------------------

--
-- Table structure for table `endroit`
--

CREATE TABLE `endroit` (
  `id` int(11) NOT NULL,
  `adress` varchar(255) DEFAULT NULL,
  `annexe_name` varchar(255) DEFAULT NULL,
  `categorie_name` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `district_name` varchar(255) DEFAULT NULL,
  `identifiant` varchar(255) DEFAULT NULL,
  `observations` varchar(255) DEFAULT NULL,
  `report_title` varchar(255) DEFAULT NULL,
  `superficie` int(11) NOT NULL,
  `x` float NOT NULL,
  `y` float NOT NULL,
  `annexe_id` int(11) DEFAULT NULL,
  `categorie_id` int(11) DEFAULT NULL,
  `district_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `endroit`
--

INSERT INTO `endroit` (`id`, `adress`, `annexe_name`, `categorie_name`, `contact`, `designation`, `district_name`, `identifiant`, `observations`, `report_title`, `superficie`, `x`, `y`, `annexe_id`, `categorie_id`, `district_id`) VALUES
(1, 'Moulay Hassan Ben Mehdi Hospital, Avenue Abou Baker Seddik, Laayoune,', 'الملحقة الإدارية 1', 'المستشفيات', '0654352456', 'مستشفى بن المهدي', 'الدائرة الحضرية الأولى', NULL, '', NULL, 230, 27.1568, -13.1892, 1, 2, 1),
(2, 'Pharmacie principale, Boulevard Boukraa, Laayoune, Pachalik de Laâyoune', 'الملحقة الإدارية 4', 'الصيدليات', '0676525437', 'صيدلية شارع بووكراع', 'الدائرة الحضرية الثانية', NULL, '', NULL, 300, 27.1475, -13.1992, 4, 3, 2),
(3, 'Pharmacie principale, Boulevard Boukraa, Laayoune', 'الملحقة الإدارية 5', 'الصيدليات', '0676525437', 'صيدلة أشرف', 'الدائرة الحضرية الثانية', NULL, '', NULL, 230, 27.1464, -13.1972, 5, 3, 2),
(4, 'Mosquée Miftah al Hamd, Rue 2, Laayoune, Pachalik de Laâyoune', 'الملحقة الحضرية 1 المسيرة', 'الصيدليات', '0654352456', 'صيدلة عائشة', 'باشوية المرسى', NULL, '', NULL, 210, 27.1433, -13.1935, 25, 3, 8),
(5, 'Mosquée Miftah al Hamd, Rue 2, Laayoune, Pachalik de Laâyoune, Laayoune Province, 70014, Morocco', 'الملحقة الإدارية 1', 'قاعات الحفلات', '0654352456', 's\"és', 'الدائرة الحضرية الأولى', NULL, '', NULL, 23, 22, 2323, 1, 1, 1),
(6, 'Mosquée Miftah al Hamd, Rue 2, Laayoune, Pachalik de Laâyoune', 'الملحقة الإدارية 2', 'قاعات الحفلات', '0654352456', 'drrr', 'الدائرة الحضرية الأولى', NULL, NULL, NULL, 23, 23, 23, 2, 1, 1),
(7, 'Mosquée Miftah al Hamd, Rue 2, Laayoune, Pachalik de Laâyoune, Laayoune Province, 70014, Morocco', 'الملحقة الإدارية 3', 'الصيدليات', '0654352456', 's\"és', 'الدائرة الحضرية الأولى', NULL, '', NULL, 0, 23, 2, 3, 3, 1),
(8, 'Mosquée Miftah al Hamd, Rue 2, Laayoune, Pachalik de Laâyoune, Laayoune Province, 70014, Morocco', 'الملحقة الإدارية 3', 'المستشفيات', '0654352456', 'drrr', 'الدائرة الحضرية الأولى', NULL, '', NULL, 23, 223, 23, 3, 2, 1),
(9, '4F4F', 'الملحقة الإدارية 4', 'المستشفيات', '0654352456', 'cat1', 'الدائرة الحضرية الثانية', NULL, '', NULL, 0, 23, 3, 4, 2, 2),
(10, 'Mosquée Miftah al Hamd, Rue 2, Laayoune, Pachalik de Laâyoune, Laayoune Province, 70014, Morocco', 'الملحقة الإدارية 5', 'الصيدليات', '0654352456', 's\"és', 'الدائرة الحضرية الثانية', NULL, NULL, NULL, 23, 23, 23, 5, 3, 2),
(11, 'Mosquée Miftah al Hamd, Rue 2, Laayoune, Pachalik de Laâyoune, Laayoune Province, 70014, Morocco', 'الملحقة الإدارية 6', 'قاعات الحفلات', '4FR', 's\"és', 'الدائرة الحضرية الثانية', NULL, '', NULL, 23, 23, 23, 6, 1, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `annexe`
--
ALTER TABLE `annexe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1yih71627tueh73qkmmqhswtq` (`district_id`);

--
-- Indexes for table `app_role`
--
ALTER TABLE `app_role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `app_user`
--
ALTER TABLE `app_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_3k4cplvh82srueuttfkwnylq0` (`username`),
  ADD KEY `FKjhkjhpuuiu6bwvxdmvhgouvol` (`annexe_id`);

--
-- Indexes for table `app_user_roles`
--
ALTER TABLE `app_user_roles`
  ADD KEY `FK1pfb2loa8so5oi6ak7rh6enva` (`roles_id`),
  ADD KEY `FKkwxexnudtp5gmt82j0qtytnoe` (`app_user_id`);

--
-- Indexes for table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `district`
--
ALTER TABLE `district`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `endroit`
--
ALTER TABLE `endroit`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfscgkc3g9mb8k3q0xj83t2xi6` (`annexe_id`),
  ADD KEY `FKnhimje8d2uwrf75q01kt9hphq` (`categorie_id`),
  ADD KEY `FKmkcjvhq35hhtiasku0hopyv8` (`district_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `annexe`
--
ALTER TABLE `annexe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `app_role`
--
ALTER TABLE `app_role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `app_user`
--
ALTER TABLE `app_user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `district`
--
ALTER TABLE `district`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `endroit`
--
ALTER TABLE `endroit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `annexe`
--
ALTER TABLE `annexe`
  ADD CONSTRAINT `FK1yih71627tueh73qkmmqhswtq` FOREIGN KEY (`district_id`) REFERENCES `district` (`id`);

--
-- Constraints for table `app_user`
--
ALTER TABLE `app_user`
  ADD CONSTRAINT `FKjhkjhpuuiu6bwvxdmvhgouvol` FOREIGN KEY (`annexe_id`) REFERENCES `annexe` (`id`);

--
-- Constraints for table `app_user_roles`
--
ALTER TABLE `app_user_roles`
  ADD CONSTRAINT `FK1pfb2loa8so5oi6ak7rh6enva` FOREIGN KEY (`roles_id`) REFERENCES `app_role` (`id`),
  ADD CONSTRAINT `FKkwxexnudtp5gmt82j0qtytnoe` FOREIGN KEY (`app_user_id`) REFERENCES `app_user` (`id`);

--
-- Constraints for table `endroit`
--
ALTER TABLE `endroit`
  ADD CONSTRAINT `FKfscgkc3g9mb8k3q0xj83t2xi6` FOREIGN KEY (`annexe_id`) REFERENCES `annexe` (`id`),
  ADD CONSTRAINT `FKmkcjvhq35hhtiasku0hopyv8` FOREIGN KEY (`district_id`) REFERENCES `district` (`id`),
  ADD CONSTRAINT `FKnhimje8d2uwrf75q01kt9hphq` FOREIGN KEY (`categorie_id`) REFERENCES `categorie` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
