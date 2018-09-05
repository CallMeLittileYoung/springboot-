package com.young.rabbitmq.sendMessage.impl;


import java.util.List;
import java.util.Map;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.young.rabbitmq.sendMessage.SendMessage;

/**
 * 
 * @author        Young
 * @description   RabbitMQ的工具类实现
 * @date          2018年4月3日 上午10:28:59 
 *
 */
	@Component
public class SednMessageImpl implements SendMessage{
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	//网上那个人有误区
	/*@Value(value="${helloworld.queue.name}")
	private String queueName;*/
	
	@Override
	public void sendMessage(Object message) {
		// routing key
		amqpTemplate.convertAndSend("q_helloworld", message);;
		System.err.println(1);
			
	}

	@Override
	public void sendMessageWithFanout(Object message) {
		amqpTemplate.convertAndSend("e_fanout_exchange", "", message);
		System.err.println(1);
	}

	@Override
	public void sendMessageWithTopic(String routingKey, Object message) {
		amqpTemplate.convertAndSend("e_topic_exchange", routingKey, message);
	}

	@Override
	public List<Map<String, Object>> rpcCall(Object message) {
	
	@SuppressWarnings("unchecked")
	List<Map<String, Object>> receive =  (List<Map<String, Object>>) amqpTemplate.convertSendAndReceive("E_NAP_RISK_EXCHANGE", "R_NAP_RISK_ROUTINGKEY", message,null);
	 
	 return receive;
	}

}
