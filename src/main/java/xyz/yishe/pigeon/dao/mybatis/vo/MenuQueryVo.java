package xyz.yishe.pigeon.dao.mybatis.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import xyz.yishe.pigeon.common.bean.BaseBean;

import java.util.Date;

/**
 *
 * @author owen
 * @date 2020-03-21 5:55 下午
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MenuQueryVo extends BaseBean {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 父编号
     */
    private Integer pid;

    /**
     * 类型 1：菜单 2：功能
     */
    private Integer type;

    /**
     * 层级 1：一级菜单 2：二级菜单 3：三级菜单
     */
    private Integer tier;

    /**
     * 前端路由
     */
    private String route;

    /**
     * 后端路由
     */
    private String url;
}
