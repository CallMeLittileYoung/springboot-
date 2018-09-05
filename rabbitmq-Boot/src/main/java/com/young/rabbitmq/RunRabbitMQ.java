package com.young.rabbitmq;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;

@SpringBootApplication
public class RunRabbitMQ {
	public static void main(String[] args) {
		SpringApplication.run(RunRabbitMQ.class, args);
	}
	
	
	@Bean("dataSource")
	@ConfigurationProperties(prefix="druid")
	@Primary  //这个注解的作用为  让这个数据源作为主数据源
	public DataSource getDataSource() {
		return DataSourceBuilder.create().type(DruidDataSource.class).build();
	}
}
