SELECT round((
    COUNT(*) FILTER (WHERE order_date = customer_pref_delivery_date) * 100.0 /
    COUNT(*)
),2) AS immediate_percentage
FROM (
    SELECT 
        d.customer_id,
        MIN(d.order_date) AS order_date,
        (
            SELECT dd.customer_pref_delivery_date
            FROM Delivery dd
            WHERE dd.customer_id = d.customer_id 
            AND dd.order_date = MIN(d.order_date)
        ) AS customer_pref_delivery_date
    FROM Delivery d
    GROUP BY d.customer_id
) t;