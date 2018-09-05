package com.lyd.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lyd.boot.annot.Table;
import com.lyd.boot.pojo.User;

@Mapper
@Table(tableName="tb_user")
public interface UserMapper {
	
	List<User> queryAllUsers();
}
