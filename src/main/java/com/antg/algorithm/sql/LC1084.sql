-- https://leetcode.cn/problems/sales-analysis-iii/
-- 销售分析III
select a.product_id,
       b.product_name
from (select distinct product_id
      from Sales
      where product_id not in
            (select distinct product_id
             from Sales
             where sale_date < '2019-01-01'
                or sale_date > '2019-03-31')) a
         left join Product b
                   on a.product_id = b.product_id