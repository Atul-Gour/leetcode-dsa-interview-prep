select (
    Round(count( * ) filter ( where a4.player_id is not null ) * 1.0 / count(a1.player_id) , 2 )
) as fraction
from (
    select a2.*
    from activity a2
    where a2.event_date = (
        select min( a3.event_date )
        from activity a3
        where a3.player_id = a2.player_id
    )
) a1
left join activity a4
on a1.player_id = a4.player_id and a4.event_date = a1.event_date + interval '1 day'
