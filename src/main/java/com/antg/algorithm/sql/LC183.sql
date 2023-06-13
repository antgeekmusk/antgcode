-- 从不订购的客户
select a.name
from Customers a
         left join Orders b on a.id = b.CustomerId
where b.id is null