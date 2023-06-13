-- 至少有5名直接下属的经理
select name
from Employee
where id in (select managerId
             from Employee
             group by managerId
             having count(1) >= 5)