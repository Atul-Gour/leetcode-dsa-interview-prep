-- Write your PostgreSQL query statement below
select Round(((count(*) filter (where x.customer_pref_delivery_date = x.order_date ) * 100.0) / count(*)) :: numeric , 2) as immediate_percentage 
from(
    select d1.*,
    row_number() over( partition by d1.customer_id order by d1.order_date ) as rn
    from Delivery d1
) as x
where rn = 1
