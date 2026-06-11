select 
    to_char( t.trans_date , 'YYYY-MM' ) as month,
    t.country,
    count( * ) as trans_count,
    COUNT(*) FILTER (WHERE t.state = 'approved') AS approved_count,
    sum( t.amount ) as trans_total_amount,
    sum( case 
                when t.state = 'approved' then t.amount
                else 0
        end ) as approved_total_amount
from Transactions t
group by to_char( t.trans_date , 'YYYY-MM' ) , country;