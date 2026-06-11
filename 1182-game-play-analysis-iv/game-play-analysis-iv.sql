select (
    Round(count( * ) filter ( where a3.player_id is not null ) * 1.0 / count(a1.player_id) , 2 )
) as fraction
from (
    select 
            a2.*,
            row_number() over (partition by player_id order by event_date ) as rn 
    from activity a2
) a1
left join activity a3
on a1.player_id = a3.player_id and a3.event_date = a1.event_date + interval '1 day'
where a1.rn = 1