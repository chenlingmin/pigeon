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
@ApiModel("用户登录请求")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserLoginRequest extends BaseBean {
    @ApiModelProperty(value = "手机")
    private String phone;

    @ApiModelProperty(value = "验证码")
    private String captch;
}
