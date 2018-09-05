package com.young.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import com.young.websocket.pojo.Message;
import com.young.websocket.service.WebSocketService;
/**
 * 
 * @author 		  Young
 * @description   用来处理页面请求触发推送
 * @date   	      2018年4月9日 下午5:18:04 
 *
 */

@Controller
public class WebSocketController {
	
	
	@Autowired
	private WebSocketService service;
	
	@MessageMapping("/welcome")
	public String send(Message message) throws Exception{
		System.out.println(message);
		service.send();
		
		return "ok";
	}
}
