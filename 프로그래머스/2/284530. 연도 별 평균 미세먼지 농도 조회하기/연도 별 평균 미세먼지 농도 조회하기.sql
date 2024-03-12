-- 코드를 작성해주세요
SELECT year(YM) as year, round(avg(pm_val1), 2) as pm10, round(avg(pm_val2), 2) as "pm2.5"
FROM air_pollution
WHERE location2 = "수원"
GROUP BY year(YM)
ORDER BY year(YM)