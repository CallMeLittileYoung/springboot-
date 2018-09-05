package com.lyd.jedis.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lyd.jedis.inter.BaseFunctionOfSingleRedis;
import com.lyd.jedis.inter.JedisService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

	/**
	 * 
	 * @author        Young
	 * @description   有人可能会有疑问，为什么不在这个类上面加上 @Component注解呢 
	 * 				      因为开发时使用单机版,上线时使用集群版，所以必须做到可拔插  
	 * 				      所以必须使单机版和集群版使用同一个接口，再spring的配置文件中进行 选择启用那个版本，通过配置bean实现
	 * @date         
	 *
	 */
@Component
public class SingleJedis implements JedisService{
	
	@Autowired(required=true)
	private JedisPool jedisPool;
	
	/**
	 * 
	 * @param      base
	 * @return     该方法用于配合BaseFunctionOfSingleRedis  对单机版通用接口实现做抽取
	 */
	public  <M> M execute(BaseFunctionOfSingleRedis<Jedis,M> base) {
			Jedis jedis=jedisPool.getResource();
			try {
				return base.callBack(jedis);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				if(jedis!=null) {
				   jedis.close();
				}
			}
				return null;
	}
	@Override
	public String put(String key, String value) {
		
		return execute(new BaseFunctionOfSingleRedis<Jedis,String>() {

			@Override
			public String callBack(Jedis jedis) {
					return jedis.set(key, value);
			}
			
		});
	}
	@Override
	public String get(String key) {
		
		return execute(new BaseFunctionOfSingleRedis<Jedis, String>() {

			@Override
			public String callBack(Jedis jedis) {
				return jedis.get(key);
			}
		});
	}
	@Override
	public String putWithLimitTime(String key, String value, int time) {
			
		return execute(new BaseFunctionOfSingleRedis<Jedis, String>() {

			@Override
			public String callBack(Jedis jedis) {
				return	jedis.setex(key, time, value);
			}
		});
		
	}
	@Override
	public Long del(String key) {
		return execute(new BaseFunctionOfSingleRedis<Jedis, Long>() {

			@Override
			public Long callBack(Jedis jedis) {
				return jedis.del(key);
			}
		});
	}
	/**
	 * 这个redis 自增太强了
	 */
	@Override
	public Long autoIncr(String key) {
		return execute(new BaseFunctionOfSingleRedis<Jedis, Long>() {

			@Override
			public Long callBack(Jedis jedis) {
				return jedis.incr(key);
			}
		});
	}
	@Override
	public long expire(String key, int time) {
		return  execute(new BaseFunctionOfSingleRedis<Jedis, Long>() {

			@Override
			public Long callBack(Jedis jedis) {
				return jedis.expire(key, time);
			}
			
		});
	}
	@Override
	public Long del(List<String> keys) {
		return execute(new BaseFunctionOfSingleRedis<Jedis,Long>() {

			@Override
			public Long callBack(Jedis jedis) {
				if(keys==null||keys.size()==0) {
					return 0L;
				}
				String [] arr=new String[keys.size()];
				keys.toArray(arr);
				return jedis.del(arr);
			}
		});
	}
	@Override
	public Set<String> keysLike(String pattern) {
		return execute(new BaseFunctionOfSingleRedis<Jedis, Set<String>>() {
			@Override
			public Set<String> callBack(Jedis jedis) {
				
				return jedis.keys(pattern);
			}
		});
	}
	@Override
	public long renameKey(String oldKey, String newKey) {
		return execute(new BaseFunctionOfSingleRedis<Jedis, Long>() {

			@Override
			public Long callBack(Jedis jedis) {
				
				return jedis.renamenx(oldKey, newKey);
			}
		});
	}
	@Override
	public long checkExpireTime(String key) {
		return execute(new BaseFunctionOfSingleRedis<Jedis, Long>() {
			@Override
			public Long callBack(Jedis jedis) {
				return jedis.ttl(key);
			}
		});
	}
		
	
	
}
