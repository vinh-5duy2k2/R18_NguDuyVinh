use classicmodels;
-- Lợi nhuận mặt hàng nào nhiều nhất

SELECT 		p.productCode,p.productName, SUM((od.priceEach-p.buyPrice)*od.quantityOrdered) AS Loi_nhuan
FROM 		products p
JOIN 		orderdetails od ON od.productCode = p.productCode
GROUP BY 	p.productCode
ORDER BY 	Loi_nhuan DESC
LIMIT 1;

-- thông kê mỗi thành phố có bao nhiêu employee
SELECT 
	o.city,
    COUNT(e.employeeNumber) AS So_luong_employee
FROM 
	employees e
LEFT JOIN offices o ON e.officeCode = o.officeCode
GROUP BY o.city;