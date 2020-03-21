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
 * 店铺
 *
 * @author owen
 * @date 2020-03-21 14:38
 */
@ApiModel("创建店铺请求")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ShopCreateRequest extends BaseBean {
    @ApiModelProperty(value = "店铺名称")
    private String name;

    @ApiModelProperty(value = "市")
    private String icon;

    @ApiModelProperty(value = "联系人")
    private String contact;

    @ApiModelProperty(value = "手机")
    private String phone;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "县、区")
    private String count;

    @ApiModelProperty(value = "详细地址")
    private String address;
}
