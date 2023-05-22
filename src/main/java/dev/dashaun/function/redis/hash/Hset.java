package dev.dashaun.function.redis.hash;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Function;

@Component
public class Hset implements Function<Map<String, String>, String> {

	private final RedisTemplate redisTemplate;

	public Hset(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public String apply(Map<String, String> input) {
		redisTemplate.opsForHash().put(input.get("k"), input.get("f"), input.get("v"));
		return "OK";
	}

}
