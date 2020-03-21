package xyz.yishe.pigeon.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import xyz.yishe.pigeon.common.bean.BaseBean;

import javax.persistence.*;
import java.util.Date;

/**
 * @author owen
 * @date 2019-08-22 20:09
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class UserEntity extends BaseBean {
    @Id
    @Column(length = 32)
    @GeneratedValue(generator = "UserIdGenerator")
    @GenericGenerator(
            name = "UserIdGenerator",
            strategy = "xyz.yishe.pigeon.dao.id.generator.UserIdGenerator"
    )
    private String id;

    @Column(columnDefinition = "VARCHAR(32) COMMENT '店铺编号'")
    private String shopId;

    @Column(columnDefinition = "VARCHAR(32) COMMENT '手机号'")
    private String phone;

    @Column(columnDefinition = "VARCHAR(64) COMMENT '密码'")
    private String password;

    @Column(columnDefinition = "VARCHAR(64) COMMENT '盐'")
    private String salt;

    @Column(columnDefinition = "VARCHAR(64) COMMENT '昵称'")
    private String nickname;

    @Column(columnDefinition = "VARCHAR(256) COMMENT '微信头像'")
    private String avatar;

    @Column(columnDefinition = "VARCHAR(128) COMMENT '微信OPEN ID'")
    private String openId;

    @Column(columnDefinition = "INT COMMENT '状态 1：正常 2：禁用'")
    private Integer state;

    @Column(columnDefinition = "DATETIME COMMENT '创建时间'")
    @CreatedDate
    private Date createDate;

    @Column(columnDefinition = "DATETIME COMMENT '更新时间'")
    @LastModifiedDate
    private Date modifyDate;
}
