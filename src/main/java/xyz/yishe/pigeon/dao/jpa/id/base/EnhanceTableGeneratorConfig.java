package xyz.yishe.pigeon.dao.jpa.id.base;

import java.util.function.Supplier;

/**
 * 增强 table 主键生成策略配置
 */
public interface EnhanceTableGeneratorConfig {
    /**
     * 前缀提供者
     * 可以提供动态的前缀
     * 例如: 根据日期 XX20180101
     *
     * @return
     */
    Supplier<String> getPrefixSupplier();

    /**
     * 初始值
     *
     * @return
     */
    Integer getInitValue();

    /**
     * 长度
     *
     * @return
     */
    Integer getLength();

    /**
     * segment 提供器
     * 可以动态提供 segment value
     * 这样就可以支持例如，每天从 0 点开始回归到 1 自增
     *
     * @return
     */
    Supplier<String> getSegmentValueSupplier();
}