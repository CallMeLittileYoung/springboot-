package com.lyd.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyd.boot.mapper.UserMapper;
import com.lyd.boot.pojo.User;
import com.lyd.boot.service.UserService;
	@Service("userService")
	@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	@Override
	public List<User> queryAllUsers() {
		return  userMapper.queryAllUsers();
	}

}
