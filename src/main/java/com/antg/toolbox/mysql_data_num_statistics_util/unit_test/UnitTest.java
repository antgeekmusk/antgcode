package com.antg.toolbox.mysql_data_num_statistics_util.unit_test;

import com.antg.toolbox.mysql_data_num_statistics_util.MysqlDataNumStatisticsUtill;
import com.antg.toolbox.mysql_data_num_statistics_util.entity.Config;
import org.junit.Test;

/**
* @author:Antg
* @create: 2023/9/18
* @Description: 单元测试
*/
public class UnitTest {


    @Test
    public void parseConfigToEntity(){
        String configPath="~/tmp/uat_statistics.json";
        Config config = MysqlDataNumStatisticsUtill.parseConfigToEntity(configPath);
        System.out.println(config.toString());

    }
}
