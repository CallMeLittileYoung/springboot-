package com.lyd.jedis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
	/**
	 * 
	 * @author        Young
	 * @description   ConfigurationProperties 并没有将配置文件直接映射到属性上
	 * @date          2018年7月9日 下午4:11:15 
	 *
	 */
@Configuration
public class JedisConfig {
	@Value("${redis.host}")
	private String host;
	@Value("${redis.port}")
	private int port;
	@Bean
	//@ConfigurationProperties(prefix="redis")
	@Primary
	public JedisPool configJedisPool() {
		System.err.println(host+"---"+port);
		JedisPool pool=new JedisPool("192.168.12.133",6379);
		return pool;
	}
	
	/*@Bean
	@ConfigurationProperties(prefix="redis")*/
	public JedisCluster configGruopJedis() {
		return null;
	}
}
