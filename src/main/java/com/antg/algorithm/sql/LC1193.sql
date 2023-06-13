-- https://leetcode.cn/problems/monthly-transactions-i/
-- 每月交易 I
select left (trans_date, 7) as 'month'
        , country
        , count (1) as trans_count
        , count (if(state ='approved', 1, null)) as approved_count
        , sum (amount) as trans_total_amount
        , sum (if(state ='approved', amount, 0)) approved_total_amount
from Transactions
group by left (trans_date, 7), country