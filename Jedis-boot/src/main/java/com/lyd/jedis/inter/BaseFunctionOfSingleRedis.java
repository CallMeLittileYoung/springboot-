package com.lyd.jedis.inter;

/**
 * 
 * @author        Young
 * @description   这个接口是为了能够为单机版Redis实现类 提供统一的 抽取 ,模仿了 动态代理，BeanHandler方法
 * @date          2018年1月20日 下午4:21:10 
 *
 */
public interface BaseFunctionOfSingleRedis<T,M> {
	
	M callBack(T jedis);
}
