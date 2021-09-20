USE Testing_system;
-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước
DROP TRIGGER IF EXISTS Question1;
DELIMITER $$
CREATE TRIGGER Question1
BEFORE	INSERT ON `Group`
FOR EACH ROW
	BEGIN
		IF NEW.CreateDate < (CURRENT_DATE - INTERVAL 1 YEAR) THEN
        SIGNAL SQLSTATE '12345'
        SET MESSAGE_TEXT = 'Loi tao ngay';
        END IF;
    END $$
DELIMITER ;

INSERT INTO `Group`(CreateDate) VALUE ('2015-09-09');
-- Question 2: Tạo trigger không cho phép người dùng thêm bất kì user nào vào Department "Sale" nữa, khi thêm thì hiện ra thông báo 
-- "Department "Sale" cannot add more user"
DROP TRIGGER IF EXISTS Question2;
DELIMITER $$
CREATE TRIGGER Question2
BEFORE	INSERT ON `Account`
FOR EACH ROW
	BEGIN
		IF NEW.DepartmentID = 1 THEN
        SIGNAL SQLSTATE '12345'
        SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
        END IF;
    END $$
DELIMITER ;

INSERT INTO `Account` (DepartmentID) VALUE (1);
-- Question 3: Cấu hình 1 group có nhiều nhất 5 user
DROP TRIGGER IF EXISTS Question3;
DELIMITER $$
CREATE TRIGGER Question3
BEFORE	INSERT ON `GroupAccount`
FOR EACH ROW
	BEGIN
		IF  NEW.GroupID IN (	SELECT 		GroupID 
								FROM 		GroupAccount
                                GROUP BY	GroupID
                                HAVING		COUNT(AccountID) > 5 ) THEN
        SIGNAL SQLSTATE '12345' -- disallow insert this record
        SET MESSAGE_TEXT = 'Cấu hình 1 group có nhiều nhất 5 user';
        END IF;
    END $$
DELIMITER ;

-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question
DROP TRIGGER IF EXISTS Question4;
DELIMITER $$
CREATE TRIGGER Question4
BEFORE	INSERT ON ExamQuestion
FOR EACH ROW
	BEGIN 
		IF NEW.ExamID 	IN (	SELECT 		ExamID 
								FROM 		ExamQuestion
                                GROUP BY	ExamID
                                HAVING		COUNT(QuestionID) > 10 ) THEN
		SIGNAL SQLSTATE '12345' -- disallow insert this record
        SET MESSAGE_TEXT = 'Cau hinh 1 bai thi co nhieu nhat 10 Question';
        END IF;
    END $$
DELIMITER ;

-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có mail là admin@gmail.com, còn lại các tài khoản khác cho phép xóa 
-- và xóa luôn các thông tin liên quan đến nó
DROP TRIGGER IF EXISTS Question5;
DELIMITER $$
CREATE TRIGGER Question5 
BEFORE DELETE ON `Account`
FOR EACH ROW
BEGIN
	DECLARE v_account_id INT;
    
    SELECT 	AccountID INTO v_account_id
    FROM 	`Account`
    WHERE 	email = OLD.email;
	
	IF OLD.email = 'admin@gmail.com' THEN
		SIGNAL SQLSTATE '12345' -- disallow delete this record
		SET MESSAGE_TEXT = 'This is Admin account, you can not delete!';
	ELSE 
		DELETE 
        FROM 	GroupAccount 
        WHERE 	AccountID = v_account_id;
        
        UPDATE `Group` 
        SET 	CreatorID = NULL 
        WHERE 	CreatorID = v_account_id;

        UPDATE 	Exam 
        SET 	CreatorID = NULL 
        WHERE 	CreatorID = v_account_id;
        
		UPDATE 	Question 
        SET 	CreatorID = NULL 
        WHERE 	CreatorID = v_account_id;
    END IF;
END$$
DELIMITER ;

INSERT INTO `Account` (Email) VALUES ('Admin@gamil.com');
DELETE
FROM	`Account`
WHERE 	email = 'Admin@gmail.com';

-- Question 6: Không dùng cấu hình default cho field DepartmentID của table Account, hãy tạo trigger cho phép người dùng khi tạo account không điền vào
-- departmentID thì được phân vào phòng ban: "waiting department"
DROP TRIGGER IF EXISTS Question6;
DELIMITER $$
CREATE 	TRIGGER Question6
BEFORE	INSERT ON `Account`
FOR EACH ROW
	BEGIN 
		IF 	NEW.DepartmentID IS NULL THEN
            SET		NEW.departmentID = 10;
        END IF;
    END $$
DELIMITER ;

INSERT INTO `Account` (Email) VALUES ('Account20@gamil.com');
DELETE
FROM	`Account`
WHERE 	Email = 'Account20@gamil.com';
-- Question 7: Cấu hình 1 bài thi chỉ cho phép tối đa 4 answer cho mỗi question, trong đó tối đa 2 đáp án đúng
DROP TRIGGER IF EXISTS Question7;
DELIMITER $$
CREATE TRIGGER Question7
BEFORE	INSERT ON ExamQuestion
FOR EACH ROW
	BEGIN
		IF NEW.QuestionID	IN  	(	SELECT 		q.QuestionID
										FROM		Question q
										JOIN		Answer a 	ON q.QuestionID = a.QuestionID
										WHERE		a.isCorret = 'True'
										GROUP BY 	q.QuestionID
										HAVING 		COUNT(a.AnswerID) > 2 			-- Dieu kien moi cau hoi co toi da 2 dap an dung
							UNION 		SELECT 		q.QuestionID
										FROM		Question q
										JOIN		Answer a 	ON q.QuestionID = a.QuestionID
										GROUP BY 	q.QuestionID
										HAVING		COUNT(a.AnswerID) > 3 )   		-- Dieu kien moi cau hoi co toi da 4 cau tra loi
							THEN
		SIGNAL SQLSTATE '12345' -- disallow insert this record
        SET MESSAGE_TEXT = 'Cau hinh 1 bai thi toi da 4 cau tra loi cho moi question, trong do toi da 2 cau tra loi dung';
        END IF ;
    END $$
DELIMITER ;
INSERT INTO ExamQuestion VALUES (11,2);

-- Question 8: Viết trigger sửa dữ liệu cho đúng"
		-- Nếu ng dùng nhập vào gender của account là nam,nữ,không xác định thì sẽ tự đổi lại thành "M", "F", "U" cho giống với cấu hình của database
        
ALTER TABLE `Account`
ADD Gender Varchar(10);
DROP TRIGGER IF EXISTS Question8;
DELIMITER $$
CREATE TRIGGER Question8 
BEFORE INSERT ON `Account`
FOR EACH ROW
BEGIN
	IF 			NEW.Gender = 'Male' THEN
				SET NEW.Gender = 'M'; 
	ELSEIF		NEW.Gender = 'Nu' THEN
				SET NEW.Gender = 'Female';
	ELSEIF		NEW.Gender IS NULL THEN
				SET NEW.Gender = 'U';
    END IF;
END$$
DELIMITER ;

INSERT INTO `Account` (Email) VALUES 
('Account21@gamil.com'),
('Account22@gamil.com');
DELETE
FROM	`Account`
WHERE 	Email = 'Account21@gamil.com';
-- Question 9: Viết trigger không cho phép ng dùng xóa bài thi mới tạo được 2 ngày
DROP TRIGGER IF EXISTS Question9;
DELIMITER $$
CREATE TRIGGER Question9 
BEFORE DELETE ON `Exam`
FOR EACH ROW
BEGIN
	IF 		OLD.CreateDate > ( CURRENT_DATE - INTERVAL 2 DAY ) THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Khong the xoa bai thi moi tao duoc 2 ngay';
    END IF;
END$$
DELIMITER ;
INSERT INTO Exam VALUES
	(13,'VTI13','Thi SQL',1,'01:00:00',1,'2021-09-19'),
    (14,'VTI14','Thi MySQL',1,'01:00:00',1,'2021-09-17');
    
DELETE
FROM	Exam
WHERE 	ExamID = 14;
-- Question 10: Viết trigger chi cho người dùng chỉ được update, delete các question khi question đó chưa nằm trong exam nào

-- Trigger cho phan Delete
			DROP TRIGGER IF EXISTS Question10_DELETE;
			DELIMITER $$
			CREATE TRIGGER Question10_DELETE 
			BEFORE DELETE ON `Question`
			FOR EACH ROW
			BEGIN
				IF 		OLD.QuestionID IN (	SELECT 	q.QuestionID
											FROM 	Question q
											JOIN	ExamQuestion e ON q.QuestionID = e.QuestionID ) THEN
						
						SIGNAL SQLSTATE '12345'
						SET MESSAGE_TEXT = 'Khong the DELETE QUESTION da nam trong Exam';
				END IF;
			END$$
			DELIMITER ;
DELETE 
FROM		Question
WHERE 		QuestionID = 6;
	
-- Trigger cho phan update
			DROP TRIGGER IF EXISTS Question10_UPDATE;
			DELIMITER $$
			CREATE TRIGGER Question10_UPDATE 
			BEFORE UPDATE ON `Question`
			FOR EACH ROW
			BEGIN
				IF 		OLD.QuestionID IN (	SELECT 	q.QuestionID
											FROM 	Question q
											JOIN	ExamQuestion e ON q.QuestionID = e.QuestionID ) THEN
						
						SIGNAL SQLSTATE '12345'
						SET MESSAGE_TEXT = 'Khong the update QUESTION da nam trong Exam';
				END IF;
			END$$
			DELIMITER ;
UPDATE	Question
SET 	content = '12345678910'
WHERE 	QuestionID = 5;
-- Trigger cho phan insert
			DROP TRIGGER IF EXISTS Question10_INSERT;
			DELIMITER $$
			CREATE TRIGGER Question10_INSERT 
			BEFORE INSERT ON `Question`
			FOR EACH ROW
			BEGIN
				IF 		NEW.QuestionID IN (	SELECT 	q.QuestionID
											FROM 	Question q
											JOIN	ExamQuestion e ON q.QuestionID = e.QuestionID ) THEN
						
						SIGNAL SQLSTATE '12345'
						SET MESSAGE_TEXT = 'Khong the INSERT QUESTION da nam trong Exam';
				END IF;
			END$$
			DELIMITER ;

-- Question 12: Lấy ra thông tin exam trong đó:
		-- Duration <= 30 thì sẽ đổi thành "Short Time"
        -- 30 <Duration <= 60 thì sẽ đổi thành "Medium Time"
        -- Duration > 60 Thì sẽ đổi thành "Long Time"
SELECT `code`, title, duration,
CASE 
	WHEN Duration <= 30 THEN 'Short time'
    WHEN 30 < Duration <= 60 THEN 'Medium time'
    ELSE 'Long time'
END AS duration_text
FROM Exam;
-- Question 13: Thống kê số account trong mỗi group và in thêm 1 column nữa có tên "the_number_user_amount" và mang giá trị được qui định sau"
		-- số lượng user trong group <= 5 thì sẽ có giá trị few
        -- số lượng user trong group <= 20 và > 5 thì sẽ có giá trị normal
        -- số lượng user trong group > 20 5 thì sẽ có giá trị higher
SELECT		GroupID, 
			COUNT(AccountID) AS So_luong_Acc,
CASE 	
	WHEN 	COUNT(AccountID) <= 5 								THEN 'Few'	
	WHEN 	COUNT(AccountID) <= 20  AND COUNT(AccountID) > 5 	THEN 'Normal'
    WHEN 	COUNT(AccountID) > 20 								THEN 'Higher'
END AS the_number_user_amount
FROM		GroupAccount
GROUP BY	GroupID;

-- Question 14: Thống kê mỗi phòng ban có bao nhiêu user, nếu phòng ban không có user nào thì sẽ đổi giá trị không thành "không có User"
SELECT		d.DepartmentID,
			IF(COUNT(a.AccountID) = 0, 'Không có user nào', COUNT(a.AccountID)) AS So_luong_User
FROM		Department d
LEFT JOIN	`Account` a 			ON d.DepartmentID = a.DepartmentID
GROUP BY	d.DepartmentID;


 