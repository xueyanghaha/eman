package com.young.eman.service;

import com.young.eman.model.User;

public interface LoginService {
	
	public User login(String loginName,String password);
	
}
