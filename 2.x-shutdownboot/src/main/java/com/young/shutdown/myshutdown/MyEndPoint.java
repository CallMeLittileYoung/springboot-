package com.young.shutdown.myshutdown;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.stereotype.Component;

@WebEndpoint(id = "young")
@Component
public class MyEndPoint {
	
	@ReadOperation
	public Map<String,Object> getMy(){
		Map<String,Object> map=new HashMap<>();
						   map.put("young", "young");
						   return map;
	}
}
