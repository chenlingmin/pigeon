package xyz.yishe.pigeon.common.model.page;

import java.lang.annotation.*;

/**
 * 自定义注解标注分页排序类型
 *
 * @author owen
 * @date 2018-12-01
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface PageOrderProperty {
}
