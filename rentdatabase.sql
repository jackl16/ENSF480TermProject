DROP DATABASE IF EXISTS RENTDATABASE;
CREATE DATABASE RENTDATABASE; 
USE RENTDATABASE;


DROP TABLE IF EXISTS MANAGER;
CREATE TABLE MANAGER (
	ID			char(5) not null,
	Name			varchar(25),

	primary key (ManuID)
);

INSERT INTO MANAGER (ManuID, Name, Phone, Province)
VALUES
('001',	''),
('002',	'');


DROP TABLE IF EXISTS LANDLORD;
CREATE TABLE LANDLORD (
	ID				char(4)	not null,
	Name			varchar(25),
    Email			varchar(25),
	primary key (ID)
);

INSERT INTO LANDLORD (ID, Type, Legs, Arms, Seat, Cushion, Price, ManuID)
VALUES
('L001',	'Johnny John',	'johnjohn@landlord.com'),
('L002',	'Emily New',	'emilynew@landlord.com'),
('L003',	'Happy Bo',	'happybo123@landlord.com');

DROP TABLE IF EXISTS RENTER;
CREATE TABLE RENTER (
	ID				char(5)	not null,
	Name			varchar(25),

	primary key (ID)

);

INSERT INTO RENTER (ID, Name)
VALUES
('R3415',	'John Doe'),
('R5555',	'Robert Doe'),


DROP TABLE IF EXISTS RENTLOGIN;
CREATE TABLE RENTLOGIN (
	ID				char(5)	not null,
	Type			varchar(25),
	Username		varchar(25),
	Password		varchar(25),
	primary key (ID)
);

INSERT INTO RENTLOGIN (ID, Type, Username, Password)
VALUES
('RL001',	'Renter',	'Rentsalot',	'renter123'),
('RL002',	'Landlord',	'Mrlandlord',	'landlording'),
('RL003',	'Manager',	'Manages',	'manage'),
('RL004',	'Renter',	'Renting',	'rent');

DROP TABLE IF EXISTS PROPERTY;
CREATE TABLE PROPERTY (
	ID				char(4)	not null,
    LORDID			char(4) not null,
	Type			varchar(25),
	Bedrooms		integer,
	Bathrooms		integer,
	Furnished		char(1),
    CityQuad		char(2),
    State			varchar(25),
    Posted			char(1),
	primary key (ID),
	foreign key (LORDID) references LANDLORD(ID) ON UPDATE CASCADE
);


INSERT INTO PROPERTY (ID, LORDID, Type, Bedrooms, Bathrooms, Furnished, CityQuad, State, Posted)
VALUES
('0001',	'L001','Apartment',	2,	1,	'Y',	'NW',	'Rented', 'Y'),
('0002',	'L001','Attached House',	4,	2,	'Y',	'SW',	'Active', 'Y'),
('0003',	'L002','Detached House',	1,	1,	'Y',	'SW',	'Cancelled', 'Y'),
('0004',	'L003','Townhouse',	3,	1,	'Y',	'NE',	'Rented', 'Y'),
('0005',	'L002','Cabin',	1,	0,	'N',	'NW',	'Suspended', 'Y'),
('0006',	'L003','Bungalow',	4,	1,	'Y',	'SE',	'Rented', 'Y');
