select p.project_id , Round(avg( e.experience_years ) :: numeric , 2 ) as average_years
from project p
left join employee e
on p.employee_id = e.employee_id 
group by p.project_id
