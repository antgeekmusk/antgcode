-- 游戏玩法分析 I
select player_id, min(event_date) as first_login
from Activity
group by player_id