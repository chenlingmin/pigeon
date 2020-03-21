package xyz.yishe.pigeon.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author owen
 * @date 2018-12-29
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig {
    /**
     * 地址
     */
    private String host;

    /**
     * 端口
     */
    private String port;

    /**
     * 密码
     */
    private String password;

    /**
     * 数据库
     */
    private Integer database;
}
