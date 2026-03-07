-- Write your PostgreSQL query statement below
select w.id
from Weather w
where w.temperature > (select max(ww.temperature) from Weather ww where ww.recordDate + interval '1 day' = w.recordDate  )
order by w.id;