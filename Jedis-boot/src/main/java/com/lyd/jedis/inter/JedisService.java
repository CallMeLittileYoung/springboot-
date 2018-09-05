package com.lyd.jedis.inter;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.exceptions.JedisDataException;

	/**
	 * @author        Young
	 * @description   Redis统一接口,会有两个实现,单机版和集群版
	 * @date          2018年7月9日 下午5:44:39 
	 */
public interface JedisService {
	
	
	/**
	 * 
	 * @param    key
	 * @param    value
	 * @return   返回设置value
	 */
	public String  put(String key,String value);
	
	/**
	 * 
	 * @param      key
	 * @return     取
	 */
	public String  get(String key);
	/**
	 * 
	 * @param      key
	 * @param      value
	 * @param      time   该键值对的生命周期
 	 * @return
	 */
	public String putWithLimitTime(String key,String value,int time);
	
	/**
	 * @desc  	                 删除指定Key 若该Key存在，且被删除了 则返回1 否则返回0
	 * @param 	      key
	 * @return
	 */
	public Long  del(String key);
	/**
	  * @Description:     删除数组中的Key,并返回实际删除的数量  
	  * @param:           key    数 组    
	  * @return:          Long   删除的数量     
	  * @throws
	 */
	public Long del(List<String> keys);
	/**
	 * @desc       将指定key 对应的value(Long) 类型 自增   该方法可用来做进入服务器的请求个数   用来做 秒杀
	 * @param      key
	 * @return     返回增长后的value
	 * 
	 */
	public  Long   autoIncr(String key);
	
	/**
	 * @desc     给指定key 加上过期时间 ，时间一到便会自动删除掉这个key
	 * @param    key
	 * @param    time  单位为 秒
	 * @return   1 设置超时时间成功 0 设置超时时间失败，原因有很多，可以自己看源码注释
	 */
	public long  expire(String key,int time);
	
	/**
	 * 
	  * @Description:     模糊查询所有的Key 
	  *                   eg: * 代表任意个任意字符   ？ 代表任意字符  [a,b]代表a,b两个字符之一   
	  * @param:           类似于正则表达式吧
	  * @return:          Set<String>   返回符合查询规则的Key集合      
	  * @throws
	 */
	public Set<String> keysLike(String pattern);
	
	/**
	 * 
	  * @Description:     将Key重新命名,若newKey 已经存在，则返回0 
	  * @param:           
	  * @return:          1 代表重命名成功,0  代表 newkey已经存在     
	  * @exception:       若oldKey不存在，则会报错
	 */ 
	public long  renameKey(String oldKey,String newKey)throws JedisDataException;
	
	/**
	 * 
	  * @Description:     查看指定Key的超时剩余时间 
	  * @param:           key
	  * @return:          long    剩余超时时间         -1 该key没有绑定超时时间, -2 该key不存在   
	 */
	public long  checkExpireTime(String key);
	
	//public  
}
