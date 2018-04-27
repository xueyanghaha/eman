package com.young.eman.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.young.eman.model.User;

public interface UserMapper {
	
	List<User> login(@Param("userName")String userName, @Param("password") String password);
	
	int insert(User user);
}