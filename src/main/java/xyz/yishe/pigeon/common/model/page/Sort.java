package xyz.yishe.pigeon.common.model.page;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import xyz.yishe.pigeon.common.bean.BaseBean;

import java.util.Map;


/**
 * @author owen
 * @date 2018-11-30
 */
@Data
@Builder
@AllArgsConstructor
@ApiModel("排序条件")
public class Sort extends BaseBean {
    // 排序参数
    private Map<String, DirectionEnum> orderBy;

    /**
     * sort
     *
     * @param property
     * @param direction
     * @return
     */
    public void orderBy(String property, DirectionEnum direction) {
        orderBy.put(property, direction);
    }
}
