-- https://leetcode.cn/problems/market-analysis-i/
-- 市场分析 I
select a.user_id as      buyer_id
     , a.join_date       join_date
     , count(b.order_id) orders_in_2019
from Users a
         left join (select * from Orders where left (order_date, 4)='2019') b
                   on a.user_id = b.buyer_id
group by a.user_id, a.join_date