package com.young.rabbitmq.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author        Young
 * @description   配置topic模式
 * @date          2018年4月7日 下午5:30:38 
 *
 */
	@Configuration
public class ConfigTopic {
	
	@Bean("q_topic_1")
	public Queue configQueue1() {
		return new Queue("q_topic_1");
	}
	
	@Bean("q_topic_2")
	public Queue configQueue2() {
		return new Queue("q_topic_2");
	}
	
	@Bean("e_topic_exchange")
	public TopicExchange configExchange() {
		return new TopicExchange("e_topic_exchange");
	}
	
	@Bean
	public Binding bindQueueToTopic1(@Qualifier("q_topic_1")Queue queue,
			@Qualifier("e_topic_exchange")TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("topic.message");
	}
	
	@Bean
	public Binding bindQueueToTopic2(@Qualifier("q_topic_2")Queue queue,
			@Qualifier("e_topic_exchange")TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("topic.#");
	}
}
