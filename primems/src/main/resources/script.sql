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
	enabled TINYINT NOT NULL,
	gender VARCHAR(255) NOT NULL,
	first_name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	username VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	birthDate DATE NULL,
	-- salt VARCHAR(255) NOT NULL,
	role VARCHAR(255) NOT NULL,
	PRIMARY KEY ( customer_id )
)
ENGINE InnoDB;

INSERT INTO customer (create_date, update_date, enabled, first_name, last_name, email, username, password, birthDate, /*salt,*/ role, gender)
VALUES (now(), now(), 1, 'Pierre', 'Apsyre', 'pierre@primems.com', 'admin', 'root123', '1981-04-01', /*'',*/ 'ROLE_ADMIN', 'MALE');
INSERT INTO customer (create_date, update_date, enabled, first_name, last_name, email, username, password, birthDate, /*salt,*/ role, gender)
VALUES (now(), now(), 1, 'Jeanne', 'Ubyon', 'jeanne@primems.com', 'user', 'user123', '1981-04-01', /*'',*/ 'ROLE_USER', 'FEMALE');

CREATE TABLE category (
	category_id INT NOT NULL AUTO_INCREMENT,
	create_date DATETIME,
	update_date DATETIME,
	created_by INT NOT NULL,
	last_modified_by INT NOT NULL,
	enabled TINYINT NOT NULL,
	name VARCHAR(255) NULL,
	description VARCHAR(255) NULL,
	parent_id INT NULL,
	PRIMARY KEY ( category_id )
)
ENGINE InnoDB;

INSERT INTO category (create_date, update_date, created_by, last_modified_by, enabled, name, description, parent_id)
VALUES (now(), now(), 1, 1, 1, 'Computers & Office', null, null);
INSERT INTO category (create_date, update_date, created_by, last_modified_by, enabled, name, description, parent_id)
VALUES (now(), now(), 1, 1, 1, 'Electronics', null, null);
INSERT INTO category (create_date, update_date, created_by, last_modified_by, enabled, name, description, parent_id)
VALUES (now(), now(), 1, 1, 1, 'Fashion & Beauty', null, null);
INSERT INTO category (create_date, update_date, created_by, last_modified_by, enabled, name, description, parent_id)
VALUES (now(), now(), 1, 1, 1, 'Video games', null, null);
INSERT INTO category (create_date, update_date, created_by, last_modified_by, enabled, name, description, parent_id)
VALUES (now(), now(), 1, 1, 1, 'Books, Movies, Music', null, null);
INSERT INTO category (create_date, update_date, created_by, last_modified_by, enabled, name, description, parent_id)
VALUES (now(), now(), 1, 1, 1, 'Home & Household', null, null);
INSERT INTO category (create_date, update_date, created_by, last_modified_by, enabled, name, description, parent_id)
VALUES (now(), now(), 1, 1, 1, 'Health & Fitness', null, null);
INSERT INTO category (create_date, update_date, created_by, last_modified_by, enabled, name, description, parent_id)
VALUES (now(), now(), 1, 1, 1, 'Toy & Baby', null, null);
INSERT INTO category (create_date, update_date, created_by, last_modified_by, enabled, name, description, parent_id)
VALUES (now(), now(), 1, 1, 1, 'Deals & More', null, null);

CREATE TABLE product (
	product_id INT NOT NULL AUTO_INCREMENT,
	category_id INT NOT NULL,
	create_date DATETIME,
	update_date DATETIME,
	created_by INT NOT NULL,
	last_modified_by INT NOT NULL,
	enabled TINYINT NOT NULL,
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

SELECT * FROM customer;
