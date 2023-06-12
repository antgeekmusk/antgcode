-- 第n高薪水

-- 解法一 : 开窗
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
RETURN (select salary
        from (select salary, dense_rank() over(order by salary desc) as drn
              from Employee) t
        where drn = n limit 1
    );
END

-- 解法二 : limit n,1 写法
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    SET
N := N-1; -- 因为 limit 后面只接受正整数,也就是表达式和0负数等都不可以
RETURN (
        # Write your MySQL query statement below.
      SELECT
            salary
      FROM
            employee
      GROUP BY
            salary
      ORDER BY
            salary DESC
      LIMIT N, 1
    );
END

-- 解法三 : 子查询
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
RETURN (SELECT DISTINCT e.salary
        FROM employee e
        WHERE (SELECT count(DISTINCT salary) FROM employee WHERE salary > e.salary) = N - 1);
END
