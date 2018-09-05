package com.young.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;


/**
 * 
 * @author 		  Young
 * @description   WebSocket的配置类
 * @date   		  2018年4月9日 下午2:42:29 
 *
 */
 @Configuration
 //该注解用来使该应用支持更高的 传输协议
 //可以实现 WebSocketMessageBrokerConfigurer 也可以集成下面这个抽象类
 @EnableWebSocketMessageBroker
public class WebSocketConfig  extends AbstractWebSocketMessageBrokerConfigurer{

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		 registry.addEndpoint("/endpointWisely").withSockJS();
		 //注册一个Stomp 协议的endpoint,并指定 SockJS协议。
	}
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
			//配置消息代理(message broker) 
			//广播式应配置一个/topic 消息代理
		  registry.enableSimpleBroker("/topic");
	}
}
