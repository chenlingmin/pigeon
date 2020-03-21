package xyz.yishe.pigeon.common.model.enums;

import lombok.Getter;

import static java.util.Arrays.stream;

/**
 * 类型枚举
 *
 * @author owen
 * @date 2019-06-24 16:29
 */
@Getter
public enum ConfigTypeEnum {
    TYPE_NUMBER     (1, "数字"),
    TYPE_STRING     (2, "字符串"),
    TYPE_DATE       (3, "日期"),
    ;

    private final int value;
    private final String name;

    ConfigTypeEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static ConfigTypeEnum fromValue(int value) {
        return stream(ConfigTypeEnum.values())
                .filter(e -> e.getValue() == value)
                .findAny()
                .orElse(null);
    }
}
