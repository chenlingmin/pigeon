package xyz.yishe.pigeon.common.model.enums;

import lombok.Getter;

import static java.util.Arrays.stream;

/**
 * 用户状态枚举
 *
 * @author owen
 * @date 2019-06-24 16:29
 */
@Getter
public enum UserStateEnum {
    OK                (1, "正常"),
    BAN               (2, "禁用"),
    ;

    private final int value;
    private final String name;

    UserStateEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static UserStateEnum fromValue(int value) {
        return stream(UserStateEnum.values())
                .filter(e -> e.getValue() == value)
                .findAny()
                .orElse(null);
    }
}
