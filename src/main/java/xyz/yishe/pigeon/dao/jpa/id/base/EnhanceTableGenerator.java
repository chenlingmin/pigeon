package xyz.yishe.pigeon.dao.jpa.id.base;

import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.TableGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.IntegerType;
import org.hibernate.type.Type;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Optional;
import java.util.Properties;

/**
 * 增强 Table 主键生成策略
 */
public abstract class EnhanceTableGenerator extends TableGenerator {

    private static final Integer DEFAULT_INITIAL = 1;
    private static final Integer DEFAULT_LENGTH = 6;
    private static final Type TYPE = new IntegerType();

    private static final String[] ZEROS = new String[]{
            "0",
            "00",
            "000",
            "0000",
            "00000",
            "000000",
            "0000000",
            "00000000",
            "000000000",
            "0000000000",
            "00000000000",
            "000000000000",
            "0000000000000",
            "00000000000000",
            "000000000000000",
    };
    private Properties params;
    private ServiceRegistry serviceRegistry;

    public abstract EnhanceTableGeneratorConfig config();

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        EnhanceTableGeneratorConfig config = config();
        validate(config);

        String segmentValue = config.getSegmentValueSupplier().get();
        if (StringUtils.isEmpty(segmentValue)) {
            throw new RuntimeException("segmentValue is null");
        }

        params.setProperty(INITIAL_PARAM, String.valueOf(Optional.ofNullable(config.getInitValue()).orElse(DEFAULT_INITIAL)));
        params.setProperty(SEGMENT_VALUE_PARAM, segmentValue);
        params.setProperty(TABLE_PARAM, DEF_TABLE);
        super.configure(TYPE, params, serviceRegistry);
        this.params = params;
        this.serviceRegistry = serviceRegistry;
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) {
        configure(TYPE, params, serviceRegistry);
        String generate = fillZero(super.generate(session, obj).toString(),
                Optional.ofNullable(config().getLength()).orElse(DEFAULT_LENGTH));
        return config().getPrefixSupplier().get() + generate;
    }

    /**
     * 校验
     *
     * @param prefixIdConfig
     */
    private void validate(EnhanceTableGeneratorConfig prefixIdConfig) {
        if (null == prefixIdConfig) {
            throw new RuntimeException("EnhanceTableGeneratorConfig is null");
        }
    }

    /**
     * 用零填充
     *
     * @param strBase
     * @param len
     * @return
     */
    private String fillZero(String strBase, int len) {
        if (strBase.length() >= len) {
            return strBase;
        }
        StringBuilder result = new StringBuilder();
        if (len - strBase.length() > ZEROS.length) {
            throw new RuntimeException("");
        }
        result.append(ZEROS[len - strBase.length() - 1]);
        return result + strBase;
    }
}
