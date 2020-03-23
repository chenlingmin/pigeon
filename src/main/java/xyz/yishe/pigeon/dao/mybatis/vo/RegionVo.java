package xyz.yishe.pigeon.dao.mybatis.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.yishe.pigeon.common.bean.BaseBean;

import java.math.BigDecimal;

/**
 * 地址信息
 *
 * @author aotianpan
 * @date 2020-03-22 5:50 下午
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegionVo extends BaseBean {
    /**
     * 行政代码
     */
    private String areaCode;

    /**
     * 序号
     */
    private Integer no;

    /**
     * 父级序号
     */
    private Integer parentNo;

    /**
     * 层级
     */
    private Integer level;

    /**
     * 邮政编码
     */
    private String zipCode;

    /**
     * 区号
     */
    private String cityCode;

    /**
     * 名称
     */
    private String name;

    /**
     * 简称
     */
    private String shortName;

    /**
     * 组合名
     */
    private String mergerName;

    /**
     * 拼音
     */
    private String pinyin;

    /**
     * 经度
     */
    private BigDecimal lon;

    /**
     * 维度
     */
    private BigDecimal lat;

    /**
     * 全程
     */
    private String fullName;

    /**
     * 省
     */
    private String provinceName;

    /**
     * 市
     */
    private String cityName;

    /**
     * 区
     */
    private String countyName;
}
