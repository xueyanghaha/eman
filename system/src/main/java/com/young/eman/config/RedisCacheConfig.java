package com.young.eman.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
@EnableCaching//启用缓存
@EnableConfigurationProperties(RedisProperties.class)
public class RedisCacheConfig extends CachingConfigurerSupport{
	
	@Autowired
    private RedisProperties redisProperties;

	@Bean(name="redisConnectionFactory")
	public JedisConnectionFactory JedisConnectionFactory(){
		
		JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
		
		redisConnectionFactory.setHostName(redisProperties.getHost());
        redisConnectionFactory.setPort(redisProperties.getPort());
        redisConnectionFactory.setPassword(redisProperties.getPassword());
        
		return redisConnectionFactory;
		
	}
	
	@Bean
	public CacheManager cacheManage(RedisTemplate<?,?> redisTemplate){
		
		CacheManager cacheManager = new RedisCacheManager(redisTemplate);
		
		return cacheManager;
		
	}
	
	@Bean
	public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory redisConnectionFactory){
		
		RedisTemplate<String,String> redisTemplate = new RedisTemplate<String,String>();
		
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		
		return redisTemplate;
	}
	
}
