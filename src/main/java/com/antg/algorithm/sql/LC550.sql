-- 游戏玩法分析 IV
select round(count(distinct b.player_id) / count(distinct a.player_id), 2) as fraction
from Activity a
         left join (select player_id, min(event_date) as first_login
                    from Activity
                    group by player_id) b on a.player_id = b.player_id and datediff(a.event_date, b.first_login) = 1