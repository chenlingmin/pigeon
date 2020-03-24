package xyz.yishe.pigeon.dao.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
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
@Table(name = "role_menu")
@EntityListeners(AuditingEntityListener.class)
public class RoleMenuEntity extends BaseBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "INT COMMENT '角色编号'")
    private Integer roleId;

    @Column(columnDefinition = "INT COMMENT '菜单编号'")
    private Integer menuId;

    @Column(columnDefinition = "DATETIME COMMENT '创建时间'")
    @CreatedDate
    private Date createDate;
}
