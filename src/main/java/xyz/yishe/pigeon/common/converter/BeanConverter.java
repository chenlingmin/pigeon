package xyz.yishe.pigeon.common.converter;

import org.springframework.beans.BeanUtils;

import java.util.function.Supplier;

/**
 * Bean 转换
 * <p>
 * 默认使用名称复制属性
 *
 * @author owen
 * @date 2018-09-10
 */
public interface BeanConverter {
    /**
     * 属性拷贝
     *
     * @param
     * @param <T>
     * @return
     */
    default <T> T convert(Supplier<T> supplier) {
        T t = supplier.get();
        return convert(t);
    }

    /**
     * 属性拷贝
     *
     * @param
     * @param <T>
     * @return
     */
    default <T> T convert(T instance) {
        BeanUtils.copyProperties(this, instance);
        return instance;
    }


    /**
     * this to requiredType object
     *
     * @param requiredType 类型
     * @return requiredType实例
     */
    default <T> T convert(Class<T> requiredType) {
        try {
            T t = requiredType.newInstance();
            BeanUtils.copyProperties(this, t);
            return t;
        } catch (Exception e) {
            return null;
        }
    }
}


