-- https://leetcode.cn/problems/students-and-examinations/
-- 学生们参加各科测试的次数
select a.student_id
     , a.student_name
     , b.subject_name
     , count(if(student_id is null, null, 1)) as attended_exams
from Students a
         join Subjects b on 1 = 1
         left join Examinations c
                   on a.student_id = c.student_id and b.subject_name = c.subject_name
group by a.student_id
       , a.student_name
       , b.subject_name
order by a.student_id, b.subject_name