package xyz.yishe.pigeon.common.model.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.yishe.pigeon.common.bean.BaseBean;

/**
 * @author owen
 * @date 2018-11-30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Page extends BaseBean {
    /**
     * 起始页
     */
    private int startIndex;

    /**
     * 每页展示记录数
     */
    private int pageSize;
}
