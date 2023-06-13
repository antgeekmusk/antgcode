-- https://leetcode.cn/problems/customers-who-bought-all-products/
-- 买下所有产品的客户

select count(1)
from Product;

select customer_id
from (select if(count(distinct c.product_key) = product_num, customer_id, null) as customer_id
      from Customer as c,
           (select count(1) as product_num
            from Product) as pm
      group by c.customer_id) t
where customer_id is not null