package com.lyd.jedis.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lyd.jedis.RunRedisBoot;
import com.lyd.jedis.inter.JedisService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
	/**
	 * 
	 * @author        Young
	 * @description   很成功，之前是因为  没能将配置文件之间映射到JedisPool中的原因导致不能使用！
	 * @date          2018年7月9日 下午4:14:21 
	 *
	 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= {RunRedisBoot.class})
public class TestStorage {
	
	@Autowired
	private JedisService jedisService;
	
	@Autowired
	private JedisPool jedisPool;
	
	//从当前数据库中  随机拿出一个key
	@Test
	public void testRandomKey() {
		Jedis resource = jedisPool.getResource();
		String randomKey = resource.randomKey();
		System.err.println(randomKey);
	}
	@Test
	public void testGet() {
		System.out.println(jedisPool);
		String string = jedisService.get("NAME");
		System.out.println(string);
	}
	@Test
	public void testPut(){
		for (int i = 65; i < 91; i++) {
			jedisService.put((char)i+"", i+"");
		}
	}
	//为什么要List装数组呢？ 因为数组长度只能是固定的
	@Test
	public void testDel() {
		List<String> keys=new ArrayList<>();
		for (int i = 65; i < 91; i++) {
			keys.add((char)i+"");
		}
		Long del = jedisService.del(keys);
		System.err.println(del);
	}
	@Test
	public void testPut333(){
			/*jedisService.put("young","1");
			jedisService.put("youmg","2");
			jedisService.put("youqg","3");
			jedisService.put("youwg","4");*/
		String putWithLimitTime = jedisService.putWithLimitTime("young1","9", 300);
		System.err.println(putWithLimitTime);
	}
	@Test
	public void testKeysLike() {
		    //[youqg, youwg, youmg, young]  "you*g"
		    //[youqg, youwg, youmg, young]  "you?g"
		    //[youmg, young]                "you[n,m]g"
			Set<String> keysLike = jedisService.keysLike("you[n,m]g");
			System.err.println(keysLike);
	}
	@Test
	public void testRename() {
		    //OK
			long renameKey = jedisService.renameKey("youqg", "youag");
			System.err.println(renameKey);
	}
	@Test
	public void testExpireTime() {
			long checkExpireTime = jedisService.checkExpireTime("young1");
			System.err.println(checkExpireTime);
	}
}
