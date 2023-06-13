-- 只出现一次的最大数字
select max(num) as num
from (select num
      from MyNumbers
      group by num
      having count(1) = 1) t