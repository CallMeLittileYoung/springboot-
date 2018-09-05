package com.young.test;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.young.rabbitmq.RunRabbitMQ;
import com.young.rabbitmq.sendMessage.SendMessage;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= {RunRabbitMQ.class})
public class TestHelloWorld {
	
	@Resource(name="helloworld")
	private Queue queue;
	
	
	@Test
	public void testQueue() {
		System.err.println(queue);
	}
	
	
	public static void main(String[] args) {
		String s="HelloWorld";
		System.err.println(Boolean.parseBoolean(s));
	}
	
	@Autowired
	private SendMessage message;
	
	
	@Test
	public void sendMessage() throws InterruptedException {
		
		
		Map<String,String> map=new HashMap<>();
		for (int i = 0; i <10; i++) {
			map.put(i+"", i+"");
			message.sendMessage(map);
		}
		Thread.sleep(20000);
	}
	/**
	 * 
	  * @Description:     测试fanout 
	  * @param:              
	  * @return:          void      
	  * @throws
	 */
	@Test
	public void sendMessWithFanout() throws InterruptedException {
		
		
		Map<String,String> map=new HashMap<>();
		for (int i = 0; i <3; i++) {
			map.put(i+"", i+"");
			message.sendMessageWithFanout(map);
		}
		Thread.sleep(20000);
	}
	@Test
	public void sendMessWithTopic() throws InterruptedException {
		Map<String,String> map=new HashMap<>();
		String routingKey;
		for (int i = 0; i <5; i++) {
			
			map.put(i+"", i+"");
			
			if(i%2==0) {
				routingKey="topic.message";
			}else {
				routingKey="topic.young";
			}
			  message.sendMessageWithTopic(routingKey, map);
		}
		Thread.sleep(20000);
	}
	@Autowired
	private ConnectionFactory connectionFactory;
	
	@Test
	public void testFactory() {
		System.err.println(connectionFactory);
	}
}
