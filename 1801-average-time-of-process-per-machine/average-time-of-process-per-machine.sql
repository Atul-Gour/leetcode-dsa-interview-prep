-- Write your PostgreSQL query statement below
select machine_id ,  processing_time 
from ( 
    select machine_id ,
        round((sum(case 
                        when activity_type = 'start' then -timestamp 
                        else +timestamp
                    end) :: NUMERIC(20,3) / (count(*)/2) ) , 3) as processing_time 
    from Activity
    group by machine_id
) t
order by machine_id