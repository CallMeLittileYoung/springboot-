package com.young.jpa.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 
 * @author        Young
 * @description   对Jpa做进一步抽象
 * @date          2018年7月24日 下午9:39:12 
 *
 */
//该注解用来避免被Spring加载
//可以使用该注解制造一个组合型的  Repository 接口
@NoRepositoryBean                                                 //该接口用于组合查询
public interface BaseRepository<T> extends JpaRepository<T, Long>,JpaSpecificationExecutor<T> {
	
}
