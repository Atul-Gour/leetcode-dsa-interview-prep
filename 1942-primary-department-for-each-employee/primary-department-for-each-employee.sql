select x.employee_id  , x.department_id 
from (
    select e.employee_id , e.department_id, e.primary_flag,
    count(*) over (partition by e.employee_id) as department_count
    from Employee e
) as x
where x.department_count = 1 or ( x.department_count > 1 and x.primary_flag = 'Y' )