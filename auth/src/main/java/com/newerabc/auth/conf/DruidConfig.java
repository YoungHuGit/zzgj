package com.newerabc.auth.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.sql.SQLException;

@Configuration
public class DruidConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.druid.ds.default")//在application.properties中读取配置信息注入到DruidDataSource里
    public DruidDataSource filterRegistrationBean() {
        DruidDataSource druidDataSource =  DataSourceBuilder.create().type(DruidDataSource.class).build();
        druidDataSource.setInitialSize(3);//初始化物理连接的数量
        try {
            druidDataSource.addFilters("stat,wall");//stat是sql监控，wall是防火墙(如果不添加则监控无效)，不能添加log4j不然会出错
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return druidDataSource;
    }

}
