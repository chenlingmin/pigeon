package xyz.yishe.pigeon.config;

import io.swagger.models.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.Paths;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;
import static xyz.yishe.pigeon.config.SpringSessionConfiguration.TOKEN_HEADER;

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
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        List<Parameter> parameterList = new ArrayList<>();
        parameterBuilder.name(TOKEN_HEADER)
                .description("token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        parameterList.add(parameterBuilder.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("YISHE.XYZ")
                .apiInfo(apiInfo())
                .enable(swaggerProperties.isEnable())
                .select()
                .paths(
                        or(
                        regex("/shop.*"),
                        regex("/user.*"),
                        regex("/role.*"),
                        regex("/user-role.*"),
                        regex("/lead.*"),
                        regex("/config.*"),
                        regex("/brand.*"),
                        regex("/region.*")
                ))
                .build()
//                .ignoredParameterTypes(new Class[]{IdentityUser.class})
                .globalOperationParameters(parameterList);
    }

    /**
     * API INFO
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("PIGEON")
                .description("PIGEON API Documentation")
                .contact(new Contact("葛坤进",
                        "http://www.yishe.xyz",
                        "i-owen@live.cn")) // required springfox 2.4.0 begin
                .version("1.0")
                .termsOfServiceUrl("urn:tos")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
}




