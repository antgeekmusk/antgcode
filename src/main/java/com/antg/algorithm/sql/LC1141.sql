-- https://leetcode.cn/problems/user-activity-for-the-past-30-days-i/
-- 查询近30天活跃用户数
select activity_date as day,count(distinct user_id) as active_users
from Activity
where activity_date<='2019-07-27' and datediff('2019-07-27', activity_date) <30
group by activity_date