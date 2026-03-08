-- Write your PostgreSQL query statement below
select q.query_name ,
    Round(
        avg(rating :: numeric /position)  , 2
    ) as quality ,

    coalesce(Round(
        ( select count(*) 
          from Queries qq 
          where q.query_name = qq.query_name and rating < 3
          group by q.query_name ) * 100.0 / count(*) , 2
    ),0) as poor_query_percentage
    
from Queries q
group by q.query_name
