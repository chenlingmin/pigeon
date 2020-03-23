package xyz.yishe.pigeon.dao.mybatis.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 区域查询
 * @author aotianpan
 * @date 2020-03-22 5:53 下午
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegionQueryBo {
    /**
     * 父序号
     */
    private Integer parentNo;

    /**
     * 区编号
     */
    private String areaCode;

    /**
     * 区域名称
     */
    private String name;

    /**
     * 层级
     */
    private Integer level;
}
