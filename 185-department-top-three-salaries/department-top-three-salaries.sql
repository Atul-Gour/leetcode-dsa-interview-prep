select 
  d.name as department ,
  x.name as employee ,
  x.salary
from (
  select 
  e.DepartmentId,
  e.Name,
  e.salary,
  dense_rank() over( partition by e.DepartmentId order by salary desc ) as rank
  from Employee e
) as x
left join Department d
on d.id = x.DepartmentId
where rank <= 3;