package xyz.yishe.pigeon.common.model.enums;

import lombok.Getter;

import static java.util.Arrays.stream;

/**
 * 删除标示
 *
 * @author owen
 * @date 2019-06-24 16:29
 */
@Getter
public enum DelFlagEnum {
    UN_DEL     (1, "正常"),
    DEL        (2, "删除"),
    ;

    private final int value;
    private final String name;

    DelFlagEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static DelFlagEnum fromValue(int value) {
        return stream(DelFlagEnum.values())
                .filter(e -> e.getValue() == value)
                .findAny()
                .orElse(null);
    }
}
