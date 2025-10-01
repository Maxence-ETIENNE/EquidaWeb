-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3307
-- Généré le : mer. 01 oct. 2025 à 10:02
-- Version du serveur : 11.3.2-MariaDB
-- Version de PHP : 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `equida`
--

-- --------------------------------------------------------

--
-- Structure de la table `categvente`
--

DROP TABLE IF EXISTS `categvente`;
CREATE TABLE IF NOT EXISTS `categvente` (
  `code` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(150) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

--
-- Déchargement des données de la table `categvente`
--

INSERT INTO `categvente` (`code`, `libelle`) VALUES
(1, 'Vente simple'),
(2, 'Vente mixte de février'),
(3, 'Vente d\'été'),
(4, 'Vente d\'automne'),
(5, 'Vente d\'élevage');

-- --------------------------------------------------------

--
-- Structure de la table `cheval`
--

DROP TABLE IF EXISTS `cheval`;
CREATE TABLE IF NOT EXISTS `cheval` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(150) NOT NULL,
  `date_naissance` date NOT NULL,
  `sexe` varchar(1) NOT NULL,
  `sire` varchar(13) NOT NULL,
  `race_id` int(11) DEFAULT NULL,
  `pere_id` int(11) DEFAULT NULL,
  `mere_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_race` (`race_id`),
  KEY `fk_pere` (`pere_id`) USING BTREE,
  KEY `fk_mere` (`mere_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `cheval`
--

INSERT INTO `cheval` (`id`, `nom`, `date_naissance`, `sexe`, `sire`, `race_id`, `pere_id`, `mere_id`) VALUES
(1, 'Eclipse', '2017-03-12', 'M', '0001.000.0001', 4, NULL, NULL),
(2, 'Aztec', '2019-07-04', 'F', '0001.000.0002', 4, NULL, NULL),
(3, 'Orion', '2015-05-23', 'M', '0001.000.0003', 5, NULL, NULL),
(4, 'Tempête de Feu', '2017-03-12', 'F', '0001.000.0004', 1, NULL, NULL),
(5, 'Éclair Noir', '2019-07-04', 'M', '0001.000.0005', 2, NULL, NULL),
(6, 'Vent du Nord', '2015-05-23', 'F', '0001.000.0006', 3, NULL, NULL),
(7, 'Comète', '2018-01-01', 'M', '0001.000.0007', 4, NULL, NULL),
(8, 'Silver Snow', '2020-11-17', 'F', '0001.000.0008', 5, NULL, NULL),
(9, 'Caramel', '2016-06-30', 'M', '0001.000.0009', 6, NULL, NULL),
(10, 'Storm', '2021-10-10', 'F', '0001.000.0010', 1, NULL, NULL),
(11, 'Mustang', '2014-08-03', 'M', '0001.000.0011', 2, NULL, NULL),
(12, 'Rising Sun', '2019-04-22', 'F', '0001.000.0012', 3, NULL, NULL),
(13, 'Phantom', '2016-12-05', 'M', '0001.000.0013', 4, NULL, NULL),
(14, 'Pompom', '2025-07-13', 'F', '0001.000.0014', 2, NULL, NULL),
(15, 'Fleur du désert', '2023-06-30', 'M', '0001.000.0015', 6, NULL, NULL),
(16, 'Valdack', '2025-09-23', 'M', '0002.000.0001', 1, 17, 18),
(17, 'Houri', '2025-09-01', 'M', '0002.000.0002', 1, NULL, NULL),
(18, 'Yastale', '2025-09-02', 'F', '0002.000.0003', 1, NULL, NULL),
(19, 'Trais d\'or', '2025-09-22', 'M', '0002.000.0004', 7, NULL, 20),
(20, 'Doune', '2025-09-04', 'F', '0002.000.0005', 7, NULL, NULL),
(21, 'Herricka', '2025-09-21', 'F', '0002.000.0006', 1, 17, 22),
(22, 'Hussa', '2025-09-05', 'F', '0002.000.0007', 1, NULL, NULL),
(23, 'Nuage', '2025-09-20', 'M', '0002.000.0008', 7, 24, 25),
(24, 'Kop', '2025-09-06', 'M', '0002.000.0009', 7, NULL, NULL),
(25, 'Jarria', '2025-09-07', 'F', '0002.000.0010', 7, NULL, NULL),
(26, 'Desperado', '2025-09-19', 'M', '0002.000.0011', 7, 27, NULL),
(27, 'Lappon', '2025-09-08', 'M', '0002.000.0012', 7, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `chevalcourse`
--

DROP TABLE IF EXISTS `chevalcourse`;
CREATE TABLE IF NOT EXISTS `chevalcourse` (
  `course_id` int(11) NOT NULL,
  `cheval_id` int(11) NOT NULL,
  `position` int(11) NOT NULL,
  KEY `fk_course_id` (`course_id`) USING BTREE,
  KEY `fk_cheval_id` (`cheval_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

--
-- Déchargement des données de la table `chevalcourse`
--

INSERT INTO `chevalcourse` (`course_id`, `cheval_id`, `position`) VALUES
(1, 21, 3),
(2, 21, 1),
(3, 21, 4);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(50) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `rue` varchar(150) NOT NULL,
  `cpos` varchar(6) NOT NULL,
  `ville` varchar(100) NOT NULL,
  `adresseMessagerie` varchar(150) NOT NULL,
  `pays_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE IF NOT EXISTS `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  `lieu` varchar(100) NOT NULL,
  `date` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

--
-- Déchargement des données de la table `course`
--

INSERT INTO `course` (`id`, `nom`, `lieu`, `date`) VALUES
(1, 'Dahman', 'Dax', '10/06/2025'),
(2, 'Danbik', 'Aurillac', '25/05/2025'),
(3, 'Pierre Pechdo', 'Pompadour', '06/05/2025');

-- --------------------------------------------------------

--
-- Structure de la table `lieu`
--

DROP TABLE IF EXISTS `lieu`;
CREATE TABLE IF NOT EXISTS `lieu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ville` varchar(150) NOT NULL,
  `nbBoxes` int(11) NOT NULL,
  `commentaires` varchar(140) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

--
-- Déchargement des données de la table `lieu`
--

INSERT INTO `lieu` (`id`, `ville`, `nbBoxes`, `commentaires`) VALUES
(1, 'Lille', 5, 'Commentaire lieu 1'),
(2, 'Toulouse', 10, 'Commentaire lieu 2');

-- --------------------------------------------------------

--
-- Structure de la table `lot`
--

DROP TABLE IF EXISTS `lot`;
CREATE TABLE IF NOT EXISTS `lot` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prixDepart` int(11) NOT NULL,
  `cheval_id` int(11) DEFAULT NULL,
  `vente_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cheval` (`cheval_id`),
  KEY `fk_vente` (`vente_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

--
-- Déchargement des données de la table `lot`
--

INSERT INTO `lot` (`id`, `prixDepart`, `cheval_id`, `vente_id`) VALUES
(1, 10000, 16, 1),
(2, 7000, 19, 1),
(3, 56000, 21, 1),
(4, 6500, 23, 1),
(5, 60000, 26, 1),
(6, 35000, 9, 2);

-- --------------------------------------------------------

--
-- Structure de la table `pays`
--

DROP TABLE IF EXISTS `pays`;
CREATE TABLE IF NOT EXISTS `pays` (
  `code` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

--
-- Déchargement des données de la table `pays`
--

INSERT INTO `pays` (`code`, `nom`) VALUES
(1, 'France'),
(2, 'Royaume-Uni'),
(3, 'Espagne'),
(4, 'Allemagne'),
(5, 'Belgique'),
(6, 'Italie'),
(7, 'Pays-Bas'),
(8, 'Suisse'),
(9, 'Etats-Unis'),
(10, 'Autriche');

-- --------------------------------------------------------

--
-- Structure de la table `race`
--

DROP TABLE IF EXISTS `race`;
CREATE TABLE IF NOT EXISTS `race` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  `description` varchar(140) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `race`
--

INSERT INTO `race` (`id`, `nom`, `description`) VALUES
(1, 'Pur-sang anglais', 'Race de cheval 1'),
(2, 'Quarter Horse', 'Race de cheval 2'),
(3, 'Frison', 'Race de cheval 3'),
(4, 'Andalou', 'Race de cheval 4'),
(5, 'Lipizzan', 'Race de cheval 5'),
(6, 'Mustang', 'Race de cheval 6'),
(7, 'Yearling', 'Race de cheval 7');

-- --------------------------------------------------------

--
-- Structure de la table `vente`
--

DROP TABLE IF EXISTS `vente`;
CREATE TABLE IF NOT EXISTS `vente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `dateDebutVente` date NOT NULL,
  `lieu_id` int(11) NOT NULL,
  `categvente_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_lieu` (`lieu_id`),
  KEY `fk_categvente` (`categvente_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

--
-- Déchargement des données de la table `vente`
--

INSERT INTO `vente` (`id`, `nom`, `dateDebutVente`, `lieu_id`, `categvente_id`) VALUES
(1, 'Vente d\'été du 12 juillet 2025', '2025-07-12', 1, 3),
(2, 'Vente simple du 23 juin 2025', '2025-06-23', 2, 1);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `cheval`
--
ALTER TABLE `cheval`
  ADD CONSTRAINT `cheval_ibfk_1` FOREIGN KEY (`pere_id`) REFERENCES `cheval` (`id`),
  ADD CONSTRAINT `cheval_ibfk_2` FOREIGN KEY (`mere_id`) REFERENCES `cheval` (`id`),
  ADD CONSTRAINT `fk_race` FOREIGN KEY (`race_id`) REFERENCES `race` (`id`);

--
-- Contraintes pour la table `chevalcourse`
--
ALTER TABLE `chevalcourse`
  ADD CONSTRAINT `chevalcourse_ibfk_1` FOREIGN KEY (`cheval_id`) REFERENCES `cheval` (`id`),
  ADD CONSTRAINT `chevalcourse_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`);

--
-- Contraintes pour la table `lot`
--
ALTER TABLE `lot`
  ADD CONSTRAINT `lot_ibfk_1` FOREIGN KEY (`vente_id`) REFERENCES `vente` (`id`),
  ADD CONSTRAINT `lot_ibfk_2` FOREIGN KEY (`cheval_id`) REFERENCES `cheval` (`id`);

--
-- Contraintes pour la table `vente`
--
ALTER TABLE `vente`
  ADD CONSTRAINT `vente_ibfk_1` FOREIGN KEY (`lieu_id`) REFERENCES `lieu` (`id`),
  ADD CONSTRAINT `vente_ibfk_2` FOREIGN KEY (`categvente_id`) REFERENCES `categvente` (`code`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
