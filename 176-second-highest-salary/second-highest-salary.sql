SELECT max(salary) AS SecondHighestSalary
from employee
where salary < (
    SELECT  max(e1.salary)
    FROM Employee e1
)