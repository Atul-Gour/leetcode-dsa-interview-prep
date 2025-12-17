-- Write your PostgreSQL query statement below
select 
    s.user_id,

    (select case
        when count(*)>0 then ((count(*) filter (where action = 'confirmed') *1.0/count(*)))
        else 0
    end
    from Confirmations c
    where c.user_id = s.user_id)::numeric(10,2) as confirmation_rate

from Signups s
