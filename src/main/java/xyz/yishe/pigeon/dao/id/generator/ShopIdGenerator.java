package xyz.yishe.pigeon.dao.id.generator;


import xyz.yishe.pigeon.dao.id.EnhanceTableGenerator;
import xyz.yishe.pigeon.dao.id.EnhanceTableGeneratorConfig;
import xyz.yishe.pigeon.dao.id.SimpleEnhanceTableGeneratorConfig;

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