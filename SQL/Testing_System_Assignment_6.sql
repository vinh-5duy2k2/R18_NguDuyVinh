USE Testing_system;
-- Question 1: 	Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó
DROP PROCEDURE IF EXISTS Question1;
DELIMITER $$
CREATE PROCEDURE Question1(IN in_departmentName varchar(30))
	BEGIN 
		SELECT		a.*
		FROM 		Department d
		LEFT JOIN 	`Account` a ON a.DepartmentID = d.DepartmentID
		WHERE 		d.DepartmentName = in_departmentName;
	END $$
DELIMITER ;
call testing_system.Question1('Sale');


-- Question 2: 	Tạo store để in ra số lượng account trong mỗi group
DROP PROCEDURE IF EXISTS Question2;
DELIMITER $$
CREATE PROCEDURE Question2()
	BEGIN 
		SELECT 		g.GroupID,
					COUNT(ga.AccountID) AS SoLuong
		FROM 		`Group` g
		LEFT JOIN 	GroupAccount ga ON g.GroupID = ga.GroupID
		GROUP BY 	g.GroupID;
	END $$
DELIMITER ;
call testing_system.Question2();


-- Question 3: 	Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại
DROP PROCEDURE IF EXISTS Question3;
DELIMITER $$
CREATE PROCEDURE Question3()
	BEGIN 
		SELECT 		t.typeID,
					MONTH(q.CreateDate) AS Thang,
					COUNT(q.QuestionID) AS SoLuong
		FROM 		TypeQuestion t
		JOIN 		Question q ON t.typeID = q.typeID
		GROUP BY 		t.typeID,MONTH(q.CreateDate);
	END $$
DELIMITER ;

call testing_system.Question3();

-- Question 4: 	Tạo store để trả ra ID của type question có nhiều câu hỏi nhất
DROP PROCEDURE IF EXISTS Question4;
DELIMITER $$
CREATE PROCEDURE Question4(OUT out_type_ID TINYINT UNSIGNED )
	BEGIN 
		SELECT 		t.typeID
		INTO 		out_type_ID
		FROM 		TypeQuestion t
		JOIN 		Question q ON t.typeID = q.typeID
		GROUP BY 		t.typeID
		HAVING 		COUNT(q.QuestionID) = (	SELECT 	MAX(Dem_question)
								FROM 	(	SELECT 	COUNT(q.QuestionID) AS Dem_question
											FROM 		TypeQuestion t
											JOIN 		Question q ON t.typeID = q.typeID
											GROUP BY		t.typeID ) AS Bang_Dem_Question );
	END $$
DELIMITER ;
SET @v_out_type_ID = 0;
call testing_system.Question4(@v_out_type_ID);
SELECT @v_out_type_ID;

-- Question 5: 	Sử dụng store của question 4 để tìm ra tên của type question ()
SET @v_out_type_ID = 0;
call testing_system.Question4(@v_out_type_ID);
SELECT @v_out_type_ID;

SELECT	t.typeName
FROM  	typequestion t
WHERE 	t.typeID = @v_out_type_ID;


-- Question 6: 	Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên chứa chuỗi của người dùng nhập vào hoặc trả về username có chứa chuỗi của người dùng nhập vào
DROP PROCEDURE IF EXISTS Question6;
DELIMITER $$
CREATE PROCEDURE Question6( IN in_string varchar(30))
	BEGIN 
		SELECT g.GroupName
		FROM `Account` a
		JOIN `Group` g 
		WHERE g.GroupName = in_string OR a.Username = in_string;
	END $$
DELIMITER ;
	
call Question6('group a');

-- Question 7: 	Viết 1 store cho phép người dùng nhập thông tin FullName, email, trong mỗi store sẽ tự động gán :
	-- username sẽ giống email nhưng bỏ phần @...mail đi
    -- positionID sẽ có default là developer
    -- DepartmentID sẽ được cho vào 1 phòng chờ
    -- Sau đó in ra kết quả tạo thành công
DROP PROCEDURE IF EXISTS Question7;
DELIMITER $$
CREATE PROCEDURE Question7(IN in_FullName VARCHAR(30), IN in_Email VARCHAR(50))
BEGIN
	DECLARE Username 		VARCHAR(30) 		DEFAULT SUBSTRING_INDEX(in_Email,'@',1);
    DECLARE PositionID 		TINYINT UNSIGNED 	DEFAULT 1;
    DECLARE DepartmentID 	TINYINT UNSIGNED 	DEFAULT 13;
	DECLARE CreateDate		 DATETIME DEFAULT 	NOW();
	INSERT INTO `Account` 	(Email		,Username, FullName		, DepartmentID,	PositionID,	CreateDate)
    VALUE					(in_email	,Username, in_fullName	, DepartmentID, PositionID, CreateDate);	
    SELECT 	*
    FROM 	`Account`;
END$$
DELIMITER ;
call Question7('Vinh dep trai','vinhdeptrai@gmail.com');


-- Question 8: 	Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple_Choise để thống kê câu hỏi Essay hoặc Multiple_Choise nào có content dài nhất
DROP PROCEDURE IF EXISTS Question8;
DELIMITER $$
CREATE PROCEDURE Question8(IN in_string ENUM('Essay','Multiple_Choise'),OUT out_questionID SMALLINT UNSIGNED)
BEGIN

    SELECT 		q.QuestionID
    INTO 		out_questionID
    FROM 		Question q
    JOIN		(	SELECT 		TypeID
					FROM 		typeQuestion
					WHERE 		typeName = in_string ) AS a ON q.typeID = a.typeID
	WHERE 		LENGTH(q.content) = (	SELECT MAX(Chieu_dai)	
										FROM	(	SELECT 	LENGTH(q.content) AS Chieu_dai
													FROM 	Question q
													JOIN	typeQuestion t ON q.typeID = t.typeID) 		AS Bang_chieu_dai);
END$$
DELIMITER ;

SET @v_out_QuestionID = 0;
call Question8('Essay',@v_out_QuestionID);
SELECT @v_out_QuestionID;

-- Question 9: 	Viết 1 store cho phép người dùng xóa exam dựa vào ID
DROP PROCEDURE IF EXISTS Question9;
DELIMITER $$
CREATE PROCEDURE Question9( IN in_ID TINYINT UNSIGNED)
	BEGIN 
		DELETE 
        FROM 	Exam
        WHERE 	ExamID = in_ID;
	END $$
DELIMITER ;

-- Question 10:	Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi.. Sử dụng store ở câu 9 để xóa
	-- Sau đó in ra số lượng record đã remove từ các table liên quan trong khi removing
-- Question 11:	Viết store cho phép người dùng xóa phòng ban bằng cách người dùng nhập vào tên phòng ban và các account
-- thuộc phòng ban đó sẽ được chuyển đến phòng ban default là phòng ban chờ việc
DROP PROCEDURE IF EXISTS delete_dept;
DELIMITER $$
CREATE PROCEDURE delete_dept(IN  in_DepartmentName VARCHAR(30))
	BEGIN
		SELECT 	*
        FROM 	`Account` a
        JOIN 	Department d 	ON d.departmentID = a.departmentID
        WHERE 	d.departmentName = 'Sale';
        UPDATE 	`Account` a
        SET		a.departmentID = 10
        WHERE	a.departmentID 	= (		SELECT 	d.DepartmentID
										FROM	Department d
										WHERE 	d.DepartmentName = 'Sale');
		DELETE
        FROM 		Department
        WHERE 		DepartmentName = in_departmentName;
    END$$
DELIMITER ;    
CALL delete_name_department('Bao ve');
SELECT*FROM department;
SELECT*FROM account;
-- Question 12:	Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo ra trong năm nay	

-- Question 13:	Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 tháng gần đây nhất 
	-- Nếu tháng nào không có sẽ in ra là : " Không có câu hỏi nào trong tháng "
