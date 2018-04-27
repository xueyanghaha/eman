package com.young.eman.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;

public class RedisUtils {
	
	@Autowired
	private static RedisTemplate<String, Object> redisTemplate;

	private static ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
	private static ListOperations<String, Object> listOperations = redisTemplate.opsForList();
	private static HashOperations<String, Serializable, Object> hashOperations = redisTemplate.opsForHash();
	private static SetOperations<String, Object> setOperations = redisTemplate.opsForSet();
	private static ZSetOperations<String, Object> zSetOperations = redisTemplate.opsForZSet();
	
	/**
	 * 永久的保存数据（没有时效）
	 * @param key
	 * @param value
	 */
	public static void setValue(String key,String value){
		
		try{
			valueOperations.set(key, value);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 保存数据并且设置时效
	 * @param key
	 * @param value
	 * @param time
	 * @param unit
	 */
	public static void setValueHaveTime(String key,String value,long time,TimeUnit unit){
		
		try{
			valueOperations.set(key, value,time,unit);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 将多组键值对存入redis
	 * @param map
	 */
	public static void multiSet(Map<String,Object> map){
		try{
			valueOperations.multiSet(map);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 对多组键值进行判断key是否已经存在，不存在存入并返回true
	 * @param key
	 * @param value
	 * @return
	 */
	public static boolean multiKeyIfAbsent(Map<String,Object> map){
		
		return valueOperations.multiSetIfAbsent(map);
		
	}
	
	/**
	 * 通过多个key的List集合来获取其对应的值
	 * @param keys
	 * @return
	 */
	public static List<Object> multiGet(List<String> keys){
		
		List<Object> oList = new ArrayList<Object>();
		
		try{
			oList = valueOperations.multiGet(keys);
		}catch(Exception e){
			e.printStackTrace();
		}
		return oList;
	}
	
	/**
	 * 对key中的value进行拼接
	 * @param key
	 * @param value
	 * @return
	 */
	public static Integer append(String key,String value){
		
		return valueOperations.append(key,value);
		
	}
	
	
}
