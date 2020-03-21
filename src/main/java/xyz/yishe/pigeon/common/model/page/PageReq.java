package xyz.yishe.pigeon.common.model.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class PageReq extends BaseBean {
    @ApiModelProperty(value = "起始页")
    private int startIndex;

    @ApiModelProperty(value = "每页展示记录数")
    private int pageSize;
}
