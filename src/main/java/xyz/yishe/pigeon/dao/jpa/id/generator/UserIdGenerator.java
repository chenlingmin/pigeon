package xyz.yishe.pigeon.dao.jpa.id.generator;


import xyz.yishe.pigeon.dao.jpa.id.base.EnhanceTableGenerator;
import xyz.yishe.pigeon.dao.jpa.id.base.EnhanceTableGeneratorConfig;
import xyz.yishe.pigeon.dao.jpa.id.base.SimpleEnhanceTableGeneratorConfig;

/**
 * 用户主键
 */
public class UserIdGenerator extends EnhanceTableGenerator {
    @Override
    public EnhanceTableGeneratorConfig config() {
        return SimpleEnhanceTableGeneratorConfig.builder()
                .prefixSupplier(() -> "U")
                .initValue(1000)
                .length(8)
                .segmentValueSupplier(() -> "USER_PK")
                .build();
    }
}