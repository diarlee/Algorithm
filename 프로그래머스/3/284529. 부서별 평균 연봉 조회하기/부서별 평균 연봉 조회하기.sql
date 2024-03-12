-- 코드를 작성해주세요
SELECT d.dept_id, d.dept_name_en, round(avg(e.SAL)) as avg_sal
FROM hr_department d INNER JOIN hr_employees e
ON d.dept_id = e.dept_id
GROUP BY d.dept_id
ORDER BY avg_sal DESC;