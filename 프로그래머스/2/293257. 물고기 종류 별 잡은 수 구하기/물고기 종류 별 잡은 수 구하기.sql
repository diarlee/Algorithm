-- 코드를 작성해주세요
SELECT COUNT(*) as fish_count, fish_name
FROM fish_info as fi
INNER JOIN fish_name_info as fni
on fi.fish_type = fni.fish_type
GROUP BY fni.fish_name
ORDER BY fish_count DESC