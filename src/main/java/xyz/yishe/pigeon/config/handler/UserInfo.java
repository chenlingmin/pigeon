package xyz.yishe.pigeon.config.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import xyz.yishe.pigeon.common.bean.BaseBean;

/**
 * 用户信息
 *
 * @author owen
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserInfo extends BaseBean {
    /**
     * 用户编号
     */
    private String id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机号
     */
    private String phone;

    /**
     * OPEN ID
     */
    private String openId;

    /**
     * 头像
     */
    private String avatar;
}