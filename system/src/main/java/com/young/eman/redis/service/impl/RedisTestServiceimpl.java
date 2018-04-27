package com.young.eman.redis.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.young.eman.redis.service.RedisTestService;
import com.young.eman.util.RedisUtils;

@Service
public class RedisTestServiceimpl implements RedisTestService{
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Override
	public Object getStr(String key) {
		
		 Object result = null;
	     
		 ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
	     
	     result = operations.get(key);
	     
	     return result;
	}

	@Override
	public void saveStr(String key,String value) {
		
		ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
		
		operations.set(key, value);

	}

}
