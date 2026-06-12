select e2.employee_id , e2.name , count(*) as reports_count , Round(avg(e1.age), 0) as average_age
from Employees e1
left join Employees e2
on e1.reports_to = e2.employee_id
where e2.employee_id is not null
group by e2.employee_id, e2.name
order by e2.employee_id