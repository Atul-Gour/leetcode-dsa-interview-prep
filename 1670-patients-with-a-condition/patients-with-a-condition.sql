-- Write your PostgreSQL query statement below
select * 
from patients
where (lower(conditions) like '% diab1%') or  (lower(conditions) like 'diab1%');