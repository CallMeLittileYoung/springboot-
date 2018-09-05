package com.young.rabbitmq.configuration;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




	/**
	 * 
	 * @author        Young
	 * @description   卧槽感觉配置的有点麻烦啊我去
	 * @date          2018年4月4日 下午4:01:31 
	 *
	 */
@Configuration
public class ConfigHelloWorld {
	
	
	@Bean(value="helloworld")
	public Queue configQueue() {
		//  对列名        是否持久化  唯一    是否自动删除
		return new Queue("q_helloworld", true, false, false);
	}
	
	
	/*public DirectExchange configDirectExchange() {
		return new DirectExchange("helloworld");
	}
	
	public Binding bingExchangeToQueue(@Qualifier("helloworld") Queue queue
			,@Qualifier("helloworld")DirectExchange  exchange) {
		
		return BindingBuilder.bind(queue).to(exchange).with("hello.world");
	}*/
	
	/**
	 * 
	  * @Description:     TODO  
	  * @param:              
	  * @return:          ConnectionFactory      
	  * @throws
	 */
	public CachingConnectionFactory createFactory()   {
		
		CachingConnectionFactory factory=new CachingConnectionFactory();
						  factory.setAddresses("127.0.0.1:5672");
				          factory.setVirtualHost("/");
				          factory.setUsername("young");
				          factory.setPassword("young");
				          return factory;
	}
	
	
	/*@Bean
	@Primary
	public AmqpTemplate createAmqp(@Qualifier CachingConnectionFactory factory) {
		
		AmqpTemplate template=new RabbitTemplate(factory);
		return template;
	}*/
}
