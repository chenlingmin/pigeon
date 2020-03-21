package xyz.yishe.pigeon.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * 开启JPA审计功能
 * @CreatedBy @CreatedBy
 * @LastModifiedDate @LastModifiedBy
 * 配合@EntityListeners(AuditingEntityListener.class)
 *
 * @author owen
 * @date 2018-12-24
 */
@EnableJpaAuditing
@Configuration
public class JpaAuditingConfiguration {
}
