select w1.id
from Weather w1
left join Weather w2
on w2.recordDate = w1.recordDate - Interval '1 day'
where w1.temperature > w2.temperature 