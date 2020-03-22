package xyz.yishe.pigeon.dao.jpa.id.generator;


import xyz.yishe.pigeon.dao.jpa.id.base.EnhanceTableGenerator;
import xyz.yishe.pigeon.dao.jpa.id.base.EnhanceTableGeneratorConfig;
import xyz.yishe.pigeon.dao.jpa.id.base.SimpleEnhanceTableGeneratorConfig;

/**
 * 店铺主键
 */
public class ShopIdGenerator extends EnhanceTableGenerator {
    @Override
    public EnhanceTableGeneratorConfig config() {
        return SimpleEnhanceTableGeneratorConfig.builder()
                .prefixSupplier(() -> "S")
                .initValue(1000)
                .length(8)
                .segmentValueSupplier(() -> "SHOP_PK")
                .build();
    }
}