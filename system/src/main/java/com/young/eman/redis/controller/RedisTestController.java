package com.young.eman.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.young.eman.redis.service.RedisTestService;

@RestController
@RequestMapping("/redisTest")
public class RedisTestController {
	
	 @Autowired
	 private RedisTestService redisTestService;
	 
	 @RequestMapping("/getValue")
	 public void getRedisValue(String key){
		 String value = redisTestService.getStr(key)+"";
		 System.out.println("获得redis中数据，数据为"+value);
	 }
	 
	 @RequestMapping("saveValue")
	 public void saveValue(String key,String value){
		 redisTestService.saveStr(key,value);
	 }
}
