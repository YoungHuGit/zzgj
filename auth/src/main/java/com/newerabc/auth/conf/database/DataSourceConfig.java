package com.newerabc.auth.conf.database;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


/**
* @Title DataSourceConfig
* @author  young_____hu
* @create  2020年05月16日
*/
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.druid")
public class DataSourceConfig {
	
	private HashMap<String, HashMap<String, String>> ds = new HashMap<>();
    private HashMap<String, String> generalConfig = new HashMap<>();
    
    public HashMap<String, HashMap<String, String>> getDs() {
		return ds;
	}
	public void setDs(HashMap<String, HashMap<String, String>> ds) {
		this.ds = ds;
	}
	public HashMap<String, String> getGeneralConfig() {
		return generalConfig;
	}
	public void setGeneralConfig(HashMap<String, String> generalConfig) {
		this.generalConfig = generalConfig;
	}

	@Bean(name = "dynamicDataSource")
    public DynamicDataSource dataSource() throws Exception{
		
    	Object defaultDataSource = null;
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        
        for (String name : ds.keySet()) {
            HashMap<String, String> dbConfig = ds.get(name);
			
            dbConfig.putAll(generalConfig);
			DataSource dataSource = DruidDataSourceFactory.createDataSource(dbConfig);

			if (name.equals("default")) {
			    defaultDataSource = dataSource;
			} else {
				targetDataSources.put(name, dataSource);
				DynamicDataSourceContextHolder.dataSourceIds.add(name);
			}
        }
        
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(defaultDataSource);
        return dynamicDataSource;
    }
	
}
