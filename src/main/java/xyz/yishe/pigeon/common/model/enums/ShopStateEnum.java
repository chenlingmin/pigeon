package xyz.yishe.pigeon.common.model.enums;

import lombok.Getter;

import static java.util.Arrays.stream;

/**
 * 店铺状态枚举
 *
 * @author owen
 * @date 2019-06-24 16:29
 */
@Getter
public enum ShopStateEnum {
    PENDING                (1, "待认证"),
    OK                     (2, "通过认证"),
    BAN                    (3, "已禁用"),
    ;

    private final int value;
    private final String name;

    ShopStateEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static ShopStateEnum fromValue(int value) {
        return stream(ShopStateEnum.values())
                .filter(e -> e.getValue() == value)
                .findAny()
                .orElse(null);
    }
}
