DROP DATABASE IF EXISTS StudentInstitute;
CREATE DATABASE IF NOT EXISTS StudentInstitute;
SHOW DATABASES ;
USE StudentInstitute;

#-------------------------------------------------------------

DROP TABLE IF EXISTS Student;
CREATE TABLE IF NOT EXISTS Student(
	studentId VARCHAR(6),
	NIC VARCHAR(8),
	name VARCHAR(30) NOT NULL DEFAULT 'Unknown',
	gender VARCHAR(6),
	birthday VARCHAR(20),
	age INT DEFAULT 0,
	address VARCHAR(30) NOT NULL DEFAULT 'Unknown',
	CONSTRAINT PRIMARY KEY (studentId)
);
SHOW TABLES;
DESCRIBE Student;

#------------------------------------------------------------

DROP TABLE IF EXISTS Programme;
CREATE TABLE IF NOT EXISTS Programme(
	programmeId VARCHAR(6),
	programmeName VARCHAR(30) NOT NULL DEFAULT 'Unknown',
	duration VARCHAR(6),
	fee DOUBLE,
	CONSTRAINT PRIMARY KEY (programmeId)
);
SHOW TABLES;
DESCRIBE programme;

#------------------------------------------------------------

DROP TABLE IF EXISTS Registeration;
CREATE TABLE IF NOT EXISTS Registeration(
   registerId VARCHAR(6),
   studentId VARCHAR(6),
   registerDate DATE,
   time VARCHAR(15),
   payment DOUBLE,
   CONSTRAINT PRIMARY KEY (registerId),
   CONSTRAINT FOREIGN KEY (studentId) REFERENCES Student(studentId) ON DELETE CASCADE ON UPDATE CASCADE
);
SHOW TABLES ;
DESCRIBE Registeration;

#-------------------------------------------------------------

DROP TABLE IF EXISTS `Register Detail`;
CREATE TABLE IF NOT EXISTS `Register Detail`(
   programmeId VARCHAR(6),
   registerId VARCHAR(6),
   qty INT(11),
   fee DOUBLE,
   CONSTRAINT PRIMARY KEY (programmeId, registerId),
   CONSTRAINT FOREIGN KEY (programmeId) REFERENCES Programme(programmeId) ON DELETE CASCADE ON UPDATE CASCADE ,
   CONSTRAINT FOREIGN KEY (registerId) REFERENCES Registeration(registerId) ON DELETE CASCADE ON UPDATE CASCADE
);
SHOW TABLES ;
DESCRIBE `Register Detail`;

