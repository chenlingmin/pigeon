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
@Table(name = "menu")
@EntityListeners(AuditingEntityListener.class)
public class MenuEntity extends BaseBean {
    @Id
    private Integer id;

    @Column(columnDefinition = "INT COMMENT '父编号'")
    private Integer pid;

    @Column(columnDefinition = "VARCHAR(64) COMMENT '名称'")
    private String name;

    /**
     * @see xyz.yishe.pigeon.common.model.enums.MenuTypeEnum
     */
    @Column(columnDefinition = "INT COMMENT '类型 1：菜单 2：功能'")
    private Integer type;

    @Column(columnDefinition = "INT COMMENT '层级 1：一级菜单 2：二级菜单 3：三级菜单'")
    private Integer tier;

    @Column(columnDefinition = "VARCHAR(256) COMMENT '前端路由'")
    private String route;

    @Column(columnDefinition = "VARCHAR(256) COMMENT '后端路由'")
    private String url;

    /**
     * @see xyz.yishe.pigeon.common.model.enums.MenuStateEnum
     */
    @Column(columnDefinition = "INT COMMENT '状态 1：启用 2：禁用'")
    private Integer state;

    @Column(columnDefinition = "DATETIME COMMENT '创建时间'")
    @CreatedDate
    private Date createDate;

    @Column(columnDefinition = "DATETIME COMMENT '更新时间'")
    @LastModifiedDate
    private Date modifyDate;
}
