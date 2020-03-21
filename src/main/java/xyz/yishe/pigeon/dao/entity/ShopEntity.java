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
@Table(name = "shop")
@EntityListeners(AuditingEntityListener.class)
public class ShopEntity extends BaseBean {
    @Id
    @Column(length = 32)
    @GeneratedValue(generator = "shopIdGenerator")
    @GenericGenerator(
            name = "shopIdGenerator",
            strategy = "xyz.yishe.pigeon.dao.jpa.id.generator.ShopIdGenerator"
    )
    private String id;

    @Column(columnDefinition = "VARCHAR(128) COMMENT '店铺名称'")
    private String name;

    @Column(columnDefinition = "VARCHAR(256) COMMENT '店铺图标'")
    private String icon;

    @Column(columnDefinition = "VARCHAR(64) COMMENT '联系人'")
    private String contact;

    @Column(columnDefinition = "VARCHAR(16) COMMENT '联系号码'")
    private String mobile;

    @Column(columnDefinition = "VARCHAR(64) COMMENT '省'")
    private String province;

    @Column(columnDefinition = "VARCHAR(64) COMMENT '市'")
    private String city;

    @Column(columnDefinition = "VARCHAR(64) COMMENT '区'")
    private String county;

    @Column(columnDefinition = "VARCHAR(256) COMMENT '详细地址'")
    private String address;

    @Column(columnDefinition = "INT COMMENT '状态 1：待认证 2：已认证 3：已禁用'")
    private Integer state;

    @Column(columnDefinition = "DATETIME COMMENT '创建时间'")
    @CreatedDate
    private Date createDate;

    @Column(columnDefinition = "DATETIME COMMENT '更新时间'")
    @LastModifiedDate
    private Date modifyDate;
}
