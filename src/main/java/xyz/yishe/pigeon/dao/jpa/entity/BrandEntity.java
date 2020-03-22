package xyz.yishe.pigeon.dao.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import xyz.yishe.pigeon.common.bean.BaseBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author aotianpan
 * @date 2020-03-21 10:37 上午
 * 品牌
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "brand")
public class BrandEntity extends BaseBean {
    @Id
    @Column(columnDefinition = "VARCHAR(32) COMMENT '编号'")
    private String id;

    @Column(columnDefinition = "VARCHAR(32) COMMENT '品牌名称'")
    private String name;

    @Column(columnDefinition = "VARCHAR(32) COMMENT '英文名称'")
    private String englishName;

    @Column(columnDefinition = "VARCHAR(32) COMMENT '别名'")
    private String alias;

    @Column(columnDefinition = "VARCHAR(32) COMMENT '拼音'")
    private String pinyin;

    @Column(columnDefinition = "VARCHAR(32) COMMENT '首字拼音'")
    private String pinyinFirstChar;

    @Column(columnDefinition = "INT COMMENT '品牌类型，1主品牌，2主系列，3子系列'")
    private Integer type;

    @Column(columnDefinition = "VARCHAR(256) COMMENT '品牌介绍'")
    private String introduction;

    @Column(columnDefinition = "VARCHAR(64) COMMENT '品牌logo'")
    private String logo;

    @Column(columnDefinition = "INT COMMENT '品牌排序'")
    private Integer sequence;

    @Column(columnDefinition = "VARCHAR(128) COMMENT '品牌url'")
    private String url;

    @Column(columnDefinition = "VARCHAR(32) COMMENT '父品牌编号'")
    private String parentId;

    @Column(columnDefinition = "DATETIME COMMENT '创建时间'")
    @CreatedDate
    private Date createTime;

    @Column(columnDefinition = "INT COMMENT '删除状态'")
    private Integer delFlag;
}
