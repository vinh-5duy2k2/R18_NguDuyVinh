USE Testing_system;
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

-- Viết trigger để xoa group id của bảng GroupAccount  nếu xóa đi 1 dòng tương ứng ở bảng Group

DROP TRIGGER IF EXISTS xyz;
DELIMITER $$
CREATE 	TRIGGER xyz
BEFORE	DELETE ON `Group`
FOR EACH ROW
	BEGIN
		DELETE 
		FROM 	groupaccount g 
        WHERE 	g.GroupID = OLD.GroupID;
    END $$
DELIMITER ;

INSERT INTO `Group` (GroupName,CreatorID,CreateDate) VALUES ('Group K',9,'2020-10-20');
DELETE 	
FROM	`group`
WHERE 	GroupID = 8;

 