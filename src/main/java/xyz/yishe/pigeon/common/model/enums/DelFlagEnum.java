package xyz.yishe.pigeon.common.model.enums;

import lombok.Getter;

import java.util.Arrays;

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

    // 编号
    private final int value;

    // 名称
    private final String name;

    DelFlagEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static DelFlagEnum fromValue(Integer value) {
        return Arrays.stream(DelFlagEnum.values())
                .filter(e -> e.getValue() == value)
                .findAny()
                .orElse(null);
    }
}
