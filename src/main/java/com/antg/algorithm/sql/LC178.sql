-- 分数排名
-- 开窗
select score, dense_rank() over(order by score desc) as 'rank'
from scores