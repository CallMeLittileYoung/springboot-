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
 * @author 		  Young
 * @description   配置Rpc
 * @date          2018年6月5日 上午11:26:38 
 *
 */
@Configuration
public class ConfigRpcCall {
	
	@Bean(" Q_NAP_RISK_QUEUE")
	public Queue configRpcQueue() {
		
		
		return new Queue(" Q_NAP_RISK_QUEUE");
		
	}
	
	@Bean("E_NAP_RISK_EXCHANGE")
    public TopicExchange configExchange() {
    	return new TopicExchange("E_NAP_RISK_EXCHANGE");
    }
	
	@Bean
	public Binding bindQueueToTopic1(@Qualifier("Q_NAP_RISK_QUEUE")Queue queue,
			@Qualifier("E_NAP_RISK_EXCHANGE")TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("R_NAP_RISK_ROUTINGKEY");
	}
}
