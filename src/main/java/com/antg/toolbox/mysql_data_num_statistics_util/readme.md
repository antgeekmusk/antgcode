功能点 : 

1.根据指定的时间字段,例如create_time 进行分组统计
例如按天,周,分钟时间维度进行数据量统计,然后将数据插入到一个结果表中
而且,直接进行整库的统计,sql任务自动生成.

配置文件格式
```json
{
    "task_name":""//任务名称
    ,"group_columns_name":["column1","column2","..."] //分组依据的columns_name,可以多个,优先级从左到右,如果第一个没有找到的话就用第二个,第二个没有就第三个
    ,"jdbc_config":{
        "driver":"com.mysql.jdbc.Driver"//驱动名称
        ,"url":""// jdbc url
        ,"username":""//用户名
        ,"password":""//密码
    },
    "table_blacklist" : ""// 表黑名单,这里的表不会进行任何操作
}
```

