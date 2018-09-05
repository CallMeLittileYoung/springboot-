package com.young.shutdown.task;

import org.springframework.scheduling.annotation.Scheduled;

public class MyTask {

	
	@Scheduled(fixedRate=2000)
	public void test() {
		System.err.println(1);
	}
}
