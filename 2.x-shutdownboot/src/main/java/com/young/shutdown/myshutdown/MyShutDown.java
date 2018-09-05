package com.young.shutdown.myshutdown;

import java.util.Map;

import org.springframework.boot.actuate.context.ShutdownEndpoint;


public class MyShutDown extends ShutdownEndpoint{
	
	@Override
	public Map<String, String> shutdown() {
		
		 Map<String, String> shutdown = super.shutdown();
		 shutdown.put("otherwise", "Bye,Bitch");
		 return shutdown;
	}
}
