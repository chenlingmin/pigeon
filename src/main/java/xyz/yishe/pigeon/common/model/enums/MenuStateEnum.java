package xyz.yishe.pigeon.common.model.enums;

import lombok.Getter;

import static java.util.Arrays.stream;

/**
 * 菜单类型枚举
 *
 * @author owen
 * @date 2019-06-24 16:29
 */
@Getter
public enum MenuStateEnum {
    MENU                (1, "启用"),
    FUNCTION            (2, "禁用"),

    ;

    private final int value;
    private final String name;

    MenuStateEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static MenuStateEnum fromValue(int value) {
        return stream(MenuStateEnum.values())
                .filter(e -> e.getValue() == value)
                .findAny()
                .orElse(null);
    }
}
