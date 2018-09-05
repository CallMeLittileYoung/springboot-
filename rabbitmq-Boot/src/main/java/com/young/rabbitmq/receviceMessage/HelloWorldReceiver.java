package com.young.rabbitmq.receviceMessage;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 
 * @author        Young
 * @description   HelloWorld案例的接收者
 * @date          2018年4月3日 上午10:58:54 
 *
 */
@Component

public class HelloWorldReceiver {
	
	@RabbitListener(queues= {"q_helloworld"})
	@RabbitHandler
	public void process(Object object) {
		
		System.err.println(object);
		
	}
}
