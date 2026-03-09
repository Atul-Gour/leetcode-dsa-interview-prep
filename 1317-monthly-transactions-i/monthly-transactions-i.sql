select 
    to_char(t.trans_date , 'YYYY-MM' ) as month,
    t.country,
    count(*) as trans_count,
    count(*) filter (where t.state = 'approved' ) as approved_count,
    sum(t.amount) as trans_total_amount,
    coalesce(sum(t.amount) filter (where t.state = 'approved' ) , 0) as approved_total_amount
from Transactions t
group by to_char(t.trans_date , 'YYYY-MM' ) , t.country