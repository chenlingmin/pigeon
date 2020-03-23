package xyz.yishe.pigeon.server.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.yishe.pigeon.common.bean.BaseBean;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("区域查询")
public class RegionRequest extends BaseBean {
    @ApiModelProperty("父序号")
    private Integer parentNo;

    @ApiModelProperty("区编号")
    private String areaCode;

    @ApiModelProperty("区域名称")
    private String name;

    @ApiModelProperty("层级")
    private Integer level;
}
