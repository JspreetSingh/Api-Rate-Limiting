package com.example.API.Rate.Limiting.ratelimit;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RateLimitService {

    private final StringRedisTemplate redisTemplate;

    private static final int MAX_TOKENS = 5;
    private static final int WINDOW_SECONDS = 60;

    public RateLimitService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public boolean isAllowed(String userId, String path) {

        String key = "rate:user1";
        Long count = redisTemplate.opsForValue().increment(key);

        Long ttl = redisTemplate.getExpire(key);

        System.out.println(
                "KEY=" + key + " COUNT=" + count + " TTL=" + ttl
        );

        if (count == 1) {
            redisTemplate.expire(key, WINDOW_SECONDS, TimeUnit.SECONDS);
        }

        return count <= MAX_TOKENS;
    }

}
