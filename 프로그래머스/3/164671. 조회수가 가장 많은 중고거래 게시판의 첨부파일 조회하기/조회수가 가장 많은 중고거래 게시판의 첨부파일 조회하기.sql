-- 코드를 입력하세요
SELECT concat("/home/grep/src/", b.board_id, "/", f.file_id, f.file_name, f.file_ext) 
as file_path
FROM (SELECT board_id
FROM used_goods_board
ORDER BY views DESC
LIMIT 1) b INNER JOIN used_goods_file f 
ON b.board_id = f.board_id
ORDER BY f.file_id DESC