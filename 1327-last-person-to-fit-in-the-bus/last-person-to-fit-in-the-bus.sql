-- Write your PostgreSQL query statement below

select x.person_name 
from (
    select 
        q.*,
        sum(weight) over ( order by turn ) as running_weight
    from Queue q
    order by running_weight desc
) as x
where running_weight <= 1000
limit 1;
