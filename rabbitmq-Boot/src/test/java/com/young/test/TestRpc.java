package com.young.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.young.rabbitmq.RunRabbitMQ;
/**
 * 
 * @author 			Young
 * @description     测试Rpc
 * @date   			2018年4月7日 下午11:58:47 
 *
 */
import com.young.rabbitmq.sendMessage.SendMessage;
@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= {RunRabbitMQ.class})
public class TestRpc {
	
	@Autowired
	private SendMessage message;
	
	
	@Test
	public void testRpc() {
		
		Map<String,Object> map =new HashMap<>();
		                   map.put("發送給風控", "Young");
		                   map.put("dateTime", new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format(new Date()));
		  List<Map<String, Object>> rpcCall = message.rpcCall(map);
	     
	     System.err.println(rpcCall);
	   
	}
}
