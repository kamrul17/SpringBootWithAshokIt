package com.domorecode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.domorecode.model.User;

@Configuration
public class RedisConfig {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory jcf=new JedisConnectionFactory();
//		if redis is using in same device then no need set these below fields
//		jcf.setHostName(null);
//		jcf.setPassword(null);
//		jcf.setPort();
		return jcf;
	}
	
	@Bean
	RedisTemplate<String,User>redisTemplate(){
		RedisTemplate<String,User>redisTemplate=new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}
}
