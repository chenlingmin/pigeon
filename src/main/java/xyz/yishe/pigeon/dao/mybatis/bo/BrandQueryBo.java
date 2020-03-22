package xyz.yishe.pigeon.dao.mybatis.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import xyz.yishe.pigeon.common.bean.BaseBean;

/**
 * 品牌查询
 * @author aotianpan
 * @date 2020-03-22 8:04 上午
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BrandQueryBo extends BaseBean {
    /**
     * 品牌编号
     */
    private String id;

    /**
     * 品牌名称
     */
    private String name;
}
