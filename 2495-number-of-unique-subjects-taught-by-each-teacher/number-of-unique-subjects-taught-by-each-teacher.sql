-- Write your PostgreSQL query statement below
select t.teacher_id , count( distinct t.subject_id ) as cnt
from teacher as t
group by t.teacher_id