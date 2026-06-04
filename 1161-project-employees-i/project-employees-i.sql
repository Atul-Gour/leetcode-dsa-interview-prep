SELECT DISTINCT
    p1.project_id,
    (
        SELECT ROUND(
            AVG(e.experience_years)::numeric,
            2
        )
        FROM Project p2
        JOIN Employee e
            ON p2.employee_id = e.employee_id
        WHERE p2.project_id = p1.project_id
    ) AS average_years
FROM Project p1;