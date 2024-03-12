-- 코드를 입력하세요
SELECT b.book_id, a.author_name, date_format(b.published_date, "%Y-%m-%d") as published_date
FROM BOOK b INNER JOIN AUTHOR a
ON b.author_id = a.author_id
WHERE category = "경제"
ORDER BY published_date