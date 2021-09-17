USE Testing_system;
-- Question1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
CREATE VIEW 	Nhan_vien_phong_sale AS
SELECT 			a.*
FROM 			`Account` a
JOIN 			Department d ON a.departmentID = d.departmentID
WHERE 			d.departmentName = 'Sale'; 

WITH Question1  as(
SELECT 			a.*
FROM 			`Account` a
JOIN 			Department d ON a.departmentID = d.departmentID
WHERE 			d.departmentName = 'Sale' )
SELECT *
FROM question1; 

-- Question2: Tạo view có chứa thông tin các account tham gia nhiều group nhất
CREATE VIEW 	Acc_count_tham_gia_nhieu_group AS
SELECT 			a.AccountID,COUNT(g.GroupID)
FROM 			`Account` a
JOIN 			`GroupAccount` g ON g.AccountID = a.AccountID
GROUP BY 		a.AccountID
HAVING COUNT(g.GroupID) = (	SELECT Max(countGroup)
							FROM (	SELECT COUNT(g.GroupID)				AS countGroup
									FROM 			`Account` a
									JOIN 			`GroupAccount` g 	ON g.AccountID = a.AccountID
									GROUP BY 		a.AccountID) 		AS Bang_dem_group);

WITH 	Dem_Group 	AS (
			SELECT COUNT(g.GroupID)				AS countGroup
			FROM 			`Account` a
			JOIN 			`GroupAccount` g 	ON g.AccountID = a.AccountID
			GROUP BY 		a.AccountID),
		Max_Group 	AS (
			SELECT Max(countGroup)
            FROM Dem_Group)
SELECT 			a.AccountID,COUNT(g.GroupID)
FROM 			`Account` a
JOIN 			`GroupAccount` g ON g.AccountID = a.AccountID
GROUP BY 		a.AccountID
HAVING 			COUNT(g.GroupID) = (	SELECT * FROM Max_Group);

                                    
-- Question3: Tạo view có chứa câu hỏi có những content quá dài (dài hơn 28 kí tự) (Đổi đề để phù hợp dữ liệu) và xóa nó đi
CREATE VIEW Chieu_dai_content AS
SELECT 		QuestionID,
			Content,
            LENGTH(Content)
FROM 		Question
WHERE 		LENGTH(Content) > 28;
DELETE
FROM 		Question
WHERE 		LENGTH(Content) > 28;


-- Question4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
CREATE VIEW Phong_ban_nhieu_nhanvien_nhat 	AS
SELECT 		d.DepartmentID,
			COUNT(a.AccountID) 				AS So_luong_nhan_vien
FROM		Department d
JOIN 		`Account` a ON a.DepartmentID = d.DepartmentID
GROUP BY 	d.departmentID
HAVING COUNT(a.AccountID) = (	SELECT Max(countAccount)
							FROM (	SELECT COUNT(a.AccountID)		AS countAccount
									FROM 			Department d
									JOIN 			`Account` a 	ON a.DepartmentID = d.DepartmentID
									GROUP BY 		d.DepartmentID) AS Bang_dem_Account);
                                    


WITH Nhan_vien_moi_phong AS (
			SELECT 		d.DepartmentID,
						COUNT(a.AccountID) 				AS So_luong_nhan_vien
			FROM		Department d
			JOIN 		`Account` a ON a.DepartmentID = d.DepartmentID
			GROUP BY 	d.departmentID ),	
	Phong_nhieu_nhan_vien_nhat AS (SELECT MAX(So_luong_nhan_vien) FRom Nhan_vien_moi_phong)
SELECT 		d.DepartmentID
FROM		Department d
JOIN 		`Account` a ON a.DepartmentID = d.DepartmentID
GROUP BY 	d.departmentID
HAVING COUNT(a.AccountID) = (SELECT * FROM Phong_nhieu_nhan_vien_nhat);




-- Question5: Tạo view có chứa tất cả các câu hỏi do user họ Nguyễn tạo
CREATE VIEW Cau_hoi_do_user_ho_Nguyen_tao AS
SELECT 		q.QuestionID,
			q.Content
FROM 		Question q
JOIN 		`Account` a ON a.AccountID = q.CreatorID
WHERE 		a.FullName LIKE 'Nguyen%';
