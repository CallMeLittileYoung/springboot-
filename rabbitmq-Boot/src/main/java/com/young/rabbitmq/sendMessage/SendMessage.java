package com.young.rabbitmq.sendMessage;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author        Young
 * @description   对不同类型交换机的RabbitMQ做统一抽象
 * @date          2018年4月3日 上午10:26:35 
 *
 */
public interface SendMessage {
	
	void  sendMessage(Object message);
	
	void  sendMessageWithFanout(Object message);
	
	void  sendMessageWithTopic(String routingKey,Object message);
	
	List<Map<String, Object>> rpcCall(Object message);
}
