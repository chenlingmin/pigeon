package xyz.yishe.pigeon.server.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import xyz.yishe.pigeon.common.bean.BaseBean;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@ApiModel("行政区域响应")
public class RegionResponse extends BaseBean {
    @ApiModelProperty(value = "序号")
    private Integer no;

    @ApiModelProperty(value = "父级序号")
    private Integer parentNo;

    @ApiModelProperty(value = "行政代码")
    private String areaCode;

    @ApiModelProperty(value = "邮政编码")
    private String zipCode;

    @ApiModelProperty(value = "区号")
    private String cityCode;

    @ApiModelProperty(value = "层级")
    private Integer level;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "简称")
    private String shortName;

    @ApiModelProperty(value = "拼音")
    private String pinyin;

    @ApiModelProperty(value = "经度")
    private BigDecimal lon;

    @ApiModelProperty(value = "维度")
    private BigDecimal lat;

    @ApiModelProperty(value = "行政区域集合")
    private List<RegionResponse> regionList;
}
