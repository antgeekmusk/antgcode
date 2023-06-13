-- https://leetcode.cn/problems/queries-quality-and-percentage/
-- 查询结果的质量和占比
select query_name
     , round(sum(rating / position) / count(1), 2)               as quality
     , round(count(if(rating < 3, 1, null)) / count(1) * 100, 2) as poor_query_percentage
from Queries
group by query_name