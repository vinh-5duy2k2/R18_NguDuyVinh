
DROP 	DATABASE IF EXISTS MySQL_FINAL;
CREATE 	DATABASE MySQL_FINAL;
USE 	MySQL_FINAL;

-- Question 1: 	 Tạo table với các ràng buộc và kiểu dữ liệu
-- 				 Thêm ít nhất 3 bản ghi vào table  
-- Bảng Giảng Viên
		DROP 	TABLE IF EXISTS GiangVien;
		CREATE 	TABLE GiangVien(
		magv 		TINYINT UNSIGNED 	AUTO_INCREMENT	PRIMARY KEY,
		hoten 		varchar(50) 		NOT NULL,
		luong		INT UNSIGNED		NOT NULL);


-- Tạo Bảng Sinh Viên
		DROP 	TABLE IF EXISTS SinhVien;
		CREATE 	TABLE SinhVien(
		masv		TINYINT UNSIGNED	AUTO_INCREMENT	PRIMARY KEY,
		hoten		varchar(50)			NOT NULL,
		namsinh		DATE 				NOT NULL,
		quequan		varchar(100)		NOT NULL);


-- Tạo Bảng Đề Tài
		DROP 	TABLE IF EXISTS DeTai;
		CREATE 	TABLE DeTai(
		madt		TINYINT UNSIGNED	AUTO_INCREMENT	PRIMARY KEY,
		tendt 		varchar(50)			NOT NULL,
		kinhphi		INT UNSIGNED		NOT NULL,
		NoiThucTap	varchar(100)		NOT NUll);


-- Tạo Bảng Hướng Dẫn
		DROP 	TABLE IF EXISTS HuongDan;
		CREATE 	TABLE HuongDan(
		id			TINYINT	UNSIGNED	AUTO_INCREMENT	PRIMARY KEY,
		masv		TINYINT UNSIGNED	NOT NULL UNIQUE KEY,
		magv 		TINYINT UNSIGNED 	NOT NULL UNIQUE KEY,
		madt		TINYINT UNSIGNED	NOT NULL UNIQUE KEY,
		ketqua		ENUM('D','T'),
		FOREIGN KEY (masv)	REFERENCES SinhVien(masv) ON DELETE CASCADE ON UPDATE CASCADE,
		FOREIGN KEY (magv)	REFERENCES GiangVien(magv) ON DELETE CASCADE ON UPDATE CASCADE,
        FOREIGN KEY (madt)	REFERENCES DeTai(madt) ON DELETE CASCADE ON UPDATE CASCADE);


-- Thêm Thông Tin Vào Tạo Bảng Giảng Viên
		INSERT INTO GiangVien VALUES 
		(1,'Nguyen Van A',10000000),
		(2,'Nguyen Van B',15000000),
		(3,'Tran Thi C',12000000),
		(4,'Chu Thi D',11000000);
        
        
-- Thêm Thông Tin Vào Bảng Sinh Viên
		INSERT INTO SinhVien VALUES 
		(1,'Nguyen Van Nam','1999-01-05','Ha Noi'),
		(2,'Ngu Duy Vinh','2002-01-18','TP.Ho Chi Minh'),
		(3,'Cao Thanh Tung','2000-01-01','Da Nang'),
		(4,'Chu Ha Giang','1995-07-22','Nghe An');


-- Thêm Thông Tin Vào Bảng Đề Tài
		INSERT INTO DeTai VALUES 
		(1,'CONG NGHE SINH HOC',1000000,'Ha Noi'),
		(2,'TRI TUE NHAN TAO',2500000,'TP.Ho Chi Minh'),
		(3,'IOT',1500000,'Ha Noi'),
		(4,'TU DONG HOA',500000,'Nghe An');
        
        
-- Thêm Thông Tin Vào Bảng Hướng Dẫn
		INSERT INTO HuongDan VALUES 
		(1,1,2,1,'D'),
		(2,2,3,2,'D'),
		(3,3,4,3,'T');

SELECT * FROM HuongDan;
SELECT * FROM GiangVien;
SELECT * FROM SinhVien;
SELECT * FROM DeTai;

-- Question 2: Viết lệnh để
-- a) Lấy tất cả các sinh viên chưa có đề tài hướng dẫn
		SELECT 		s.*
		FROM		SinhVien s
		LEFT JOIN	HuongDan h ON s.masv = h.masv
		WHERE		h.id IS NULL;
        
        
-- b) Lấy ra số sinh viên làm đề tài ‘CONG NGHE SINH HOC’ 
		SELECT 		COUNT(h.masv) AS SoLuong
		FROM		DeTai 	d
		JOIN		HuongDan h ON h.madt = d.madt
        WHERE 		d.tendt = 'CONG NGHE SINH HOC';
        
        
-- Question 3: Tạo view có tên là "SinhVienInfo" lấy các thông tin về học sinh bao gồm:
-- 				mã số, họ tên và tên đề tài
-- 				(Nếu sinh viên nào không có đề tài thì column tên đề tài sẽ in ra "Chưa Có")
		DROP 	VIEW IF EXISTS SinhVienInfo;
		CREATE	VIEW SinhVienInfo 	AS
		SELECT		s.masv,s.hoten,d.tendt
		FROM		SinhVien s
		LEFT JOIN	HuongDan h 		ON 	s.masv = h.masv
		LEFT JOIN	DeTai	 d		ON  d.madt = h.madt;

		SELECT 		masv,hoten, IF(tendt IS NULL,'Chưa có đề tài',tendt) AS Tendt
		FROM 		SinhVienInfo;


-- Question 4:  Tạo trigger cho table SinhVien khi insert sinh viên có năm sinh <= 1900
-- 				thì hiện ra thông báo "năm sinh phải > 1900"
		DROP TRIGGER IF EXISTS Insert_Sinhvien;
		DELIMITER $$
		CREATE TRIGGER Insert_Sinhvien
		BEFORE	INSERT ON SinhVien
		FOR EACH ROW
			BEGIN
				IF 
					YEAR(NEW.NamSinh) <= 1900  THEN
					SIGNAL SQLSTATE '12345'
					SET MESSAGE_TEXT = 'năm sinh phải > 1900';
				END IF;
			END $$
		DELIMITER ;

		INSERT INTO SinhVien(Namsinh) VALUES ('1800-01-01');
        
        
-- Question 5: 	Hãy cấu hình table sao cho khi xóa 1 sinh viên nào đó thì sẽ tất cả thông
--       		tin trong table HuongDan liên quan tới sinh viên đó sẽ bị xóa đi
		DROP TRIGGER IF EXISTS Cau_hinh_Table_HuongDan;
		DELIMITER $$
		CREATE TRIGGER Cau_hinh_Table_HuongDan 
		BEFORE DELETE ON HuongDan
		FOR EACH ROW
			BEGIN
				DECLARE v_masv TINYINT UNSIGNED;
                
				SELECT 	masv INTO v_masv
				FROM 	SinhVien
				WHERE 	masv = OLD.masv;
                
				UPDATE 	HuongDan 
				SET 	masv = NULL 
				WHERE 	masv = v_masv;
                
				UPDATE 	HuongDan 
				SET 	madt = NULL 
				WHERE 	masv = v_masv;
                
				UPDATE 	HuongDan 
				SET 	magv = NULL 
				WHERE 	masv = v_masv;
		END$$
		DELIMITER ;


DELETE 
FROM	SinhVien
WHERE 	masv = 1;

SELECT * FROM HuongDan;
SELECT * FROM GiangVien;
SELECT * FROM SinhVien;
SELECT * FROM DeTai;



		

