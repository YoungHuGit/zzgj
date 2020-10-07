package com.newerabc.zzgj_analyse.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DruidConfig {

    /*@Bean
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
    }*/

}
