DROP DATABASE IF EXISTS Testing_system;
CREATE DATABASE IF NOT EXISTS Testing_system;
Use Testing_system;
-- Xóa bảng Department
DROP TABLE 	IF EXISTS Department;
-- Tạo bảng Department
CREATE TABLE Department (
    DepartmentID TINYINT PRIMARY KEY AUTO_INCREMENT,
    DepartmentName VARCHAR(30)
);
-- Thêm thông tin vào bản Department
INSERT INTO Department(DepartmentName) VALUES 
	('Ban hang'),
    ('Maketing'),
    ('Bao ve'),
    ('Nhan su'),
    ('Pho giam doc'),
    ('Thu ky'),
    ('Giam doc'),
	('Tai chinh'),
    ('Quan ly');
    

-- Xóa bảng Position
DROP TABLE 	IF EXISTS `Position`;

-- Tạo bảng Position
CREATE TABLE `Position` (
    PositionID TINYINT PRIMARY KEY AUTO_INCREMENT,
    PositionName ENUM('Dev', 'Test', 'Scrum Master', 'PM')
);
-- Thêm thông tin vào bảng Position
INSERT INTO `Position`(PositionName) VALUES 
	('Dev'),
    ('Test'), 
    ('Scrum Master'), 
    ('PM');

-- Xóa bảng Account
DROP TABLE 	IF EXISTS `Account`;

-- Tạo bảng Account
CREATE TABLE `Account` (
    AccountID 		INT PRIMARY KEY AUTO_INCREMENT,
    Email 			VARCHAR(50) UNIQUE KEY,
    Username 		VARCHAR(30) UNIQUE KEY,
    FullName 		VARCHAR(30),
    DepartmentID 	TINYINT ,
    PositionID 		TINYINT ,
    CreateDate 		DATE,
    FOREIGN KEY (DepartmentID)	REFERENCES Department(DepartmentID),
    FOREIGN KEY (PositionID)	REFERENCES `Position`(PositionID)
);
-- Thêm thông tin vào bảng 
INSERT INTO `Account`(Email,Username,FullName,DepartmentID,PositionID,CreateDate) VALUES 
('account1@gmail.com','account1','Nguyen Van An',1,2,'2001-08-07'),
('account2@gmail.com','account2','Nguyen Van Binh',2,1,'2002-09-07'),
('account3@gmail.com','account3','Nguyen Van Chien',3,4,'2003-07-27'),
('account4@gmail.com','account4','Nguyen Thi Anh',4,3,'2007-08-07'),
('account5@gmail.com','account5','Nguyen Thi Bao',5,1,'2011-08-17'),
('account6@gmail.com','account6','Nguyen Thi Cuu',6,2,'2009-12-11'),
('account7@gmail.com','account7','Tran Van An',7,3,'2007-12-17'),
('account8@gmail.com','account8','Ngo Van Cuong',8,4,'2012-12-19'),
('account9@gmail.com','account9','Chu Thanh Tam',9,4,'2011-12-12'),
('account10@gmail.com','account10','Nguyen Thi Ngoc',1,2,'2010-12-15'),
('account11@gmail.com','account11','Nguyen Thi Thanh Lam',2,2,'2009-12-31'),
('account12@gmail.com','account12','Nguyen Cong Tuan',3,1,'2011-10-01'),
('account13@gmail.com','account13','Nguyen Gia Bao',4,4,'2010-11-21'),
('account14@gmail.com','account14','Nguyen Gia Hung',5,4,'2010-11-21'),
('account15@gmail.com','account15','Ngu Duy Vinh',6,4,'2010-11-21'),
('account16@gmail.com','account16','Cao Thanh Tung',7,4,'2010-11-21')

;
-- Xóa bảng Group
DROP TABLE 	IF EXISTS `Group`;

-- Tạo bảng Group
CREATE TABLE `Group` (
    GroupID 		TINYINT PRIMARY KEY AUTO_INCREMENT,
    GroupName 		VARCHAR(30),
    CreatorID 		INT,
    CreateDate 		DATE,
    FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID) ON DELETE CASCADE
);
-- Thêm thông tin vào bảng 
INSERT INTO `Group` (GroupName,CreatorID,CreateDate) VALUES
	('Group A',1,'2017-09-05'),
    ('Group B',2,'2015-11-09'),
    ('Group C',3,'2018-10-11'),
    ('Group D',4,'2019-09-05'),
    ('Group E',5,'2019-10-15'),
    ('Group F',6,'2018-06-20'),
	('Group G',7,'2019-06-20'),
    ('Group H',8,'2018-06-20'),
    ('Group K',9,'2018-06-20');

    
-- Xóa bảng GroupAccount
DROP TABLE 	IF EXISTS GroupAccount;

-- Tạo bảng GroupAccount
CREATE TABLE GroupAccount (
    GroupID 		TINYINT,
    AccountID 		INT,
    JoinDate 		DATE,
    PRIMARY KEY (GroupID,AccountID),
	FOREIGN KEY (GroupID) REFERENCES `Group`(GroupID) ON DELETE CASCADE,
    FOREIGN KEY (AccountID) REFERENCES `Account`(AccountID) ON DELETE CASCADE

);
-- Thêm thông tin vào bảng 
INSERT INTO GroupAccount VALUES 
	(1,5,'2021-12-04'),
    (2,9,'2021-11-14'),
    (3,8,'2021-10-24'),
    (4,6,'2021-12-24'),
    (5,4,'2021-09-04'),
    (6,1,'2021-11-19'),
    (7,8,'2021-10-12'),
    (8,5,'2021-12-15'),
	(5,7,'2021-12-04'),
    (4,8,'2021-10-06'),
    (3,6,'2021-09-18'),
    (2,5,'2021-12-22'),
    (8,2,'2021-08-19'),
    (9,1,'2021-11-11'),
    (7,4,'2021-05-04'),
    (4,9,'2021-07-18');
    
    
-- Xóa bảng TypeQuestion
DROP TABLE 	IF EXISTS TypeQuestion;

-- Tạo bảng TypeQuestion
CREATE TABLE TypeQuestion (
    TypeID 			TINYINT PRIMARY KEY AUTO_INCREMENT,
    TypeName 		ENUM('Essay', 'Multiple-Choise')
);-- Thêm thông tin vào bảng 
INSERT INTO TypeQuestion(TypeName) VALUES
	('Essay'),
	('Multiple-Choise'),
	('Essay'),
	('Multiple-Choise'),
	('Essay'),
    ('Essay'),
	('Multiple-Choise'),
	('Essay'),
	('Multiple-Choise'),
    ('Multiple-Choise'),
	('Multiple-Choise');

-- Xóa bảng CategoryQuestion
DROP TABLE 	IF EXISTS CategoryQuestion;

-- Tạo bảng CategoryQuestion
CREATE TABLE CategoryQuestion (
    CategoryID 		TINYINT PRIMARY KEY AUTO_INCREMENT,
    CategoryName 	VARCHAR(20)
);
-- Thêm thông tin vào bảng 
INSERT INTO CategoryQuestion(CategoryName) VALUES
	('Java'),
	('Python'),
	('C'),
	('C#'),
	('C++'),
	('Pascal'),
	('Javascript'),
	('Ruby'),
	('PHP');
    

-- Xóa bảng Question
DROP TABLE 	IF EXISTS Question;

-- Tạo bảng Question
CREATE TABLE Question (
    QuestionID 		SMALLINT PRIMARY KEY AUTO_INCREMENT,
    Content 		VARCHAR(100),
    CategoryID 		TINYINT,
    TypeID 			TINYINT,
    CreatorID 		INT,
    CreateDate 		DATE,
    FOREIGN KEY (TypeID) REFERENCES TypeQuestion(TypeID) ON DELETE CASCADE,
    FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID) ON DELETE CASCADE
);
-- Thêm thông tin vào bảng 
INSERT INTO Question VALUES
	(1,'Lap trinh C nhu the nao',1,1,11,'2021-10-24'),
	(2,'Lap trinh Java nhu the nao',2,2,10,'2021-10-24'),
	(3,'Lam sao de hoc lap trinh gioi',3,3,9,'2021-10-22'),
	(4,'Hoc lap trinh o trung tam nao',4,4,8,'2021-10-29'),
	(5,'Ngon ngu nao nhieu tien',5,5,7,'2021-11-24'),
	(6,'Ngon ngu nhieu nguoi dung nhat',6,6,6,'2021-11-24'),
	(7,'Nen hoc java hay C',7,7,5,'2021-11-24'),
	(8,'Hoc lap trinh web hay mobie',8,8,4,'2021-11-24'),
	(9,'Tri tue nhan tao',9,9,3,'2021-11-24'),
	(10,'Cong nghe thong tin la gi',10,10,2,'2021-11-24'),
	(11,'Lap trinh Python nhu the nao',11,11,1,'2021-10-24');
    
    
-- Xóa bảng Answer
DROP TABLE 	IF EXISTS Answer;

-- Tạo bảng Answer
CREATE TABLE Answer (
    AnswerID 		SMALLINT PRIMARY KEY AUTO_INCREMENT,
    Content 		VARCHAR(100),
    QuestionID 		SMALLINT,
    isCorret 		ENUM('True','False'),
    FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID) ON DELETE CASCADE
);
-- Thêm thông tin vào bảng 
INSERT INTO Answer(Content,QuestionID,isCorret) VALUES
	('Hoc tu youtube',1,'True'),
	('Hoc tu youtube va trung tam VTI',2,'True'),
	('Choi la chu yeu, hoc luc nao cung duoc',3,'False'),
	('Trung tam VTI',4,'True'),
	('Pascal',5,'False'),
	('Python',6,'True'),
	('Hoc ca 2',7,'True'),
	('Hoc web',8,'True'),
	('Hoc web',9,'False'),
	('Nganh hoc phat trien nhat hien nay',10,'False'),
	('Hoc tu Youtube',11,'True');


-- Xóa bảng Exam
DROP TABLE 	IF EXISTS Exam;

-- Tạo bảng Exam
CREATE TABLE Exam (
	ExamID 			TINYINT PRIMARY KEY AUTO_INCREMENT,
    `Code` 			VARCHAR(5) UNIQUE KEY,
    Title 			VARCHAR(30),
    CategoryID 		TINYINT,
    Duration 		TIME,
    CreatorID 		INT,
    CreateDate 		DATE,
	FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID) ON DELETE CASCADE,
	FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion(CategoryID) ON DELETE CASCADE

);
-- Thêm thông tin vào bảng 
INSERT INTO Exam VALUES
	(1,'VTI1','Thi Java',1,'01:00:00',1,'2020-12-07'),
    (2,'VTI2','Thi Python',1,'02:30:00',1,'2020-12-10'),
    (3,'VTI3','Thi C',1,'01:45:00',1,'2020-11-05'),
	(4,'VTI4','Thi C#',1,'01:00:00',1,'2020-10-07'),
	(5,'VTI5','Thi C++',1,'00:50:00',1,'2020-12-01'),
	(6,'VTI6','Thi Pascal',1,'00:30:00',1,'2020-11-01'),
	(7,'VTI7','Thi Javascript',1,'01:15:00',1,'2020-11-15'),
	(8,'VTI8','Thi Ruby',1,'02:25:00',1,'2020-10-04');


-- Xóa bảng ExamQuestion
DROP TABLE 	IF EXISTS ExamQuestion;

-- Tạo bảng ExamQuestion
CREATE TABLE ExamQuestion(
	ExamID 			TINYINT,
    QuestionID 		SMALLINT,
    PRIMARY KEY (ExamID,QuestionID),
	FOREIGN KEY (ExamID) REFERENCES Exam(ExamID) ON DELETE CASCADE,
	FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID) ON DELETE CASCADE

);

-- Thêm thông tin vào bảng 
INSERT INTO ExamQuestion VALUES
	(1,1),
    (2,2),
    (3,3),
    (4,4),
    (5,5),
    (6,6),
    (7,7),
    (8,8);
    
