package xyz.yishe.pigeon.dao.id.generator;


import xyz.yishe.pigeon.dao.id.EnhanceTableGenerator;
import xyz.yishe.pigeon.dao.id.EnhanceTableGeneratorConfig;
import xyz.yishe.pigeon.dao.id.SimpleEnhanceTableGeneratorConfig;

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