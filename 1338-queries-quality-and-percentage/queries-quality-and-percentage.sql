-- Write your PostgreSQL query statement below
select q.query_name ,
    Round(
        avg(rating :: numeric /position)  , 2
    ) as quality ,

    Round(
        coalesce(
            100.0 * count(*) filter (where rating < 3) / COUNT(*) 
        ,0)
    , 2) as poor_query_percentage

from Queries q
group by q.query_name
