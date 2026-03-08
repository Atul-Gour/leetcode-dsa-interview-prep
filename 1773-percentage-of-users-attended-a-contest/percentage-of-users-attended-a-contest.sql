select r.contest_id , 
        round(
            count(r.user_id)*100 :: numeric /(SELECT COUNT(*) FROM Users)
        ,2) as percentage
from Register r
group by r.contest_id 
order by percentage desc , contest_id 