package xyz.yishe.pigeon.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.yishe.pigeon.common.bean.BaseBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @Description
 * @Author aotianpan
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "region")
public class RegionEntity extends BaseBean {

    @Id
    @Column(columnDefinition = "VARCHAR(32) COMMENT '行政代码'")
    private String areaCode;

    @Column(columnDefinition = "INT COMMENT '序号'")
    private Integer no;

    @Column(columnDefinition = "INT COMMENT '父级序号'")
    private Integer parentNo;

    @Column(columnDefinition = "INT COMMENT '层级'")
    private Integer level;

    @Column(columnDefinition = "VARCHAR(32) COMMENT '邮政编码'")
    private String zipCode;

    @Column(columnDefinition = "VARCHAR(32) COMMENT '区号'")
    private String cityCode;

    @Column(columnDefinition = "VARCHAR(64) COMMENT '名称'")
    private String name;

    @Column(columnDefinition = "VARCHAR(64) COMMENT '简称'")
    private String shortName;

    @Column(columnDefinition = "VARCHAR(64) COMMENT '组合名'")
    private String mergerName;

    @Column(columnDefinition = "VARCHAR(64) COMMENT '拼音'")
    private String pinyin;

    @Column(columnDefinition = "DOUBLE COMMENT '经度'")
    private BigDecimal lon;

    @Column(columnDefinition = "DOUBLE COMMENT '维度'")
    private BigDecimal lat;

    @Column(columnDefinition = "VARCHAR(128) COMMENT '全程'")
    private String fullName;

    @Column(columnDefinition = "VARCHAR(32) COMMENT '省'")
    private String provinceName;

    @Column(columnDefinition = "VARCHAR(32) COMMENT '市'")
    private String cityName;

    @Column(columnDefinition = "VARCHAR(32) COMMENT '区'")
    private String countyName;
}
