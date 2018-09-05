package com.young.admins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class RunAdminsServerBoot {
	public static void main(String[] args) {
		SpringApplication.run(RunAdminsServerBoot.class, args);
	}
}
