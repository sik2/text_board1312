create database proj1;

use proj1;

create table article (
	id int UNSIGNED NOT NULL AUTO_INCREMENT,
	title varchar(100) NOT NULL,
	content text NOT NULL,
	author varchar(50) NOT NULL,
	regDate datetime NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE `member` (
	id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	userId varchar(50) NOT NULL UNIQUE,
	password varchar(100) NOT NULL,
	regDate datetime NOT NULL
);

INSERT INTO `member`
SET userId = "member1",
password = "1234",
regDate = now();

INSERT INTO `member`
SET userId = "member2",
password = "1234",
regDate = now();

INSERT INTO `member`
SET userId = "member3",
password = "1234",
regDate = now();

INSERT INTO article
SET title = "test",
content = "test",
author = "member1",
regDate = now();

INSERT INTO article
SET title = "test2",
content = "test2",
author = "member2",
regDate = now();