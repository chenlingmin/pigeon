package xyz.yishe.pigeon.common.model.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.yishe.pigeon.common.bean.BaseBean;

import java.util.List;

/**
 * @author owen
 * @date 2018-11-30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class SortReq extends BaseBean {
    @ApiModelProperty(value = "排序条件, 逗号分隔, \"-\"前缀为desc")
    private List<String> sorts;
}
