-- 删除重复的电子邮箱
delete
from person
where id not in
      (select id
       from (select min(id) as id
             from person
             group by email) a)
