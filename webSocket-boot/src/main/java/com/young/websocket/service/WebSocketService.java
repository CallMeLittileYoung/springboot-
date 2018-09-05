package com.young.websocket.service;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.young.websocket.pojo.ResponseMessage;

/**
 * 
 * @author		  Young
 * @description   该类用于向浏览器端推送消息
 * @date   		  2018年4月9日 下午5:02:02 
 *
 */
@Service
public class WebSocketService {
	
	
	@Autowired
	private SimpMessagingTemplate template;
	
	
	public void send() throws Exception {
		
		
		for (int i = 0; i <100; i++) {
			
			ResponseMessage responseMessage = new ResponseMessage();
			
			responseMessage.setResponseMessage("Young"+i);
			
			template.convertAndSend("/topic/getResponse", responseMessage);
			
			System.err.println("已发送");
			
			Thread.sleep(10000);
			
		}
		
	}
	public static void main(String[] args) {
		try {
			
			  int a=10/0;
			  
			  System.out.println(a);
			  
		} catch (Exception e) {
			StringWriter sw=new StringWriter();
			e.printStackTrace(new PrintWriter(sw,true));
			String string = sw.getBuffer().toString();
			System.out.println(string);
		}
	}
}
