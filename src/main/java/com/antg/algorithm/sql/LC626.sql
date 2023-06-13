-- 换座位
-- 写法一 case when
select case
           when mod(id, 2)!=0 and counts!=id then id+1
    when mod(id,2)!=0 and counts=id then id
    else id-1
end
as id,
student
from
seat,(select count(1) as counts from seat) as seat_conunts
order by id asc;

-- 写法二 位运算+ COALESCE
select s1.id
     , coalesce(s2.student, s1.student) as student
from seat as s1
         left join seat as s2
                   on (s1.id + 1)^1-1=s2.id
order by s1.id;