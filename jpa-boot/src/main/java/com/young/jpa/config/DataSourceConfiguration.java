package com.young.jpa.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;
	/**
	 * 
	 * @author        Young
	 * @description   配置数据源
	 * @date          2018年7月24日 下午9:19:14 
	 *
	 */
@Configuration
public class DataSourceConfiguration {
	@Bean("dataSource")
	@ConfigurationProperties(prefix="druid")
	@Primary  //这个注解的作用为  让这个数据源作为主数据源
	public DataSource getDataSource() {
		return DataSourceBuilder.create().type(DruidDataSource.class).build();
	}
}
