package xyz.yishe.pigeon.common.model.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import xyz.yishe.pigeon.common.bean.BaseBean;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author owen
 * @date 2018-11-29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PageResult<E> extends BaseBean {
    /**
     * 是否最后一页
     */
    private boolean last;

    /**
     * 是否第一页
     */
    private boolean first;

    /**
     * 列表项
     */
    private List<E> items;

    /**
     * 总记录数
     */
    private long count;


    /**
     * 查询结果集装饰
     *
     * @param result   结果集
     * @param function 装饰函数
     * @param <T>
     * @param <S>
     * @return
     */
    public static <S, T> PageResult<T> decorate(PageResult<S> result, Function<S, T> function) {
        return PageResult.<T>builder()
                .first(result.isFirst())
                .last(result.isLast())
                .count(result.getCount())
                .items(result.getItems().stream()
                        .map(function)
                        .collect(Collectors.toList())
                )
                .build();
    }
}
