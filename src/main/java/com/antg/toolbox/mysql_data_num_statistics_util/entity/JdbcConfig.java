package com.antg.toolbox.mysql_data_num_statistics_util.entity;

import lombok.Data;

/**
* @author:Antg
* @create: 2023/9/18
* @Description: jdbcconfig 实体类
*/
@Data
public class JdbcConfig {
    String driver; // 驱动
    String url; // url
    String username; // 用户名
    String password; //密码
}
