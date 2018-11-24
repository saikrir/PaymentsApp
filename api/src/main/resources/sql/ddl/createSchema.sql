CREATE DATABASE `MyPayments_TEST`;

USE MyPayments_TEST;

CREATE TABLE `Product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `payment_due_by` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `Product_User` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `emailId` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `User_Product_Payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `payment_date` date NOT NULL,
  `paid_by_user` int(11) NOT NULL,
  `payment_term` varchar(45) NOT NULL,
  `amount` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_User_Product_Payment_1_idx` (`product_id`),
  KEY `fk_User_Product_Payment_2_idx` (`paid_by_user`),
  CONSTRAINT `fk_User_Product_Payment_1` FOREIGN KEY (`product_id`) REFERENCES `Product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_Product_Payment_2` FOREIGN KEY (`paid_by_user`) REFERENCES `Product_User` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
