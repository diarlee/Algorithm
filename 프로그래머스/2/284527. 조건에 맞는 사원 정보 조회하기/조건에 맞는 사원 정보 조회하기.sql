-- 코드를 작성해주세요
SELECT sum(score) score, e.emp_no, e.emp_name, e.position, e.email
FROM hr_employees e INNER JOIN hr_grade g
ON e.emp_no = g.emp_no 
WHERE year = "2022"
GROUP BY emp_no
ORDER BY sum(score) DESC
LIMIT 1