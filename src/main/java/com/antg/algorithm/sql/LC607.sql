-- 销售员
select distinct name
from (select a.name, count(if(c.name = 'RED', 1, null)) as n
      from SalesPerson a
               left join Orders b on a.sales_id = b.sales_id
               left join Company c on b.com_id = c.com_id
      group by name) t
where n = 0