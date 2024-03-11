-- 코드를 입력하세요
SELECT PRODUCT_CODE, SUM(p.price * o.sales_amount) as SALES
FROM product p RIGHT OUTER JOIN OFFLINE_SALE o
ON p.product_id = o.product_id
GROUP BY p.product_code
ORDER BY SALES DESC, p.product_code;