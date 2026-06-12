select 
    'Low Salary' as category,
    count(*) filter ( where income < 20000) as accounts_count
from accounts

union all

select 
    'Average Salary' as category,
    count(*) filter ( where income between 20000 and 50000 ) as accounts_count
from accounts

union all

select 
    'High Salary' as category,
    count(*) filter ( where income > 50000 ) as accounts_count
from accounts