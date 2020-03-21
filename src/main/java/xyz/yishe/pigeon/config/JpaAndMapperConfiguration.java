package xyz.yishe.pigeon.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "xyz.yishe.pigeon.dao.entity")
@MapperScan(value = "xyz.yishe.pigeon.dao.mybatis.mapper")
@EnableJpaRepositories(basePackages = "xyz.yishe.pigeon.dao.repository")
public class JpaAndMapperConfiguration {
}
