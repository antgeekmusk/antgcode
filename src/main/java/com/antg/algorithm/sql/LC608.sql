-- 树节点
select a.id
     , case
           when a.p_id is null then 'Root'
           when b.p_id is not null then 'Inner'
           else 'Leaf'
    end as type
from tree a
         left join (select distinct p_id from tree) b on a.id = b.p_id