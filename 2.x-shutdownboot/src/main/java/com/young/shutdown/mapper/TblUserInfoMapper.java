package com.young.shutdown.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.young.shutdown.entity.TblUserInfo;




/**
 * 
  * @author        Young     
  * @Package 	   com.young.admins.mapper  
  * @Description:  操作 tbl_user_info 表的Mapper接口
  * @date          2018年6月1日 下午3:03:21
 */
@Mapper
public interface TblUserInfoMapper {
	
	/**
	  * @Description: 新增一个用户,选择性增加哦 
	  * @return       int   新生产用户的id   
	 */
	void addOneUserBySelective(TblUserInfo tblUserInfo) throws Exception;
	
	List<TblUserInfo> selectAllTblUserInfo()throws Exception;
	
}
