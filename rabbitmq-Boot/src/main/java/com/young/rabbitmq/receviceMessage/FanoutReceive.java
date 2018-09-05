package com.young.rabbitmq.receviceMessage;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceive {
	
	@RabbitListener(queues="q_fanout_1")
	public void receive1(Object message) {
		System.err.println("q_fanout_1:"+message);
	}
	
	@RabbitListener(queues="q_fanout_2")
	public void receive2(Object message) {
		System.err.println("q_fanout_2:"+message);
	}
	
	@RabbitListener(queues="q_fanout_3")
	public void receive3(Object message) {
		System.err.println("q_fanout_3:"+message);
	}
}
