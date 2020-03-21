package xyz.yishe.pigeon.config;

import lombok.RequiredArgsConstructor;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author owen
 * @date 2018-12-28
 */
@Configuration
@RequiredArgsConstructor
public class RedissonConfiguration {
    private final RedisConfig redisConfig;

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient() {
        String ip = redisConfig.getHost();
        String port = redisConfig.getPort();
        String password = redisConfig.getPassword();
        int database = redisConfig.getDatabase();

        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://" + ip + ":" + port) // 地址
                .setPassword(password) // 密码
                .setDatabase(database); // 数据库
        return Redisson.create(config);
    }
}
