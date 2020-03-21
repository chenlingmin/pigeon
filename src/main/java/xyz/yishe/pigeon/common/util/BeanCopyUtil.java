package xyz.yishe.pigeon.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * Bean 转换
 * 默认使用名称复制属性
 *
 * @author owen
 * @date 2018-09-10
 */
@Slf4j
public class BeanCopyUtil {
    /**
     * 属性拷贝，全拷贝
     * 属性名称一致的全部拷贝
     *
     * @param original 源对象
     * @param target   目标对象
     * @param <O>
     * @param <T>
     * @return
     */
    public static <O, T> T fullCopy(O original, T target) {
        return copy(original, target, false);
    }

    /**
     * 属性拷贝，忽略源对象属性空值
     *
     * @param original 源对象
     * @param target   目标对象
     * @param <O>
     * @param <T>
     * @return
     */
    public static <O, T> T copyIgnoreNullValue(O original, T target) {
        return copy(original, target, true);
    }

    /**
     * 属性拷贝
     *
     * @param original           源对象
     * @param target             目标对象
     * @param ignoreOriginalNull 是否忽略源对象属性空值（不复制）
     * @param <O>
     * @param <T>
     * @return 目标对象
     */
    private static <O, T> T copy(O original, T target, boolean ignoreOriginalNull) {
        ReflectionUtils.doWithFields(original.getClass(), originalField -> {
                    originalField.setAccessible(true);
                    String oName = originalField.getName(); // 属性名称
                    Object oValue = originalField.get(original);
                    log.debug("Original field name: {} ,value: {}", oName, oValue);

                    // 源对象属性空值
                    if (CommonUtils.isEmpty(oValue)) {
                        if (ignoreOriginalNull) {
                            log.debug("Original field value is null,ignore copy! Field:{}", oName);
                            return;
                        }
                    }

                    // 目标对象属性校验
                    Field targetField = ReflectionUtils.findField(target.getClass(), oName);
                    if (CommonUtils.isNotEmpty(targetField)) {
                        targetField.setAccessible(true);
                        targetField.set(target, oValue); // 设置目标属性值
                    }
                }
        );
        log.debug(String.format("Target Object: %s", target));
        return target;
    }
}



