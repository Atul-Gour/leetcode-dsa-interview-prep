select distinct l1.num as ConsecutiveNums 
from Logs l1
left join Logs l2 on l2.id = l1.id + 1
left join logs l3 on l3.id = l2.id + 1
where 
    l1.id is not null 
    and l2.id is not null 
    and l3.id is not null
    and l2.num = l1.num
    and l3.num = l1.num