-- Write your PostgreSQL query statement below
select 
    to_char( activity_date , 'YYYY-MM-DD' ) as day,
    count( distinct user_id ) as active_users
from activity
where activity_date between Date '2019-07-27' - interval '29 day' and Date '2019-07-27'
group by to_char( activity_date , 'YYYY-MM-DD' ) 