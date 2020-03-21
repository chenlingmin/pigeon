package xyz.yishe.pigeon.config;

import org.redisson.api.RedissonClient;
import org.redisson.spring.cache.CacheConfig;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@EnableCaching
@Configuration
public class CacheConfiguration {
    // 默认缓存名称
    public final String DEFAULT_CERES_CACHE_NAME = "BIZ_CACHE";

    @Bean
    public CacheManager cacheManager(RedissonClient redissonClient) {
        Map<String, CacheConfig> cacheCollections = new HashMap<>();

        // 创建缓存,ttl:24h,maxIdleTime:12h
        cacheCollections.put(DEFAULT_CERES_CACHE_NAME,
                new CacheConfig(24 * 60 * 60 * 1000, 12 * 60 * 60 * 1000));

        return new RedissonSpringCacheManager(redissonClient, cacheCollections);
    }
}
