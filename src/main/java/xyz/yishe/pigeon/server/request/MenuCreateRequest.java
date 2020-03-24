package xyz.yishe.pigeon.server.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import xyz.yishe.pigeon.common.bean.BaseBean;

/**
 * @author owen
 * @date 2020-03-21 14:38
 */
@ApiModel("创建用户请求")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MenuCreateRequest extends BaseBean {
    @ApiModelProperty("父编号")
    private Integer pid;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("类型 1：菜单 2：功能")
    private Integer type;

    @ApiModelProperty("层级 1：一级菜单 2：二级菜单 3：三级菜单")
    private Integer tier;

    @ApiModelProperty("前端路由")
    private String route;

    @ApiModelProperty("后端路由")
    private String url;
}
