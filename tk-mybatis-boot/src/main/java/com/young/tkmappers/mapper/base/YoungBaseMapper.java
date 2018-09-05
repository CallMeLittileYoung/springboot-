package com.young.tkmappers.mapper.base;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface YoungBaseMapper<T> extends Mapper<T> ,IdsMapper<T>,MySqlMapper<T>{
	
}	
