package xyz.yishe.pigeon.common.model.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.yishe.pigeon.common.bean.BaseBean;

/**
 * @author owen
 * @date 2018-11-29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageQuery<T> extends BaseBean {
    /**
     * 分页信息
     */
    private Page page;

    /**
     * 排序信息
     */
    private Sort sort;

    /**
     * 业务查询条件
     */
    private T conditions;
}
