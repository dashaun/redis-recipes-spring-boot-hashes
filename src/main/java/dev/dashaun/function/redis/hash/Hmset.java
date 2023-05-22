package dev.dashaun.function.redis.hash;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Function;

@Component
public class Hmset implements Function<Map<?, ?>, String> {

	private final RedisTemplate redisTemplate;

	public Hmset(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public String apply(Map<?, ?> input) {
		redisTemplate.opsForHash().putAll(input.get("key"), (Map<?, ?>) input.get("f"));
		return "OK";
	}

}
