-- 코드를 입력하세요
SELECT b.title, b.board_id, r.reply_id, r.writer_id, r.contents, date_format(r.created_date, "%Y-%m-%d") as created_date
FROM used_goods_board as b, used_goods_reply as r
WHERE b.board_id = r.board_id AND b.created_date LIKE "2022-10%"
ORDER BY r.created_date, b.title;