-- 行程和用户
select request_at as 'Day',round(count(if(status = 'cancelled_by_driver' or status = 'cancelled_by_client', id,
                                          null)) / count(id),2) as 'Cancellation Rate'
from (select a.id
           , a.request_at
           , a.status
      from Trips a
               left join Users b on a.client_id = b.users_id -- 补全客户信息
               left join Users c on a.driver_id = c.users_id -- 补全司机信息
      where b.banned <> 'Yes'
        and c.banned <> 'Yes'
        and a.request_at >= '2013-10-01'
        and a.request_at <= '2013-10-03') t
group by request_at
order by request_at