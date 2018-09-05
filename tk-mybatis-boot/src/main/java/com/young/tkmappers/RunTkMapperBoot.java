package com.young.tkmappers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author        Young
 * @description   学习TkMappers
 * @date          2018年9月3日 上午12:58:39 
 *
 */
@SpringBootApplication
@EnableTransactionManagement
public class RunTkMapperBoot {
	public static void main(String[] args) {
		SpringApplication.run(RunTkMapperBoot.class, args);
	}
}
