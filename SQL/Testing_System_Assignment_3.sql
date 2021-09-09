USE testing_system;
-- Question1
-- Question2

SELECT * 
FROM Department;

-- Question3
SELECT DepartmentID
FROM Department
WHERE DepartmentName = 'Ban hang';

-- Question4
SELECT 
	*
FROM `Account`
ORDER BY length(FullName)  DESC
LIMIT 1;

-- Question5
SELECT 
	*
FROM `Account`
WHERE DepartmentID = 3
ORDER BY length(FullName)  DESC
LIMIT 1;

-- Question6
SELECT groupName
FROM `Group`
WHERE CreateDate < '2018-12-20';


-- Question7
SELECT QuestionID
FROM Answer
GROUP BY QuestionID
HAVING Count(QuestionID) > 4;

-- Question8
SELECT `Code`
FROM Exam
WHERE Duration >= '01:00:00' AND CreateDate < '2020-11-20';

-- Question9
SELECT *
FROM `Group`
ORDER BY CreateDate DESC
LIMIT 5;


-- Question10
SELECT Count(DepartmentID) AS `Count`
FROM `Account`
WHERE DepartmentID = 2;


-- Question11
SELECT *
FROM `Account`
WHERE FullName LIKE 'N%' AND FullName LIKE '%h'; 

-- Question12

-- Question5
-- Question5
-- Question5

