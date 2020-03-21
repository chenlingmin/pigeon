package xyz.yishe.pigeon.common.model.enums;

import lombok.Getter;

import static java.util.Arrays.stream;

/**
 * 业务类型枚举
 *
 * @author owen
 * @date 2019-06-24 16:29
 */
@Getter
public enum BusinessTypeEnum {
    RECYCLE                (1, "回收"),
    CONSIGNMENT_SALES      (2, "寄售"),
    SALES                  (3, "销售"),
    CARE                   (4, "护理"),
    TRAINING               (5, "培训"),
    JOIN_IN                (6, "加盟"),

    ;

    private final int value;
    private final String name;

    BusinessTypeEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static BusinessTypeEnum fromValue(int value) {
        return stream(BusinessTypeEnum.values())
                .filter(e -> e.getValue() == value)
                .findAny()
                .orElse(null);
    }
}
