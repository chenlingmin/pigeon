package xyz.yishe.pigeon.dao.mybatis.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import xyz.yishe.pigeon.common.bean.BaseBean;

import java.math.BigDecimal;

/**
 * 用户信息
 *
 * @author owen 2019-12-24
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserQueryVo extends BaseBean {
    /**
     * 用户编号
     */
    private String id;

    /**
     * 用户姓名
     */
    private String nickname;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 账户余额
     */
    private BigDecimal balance;
}
