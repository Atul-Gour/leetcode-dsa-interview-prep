-- Write your PostgreSQL query statement below
select Round(((count(*) filter (where x.customer_pref_delivery_date = x.order_date ) * 100.0) / count(*)) :: numeric , 2) as immediate_percentage 
from(
    select  d1.*
    from Delivery d1 
    where d1.order_date = (
        select min(d2.order_date)
        from Delivery d2
        where d2.customer_id = d1.customer_id
        group by d2.customer_id
    )
) as x
