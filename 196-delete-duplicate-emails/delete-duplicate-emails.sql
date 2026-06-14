delete from person p2
where id != ( 
    select min(id)
    from person p1
    where p1.email = p2.email
    group by email
) 
