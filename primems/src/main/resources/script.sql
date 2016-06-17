drop database primems;
create database primems;
use primems;

DROP TABLE customer;

CREATE TABLE customer (
	customer_id INT NOT NULL AUTO_INCREMENT,
	firstName VARCHAR(255) NOT NULL,
	lastName VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	login VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	salt VARCHAR(255) NOT NULL,
	admin TINYINT NOT NULL,
	active TINYINT NOT NULL,
	PRIMARY KEY ( customer_id )
)
ENGINE InnoDB;

INSERT INTO customer (firstName, lastName, email, login, password, salt, admin, active)
VALUES ('Jean', 'Martin', 'jean@martin.fr', 'jmartin', '17Juin15:17', '', 1, 1);

SELECT * FROM customer;