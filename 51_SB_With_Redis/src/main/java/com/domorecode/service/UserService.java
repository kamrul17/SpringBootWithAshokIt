package com.domorecode.service;

import java.util.Collection;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.domorecode.model.User;

@Service
public class UserService {
	private HashOperations<String, Integer, User> opsForHash = null;

	public UserService(RedisTemplate<String, User> redisTemplate) {
		this.opsForHash = redisTemplate.opsForHash();
	}
	
	public String addUsers(User user) {
		opsForHash.put("USERS", user.getId(), user);
		return "user added successfully";
	}
	
	public User getUser(Integer userId) {
		return opsForHash.get("USERS", userId);
	}
	public Collection<User> getAllUser() {
		Map<Integer, User> entries = opsForHash.entries("USERS");
		return entries.values();
	}
}
