-- Write your PostgreSQL query statement below
select stu.student_id , stu.student_name , sub.subject_name , count(ex.student_id) as attended_exams
from Students stu
cross join Subjects sub
left join Examinations ex
on stu.student_id = ex.student_id AND sub.subject_name = ex.subject_name
group by stu.student_id , stu.student_name , sub.subject_name
order by stu.student_id , stu.student_name , subject_name