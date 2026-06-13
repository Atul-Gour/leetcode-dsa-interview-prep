-- Write your PostgreSQL query statement below
select
    x.id,
    (
        case
            when( x.id % 2 = 0 ) then x.prev_student
            when( x.next_student is null ) then x.student
            else x.next_student
        end
    ) as student
from (
    SELECT 
        s1.id,
        s1.student,
        lag(s1.student) over () as prev_student,
        lead(s1.student) over () as next_student
    FROM Seat s1
) as x