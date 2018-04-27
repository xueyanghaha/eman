package com.young.eman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.young.eman.mapper.UserMapper;
import com.young.eman.model.User;
import com.young.eman.service.LoginService;
import com.young.eman.util.RedisUtils;
@Service
public class LoginServiceimpl implements LoginService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User login(String loginName, String password) {
		List<User> userL = userMapper.login(loginName, password);
		return userL.get(0);
	}
	
}
