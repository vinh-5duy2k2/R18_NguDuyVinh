DROP DATABASE IF EXISTS Control_Fresher;
CREATE DATABASE Control_Fresher;
USE Control_Fresher;

-- Exercise 1: Design a table
-- Question 1: Thêm table với các ràng buộc và kiểu dữ liệu 
DROP TABLE IF EXISTS Trainee;
CREATE TABLE IF NOT EXISTS Trainee(
	TraineeID 			INT UNSIGNED 		PRIMARY KEY AUTO_INCREMENT,
    Full_Name 			Varchar(50) 		NOT NULL,
    Birth_Date 			DATE 				NOT NULL,
    Gender 				ENUM('Male','Female','Unknown'),
    ET_IQ 				TINYINT UNSIGNED	CHECK(ET_IQ < 20),
    ET_Gmath 			TINYINT UNSIGNED	CHECK(ET_Gmath < 50),
    ET_English 			TINYINT UNSIGNED	CHECK(ET_English < 50),
    Training_class		Char(10) 			NOT NULL,
    Evaluation_Notes	Varchar(255)
);

-- Question 2: Thêm trường VTI_Account với điều kiện NOT NULL và UNIQUE
ALTER TABLE Trainee
ADD VTI_Account 		Char(50) 			NOT NULL UNIQUE;

-- Exercise 2: Data Types
DROP TABLE IF EXISTS Data_Types1;
CREATE TABLE IF NOT EXISTS Data_Types1(
	ID 				INT UNSIGNED 	PRIMARY KEY AUTO_INCREMENT,
    `Name` 			Varchar(50)		NOT NULL,
    `Code`			Char(5) 		NOT NULL,
    ModifiedDate	DATETIME 		NOT NULL);
    
-- Exercise 3: Data Types (2)
DROP TABLE IF EXISTS Data_Types2;
CREATE TABLE IF NOT EXISTS Data_Types2(
	ID 				INT UNSIGNED 	PRIMARY KEY AUTO_INCREMENT,
    `Name` 			Varchar(50)		NOT NULL,
    BirthDate		DATE			NOT NULL,
    Gender			ENUM('Male','Female','Unknown'),
    IsDaleteFlag	ENUM('Dang hoat dong','Da xoa'));


