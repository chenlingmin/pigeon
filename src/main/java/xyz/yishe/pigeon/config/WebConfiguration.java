package xyz.yishe.pigeon.config;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xyz.yishe.pigeon.config.handler.SessionTimeoutCheckInterceptor;

/**
 * WebConfiguration
 */
@Configuration
@RequiredArgsConstructor
public class WebConfiguration implements WebMvcConfigurer {
    // 业务路径
    private static final String[] businessExcludes = {
            "/",
            "/error/**",
            "/user/create",                            // 创建用户（临时）
            "/user/quick-login",                       // 快速登录，用open-id登录
            "/user/web-login",                         // 网页登录，用open-id登录
            "/user/wechat-login"                       // 微信登录

    };

    // Swagger路径
    private static final String[] swaggerExcludes = {
            "/swagger-ui.html",
            "/configuration/**",
            "/swagger-resources",
            "/v2/api-docs",
            "/webjars/springfox-swagger-ui/**",
            "/swagger-resources/**",
            "/csrf/**"
    };

    private final SessionTimeoutCheckInterceptor sessionTimeoutInterceptor;

    /**
     * 拦截器配置
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] excludes = ArrayUtils.addAll(swaggerExcludes, businessExcludes);
        registry.addInterceptor(sessionTimeoutInterceptor).excludePathPatterns(excludes);
    }

//    /**
//     * 跨域配置
//     *
//     * @param registry
//     */
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*")
//                .allowedMethods("*")
//                .allowedHeaders("*")
//                .maxAge(3600)
//                .exposedHeaders("x-auth-token")
//                .allowCredentials(true);
//    }
}
