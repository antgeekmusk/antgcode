-- 连续出现的数字,连续出现3次
-- 使用lead lag
select distinct b as ConsecutiveNums
from (select lead(num, 1) over(order by id) as a -- num的后一个值
    ,num as b
           , lag(num, 1)  over(order by id) as c -- num的前一个值
      from logs) t
where t.a = t.b
  and t.b = t.c

-- 单独使用lead 和 lag 也可以,原理同上

-- 使用row_number
select distinct num as ConsecutiveNums
from (select num
           , row_number() over(order by id) as rn
,row_number() over(partition by num order by id) as id_rn
      from logs) t
group by num, (t.rn - t.id_rn)
having count(1) >= 3
