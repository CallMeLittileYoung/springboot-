package com.young.rabbitmq.receviceMessage;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RpcReceive {
	
	@RabbitListener(queues="q_rpc_req")
	@RabbitHandler
	public Object reveive(Object message) {
		
		System.out.println(message);
		
		return "Young";
	}
}
