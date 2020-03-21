package xyz.yishe.pigeon.common.model.enums;

import lombok.Getter;

import static java.util.Arrays.stream;
import static xyz.yishe.pigeon.common.model.enums.ConfigTypeEnum.TYPE_NUMBER;
import static xyz.yishe.pigeon.common.model.enums.ConfigTypeEnum.TYPE_STRING;

/**
 * 配置项枚举
 *
 * @author owen
 * @date 2019-06-24 16:29
 */
@Getter
public enum ConfigEnum {
    // 计划生命周期
    // 开始1 -------------------> 冻结2-------> 结束3
    // |----------------------------------------|     // 计划持续时长
    // |--------------------------|                   // 计划竞猜时长
    //                            |-------------|     // 计划冻结时长

    PLAN_DURATION_TIME          ("config_plan_duration", TYPE_NUMBER, "计划持续时长（分钟）"),
    PLAN_FREEZE_TIME            ("config_plan_freeze", TYPE_NUMBER, "计划冻结时长（秒）"),
    PLAN_SERVICE_FEE_RATE       ("config_plan_service_fee_rate", TYPE_NUMBER, "手续费（限定1-100）"),

//    public static int nextInt(int startInclusive, int endExclusive) {
    RANDOM_START_INCLUSIVE      ("config_start_inclusive",TYPE_NUMBER,"分蘖随机数-开始（含）"),
    RANDOM_END_EXCLUSIVE        ("config_end_exclusive",TYPE_NUMBER,"分裂随机数-结束（不包含)"),

    USER_REGISTER_INIT_BALANCE  ("config_user_register_init_balance", TYPE_NUMBER,"客户注册默认奖励金币"),

    SYSTEM_DEFAULT_USER_ID      ("config_system_default_user_id", TYPE_STRING, "系统手续费默认账户编号")
    ;

    /**
     * 关键字
     */
    private final String key;

    /**
     * @see ConfigTypeEnum
     */
    private final ConfigTypeEnum type;

    /**
     * 描述
     */
    private final String desc;

    ConfigEnum(String key, ConfigTypeEnum type, String desc) {
        this.key = key;
        this.type = type;
        this.desc = desc;
    }

    public static ConfigEnum fromValue(String key) {
        return stream(ConfigEnum.values())
                .filter(config -> config.getKey().equals(key))
                .findAny()
                .orElse(null);
    }
}
