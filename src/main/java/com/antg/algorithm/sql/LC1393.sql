-- https://leetcode.cn/problems/capital-gainloss/
-- 股票的资本损益
select stock_name,
       sum(if(operation = 'Buy', -price, price)) as capital_gain_loss
from Stocks
group by stock_name