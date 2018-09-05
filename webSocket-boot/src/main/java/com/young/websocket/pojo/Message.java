package com.young.websocket.pojo;

import java.io.Serializable;
	/**
	 * 
	 * @author 		  Young
	 * @description   用于封装页面提交的消息
	 * @date          2018年4月9日 下午2:55:45 
	 *
	 */
public class Message implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1162514822443483247L;
	
	private String name;

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Message [name=" + name + "]";
	}
	
}
