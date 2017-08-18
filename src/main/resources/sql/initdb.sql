CREATE DATABASE IF NOT EXISTS activiti DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

CREATE TABLE activiti.customer (
	first_name VARCHAR(100),
	id INTEGER NOT NULL AUTO_INCREMENT,
	last_name VARCHAR(100),
	email VARCHAR(100),
	birthday DATETIME,
	PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;