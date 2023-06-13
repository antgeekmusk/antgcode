-- 上升的温度
select id
from (select id
           , recordDate
           , temperature
           , lag(recordDate, 1) over(order by recordDate) as previous_recordDate
          , lag(temperature, 1) over(order by recordDate) as previous_temperature
      from Weather) t
where datediff(recordDate, previous_recordDate) = 1
  and temperature - previous_temperature > 0