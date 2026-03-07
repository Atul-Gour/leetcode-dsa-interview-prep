SELECT machine_id,
       ROUND(
            SUM(
                CASE
                    WHEN activity_type = 'start' THEN -timestamp
                    WHEN activity_type = 'end' THEN timestamp
                END
            ) :: numeric / (COUNT(*)/2)
        ,3) AS processing_time
FROM Activity
GROUP BY machine_id
ORDER BY machine_id;