package xyz.yishe.pigeon.dao.jpa.entity;

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
 * @author owen
 * @date 2019-08-22 20:09
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "role")
@EntityListeners(AuditingEntityListener.class)
public class RoleEntity extends BaseBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "VARCHAR(64) COMMENT '角色名称'")
    private String roleName;

    @Column(columnDefinition = "DATETIME COMMENT '创建时间'")
    @CreatedDate
    private Date createDate;

    @Column(columnDefinition = "DATETIME COMMENT '更新时间'")
    @LastModifiedDate
    private Date modifyDate;
}
