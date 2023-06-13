-- 超过经理收入的员工
select a.name as Employee
from (select t1.name
           , t1.salary as a_salary
           , t2.salary as b_salary
      from Employee t1
               left join Employee t2
                         on t1.managerId = t2.id) t
where t.a_salary > t.b_salary

