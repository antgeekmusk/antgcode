-- 部门工资前三高的所有员工
-- 开窗
select Department
     , Employee
     , Salary
from (select b.name   as  Department
           , a.name   as  Employee
           , a.salary as  Salary
           , dense_rank() over(partition by a.departmentId order by a.salary desc) as rn
      from Employee a
               left join Department b on a.departmentId = b.id) t
where rn <= 3

-- 进阶 行专列 将前三高的员工薪资 放在一行显示,也就是每个部门一行,另外一列是 name1 : salary2,name2 : salary2,...
select Department,
       concat_ws(',', group_concat(info)) as a -- hive 中用collect_list(不去重) 和 collect_set(去重) group_concat 中可以加入 order by
from (select Department
           , concat(Employee, ' : ', Salary) as info
      from (select b.name   as  Department
                 , a.name   as  Employee
                 , a.salary as  Salary
                 , dense_rank() over(partition by a.departmentId order by a.salary desc) as rn
            from Employee a
                     left join Department b on a.departmentId = b.id) t
      where rn <= 3) t
group by Department