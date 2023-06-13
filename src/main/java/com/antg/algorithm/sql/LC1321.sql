-- https://leetcode.cn/problems/restaurant-growth/
-- 餐馆营业额变化增长
select visited_on,
       amount,
       average_amount
from (select visited_on
           , sum(amount)  over(order by visited_on range between interval 6 day preceding and current row) as amount
,round(avg(amount) over(order by visited_on range between interval 6 day preceding and current row), 2) as average_amount
           , row_number() over(order by visited_on) as rn
      from (select visited_on, min_date, amount
            from (select visited_on, min_date, sum(amount) as amount
                  from Customer a,
                       (select min(visited_on) as min_date from Customer) b
                  group by visited_on, min_date) t) t) t
where rn > 6