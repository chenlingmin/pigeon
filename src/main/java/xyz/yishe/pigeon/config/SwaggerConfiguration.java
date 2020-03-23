package xyz.yishe.pigeon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
@EnableConfigurationProperties(SwaggerProperties.class)
public class SwaggerConfiguration {
    private final SwaggerProperties swaggerProperties;

    @Autowired
    public SwaggerConfiguration(SwaggerProperties swaggerProperties) {
        this.swaggerProperties = swaggerProperties;
    }

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("YISHE.XYZ")
                .apiInfo(
                        new ApiInfoBuilder()
                                .title("PIGEON服务端API")
                                .build()
                )
                .enable(swaggerProperties.isEnable())
                .select()
                .paths(or(
                        regex("/shop.*"),
                        regex("/user.*"),
                        regex("/role.*"),
                        regex("/user-role.*"),
                        regex("/lead.*"),
                        regex("/config.*"),
                        regex("/brand.*")
                ))
                .build();
    }
}




