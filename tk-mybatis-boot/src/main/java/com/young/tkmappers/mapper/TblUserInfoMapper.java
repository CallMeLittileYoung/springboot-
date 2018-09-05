package com.young.tkmappers.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.young.tkmappers.entity.TblUserInfo;
import com.young.tkmappers.mapper.base.YoungBaseMapper;

/**
 * 
 * @author        Young
 * @description   用来操作`tbl_user_info`表
 * @date          2018年9月4日 下午6:22:27 
 *
 */
@Mapper
public interface TblUserInfoMapper extends YoungBaseMapper<TblUserInfo>{
	
}
