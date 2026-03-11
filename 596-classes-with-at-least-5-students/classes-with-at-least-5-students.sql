# Write your MySQL query statement below
-- select class
-- from Courses c
-- group by c.class
-- where count(*) >= 5 

select class
from (
    select class , count(*) as count
    from Courses c
    group by c.class
) t
where t.count >= 5 