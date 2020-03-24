package xyz.yishe.pigeon.server.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import xyz.yishe.pigeon.common.bean.BaseBean;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author aotianpan
 * @date 2020-03-21 5:23 下午
 */
@ApiModel("查询菜单响应")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MenuQueryResponse extends BaseBean {
    @ApiModelProperty("编号")
    private Integer id;

    @ApiModelProperty("父编号")
    private Integer pid;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("层级 1：一级菜单 2：二级菜单 3：三级菜单")
    private Integer tier;

    @ApiModelProperty("前端路由")
    private String route;

    @ApiModelProperty("后端路由")
    private String url;
}
