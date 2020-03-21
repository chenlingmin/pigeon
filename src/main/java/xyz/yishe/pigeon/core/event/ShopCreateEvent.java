package xyz.yishe.pigeon.core.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import xyz.yishe.pigeon.common.bean.BaseBean;

/**
 * @author owen
 * @date 2020-03-21 16:41
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ShopCreateEvent extends BaseBean {
    /**
     * 店铺编号
     */
    private String shopId;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 联系手机
     */
    private String phone;
}
