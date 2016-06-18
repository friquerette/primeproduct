drop database primems;
create database primems;
use primems;

DROP TABLE customer;

CREATE TABLE customer (
	customer_id INT NOT NULL AUTO_INCREMENT,
	create_date DATETIME,
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

INSERT INTO customer (create_date, firstName, lastName, email, login, password, salt, admin, active)
VALUES (now(), 'Jean', 'Martin', 'jean@martin.fr', 'jmartin', '17Juin15:17', '', 1, 1);

SELECT * FROM customer;

DROP TABLE category;
CREATE TABLE category (
	category_id INT NOT NULL AUTO_INCREMENT,
	create_date DATETIME,
	name VARCHAR(255) NOT NULL,
	description VARCHAR(255) NOT NULL,
	PRIMARY KEY ( category_id )
)
ENGINE InnoDB;

DROP TABLE product;
CREATE TABLE product (
	product_id INT NOT NULL AUTO_INCREMENT,
	category_id INT NOT NULL,
	create_date DATETIME,
	title VARCHAR(255) NULL,
	description TEXT NULL,
	price DECIMAL(10,2),
	PRIMARY KEY ( product_id )
)
ENGINE InnoDB;

ALTER TABLE product 
    ADD CONSTRAINT productCategory
    FOREIGN KEY(category_id)
    REFERENCES category(category_id);