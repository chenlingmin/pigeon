package xyz.yishe.pigeon.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "xyz.yishe.game.dao.jpa.entity")
@MapperScan(value = "xyz.yishe.game.dao.mybatis.mapper")
@EnableJpaRepositories(basePackages = "xyz.yishe.game.dao.jpa.repository")
public class JpaAndMapperConfiguration {
}
