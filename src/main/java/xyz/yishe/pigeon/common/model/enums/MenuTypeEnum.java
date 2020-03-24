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
public enum MenuTypeEnum {
    MENU                (1, "菜单"),
    FUNCTION            (2, "功能"),

    ;

    private final int value;
    private final String name;

    MenuTypeEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static MenuTypeEnum fromValue(int value) {
        return stream(MenuTypeEnum.values())
                .filter(e -> e.getValue() == value)
                .findAny()
                .orElse(null);
    }
}
