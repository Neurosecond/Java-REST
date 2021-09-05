DROP DATABASE if EXISTS sample;
CREATE DATABASE sample;
USE sample;
DROP TABLE IF EXISTS `form`;
CREATE TABLE form (
	formId bigint(20) NOT NULL AUTO_INCREMENT,
    organizationForm varchar(200),
    PRIMARY KEY (`formId`) USING BTREE
 )  ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8;

INSERT INTO form (formId, organizationForm) values
	(1, 'Казенное предприятие'),
	(2, 'Непубличное акционерное общество'),
	(3, 'Общество с ограниченной ответственностью'),
	(4, 'Автономная некоммерческая организация');

DROP TABLE IF EXISTS `client`;
CREATE TABLE client (
	clientId bigint(20) NOT NULL AUTO_INCREMENT,
	clientName varchar(200) NOT NULL,
	clientTitle varchar(50) NOT NULL,
	clientAddress varchar(200) NOT NULL,
	formId bigint(20) NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`clientId`) USING BTREE,
	CONSTRAINT `formId` FOREIGN KEY (`formId`) REFERENCES `form` (`formId`)
 )  ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO client clientId, clientName, clientTitle, clientAddress, formId) values 
	(1, 'Производственное объединение "Уральский оптико-механический завод" имени Э.С. Яламова', 'ПО "УОМЗ"', 'Свердловская область, город Екатеринбург, улица Восточная, дом 33Б', 2),
	(2, '"Электросистем"', '"ЭС"', 'Свердловская область, Верхняя Пышма, Индустриальный проезд, строение 1/2', 3),
	(3, 'Медицинское объединение "Новая Больница"', 'МО "НБ"', 'Свердловская область, город Екатеринбург, улица Заводская, дом 29', 3),
	(4, 'Институт физики металлов имени М.Н. Михеева Уральского отделения Российской Академии наук', 'ИФМ УрО РАН', 'Свердловская область, город Екатеринбург, улица Софьи Ковалевской, дом 18', 1),
	(5, 'Отдел Медицинской Техники - Сервис', '"ОМТ-Сервис"', 'Свердловская область, город Екатеринбург, улица Белореченская, дом 22', 3),
	(6, '"Финансово-Хозяйственное Управление" Министерства Здравоохранения Свердловской области', '"ФХУ" МЗ СО', 'Свердловская область, город Екатеринбург, улица Вайнера, дом 34Б', 1),
	(7, '"Клинический Институт Мозга"', '"КИМ"', 'Свердловская область, город Екатеринбург, улица Ясная, дом 38', 4),
	(8, 'Уральский государственный университет имени А.М. Горького', 'УрГУ', 'Свердловская область, город Екатеринбург, проспект Ленина, дом 51', 1),
	(9, '"Первоуральский Хлебокомбинат"', '"ПХК"', 'Свердловская область, город Первоуральск, улица Ленина, дом 154', 3);

DROP TABLE IF EXISTS `bank`;
CREATE TABLE bank (
	bankId bigint(20) NOT NULL AUTO_INCREMENT,
	bankName varchar(128) NOT NULL,
	bankIdCode bigint(20) NOT NULL,
	PRIMARY KEY (`bankId`) USING BTREE,
	UNIQUE KEY `UNI_bankIdCode` (`bankIdCode`) USING BTREE
 )  ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO bank (bankId, bankName, bankIdCode) values 
	(1, 'Сбербанк', 044525225),
	(2, 'Газпромбанк', 044525823),
	(3, 'Новикомбанк', 044525162),
	(4, 'Альфа-Банк', 044525593),
	(5, 'СКБ-Банк', 046577756),
	(6, 'УБРИР', 046577795);

DROP TABLE IF EXISTS `deposit`;
CREATE TABLE deposit (
	depositId bigint(20) NOT NULL AUTO_INCREMENT,
	clientId bigint(20) NOT NULL AUTO_INCREMENT,
	bankId bigint(20) NOT NULL AUTO_INCREMENT,
	depositOpen date,
	depositRate decimal,
	depositClose date,
    PRIMARY KEY (`depositId`) USING BTREE,
	CONSTRAINT `clientId` FOREIGN KEY (`clientId`) REFERENCES `client` (`clientId`),
    CONSTRAINT `bankId` FOREIGN KEY (`bankId`) REFERENCES `bank` (`bankId`)
 )  ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO deposit (depositId, clientId, bankId, depositOpen, depositRate, depositClose) values 
	(1, 1, 1, 1994-10-04, 15.00, 2003-06-28),
	(2, 1, 1, 2010-12-22, 4.75, 2030-12-17),
	(3, 1, 2, 2008-05-14, 11.25, 2024-01-29),
	(4, 1, 3, 2013-11-01, 6.50, 2035-11-03),
	(5, 2, 1, 2017-12-10, 5.75, 2025-12-12),
	(6, 3, 4, 2011-03-18, 5.25, 2025-01-24),
	(7, 4, 1, 2015-12-10, 5.00, 2022-12-10),
	(8, 5, 5, 2013-03-22, 4.75, 2021-12-01),
	(9, 6, 1, 2012-07-15, 6.25, 2025-06-08),
	(10, 7, 6, 2011-03-16, 7.50, 2013-04-02),
	(11, 8, 1, 1998-02-01, 12.25, 2004-12-01),
	(12, 8, 5, 2007-03-27, 5.75, 2010-09-21),
	(13, 9, 2, 1999-12-23, 11.50, 2013-05-14);

