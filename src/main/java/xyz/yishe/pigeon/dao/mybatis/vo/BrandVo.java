package xyz.yishe.pigeon.dao.mybatis.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import xyz.yishe.pigeon.common.bean.BaseBean;

import java.util.Date;

/**
 * 品牌
 *
 * @author aotianpan
 * @date 2020-03-21 5:55 下午
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BrandVo extends BaseBean {
    /**
     * 编号
     */
    private String id;

    /**
     * 品牌名称
     */
    private String name;

    /**
     * 英文名称
     */
    private String englishName;

    /**
     * 别名
     */
    private String alias;

    /**
     * 拼音
     */
    private String pinyin;

    /**
     * 首字拼音
     */
    private String pinyinFirstChar;

    /**
     * 品牌类型，1主品牌，2主系列，3子系列
     */
    private Integer type;

    /**
     * 品牌介绍
     */
    private String introduction;

    /**
     * 品牌logo
     */
    private String logo;

    /**
     * 品牌排序
     */
    private Integer sequence;

    /**
     * 品牌url
     */
    private String url;

    /**
     * 父品牌编号
     */
    private String parentId;

    /**
     * 创建时间
     */
    private Date createTime;
}
