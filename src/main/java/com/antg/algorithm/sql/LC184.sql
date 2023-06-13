-- 部门工资最高的员工

-- 开窗
select Department
     , Employee
     , Salary
from (select b.name   as Department
           , a.name   as Employee
           , a.salary as Salary
           , rank()      over(partition by a.departmentId order by a.salary desc) as rn
      from Employee a
               left join Department b on a.departmentId = b.id) t
where rn = 1