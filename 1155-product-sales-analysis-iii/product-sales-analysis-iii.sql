select s.product_id , s.year as first_year , s.quantity , s.price
from Sales s 
join (
    select product_id , min(year) as first_sale_year
    from sales 
    group by product_id
) t
on s.product_id = t.product_id and s.year = t.first_sale_year
