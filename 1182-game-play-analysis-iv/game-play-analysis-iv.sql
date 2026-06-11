select (
    Round(count( distinct a1.player_id ) filter ( where a1.event_date = a1.first_day + interval '1 day' ) * 1.0 / count(distinct a1.player_id) , 2 )
) as fraction
from (
    select 
            a2.*,
            min(event_date) over (partition by player_id ) as first_day
    from activity a2
) a1