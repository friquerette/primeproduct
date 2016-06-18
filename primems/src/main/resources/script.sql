-- ALTER TABLE category DROP CONSTRAINT parentCategory;
-- ALTER TABLE product DROP CONSTRAINT productCategory;

-- DROP TABLE category;
-- DROP TABLE product;
-- DROP TABLE customer;

drop database primems;
create database primems;
use primems;

CREATE TABLE customer (
	customer_id INT NOT NULL AUTO_INCREMENT,
	create_date DATETIME,
	update_date DATETIME,
	created_by INT NULL,
	last_modified_by INT NULL,
	active TINYINT NOT NULL,
	firstName VARCHAR(255) NOT NULL,
	lastName VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	login VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	-- salt VARCHAR(255) NOT NULL,
	admin TINYINT NOT NULL,
	PRIMARY KEY ( customer_id )
)
ENGINE InnoDB;

INSERT INTO customer (create_date, update_date, active, firstName, lastName, email, login, password, /*salt,*/ admin)
VALUES (now(), now(), 1, 'Jean', 'Martin', 'jean@martin.fr', 'jmartin', '17Juin15:17', /*'',*/ 1);

SELECT * FROM customer;

CREATE TABLE category (
	category_id INT NOT NULL AUTO_INCREMENT,
	create_date DATETIME,
	update_date DATETIME,
	created_by INT NOT NULL,
	last_modified_by INT NOT NULL,
	active TINYINT NOT NULL,
	name VARCHAR(255) NULL,
	description VARCHAR(255) NULL,
	parent_id INT NULL,
	PRIMARY KEY ( category_id )
)
ENGINE InnoDB;

INSERT INTO category (create_date, update_date, created_by, last_modified_by, active, name, description, parent_id)
VALUES (now(), now(), 1, 1, 1, 'Computers & Office', null, null);
INSERT INTO category (create_date, update_date, created_by, last_modified_by, active, name, description, parent_id)
VALUES (now(), now(), 1, 1, 1, 'Electronics', null, null);
INSERT INTO category (create_date, update_date, created_by, last_modified_by, active, name, description, parent_id)
VALUES (now(), now(), 1, 1, 1, 'Fashion & Beauty', null, null);
INSERT INTO category (create_date, update_date, created_by, last_modified_by, active, name, description, parent_id)
VALUES (now(), now(), 1, 1, 1, 'Video games', null, null);
INSERT INTO category (create_date, update_date, created_by, last_modified_by, active, name, description, parent_id)
VALUES (now(), now(), 1, 1, 1, 'Books, Movies, Music', null, null);
INSERT INTO category (create_date, update_date, created_by, last_modified_by, active, name, description, parent_id)
VALUES (now(), now(), 1, 1, 1, 'Home & Household', null, null);
INSERT INTO category (create_date, update_date, created_by, last_modified_by, active, name, description, parent_id)
VALUES (now(), now(), 1, 1, 1, 'Health & Fitness', null, null);
INSERT INTO category (create_date, update_date, created_by, last_modified_by, active, name, description, parent_id)
VALUES (now(), now(), 1, 1, 1, 'Toy & Baby', null, null);
INSERT INTO category (create_date, update_date, created_by, last_modified_by, active, name, description, parent_id)
VALUES (now(), now(), 1, 1, 1, 'Deals & More', null, null);

CREATE TABLE product (
	product_id INT NOT NULL AUTO_INCREMENT,
	category_id INT NOT NULL,
	create_date DATETIME,
	update_date DATETIME,
	created_by INT NOT NULL,
	last_modified_by INT NOT NULL,
	active TINYINT NOT NULL,
	owner INT NOT NULL,
	title VARCHAR(255) NULL,
	description TEXT NULL,
	currency VARCHAR(255) NULL,
	price DECIMAL(10,2),
	PRIMARY KEY ( product_id )
)
ENGINE InnoDB;

ALTER TABLE product 
    ADD CONSTRAINT productCategory
    FOREIGN KEY(category_id)
    REFERENCES category(category_id);

ALTER TABLE category 
    ADD CONSTRAINT parentCategory
    FOREIGN KEY(parent_id)
    REFERENCES category(category_id);
