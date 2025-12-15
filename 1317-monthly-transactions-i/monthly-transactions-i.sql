-- Write your PostgreSQL query statement below
select 
    to_char(t.trans_date , 'yyyy-mm') as month ,
    t.country ,
    count(8) as trans_count,
    count(state) filter (where state ='approved') as approved_count,
    sum(amount) as trans_total_amount,
    coalesce(sum(amount) filter (where state = 'approved'),0) as approved_total_amount
from Transactions t
group by t.country , to_char(t.trans_date , 'yyyy-mm')