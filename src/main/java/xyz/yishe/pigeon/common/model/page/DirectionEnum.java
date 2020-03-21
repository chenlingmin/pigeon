package xyz.yishe.pigeon.common.model.page;

import lombok.Getter;

/**
 * 排序方向
 *
 * @author owen
 * @date 2018-11-30
 */
@Getter
public enum DirectionEnum {
    ASC         ("asc"),
    DESC        ("desc"),
    ;

    @Getter
    private String direction;

    DirectionEnum(String direction) {
        this.direction = direction;
    }
}
