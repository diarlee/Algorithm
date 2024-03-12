-- 코드를 입력하세요
SELECT car_type, count(*) as cars
FROM car_rental_company_car
WHERE find_in_set('통풍시트', options) > 0
or find_in_set('열선시트', options) > 0
or find_in_set('가죽시트', options) > 0
GROUP BY car_type
ORDER BY car_type;