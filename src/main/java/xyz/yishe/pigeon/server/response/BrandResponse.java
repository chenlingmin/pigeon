package xyz.yishe.pigeon.server.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author aotianpan
 * @date 2020-03-21 5:23 下午
 */
@ApiModel("品牌")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BrandResponse {

    @ApiModelProperty("编号")
    private String id;

    @ApiModelProperty("品牌名称")
    private String name;

    @ApiModelProperty("英文名称")
    private String englishName;

    @ApiModelProperty("别名")
    private String alias;

    @ApiModelProperty("品牌类型，1主品牌，2主系列，3子系列")
    private Integer type;

    @ApiModelProperty("品牌介绍")
    private String introduction;

    @ApiModelProperty("品牌logo")
    private String logo;

    @ApiModelProperty("品牌排序")
    private Integer sequence;

    @ApiModelProperty("品牌url")
    private String url;

    @ApiModelProperty("父品牌编号")
    private String parentId;

    @ApiModelProperty("创建时间")
    private Date createTime;
}
