-- Write your PostgreSQL query statement below


select distinct p3.product_id , coalesce( x.new_price , 10 ) as price
from (
    select distinct product_id
            ,(
                select max(p2.change_date) 
                from products p2
                where p2.product_id = p1.product_id and p2.change_date <= '2019-08-16'
            ) as newest_date
    from products p1
) as p3
left join products x
on p3.product_id = x.product_id and p3.newest_date = x.change_date
where (p3.newest_date is null or p3.newest_date = x.change_date )