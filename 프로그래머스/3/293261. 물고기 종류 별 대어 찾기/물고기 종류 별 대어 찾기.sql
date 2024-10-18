-- 코드를 작성해주세요
SELECT fi.id, fni.fish_name, fi.length
FROM fish_info as fi
INNER JOIN fish_name_info as fni
ON fi.fish_type = fni.fish_type
WHERE (fi.fish_type, fi.length) 
in (SELECT fish_type, MAX(length)
      FROM fish_info
      GROUP BY fish_type)
ORDER BY fi.id