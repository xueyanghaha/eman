package com.young.eman.redis.service;


public interface RedisTestService {
	
	public Object getStr(String id);
	
	public void saveStr(String key,String value);
}
