-- 코드를 작성해주세요
SELECT COUNT(*) as FISH_COUNT 
FROM FISH_INFO as fi
INNER JOIN FISH_NAME_INFO as fni
ON fi.FISH_TYPE = fni.FISH_TYPE
WHERE fni.FISH_NAME in ("BASS", "SNAPPER")