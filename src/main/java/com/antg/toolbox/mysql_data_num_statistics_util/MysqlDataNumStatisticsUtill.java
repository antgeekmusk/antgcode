package com.antg.toolbox.mysql_data_num_statistics_util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPatch;
import com.antg.toolbox.mysql_data_num_statistics_util.entity.Config;
import com.antg.toolbox.mysql_data_num_statistics_util.entity.JdbcConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
* @author:Antg
* @create: 2023/9/18
* @Description:
 * 统计mysql 行数变化,数据量大小变化的工具
*/
public class MysqlDataNumStatisticsUtill {
    public static void main(String[] args) {
        // 配置文件地址,解析日志
        String configPath="~/tmp/uat_statistics.json";
        Config config = parseConfigToEntity(configPath);

        // 获取数据库连接

        // 根据配置文件生成sql任务

        // 执行任务列表并将结果写入mysql中的一个表

    }

    /**
    * @author:Antg
    * @create: 2023/9/18
    * @Description: 将日志文件解析成实体类
    */
    public static Config parseConfigToEntity(String configPath){
        Config config = null;
        try {
            String content = FileUtil.readString(configPath, CharsetUtil.CHARSET_UTF_8);
            JSONObject jsonObject = JSONObject.parseObject(content);
            config = new Config();

            // 任务名称
            config.setTaskName(jsonObject.getString("task_name"));

            // 分组字段名称
            JSONArray groupColumnsName = jsonObject.getJSONArray("group_columns_name");
            List<String> list = new ArrayList<>();
            groupColumnsName.forEach(e->{
                list.add(e.toString());
            });
            config.setGroupColumnName(list);

            //jdbc 配置
            JSONObject jdbcConfig = jsonObject.getJSONObject("jdbc_config");
            JdbcConfig jc = new JdbcConfig();
            jc.setDriver(jdbcConfig.getString("driver"));
            jc.setUrl(jdbcConfig.getString("url"));
            jc.setUsername(jdbcConfig.getString("username"));
            jc.setPassword(jdbcConfig.getString("password"));
            config.setJdbcConfig(jc);

            // 表黑名单
            JSONArray tableBlacklist = jsonObject.getJSONArray("table_blacklist");
            Set<String> blacklist = new HashSet<>();
            tableBlacklist.forEach(e->{
                blacklist.add(e.toString());
            });
            config.setTableBlacklist(blacklist);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return config;
    }

    /**
    * @author:Antg
    * @create: 2023/9/18
    * @Description: 获取数据库连接
    */
    public static Connection getConnection(Config config){
        Connection connection = null;
        try {
            JdbcConfig jdbcConfig = config.getJdbcConfig();
            Class.forName(jdbcConfig.getDriver());
            connection = DriverManager.getConnection(jdbcConfig.getUrl(), jdbcConfig.getUsername(), jdbcConfig.getPassword());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    /**
    * @author:Antg
    * @create: 2023/9/18
    * @Description: 关闭数据库连接
    */
    public static void closeConnection(){

    }

    /**
    * @author:Antg
    * @create: 2023/9/18
    * @Description: 获取执行的 statement
    */
    public static PreparedStatement getPS(){
        return null;
    }

    /**
    * @author:Antg
    * @create: 2023/9/18
    * @Description: 释放 ps
    */
    public static void closePS(){

    }
}
