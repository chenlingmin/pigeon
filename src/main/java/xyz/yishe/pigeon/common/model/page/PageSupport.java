package xyz.yishe.pigeon.common.model.page;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import xyz.yishe.pigeon.common.util.CommonUtils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 功能详细描述
 *
 * @author owen
 * @version 2018-10-01-13:56
 */
@Slf4j
public class PageSupport {
    // DESC 排序前缀
    private static final String DESC_PREFIX = "-";

    /**
     * 配置分页信息
     *
     * @param pageQuery 分页查询表单
     * @param pageReq   分页信息
     */
    public static void init(PageQuery pageQuery, PageReq pageReq) {
        init(pageQuery, pageReq, null);
    }


    /**
     * 配置分页、排序信息
     *
     * @param pageQuery 分页查询表单
     * @param pageReq   分页信息
     * @param sortReq   排序信息
     */
    public static <T> PageQuery<T> init(PageQuery<T> pageQuery, PageReq pageReq, SortReq sortReq) {
        // 分页
        if (CommonUtils.isNotEmpty(pageReq)) {
            pageQuery.setPage(
                    Page.builder()
                            .startIndex(pageReq.getStartIndex())
                            .pageSize(pageReq.getPageSize())
                            .build()
            );
        }

        // 排序
        if (CommonUtils.isNotEmpty(sortReq) && CommonUtils.isNotEmpty(sortReq.getSorts())) {
            List<String> sorts = sortReq.getSorts();
            // 分页业务参数
            Class pageQueryBizClazz = pageQuery.getConditions().getClass();

            // 获取所有申明类型
            Class[] declaredClasses = pageQueryBizClazz.getDeclaredClasses();

            // 分页排序枚举类型
            Class pageSortEnumClazz = Arrays.stream(declaredClasses)
                    .filter(Class::isEnum) // 枚举
                    .filter(c -> CommonUtils.isNotEmpty(c.getDeclaredAnnotation(PageOrderProperty.class))) // 精准定位
                    .findFirst().orElse(null);
            if (CommonUtils.isNotEmpty(pageSortEnumClazz)) {
                // 构建
                Sort sort = Sort.builder()
                        .orderBy(new HashMap<>())
                        .build();

                for (String sortColumn : sorts) {
                    DirectionEnum direct = DirectionEnum.ASC; // 排序方式，默认升序
                    sortColumn = sortColumn.trim();
                    if (sortColumn.startsWith(DESC_PREFIX)) {
                        sortColumn = sortColumn.substring(1);
                        direct = DirectionEnum.DESC; // 降序
                    }

                    // 过滤
                    String sortProperty = filter(pageSortEnumClazz, sortColumn);
                    if (CommonUtils.isNotEmpty(sortProperty)) {
                        sort.orderBy(sortProperty, direct);
                    }
                }

                pageQuery.setSort(sort);
            }
        }
        return pageQuery;
    }


    /**
     * 分页结果集转换
     *
     * @param pageInfo
     * @param <T>
     * @return
     */
    public static <T> PageResult<T> convert(PageInfo<T> pageInfo) {
        return PageResult.<T>builder()
                .first(pageInfo.isIsFirstPage())
                .last(pageInfo.isIsLastPage())
                .count(pageInfo.getTotal())
                .items(pageInfo.getList())
                .build();
    }


    /**
     * 排序过滤
     */
    private static String filter(Class pageSortEnumClazz, String sortColumn) {
        try {
            Class<Enum> pageSortEnumClass = (Class<Enum>) Class.forName(pageSortEnumClazz.getName());
            Enum[] enumConstants = pageSortEnumClass.getEnumConstants(); // 枚举常量

            Method getDesc = pageSortEnumClass.getMethod("getDesc");
            return Arrays.stream(enumConstants)
                    .filter(e -> e.name().equals(sortColumn))
                    .map(e -> {
                        try {
                            return getDesc.invoke(e).toString(); // 调用枚举类的getDesc方法
                        } catch (Exception ex) {
                            // ignore
                        }
                        return null;
                    })
                    .filter(CommonUtils::isNotEmpty)
                    .findFirst().orElse(null);


        } catch (Exception e) {
            log.warn("排序参数过滤出错！PageSortEnumClass: {}, sortColumn: {}", pageSortEnumClazz, sortColumn);
            return null;
        }
    }
}
