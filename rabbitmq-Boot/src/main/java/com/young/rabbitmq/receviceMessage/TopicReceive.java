package com.young.rabbitmq.receviceMessage;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 
 * @author        Young
 * @description   主题模式接收
 * @date          2018年4月7日 下午5:42:29 
 *
 */
@Component
public  class TopicReceive {
	
	@RabbitListener(queues="q_topic_1")
	public void receive1(Object message) {
		System.err.println("q_topic_1:"+message);
	}
	
	@RabbitListener(queues="q_topic_2")
	public void receive2(Object message) {
		System.err.println("q_topic_2:"+message);
	}
	
}
