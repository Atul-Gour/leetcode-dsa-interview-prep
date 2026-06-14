select (
    SELECT salary 
    from (
        SELECT 
            salary,
            dense_rank() over ( order by salary desc ) as rank
        FROM Employee e1
    )
    where rank = 2
    limit 1
) as SecondHighestSalary  