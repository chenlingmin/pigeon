package xyz.yishe.pigeon.dao.id;

import lombok.Builder;
import lombok.Getter;

import java.util.function.Supplier;

@Builder
public class SimpleEnhanceTableGeneratorConfig implements EnhanceTableGeneratorConfig {
    @Getter
    private Integer initValue;

    @Getter
    private Integer length;

    @Getter
    private Supplier<String> prefixSupplier;

    @Getter
    private Supplier<String> segmentValueSupplier;
}
