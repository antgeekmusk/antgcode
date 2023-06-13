-- https://leetcode.cn/problems/top-travellers/
-- 排名靠前的旅行者
select name, travelled_distance
from (select a.id
           , a.name
           , coalesce(sum(b.distance), 0) as travelled_distance
      from Users a
               left join Rides b
                         on a.id = b.user_id
      group by a.id
      order by travelled_distance desc, a.name asc) t