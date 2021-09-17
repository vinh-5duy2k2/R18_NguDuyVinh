USE Testing_system;
-- QUESTION A: JOIN
-- Question1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT 
	AccountID,
    Email,
    Username,
    FullName,
    d.DepartmentID,
    d.DepartmentName
FROM 
	`Account` a 
LEFT JOIN 
	Department d ON a.departmentID= d.departmentID;


-- Question2: Viết lệnh để lấy ra thông tin các account được tạo ra sau ngày 20-12-2010
SELECT *
FROM 	`Account`
WHERE 	
	CreateDate > '2010-12-20';
    
    
-- Question3: Viết lệnh để lấy ra tất cả các developer
SELECT 
	a.AccountID,
    p.PositionName
FROM	
	`Account` a
JOIN 	`Position` p ON a.positionID = p.positionID
WHERE 
	p.PositionName = 'Dev';
    

-- Question4: Viết lệnh lấy ra danh sách các phòng ban có >= 2 sinh viên (Đổi đề để có dữ liệu đẹp)
SELECT d.DepartmentID
FROM Department d
JOIN `Account` a ON a.DepartmentID = d.DepartmentID
GROUP BY d.DepartmentID
HAVING COUNT(a.`AccountID`) >= 2;


-- Question5: Viết lệnh lấy ra danh sách câu hỏi được sử dụng nhiều nhất trong đề thi
SELECT 
	q.QuestionID,
    q.Content,
    COUNT(q.QuestionID) AS SoLuong
FROM 
	Question q
JOIN 		
	Examquestion e ON q.QuestionID = e.QuestionID
GROUP BY e.ExamID
HAVING COUNT(q.QuestionID) = (	SELECT MAX(SoLuongQ)
								FROM (	SELECT COUNT(q.QuestionID) AS SoLuongQ
										FROM 
											Question q
										JOIN 		
											Examquestion e ON q.QuestionID = e.QuestionID
										GROUP BY e.ExamID) AS So_luong_Question );

-- Question6: Thống kê mỗi Category Question được sử dụng trong bao nhiêu Question
SELECT 
	c.CategoryID,
    COUNT(q.QuestionID) AS SoLuong
FROM 
	Categoryquestion c
JOIN 		
	Question q ON c.CategoryID = q.CategoryID
GROUP BY CategoryID;


-- Question7: Thống kê mỗi question được sử dụng trong bao nhiêu Exam
SELECT 
	q.QuestionID,
    COUNT(e.ExamID) AS SoLuong
FROM 
	Question q
JOIN 		
	Examquestion e ON q.QuestionID = e.QuestionID
GROUP BY q.QuestionID;


-- Question8: Lấy ra Question có nhiều câu trả lời nhất
SELECT 
	q.QuestionID,
    COUNT(a.answerID) AS Max_Answer
FROM 
	Question q
JOIN 		
	Answer a ON q.QuestionID = a.QuestionID
GROUP BY a.QuestionID
HAVING COUNT(a.answerID) = (	SELECT MAX(Dem_Answer)
								FROM (
									SELECT COUNT(a.answerID) AS Dem_Answer
                                    FROM 
										Question q
									JOIN 		
										Answer a ON q.QuestionID = a.QuestionID
									GROUP BY a.QuestionID ) AS Bang_Dem_Answer );

-- Question9: Thống kê số lượng account trong mỗi group
SELECT 
	g.GroupID,
	COUNT(ga.AccountID) AS SoLuong
FROM 
	`Groupaccount` ga
JOIN 		
	`Group` g ON g.GroupID = ga.GroupID
GROUP BY g.GroupID;


-- Question10: Tìm chức vụ có ít người nhất
SELECT 
	p.positionID,
    COUNT(a.AccountID) AS `MIN`
FROM 
	`Account` a
JOIN 		
	`Position` p 		ON p.PositionID = a.PositionID
GROUP BY 	p.PositionID
HAVING 		COUNT(a.AccountID) = (	SELECT MIN(Dem_acc)
									FROM (	SELECT COUNT(a.AccountID) AS Dem_acc
											FROM 
												`Account` a
											JOIN 		
												`Position` p 		ON p.PositionID = a.PositionID
											GROUP BY 	p.PositionID ) AS Bang_dem_so_luong_acc);


-- Question11: Thống kê mỗi phòng ban có bao nhiêu dev,test,scrum master,PM
SELECT 
	d.DepartmentID,
    p.positionName,
	COUNT(a.AccountID) 	AS SoLuong
FROM 
	Department d 		
LEFT JOIN 		
	`Account` a 		ON a.DepartmentID = d.DepartmentID
CROSS JOIN 	
	`Position` p 		
GROUP BY d.DepartmentID, p.positionName
ORDER BY d.DepartmentID;


-- Question12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của Question, loại câu hỏi,
-- ai là người tạo ra câu hỏi, câu trả lời là gì
SELECT 
	q.QuestionID,
    q.Content AS 'Cau_hoi',
    c.CategoryName,
    t.TypeName,
    ac.FullName,
    q.CreateDate,
    a.Content AS 'Cau_tra_loi',
    a.isCorret
FROM 
	Question q
LEFT JOIN 		
	Answer a 			ON q.QuestionID = a.QuestionID
LEFT JOIN 	
	TypeQuestion t 		ON t.TypeID = q.TypeID
LEFT JOIN
	`Account` ac 		ON ac.AccountID = q.CreatorID
LEFT JOIN
	CategoryQuestion c 	ON c.CategoryID = q.CategoryID
ORDER BY q.QuestionID;


-- Question13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT 
	t.TypeName,
	COUNT(q.QuestionID) AS SoLuong
FROM 
	TypeQuestion t
JOIN 		
	Question q 			ON q.TypeID = t.TypeID
GROUP BY t.TypeName;


-- Question14: Lấy ra Group không có Account nào
SELECT 
	g.GroupID
FROM 
	GroupAccount g
JOIN 		
	`Account` a ON g.AccountID = a.AccountID
GROUP BY g.GroupID
HAVING COUNT(a.AccountID) = 0 ;


-- Question15: Lấy ra Group không có Account nào
SELECT 
	g.GroupID
FROM 
	GroupAccount g
JOIN 		
	`Account` a 		ON g.AccountID = a.AccountID
GROUP BY g.GroupID
HAVING COUNT(a.AccountID) = 0 ;


-- Question16: Lấy ra question không có Answer nào
SELECT 
	q.QuestionID,
    q.Content
FROM 
	Question q
LEFT JOIN 		
	Answer a 			ON q.QuestionID = a.QuestionID
GROUP BY q.QuestionID
HAVING COUNT(a.AnswerID) = 0 ;


-- QUESTION B: UNION
-- Question 17:
-- a) Lấy các account thuộc Group 1
-- b) Lấy các account thuộc Group 2
-- c) Ghép kết quả câu a) b) sao cho không có record nào trùng nhau


-- a)
SELECT 	AccountID
FROM 	GroupAccount
WHERE 	GroupId = 1;
-- b)
SELECT 	AccountID
FROM 	GroupAccount
WHERE 	GroupId = 2;
-- c)
SELECT	
		'Group_1' AS Danh_sach,
        AccountID
FROM 	
		GroupAccount
WHERE 	
		GroupID = 1
UNION
SELECT 	
		'Group_2',
		AccountID
FROM	
		GroupAccount
WHERE 	
		GroupID = 2;

-- Question 18:
-- a) Lấy các group có hơn 5 thành viên
-- b) Lấy các group có ít hơn 7 thành viên
-- c) Ghép kết quả từ câu a) và b)

-- a)
SELECT 		GroupID
FROM 		GroupAccount
GROUP BY 	GroupID
HAVING 		COUNT(AccountID) > 5;
-- b)
SELECT 		GroupID
FROM 		GroupAccount
GROUP BY 	GroupID
HAVING 		COUNT(AccountID) < 7;
-- c)
SELECT 		GroupID
FROM 		GroupAccount
GROUP BY 	GroupID
HAVING 		COUNT(AccountID) > 5
UNION ALL
SELECT 		GroupID
FROM 		GroupAccount
GROUP BY 	GroupID
HAVING 		COUNT(AccountID) < 7;