package com.antg.toolbox.mysql_data_num_statistics_util.entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Set;

/**
* @author:Antg
* @create: 2023/9/18
* @Description: 配置文件实体类
*/
@Data
@ToString
public class Config {
    String taskName; // 任务名称
    List<String> groupColumnName; //分组依据的columns_name,可以多个,优先级从左到右,如果第一个没有找到的话就用第二个,第二个没有就第三个

    JdbcConfig jdbcConfig; // jdbc config

    Set<String> tableBlacklist; // 表黑名单,这里的表不会进行任何操作
}
