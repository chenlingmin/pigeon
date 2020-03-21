package xyz.yishe.pigeon.common.model.enums;

import lombok.Getter;

import java.util.Arrays;

/**
 * 是否枚举
 */
@Getter
public enum YesNoEnum {
    NO     (1,"否"),
    YES    (2,"是"),
    ;

    private final Integer value;
    private final String name;

    YesNoEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public static YesNoEnum fromValue(int value) {
        return Arrays.stream(YesNoEnum.values())
                .filter(e -> e.getValue() == value)
                .findAny()
                .orElse(null);
    }
}
