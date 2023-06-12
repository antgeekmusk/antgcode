-- 订单最多的客户
-- 求单个订单最多的顾客
select customer_number
from orders
group by customer_number
order by count(1) desc limit 1
-- 求多个顾客并列的情况
select customer_number
from orders
group by customer_number
having count(1) = (select count(1)
                   from orders
                   group by customer_number
                   order by count(1) desc limit 1
    )