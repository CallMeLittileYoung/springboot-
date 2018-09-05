package com.lyd.boot.config;

import java.util.Collection;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.ibatis.binding.MapperRegistry;
import org.springframework.stereotype.Component;

@Component
public class TotalMapperUtil {
	
	//@Autowired
	private MapperRegistry mapperRegistry;
	
	private Map<String,Class<?>> innerMap;
	
	@PostConstruct
	public void  init() {
		/*Collection<Class<?>> mappers = mapperRegistry.getMappers();
		for (Class<?> clz : mappers) {
		}*/
	}
}
