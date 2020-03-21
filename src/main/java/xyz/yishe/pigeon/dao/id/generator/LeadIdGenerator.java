package xyz.yishe.pigeon.dao.id.generator;


import xyz.yishe.pigeon.dao.id.EnhanceTableGenerator;
import xyz.yishe.pigeon.dao.id.EnhanceTableGeneratorConfig;
import xyz.yishe.pigeon.dao.id.SimpleEnhanceTableGeneratorConfig;

/**
 * 线索主键
 */
public class LeadIdGenerator extends EnhanceTableGenerator {
    @Override
    public EnhanceTableGeneratorConfig config() {
        return SimpleEnhanceTableGeneratorConfig.builder()
                .prefixSupplier(() -> "L")
                .initValue(1000)
                .length(8)
                .segmentValueSupplier(() -> "LEAD_PK")
                .build();
    }
}