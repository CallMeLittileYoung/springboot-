package com.lyd.jedis.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.lyd.jedis.inter.JedisService;

import redis.clients.jedis.JedisCluster;
	/**
	 * 
	 * @author        Young
	 * @description   Jedis集群版 用于上线时
	 * @date         
	 *
	 */
public class GroupJedis implements JedisService{
	
	@Autowired(required=false)
	private JedisCluster jedisCluster;
	
	@Override
	public String put(String key, String value) {
		return jedisCluster.set(key, value);
	}

	@Override
	public String get(String key) {
		
		return jedisCluster.get(key);
	}

	@Override
	public String putWithLimitTime(String key, String value, int time) {
		
		return jedisCluster.setex(key, time, value);
	}

	@Override
	public Long del(String key) {
		return jedisCluster.del(key);
	}

	@Override
	public Long autoIncr(String key) {
		return jedisCluster.incr(key);
	}

	@Override
	public long expire(String key, int time) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Long del(List<String> keys) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> keysLike(String pattern) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long renameKey(String oldKey, String newKey) {
		// TODO Auto-generated method stub
		return 0L;
	}

	@Override
	public long checkExpireTime(String key) {
		// TODO Auto-generated method stub
		return 0;
	}


}
