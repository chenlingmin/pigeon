package xyz.yishe.pigeon.dao.jpa.id.generator;


import xyz.yishe.pigeon.dao.jpa.id.EnhanceTableGenerator;
import xyz.yishe.pigeon.dao.jpa.id.EnhanceTableGeneratorConfig;
import xyz.yishe.pigeon.dao.jpa.id.SimpleEnhanceTableGeneratorConfig;

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