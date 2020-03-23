package xyz.yishe.pigeon.server.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.yishe.pigeon.common.bean.BaseBean;

/**
 * @author panjianguo
 * @date 2019-06-26 2:55 PM
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequest extends BaseBean {
    @ApiModelProperty("品牌编号")
    private String id;

    @ApiModelProperty("品牌名称")
    private String name;

    @ApiModelProperty("英文名称")
    private String englishName;

    @ApiModelProperty("别名")
    private String alias;

    @ApiModelProperty("品牌介绍")
    private String introduction;

    @ApiModelProperty("品牌logo")
    private String logo;

    @ApiModelProperty("品牌次序")
    private Integer index;

    @ApiModelProperty("品牌url")
    private String url;
}
