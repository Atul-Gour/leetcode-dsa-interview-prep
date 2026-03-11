# Write your MySQL query statement below
select class
from Courses c
group by c.class
having count(*) >= 5 