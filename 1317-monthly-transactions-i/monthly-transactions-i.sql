SELECT 
    month,
    t.country,
    COUNT(*) AS trans_count,
    COUNT(*) FILTER (WHERE t.state = 'approved') AS approved_count,
    SUM(t.amount) AS trans_total_amount,
    COALESCE(SUM(t.amount) FILTER (WHERE t.state = 'approved'),0) AS approved_total_amount
FROM (
    SELECT 
        TO_CHAR(trans_date,'YYYY-MM') AS month,
        country,
        state,
        amount
    FROM Transactions
) t
GROUP BY month, t.country;