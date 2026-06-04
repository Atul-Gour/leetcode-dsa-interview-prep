-- Write your PostgreSQL query statement below
select p.product_id , coalesce(Round(sum( u.units * p.price )/(sum( u.units )*1.0) :: numeric , 2 ) , 0 ) as average_price 
from prices p
left join UnitsSold u
on p.product_id = u.product_id and u.purchase_date between p.start_date and p.end_date
group by p.product_id