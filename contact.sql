-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Sam 15 Octobre 2016 à 13:17
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `contact`
--

-- --------------------------------------------------------

--
-- Structure de la table `address`
--

CREATE TABLE IF NOT EXISTS `address` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `street` varchar(50) NOT NULL,
  `city` varchar(30) NOT NULL,
  `zip` varchar(10) NOT NULL,
  `country` varchar(30) NOT NULL,
  `idContact` int(5) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idContact` (`idContact`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `contact`
--

CREATE TABLE IF NOT EXISTS `contact` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) DEFAULT NULL,
  `prenom` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Contenu de la table `contact`
--

INSERT INTO `contact` (`id`, `nom`, `prenom`, `email`) VALUES
(1, 'toto', 'tata', 'tototata'),
(2, 'tutu', 'tata', 'teoetotez'),
(3, 'Quentin', 'Lassalle', 'qlassalle@gmail.com'),
(4, 'Rabeony', 'Arnaud', 'a_rabeony@hotmail.fr'),
(5, 'Nouveau', 'Contact', 'nouveau@contact');

-- --------------------------------------------------------

--
-- Structure de la table `contact_groupe`
--

CREATE TABLE IF NOT EXISTS `contact_groupe` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `idGroupe` int(5) NOT NULL,
  `idContact` int(5) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_index` (`idGroupe`,`idContact`),
  KEY `idGroupe` (`idGroupe`),
  KEY `idContact` (`idContact`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

CREATE TABLE IF NOT EXISTS `groupe` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `phone`
--

CREATE TABLE IF NOT EXISTS `phone` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `kind` varchar(10) NOT NULL,
  `number` varchar(10) NOT NULL,
  `idContact` int(5) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idContact` (`idContact`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `address`
--
ALTER TABLE `address`
  ADD CONSTRAINT `add_idContact` FOREIGN KEY (`idContact`) REFERENCES `contact` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `contact_groupe`
--
ALTER TABLE `contact_groupe`
  ADD CONSTRAINT `contact_groupe_idContact` FOREIGN KEY (`idContact`) REFERENCES `contact` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `contact_groupe_idGroupe` FOREIGN KEY (`idGroupe`) REFERENCES `groupe` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `phone`
--
ALTER TABLE `phone`
  ADD CONSTRAINT `idContact` FOREIGN KEY (`idContact`) REFERENCES `contact` (`id`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
