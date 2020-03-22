package xyz.yishe.pigeon.dao.jpa.id.generator;


import xyz.yishe.pigeon.dao.jpa.id.base.EnhanceTableGenerator;
import xyz.yishe.pigeon.dao.jpa.id.base.EnhanceTableGeneratorConfig;
import xyz.yishe.pigeon.dao.jpa.id.base.SimpleEnhanceTableGeneratorConfig;

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