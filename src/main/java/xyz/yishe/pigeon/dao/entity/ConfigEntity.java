package xyz.yishe.pigeon.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import xyz.yishe.pigeon.common.bean.BaseBean;

import javax.persistence.*;
import java.util.Date;

/**
 * 系统配置项
 *
 * @author owen
 * @date 2019-08-22 20:09
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "config", indexes = {
        @Index(name = "idx_config_key", columnList = "keyword", unique = true)
})
@EntityListeners(AuditingEntityListener.class)
public class ConfigEntity extends BaseBean {
    @Id
    @Column(length = 32)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(64) COMMENT '关键字'")
    private String keyword;

    @Column(columnDefinition = "INT COMMENT '类型 1：数字 2：字符串 3：日期'")
    private Integer type;

    @Column(columnDefinition = "VARCHAR(256) COMMENT '值'")
    private String value;

    @Column(columnDefinition = "VARCHAR(256) COMMENT '备注'")
    private String remark;

    @Column(columnDefinition = "DATETIME COMMENT '创建时间'")
    @CreatedDate
    private Date createDate;

    @Column(columnDefinition = "DATETIME COMMENT '更新时间'")
    @LastModifiedDate
    private Date modifyDate;
}
