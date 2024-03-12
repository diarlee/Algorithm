-- 코드를 입력하세요
SELECT *
FROM car_rental_company_car
WHERE find_in_set("네비게이션", options) > 0 
ORDER BY car_id desc;