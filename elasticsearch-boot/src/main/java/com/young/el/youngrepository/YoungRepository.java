package com.young.el.youngrepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 
 * @author        Young
 * @description   带有泛型，所以不让Spring去实例化这个接口
 * 				     通过@NoRepositoryBean实现
 * @date          2018年9月5日 下午5:22:57 
 *
 */
@NoRepositoryBean
public interface YoungRepository<T, ID> extends CrudRepository<T, ID>,PagingAndSortingRepository<T, ID>{
}
