-- https://leetcode.cn/problems/product-price-at-a-given-date/
-- 指定日期的产品价格
select a.product_id, coalesce(b.price, 10) as price
from (select distinct product_id from Products) a
         left join (select *
                    from (select product_id, new_price as price, row_number() over(partition by product_id order by change_date desc) as rn
                          from Products
                          where change_date <= '2019-08-16') t
                    where rn = 1) b on a.product_id = b.product_id