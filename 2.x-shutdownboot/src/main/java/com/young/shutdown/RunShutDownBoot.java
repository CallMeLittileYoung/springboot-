package com.young.shutdown;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RunShutDownBoot {
	public static void main(String[] args) {
		SpringApplication.run(RunShutDownBoot.class, args);
	}
}
