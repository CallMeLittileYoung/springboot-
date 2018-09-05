package com.young.rabbitmq.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author        Young
 * @description   fanout模式的配置,订阅模式下，所有消费者都会接收到生产者发出的消息
 * @date   		  2018年4月7日 下午4:57:01 
 *
 */
@Configuration
public class ConfigFanout {
	
	@Bean("fanout_queue_1")
	public Queue configQueue1() {
		
		return new Queue("q_fanout_1");
	}
	
	@Bean("fanout_queue_2")
	public Queue configQueue2() {
		
		return new Queue("q_fanout_2");
	}
	
	@Bean("fanout_queue_3")
	public Queue configQueue3() {
		
		return new Queue("q_fanout_3");
	}
	@Bean("e_fanout_exchange")
	public FanoutExchange configFanoutExchange() {
		
		return new FanoutExchange("e_fanout_exchange");
		
	}
	//进行绑定
	@Bean
	public Binding bingQueueToFanouut1(@Qualifier("fanout_queue_1")Queue queue,
			@Qualifier("e_fanout_exchange")FanoutExchange exchange) {
		
		return BindingBuilder.bind(queue).to(exchange);
	}
	@Bean
	public Binding bingQueueToFanouut2(@Qualifier("fanout_queue_2")Queue queue,
			@Qualifier("e_fanout_exchange")FanoutExchange exchange) {
		
		return BindingBuilder.bind(queue).to(exchange);
	}
	@Bean
	public Binding bingQueueToFanouut3(@Qualifier("fanout_queue_3")Queue queue,
			@Qualifier("e_fanout_exchange")FanoutExchange exchange) {
		
		return BindingBuilder.bind(queue).to(exchange);
	}
}
