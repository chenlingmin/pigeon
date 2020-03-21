package xyz.yishe.pigeon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionIdResolver;
import org.springframework.session.web.http.HttpSessionIdResolver;

/**
 * Spring Session 配置
 * 1、引入Spring Session后 通过 HttpServletRequest.getSession 获得的session 不是常规的容器session，而是其wrap 类，每次获得的session也不一样，可以通过session.getId()验证
 * 2、通过HttpSessionIdResolver 指定后session id解析器后（默认通过X-Auth-Token)获得的session id一致
 * 3、这里的session全部是由spring session 生成，手动指定x-auth-token传递无效，还是会获取一个新的session id
 *
 * @author owen
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 30 * 24 * 60 * 60)
public class SpringSessionConfiguration {
    public static final String TOKEN_HEADER = "x-auth-token";

    @Bean
    public HttpSessionIdResolver HttpSessionIdResolver() {
        return new HeaderHttpSessionIdResolver(TOKEN_HEADER);
    }
}
