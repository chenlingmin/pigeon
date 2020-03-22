package xyz.yishe.pigeon.server.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.yishe.pigeon.common.bean.BaseBean;

/**
 * @author aotianpan
 * @date 2020-03-21 5:27 下午
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("品牌查询")
public class BrandQueryRequest extends BaseBean {

    @ApiModelProperty("品牌编号")
    private String id;

    @ApiModelProperty("品牌名称")
    private String name;
}
