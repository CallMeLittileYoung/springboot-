package com.lyd.jedis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
	 * 
	 * @author        Young
	 * @description   Jedis启动类
	 * @date          2018年6月29日 下午3:56:05 
	 *
	 */
	@SpringBootApplication
public class RunRedisBoot {
	public static void main(String[] args) {
		SpringApplication.run(RunRedisBoot.class, args);
	}
}
