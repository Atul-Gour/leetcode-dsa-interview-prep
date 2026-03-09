select round((
    count(*) filter (where d.order_date = d.customer_pref_delivery_date ) * 100.0/
    count(*)
),2) as immediate_percentage
from Delivery d
join (
    select
        customer_id ,
        min(order_date) as first_order
    from Delivery 
    group by customer_id
) t
on d.customer_id = t.customer_id
and t.first_order = d.order_date
