package xyz.yishe.pigeon.server.response;

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
 * @date 2020-03-21 15:35
 */
@ApiModel("创建用户响应")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserCreateRresponse extends BaseBean {
    @ApiModelProperty("用户编号")
    private String userId;
}
