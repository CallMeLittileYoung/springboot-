package com.young.websocket.pojo;

import java.io.Serializable;
	/**
	 * 
	 * @author        Young
	 * @description   用来封装返回给页面的消息
	 * @date   		  2018年4月9日 下午2:56:46 
	 *
	 */
public class ResponseMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6622261450876626529L;
	
	private String responseMessage;

	public ResponseMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	@Override
	public String toString() {
		return "ResponseMessage [responseMessage=" + responseMessage + "]";
	}
	
	
}
