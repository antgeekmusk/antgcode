-- https://leetcode.cn/problems/movie-rating/
-- 电影评分
select min(name) as results
from (select *, rank() over(order by cnt desc) as rn
      from (select b.name
                 , count(movie_id) as cnt
            from MovieRating a
                     left join Users b on a.user_id = b.user_id
            group by b.name) t) t
where rn = 1
union all
select min(title) as results
from (select *, rank() over(order by avg_rating desc) as rn
      from (select b.title, avg(rating) as avg_rating
            from MovieRating a
                     left join Movies b
                               on a.movie_id = b.movie_id
            where left (a.created_at, 7)='2020-02'
            group by b.title) t) t
where rn = 1