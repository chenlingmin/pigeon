package xyz.yishe.pigeon.dao.mybatis.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import xyz.yishe.pigeon.common.bean.BaseBean;

/**
 * @author owen
 * @date 2020-03-22 8:04 上午
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MenuQueryBo extends BaseBean {
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
}
