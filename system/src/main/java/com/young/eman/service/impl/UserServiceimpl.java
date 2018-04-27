package com.young.eman.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.young.eman.mapper.UserMapper;
import com.young.eman.model.User;
import com.young.eman.service.UserService;

@Service
public class UserServiceimpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	@Override
	public void saveOrUpdate(User user) {
		userMapper.insert(user);
	}

}
